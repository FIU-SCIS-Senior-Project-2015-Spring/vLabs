
/**
 * TrialWSCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package edu.fiu.cis.acrl.kaseya.tenant.ws;

    /**
     *  TrialWSCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class TrialWSCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public TrialWSCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public TrialWSCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for createTrialAccount method
            * override this method for handling normal response from createTrialAccount operation
            */
           public void receiveResultcreateTrialAccount(
                    com.kaseya.hosted.webservices.CreateTrialAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createTrialAccount operation
           */
            public void receiveErrorcreateTrialAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for validateTrialAccount method
            * override this method for handling normal response from validateTrialAccount operation
            */
           public void receiveResultvalidateTrialAccount(
                    com.kaseya.hosted.webservices.ValidateTrialAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from validateTrialAccount operation
           */
            public void receiveErrorvalidateTrialAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateTrialAccount method
            * override this method for handling normal response from updateTrialAccount operation
            */
           public void receiveResultupdateTrialAccount(
                    com.kaseya.hosted.webservices.UpdateTrialAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateTrialAccount operation
           */
            public void receiveErrorupdateTrialAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for validatePromoCode method
            * override this method for handling normal response from validatePromoCode operation
            */
           public void receiveResultvalidatePromoCode(
                    com.kaseya.hosted.webservices.ValidatePromoCodeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from validatePromoCode operation
           */
            public void receiveErrorvalidatePromoCode(java.lang.Exception e) {
            }
                


    }
    