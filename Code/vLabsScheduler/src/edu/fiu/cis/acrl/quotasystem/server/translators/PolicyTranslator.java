package edu.fiu.cis.acrl.quotasystem.server.translators;

import java.util.Calendar;
import edu.fiu.cis.acrl.quotasystem.ws.Policy;

public class PolicyTranslator {

	public static Policy toAxisRepresentation(
			edu.fiu.cis.acrl.quotasystem.entity.Policy policy) {
		Policy axisPolicy = new Policy();
		axisPolicy.setId(policy.getId());
		axisPolicy.setName(policy.getName());
		axisPolicy.setDescription(policy.getDescription());
		axisPolicy.setNumberOfPeriods(policy.getNumberOfPeriods());
		axisPolicy.setDaysInPeriod(policy.getDaysInPeriod());
		axisPolicy.setMaximum(policy.getMaximum());
		axisPolicy.setMinimum(policy.getMinimum());
		axisPolicy.setQuotaInPeriod(policy.getQuotaInPeriod());
		axisPolicy.setActive(policy.getActive());
		axisPolicy.setAssignable(policy.getAssignable());
		axisPolicy.setAbsolute(policy.getAbsolute());

		if (policy.getStartDate() != null) {
			Calendar startDate = Calendar.getInstance();
			startDate.setTime(policy.getStartDate());
			axisPolicy.setStartDate(startDate);
		}
		if (policy.getDaysToRelStart() != null) {
			axisPolicy.setDaysToRelStart(policy.getDaysToRelStart());
		}

		String type = policy.getPolicyType();
		axisPolicy.setPolicyType(PolicyTypeTranslator
				.toAxisRepresentation(type));

		return axisPolicy;

	}

}
