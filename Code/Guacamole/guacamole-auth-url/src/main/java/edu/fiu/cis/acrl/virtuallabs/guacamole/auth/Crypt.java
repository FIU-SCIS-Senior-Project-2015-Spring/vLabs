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
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;



/***
 *  Class to encrypt and decrypt base64 strings.
 */
public class Crypt {

	private static Logger logger = LoggerFactory.getLogger(Crypt.class);
	private static String key = "ks03nlg3mz38l2z3";	




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
}
