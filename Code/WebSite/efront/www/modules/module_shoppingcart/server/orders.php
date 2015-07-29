<?php

error_reporting(E_ALL);
ini_set('display_errors',1);

/*
 * orders.php
 *
 * This class contains methods that reload the interface which displays orders,
 * and methods to approve or decline orders.
 * Methods that are concerned to saving new orders are located
 * on checkouthandler.php
 *
 */


require_once((dirname(__FILE__)).'/db/db.php');

require_once('packages.php');
require_once('transactions.php');
require_once('mailing.php');


if (isset($_POST['action'])) {
	$action = $_POST['action'];
} else {
	$action = "";
}


if (isset($_POST['email'])) {
	$email = $_POST['email'];
} else {
	$email = "";
}


//Reload orders of an specific user depending on who is logged in
if ($action == "reloadOrders") {

	//echo '<script type="text/javascript">alert("In reloadOrders")</script>';

	if (isset($_POST['userid'])) {
		$userid = $_POST['userid'];
	} else {
		$userid = "";
	}
	$userdata = db_getUserById($userid);
	$timeZoneId = "";
	$user = "";
	foreach ($userdata as $u){
		$user = $u['id'];
		$timeZoneId = 'GMT-05:00 US/Eastern';//jh getting user info from quota system which does not have timezoneid
	}
	$orders = db_getOrdersByUser($user);
	date_default_timezone_set($timeZoneId);

	$formattedOrders= array();

			foreach ($orders as $order) {

			$purchaseDate = date(DATE_ATOM, ($order['purchasedate']/1000));
					
			$o = array($order['id'],
			$order['ordernumber'],
			$userid,
			$purchaseDate,
			$order['lastmodification'] ,
			$order['fulfillmentorderstate'],
			$order['financialorderstate'] ,
			$order['total']
			);

			array_push($formattedOrders, $o);
		}

		
    echo json_encode($formattedOrders);

	//Reload all orders of all users. Only used for administartor view
} else if ($action == "reloadOrdersAll") {

    $sql = 'SELECT COUNT(*) FROM information_schema.tables  WHERE table_schema = "efront"  AND table_name = "module_vlabs_shoppingcart_order"';
    $tcount = eF_executeQuery($sql);

    foreach($tcount as $t){
        if($t['COUNT(*)'] < 1 ) {
            echo json_encode(array());
            return;
        }
    }

	$orders = db_getOrders();

	$formattedOrders= array();

		foreach($orders as $row) {
			$user = refactored_db_getUserById($row['userid']);
			$purchaseDate = date(DATE_ATOM, ($row['purchasedate']/1000)); 

			$o = array($row['id'],
			$row['ordernumber'],
			$user['name'],
			$purchaseDate,
			$row['lastmodification'] ,
			$row['fulfillmentorderstate'],
			$row['financialorderstate'] ,
			$row['total']
			);

			array_push($formattedOrders, $o);
	
		}

		
    echo json_encode($formattedOrders);

} else if ($action == "reloadOrderItems") {



	if (isset($_POST['orderid'])) {
		$orderid = $_POST['orderid'];
	} else {
		$orderid = "";
	}

	$ordertotal= 0;
	$orderItems = db_getOrderItems($orderid);
	$order = db_getOrderById($orderid);

	$formattedOrderItems= array();

		foreach ($orderItems as $orderitem) {
			$subtotal = $orderitem['quantity'] * $orderitem['unitprice'];						
			$description = ord_getItemDescription($orderitem['itemid'], $orderid); //jh this needs a lot of work, it's making a soap call
			$item = db_getItem($orderitem['itemid']);
	
			$itemid = "";
			$itemname = "";
			$itemtype = "";
			$itemdescription = "";

			foreach ($item as $i){
				$itemid = $i['id'];
				$itemname = $i['name'];
				$itemtype = $i['type'];
				$itemdescription = $i['description'];
			}

		
			$oi = array(
				$orderitem['id'],
			    $itemid,
				$itemname,
				$itemtype,
				$itemdescription,
				$orderitem['quantity'],
				$orderitem['unitprice'] ,
				$subtotal,
				$orderitem['cancelled'],
				$description	
			);
			
			$ordertotal += $subtotal;
			array_push($formattedOrderItems, $oi);
		}

	$result = array('orderItems' => $formattedOrderItems, "orderTotal" => $ordertotal);
	echo json_encode($result);

	//Approves the order with id orderid sent via POST
} else if ($action == "approveOrder") {
	
	if (isset($_POST['orderid'])) {
		$orderid = $_POST['orderid'];
	} else {
		$orderid = "";
	}
	
	if (isset($_POST['userid'])) {
		$userlogin = $_POST['userid'];
	} else {
		$userlogin = "";
	}
	

	$adminId = $userlogin;
	$userdata = db_getUserById($userlogin);

	$timeZoneId = "";

	foreach ($userdata as $u){
		$timeZoneId = $u['timezone'];
	}

	date_default_timezone_set($timeZoneId);
	
	//Get order details
	$dbOrder = db_getOrderById($orderid);
	$userid = "";
	$dbOrder_ordernumber = "";
	foreach($dbOrder as $o){
		$dbOrder_ordernumber = $o['ordernumber'];
		$userid = $o['userid'];
   }

	$user= db_getUserById($userid);
	$user_name = "";
	foreach($user as $u){
		$user_name = $u['name'];
	}
	
	//This array will help to create a detailed email of the items that could not be approved
	$failedItems = array();
	//call web service
	$orderItemsSuccess = saveTransaction($orderid, false);
	
	//Iterate through the response
	foreach($orderItemsSuccess as $ois){
		
		//If item could not be saved in web service, it should be deleted form the order summary
		if(!$ois["success"]){
			array_push($failedItems, $ois["id"]);
			db_cancelOrderItem($orderid, $ois["id"]);
		}
		
	}
	//Get active order items
	$items = db_getActiveOrderItems($orderid);

	//get cancelled order items and save the names on a string for a detailed message
	$itemsCancelled = db_getCancelledOrderItems($orderid);	
	$cancelledItemsNames = "";
	foreach ($itemsCancelled as $ic){
		$item = refactored_db_getItem($ic['itemid']);
		$cancelledItemsNames .= " ".$item['name'].",";
	}	
	$cancelledItemsNames = substr($cancelledItemsNames, 0, -1);
	$cancelledItemsNames.=".";
	$message = "The following items has not been approved in the order : ".$cancelledItemsNames	;
	
	$success  = true;
	
	//if there are non active order items decline order, otherwise approve it
	if($items)
	{
		db_approveOrder($orderid);
		//TODO:email content
		$body= '<p>Order '.$dbOrder_ordernumber.' has been approved.</p>';
		if($itemsCancelled){
			$body.='<p>'.$message.'</p>';
		}
		// sms: 5/19/2011
		// sendEmail($user, 'Order Approved', $body);
					
	}else{
		db_declineOrder($orderid);
		$success = false;
		//TODO:email content
		$body= '<p>Order '.$dbOrder_ordernumber.' has been declined. '.$message.'</p>';
		// sms: 5/19/2011
		// sendEmail($user, 'Order Declined', $body);
	}

	//Get order updated
	$order = db_getOrderById($orderid);
   $order_id = "";
	$order_ordernumber = "";
	$order_lastmodification = "";
	$order_fulfillmentorderstate = "";
	$order_financialorderstate = "";
	$order_total = "";
	$order_purchasedate = "";
	foreach($order as $o){
       $order_id = $o['id'];
		$order_ordernumber = $o['ordernumber'];
		$order_lastmodification = $o['lastmodification'];
		$order_fulfillmentorderstate = $o['fulfillmentorderstate'];
		$order_financialorderstate = $o['financialorderstate'];
		$order_total = $o['total'];
		$order_purchasedate = $o['purchasedate'];
	}

	$o = array("id"=>$order_id,
			"ordernumber"=>$order_ordernumber,
			"username"=>$user_name,
			"purchasedate"=>date(DATE_ATOM, ($order_purchasedate/1000)),
			"lastmodification"=>$order_lastmodification ,
			"fulfillmentorderstate"=>$order_fulfillmentorderstate,
			"financialorderstate"=>$order_financialorderstate ,
			"total"=>$order_total
			);	
			
	$response = array("success"=>$success, "message"=>$message, "cancelled"=>$itemsCancelled, "order"=>$o);
	echo json_encode($response);
		
	//Declines order with id orderid sent via POST
} else if ($action == "declineOrder") {

	if (isset($_POST['orderid'])) {
		$orderid = $_POST['orderid'];
	} else {
		$orderid = "";
	}
	
	if (isset($_POST['userid'])) {
		$userlogin = $_POST['userid'];
	} else {
		$userlogin = "";
	}


	$adminId = $userlogin;
	$userdata = db_getUserById($userlogin);

	$timeZoneId = "";

	foreach ($userdata as $u){
		$timeZoneId = 'GMT-05:00 US/Eastern';
	}

	date_default_timezone_set($timeZoneId);

	//Get order details
	$dbOrder = db_getOrderById($orderid);

	$dbOrder_userid = "";
	$dbOrder_ordernumber = "";
	foreach($dbOrder as $dbO){
		$dbOrder_userid = $dbO['userid'];
		$dbOrder_ordernumber = $dbO['ordernumber'];
	}

	//Update order in database
	$success = db_declineOrder($orderid);

	//Send email
	$user= db_getUserById($dbOrder_userid);

    $user_name="";
    foreach($user as $u) {

    $user_name = $u['username'];
    }
	$body= '<p>Order '.$dbOrder_ordernumber.' has been declined.<p>';
	//sendEmail($user, 'Order Declined', $body);  jh NOTE: come back to this !!!
	
	//Get order details
	$order = db_getOrderById($orderid);
	$order_ordernumber = "";
	$order_purchasedate = "";
	$order_lastmodification = "";
	$order_fulfillmentorderstate ="";
	$order_financialorderstate = "";
	$order_total = "";
	$order_id = "";

	foreach($order as $o){
		$order_ordernumber = $o['ordernumber'];
		$order_purchasedate = $o['purchasedate'];
		$order_lastmodification = $o['lastmodification'];
		$order_fulfillmentorderstate = $o['fulfillmentorderstate'];
		$order_financialorderstate = $o['ninancialorderstate'];
		$order_total = $o['total'];
		$order_id = $o['id'];
	}


	$o = array("id"=>$order_id,
			"ordernumber"=>$order_ordernumber,
			"username"=>$user_name,
			"purchasedate"=>date(DATE_ATOM, ($order_purchasedate/1000)),
			"lastmodification"=>$order_lastmodification ,
			"fulfillmentorderstate"=>$order_fulfillmentorderstate,
			"financialorderstate"=>$order_financialorderstate ,
			"total"=>$order_total
			);	
	
	$response = array("success"=>$success, "order"=>$o);
	echo json_encode($response);
		
}else if ($action == "cancelOrder") {

	if (isset($_POST['orderid'])) {
		$orderid = $_POST['orderid'];
	} else {
		$orderid = "";
	}

	if (isset($_POST['userid'])) {
		$userlogin = $_POST['userid'];
	} else {
		$userlogin = "";
	}
	
	$adminId = $userlogin;

	$userdata = db_getUserById($userlogin);

	$timeZoneId = "";

	foreach ($userdata as $u){
		$timeZoneId = 'GMT-05:00 US/Eastern'; //jh Geting data from quota system which does not currently have timezone
	}

	date_default_timezone_set($timeZoneId);

	//initialize refund
	$refundAmount = 0;
	
	$dbOrder =  db_getOrderById($orderid);
	$dbOrder_payment = "";
	$dbOrder_id = "";
	$dbOrder_refund= "";
	$dbOrder_ordernumber = "";
	$dbOrder_userid = "";

	foreach($dbOrder as $dbO){
		$dbOrder_payment = $dbO['payment'];
		$dbOrder_id = $dbO['id'];
		$dbOrder_refund= $dbO['refund'];
		$dbOrder_ordernumber = $dbO['ordernumber'];
		$dbOrder_userid = $dbO['userid'];
	}
	
	$dbOrderItems = db_getOrderItems($orderid);

	$assignmentsResponse = cancelTransaction($orderid);

	$i=0;	
	foreach ($dbOrderItems as $dbOrderItem){
		$ar = $assignmentsResponse[$i++];
		$subtotal = $dbOrderItem['quantity']*$dbOrderItem['unitprice'];
		$partialRefund = ($subtotal*$ar->percentageReturned)/100;	
		$refundAmount = $refundAmount + $partialRefund;	
	}
	
	//Google checkout orders
	if($dbOrder_payment){

		if($refundAmount>0){
			
			db_setOrderRefund($dbOrder_id, $dbOrder_refund+$refundAmount);
			
			//Refund total or partial item price 
			/*jh NOTE:  Discussed with Dr. Sadjadi on 7/6/2015 that we will not use the google request methods for now.
			$gresponse = $Grequest->SendRefundOrder($dbOrder_ordernumber,$refundAmount,
										"Order has been refunded by the store administrator.".
										"Contact the administrator for further details.");
			
			if($gresponse[0]==200){
				//If the refund amount is not the total of the orderItem, 
				//item cannot be cancelled

				$gresponse  = $Grequest->SendCancelOrder($dbOrder_ordernumber, 
								"Order has been cancelled by the store.".
				 				"Contact the administrator for further details.");
						
				if($gresponse[0]==200){
					db_cancelGoogleCheckoutOrder($dbOrder->id);
					$success = true;
				}else{
					$success = false;
					$message = "Google checkout has not allowed to cancel the order ".$dbOrder->ordernumber.".";
				}


			}else{
				$success = false;
				$message = "Google checkout has not allowed to refund the quantity of ".$refundAmount." to the order ".$dbOrder->ordernumber.".";
			}

			end jh */
			$message = "Refunds not available through this system, please contact the administrator for further details.";				
		}else{
			$success = false;
			$message = "Order could not be cancelled because all items have been consumed by the buyer.";
						
		}
	}else{
		$success = db_cancelOrder($orderid);	
	}

	if($success){
		$body= '<p>Order '.$dbOrder_ordernumber.' has been cancelled.<p>';
	}else{
		$body= '<p>The cancellation of your order has not been completed. The reason is:<cite>'.$message.'</cite><p>';
		
	}
	//Send email
	$user= db_getUserById($dbOrder_userid);
	$user_name = "";
	foreach($user as $u){
		$user_name = $u['username'];
	}
	// sms: 5/19/2011
	// sendEmail($user, 'Order['.$dbOrder->ordernumber.'] Cancellation', $body);

	
	//Get updated order info
	$order = db_getOrderById($orderid);
	$order_id = "";
	$order_ordernumber = "";
	$order_purchasedate = "";
	$order_fulfillmentorderstate = "";
	$order_financialorderstate = "";
	$order_total = "";
	$order_lastmodification = "";
	foreach($order as $o){
		$order_id = $o['id'];
		$order_ordernumber = $o['ordernumber'];
		$order_purchasedate = $o['purchasedate'];
		$order_fulfillmentorderstate = $o['fulfillmentorderstate'];
		$order_financialorderstate = $o['financialorderstate'];
		$order_total = $o['total'];
		$order_lastmodification = $o['lastmodification'];
	}



	$o = array("id"=>$order_id,
			"ordernumber"=>$order_ordernumber,
			"username"=>$user_name,
			"purchasedate"=>date(DATE_ATOM, ($order_purchasedate/1000)),
			"lastmodification"=>$order_lastmodification ,
			"fulfillmentorderstate"=>$order_fulfillmentorderstate,
			"financialorderstate"=>$order_financialorderstate ,
			"total"=>$order_total
			);	
			
	$response = array("success"=>$success, "message"=>$message, "order"=>$o);		
	echo json_encode($response);

	
}else if ($action == "cancelOrderItem") {

	if (isset($_POST['id'])) {
		$id = $_POST['id'];
	} else {
		$id = "";
	}

    if (isset($_POST['userid'])) {
        $userlogin = $_POST['userid'];
    } else {
        $userlogin = "";
    }

	//initilize refund
	$refundAmount=0;

	$dbOrderItem = db_getOrderItemById($id);

	$dbOrder = db_getOrderById($dbOrderItem['orderid']);
    $dbOrder_ordernumber ="";
    $dbOrder_id = "";
    $dbOrder_payment = "";
    $dbOrder_userid = "";
    foreach($dbOrder as $dbO){
        $dbOrder_ordernumber = $dbO['ordernumber'];
        $dbOrder_id = $dbO['id'];
        $dbOrder_payment = $dbO['payment'];
        $dbOrder_userid = $dbO['userid'];
    }

	$dbItem = db_getItem($dbOrderItem['itemid']);
    $dbItem_id = "";
    $dbItem_referenceid = "";
    $dbItem_name = "";
    $dbItem_type ="";

    foreach($dbItem as $dbI){
        $dbItem_id = $dbI['id'];
        $dbItem_referenceid = $dbI['id'];
        $dbItem_name = $dbI['name'];
        $dbItem_type = $dbI['type'];
    }
	$success = true;
	$message="";
	
	$assignmentsRequest = array();
	
	if($dbItem_type=="PACKAGE"){
		$packageItems = db_getPackageItems($dbItem_id);
		foreach ($packageItems as $pi){
			$item = db_getItem($pi['itemid']);
            $item_referenceid = "";
            foreach($item as $i){
                $item_referenceid = $i['referenceid'];
            }

			$assignment = array("creditTypeId"=>$item_referenceid,
								"quantity"=>$pi['quantity'],
								"purchaseId"=>$dbOrder_ordernumber."".$dbItem_id,
								"active"=>!$pi['cancelled']
								);
			array_push($assignmentsRequest, $assignment);			
		}
		
		$assignmentsResponse = ws_cancelQuotaAssignment($assignmentsRequest);
		
		$i=0;
		foreach ($packageItems as $pi){
			$percentageReturned = $assignmentsResponse[$i++]->percentageReturned; //jh NOTE: this is tied to the above call!!
			$subtotal = $pi['quantity']*$dbOrderItem['quantity']*$pi['price'];
			$partialRefund = ($subtotal * $percentageReturned)/100;	
			$refundAmount = $refundAmount + $partialRefund;		
		}

	}else{
		$assignment = array("creditTypeId"=>$dbItem_referenceid,
							"quantity"=>$dbOrderItem['quantity'],
							"purchaseId"=>$dbOrder_ordernumber,
							"active"=>!$dbOrderItem['cancelled']
							);	
		array_push($assignmentsRequest, $assignment);
		
		$assignmentResponse = ws_cancelQuotaAssignment($assignmentsRequest);

		$percentageReturned = $assignmentResponse->percentageReturned;
		$subtotal = $dbOrderItem->quantity*$dbItem->price;	
		$refundAmount = ($subtotal * $percentageReturned)/100;
	}


	//Google checkout order items
	if($dbOrder_payment){
		
		if($refundAmount>0){
            /*jh NOTE:  Discussed with Dr. Sadjadi on 7/6/2015 that we will not use the google request methods for now.

            $itemToCancel = array();
            //create a google item
            $gitem = new GoogleItem($dbItem->name, // Item name
            $dbItem->description, // Item description
            $dbOrderItem->quantity, // Quantity
            $dbItem->price); // Unit price

            //set item unique id
            $gitem->SetMerchantItemId($dbItem->id);
            array_push($itemsToCancel, $gitem);

            //Refund total or partial item price


            $gresponse = $Grequest->SendRefundOrder($dbOrder->ordernumber,$refundAmount,
                                        "Item has been refunded by the administrator of the quota store.".
                                        "Contact the administrator for further details.");

            if($gresponse[0]==200){
                //If the refund amount is not the total of the orderItem,
                //item cannot be cancelled

                db_setOrderRefund($dbOrder->id, $dbOrder->refund+$refundAmount);

                if($percentageReturned==1){
                    $gresponse = $Grequest->SendCancelItems($dbOrder->ordernumber, $itemsToCancel,
                                        "Item has been cancelled by the administrator of the quota store.".
                                        "Contact the administrator for further details.");

                    if($gresponse[0]==200){
                        db_cancelOrderItem($dbOrder->id, $dbItem->id);
                        $success = true;

                    }else{
                        $success = false;
                        $message = "Google could not cancel item ". $dbItem->name;
                    }
                }else{
                    db_cancelOrderItem($dbOrder->id, $dbItem->id);
                    $success = true;
                }
            }else{
                $success = false;
                $message = "Google could not refund the amount of ".$refundAmount." to the order ".$dbOrder->ordernumber.".";
            }

         $message = "Refunds not available through this system, please contact the administrator for further details.";
        jh end*/
        }else{
            $success = false;
            $message = "Item ". $dbItem_name." could not be cancelled because it has been consumed by the buyer.";


        }


    }else{
        $success = db_cancelOrderItem($dbOrder_id, $dbItem_id);
        if($success){
            $body= '<p>The item '.$dbItem_name.' from order '.$dbOrder_ordernumber.' has been cancelled.<p>';
        }else{
            $message = "Item could not be cancelled in database";
            $body= '<p>The cancellation of item '.$dbItem_name.' from order '.$dbOrder_ordernumber.' has not been completed.<p>';
        }

    }

    $itemsCancelled = db_getCancelledOrderItems($dbOrder_id);
    $items = refactored_db_getOrderItems($dbOrder_id);

    if(count($items) == count($itemsCancelled)){
        if($dbOrder_payment){

            /* jh as mentioned in above NOTE, google events will be omited for now
            db_cancelGoogleCheckoutOrder($dbOrder_id);
            $gresponse  = $Grequest->SendCancelOrder($dbOrder->ordernumber,
                                    "Order has been cancelled due to a partial or complete refund.".
                                     "Contact the administrator for further details.");
            */
        }else{
            db_cancelOrder($dbOrder_id);
            $body= '<p>Order '.$dbOrder_ordernumber.' has been cancelled.<p>';
            $user= db_getUserById($dbOrder_userid);
            // sms: 5/19/2011
            // sendEmail($user, 'Order['.$dbOrder->ordernumber.'] Cancellation', $body);

        }

    }

    $orderitem = db_getOrderItemById($id);
    $subtotal = $orderitem['quantity'] * $orderitem['unitprice'];
    $item = refactored_db_getItem($orderitem['itemid']);
    $user= db_getUserById($dbOrder_userid);
    $description = ord_getItemDescription($item['id'], $dbOrder_id);

    $oi = array(
        "id"=>$orderitem['id'],
        "itemid"=>$item['id'],
        "name"=>$item['name'],
        "type"=>$item['type'],
        "description"=>$item['description'],
        "quantity"=>$orderitem['quantity'],
        "price"=>$orderitem['unitprice'] ,
        "subtotal"=>$subtotal,
        "cancelled"=>$orderitem['cancelled'],
        "description"=>$description
    );

    if($success){
        $body= '<p>The item '. $dbItem_name.' from order '.$dbOrder_ordernumber.' has been cancelled.<p>';
    }else{
        $body= '<p>The item '. $dbItem_name.' from order '.$dbOrder_ordernumber.' has not been cancelled. The reason is: <cite>'.$message.'</cite><p>';

    }

    // sms: 5/19/2011
    // sendEmail($user, 'Item Cancellation from order['.$dbOrder->ordernumber.']', $body);

    $response = array("success"=>$success, "orderitem"=>$oi, "message"=>$message);
    echo json_encode($response);

}

