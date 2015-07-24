/***
 *	This Guacamole plugin allows for the authentication parameters to be passed 
 *	directly in the URL.
 *  Other class in this package (Crypt) is used to decrypt the password parameter
 *  which comes encrypted from the caller, using a similar php class.
 *  Finally the Limit class is used to check hostname and port and allow or
 *  denny access based on that.
 *	
 *	Author: Juan Riano
 *	FIU / Senior Project / Summer 2015
 */

package edu.fiu.cis.acrl.virtuallabs.guacamole.auth;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.glyptodon.guacamole.GuacamoleException;
import org.glyptodon.guacamole.net.auth.simple.SimpleAuthenticationProvider;
import org.glyptodon.guacamole.net.auth.Credentials;
import org.glyptodon.guacamole.net.auth.UserContext;
import org.glyptodon.guacamole.net.auth.simple.SimpleUserContext;
import org.glyptodon.guacamole.protocol.GuacamoleConfiguration;
import org.glyptodon.guacamole.properties.GuacamoleProperties;
import org.glyptodon.guacamole.token.StandardTokens;
import org.glyptodon.guacamole.token.TokenFilter;
import org.glyptodon.guacamole.properties.StringGuacamoleProperty;
import org.glyptodon.guacamole.properties.IntegerGuacamoleProperty;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import javax.servlet.http.HttpServletRequest;


/**
 *	This class overrides some functions to allow the interception of the http request, then use
 *	the request's parameters to create a user session valid to connect to the target computer.
 */
public class UrlAuthenticationProvider extends SimpleAuthenticationProvider {

	private Logger logger = LoggerFactory.getLogger(UrlAuthenticationProvider.class);
	// Default protocol used by this authenticator
	public static final StringGuacamoleProperty DEFAULT_PROTOCOL = new StringGuacamoleProperty() {
		@Override
		public String getName() { return "default-protocol"; }
	};

	// The secret key used to encrypt the username and password
	public static final StringGuacamoleProperty SECRET_KEY = new StringGuacamoleProperty() {
		@Override
		public String getName() { return "secret-key"; }
	};

	// The timestamp age limit 
	public static final IntegerGuacamoleProperty TIMESTAMP_AGE_LIMIT = new IntegerGuacamoleProperty() {
		@Override
		public String getName() { return "timestamp-age-limit"; }
	};

	// The time limit of life for a request
	public static final long TEN_MINUTES = 10 * 60 * 1000;	
	private String defaultProtocol = "rdp";	
	private long timeStampAgeLimit = TEN_MINUTES;
	// The key to decrypt the password
	private String secretKey = "";

	// Per-request params
	public static final String SIGNATURE_PARAM = "signature";
	public static final String ID_PARAM = "id";
	public static final String TIMESTAMP_PARAM = "timestamp";
	public static final String PARAM_PREFIX = "guac.";
	public static final String PASSWORD = "password";


	/**
	*  Given a credentials object, returns a Map with a connection id and 
	*  its related configuration. This implementation returns a single pair.   
	*/
	public Map<String, GuacamoleConfiguration> getAuthorizedConfigurations(Credentials credentials) throws GuacamoleException {
		logger.debug("getAuthorizedConfigurations - user in credentials: {}", credentials.getUsername());
		logger.debug("getAuthorizedConfigurations - password in credentials: {}", credentials.getPassword());

		// The configuration to return 
		GuacamoleConfiguration config = getGuacamoleConfiguration(credentials.getRequest()); 
		logger.debug("getAuthorizedConfigurations - Guacamole configurations were just read");

		// The <connection id, configuration> map to return 
		Map<String, GuacamoleConfiguration> configs = new HashMap<String, GuacamoleConfiguration>();
		configs.put(config.getParameter(ID_PARAM), config);	
		return configs;
	}


