package edu.fiu.cis.acrl.quotasystem.server.translators;

import edu.fiu.cis.acrl.quotasystem.ws.PolicyType;

public class PolicyTypeTranslator {
	
	
	public static PolicyType toAxisRepresentation(String type)
	{
		if(type.equals(PolicyType._FIXED)){
			
			return PolicyType.FIXED;
			
		}else if(type.equals(PolicyType._GRADUAL)){
			
			return PolicyType.GRADUAL;
			
		}else if(type.equals(PolicyType._MINMAX)){
			
			return PolicyType.MINMAX;
			
		}else if(type.equals(PolicyType._NOEXPIRATION)){
			
			return PolicyType.NOEXPIRATION;
			
		}else{
			
			return null;
		}
		
		
	}

}
