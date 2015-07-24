Florida International University / Senior Project / Summer 2015
Project: Virtual Labs Ver 3.0
Section: Guacamole Gateway


This Readme file explains the process of installing the Guacamole gateway
and the guacamole-auth-url plugin by using 2 installation scripts.
For detailed instructions, and for how to install it manually please
refer to the project documentation section of this project.


------------------------------------------
THE SHORT VERSION
------------------------------------------

Getting a Guacamole server ready for vLabs is easy, just complete these 2 steps: 

1) Create the text file key.key with a single line with the encription string
   for URL password encryption. (16 characters), save it in this directory.
2) run the following commands
sudo guacamole-installer.sh
sudo guacamole-auth-url-installer.sh


-----------------------------------------
THE LONG VERSION
-----------------------------------------

This folder has 8 files and 1 folder, this is all that is needed
to install Guacamole and the authentication plugin.

The installation process will create additional folders, 
when Guacamole and the plugin are installed, these folders
will be deleted by the installer.

This installer was made for version 0.9.7 of Guacamole, and
hopefully it will need very little modifications to work in 
future versions.


The initial 8 files and 1 folder are required
---------------------------------------------
firewal.sh
guacamole-installer.sh
guacamole-auth-url-installer.sh
guacamole.properties
guacamole-VERSION-dependency.list.txt
server.xml
restrictions.txt
README.txt
./guacamole-auth-url/


Create the file key.key as a simple text file with a single line
containing a 16 character key to decrypt the password.
----------------------------------------------------------------
key.key

Modify restrictions.txt to restrict access to certain domains
and port combinations. i.e. 
-------------------------------------------------------------

Plus these files will be created and downloaded by this instaler
----------------------------------------------------------------
guacamole-server-0.9.7.tar.gz
guacamole-client-0.9.7.tar.gz
guacamole-auth-url-1.0-SNAPSHOT.jar




firewall.sh:
-----------
Can be used to secure a test server, basically it locks all ports except ssh, http/https, and 8080.
This script was slightly modified from the original verion found on this website:
http://beadmin.2tl.eu/post/server-vps-openvz-firewall-script-iptables-1#.VaWb13UViko
usage: sudo ./firewall [start/stop]

guacamole-installer.sh
----------------------
Downloads, build, and installs a default Guacamole server. This default version will still not work, since it needs to be configured.
This script installs software that may or may not be installed in the server, and that is needed to setup guacamole, an
example could be the Java JDK. Check the script before running it to make sure it does not download unwanted versions.
usage: sudo ./guacamole-installer.sh

guacamole-auth-url-installer.sh
-------------------------------
This script sets up the guacamole-auth-url.jar plugin and the other configuration files in their respective locations.
usage: sudo ./guacamole-auth-url-installer.sh

guacamole.properties
--------------------
The main Guacamole configuration file. The most important line in this file is the Authentication Provider, which enables the 
guacamole-auth-url.jar plugin.

guacamole-[VERSION]-dependency-list.txt
-------------------------------------
A list of all the prerequisite libraries that will need to be installed before Guacamole can be installed and ran.

server.xml
----------
This file is a configuration file for Tomcat, it opens the port needed for Guacamole.
The section of interest is marked with: "Enabled for Guacamole".

key.key
-------
A text file you need to create with a single line containing the unencrypting key for Guacamole.
This string needs to be 16 url safe characters.

restrictions.txt
----------------
Used to restrict access to some domain:port combinations, the format used is:
host.domain.com:port-range 
*.cis.fiu.edu:40000-60000
This file is copied to /var/lib/guacamole/classpath

README.txt
----------
This file.

./guacamole-auth-url/
--------------------
The Maven project folder for the plugin, that will be used to build the .jar plugin file.



guacamole-aut-url-1.0-SNAPSHOT.jar
----------------------------------
Authentication plugin that enables Guacamole to open connections with all the client's information passed via the URL.
This file will be buit by the installer.

guacamole-server-0.9.7.tar.gz
-----------------------------
The archive needed to install Guacamole server.
This file will be downloaded by the scripts.

guacamole-client-0.9.7.tar.gz
-----------------------------
The archive needed to install the Guacamole web application.
This file will be downloaded by the scripts.
