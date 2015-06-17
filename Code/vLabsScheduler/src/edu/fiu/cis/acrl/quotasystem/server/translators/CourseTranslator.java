package edu.fiu.cis.acrl.quotasystem.server.translators;

import edu.fiu.cis.acrl.quotasystem.ws.Course;


public class CourseTranslator {
	
	public static Course toAxisRepresentation(edu.fiu.cis.acrl.quotasystem.entity.Course course)
	{
		Course axisCourse = new Course();
		axisCourse.setId(course.getId());
		axisCourse.setShortname(course.getShortname());
		axisCourse.setFullname(course.getFullname());
		return axisCourse;
	}

}
