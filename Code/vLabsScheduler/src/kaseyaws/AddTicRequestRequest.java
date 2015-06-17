
/**
 * AddTicRequestRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package kaseyaws;
            

            /**
            *  AddTicRequestRequest bean class
            */
        
        public  class AddTicRequestRequest extends kaseyaws.RequestBase
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = AddTicRequestRequest
                Namespace URI = KaseyaWS
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("KaseyaWS")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for SubmitterName
                        */

                        
                                    protected java.lang.String localSubmitterName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSubmitterNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSubmitterName(){
                               return localSubmitterName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SubmitterName
                               */
                               public void setSubmitterName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSubmitterNameTracker = true;
                                       } else {
                                          localSubmitterNameTracker = false;
                                              
                                       }
                                   
                                            this.localSubmitterName=param;
                                    

                               }
                            

                        /**
                        * field for SubmitterEmailAddr
                        */

                        
                                    protected java.lang.String localSubmitterEmailAddr ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSubmitterEmailAddrTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSubmitterEmailAddr(){
                               return localSubmitterEmailAddr;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SubmitterEmailAddr
                               */
                               public void setSubmitterEmailAddr(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSubmitterEmailAddrTracker = true;
                                       } else {
                                          localSubmitterEmailAddrTracker = false;
                                              
                                       }
                                   
                                            this.localSubmitterEmailAddr=param;
                                    

                               }
                            

                        /**
                        * field for Subj
                        */

                        
                                    protected java.lang.String localSubj ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSubjTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSubj(){
                               return localSubj;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Subj
                               */
                               public void setSubj(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSubjTracker = true;
                                       } else {
                                          localSubjTracker = false;
                                              
                                       }
                                   
                                            this.localSubj=param;
                                    

                               }
                            

                        /**
                        * field for Body
                        */

                        
                                    protected java.lang.String localBody ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBodyTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBody(){
                               return localBody;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Body
                               */
                               public void setBody(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localBodyTracker = true;
                                       } else {
                                          localBodyTracker = false;
                                              
                                       }
                                   
                                            this.localBody=param;
                                    

                               }
                            

                        /**
                        * field for SourceType
                        */

                        
                                    protected java.lang.String localSourceType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSourceTypeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSourceType(){
                               return localSourceType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SourceType
                               */
                               public void setSourceType(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSourceTypeTracker = true;
                                       } else {
                                          localSourceTypeTracker = false;
                                              
                                       }
                                   
                                            this.localSourceType=param;
                                    

                               }
                            

                        /**
                        * field for SourceTag1
                        */

                        
                                    protected java.lang.String localSourceTag1 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSourceTag1Tracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSourceTag1(){
                               return localSourceTag1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SourceTag1
                               */
                               public void setSourceTag1(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSourceTag1Tracker = true;
                                       } else {
                                          localSourceTag1Tracker = false;
                                              
                                       }
                                   
                                            this.localSourceTag1=param;
                                    

                               }
                            

                        /**
                        * field for SourceValue1
                        */

                        
                                    protected java.lang.String localSourceValue1 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSourceValue1Tracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSourceValue1(){
                               return localSourceValue1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SourceValue1
                               */
                               public void setSourceValue1(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSourceValue1Tracker = true;
                                       } else {
                                          localSourceValue1Tracker = false;
                                              
                                       }
                                   
                                            this.localSourceValue1=param;
                                    

                               }
                            

                        /**
                        * field for SourceTag2
                        */

                        
                                    protected java.lang.String localSourceTag2 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSourceTag2Tracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSourceTag2(){
                               return localSourceTag2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SourceTag2
                               */
                               public void setSourceTag2(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSourceTag2Tracker = true;
                                       } else {
                                          localSourceTag2Tracker = false;
                                              
                                       }
                                   
                                            this.localSourceTag2=param;
                                    

                               }
                            

                        /**
                        * field for SourceValue2
                        */

                        
                                    protected java.lang.String localSourceValue2 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSourceValue2Tracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSourceValue2(){
                               return localSourceValue2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SourceValue2
                               */
                               public void setSourceValue2(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSourceValue2Tracker = true;
                                       } else {
                                          localSourceValue2Tracker = false;
                                              
                                       }
                                   
                                            this.localSourceValue2=param;
                                    

                               }
                            

                        /**
                        * field for SourceTag3
                        */

                        
                                    protected java.lang.String localSourceTag3 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSourceTag3Tracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSourceTag3(){
                               return localSourceTag3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SourceTag3
                               */
                               public void setSourceTag3(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSourceTag3Tracker = true;
                                       } else {
                                          localSourceTag3Tracker = false;
                                              
                                       }
                                   
                                            this.localSourceTag3=param;
                                    

                               }
                            

                        /**
                        * field for SourceValue3
                        */

                        
                                    protected java.lang.String localSourceValue3 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSourceValue3Tracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSourceValue3(){
                               return localSourceValue3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SourceValue3
                               */
                               public void setSourceValue3(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSourceValue3Tracker = true;
                                       } else {
                                          localSourceValue3Tracker = false;
                                              
                                       }
                                   
                                            this.localSourceValue3=param;
                                    

                               }
                            

                        /**
                        * field for AssocMachineId
                        */

                        
                                    protected java.lang.String localAssocMachineId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAssocMachineIdTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAssocMachineId(){
                               return localAssocMachineId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AssocMachineId
                               */
                               public void setAssocMachineId(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAssocMachineIdTracker = true;
                                       } else {
                                          localAssocMachineIdTracker = false;
                                              
                                       }
                                   
                                            this.localAssocMachineId=param;
                                    

                               }
                            

                        /**
                        * field for AssocMachineGroupId
                        */

                        
                                    protected java.lang.String localAssocMachineGroupId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAssocMachineGroupIdTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAssocMachineGroupId(){
                               return localAssocMachineGroupId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AssocMachineGroupId
                               */
                               public void setAssocMachineGroupId(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAssocMachineGroupIdTracker = true;
                                       } else {
                                          localAssocMachineGroupIdTracker = false;
                                              
                                       }
                                   
                                            this.localAssocMachineGroupId=param;
                                    

                               }
                            

                        /**
                        * field for NewTicketFlag
                        */

                        
                                    protected java.lang.String localNewTicketFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNewTicketFlagTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNewTicketFlag(){
                               return localNewTicketFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NewTicketFlag
                               */
                               public void setNewTicketFlag(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localNewTicketFlagTracker = true;
                                       } else {
                                          localNewTicketFlagTracker = false;
                                              
                                       }
                                   
                                            this.localNewTicketFlag=param;
                                    

                               }
                            

                        /**
                        * field for NoNotificationFlag
                        */

                        
                                    protected java.lang.String localNoNotificationFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNoNotificationFlagTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNoNotificationFlag(){
                               return localNoNotificationFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NoNotificationFlag
                               */
                               public void setNoNotificationFlag(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localNoNotificationFlagTracker = true;
                                       } else {
                                          localNoNotificationFlagTracker = false;
                                              
                                       }
                                   
                                            this.localNoNotificationFlag=param;
                                    

                               }
                            

                        /**
                        * field for BrowserIP
                        */

                        
                                    protected java.lang.String localBrowserIP ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBrowserIPTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBrowserIP(){
                               return localBrowserIP;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BrowserIP
                               */
                               public void setBrowserIP(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localBrowserIPTracker = true;
                                       } else {
                                          localBrowserIPTracker = false;
                                              
                                       }
                                   
                                            this.localBrowserIP=param;
                                    

                               }
                            

                        /**
                        * field for SessionID
                        */

                        
                                    protected java.math.BigDecimal localSessionID ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getSessionID(){
                               return localSessionID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SessionID
                               */
                               public void setSessionID(java.math.BigDecimal param){
                            
                                            this.localSessionID=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       AddTicRequestRequest.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"KaseyaWS");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":AddTicRequestRequest",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "AddTicRequestRequest",
                           xmlWriter);
                   }

                if (localSubmitterNameTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"submitterName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"submitterName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("submitterName");
                                    }
                                

                                          if (localSubmitterName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("submitterName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSubmitterName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSubmitterEmailAddrTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"submitterEmailAddr", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"submitterEmailAddr");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("submitterEmailAddr");
                                    }
                                

                                          if (localSubmitterEmailAddr==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("submitterEmailAddr cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSubmitterEmailAddr);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSubjTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"subj", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"subj");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("subj");
                                    }
                                

                                          if (localSubj==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("subj cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSubj);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBodyTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"body", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"body");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("body");
                                    }
                                

                                          if (localBody==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("body cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBody);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSourceTypeTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"sourceType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"sourceType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("sourceType");
                                    }
                                

                                          if (localSourceType==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("sourceType cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSourceType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSourceTag1Tracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"sourceTag1", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"sourceTag1");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("sourceTag1");
                                    }
                                

                                          if (localSourceTag1==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("sourceTag1 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSourceTag1);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSourceValue1Tracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"sourceValue1", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"sourceValue1");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("sourceValue1");
                                    }
                                

                                          if (localSourceValue1==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("sourceValue1 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSourceValue1);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSourceTag2Tracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"sourceTag2", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"sourceTag2");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("sourceTag2");
                                    }
                                

                                          if (localSourceTag2==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("sourceTag2 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSourceTag2);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSourceValue2Tracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"sourceValue2", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"sourceValue2");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("sourceValue2");
                                    }
                                

                                          if (localSourceValue2==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("sourceValue2 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSourceValue2);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSourceTag3Tracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"sourceTag3", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"sourceTag3");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("sourceTag3");
                                    }
                                

                                          if (localSourceTag3==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("sourceTag3 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSourceTag3);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSourceValue3Tracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"sourceValue3", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"sourceValue3");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("sourceValue3");
                                    }
                                

                                          if (localSourceValue3==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("sourceValue3 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSourceValue3);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAssocMachineIdTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"assocMachineId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"assocMachineId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("assocMachineId");
                                    }
                                

                                          if (localAssocMachineId==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("assocMachineId cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAssocMachineId);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAssocMachineGroupIdTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"assocMachineGroupId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"assocMachineGroupId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("assocMachineGroupId");
                                    }
                                

                                          if (localAssocMachineGroupId==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("assocMachineGroupId cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAssocMachineGroupId);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNewTicketFlagTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"newTicketFlag", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"newTicketFlag");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("newTicketFlag");
                                    }
                                

                                          if (localNewTicketFlag==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("newTicketFlag cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNewTicketFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNoNotificationFlagTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"noNotificationFlag", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"noNotificationFlag");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("noNotificationFlag");
                                    }
                                

                                          if (localNoNotificationFlag==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("noNotificationFlag cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNoNotificationFlag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBrowserIPTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"BrowserIP", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"BrowserIP");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("BrowserIP");
                                    }
                                

                                          if (localBrowserIP==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("BrowserIP cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBrowserIP);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SessionID", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SessionID");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SessionID");
                                    }
                                

                                          if (localSessionID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SessionID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSessionID));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                
                    attribList.add(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema-instance","type"));
                    attribList.add(new javax.xml.namespace.QName("KaseyaWS","AddTicRequestRequest"));
                 if (localSubmitterNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "submitterName"));
                                 
                                        if (localSubmitterName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSubmitterName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("submitterName cannot be null!!");
                                        }
                                    } if (localSubmitterEmailAddrTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "submitterEmailAddr"));
                                 
                                        if (localSubmitterEmailAddr != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSubmitterEmailAddr));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("submitterEmailAddr cannot be null!!");
                                        }
                                    } if (localSubjTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "subj"));
                                 
                                        if (localSubj != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSubj));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("subj cannot be null!!");
                                        }
                                    } if (localBodyTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "body"));
                                 
                                        if (localBody != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBody));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("body cannot be null!!");
                                        }
                                    } if (localSourceTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "sourceType"));
                                 
                                        if (localSourceType != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSourceType));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("sourceType cannot be null!!");
                                        }
                                    } if (localSourceTag1Tracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "sourceTag1"));
                                 
                                        if (localSourceTag1 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSourceTag1));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("sourceTag1 cannot be null!!");
                                        }
                                    } if (localSourceValue1Tracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "sourceValue1"));
                                 
                                        if (localSourceValue1 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSourceValue1));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("sourceValue1 cannot be null!!");
                                        }
                                    } if (localSourceTag2Tracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "sourceTag2"));
                                 
                                        if (localSourceTag2 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSourceTag2));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("sourceTag2 cannot be null!!");
                                        }
                                    } if (localSourceValue2Tracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "sourceValue2"));
                                 
                                        if (localSourceValue2 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSourceValue2));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("sourceValue2 cannot be null!!");
                                        }
                                    } if (localSourceTag3Tracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "sourceTag3"));
                                 
                                        if (localSourceTag3 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSourceTag3));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("sourceTag3 cannot be null!!");
                                        }
                                    } if (localSourceValue3Tracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "sourceValue3"));
                                 
                                        if (localSourceValue3 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSourceValue3));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("sourceValue3 cannot be null!!");
                                        }
                                    } if (localAssocMachineIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "assocMachineId"));
                                 
                                        if (localAssocMachineId != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssocMachineId));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("assocMachineId cannot be null!!");
                                        }
                                    } if (localAssocMachineGroupIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "assocMachineGroupId"));
                                 
                                        if (localAssocMachineGroupId != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssocMachineGroupId));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("assocMachineGroupId cannot be null!!");
                                        }
                                    } if (localNewTicketFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "newTicketFlag"));
                                 
                                        if (localNewTicketFlag != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNewTicketFlag));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("newTicketFlag cannot be null!!");
                                        }
                                    } if (localNoNotificationFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "noNotificationFlag"));
                                 
                                        if (localNoNotificationFlag != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNoNotificationFlag));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("noNotificationFlag cannot be null!!");
                                        }
                                    } if (localBrowserIPTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "BrowserIP"));
                                 
                                        if (localBrowserIP != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBrowserIP));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("BrowserIP cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "SessionID"));
                                 
                                        if (localSessionID != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSessionID));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SessionID cannot be null!!");
                                        }
                                    

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static AddTicRequestRequest parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            AddTicRequestRequest object =
                new AddTicRequestRequest();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"AddTicRequestRequest".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (AddTicRequestRequest)kaseyaws.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","submitterName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSubmitterName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","submitterEmailAddr").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSubmitterEmailAddr(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","subj").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSubj(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","body").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBody(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","sourceType").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSourceType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","sourceTag1").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSourceTag1(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","sourceValue1").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSourceValue1(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","sourceTag2").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSourceTag2(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","sourceValue2").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSourceValue2(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","sourceTag3").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSourceTag3(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","sourceValue3").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSourceValue3(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","assocMachineId").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAssocMachineId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","assocMachineGroupId").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAssocMachineGroupId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","newTicketFlag").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNewTicketFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","noNotificationFlag").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNoNotificationFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","BrowserIP").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBrowserIP(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","SessionID").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSessionID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                              
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          