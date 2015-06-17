package edu.fiu.cis.acrl.mentorscheduler.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

import edu.fiu.cis.acrl.mentorscheduler.server.Configuration;
import edu.fiu.cis.acrl.mentorscheduler.server.MentorCourse;
import edu.fiu.cis.acrl.mentorscheduler.server.MentorSchedulerSettings;
import edu.fiu.cis.acrl.mentorscheduler.server.MentorUnallocatedWorktimeSchedule;
import edu.fiu.cis.acrl.mentorscheduler.server.MentoringSchedule;
import edu.fiu.cis.acrl.mentorscheduler.server.Mentor;
import edu.fiu.cis.acrl.mentorscheduler.server.ReservedResource;
import edu.fiu.cis.acrl.mentorscheduler.server.tools.debug.DebugTools;
import edu.fiu.cis.acrl.tools.timeperiod.TimePeriod;
import edu.fiu.cis.acrl.tools.timeperiod.ScheduledEvent;
import edu.fiu.cis.acrl.tools.timeperiod.TimePeriodTools;

public class MentorSchedulerDB {
	
	// Debug level for this class
	private static int DEBUG_LEVEL = 2;
	
	private Connection conn;
	
	/**
	 * Default Constructor.
	 */
	public MentorSchedulerDB() {
		
	}

	/**
	 * Connects to the database.
	 * @param user
	 * @param password
	 * @param host
	 * @param database
	 * @return
	 */
    public boolean connect(String user, String password, String host, String database) {
    
    	DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - connect] Inside!");
    	
    	try {
    		
    	    Class.forName("org.postgresql.Driver");
    	    
    	    conn = DriverManager.getConnection("jdbc:postgresql://" + host + "/" + 
    	    		database, user, password);
    	
    	}
    	catch(ClassNotFoundException cnfe) {
    	    
    	    System.err.println("Could not find JDBC driver");
    	    return false;
    	
    	}
    	catch(SQLException se) {
    	
    		se.printStackTrace();
    	    return false;
    	
    	}