function ord_getItemDescription($itemid, $orderid){

    //Test with ordernumber:  IA4f310f1212c9b

    $order = db_getOrderById($orderid);

    $order_userid = "";
    foreach($order as $o)
    {
        $order_userid = $o['userid'];
    }

    $item = db_getItem($itemid);
    $itemtype="";
    foreach($item as $i)
    {
        $itemtype=$i['type'];
    }

    $timeZoneId = 'GMT-05:00 US/Eastern'; //jh Quota system currently not providing timeZone info.
    $description = "";

    if($itemtype=="PACKAGE"){

        $items = array();
        $packageItems = db_getPackageItems($itemid);

        foreach($packageItems as $packageItem){

            $item = db_getItem($packageItem['itemid']);
            // jh NOTE: $item->quantity = $packageItem->quantity; //replaced by foreach loop below.  I cannot use object->field because getting back  a mixed mysqli array

            foreach($item as $i)
            {
                $i['quantity'] = $packageItem['quantity'];
            }


            array_push($items, $item);
        }

        $description .= "<ul>";

        foreach ($items as $item){
            $itemname="";
            $itemquantity="";
            $item_referenceid="";

            foreach($item as $i)
            {
                $itemname=$i['name'];
                $itemquantity=$i['quantity'];
                $item_referenceid=['referenceid'];
            }

            $creditType = ws_getCreditTypeById($item_referenceid);
            //jh CAREFUL!!!! NEED TO TEST IF creditType returned is null else it will look ugly

			$course = db_getCourseById($creditType->courseId);
			$course_name = "";
			foreach($course as $c)
			{
				$course_name = $c['name'];
			}
							
			$description .= "<li>";
			$description .= "<strong>".$itemname."(".$itemquantity."):</strong> ";
			$description .= "This item allows students enrolled in the course ".$course_name." to use the resource ".$creditType->resource." for ";	
			$description .= ord_getPolicyDescription($creditType->policyId, $timeZoneId);			
			$description .= "</li>";
		}

		$description .= "</ul>";
		
						
	}else{
		
			$item_referenceid="";
			foreach($item as $i)
			{
				$item_referenceid=$i['referenceid'];
			}		

		$creditType = ws_getCreditTypeById($item_referenceid);
		$course = db_getCourseById($creditType->courseId);
		$course_name="";
		foreach($course as $c)
		{
			$course_name=$c['name'];
		}
	//	$description .=  "This item allows students enrolled in the course ".$course->shortname."  to use the resource ".$creditType->resource." for ";	//jh original code needs retrofitting, efront course table does not have a shortname field
		$description .=  "This item allows students enrolled in the course ".$course_name."  to use the resource ".$creditType->resource." for ";
		$description .= ord_getPolicyDescription($creditType->policyId, $timeZoneId);
		
	}

	return $description;
	

}