	/**
	*  Given a request, returns a configuration with the request, id and protocol set, and also
	*  initializes the Authenticator's secret key, default protocol and timestamp age limit.
	*/
	private GuacamoleConfiguration getGuacamoleConfiguration(HttpServletRequest request) throws GuacamoleException {
		// Load properties from guacamole.properties
		String tempKey = GuacamoleProperties.getProperty(SECRET_KEY); 
		String tempProtocol = GuacamoleProperties.getProperty(DEFAULT_PROTOCOL);
		int tempAgeLimit = GuacamoleProperties.getProperty(TIMESTAMP_AGE_LIMIT);

		if (tempKey != null) secretKey = tempKey;
		if (tempProtocol != null) defaultProtocol = tempProtocol;
		if (tempAgeLimit != 0) timeStampAgeLimit = tempAgeLimit;

		// Construct config from request
		GuacamoleConfiguration config = parseConfigParams(request);

		return config;	
	}


	/**
	*  Given a request, returns a configuration with such request, 
	*  and with id and protocol set to be the same as the ones in the request.
	*/
	private GuacamoleConfiguration parseConfigParams(HttpServletRequest request) {
		logger.debug("parseConfigParams - given request: {}", request);
		// Construct the object to return
		GuacamoleConfiguration config = new GuacamoleConfiguration();
		// Extract the parameters from the request
		Map<String, String[]> params = request.getParameterMap();

		/* Connections can be denied based on hostname and port, this
		 * block checks for that and returns the empty config on fail */
		String hostname = request.getParameter("guac.hostname");
		String port = request.getParameter("guac.port");
		if ( ! Limit.isAuthorized(hostname + ":" + port)) {
			logger.info("This connection (hostname and port) is not authorized.");
			return config;
		}	

		// Go through the elements of the parameters and set the config object
		for (String name : params.keySet()) {
			String value = request.getParameter(name);
			logger.debug("parseConfigParams - name: {}, value: {}", name, value);

			if (name.equals(ID_PARAM)) {	// Set the config's id
				config.setParameter(name, request.getParameter(name)); 
			}
			// Don't do anything with non-guac parameters
			else if (!name.startsWith(PARAM_PREFIX) || value == null || value.length() == 0) {
				continue;
			}
			// Set the config's protocol
			else if (name.equals(PARAM_PREFIX + "protocol")) {
				config.setProtocol(request.getParameter(name));
			}
			// Get the encrypted password
			else if (name.equals(PARAM_PREFIX + "encrypted_password")) {
				config.setParameter(PASSWORD, Crypt.decrypt(request.getParameter(name)));
			}
			// Get un-encrypted password if it exists
			else if (name.equals(PARAM_PREFIX + "password")) {
				config.setParameter(PASSWORD, request.getParameter(name));
			}
			else {	// Set the guac parameters, removing the guac. string first
				config.setParameter(name.substring(PARAM_PREFIX.length()), request.getParameter(name));
			}
		}
		// Set the default protocol if non is found in the request
		if (config.getProtocol() == null) 
			config.setProtocol(defaultProtocol);

		return config;
	}


	/**
	*  Given a credentials, sets a user context and returns it.
	*/
	@Override
	public UserContext getUserContext(Credentials credentials) throws GuacamoleException {
		// The username to return
		String username = ""; 

		// Extract the configuration from the credentials 
		Map<String, GuacamoleConfiguration> configs = getAuthorizedConfigurations(credentials);

		// If the credentials have no valid configuration, return null 
		if (configs == null) {
			logger.debug("getUserContext - configuration from getAuthorizedConfigurations is null");
			return null;
		}

		// A <connection id, config> pair extracted from the configs 
		Map.Entry<String, GuacamoleConfiguration> configsEntry = configs.entrySet().iterator().next();
		
		// Extract the values of the pair
		String configKey = configsEntry.getKey();
		GuacamoleConfiguration configValue = configsEntry.getValue();

		// Get the Parameters from the config
		Map<String, String> theParameters = configValue.getParameters();

		// Get the username
		username = theParameters.get("username");
		logger.debug(" - getUserContext - username: {}", username);

		return new SimpleUserContext(username, configs);
	}


	/**
	*  Update the user context with the credentials provided.
	*  It calls getUserContext() to do the work.
	*/
	@Override
	public UserContext updateUserContext(UserContext context, Credentials credentials) throws GuacamoleException {
		logger.debug("updateUserContext - will pass to getUserContext");
		return getUserContext(credentials);        
	}
}
