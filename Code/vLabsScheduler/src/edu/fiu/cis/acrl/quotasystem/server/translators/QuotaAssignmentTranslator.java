package edu.fiu.cis.acrl.quotasystem.server.translators;

import edu.fiu.cis.acrl.quotasystem.ws.QuotaAssignment;

public class QuotaAssignmentTranslator {
	
	
	public static QuotaAssignment 
		toAxisRepresentation(edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment quotaAssignment){
		QuotaAssignment axisQuotaAssignment = new QuotaAssignment();
		
		axisQuotaAssignment.setActive(quotaAssignment.isActive());
		axisQuotaAssignment.setPercentageReturned(quotaAssignment.getPercentageReturned());
		axisQuotaAssignment.setPurchaseId(quotaAssignment.getPurchaseId());
		axisQuotaAssignment.setCreditTypeId(quotaAssignment.getCreditType().getId());
		axisQuotaAssignment.setQuantity(quotaAssignment.getQuantity());
		
		return axisQuotaAssignment;
			
	}
	
	
	public static edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment 
		toLocalRepresentation(QuotaAssignment axisQuotaAssignment){
		
		edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment quotaAssignment = 
			new edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment();
		
		quotaAssignment.setActive(axisQuotaAssignment.getActive());
		quotaAssignment.setPercentageReturned(axisQuotaAssignment.getPercentageReturned());
		quotaAssignment.setPurchaseId(axisQuotaAssignment.getPurchaseId());
		quotaAssignment.setQuantity(axisQuotaAssignment.getQuantity());
		
		return quotaAssignment;
			
	}

}