    	DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - connect] Ready to get out!");
    	
    	return true;
        
    }
        
    /**
     * Closes the database.
     */
    public void close() {

    	try {
    		
    	    if(conn != null) {
    		
    	    	conn.close();
    	    
    	    }
    	    
    	}
    	catch(SQLException e) {
    	    
    		e.printStackTrace();
    	
    	}
        
    }

    /**
     * The configuration table is supposed to have only one active record.
     * This function returns that one active record.
     * @return
     */
    public Configuration getConfiguration() {

    	DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getConfiguraiton] Inside!");
    	
    	Configuration config = null;
    	
    	try {
	    
    		PreparedStatement ps = conn.prepareStatement(
    				"SELECT * FROM configuration WHERE active='t'");
	    
    		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
    		
    		ResultSet rs = ps.executeQuery();
	    
    		if (rs.next()) {
		
    			int id = rs.getInt("id");
    			Calendar userStartTime = Calendar.getInstance();
       			userStartTime.setTime(rs.getTimestamp("user_start_time"));
    			Calendar userEndTime = Calendar.getInstance();
    			userEndTime.setTime(rs.getTimestamp("user_end_time"));
    			Calendar adminStartTime = Calendar.getInstance();
       			adminStartTime.setTime(rs.getTimestamp("admin_start_time"));
    			Calendar adminEndTime = Calendar.getInstance();
    			adminEndTime.setTime(rs.getTimestamp("admin_end_time"));
    			boolean active = rs.getBoolean("active");
    			
    			config = new Configuration(
    					id, 
    					userStartTime, 
    					userEndTime, 
    					adminStartTime,
    					adminEndTime,
    					active);
	    
    		}
	   
    		rs.close();
    		ps.close();
	       
    	}
	
    	catch(SQLException e) {
	    
    		e.printStackTrace();
	
    	}

    	DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getConfiguraiton] Ready to get out!");
    	
    	return config;

    }

    /**
     * Gets a configuration record using its unique id.
     * @param id
     * @return
     */
    public Configuration getConfiguration(int id) {

    	DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getConfiguraiton using id] Inside!");
    	
    	Configuration config = null;
    	
    	try {
	    
    		PreparedStatement ps = conn.prepareStatement(
    				"SELECT * FROM configuration WHERE id=?");
	    
    		ps.setInt(1, id);
    		
    		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
    		
    		ResultSet rs = ps.executeQuery();
	    
    		if (rs.next()) {
		
    			int retId = rs.getInt("id");
    			Calendar userStartTime = Calendar.getInstance();
       			userStartTime.setTime(rs.getTimestamp("user_start_time"));
    			Calendar userEndTime = Calendar.getInstance();
    			userEndTime.setTime(rs.getTimestamp("user_end_time"));
    			Calendar adminStartTime = Calendar.getInstance();
       			userStartTime.setTime(rs.getTimestamp("admin_start_time"));
    			Calendar adminEndTime = Calendar.getInstance();
    			userEndTime.setTime(rs.getTimestamp("admin_end_time"));
    			boolean active = rs.getBoolean("active");
    			
    			config = new Configuration(
    					retId, 
    					userStartTime, 
    					userEndTime, 
    					adminStartTime,
    					adminEndTime,
    					active);
	    
    		}
	   
    		rs.close();
    		ps.close();
	       
    	}
	
    	catch(SQLException e) {
	    
    		e.printStackTrace();
	
    	}

    	DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getConfiguraiton] Ready to get out!");
    	
    	return config;

    }

    /**
     * Sets a configuration record using its unique id.
     * @param configuration
     * @return
     */
    public boolean setConfiguration(Configuration configuration) {

    	DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - setConfiguraiton] Inside!");
    	
    	boolean retVal = false;
    	
    	try {

    		PreparedStatement ps = conn.prepareStatement(
    				"UPDATE configuration SET active='f'");
	    
    		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
    		
    		ps.execute();
    		
    		ps.close();

    		int id = addConfiguration(configuration);
    			
    		if (id <= 0)
        		retVal = false;	
    		
    	}
	
    	catch(SQLException e) {
	    
    		e.printStackTrace();
	
    	}

    	DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - setConfiguraiton] Ready to get out!");

    	return retVal;

    }

    /**
     * Adds a new configuration.
     * @param config
     * @return Returns the unique id for this new record.
     */
    public int addConfiguration(Configuration config) {

    	DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - addConfiguraiton] Inside!");
    	
    	int id = 0;
    	
    	try {
	    
    		PreparedStatement ps = conn.prepareStatement(
    				"INSERT INTO " +
    				"configuration(user_start_time,user_end_time," +
    				"admin_start_time,admin_end_time,active) " +
    				"VALUES(?,?,?,?,?) " +
					"RETURNING id");
        	
    		DebugTools.println(DEBUG_LEVEL, "MentorSchedulerDB - addConfiguration] config: " +
    				"userStart: " + config.getUserStartTime().getTime() + " " +
    				"userEnd: " + config.getUserEndTime().getTime() + " " +
    				"adminStart: " + config.getAdminStartTime().getTime() + " " +
    				"adminEnd: " + config.getAdminEndTime().getTime());
    		
    		Timestamp userStartTimeStamp = new Timestamp(
    				config.getUserStartTime().getTime().getTime());
    		ps.setTimestamp(1, userStartTimeStamp);
    		Timestamp userEndTimeStamp = new Timestamp(
    				config.getUserEndTime().getTime().getTime());
    		ps.setTimestamp(2, userEndTimeStamp);
    		Timestamp adminStartTimeStamp = new Timestamp(
    				config.getAdminStartTime().getTime().getTime());
    		ps.setTimestamp(3, adminStartTimeStamp);
    		Timestamp adminEndTimeStamp = new Timestamp(
    				config.getAdminEndTime().getTime().getTime());
    		ps.setTimestamp(4, adminEndTimeStamp);
    		ps.setBoolean(5, config.isActive());
    		
    		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
    	
    		ResultSet rs = ps.executeQuery();

    		if (rs.next())
    			id = rs.getInt("id");
    		
    		rs.close();
    		ps.close();

    	}
	
    	catch(SQLException e) {
	    
    		e.printStackTrace();
	
    	}

    	DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - setConfiguraiton] Ready to get out!");

    	return id;

    }

    /**
	 * Gets a mentor record using its unique username.
	 * @param id
	 * @return
	 */
	public Mentor getMentor(String mentorUsername) {
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentor] Inside!");
		
		Mentor mentor = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM mentor WHERE username=?");
	    
			ps.setString(1, mentorUsername);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
	
				String username = rs.getString("username");
				boolean active = rs.getBoolean("active");
				
				mentor = new Mentor(username, active); 
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentor] Ready to get out!");
		
		return mentor;
	
	}

	/**
	 * Sets a mentor record using its unique username.
	 * @param mentor
	 * @return
	 */
	public boolean setMentor(Mentor mentor) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - setMentor] Inside!");
		
		boolean retVal = false;
		
		try {
	
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE mentor SET active=? " +
					"WHERE username=?");
	
			ps.setBoolean(1, mentor.isActive());
			ps.setString(2, mentor.getUsername());
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ps.execute();

			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;
			
		    DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - setMentor] update count: " + count +
		    		" retVal is " + retVal);
		    
		    ps.close();
		
		    
		}
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - setMentor] Ready to get out!");
		
		return retVal;
		
	}

	public boolean delMentor(String mentorUsername) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - delMentor] Inside!");
		
		boolean retVal = false;
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM mentor_unallocated_worktime_sch " +
					"WHERE mentor_username=?");
			
			ps.setString(1, mentorUsername);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - delMentor] ps: " + ps);
			
			ps.execute();
			
			ps.close();

			ps = conn.prepareStatement(
					"DELETE FROM mentor_course " +
					"WHERE mentor_username=?");
			
			ps.setString(1, mentorUsername);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - delMentor] ps: " + ps);
			
			ps.execute();

			ps.close();
			
			ps = conn.prepareStatement(
					"DELETE FROM mentoring_sch " +
					"WHERE mentor_username=?");
			
			ps.setString(1, mentorUsername);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - delMentor] ps: " + ps);
			
			ps.execute();
			
			ps.close();

			ps = conn.prepareStatement(
			"DELETE FROM mentor WHERE username=?");
	
			ps.setString(1, mentorUsername);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorScheduler - delMentor] ps: " + ps);
			
			ps.execute();

			ps.close();
					
			retVal = true;
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - delMentor] Ready to get out!");
		
		return retVal;
	}
	
	/**
     * Adds a mentor record to the mentor table.
     * @param mentor
     * @return returns the auto-generated unique mentor id.
     */
    public String addMentor(Mentor mentor) {
    	
    	DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - addMentor] Inside!");
    	
    	String username = null;
    	
    	try {
    		
    		PreparedStatement ps = conn.prepareStatement(
    				"INSERT INTO mentor(username,active) VALUES(?,?) " +
    				"RETURNING username");
    		
    		ps.setString(1, mentor.getUsername());
    		ps.setBoolean(2, mentor.isActive());
    		
    		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
    	
    		ResultSet rs = ps.executeQuery();
    		
    		if (rs.next()) {
    			
    			username = rs.getString("username");
    			
    		}
    		
    		rs.close();
    		ps.close();
    		
    	}
    	catch (Exception e) {
    		
    		e.printStackTrace();
    		
    	}
    	
    	DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - addMentor] username: " + username);
    	
    	DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - addMentor] Ready to get out!");
    	
    	return username;
    }
    
    /**
	 * Gets a list of all active mentors in the database.
	 * @return
	 */
	public ArrayList<Mentor> getMentorList() {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentorList] Inside!");
		
		ArrayList<Mentor> mentorList = new ArrayList<Mentor>();
		Mentor mentor = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM mentor WHERE active='t'");
	    
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			while (rs.next()) {
		
				String username = rs.getString("username");
				boolean active = rs.getBoolean("active");
				
				mentor = new Mentor(username, active); 
				mentorList.add(mentor);
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentorList] Ready to get out!");
		
		return mentorList;
	
	}

    /**
	 * Gets a list of all active mentors for a course.
	 * @return
	 */
	public ArrayList<Mentor> getMentorList(String courseId) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentorList] Inside!");
		
		ArrayList<Mentor> mentorList = new ArrayList<Mentor>();
		Mentor mentor = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM mentor,mentor_course " +
					"WHERE username=mentor_username AND " +
					"mentor.active='t' AND " +
					"mentor_course.active='t' AND " +
					"course_id = ?");
	    
			ps.setString(1, courseId);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			while (rs.next()) {
		
				String username = rs.getString("username");
				boolean active = rs.getBoolean("active");
				
				mentor = new Mentor(username, active); 
				mentorList.add(mentor);
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentorList] Ready to get out!");
		
		return mentorList;
	
	}
	
	public MentorCourse getMentorCourse(
			String mentorUsername,
			String courseId) {
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentorCourse] Inside!");
		
		MentorCourse mentorCourse = null;
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM mentor_course WHERE " +
					"mentor_username=? AND " +
					"course_id=?");
			
			ps.setString(1, mentorUsername);
			ps.setString(2, courseId);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {

				String retMentorUsername = rs.getString("mentor_username");
				String retCourseId = rs.getString("course_id");
				boolean retActive = rs.getBoolean("active");
				
				mentorCourse = 
					new MentorCourse(
							retMentorUsername,
							retCourseId,
							retActive);
			
			}
			
			rs.close();
			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentorCourse] Ready to get out!");
		
		return mentorCourse;
	}

	public boolean setMentorCourse(MentorCourse mentorCourse) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - setMentorCourse] Inside!");
		
		boolean retVal = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE mentor_course SET active=? WHERE " +
					"mentor_username=? AND " +
					"course_id=?");
			
			ps.setBoolean(1, mentorCourse.isActive());
			ps.setString(2, mentorCourse.getMentorUsername());
			ps.setString(3, mentorCourse.getCourseId());
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ps.execute();
			
			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;

		    ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - setMentorCourse] Ready to get out!");
		
		return retVal;
		
	}
	
	public boolean addMentorCourse(MentorCourse mentorCourse) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - addMentorCourse] Inside!");
		
		boolean retVal = false;
		
		if (getMentorCourse(mentorCourse.getMentorUsername(), mentorCourse.getCourseId()) != null)
			return retVal;
		
		Mentor mentor = getMentor(mentorCourse.getMentorUsername());
		if (mentor == null)
			return retVal;
		if (!mentor.isActive())
			return retVal;
	
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO " +
					"mentor_course(mentor_username,course_id,active) " +
					"VALUES(?,?,?)");
			
			ps.setString(1, mentorCourse.getMentorUsername());
			ps.setString(2, mentorCourse.getCourseId());
			ps.setBoolean(3, mentorCourse.isActive());
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			retVal = ps.execute();
		
			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - addMentorCourse] Ready to get out!");
		
		return retVal;
		
	}
	
	public boolean delMentorCourse(MentorCourse mentorCourse) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - delMentorCourse] Inside!");
		
		boolean retVal = false;
	
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT count(*) FROM mentoring_sch WHERE " +
					"mentor_username=? AND " +
					"course_id=?");
			
			ps.setString(1, mentorCourse.getMentorUsername());
			ps.setString(2, mentorCourse.getCourseId());
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				int count = rs.getInt("count");
				
				if (count == 0) {
			
					PreparedStatement ps2 = conn.prepareStatement(
							"DELETE FROM mentor_course WHERE " +
							"mentor_username=? AND " +
							"course_id=?");
					
					ps2.setString(1, mentorCourse.getMentorUsername());
					ps2.setString(2, mentorCourse.getCourseId());
					
					DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps2: " + ps2);
					
					ps2.execute();
					retVal = true;
				
					ps2.close();
					
				}
				
			}
			
			rs.close();
			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - delMentorCourse] Ready to get out!");
		
		return retVal;
		
	}
	
	public ArrayList<String> getCourseList(String mentorUsername) {
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getCourseList] Inside!");
		
		ArrayList<String> courseList = new ArrayList<String>();
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM mentor_course WHERE " +
					"mentor_username=? AND " +
					"active=true");
			
			ps.setString(1, mentorUsername);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				courseList.add(rs.getString("course_id"));
				
			}
			
			rs.close();
			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getCourseList] Ready to get out!");
		
		return courseList;
		
	}
	
	/**
	 * Gets a mentor unallocated worktime schedule using the schedule's unique id.
	 * @param id
	 * @return
	 */
	public MentorUnallocatedWorktimeSchedule getMentorUnallocatedWorktimeSch(
			String id) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentorUnallocatedWorktimeSch] Inside!");
		
		MentorUnallocatedWorktimeSchedule mentorUnallocatedWorktimeSch = null;
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * from mentor_unallocated_worktime_sch " +
					"WHERE id=?"
					);
			
			ps.setString(1, id);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				String retId = rs.getString("id");
				String mentorUsername = rs.getString("mentor_username");
				Calendar startTime = Calendar.getInstance();
				startTime.setTime(rs.getTimestamp("start_time"));
				Calendar endTime = Calendar.getInstance();
				endTime.setTime(rs.getTimestamp("end_time"));
				boolean active = rs.getBoolean("active");
				
				mentorUnallocatedWorktimeSch = 
					new MentorUnallocatedWorktimeSchedule(
							retId, 
							mentorUsername, 
							startTime,
							endTime, 
							active);
			
			}
			
			rs.close();
			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentorUnallocatedWorktimeSch] Ready to get out!");
		
		return mentorUnallocatedWorktimeSch;
		
	}

	/**
	 * Sets a mentor unallocated worktime schedule using the schedule's unique id.
	 * @param mentorUnallocatedWorktimeSch
	 * @return
	 */
	public boolean setMentorUnallocatedWorktimeSch(
			MentorUnallocatedWorktimeSchedule mentorUnallocatedWorktimeSch) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - setMentorUnallocatedWorktimeSch] Inside!");
		
		boolean retVal = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE mentor_unallocated_worktime_sch " +
					"SET mentor_username=?,start_time=?,end_time=?,active=? " +
					"WHERE id=?"
					);
			
			ps.setString(1, mentorUnallocatedWorktimeSch.getMentorUsername());
			Timestamp startTimeStamp = new Timestamp(
					mentorUnallocatedWorktimeSch.getStartTime().getTime().getTime());
			ps.setTimestamp(2, startTimeStamp);
			Timestamp endTimeStamp = new Timestamp(
					mentorUnallocatedWorktimeSch.getEndTime().getTime().getTime());
			ps.setTimestamp(3, endTimeStamp);
			ps.setBoolean(4, mentorUnallocatedWorktimeSch.isActive());
			ps.setString(5, mentorUnallocatedWorktimeSch.getId());
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ps.execute();
			
			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;
			
			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - setMentorUnallocatedWorktimeSch] Ready to get out!");
		
		return retVal;
		
	}

	/**
	 * Removes the time period from mentor's unallocated worktime.
	 * 
	 * @param mentorUsername
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public boolean remMentorUnallocatedWorktimeSch(
			String mentorUsername,
			Calendar startTime, 
			Calendar endTime) {
		
		DebugTools.println(DEBUG_LEVEL, "MentorSchedulerDB - remMentorUnallocatedWorktimeSch] Inside!");
		
		boolean retVal = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM mentor_unallocated_worktime_sch " +
					"WHERE active='t' AND mentor_username=? AND " +
					"start_time<=? AND end_time>=?");
			
			ps.setString(1, mentorUsername);
			Timestamp startTimeStamp = new Timestamp(
					startTime.getTime().getTime());
			ps.setTimestamp(2, startTimeStamp);
			Timestamp endTimeStamp = new Timestamp(
					endTime.getTime().getTime());
			ps.setTimestamp(3, endTimeStamp);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				// First, get the schedule
				String retId = rs.getString("id");
				MentorUnallocatedWorktimeSchedule mentorFreetime = 
					getMentorUnallocatedWorktimeSch(retId);
				
				// Next, inactive this record
				mentorFreetime.setActive(false);
				setMentorUnallocatedWorktimeSch(mentorFreetime);
				
				// Next, see if we need to add some records
				if (mentorFreetime.getStartTime().compareTo(startTime) < 0) {
					
					MentorUnallocatedWorktimeSchedule sch = 
						new MentorUnallocatedWorktimeSchedule(
								null,
								mentorUsername,
								mentorFreetime.getStartTime(),
								startTime,
								true);
					addMentorUnallocatedWorktimeSch(sch);
					
				}
					
				if (mentorFreetime.getEndTime().compareTo(endTime) > 0) {
					
					MentorUnallocatedWorktimeSchedule sch = 
						new MentorUnallocatedWorktimeSchedule(
								null,
								mentorUsername,
								endTime,
								mentorFreetime.getEndTime(),
								true);
					addMentorUnallocatedWorktimeSch(sch);
					
				}
				
				retVal = true;
				
			}
			
		}	
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "MentorSchedulerDB - remMentorUnallocatedWorktimeSch] Ready to get out!");
		
		return retVal;
	
	}

	/**
	 * Adds a new mentor unallocated worktime schedule and returns a unique id.
	 * @param mentorUnallocatedWorktimeSch
	 * @return
	 */
	public String addMentorUnallocatedWorktimeSch(
			MentorUnallocatedWorktimeSchedule mentorUnallocatedWorktimeSch) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - addMentorUnallocatedWorktimeSch] Inside!");
		
		String id = null;
		
		try {
			
			Timestamp startTimeStamp = new Timestamp(
					mentorUnallocatedWorktimeSch.getStartTime().getTime().getTime());
			Timestamp endTimeStamp = new Timestamp(
					mentorUnallocatedWorktimeSch.getEndTime().getTime().getTime());

			PreparedStatement ps = conn.prepareStatement(
					"SELECT id FROM mentor_unallocated_worktime_sch " +
					"WHERE mentor_username=? and start_time=? and active='t'");
			
			ps.setString(1, mentorUnallocatedWorktimeSch.getMentorUsername());
			ps.setTimestamp(2, endTimeStamp);

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				String tempId = rs.getString("id");
				MentorUnallocatedWorktimeSchedule sch =
					getMentorUnallocatedWorktimeSch(tempId);
				sch.setActive(false);
				setMentorUnallocatedWorktimeSch(sch);
				
				endTimeStamp = new Timestamp(
						sch.getEndTime().getTime().getTime());
				
			}
			
			ps.close();
			
			ps = conn.prepareStatement(
					"SELECT id FROM mentor_unallocated_worktime_sch " +
					"WHERE mentor_username=? and end_time=? and active='t'");
			
			ps.setString(1, mentorUnallocatedWorktimeSch.getMentorUsername());
			ps.setTimestamp(2, startTimeStamp);

			rs = ps.executeQuery();
			
			if (rs.next()) {
				
				String tempId = rs.getString("id");
				MentorUnallocatedWorktimeSchedule sch =
					getMentorUnallocatedWorktimeSch(tempId);
				sch.setActive(false);
				setMentorUnallocatedWorktimeSch(sch);
				
				startTimeStamp = new Timestamp(
						sch.getStartTime().getTime().getTime());
				
			}
			
			ps.close();
			
			ps = conn.prepareStatement(
					"INSERT INTO " +
					"mentor_unallocated_worktime_sch(id,mentor_username,start_time,end_time,active) " +
					"VALUES(?,?,?,?,?) "
					);
			
			if (mentorUnallocatedWorktimeSch.getId() == null)
				id = UUID.randomUUID().toString();
			else
				id = mentorUnallocatedWorktimeSch.getId();
			ps.setString(1, id);
			ps.setString(2, mentorUnallocatedWorktimeSch.getMentorUsername());
			ps.setTimestamp(3, startTimeStamp);
			ps.setTimestamp(4, endTimeStamp);
			ps.setBoolean(5, mentorUnallocatedWorktimeSch.isActive());
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ps.execute();
			
			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - addMentorUnallocatedWorktimeSch] Ready to get out!");
		
		return id;
		
	}

	/**
	 * Gets all the periods that a mentor is scheduled for unallocated worktime.
	 * @param mentor
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public ArrayList<ScheduledEvent> getMentorUnallocatedWorktimeSchList(
			String mentorUsername,
			Calendar startTime, 
			Calendar endTime) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentorUnallocatedWorktimeSchList] Inside!");
		
		ArrayList<ScheduledEvent> mentorUnallocatedWorktimeList = new ArrayList<ScheduledEvent>();
		
	    try {
	
	    	PreparedStatement ps = conn.prepareStatement(
	    		"SELECT * FROM mentor_unallocated_worktime_sch " +
	    		"WHERE mentor_username=? AND active='t' AND" +
	    		"((start_time < ? AND start_time >= ?) OR " +
	    		"(end_time > ? AND end_time <= ?) OR" +
	    		"(start_time < ? AND end_time > ?))");
		    
			ps.setString(1, mentorUsername);
	    	Timestamp startTimeStamp = new Timestamp(startTime.getTime().getTime());
			Timestamp endTimeStamp = new Timestamp(endTime.getTime().getTime());
			ps.setTimestamp(2, endTimeStamp);
			ps.setTimestamp(3, startTimeStamp);
			ps.setTimestamp(4, startTimeStamp);
			ps.setTimestamp(5, endTimeStamp);
			ps.setTimestamp(6, startTimeStamp);
			ps.setTimestamp(7, endTimeStamp);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
		    
			while (rs.next()) {
	
				Calendar sTime = Calendar.getInstance();
				sTime.setTime(rs.getTimestamp("start_time"));
				if (sTime.getTime().getTime() < startTime.getTime().getTime())
					sTime = startTime;
				Calendar eTime = Calendar.getInstance();
				eTime.setTime(rs.getTimestamp("end_time"));
				if (eTime.getTime().getTime() > endTime.getTime().getTime())
					eTime = endTime;
				
				ScheduledEvent schEvent = new ScheduledEvent();
				TimePeriod mentorSchedule = new TimePeriod();
				mentorSchedule.setStartTime(sTime);
				mentorSchedule.setEndTime(eTime);
				schEvent.setTimePeriod(mentorSchedule);
				schEvent.setSchId(rs.getString("id"));
				mentorUnallocatedWorktimeList.add(schEvent);
		   		
			}
			
			rs.close();
		    ps.close();
		
		}
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		/*
		mentorUnallocatedWorktimeList =
			TimePeriodTools.fixAndSortTimePeriodList(
				mentorUnallocatedWorktimeList, 
				startTime,
				endTime);
		*/
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentorUnallocatedWorktimeSchList] Ready to get out!");
		
		return mentorUnallocatedWorktimeList;
	
	}

	/**
	 * Gets all the available mentoring time periods for a specific course
	 * during a time period.
	 * @param mentor
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public ArrayList<TimePeriod> getMentoringUnallocatedWorktimeList(
			String courseId,
			Calendar startTime,
			Calendar endTime) {
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentoringUnallocatedWorktimeList] Inside!");
		
		ArrayList<TimePeriod> mentoringList = new ArrayList<TimePeriod>();
		
		ArrayList<Mentor> mentorList = getMentorList(courseId);
		
	    try {
	
	    	String whereClause = "";
	    	
	    	for (int i=0; i<mentorList.size(); i++) {
	
	    		if (i == 0)
	    			whereClause += " AND ( ";
	    		
	    		if (i > 0)
	    			whereClause += " OR ";
	    		whereClause += "mentor_username='" + mentorList.get(i).getUsername() + "'";
	    	
	    		if (i == mentorList.size()-1) 
	    			whereClause += " ) ";
	    	
	    	}
	    	
	    	PreparedStatement ps = conn.prepareStatement(
	    		"SELECT start_time,end_time FROM mentor_unallocated_worktime_sch " +
	    		"WHERE active='t' " + whereClause + " AND " +
	    		"((start_time < ? AND start_time >= ?) OR " +
	    		"(end_time > ? AND end_time <= ?) OR " +
	    		"(start_time < ? AND end_time > ?))");
		    
			Timestamp startTimeStamp = new Timestamp(startTime.getTime().getTime());
			Timestamp endTimeStamp = new Timestamp(endTime.getTime().getTime());
			ps.setTimestamp(1, endTimeStamp);
			ps.setTimestamp(2, startTimeStamp);
			ps.setTimestamp(3, startTimeStamp);
			ps.setTimestamp(4, endTimeStamp);
			ps.setTimestamp(5, startTimeStamp);
			ps.setTimestamp(6, endTimeStamp);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
		    
			while (rs.next()) {
	
				Calendar sTime = Calendar.getInstance();
				sTime.setTime(rs.getTimestamp("start_time"));
				if (sTime.getTime().getTime() < startTime.getTime().getTime())
					sTime = startTime;
				Calendar eTime = Calendar.getInstance();
				eTime.setTime(rs.getTimestamp("end_time"));
				if (eTime.getTime().getTime() > endTime.getTime().getTime())
					eTime = endTime;
				
				TimePeriod mentoringSchedule = new TimePeriod();
				mentoringSchedule.setStartTime(sTime);
				mentoringSchedule.setEndTime(eTime);
				mentoringList.add(mentoringSchedule);
		   		
			}
			
			rs.close();
		    ps.close();
		
		}
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		mentoringList = TimePeriodTools.fixAndSortTimePeriodList(mentoringList);
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentoringUnallocatedWorktimeList] Ready to get out!");
		
		return mentoringList;
	
	}

	/**
	 * Gets a mentoring schedule using the schedule's unique id.
	 * @param id
	 * @return
	 */
	public MentoringSchedule getMentoringSch(
			String id) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentoringSch] Inside!");
		
		MentoringSchedule mentoringSch = null;
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * from mentoring_sch " +
					"WHERE id=?"
					);
			
			ps.setString(1, id);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				String retId = rs.getString("id");
				String mentorUsername = rs.getString("mentor_username");
				String studentUsername = rs.getString("student_username");
				String courseId = rs.getString("course_id");
				Calendar startTime = Calendar.getInstance();
				startTime.setTime(rs.getTimestamp("start_time"));
				Calendar endTime = Calendar.getInstance();
				endTime.setTime(rs.getTimestamp("end_time"));
				boolean active = rs.getBoolean("active");
				
				mentoringSch = 
					new MentoringSchedule(
							retId, 
							mentorUsername, 
							studentUsername,
							courseId,
							startTime,
							endTime, 
							active);
			
			}
			
			rs.close();
			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentoringSch] Ready to get out!");
		
		return mentoringSch;
		
	}

	/**
	 * Sets a mentoring schedule using the schedule's unique id.
	 * @param mentoringSch
	 * @return
	 */
	public boolean setMentoringSch(
			MentoringSchedule mentoringSch) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - setMentoringSch] Inside!");
		
		boolean retVal = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE mentoring_sch " +
					"SET mentor_username=?,student_username=?,course_id=?," +
					"start_time=?,end_time=?,active=? " +
					"WHERE id=?"
					);
			
			ps.setString(1, mentoringSch.getMentorUsername());
			ps.setString(2, mentoringSch.getStudentUsername());
			ps.setString(3, mentoringSch.getCourseId());
			Timestamp startTimeStamp = new Timestamp(
					mentoringSch.getStartTime().getTime().getTime());
			ps.setTimestamp(4, startTimeStamp);
			Timestamp endTimeStamp = new Timestamp(
					mentoringSch.getEndTime().getTime().getTime());
			ps.setTimestamp(5, endTimeStamp);
			ps.setBoolean(6, mentoringSch.isActive());
			ps.setString(7, mentoringSch.getId());
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ps.execute();
			
			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;

			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - setMentoringSch] Ready to get out!");
		
		return retVal;
		
	}

	/**
	 * Adds a new mentoring schedule and returns a unique id.
	 * @param mentoringSch
	 * @return
	 */
	public String addMentoringSch(
			MentoringSchedule mentoringSch) {
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - addMentoringSch] Inside!");
		
		String id = null;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO " +
					"mentoring_sch(id,mentor_username,student_username,course_id," +
					"start_time,end_time,active) " +
					"VALUES(?,?,?,?,?,?,?) "
					);
			
			if (mentoringSch.getId() == null)
				id = UUID.randomUUID().toString();
			else
				id = mentoringSch.getId();
			ps.setString(1, id);
			ps.setString(2, mentoringSch.getMentorUsername());
			ps.setString(3, mentoringSch.getStudentUsername());
			ps.setString(4, mentoringSch.getCourseId());
			Timestamp startTimeStamp = new Timestamp(
					mentoringSch.getStartTime().getTime().getTime());
			ps.setTimestamp(5, startTimeStamp);
			Timestamp endTimeStamp = new Timestamp(
					mentoringSch.getEndTime().getTime().getTime());
			ps.setTimestamp(6, endTimeStamp);
			ps.setBoolean(7, mentoringSch.isActive());
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ps.execute();
			
			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - addMentoringSch] Ready to get out!");
		
		return id;
		
	}

	/**
	 * Gets all the scheduled mentoring time periods for a specific 
	 * mentor, student, and course during a time period.
	 * @param mentorUsername
	 * @param studentUsername
	 * @param courseId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public ArrayList<ScheduledEvent> getScheduledMentoringList(
			String mentorUsername,
			String studentUsername,
			String courseId,
			Calendar startTime,
			Calendar endTime) {
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getScheduledMentoringList] Inside!");
		
		ArrayList<ScheduledEvent> mentoringList = new ArrayList<ScheduledEvent>();
		
		try {
	
	    	String whereClause = "";
	    
	    	if ((mentorUsername != null) && (mentorUsername != ""))
	    		whereClause += " AND mentor_username='" + mentorUsername + "'";
	    	
	    	if ((studentUsername != null) && (studentUsername != ""))
	    		whereClause += " AND student_username='" + studentUsername + "'";
	    	
	    	if ((courseId != null) && (courseId != ""))
	    		whereClause += " AND course_id='" + courseId + "'";
	    	
	    	PreparedStatement ps = conn.prepareStatement(
	    		"SELECT start_time,end_time,id FROM mentoring_sch " +
	    		"WHERE active='t' " + whereClause + " AND " +
	    		"((start_time < ? AND start_time >= ?) OR " +
	    		"(end_time > ? AND end_time <= ?) OR " +
	    		"(start_time < ? AND end_time > ?))");
		    
			Timestamp startTimeStamp = new Timestamp(startTime.getTime().getTime());
			Timestamp endTimeStamp = new Timestamp(endTime.getTime().getTime());
			ps.setTimestamp(1, endTimeStamp);
			ps.setTimestamp(2, startTimeStamp);
			ps.setTimestamp(3, startTimeStamp);
			ps.setTimestamp(4, endTimeStamp);
			ps.setTimestamp(5, startTimeStamp);
			ps.setTimestamp(6, endTimeStamp);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
		    
			while (rs.next()) {
	
				Calendar sTime = Calendar.getInstance();
				sTime.setTime(rs.getTimestamp("start_time"));
				if (sTime.getTime().getTime() < startTime.getTime().getTime())
					sTime = startTime;
				Calendar eTime = Calendar.getInstance();
				eTime.setTime(rs.getTimestamp("end_time"));
				if (eTime.getTime().getTime() > endTime.getTime().getTime())
					eTime = endTime;
				String schId = rs.getString("id");
				
				TimePeriod mentoringSchedule = new TimePeriod();
				mentoringSchedule.setStartTime(sTime);
				mentoringSchedule.setEndTime(eTime);
				ScheduledEvent mentoringEvent = new ScheduledEvent();
				mentoringEvent.setTimePeriod(mentoringSchedule);
				mentoringEvent.setSchId(schId);
				mentoringList.add(mentoringEvent);
		   		
			}
			
			rs.close();
		    ps.close();
		
		}
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentoringUnallocatedWorktimeList] " +
				"mentoringList.size(): " + mentoringList.size());
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentoringUnallocatedWorktimeList] Ready to get out!");
		
		return mentoringList;
	
	}

	public ArrayList<Mentor> getMentorList(
			String courseId, 
			Calendar startTime,
			Calendar endTime) {

		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentorList] Inside!");
		
		ArrayList<Mentor> mentorList = new ArrayList<Mentor>();
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM mentor_unallocated_worktime_sch,mentor " +
					"WHERE " +
					"mentor_unallocated_worktime_sch.mentor_username = mentor.username and " +
					"mentor.active = 't' and " +
					"mentor_unallocated_worktime_sch.start_time <= ? and " +
					"mentor_unallocated_worktime_sch.end_time >= ?");
			
			Timestamp startTimeStamp = new Timestamp(startTime.getTime().getTime());
			Timestamp endTimeStamp = new Timestamp(endTime.getTime().getTime());
			ps.setTimestamp(1, startTimeStamp);
			ps.setTimestamp(2, endTimeStamp);
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentorList] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
		
				Mentor mentor = 
					new Mentor(
							rs.getString("username"),
							true);
				mentorList.add(mentor);
				
			}
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - getMentorList] Ready to get out!");
		
		return mentorList;
		
	}

	public boolean reserveResource(ReservedResource reservedResource) {

		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - reserveResource] Inside!");
		
		boolean retVal = false;
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO " +
					"	reserved_resources(course_id,start_time,end_time,quota,cancel)" +
					"	VALUES(?,?,?,?,?) " +
					"	RETURNING id"
					);
			
			ps.setString(1, reservedResource.getCourseId());
    		Timestamp startTimeStamp = new Timestamp(reservedResource.getStartTime().getTime().getTime());
    		ps.setTimestamp(2, startTimeStamp);
    		Timestamp endTimeStamp = new Timestamp(reservedResource.getEndTime().getTime().getTime());
    		ps.setTimestamp(3, endTimeStamp);
			ps.setInt(4, reservedResource.getQuota());
			ps.setBoolean(5, reservedResource.isCancel());
			
			DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - reserveResource] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				if (rs.getInt("id") > 0)
					retVal = true;
				
			}
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[MentorSchedulerDB - reserveResource] Ready to get out!");
		
		return retVal;
		
	}
	
}