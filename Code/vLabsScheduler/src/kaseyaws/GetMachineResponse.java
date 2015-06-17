
/**
 * GetMachineResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package kaseyaws;
            

            /**
            *  GetMachineResponse bean class
            */
        
        public  class GetMachineResponse extends kaseyaws.ResponseBase
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = GetMachineResponse
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
                        * field for Machine_GroupID
                        */

                        
                                    protected java.lang.String localMachine_GroupID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMachine_GroupIDTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMachine_GroupID(){
                               return localMachine_GroupID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Machine_GroupID
                               */
                               public void setMachine_GroupID(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMachine_GroupIDTracker = true;
                                       } else {
                                          localMachine_GroupIDTracker = false;
                                              
                                       }
                                   
                                            this.localMachine_GroupID=param;
                                    

                               }
                            

                        /**
                        * field for AgentGuid
                        */

                        
                                    protected java.math.BigDecimal localAgentGuid ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getAgentGuid(){
                               return localAgentGuid;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AgentGuid
                               */
                               public void setAgentGuid(java.math.BigDecimal param){
                            
                                            this.localAgentGuid=param;
                                    

                               }
                            

                        /**
                        * field for MachName
                        */

                        
                                    protected java.lang.String localMachName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMachNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMachName(){
                               return localMachName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MachName
                               */
                               public void setMachName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMachNameTracker = true;
                                       } else {
                                          localMachNameTracker = false;
                                              
                                       }
                                   
                                            this.localMachName=param;
                                    

                               }
                            

                        /**
                        * field for GroupName
                        */

                        
                                    protected java.lang.String localGroupName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGroupNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getGroupName(){
                               return localGroupName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GroupName
                               */
                               public void setGroupName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localGroupNameTracker = true;
                                       } else {
                                          localGroupNameTracker = false;
                                              
                                       }
                                   
                                            this.localGroupName=param;
                                    

                               }
                            

                        /**
                        * field for Manufacturer
                        */

                        
                                    protected java.lang.String localManufacturer ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localManufacturerTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getManufacturer(){
                               return localManufacturer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Manufacturer
                               */
                               public void setManufacturer(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localManufacturerTracker = true;
                                       } else {
                                          localManufacturerTracker = false;
                                              
                                       }
                                   
                                            this.localManufacturer=param;
                                    

                               }
                            

                        /**
                        * field for ProductName
                        */

                        
                                    protected java.lang.String localProductName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localProductNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getProductName(){
                               return localProductName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ProductName
                               */
                               public void setProductName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localProductNameTracker = true;
                                       } else {
                                          localProductNameTracker = false;
                                              
                                       }
                                   
                                            this.localProductName=param;
                                    

                               }
                            

                        /**
                        * field for MachineVersion
                        */

                        
                                    protected java.lang.String localMachineVersion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMachineVersionTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMachineVersion(){
                               return localMachineVersion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MachineVersion
                               */
                               public void setMachineVersion(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMachineVersionTracker = true;
                                       } else {
                                          localMachineVersionTracker = false;
                                              
                                       }
                                   
                                            this.localMachineVersion=param;
                                    

                               }
                            

                        /**
                        * field for SysSerialNumber
                        */

                        
                                    protected java.lang.String localSysSerialNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSysSerialNumberTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSysSerialNumber(){
                               return localSysSerialNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SysSerialNumber
                               */
                               public void setSysSerialNumber(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSysSerialNumberTracker = true;
                                       } else {
                                          localSysSerialNumberTracker = false;
                                              
                                       }
                                   
                                            this.localSysSerialNumber=param;
                                    

                               }
                            

                        /**
                        * field for ChassisSerialNumber
                        */

                        
                                    protected java.lang.String localChassisSerialNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localChassisSerialNumberTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChassisSerialNumber(){
                               return localChassisSerialNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ChassisSerialNumber
                               */
                               public void setChassisSerialNumber(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localChassisSerialNumberTracker = true;
                                       } else {
                                          localChassisSerialNumberTracker = false;
                                              
                                       }
                                   
                                            this.localChassisSerialNumber=param;
                                    

                               }
                            

                        /**
                        * field for ChassisAssetTag
                        */

                        
                                    protected java.lang.String localChassisAssetTag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localChassisAssetTagTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChassisAssetTag(){
                               return localChassisAssetTag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ChassisAssetTag
                               */
                               public void setChassisAssetTag(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localChassisAssetTagTracker = true;
                                       } else {
                                          localChassisAssetTagTracker = false;
                                              
                                       }
                                   
                                            this.localChassisAssetTag=param;
                                    

                               }
                            

                        /**
                        * field for ChassisType
                        */

                        
                                    protected java.lang.String localChassisType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localChassisTypeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChassisType(){
                               return localChassisType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ChassisType
                               */
                               public void setChassisType(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localChassisTypeTracker = true;
                                       } else {
                                          localChassisTypeTracker = false;
                                              
                                       }
                                   
                                            this.localChassisType=param;
                                    

                               }
                            

                        /**
                        * field for BusSpeed
                        */

                        
                                    protected java.lang.String localBusSpeed ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBusSpeedTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBusSpeed(){
                               return localBusSpeed;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BusSpeed
                               */
                               public void setBusSpeed(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localBusSpeedTracker = true;
                                       } else {
                                          localBusSpeedTracker = false;
                                              
                                       }
                                   
                                            this.localBusSpeed=param;
                                    

                               }
                            

                        /**
                        * field for MaxMemorySize
                        */

                        
                                    protected java.lang.String localMaxMemorySize ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMaxMemorySizeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMaxMemorySize(){
                               return localMaxMemorySize;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MaxMemorySize
                               */
                               public void setMaxMemorySize(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMaxMemorySizeTracker = true;
                                       } else {
                                          localMaxMemorySizeTracker = false;
                                              
                                       }
                                   
                                            this.localMaxMemorySize=param;
                                    

                               }
                            

                        /**
                        * field for MaxMemorySlots
                        */

                        
                                    protected java.lang.String localMaxMemorySlots ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMaxMemorySlotsTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMaxMemorySlots(){
                               return localMaxMemorySlots;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MaxMemorySlots
                               */
                               public void setMaxMemorySlots(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMaxMemorySlotsTracker = true;
                                       } else {
                                          localMaxMemorySlotsTracker = false;
                                              
                                       }
                                   
                                            this.localMaxMemorySlots=param;
                                    

                               }
                            

                        /**
                        * field for ChassisManufacturer
                        */

                        
                                    protected java.lang.String localChassisManufacturer ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localChassisManufacturerTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChassisManufacturer(){
                               return localChassisManufacturer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ChassisManufacturer
                               */
                               public void setChassisManufacturer(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localChassisManufacturerTracker = true;
                                       } else {
                                          localChassisManufacturerTracker = false;
                                              
                                       }
                                   
                                            this.localChassisManufacturer=param;
                                    

                               }
                            

                        /**
                        * field for ChassisVersion
                        */

                        
                                    protected java.lang.String localChassisVersion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localChassisVersionTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getChassisVersion(){
                               return localChassisVersion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ChassisVersion
                               */
                               public void setChassisVersion(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localChassisVersionTracker = true;
                                       } else {
                                          localChassisVersionTracker = false;
                                              
                                       }
                                   
                                            this.localChassisVersion=param;
                                    

                               }
                            

                        /**
                        * field for MotherboardManufacturer
                        */

                        
                                    protected java.lang.String localMotherboardManufacturer ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMotherboardManufacturerTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMotherboardManufacturer(){
                               return localMotherboardManufacturer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MotherboardManufacturer
                               */
                               public void setMotherboardManufacturer(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMotherboardManufacturerTracker = true;
                                       } else {
                                          localMotherboardManufacturerTracker = false;
                                              
                                       }
                                   
                                            this.localMotherboardManufacturer=param;
                                    

                               }
                            

                        /**
                        * field for MotherboardProductCode
                        */

                        
                                    protected java.lang.String localMotherboardProductCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMotherboardProductCodeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMotherboardProductCode(){
                               return localMotherboardProductCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MotherboardProductCode
                               */
                               public void setMotherboardProductCode(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMotherboardProductCodeTracker = true;
                                       } else {
                                          localMotherboardProductCodeTracker = false;
                                              
                                       }
                                   
                                            this.localMotherboardProductCode=param;
                                    

                               }
                            

                        /**
                        * field for MotherboardVersion
                        */

                        
                                    protected java.lang.String localMotherboardVersion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMotherboardVersionTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMotherboardVersion(){
                               return localMotherboardVersion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MotherboardVersion
                               */
                               public void setMotherboardVersion(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMotherboardVersionTracker = true;
                                       } else {
                                          localMotherboardVersionTracker = false;
                                              
                                       }
                                   
                                            this.localMotherboardVersion=param;
                                    

                               }
                            

                        /**
                        * field for MotherboardSerialNumber
                        */

                        
                                    protected java.lang.String localMotherboardSerialNumber ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMotherboardSerialNumberTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMotherboardSerialNumber(){
                               return localMotherboardSerialNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MotherboardSerialNumber
                               */
                               public void setMotherboardSerialNumber(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMotherboardSerialNumberTracker = true;
                                       } else {
                                          localMotherboardSerialNumberTracker = false;
                                              
                                       }
                                   
                                            this.localMotherboardSerialNumber=param;
                                    

                               }
                            

                        /**
                        * field for ComputerName
                        */

                        
                                    protected java.lang.String localComputerName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localComputerNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getComputerName(){
                               return localComputerName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ComputerName
                               */
                               public void setComputerName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localComputerNameTracker = true;
                                       } else {
                                          localComputerNameTracker = false;
                                              
                                       }
                                   
                                            this.localComputerName=param;
                                    

                               }
                            

                        /**
                        * field for IpAddress
                        */

                        
                                    protected java.lang.String localIpAddress ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIpAddressTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIpAddress(){
                               return localIpAddress;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IpAddress
                               */
                               public void setIpAddress(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localIpAddressTracker = true;
                                       } else {
                                          localIpAddressTracker = false;
                                              
                                       }
                                   
                                            this.localIpAddress=param;
                                    

                               }
                            

                        /**
                        * field for SubnetMask
                        */

                        
                                    protected java.lang.String localSubnetMask ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSubnetMaskTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSubnetMask(){
                               return localSubnetMask;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SubnetMask
                               */
                               public void setSubnetMask(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSubnetMaskTracker = true;
                                       } else {
                                          localSubnetMaskTracker = false;
                                              
                                       }
                                   
                                            this.localSubnetMask=param;
                                    

                               }
                            

                        /**
                        * field for DefaultGateway
                        */

                        
                                    protected java.lang.String localDefaultGateway ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDefaultGatewayTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDefaultGateway(){
                               return localDefaultGateway;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DefaultGateway
                               */
                               public void setDefaultGateway(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDefaultGatewayTracker = true;
                                       } else {
                                          localDefaultGatewayTracker = false;
                                              
                                       }
                                   
                                            this.localDefaultGateway=param;
                                    

                               }
                            

                        /**
                        * field for DnsServer1
                        */

                        
                                    protected java.lang.String localDnsServer1 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDnsServer1Tracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDnsServer1(){
                               return localDnsServer1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DnsServer1
                               */
                               public void setDnsServer1(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDnsServer1Tracker = true;
                                       } else {
                                          localDnsServer1Tracker = false;
                                              
                                       }
                                   
                                            this.localDnsServer1=param;
                                    

                               }
                            

                        /**
                        * field for DnsServer2
                        */

                        
                                    protected java.lang.String localDnsServer2 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDnsServer2Tracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDnsServer2(){
                               return localDnsServer2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DnsServer2
                               */
                               public void setDnsServer2(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDnsServer2Tracker = true;
                                       } else {
                                          localDnsServer2Tracker = false;
                                              
                                       }
                                   
                                            this.localDnsServer2=param;
                                    

                               }
                            

                        /**
                        * field for DnsServer3
                        */

                        
                                    protected java.lang.String localDnsServer3 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDnsServer3Tracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDnsServer3(){
                               return localDnsServer3;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DnsServer3
                               */
                               public void setDnsServer3(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDnsServer3Tracker = true;
                                       } else {
                                          localDnsServer3Tracker = false;
                                              
                                       }
                                   
                                            this.localDnsServer3=param;
                                    

                               }
                            

                        /**
                        * field for DnsServer4
                        */

                        
                                    protected java.lang.String localDnsServer4 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDnsServer4Tracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDnsServer4(){
                               return localDnsServer4;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DnsServer4
                               */
                               public void setDnsServer4(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDnsServer4Tracker = true;
                                       } else {
                                          localDnsServer4Tracker = false;
                                              
                                       }
                                   
                                            this.localDnsServer4=param;
                                    

                               }
                            

                        /**
                        * field for DhcpEnabled
                        */

                        
                                    protected int localDhcpEnabled ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getDhcpEnabled(){
                               return localDhcpEnabled;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DhcpEnabled
                               */
                               public void setDhcpEnabled(int param){
                            
                                            this.localDhcpEnabled=param;
                                    

                               }
                            

                        /**
                        * field for DhcpServer
                        */

                        
                                    protected java.lang.String localDhcpServer ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDhcpServerTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDhcpServer(){
                               return localDhcpServer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DhcpServer
                               */
                               public void setDhcpServer(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDhcpServerTracker = true;
                                       } else {
                                          localDhcpServerTracker = false;
                                              
                                       }
                                   
                                            this.localDhcpServer=param;
                                    

                               }
                            

                        /**
                        * field for WinsEnabled
                        */

                        
                                    protected int localWinsEnabled ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getWinsEnabled(){
                               return localWinsEnabled;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WinsEnabled
                               */
                               public void setWinsEnabled(int param){
                            
                                            this.localWinsEnabled=param;
                                    

                               }
                            

                        /**
                        * field for PrimaryWinsServer
                        */

                        
                                    protected java.lang.String localPrimaryWinsServer ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPrimaryWinsServerTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPrimaryWinsServer(){
                               return localPrimaryWinsServer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PrimaryWinsServer
                               */
                               public void setPrimaryWinsServer(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPrimaryWinsServerTracker = true;
                                       } else {
                                          localPrimaryWinsServerTracker = false;
                                              
                                       }
                                   
                                            this.localPrimaryWinsServer=param;
                                    

                               }
                            

                        /**
                        * field for SecondaryWinsServer
                        */

                        
                                    protected java.lang.String localSecondaryWinsServer ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSecondaryWinsServerTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSecondaryWinsServer(){
                               return localSecondaryWinsServer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SecondaryWinsServer
                               */
                               public void setSecondaryWinsServer(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSecondaryWinsServerTracker = true;
                                       } else {
                                          localSecondaryWinsServerTracker = false;
                                              
                                       }
                                   
                                            this.localSecondaryWinsServer=param;
                                    

                               }
                            

                        /**
                        * field for ConnectionGatewayIp
                        */

                        
                                    protected java.lang.String localConnectionGatewayIp ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConnectionGatewayIpTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConnectionGatewayIp(){
                               return localConnectionGatewayIp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ConnectionGatewayIp
                               */
                               public void setConnectionGatewayIp(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localConnectionGatewayIpTracker = true;
                                       } else {
                                          localConnectionGatewayIpTracker = false;
                                              
                                       }
                                   
                                            this.localConnectionGatewayIp=param;
                                    

                               }
                            

                        /**
                        * field for OsType
                        */

                        
                                    protected java.lang.String localOsType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOsTypeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOsType(){
                               return localOsType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OsType
                               */
                               public void setOsType(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localOsTypeTracker = true;
                                       } else {
                                          localOsTypeTracker = false;
                                              
                                       }
                                   
                                            this.localOsType=param;
                                    

                               }
                            

                        /**
                        * field for OsInfo
                        */

                        
                                    protected java.lang.String localOsInfo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOsInfoTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOsInfo(){
                               return localOsInfo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OsInfo
                               */
                               public void setOsInfo(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localOsInfoTracker = true;
                                       } else {
                                          localOsInfoTracker = false;
                                              
                                       }
                                   
                                            this.localOsInfo=param;
                                    

                               }
                            

                        /**
                        * field for MajorVersion
                        */

                        
                                    protected int localMajorVersion ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getMajorVersion(){
                               return localMajorVersion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MajorVersion
                               */
                               public void setMajorVersion(int param){
                            
                                            this.localMajorVersion=param;
                                    

                               }
                            

                        /**
                        * field for MinorVersion
                        */

                        
                                    protected int localMinorVersion ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getMinorVersion(){
                               return localMinorVersion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MinorVersion
                               */
                               public void setMinorVersion(int param){
                            
                                            this.localMinorVersion=param;
                                    

                               }
                            

                        /**
                        * field for MacAddr
                        */

                        
                                    protected java.lang.String localMacAddr ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMacAddrTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMacAddr(){
                               return localMacAddr;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MacAddr
                               */
                               public void setMacAddr(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMacAddrTracker = true;
                                       } else {
                                          localMacAddrTracker = false;
                                              
                                       }
                                   
                                            this.localMacAddr=param;
                                    

                               }
                            

                        /**
                        * field for LoginName
                        */

                        
                                    protected java.lang.String localLoginName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLoginNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLoginName(){
                               return localLoginName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LoginName
                               */
                               public void setLoginName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localLoginNameTracker = true;
                                       } else {
                                          localLoginNameTracker = false;
                                              
                                       }
                                   
                                            this.localLoginName=param;
                                    

                               }
                            

                        /**
                        * field for FirstCheckin
                        */

                        
                                    protected java.util.Calendar localFirstCheckin ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getFirstCheckin(){
                               return localFirstCheckin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FirstCheckin
                               */
                               public void setFirstCheckin(java.util.Calendar param){
                            
                                            this.localFirstCheckin=param;
                                    

                               }
                            

                        /**
                        * field for LastCheckin
                        */

                        
                                    protected java.util.Calendar localLastCheckin ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getLastCheckin(){
                               return localLastCheckin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LastCheckin
                               */
                               public void setLastCheckin(java.util.Calendar param){
                            
                                            this.localLastCheckin=param;
                                    

                               }
                            

                        /**
                        * field for CurrentUser
                        */

                        
                                    protected java.lang.String localCurrentUser ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCurrentUserTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCurrentUser(){
                               return localCurrentUser;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CurrentUser
                               */
                               public void setCurrentUser(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCurrentUserTracker = true;
                                       } else {
                                          localCurrentUserTracker = false;
                                              
                                       }
                                   
                                            this.localCurrentUser=param;
                                    

                               }
                            

                        /**
                        * field for LastLoginName
                        */

                        
                                    protected java.lang.String localLastLoginName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLastLoginNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLastLoginName(){
                               return localLastLoginName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LastLoginName
                               */
                               public void setLastLoginName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localLastLoginNameTracker = true;
                                       } else {
                                          localLastLoginNameTracker = false;
                                              
                                       }
                                   
                                            this.localLastLoginName=param;
                                    

                               }
                            

                        /**
                        * field for LastReboot
                        */

                        
                                    protected java.util.Calendar localLastReboot ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getLastReboot(){
                               return localLastReboot;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LastReboot
                               */
                               public void setLastReboot(java.util.Calendar param){
                            
                                            this.localLastReboot=param;
                                    

                               }
                            

                        /**
                        * field for AgentVersion
                        */

                        
                                    protected int localAgentVersion ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getAgentVersion(){
                               return localAgentVersion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AgentVersion
                               */
                               public void setAgentVersion(int param){
                            
                                            this.localAgentVersion=param;
                                    

                               }
                            

                        /**
                        * field for ContactName
                        */

                        
                                    protected java.lang.String localContactName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localContactNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getContactName(){
                               return localContactName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ContactName
                               */
                               public void setContactName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localContactNameTracker = true;
                                       } else {
                                          localContactNameTracker = false;
                                              
                                       }
                                   
                                            this.localContactName=param;
                                    

                               }
                            

                        /**
                        * field for ContactEmail
                        */

                        
                                    protected java.lang.String localContactEmail ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localContactEmailTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getContactEmail(){
                               return localContactEmail;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ContactEmail
                               */
                               public void setContactEmail(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localContactEmailTracker = true;
                                       } else {
                                          localContactEmailTracker = false;
                                              
                                       }
                                   
                                            this.localContactEmail=param;
                                    

                               }
                            

                        /**
                        * field for ContactPhone
                        */

                        
                                    protected java.lang.String localContactPhone ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localContactPhoneTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getContactPhone(){
                               return localContactPhone;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ContactPhone
                               */
                               public void setContactPhone(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localContactPhoneTracker = true;
                                       } else {
                                          localContactPhoneTracker = false;
                                              
                                       }
                                   
                                            this.localContactPhone=param;
                                    

                               }
                            

                        /**
                        * field for ContactNotes
                        */

                        
                                    protected java.lang.String localContactNotes ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localContactNotesTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getContactNotes(){
                               return localContactNotes;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ContactNotes
                               */
                               public void setContactNotes(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localContactNotesTracker = true;
                                       } else {
                                          localContactNotesTracker = false;
                                              
                                       }
                                   
                                            this.localContactNotes=param;
                                    

                               }
                            

                        /**
                        * field for EnableTickets
                        */

                        
                                    protected int localEnableTickets ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getEnableTickets(){
                               return localEnableTickets;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EnableTickets
                               */
                               public void setEnableTickets(int param){
                            
                                            this.localEnableTickets=param;
                                    

                               }
                            

                        /**
                        * field for EnableRemoteControl
                        */

                        
                                    protected int localEnableRemoteControl ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getEnableRemoteControl(){
                               return localEnableRemoteControl;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EnableRemoteControl
                               */
                               public void setEnableRemoteControl(int param){
                            
                                            this.localEnableRemoteControl=param;
                                    

                               }
                            

                        /**
                        * field for EnableChat
                        */

                        
                                    protected int localEnableChat ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getEnableChat(){
                               return localEnableChat;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EnableChat
                               */
                               public void setEnableChat(int param){
                            
                                            this.localEnableChat=param;
                                    

                               }
                            

                        /**
                        * field for CredentialName
                        */

                        
                                    protected java.lang.String localCredentialName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCredentialNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCredentialName(){
                               return localCredentialName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CredentialName
                               */
                               public void setCredentialName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCredentialNameTracker = true;
                                       } else {
                                          localCredentialNameTracker = false;
                                              
                                       }
                                   
                                            this.localCredentialName=param;
                                    

                               }
                            

                        /**
                        * field for PrimaryKServer
                        */

                        
                                    protected java.lang.String localPrimaryKServer ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPrimaryKServerTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPrimaryKServer(){
                               return localPrimaryKServer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PrimaryKServer
                               */
                               public void setPrimaryKServer(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPrimaryKServerTracker = true;
                                       } else {
                                          localPrimaryKServerTracker = false;
                                              
                                       }
                                   
                                            this.localPrimaryKServer=param;
                                    

                               }
                            

                        /**
                        * field for SecondaryKServer
                        */

                        
                                    protected java.lang.String localSecondaryKServer ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSecondaryKServerTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSecondaryKServer(){
                               return localSecondaryKServer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SecondaryKServer
                               */
                               public void setSecondaryKServer(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSecondaryKServerTracker = true;
                                       } else {
                                          localSecondaryKServerTracker = false;
                                              
                                       }
                                   
                                            this.localSecondaryKServer=param;
                                    

                               }
                            

                        /**
                        * field for QuickCheckinSecs
                        */

                        
                                    protected int localQuickCheckinSecs ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getQuickCheckinSecs(){
                               return localQuickCheckinSecs;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param QuickCheckinSecs
                               */
                               public void setQuickCheckinSecs(int param){
                            
                                            this.localQuickCheckinSecs=param;
                                    

                               }
                            

                        /**
                        * field for AgentTempDir
                        */

                        
                                    protected java.lang.String localAgentTempDir ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAgentTempDirTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAgentTempDir(){
                               return localAgentTempDir;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AgentTempDir
                               */
                               public void setAgentTempDir(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAgentTempDirTracker = true;
                                       } else {
                                          localAgentTempDirTracker = false;
                                              
                                       }
                                   
                                            this.localAgentTempDir=param;
                                    

                               }
                            

                        /**
                        * field for CPUs
                        */

                        
                                    protected kaseyaws.ArrayOfCPU localCPUs ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCPUsTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return kaseyaws.ArrayOfCPU
                           */
                           public  kaseyaws.ArrayOfCPU getCPUs(){
                               return localCPUs;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CPUs
                               */
                               public void setCPUs(kaseyaws.ArrayOfCPU param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCPUsTracker = true;
                                       } else {
                                          localCPUsTracker = false;
                                              
                                       }
                                   
                                            this.localCPUs=param;
                                    

                               }
                            

                        /**
                        * field for Disks
                        */

                        
                                    protected kaseyaws.ArrayOfDisk localDisks ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDisksTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return kaseyaws.ArrayOfDisk
                           */
                           public  kaseyaws.ArrayOfDisk getDisks(){
                               return localDisks;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Disks
                               */
                               public void setDisks(kaseyaws.ArrayOfDisk param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDisksTracker = true;
                                       } else {
                                          localDisksTracker = false;
                                              
                                       }
                                   
                                            this.localDisks=param;
                                    

                               }
                            

                        /**
                        * field for Method
                        */

                        
                                    protected java.lang.String localMethod ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMethodTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMethod(){
                               return localMethod;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Method
                               */
                               public void setMethod(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMethodTracker = true;
                                       } else {
                                          localMethodTracker = false;
                                              
                                       }
                                   
                                            this.localMethod=param;
                                    

                               }
                            

                        /**
                        * field for TransactionID
                        */

                        
                                    protected java.math.BigDecimal localTransactionID ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.math.BigDecimal
                           */
                           public  java.math.BigDecimal getTransactionID(){
                               return localTransactionID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TransactionID
                               */
                               public void setTransactionID(java.math.BigDecimal param){
                            
                                            this.localTransactionID=param;
                                    

                               }
                            

                        /**
                        * field for ErrorMessage
                        */

                        
                                    protected java.lang.String localErrorMessage ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localErrorMessageTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getErrorMessage(){
                               return localErrorMessage;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ErrorMessage
                               */
                               public void setErrorMessage(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localErrorMessageTracker = true;
                                       } else {
                                          localErrorMessageTracker = false;
                                              
                                       }
                                   
                                            this.localErrorMessage=param;
                                    

                               }
                            

                        /**
                        * field for ErrorLocation
                        */

                        
                                    protected java.lang.String localErrorLocation ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localErrorLocationTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getErrorLocation(){
                               return localErrorLocation;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ErrorLocation
                               */
                               public void setErrorLocation(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localErrorLocationTracker = true;
                                       } else {
                                          localErrorLocationTracker = false;
                                              
                                       }
                                   
                                            this.localErrorLocation=param;
                                    

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
                       GetMachineResponse.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":GetMachineResponse",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "GetMachineResponse",
                           xmlWriter);
                   }

                if (localMachine_GroupIDTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Machine_GroupID", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Machine_GroupID");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Machine_GroupID");
                                    }
                                

                                          if (localMachine_GroupID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Machine_GroupID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMachine_GroupID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"agentGuid", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"agentGuid");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("agentGuid");
                                    }
                                

                                          if (localAgentGuid==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("agentGuid cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAgentGuid));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localMachNameTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"machName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"machName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("machName");
                                    }
                                

                                          if (localMachName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("machName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMachName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localGroupNameTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"groupName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"groupName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("groupName");
                                    }
                                

                                          if (localGroupName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("groupName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localGroupName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localManufacturerTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Manufacturer", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Manufacturer");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Manufacturer");
                                    }
                                

                                          if (localManufacturer==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Manufacturer cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localManufacturer);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localProductNameTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ProductName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ProductName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ProductName");
                                    }
                                

                                          if (localProductName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ProductName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localProductName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMachineVersionTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MachineVersion", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MachineVersion");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MachineVersion");
                                    }
                                

                                          if (localMachineVersion==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MachineVersion cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMachineVersion);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSysSerialNumberTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SysSerialNumber", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SysSerialNumber");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SysSerialNumber");
                                    }
                                

                                          if (localSysSerialNumber==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SysSerialNumber cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSysSerialNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localChassisSerialNumberTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ChassisSerialNumber", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ChassisSerialNumber");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ChassisSerialNumber");
                                    }
                                

                                          if (localChassisSerialNumber==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ChassisSerialNumber cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localChassisSerialNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localChassisAssetTagTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ChassisAssetTag", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ChassisAssetTag");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ChassisAssetTag");
                                    }
                                

                                          if (localChassisAssetTag==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ChassisAssetTag cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localChassisAssetTag);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localChassisTypeTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ChassisType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ChassisType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ChassisType");
                                    }
                                

                                          if (localChassisType==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ChassisType cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localChassisType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBusSpeedTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"BusSpeed", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"BusSpeed");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("BusSpeed");
                                    }
                                

                                          if (localBusSpeed==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("BusSpeed cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBusSpeed);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMaxMemorySizeTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MaxMemorySize", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MaxMemorySize");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MaxMemorySize");
                                    }
                                

                                          if (localMaxMemorySize==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MaxMemorySize cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMaxMemorySize);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMaxMemorySlotsTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MaxMemorySlots", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MaxMemorySlots");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MaxMemorySlots");
                                    }
                                

                                          if (localMaxMemorySlots==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MaxMemorySlots cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMaxMemorySlots);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localChassisManufacturerTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ChassisManufacturer", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ChassisManufacturer");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ChassisManufacturer");
                                    }
                                

                                          if (localChassisManufacturer==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ChassisManufacturer cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localChassisManufacturer);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localChassisVersionTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ChassisVersion", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ChassisVersion");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ChassisVersion");
                                    }
                                

                                          if (localChassisVersion==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ChassisVersion cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localChassisVersion);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMotherboardManufacturerTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MotherboardManufacturer", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MotherboardManufacturer");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MotherboardManufacturer");
                                    }
                                

                                          if (localMotherboardManufacturer==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MotherboardManufacturer cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMotherboardManufacturer);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMotherboardProductCodeTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MotherboardProductCode", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MotherboardProductCode");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MotherboardProductCode");
                                    }
                                

                                          if (localMotherboardProductCode==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MotherboardProductCode cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMotherboardProductCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMotherboardVersionTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MotherboardVersion", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MotherboardVersion");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MotherboardVersion");
                                    }
                                

                                          if (localMotherboardVersion==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MotherboardVersion cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMotherboardVersion);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMotherboardSerialNumberTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MotherboardSerialNumber", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MotherboardSerialNumber");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MotherboardSerialNumber");
                                    }
                                

                                          if (localMotherboardSerialNumber==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MotherboardSerialNumber cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMotherboardSerialNumber);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localComputerNameTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ComputerName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ComputerName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ComputerName");
                                    }
                                

                                          if (localComputerName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ComputerName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localComputerName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIpAddressTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"IpAddress", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"IpAddress");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("IpAddress");
                                    }
                                

                                          if (localIpAddress==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("IpAddress cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIpAddress);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSubnetMaskTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SubnetMask", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SubnetMask");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SubnetMask");
                                    }
                                

                                          if (localSubnetMask==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SubnetMask cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSubnetMask);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDefaultGatewayTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DefaultGateway", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DefaultGateway");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DefaultGateway");
                                    }
                                

                                          if (localDefaultGateway==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DefaultGateway cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDefaultGateway);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDnsServer1Tracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DnsServer1", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DnsServer1");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DnsServer1");
                                    }
                                

                                          if (localDnsServer1==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DnsServer1 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDnsServer1);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDnsServer2Tracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DnsServer2", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DnsServer2");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DnsServer2");
                                    }
                                

                                          if (localDnsServer2==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DnsServer2 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDnsServer2);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDnsServer3Tracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DnsServer3", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DnsServer3");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DnsServer3");
                                    }
                                

                                          if (localDnsServer3==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DnsServer3 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDnsServer3);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDnsServer4Tracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DnsServer4", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DnsServer4");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DnsServer4");
                                    }
                                

                                          if (localDnsServer4==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DnsServer4 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDnsServer4);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DhcpEnabled", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DhcpEnabled");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DhcpEnabled");
                                    }
                                
                                               if (localDhcpEnabled==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("DhcpEnabled cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDhcpEnabled));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localDhcpServerTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"DhcpServer", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"DhcpServer");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("DhcpServer");
                                    }
                                

                                          if (localDhcpServer==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("DhcpServer cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDhcpServer);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"WinsEnabled", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"WinsEnabled");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("WinsEnabled");
                                    }
                                
                                               if (localWinsEnabled==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("WinsEnabled cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWinsEnabled));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localPrimaryWinsServerTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"PrimaryWinsServer", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"PrimaryWinsServer");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("PrimaryWinsServer");
                                    }
                                

                                          if (localPrimaryWinsServer==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("PrimaryWinsServer cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPrimaryWinsServer);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSecondaryWinsServerTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SecondaryWinsServer", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SecondaryWinsServer");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SecondaryWinsServer");
                                    }
                                

                                          if (localSecondaryWinsServer==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SecondaryWinsServer cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSecondaryWinsServer);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConnectionGatewayIpTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ConnectionGatewayIp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ConnectionGatewayIp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ConnectionGatewayIp");
                                    }
                                

                                          if (localConnectionGatewayIp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ConnectionGatewayIp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConnectionGatewayIp);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOsTypeTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"OsType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"OsType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("OsType");
                                    }
                                

                                          if (localOsType==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("OsType cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOsType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOsInfoTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"OsInfo", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"OsInfo");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("OsInfo");
                                    }
                                

                                          if (localOsInfo==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("OsInfo cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOsInfo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MajorVersion", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MajorVersion");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MajorVersion");
                                    }
                                
                                               if (localMajorVersion==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("MajorVersion cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMajorVersion));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MinorVersion", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MinorVersion");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MinorVersion");
                                    }
                                
                                               if (localMinorVersion==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("MinorVersion cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMinorVersion));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localMacAddrTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MacAddr", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MacAddr");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MacAddr");
                                    }
                                

                                          if (localMacAddr==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MacAddr cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMacAddr);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLoginNameTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"LoginName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"LoginName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("LoginName");
                                    }
                                

                                          if (localLoginName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("LoginName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLoginName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"firstCheckin", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"firstCheckin");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("firstCheckin");
                                    }
                                

                                          if (localFirstCheckin==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("firstCheckin cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFirstCheckin));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"lastCheckin", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"lastCheckin");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("lastCheckin");
                                    }
                                

                                          if (localLastCheckin==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("lastCheckin cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastCheckin));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localCurrentUserTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"currentUser", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"currentUser");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("currentUser");
                                    }
                                

                                          if (localCurrentUser==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("currentUser cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCurrentUser);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLastLoginNameTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"lastLoginName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"lastLoginName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("lastLoginName");
                                    }
                                

                                          if (localLastLoginName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("lastLoginName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLastLoginName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"lastReboot", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"lastReboot");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("lastReboot");
                                    }
                                

                                          if (localLastReboot==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("lastReboot cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastReboot));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"agentVersion", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"agentVersion");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("agentVersion");
                                    }
                                
                                               if (localAgentVersion==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("agentVersion cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAgentVersion));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localContactNameTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"contactName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"contactName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("contactName");
                                    }
                                

                                          if (localContactName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("contactName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localContactName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localContactEmailTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"contactEmail", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"contactEmail");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("contactEmail");
                                    }
                                

                                          if (localContactEmail==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("contactEmail cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localContactEmail);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localContactPhoneTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"contactPhone", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"contactPhone");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("contactPhone");
                                    }
                                

                                          if (localContactPhone==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("contactPhone cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localContactPhone);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localContactNotesTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"contactNotes", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"contactNotes");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("contactNotes");
                                    }
                                

                                          if (localContactNotes==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("contactNotes cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localContactNotes);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"enableTickets", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"enableTickets");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("enableTickets");
                                    }
                                
                                               if (localEnableTickets==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("enableTickets cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEnableTickets));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"enableRemoteControl", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"enableRemoteControl");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("enableRemoteControl");
                                    }
                                
                                               if (localEnableRemoteControl==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("enableRemoteControl cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEnableRemoteControl));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"enableChat", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"enableChat");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("enableChat");
                                    }
                                
                                               if (localEnableChat==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("enableChat cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEnableChat));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localCredentialNameTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"credentialName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"credentialName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("credentialName");
                                    }
                                

                                          if (localCredentialName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("credentialName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCredentialName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPrimaryKServerTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"primaryKServer", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"primaryKServer");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("primaryKServer");
                                    }
                                

                                          if (localPrimaryKServer==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("primaryKServer cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPrimaryKServer);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSecondaryKServerTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"secondaryKServer", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"secondaryKServer");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("secondaryKServer");
                                    }
                                

                                          if (localSecondaryKServer==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("secondaryKServer cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSecondaryKServer);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"quickCheckinSecs", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"quickCheckinSecs");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("quickCheckinSecs");
                                    }
                                
                                               if (localQuickCheckinSecs==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("quickCheckinSecs cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuickCheckinSecs));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localAgentTempDirTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"agentTempDir", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"agentTempDir");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("agentTempDir");
                                    }
                                

                                          if (localAgentTempDir==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("agentTempDir cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAgentTempDir);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCPUsTracker){
                                            if (localCPUs==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CPUs cannot be null!!");
                                            }
                                           localCPUs.serialize(new javax.xml.namespace.QName("KaseyaWS","CPUs"),
                                               factory,xmlWriter);
                                        } if (localDisksTracker){
                                            if (localDisks==null){
                                                 throw new org.apache.axis2.databinding.ADBException("Disks cannot be null!!");
                                            }
                                           localDisks.serialize(new javax.xml.namespace.QName("KaseyaWS","Disks"),
                                               factory,xmlWriter);
                                        } if (localMethodTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Method", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Method");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Method");
                                    }
                                

                                          if (localMethod==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Method cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMethod);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"TransactionID", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"TransactionID");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("TransactionID");
                                    }
                                

                                          if (localTransactionID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("TransactionID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTransactionID));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localErrorMessageTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ErrorMessage", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ErrorMessage");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ErrorMessage");
                                    }
                                

                                          if (localErrorMessage==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ErrorMessage cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localErrorMessage);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localErrorLocationTracker){
                                    namespace = "KaseyaWS";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ErrorLocation", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ErrorLocation");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ErrorLocation");
                                    }
                                

                                          if (localErrorLocation==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ErrorLocation cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localErrorLocation);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
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
                    attribList.add(new javax.xml.namespace.QName("KaseyaWS","GetMachineResponse"));
                 if (localMachine_GroupIDTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "Machine_GroupID"));
                                 
                                        if (localMachine_GroupID != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMachine_GroupID));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("Machine_GroupID cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "agentGuid"));
                                 
                                        if (localAgentGuid != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAgentGuid));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("agentGuid cannot be null!!");
                                        }
                                     if (localMachNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "machName"));
                                 
                                        if (localMachName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMachName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("machName cannot be null!!");
                                        }
                                    } if (localGroupNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "groupName"));
                                 
                                        if (localGroupName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGroupName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("groupName cannot be null!!");
                                        }
                                    } if (localManufacturerTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "Manufacturer"));
                                 
                                        if (localManufacturer != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localManufacturer));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("Manufacturer cannot be null!!");
                                        }
                                    } if (localProductNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "ProductName"));
                                 
                                        if (localProductName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProductName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ProductName cannot be null!!");
                                        }
                                    } if (localMachineVersionTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "MachineVersion"));
                                 
                                        if (localMachineVersion != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMachineVersion));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("MachineVersion cannot be null!!");
                                        }
                                    } if (localSysSerialNumberTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "SysSerialNumber"));
                                 
                                        if (localSysSerialNumber != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSysSerialNumber));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SysSerialNumber cannot be null!!");
                                        }
                                    } if (localChassisSerialNumberTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "ChassisSerialNumber"));
                                 
                                        if (localChassisSerialNumber != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChassisSerialNumber));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ChassisSerialNumber cannot be null!!");
                                        }
                                    } if (localChassisAssetTagTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "ChassisAssetTag"));
                                 
                                        if (localChassisAssetTag != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChassisAssetTag));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ChassisAssetTag cannot be null!!");
                                        }
                                    } if (localChassisTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "ChassisType"));
                                 
                                        if (localChassisType != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChassisType));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ChassisType cannot be null!!");
                                        }
                                    } if (localBusSpeedTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "BusSpeed"));
                                 
                                        if (localBusSpeed != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBusSpeed));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("BusSpeed cannot be null!!");
                                        }
                                    } if (localMaxMemorySizeTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "MaxMemorySize"));
                                 
                                        if (localMaxMemorySize != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxMemorySize));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("MaxMemorySize cannot be null!!");
                                        }
                                    } if (localMaxMemorySlotsTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "MaxMemorySlots"));
                                 
                                        if (localMaxMemorySlots != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaxMemorySlots));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("MaxMemorySlots cannot be null!!");
                                        }
                                    } if (localChassisManufacturerTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "ChassisManufacturer"));
                                 
                                        if (localChassisManufacturer != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChassisManufacturer));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ChassisManufacturer cannot be null!!");
                                        }
                                    } if (localChassisVersionTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "ChassisVersion"));
                                 
                                        if (localChassisVersion != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localChassisVersion));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ChassisVersion cannot be null!!");
                                        }
                                    } if (localMotherboardManufacturerTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "MotherboardManufacturer"));
                                 
                                        if (localMotherboardManufacturer != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMotherboardManufacturer));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("MotherboardManufacturer cannot be null!!");
                                        }
                                    } if (localMotherboardProductCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "MotherboardProductCode"));
                                 
                                        if (localMotherboardProductCode != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMotherboardProductCode));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("MotherboardProductCode cannot be null!!");
                                        }
                                    } if (localMotherboardVersionTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "MotherboardVersion"));
                                 
                                        if (localMotherboardVersion != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMotherboardVersion));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("MotherboardVersion cannot be null!!");
                                        }
                                    } if (localMotherboardSerialNumberTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "MotherboardSerialNumber"));
                                 
                                        if (localMotherboardSerialNumber != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMotherboardSerialNumber));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("MotherboardSerialNumber cannot be null!!");
                                        }
                                    } if (localComputerNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "ComputerName"));
                                 
                                        if (localComputerName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComputerName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ComputerName cannot be null!!");
                                        }
                                    } if (localIpAddressTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "IpAddress"));
                                 
                                        if (localIpAddress != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIpAddress));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("IpAddress cannot be null!!");
                                        }
                                    } if (localSubnetMaskTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "SubnetMask"));
                                 
                                        if (localSubnetMask != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSubnetMask));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SubnetMask cannot be null!!");
                                        }
                                    } if (localDefaultGatewayTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "DefaultGateway"));
                                 
                                        if (localDefaultGateway != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDefaultGateway));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DefaultGateway cannot be null!!");
                                        }
                                    } if (localDnsServer1Tracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "DnsServer1"));
                                 
                                        if (localDnsServer1 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDnsServer1));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DnsServer1 cannot be null!!");
                                        }
                                    } if (localDnsServer2Tracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "DnsServer2"));
                                 
                                        if (localDnsServer2 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDnsServer2));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DnsServer2 cannot be null!!");
                                        }
                                    } if (localDnsServer3Tracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "DnsServer3"));
                                 
                                        if (localDnsServer3 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDnsServer3));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DnsServer3 cannot be null!!");
                                        }
                                    } if (localDnsServer4Tracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "DnsServer4"));
                                 
                                        if (localDnsServer4 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDnsServer4));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DnsServer4 cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "DhcpEnabled"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDhcpEnabled));
                             if (localDhcpServerTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "DhcpServer"));
                                 
                                        if (localDhcpServer != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDhcpServer));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("DhcpServer cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "WinsEnabled"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWinsEnabled));
                             if (localPrimaryWinsServerTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "PrimaryWinsServer"));
                                 
                                        if (localPrimaryWinsServer != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPrimaryWinsServer));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("PrimaryWinsServer cannot be null!!");
                                        }
                                    } if (localSecondaryWinsServerTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "SecondaryWinsServer"));
                                 
                                        if (localSecondaryWinsServer != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSecondaryWinsServer));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SecondaryWinsServer cannot be null!!");
                                        }
                                    } if (localConnectionGatewayIpTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "ConnectionGatewayIp"));
                                 
                                        if (localConnectionGatewayIp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localConnectionGatewayIp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ConnectionGatewayIp cannot be null!!");
                                        }
                                    } if (localOsTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "OsType"));
                                 
                                        if (localOsType != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOsType));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("OsType cannot be null!!");
                                        }
                                    } if (localOsInfoTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "OsInfo"));
                                 
                                        if (localOsInfo != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOsInfo));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("OsInfo cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "MajorVersion"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMajorVersion));
                            
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "MinorVersion"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMinorVersion));
                             if (localMacAddrTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "MacAddr"));
                                 
                                        if (localMacAddr != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMacAddr));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("MacAddr cannot be null!!");
                                        }
                                    } if (localLoginNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "LoginName"));
                                 
                                        if (localLoginName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLoginName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("LoginName cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "firstCheckin"));
                                 
                                        if (localFirstCheckin != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFirstCheckin));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("firstCheckin cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "lastCheckin"));
                                 
                                        if (localLastCheckin != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastCheckin));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("lastCheckin cannot be null!!");
                                        }
                                     if (localCurrentUserTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "currentUser"));
                                 
                                        if (localCurrentUser != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCurrentUser));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("currentUser cannot be null!!");
                                        }
                                    } if (localLastLoginNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "lastLoginName"));
                                 
                                        if (localLastLoginName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastLoginName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("lastLoginName cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "lastReboot"));
                                 
                                        if (localLastReboot != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLastReboot));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("lastReboot cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "agentVersion"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAgentVersion));
                             if (localContactNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "contactName"));
                                 
                                        if (localContactName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localContactName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("contactName cannot be null!!");
                                        }
                                    } if (localContactEmailTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "contactEmail"));
                                 
                                        if (localContactEmail != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localContactEmail));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("contactEmail cannot be null!!");
                                        }
                                    } if (localContactPhoneTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "contactPhone"));
                                 
                                        if (localContactPhone != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localContactPhone));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("contactPhone cannot be null!!");
                                        }
                                    } if (localContactNotesTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "contactNotes"));
                                 
                                        if (localContactNotes != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localContactNotes));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("contactNotes cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "enableTickets"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEnableTickets));
                            
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "enableRemoteControl"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEnableRemoteControl));
                            
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "enableChat"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEnableChat));
                             if (localCredentialNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "credentialName"));
                                 
                                        if (localCredentialName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCredentialName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("credentialName cannot be null!!");
                                        }
                                    } if (localPrimaryKServerTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "primaryKServer"));
                                 
                                        if (localPrimaryKServer != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPrimaryKServer));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("primaryKServer cannot be null!!");
                                        }
                                    } if (localSecondaryKServerTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "secondaryKServer"));
                                 
                                        if (localSecondaryKServer != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSecondaryKServer));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("secondaryKServer cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "quickCheckinSecs"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQuickCheckinSecs));
                             if (localAgentTempDirTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "agentTempDir"));
                                 
                                        if (localAgentTempDir != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAgentTempDir));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("agentTempDir cannot be null!!");
                                        }
                                    } if (localCPUsTracker){
                            elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "CPUs"));
                            
                            
                                    if (localCPUs==null){
                                         throw new org.apache.axis2.databinding.ADBException("CPUs cannot be null!!");
                                    }
                                    elementList.add(localCPUs);
                                } if (localDisksTracker){
                            elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "Disks"));
                            
                            
                                    if (localDisks==null){
                                         throw new org.apache.axis2.databinding.ADBException("Disks cannot be null!!");
                                    }
                                    elementList.add(localDisks);
                                } if (localMethodTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "Method"));
                                 
                                        if (localMethod != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMethod));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("Method cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "TransactionID"));
                                 
                                        if (localTransactionID != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTransactionID));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("TransactionID cannot be null!!");
                                        }
                                     if (localErrorMessageTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "ErrorMessage"));
                                 
                                        if (localErrorMessage != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorMessage));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ErrorMessage cannot be null!!");
                                        }
                                    } if (localErrorLocationTracker){
                                      elementList.add(new javax.xml.namespace.QName("KaseyaWS",
                                                                      "ErrorLocation"));
                                 
                                        if (localErrorLocation != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorLocation));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ErrorLocation cannot be null!!");
                                        }
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
        public static GetMachineResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            GetMachineResponse object =
                new GetMachineResponse();

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
                    
                            if (!"GetMachineResponse".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (GetMachineResponse)kaseyaws.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","Machine_GroupID").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMachine_GroupID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","agentGuid").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAgentGuid(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","machName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMachName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","groupName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setGroupName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","Manufacturer").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setManufacturer(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","ProductName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setProductName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","MachineVersion").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMachineVersion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","SysSerialNumber").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSysSerialNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","ChassisSerialNumber").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setChassisSerialNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","ChassisAssetTag").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setChassisAssetTag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","ChassisType").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setChassisType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","BusSpeed").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBusSpeed(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","MaxMemorySize").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMaxMemorySize(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","MaxMemorySlots").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMaxMemorySlots(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","ChassisManufacturer").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setChassisManufacturer(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","ChassisVersion").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setChassisVersion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","MotherboardManufacturer").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMotherboardManufacturer(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","MotherboardProductCode").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMotherboardProductCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","MotherboardVersion").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMotherboardVersion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","MotherboardSerialNumber").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMotherboardSerialNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","ComputerName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setComputerName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","IpAddress").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIpAddress(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","SubnetMask").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSubnetMask(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","DefaultGateway").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDefaultGateway(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","DnsServer1").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDnsServer1(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","DnsServer2").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDnsServer2(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","DnsServer3").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDnsServer3(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","DnsServer4").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDnsServer4(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","DhcpEnabled").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDhcpEnabled(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","DhcpServer").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDhcpServer(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","WinsEnabled").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setWinsEnabled(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","PrimaryWinsServer").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPrimaryWinsServer(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","SecondaryWinsServer").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSecondaryWinsServer(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","ConnectionGatewayIp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConnectionGatewayIp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","OsType").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOsType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","OsInfo").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOsInfo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","MajorVersion").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMajorVersion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","MinorVersion").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMinorVersion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","MacAddr").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMacAddr(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","LoginName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLoginName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","firstCheckin").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFirstCheckin(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","lastCheckin").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLastCheckin(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","currentUser").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCurrentUser(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","lastLoginName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLastLoginName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","lastReboot").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLastReboot(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","agentVersion").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAgentVersion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","contactName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setContactName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","contactEmail").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setContactEmail(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","contactPhone").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setContactPhone(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","contactNotes").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setContactNotes(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","enableTickets").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEnableTickets(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","enableRemoteControl").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEnableRemoteControl(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","enableChat").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEnableChat(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","credentialName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCredentialName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","primaryKServer").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPrimaryKServer(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","secondaryKServer").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSecondaryKServer(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","quickCheckinSecs").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setQuickCheckinSecs(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","agentTempDir").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAgentTempDir(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","CPUs").equals(reader.getName())){
                                
                                                object.setCPUs(kaseyaws.ArrayOfCPU.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","Disks").equals(reader.getName())){
                                
                                                object.setDisks(kaseyaws.ArrayOfDisk.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","Method").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMethod(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","TransactionID").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTransactionID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDecimal(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","ErrorMessage").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setErrorMessage(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("KaseyaWS","ErrorLocation").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setErrorLocation(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
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
           
          