function ord_getPolicyDescription($policyId, $timeZoneId){

	$policy = ws_getPolicyById($policyId, $timeZoneId);	
	$policyType = $policy->policyType;
	$absolute = $policy->absolute;
	$compatibleTimezone = substr($timeZoneId,10);
	date_default_timezone_set($compatibleTimezone);

	if($policyType =="NOEXPIRATION"){
		$description .= $policy['quotaInPeriod']." minutes. ";
		$description .= "This item does not expire. ";
	
	}else if($policyType =="FIXED"){
		$description .= $policy->quotaInPeriod." minutes. ";				
		$daysFromStart = $policy->numberOfPeriods * $policy->daysInPeriod;
		
		if($absolute){
			$expDate = strtotime ( '+ '.$daysFromStart.' day' , strtotime ( $policy->startDate ) ) ;
			$description .= "This item can be used from ".date('F j, Y, g:i a' ,strtotime ( $policy->startDate ) )." until ". date ( 'F j, Y, g:i a' , $expDate ).". ";	
		}else{
			$description .= "This item will expire ".$daysFromStart ." days after purchase. ";
		}
	
	}else if($policyType =="GRADUAL"){
		$description .= $policy->quotaInPeriod." minutes per period (".$policy->numberOfPeriods." periods of ".$policy->daysInPeriod." days each). ";			
		$description.= "A maximum of ".$policy->maximum." minutes can be used each period. ";
	
		$daysFromStart = $policy->numberOfPeriods * $policy->daysInPeriod;
			
		if($absolute){
			$expDate = strtotime ( '+ '.$daysFromStart.' day' , strtotime ( $policy->startDate ) ) ;
			$description .= "This item can be used from ".date('F j, Y, g:i a' ,strtotime ( $policy->startDate ) )." until ". date ( 'F j, Y, g:i a' , $expDate ).". ";	
		}else{
			$description .= "This item will expire ".$daysFromStart ." days after purchase. ";
		}		
	
	}else if($policyType =="MINMAX"){
		$description .= $policy->quotaInPeriod." minutes per period (".$policy->numberOfPeriods." periods of ".$policy->daysInPeriod." days each). ";							
		$description .= "A maximum of ".$policy->maximum." minutes can be used each period. ";
		$description .= "A minimum of ".$policy->minimum." minutes must be used each period. Otherwise, they remaining minutes will expire. ";
				
		$daysFromStart = $policy->numberOfPeriods * $policy->daysInPeriod;				
		
		if($absolute){
			$expDate = strtotime ( '+ '.$daysFromStart.' day' , strtotime ( $policy->startDate ) ) ;
			$description .= "This item can be used from ".date('F j, Y, g:i a' ,strtotime ( $policy->startDate ) )." until ". date ( 'F j, Y, g:i a' , $expDate ).". ";	
		}else{
			$description .= "This item will expire ".$daysFromStart ." days after purchase. ";
		}
		
	
	}
	return $description;
	 	
}

?>
