/***
 *	This Guacamole plugin allows for the authentication parameters to be passed 
 *	directly in the URL.
 *	This class is used to limit the hosts to which Guacamole for vLabs
    is allowed to connect to. 
 *
 *	Author: Juan Riano
 *	FIU / Senior Project / Summer 2015
 */


package edu.fiu.cis.acrl.virtuallabs.guacamole.auth;

import java.io.File;
import java.io.FileInputStream; 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import org.glyptodon.guacamole.properties.GuacamoleProperties;
import org.glyptodon.guacamole.properties.StringGuacamoleProperty;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.Arrays;
import java.util.ArrayList;



/***
 *  Class to limit the hosts to which Guacamole for vLabs can connect to 
 */
public class Limit {

	private static Logger logger = LoggerFactory.getLogger(Limit.class);

	/***
	 * The classpath directory where the key.key file is/shold be stored.
	 * This is retrieved from guacamole.properties.
	 */
	public static final StringGuacamoleProperty LIB_DIRECTORY = new StringGuacamoleProperty() {
		@Override
		public String getName() { return "lib-directory"; }
	};



	/***
	 * Reads the restrictions file and returns a list with the read lines 
	 */
	private static String[] readRestrictions() {
		// Will construct the list using an array list.
        ArrayList<String> restrictions = new ArrayList<String>();

		try {
			String classPathDir = GuacamoleProperties.getProperty(LIB_DIRECTORY);	
			File dir = new File(classPathDir);
			File fin = new File(dir.getCanonicalPath() + File.separator + "restrictions.txt");
            FileInputStream fis = new FileInputStream(fin);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			String line = null;
			while ((line = br.readLine()) != null) {
				restrictions.add(line);
			}

			br.close();
			
		} catch(Exception e){
			System.out.println(e.toString());
			logger.info("Error opening restrictions file.");
		}

		// Convert to regular array before returning.
		return restrictions.toArray(new String[restrictions.size()]);
	}


	
	/***
	 * Takes the restriction and the host (lists) and compares all parts except for the host.
	 */	
	private static boolean compareDomain(String[] restr, String[] host) {
		int size = host.length;
		for (int i = 1; i < size; i ++) {
			if ( ! restr[i].equals(host[i])) {
				return false;	
			}
		}	
		return compareHost(restr[0], host[0]); 
	}


	/***
	 * Compares the host part of the connection and the host part of the restriction.
	 */
	private static boolean compareHost(String restr, String host) {
		if (restr.equals("*"))
			return true;
		if (restr.equals(host))
			return true;
		return false;
	}


	/***
	 * Checks the connection's port against a range given by the restrictions
	 * to check  for its validity.
	 */
	private static boolean isPortValid(String[] restr_port_range, String conn_port) {
		if (restr_port_range[0].equals("*"))
			return true;
		if (restr_port_range[0].equals(conn_port))
			return true;

		int size = restr_port_range.length;
		if (size == 2) {
			int low = Integer.parseInt(restr_port_range[0]);
			int high = Integer.parseInt(restr_port_range[1]);
			int conn = Integer.parseInt(conn_port);
 
			if ((low <= conn) && (high >= conn))
				return true;
		} 

		return false;
	} 


	/***
	 * Tests the connection string provided (hostname+port) to see if it
	 * is a valid connection.
	 */
	public static boolean isAuthorized(String connectionString) {

		// Split the connection string into its parts (host, domain and port range)
		String[] conn_parts = connectionString.trim().split(":");
		String[] conn_host_domain = conn_parts[0].split("\\.");
		String conn_port = conn_parts[1];

		// Abort if domain+host parts don't make even 3 parts
		if (conn_host_domain.length < 3) 
			return false;

		// Now check that the restrictions file and contents are good
		String[] restrictions = readRestrictions();
		if (restrictions.length < 1)
			return false;

		// Now let's compare the restrictions against the connection string
		String[] restr_parts;
		String[] restr_host_domain;
		String[] restr_port_range;

		boolean authorized = false;
		// Split and compare a restriction at a time against the connection string
		for (String restriction : restrictions) {
			restr_parts = restriction.trim().split(":");
			restr_host_domain = restr_parts[0].split("\\.");
			restr_port_range = restr_parts[1].split("\\-");

            // Check port validity
			if ( ! isPortValid(restr_port_range, conn_port)) 
                continue;

            // Skip if host+domain parts' sizes are not equal
            if (restr_host_domain.length != conn_host_domain.length) 
            	continue;

            // Check the host+domain parts are all permited  
            if ( ! compareDomain(restr_host_domain, conn_host_domain)) 
                continue;

            // If all previous tests passed, this is a valid connection
            authorized = true;
		}

        return authorized;
	}
}
