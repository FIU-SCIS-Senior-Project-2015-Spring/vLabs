
/**
 * TrialWSMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package edu.fiu.cis.acrl.kaseya.tenant.ws;

        /**
        *  TrialWSMessageReceiverInOut message receiver
        */

        public class TrialWSMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        TrialWSSkeleton skel = (TrialWSSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){

        

            if("createTrialAccount".equals(methodName)){
                
                com.kaseya.hosted.webservices.CreateTrialAccountResponse createTrialAccountResponse1 = null;
	                        com.kaseya.hosted.webservices.CreateTrialAccount wrappedParam =
                                                             (com.kaseya.hosted.webservices.CreateTrialAccount)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.kaseya.hosted.webservices.CreateTrialAccount.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               createTrialAccountResponse1 =
                                                   
                                                   
                                                         skel.createTrialAccount(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), createTrialAccountResponse1, false);
                                    } else 

            if("validateTrialAccount".equals(methodName)){
                
                com.kaseya.hosted.webservices.ValidateTrialAccountResponse validateTrialAccountResponse3 = null;
	                        com.kaseya.hosted.webservices.ValidateTrialAccount wrappedParam =
                                                             (com.kaseya.hosted.webservices.ValidateTrialAccount)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.kaseya.hosted.webservices.ValidateTrialAccount.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               validateTrialAccountResponse3 =
                                                   
                                                   
                                                         skel.validateTrialAccount(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), validateTrialAccountResponse3, false);
                                    } else 

            if("updateTrialAccount".equals(methodName)){
                
                com.kaseya.hosted.webservices.UpdateTrialAccountResponse updateTrialAccountResponse5 = null;
	                        com.kaseya.hosted.webservices.UpdateTrialAccount wrappedParam =
                                                             (com.kaseya.hosted.webservices.UpdateTrialAccount)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.kaseya.hosted.webservices.UpdateTrialAccount.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               updateTrialAccountResponse5 =
                                                   
                                                   
                                                         skel.updateTrialAccount(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), updateTrialAccountResponse5, false);
                                    } else 

            if("validatePromoCode".equals(methodName)){
                
                com.kaseya.hosted.webservices.ValidatePromoCodeResponse validatePromoCodeResponse7 = null;
	                        com.kaseya.hosted.webservices.ValidatePromoCode wrappedParam =
                                                             (com.kaseya.hosted.webservices.ValidatePromoCode)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.kaseya.hosted.webservices.ValidatePromoCode.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               validatePromoCodeResponse7 =
                                                   
                                                   
                                                         skel.validatePromoCode(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), validatePromoCodeResponse7, false);
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(com.kaseya.hosted.webservices.CreateTrialAccount param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.kaseya.hosted.webservices.CreateTrialAccount.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.kaseya.hosted.webservices.CreateTrialAccountResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.kaseya.hosted.webservices.CreateTrialAccountResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.kaseya.hosted.webservices.ValidateTrialAccount param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.kaseya.hosted.webservices.ValidateTrialAccount.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.kaseya.hosted.webservices.ValidateTrialAccountResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.kaseya.hosted.webservices.ValidateTrialAccountResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.kaseya.hosted.webservices.UpdateTrialAccount param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.kaseya.hosted.webservices.UpdateTrialAccount.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.kaseya.hosted.webservices.UpdateTrialAccountResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.kaseya.hosted.webservices.UpdateTrialAccountResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.kaseya.hosted.webservices.ValidatePromoCode param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.kaseya.hosted.webservices.ValidatePromoCode.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.kaseya.hosted.webservices.ValidatePromoCodeResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.kaseya.hosted.webservices.ValidatePromoCodeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.kaseya.hosted.webservices.CreateTrialAccountResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.kaseya.hosted.webservices.CreateTrialAccountResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.kaseya.hosted.webservices.CreateTrialAccountResponse wrapCreateTrialAccount(){
                                com.kaseya.hosted.webservices.CreateTrialAccountResponse wrappedElement = new com.kaseya.hosted.webservices.CreateTrialAccountResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.kaseya.hosted.webservices.ValidateTrialAccountResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.kaseya.hosted.webservices.ValidateTrialAccountResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.kaseya.hosted.webservices.ValidateTrialAccountResponse wrapValidateTrialAccount(){
                                com.kaseya.hosted.webservices.ValidateTrialAccountResponse wrappedElement = new com.kaseya.hosted.webservices.ValidateTrialAccountResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.kaseya.hosted.webservices.UpdateTrialAccountResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.kaseya.hosted.webservices.UpdateTrialAccountResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.kaseya.hosted.webservices.UpdateTrialAccountResponse wrapUpdateTrialAccount(){
                                com.kaseya.hosted.webservices.UpdateTrialAccountResponse wrappedElement = new com.kaseya.hosted.webservices.UpdateTrialAccountResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.kaseya.hosted.webservices.ValidatePromoCodeResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.kaseya.hosted.webservices.ValidatePromoCodeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private com.kaseya.hosted.webservices.ValidatePromoCodeResponse wrapValidatePromoCode(){
                                com.kaseya.hosted.webservices.ValidatePromoCodeResponse wrappedElement = new com.kaseya.hosted.webservices.ValidatePromoCodeResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (com.kaseya.hosted.webservices.CreateTrialAccount.class.equals(type)){
                
                           return com.kaseya.hosted.webservices.CreateTrialAccount.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.kaseya.hosted.webservices.CreateTrialAccountResponse.class.equals(type)){
                
                           return com.kaseya.hosted.webservices.CreateTrialAccountResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.kaseya.hosted.webservices.ValidateTrialAccount.class.equals(type)){
                
                           return com.kaseya.hosted.webservices.ValidateTrialAccount.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.kaseya.hosted.webservices.ValidateTrialAccountResponse.class.equals(type)){
                
                           return com.kaseya.hosted.webservices.ValidateTrialAccountResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.kaseya.hosted.webservices.UpdateTrialAccount.class.equals(type)){
                
                           return com.kaseya.hosted.webservices.UpdateTrialAccount.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.kaseya.hosted.webservices.UpdateTrialAccountResponse.class.equals(type)){
                
                           return com.kaseya.hosted.webservices.UpdateTrialAccountResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.kaseya.hosted.webservices.ValidatePromoCode.class.equals(type)){
                
                           return com.kaseya.hosted.webservices.ValidatePromoCode.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.kaseya.hosted.webservices.ValidatePromoCodeResponse.class.equals(type)){
                
                           return com.kaseya.hosted.webservices.ValidatePromoCodeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    