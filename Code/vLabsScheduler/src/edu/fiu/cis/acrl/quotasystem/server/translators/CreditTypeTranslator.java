package edu.fiu.cis.acrl.quotasystem.server.translators;

import edu.fiu.cis.acrl.quotasystem.ws.CreditType;
import edu.fiu.cis.acrl.tools.debug.DebugTools;

public class CreditTypeTranslator {
	
	// Debug level for this class
	private static int DEBUG_LEVEL = 1;
	
	public static CreditType toAxisRepresentation(edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType)
	{

		DebugTools.println(DEBUG_LEVEL, "[CreditTypeTranslator - toAxisRepresentation] Inside!");

		CreditType axisCreditType = null;
		
		if (creditType != null) {
		
			axisCreditType = new CreditType();
			axisCreditType.setId(creditType.getId());
			axisCreditType.setName(creditType.getName());
			axisCreditType.setResource(creditType.getResource());
			axisCreditType.setActive(creditType.getActive());		
			axisCreditType.setAssignable(creditType.getAssignable());

			if(creditType.getCourse()!=null)
				axisCreditType.setCourseId(creditType.getCourse().getId().intValue());
			if(creditType.getPolicy()!=null)
				axisCreditType.setPolicyId(creditType.getPolicy().getId().intValue());
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[CreditTypeTranslator - toAxisRepresentation] Ready to get out!");

		return axisCreditType;
		
	}
	
	public static edu.fiu.cis.acrl.quotasystem.entity.CreditType toLocalRepresentation(CreditType axisCreditType)
	{

		edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = 
			new edu.fiu.cis.acrl.quotasystem.entity.CreditType();
		creditType.setId(axisCreditType.getId());
		creditType.setName(axisCreditType.getName());
		creditType.setResource(axisCreditType.getResource());
		creditType.setActive(axisCreditType.getActive());		
		creditType.setAssignable(axisCreditType.getAssignable());

		return creditType;
		
	}

}
