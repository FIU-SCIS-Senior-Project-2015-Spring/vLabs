#!/bin/bash

# READ THIS FIRST!!!
#
# Before running make sure that:
#
# - This is an ubuntu server 14.04 and over
# - This file is an executable file
# - A default installation of Guacamole is already in place



# CHANGE THIS VARIABLES TO REFLECT THE VERSIONS INSTALLED IN THIS SERVER
TOMCAT=tomcat7  # the tomcat version installed in this server
GUACAMOLE_VERSION=0.9.7  # the Guacamole version installed in this server

# the Guacamole configuration file
GUACAMOLE_PROPERTIES=guacamole.properties

# guacamole_auth_url.jar file names
GUACAMOLE_JAR_WITH_VERSION=guacamole-auth-url-1.0-SNAPSHOT.jar
GUACAMOLE_JAR=guacamole-auth-url.jar

# guacamole .war names 
GUACAMOLE_WAR_WITH_VERSION="guacamole-${GUACAMOLE_VERSION}.war"
GUACAMOLE_WAR=guacamole.war

# folders that need to be created to setup Guacamole
GUACAMOLE_ETC_FOLDER=/etc/guacamole/
GUACAMOLE_VAR_LIB_FOLDER=/var/lib/guacamole/
GUACAMOLE_CLASSPATH="${GUACAMOLE_VAR_LIB_FOLDER}classpath/"
GUACAMOLE_USR_SHARE_FOLDER=/usr/share/$TOMCAT/.guacamole/
GUACAMOLE_WEBAPPS_FOLDER=/var/lib/$TOMCAT/webapps/



# abort on error
set -e
set -o pipefail



# welcome message
echo -e "\n\n"
echo -e "-------------------------------------------------------------------------------"
echo -e "guacamole-auth-url Installer"
echo -e ""
echo -e "This installer copies the required guacamole configuration files and restart"
echo -e "services after it is done"
echo -e "-------------------------------------------------------------------------------"
echo -e ""


#---------------------------------------
# FIRST PART: CONFIGURE GUACAMOLE SERVER 
#---------------------------------------

# copy guacamole.properties to its required location
echo -e "Copying guacamole.properties..."
mkdir -p $GUACAMOLE_ETC_FOLDER  # create folder if not present
cp $GUACAMOLE_PROPERTIES $GUACAMOLE_ETC_FOLDER

# create soft link to guacamole.properties 
echo -e "Creating softlink to guacamole.properties..."
mkdir -p $GUACAMOLE_USR_SHARE_FOLDER
# remove link if exists, and re-create it
if [ -f $GUACAMOLE_USR_SHARE_FOLDER$GUACAMOLE_PROPERTIES ]; then
	rm $GUACAMOLE_USR_SHARE_FOLDER$GUACAMOLE_PROPERTIES
fi
ln -s $GUACAMOLE_ETC_FOLDER$GUACAMOLE_PROPERTIES $GUACAMOLE_USR_SHARE_FOLDER$GUACAMOLE_PROPERTIES 


# this installation (guacamole-auth-url) does not need a user-mapping.xml file


#-----------------------------------------
# SECOND PART: CONFIGURE GUACAMOLE WEB APP
#-----------------------------------------

# copy the .war web application to its required location
echo -e "Copying guacamole.war file..."
mkdir -p $GUACAMOLE_VAR_LIB_FOLDER  # create folder if not present
# rename the file to remove the version and place it in its destination
cp $GUACAMOLE_WAR_WITH_VERSION $GUACAMOLE_VAR_LIB_FOLDER$GUACAMOLE_WAR 

# create soft link to guacamole.war
echo -e "Creating softlink to guacamole.war"
mkdir -p $GUACAMOLE_WEBAPPS_FOLDER  # create folder if not present
# delete link if present, then create link
if [ -f $GUACAMOLE_WEBAPPS_FOLDER$GUACAMOLE_WAR ]; then
	rm $GUACAMOLE_WEBAPPS_FOLDER$GUACAMOLE_WAR  
fi
ln -s $GUACAMOLE_VAR_LIB_FOLDER$GUACAMOLE_WAR $GUACAMOLE_WEBAPPS_FOLDER$GUACAMOLE_WAR  



#---------------------------------
# THIRD PART: CONFIGURE THE PLUGIN
#---------------------------------

# copy the guacamole-auth-url.jar file to its required location
echo -e "Copying guacamole auth jar file..."
mkdir -p $GUACAMOLE_CLASSPATH  # create folder if it does not exist
# rename jar file to remove version and copy it to the folder just created
cp $GUACAMOLE_JAR_WITH_VERSION $GUACAMOLE_CLASSPATH$GUACAMOLE_JAR 



# restart tomcat and guac
echo -e "\n\nRestaring Tomcat..."
/etc/init.d/$TOMCAT restart
/etc/init.d/guacd restart
