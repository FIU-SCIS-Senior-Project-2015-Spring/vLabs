
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

            package com.kaseya.hosted.webservices;
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://hosted.kaseya.com/webservices/".equals(namespaceURI) &&
                  "PromoCodeResponse".equals(typeName)){
                   
                            return  com.kaseya.hosted.webservices.PromoCodeResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://hosted.kaseya.com/webservices/".equals(namespaceURI) &&
                  "TrialType".equals(typeName)){
                   
                            return  com.kaseya.hosted.webservices.TrialType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://hosted.kaseya.com/webservices/".equals(namespaceURI) &&
                  "PromoCodeRequest".equals(typeName)){
                   
                            return  com.kaseya.hosted.webservices.PromoCodeRequest.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://hosted.kaseya.com/webservices/".equals(namespaceURI) &&
                  "UpdateTrialResponse".equals(typeName)){
                   
                            return  com.kaseya.hosted.webservices.UpdateTrialResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://hosted.kaseya.com/webservices/".equals(namespaceURI) &&
                  "UpdateTrialRequest".equals(typeName)){
                   
                            return  com.kaseya.hosted.webservices.UpdateTrialRequest.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://hosted.kaseya.com/webservices/".equals(namespaceURI) &&
                  "TrialRequest".equals(typeName)){
                   
                            return  com.kaseya.hosted.webservices.TrialRequest.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://hosted.kaseya.com/webservices/".equals(namespaceURI) &&
                  "TrialResponse".equals(typeName)){
                   
                            return  com.kaseya.hosted.webservices.TrialResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://hosted.kaseya.com/webservices/".equals(namespaceURI) &&
                  "AccountType".equals(typeName)){
                   
                            return  com.kaseya.hosted.webservices.AccountType.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    