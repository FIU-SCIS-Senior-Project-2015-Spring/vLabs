
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

            package edu.fiu.cis.acrl.quotasystem.ws;
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://acrl.cis.fiu.edu/quotasystem/ws".equals(namespaceURI) &&
                  "QuotaSummary".equals(typeName)){
                   
                            return  edu.fiu.cis.acrl.quotasystem.ws.QuotaSummary.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://acrl.cis.fiu.edu/quotasystem/ws".equals(namespaceURI) &&
                  "PolicyType".equals(typeName)){
                   
                            return  edu.fiu.cis.acrl.quotasystem.ws.PolicyType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://acrl.cis.fiu.edu/quotasystem/ws".equals(namespaceURI) &&
                  "Enrollment".equals(typeName)){
                   
                            return  edu.fiu.cis.acrl.quotasystem.ws.Enrollment.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://acrl.cis.fiu.edu/quotasystem/ws".equals(namespaceURI) &&
                  "Policy".equals(typeName)){
                   
                            return  edu.fiu.cis.acrl.quotasystem.ws.Policy.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://acrl.cis.fiu.edu/quotasystem/ws".equals(namespaceURI) &&
                  "CreditType".equals(typeName)){
                   
                            return  edu.fiu.cis.acrl.quotasystem.ws.CreditType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://acrl.cis.fiu.edu/quotasystem/ws".equals(namespaceURI) &&
                  "QuotaAssignment".equals(typeName)){
                   
                            return  edu.fiu.cis.acrl.quotasystem.ws.QuotaAssignment.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://acrl.cis.fiu.edu/quotasystem/ws".equals(namespaceURI) &&
                  "Course".equals(typeName)){
                   
                            return  edu.fiu.cis.acrl.quotasystem.ws.Course.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://acrl.cis.fiu.edu/quotasystem/ws".equals(namespaceURI) &&
                  "Appointment".equals(typeName)){
                   
                            return  edu.fiu.cis.acrl.quotasystem.ws.Appointment.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://acrl.cis.fiu.edu/quotasystem/ws".equals(namespaceURI) &&
                  "User".equals(typeName)){
                   
                            return  edu.fiu.cis.acrl.quotasystem.ws.User.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    