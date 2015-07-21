/***
 *	This Guacamole plugin allows for the authentication parameters to be passed 
 *	directly in the URL.
 *	This class is used to decrypt the password parameter that comes encrypted
 *  in the URL.
 *
 *	Code provided by Dr. Masoud Sadjadi
 *	FIU / Senior Project / Summer 2015
 */


package edu.fiu.cis.acrl.virtuallabs.guacamole.auth;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import java.io.File;
import java.io.FileInputStream; 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import org.glyptodon.guacamole.GuacamoleException;
import org.glyptodon.guacamole.properties.GuacamoleProperties;
import org.glyptodon.guacamole.properties.StringGuacamoleProperty;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;



/***
 *  Class to encrypt and decrypt base64 strings.
 */
public class Crypt {

	private static Logger logger = LoggerFactory.getLogger(Crypt.class);

	/***
	 *  The classpath directory where the key.key file is/shold be stored.
	 *  This is retrieved from guacamole.properties.
	 */
	public static final StringGuacamoleProperty LIB_DIRECTORY = new StringGuacamoleProperty() {
		@Override
		public String getName() { return "lib-directory"; }
	};

	// read the key from a file named key.key located in the same folder as this .jar file
	private static String key = readKey("key.key");



	/***
	 *  Encodes a string in base64, then encrypts it with a 16 lenght key.
	 */
	public static String encrypt(String input) {

		String output = null;
		
		if (input == null)
			return input;
		if (input.isEmpty())
			return input;
		
		byte[] encrypted = null;
		try {
			SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skey);
			encrypted = cipher.doFinal(input.getBytes());
		} catch(Exception e){
			System.out.println(e.toString());
		}
		
		if (encrypted == null)
			output = null;
		else
			output = new String(Base64.encodeBase64(encrypted));
		
		return output;
	}



	/***
	 *  Decrypts a string, decode it using base64 and returns it.
	 */
	public static String decrypt(String input){

		logger.debug("Got into decrypt() function!");
		String output = null;
		
		if (input == null)
			return input;
		if (input.isEmpty())
			return input;
		
		byte[] decrypted = null;
		try{
			SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skey);
			decrypted = cipher.doFinal(Base64.decodeBase64(input));
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		if (decrypted == null)
			output = null;
		else
			output = new String(decrypted);
			logger.debug("decrypted string: {}", output);

		return output;
	}



	/***
	 *  Reads the encryption key from a text file stored
	 *  in the same directory as this .jar file.
	 */
	private static String readKey(String keyFileName) {
		String line = null;
		try {
			// key.key is stored in the classpath directory, get that info from guacamole.properties
			String classPathDir = GuacamoleProperties.getProperty(LIB_DIRECTORY);
			File dir = new File(classPathDir);
			File fin = new File(dir.getCanonicalPath() + File.separator + keyFileName);
			FileInputStream fis = new FileInputStream(fin);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			line = br.readLine();
			if (line == null)
				logger.info("Error: reading encryption in Crypt.readKey() returned null!");
			br.close();
		} catch (IOException e) {
			logger.info("Error reading encryption key in Crypt.readKey()");
		} catch (GuacamoleException e) {
			logger.info("Error opening the LIB_DIRECTORY");
		}		
		
		return line;
	}
}
