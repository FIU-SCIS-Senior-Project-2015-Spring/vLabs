package edu.fiu.cis.acrl.quotasystem.server.translators;

import edu.fiu.cis.acrl.quotasystem.entity.UserProfile;
import edu.fiu.cis.acrl.quotasystem.ws.User;

public class UserTranslator {
	
public static User toAxisRepresentation(edu.fiu.cis.acrl.quotasystem.entity.UserProfile user){
	
	User axisUser = new User();
	axisUser.setId(user.getId());
	axisUser.setUsername(user.getUsername());
	axisUser.setEmail(user.getEmail());
	
	return axisUser;
}

}
