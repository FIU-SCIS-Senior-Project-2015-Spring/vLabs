package edu.fiu.cis.acrl.vescheduler.server.db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import edu.fiu.cis.acrl.tools.timeperiod.TimePeriodTools;
import edu.fiu.cis.acrl.tools.timeperiod.TimePeriod;
import edu.fiu.cis.acrl.tools.timeperiod.ScheduledEvent;
import edu.fiu.cis.acrl.tools.timeperiod.TimePeriodWithCounter;

import edu.fiu.cis.acrl.vescheduler.server.Configuration;
import edu.fiu.cis.acrl.vescheduler.server.Host;
import edu.fiu.cis.acrl.vescheduler.server.HostMaintenanceSchedule;
import edu.fiu.cis.acrl.vescheduler.server.HostStorage;
import edu.fiu.cis.acrl.vescheduler.server.KServer;
import edu.fiu.cis.acrl.vescheduler.server.KServerMaintenanceSchedule;
import edu.fiu.cis.acrl.vescheduler.server.MigrationTask;
import edu.fiu.cis.acrl.vescheduler.server.ReservedResource;
import edu.fiu.cis.acrl.vescheduler.server.Storage;
import edu.fiu.cis.acrl.vescheduler.server.Tenant;
import edu.fiu.cis.acrl.vescheduler.server.VEInsHost;
import edu.fiu.cis.acrl.vescheduler.server.VEInstance;
import edu.fiu.cis.acrl.vescheduler.server.VEInstanceSchedule;
import edu.fiu.cis.acrl.vescheduler.server.VESchedulerSettings;
import edu.fiu.cis.acrl.vescheduler.server.VMInstance;
import edu.fiu.cis.acrl.vescheduler.server.VEInstance.VEInsStatusType;
import edu.fiu.cis.acrl.vescheduler.server.VMInstance.VMInsStatusType;
import edu.fiu.cis.acrl.vescheduler.server.agent.SchedulingTask;
import edu.fiu.cis.acrl.vescheduler.server.agent.SchedulingTask.TaskType;
import edu.fiu.cis.acrl.vescheduler.server.tools.debug.DebugTools;
import edu.fiu.cis.acrl.vescheduler.ws.vetypes.VENodeListType;
import edu.fiu.cis.acrl.vescheduler.ws.vetypes.VENodeType;
import edu.fiu.cis.acrl.vescheduler.ws.vetypes.VirtualApplianceType;
import edu.fiu.cis.acrl.vescheduler.ws.vetypes.VirtualEnvironmentType;
import edu.fiu.cis.acrl.virtuallabs.server.VirtualLabs;

public class VESchedulerDB {
	
	// Debug level for this class
	private static int DEBUG_LEVEL = 2;
	private static int MY_DL = 1;
	
	private VESchedulerSettings settings;
	private Connection conn;
	
	/**
	 * Default Constructor.
	 */
	private VESchedulerDB() {
		
		settings= VESchedulerSettings.instance();
		connect(
				settings.getDbUser(), 
				settings.getDbPassword(), 
				settings.getDbHost(), 
				settings.getDbName());
		
	}

	/**
	 * A handle to the unique Singleton instance.
	 */
	static private VESchedulerDB _instance = null;
	
	/**
	 * @return The unique instance of this class.
	 */
	static public VESchedulerDB instance() {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - instance] Inside!");
		
		if(null == _instance) {
			_instance = new VESchedulerDB();
	    }
	    
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - instance] Ready to get out!");
		
		return _instance;
	   
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

    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getConfiguraiton] Inside!");
    	
    	Configuration config = null;
    	
    	try {
	    
    		PreparedStatement ps = conn.prepareStatement(
    				"SELECT * FROM configuration WHERE active='t'");
	    
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
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

    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getConfiguraiton] Ready to get out!");
    	
    	return config;

    }

    /**
     * Gets a configuration record using its unique id.
     * @param id
     * @return
     */
    public Configuration getConfiguration(int id) {

    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getConfiguraiton using id] Inside!");
    	
    	Configuration config = null;
    	
    	try {
	    
    		PreparedStatement ps = conn.prepareStatement(
    				"SELECT * FROM configuration WHERE id=?");
	    
    		ps.setInt(1, id);
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
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

    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getConfiguraiton] Ready to get out!");
    	
    	return config;

    }

    /**
     * Sets a configuration record using its unique id.
     * @param configuration
     * @return
     */
    public boolean setConfiguration(Configuration configuration) {

    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setConfiguraiton] Inside!");
    	
    	boolean retVal = false;
    	
    	try {

    		PreparedStatement ps = conn.prepareStatement(
    				"UPDATE configuration SET active='f'");
	    
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
    		ps.execute();
    		
    		ps.close();

    		int id = addConfiguration(configuration);
    			
    		if (id <= 0)
        		retVal = false;	
    		
    	}
	
    	catch(SQLException e) {
	    
    		e.printStackTrace();
	
    	}

    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setConfiguraiton] Ready to get out!");

    	return retVal;

    }

    /**
     * Adds a new configuration.
     * @param config
     * @return Returns the unique id for this new record.
     */
    public int addConfiguration(Configuration config) {

    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addConfiguraiton] Inside!");
    	
    	int id = 0;
    	
    	try {
	    
    		PreparedStatement ps = conn.prepareStatement(
    				"INSERT INTO " +
    				"configuration(user_start_time,user_end_time," +
    				"admin_start_time,admin_end_time,active) " +
    				"VALUES(?,?,?,?,?) " +
					"RETURNING id");
        	
    		DebugTools.println(DEBUG_LEVEL, "VESchedulerDB - addConfiguration] config: " +
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
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    	
    		ResultSet rs = ps.executeQuery();

    		if (rs.next())
    			id = rs.getInt("id");
    		
    		rs.close();
    		ps.close();

    	}
	
    	catch(SQLException e) {
	    
    		e.printStackTrace();
	
    	}

    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setConfiguraiton] Ready to get out!");

    	return id;

    }

    /**
	 * Gets a host record using its unique id.
	 * @param id
	 * @return
	 */
	public Host getHost(int id) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB -getHost] Inside!");
		
		Host host = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM host WHERE id=?");
	    
			ps.setInt(1, id);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				int retId = rs.getInt("id");
				String name = rs.getString("name");
				int sshPort = rs.getInt("ssh_port");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int veNumCap = rs.getInt("ve_num_cap");
				int veFirstFreePort = rs.getInt("ve_first_free_port");
				int vePortNum = rs.getInt("ve_port_num");
				boolean active = rs.getBoolean("active");
				boolean newAssignment = rs.getBoolean("new_assignment");
				
				host = new Host(retId, name, sshPort, username, password, 
						veNumCap, veFirstFreePort, vePortNum, active, newAssignment); 
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB -getHost] Ready to get out!");
		
		return host;
	
	}

	/**
	 * Gets a host record using its name.
	 * @param id
	 * @return
	 */
	public Host getHostUsingName(String hostName) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB -getHostUsingName] Inside!");
		
		Host host = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM host WHERE name=?");
	    
			ps.setString(1, hostName);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				int retId = rs.getInt("id");
				String name = rs.getString("name");
				int sshPort = rs.getInt("ssh_port");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int veNumCap = rs.getInt("ve_num_cap");
				int veFirstFreePort = rs.getInt("ve_first_free_port");
				int vePortNum = rs.getInt("ve_port_num");
				boolean active = rs.getBoolean("active");
				boolean newAssignment = rs.getBoolean("new_assignment");
				
				host = new Host(retId, name, sshPort, username, password, 
						veNumCap, veFirstFreePort, vePortNum, active, newAssignment); 
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB -getHost] Ready to get out!");
		
		return host;
	
	}

	/**
	 * Sets a host record using its unique id.
	 * @param host
	 * @return
	 */
	public boolean setHost(Host host) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setHost] Inside!");
		
		boolean retVal = false;
		
		try {
	
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE host SET name=?,ssh_port=?,username=?,password=?," +
					"ve_num_cap=?,ve_first_free_port=?,ve_port_num=?,active=?," +
					"new_assignment=? " +
					"WHERE id=?");
	
			ps.setString(1, host.getName());
			ps.setInt(2, host.getSshPort());
			ps.setString(3, host.getUsername());
			ps.setString(4, host.getPassword());
			ps.setInt(5, host.getVeNumCap());
			ps.setInt(6, host.getVeFirstFreePort());
			ps.setInt(7, host.getVePortNum());
			ps.setBoolean(8, host.isActive());
			ps.setBoolean(9, host.isNewAssignment());
			ps.setInt(10, host.getId());
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ps.execute();
			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;
			
		    DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setHost] update count: " + count +
		    		" retVal is " + retVal);
		    
		    ps.close();
		
		    
		}
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setHost] Ready to get out!");
		
		return retVal;
		
	}

	public boolean delHost(int id) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delHost] Inside!");
		
		boolean retVal = false;
		
		try {
			// TODO we need to make sure that host is not reference anywhere else in the db
			// For example, in the ve_ins_sch table.
			
		/*
			PreparedStatement ps = conn.prepareStatement(
					"SELECT count(*) FROM ve_ins WHERE host_id=?");
			
			ps.setInt(1, id);
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			int count = 1;
			
			if (rs.next()) {
				
				count = rs.getInt("count");
				
				DebugTools.println(DEBUG_LEVEL, "[VEScheduler] inside if count: " + count);
				
			}
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler] outside if count: " + count);
			
			if (count == 0) {
			*/
				PreparedStatement ps = conn.prepareStatement(
				"DELETE from host where id=?");
		
				ps.setInt(1, id);
				
				DebugTools.println(DEBUG_LEVEL, "VEScheduler] ps: " + ps);
				
				ps.execute();
				
				retVal = true;
									
			// }
			
			// rs.close();
			ps.close();
					
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delHost] Ready to get out!");
		
		return retVal;
	}
	
	/**
     * Adds a host record to the host table.
     * @param host
     * @return returns the auto-generated unique host id.
     */
    public int addHost(Host host) {
    	
    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addHost] Inside!");
    	
    	int id = 0;
    	
    	try {
    		
    		PreparedStatement ps = conn.prepareStatement(
    				"INSERT INTO host(name,ssh_port,username,password,ve_num_cap," +
    				"ve_first_free_port,ve_port_num,active,new_assignment) " +
    				"VALUES(?,?,?,?,?,?,?,?,?) " +
    				"RETURNING id");
    		
    		ps.setString(1, host.getName());
    		ps.setInt(2, host.getSshPort());
    		ps.setString(3, host.getUsername());
    		ps.setString(4, host.getPassword());
    		ps.setInt(5, host.getVeNumCap());
    		ps.setInt(6, host.getVeFirstFreePort());
    		ps.setInt(7, host.getVePortNum());
    		ps.setBoolean(8, host.isActive());
    		ps.setBoolean(9, host.isNewAssignment());
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    	
    		ResultSet rs = ps.executeQuery();
    		
    		if (rs.next()) {
    			
    			id = rs.getInt("id");
    			
    		}
    		
    		rs.close();
    		ps.close();
    		
    	}
    	catch (Exception e) {
    		
    		e.printStackTrace();
    		
    	}
    	
    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addHost] Ready to get out!");
    	
    	return id;
    }
    
    /**
	 * Gets a list of all active hosts in the database.
	 * @return
	 */
	public ArrayList<Host> getHostList() {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostList - no param] Inside!");
		
		ArrayList<Host> hostList = getHostList(true, true);
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostList - no param] Ready to get out!");
		
		return hostList;
		
	}
	
	/**
	 * 
	 * @param active
	 * @return
	 */
	public ArrayList<Host> getHostList(boolean active, boolean newAssignment) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostList] Inside!");
		
		ArrayList<Host> hostList = new ArrayList<Host>();
		Host host = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM host WHERE active=? and new_assignment=? ORDER BY id");
	    
			ps.setBoolean(1, active);
			ps.setBoolean(2, newAssignment);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			while (rs.next()) {
		
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int sshPort = rs.getInt("ssh_port");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int veNumCap = rs.getInt("ve_num_cap");
				int veFirstFreePort = rs.getInt("ve_first_free_port");
				int vePortNum = rs.getInt("ve_port_num");
				boolean retActive = rs.getBoolean("active");
				boolean retNewAssignment = rs.getBoolean("new_assignment");
				
				host = new Host(id, name, sshPort, username, password, veNumCap, veFirstFreePort,
					vePortNum, retActive, retNewAssignment); 
				hostList.add(host);
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostList] Ready to get out!");
		
		return hostList;
	
	}

	public int getMaxHostId() {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMaxHostId] Inside!");
		
		int maxHostId = -1; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM host");
	    
			DebugTools.println(DEBUG_LEVEL, "[getMaxHostId] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			while (rs.next()) {
		
				int id = rs.getInt("id");
				if (id > maxHostId)
					maxHostId = id;
				
			}
	
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMaxHostId] Ready to get out!");
		
		return maxHostId;
	
	}

	/**
	 * Gets all the fully booked periods for a host during a time period.
	 * @param host
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	// public synchronized ArrayList<TimePeriod> getHostFilledPeriodList(Host host, Calendar startTime,
	public ArrayList<TimePeriod> getHostFilledPeriodList(Host host, Calendar startTime,
			Calendar endTime) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostFilledPeriodList] Inside!");
		
		ArrayList<TimePeriod> hostFilledPeriodList = new ArrayList<TimePeriod>();
		ArrayList<TimePeriod> hostScheduleList = new ArrayList<TimePeriod>();
		
	    try {
	
	    	PreparedStatement ps = conn.prepareStatement(
	    		"SELECT host_id,start_time,end_time FROM ve_ins,ve_ins_sch WHERE " +
	    		"ve_ins.active='t' AND ve_ins_sch.active='t' AND host_id=? " +
	    		"AND ve_ins.id=ve_ins_sch.ve_ins_id AND" +
	    		"((start_time < ? AND start_time >= ?) OR " +
	    		"(end_time > ? AND end_time <= ?) OR " +
	    		"(start_time < ? AND end_time > ?))");
		    
			ps.setInt(1, host.getId());
	    	Timestamp startTimeStamp = new Timestamp(startTime.getTime().getTime());
			Timestamp endTimeStamp = new Timestamp(endTime.getTime().getTime());
			ps.setTimestamp(2, endTimeStamp);
			ps.setTimestamp(3, startTimeStamp);
			ps.setTimestamp(4, startTimeStamp);
			ps.setTimestamp(5, endTimeStamp);
			ps.setTimestamp(6, startTimeStamp);
			ps.setTimestamp(7, endTimeStamp);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
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
				
				TimePeriod veSchedule = new TimePeriod();
				veSchedule.setStartTime(sTime);
				veSchedule.setEndTime(eTime);
				hostScheduleList.add(veSchedule);
		   		
			}
			
			rs.close();
		    ps.close();
		
		}
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		ArrayList<TimePeriodWithCounter> countedList = 
			TimePeriodTools.countPeriods(hostScheduleList);
		for (int i = 0; i < countedList.size(); i++) {
			
			if (countedList.get(i).getCounter() >= host.getVeNumCap()) {
				
				TimePeriodWithCounter timePeriodWithCounter = countedList.get(i);
				TimePeriod timePeriod = new TimePeriod();
				timePeriod.setStartTime(timePeriodWithCounter.getStartTime());
				timePeriod.setEndTime(timePeriodWithCounter.getEndTime());
				hostFilledPeriodList.add(timePeriod);
			
			}
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostFilledPeriodList] Ready to get out!");
		
		return hostFilledPeriodList;
	
	}

	/**
	 * Gets a host maintenance schedule using its unique id.
	 * @param id
	 * @return
	 */
	// public synchronized HostMaintenanceSchedule getHostMainSch(String id) {
	public HostMaintenanceSchedule getHostMainSch(String id) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostMainSch] Inside!");
		
		HostMaintenanceSchedule hostMainSch = null;
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * from host_maintenance_sch WHERE id=?"
					);
			
			ps.setString(1, id);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				String retId = rs.getString("id");
				int hostId = rs.getInt("host_id");
				Calendar startTime = Calendar.getInstance();
				startTime.setTime(rs.getTimestamp("start_time"));
				Calendar endTime = Calendar.getInstance();
				endTime.setTime(rs.getTimestamp("end_time"));
				boolean active = rs.getBoolean("active");
				
				hostMainSch = new HostMaintenanceSchedule(retId, hostId, startTime,
						endTime, active);
			}
			
			rs.close();
			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostMainSch] Ready to get out!");
		
		return hostMainSch;
		
	}
	
	/**
	 * Sets a host maintenance schedule using its unique id.
	 * @param hostMainSch
	 * @return
	 */
	public boolean setHostMainSch(HostMaintenanceSchedule hostMainSch) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setHostMainSch] Inside!");
		
		boolean retVal = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE host_maintenance_sch " +
					"SET host_id=?,start_time=?,end_time=?,active=? " +
					"WHERE id=?"
					);
			
			ps.setInt(1, hostMainSch.getHostId());
			Timestamp startTimeStamp = new Timestamp(
    				hostMainSch.getStartTime().getTime().getTime());
    		ps.setTimestamp(2, startTimeStamp);
    		Timestamp endTimeStamp = new Timestamp(
    				hostMainSch.getEndTime().getTime().getTime());
    		ps.setTimestamp(3, endTimeStamp);
    		ps.setBoolean(4, hostMainSch.isActive());
    		ps.setString(5, hostMainSch.getId());
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
    		ps.execute();
    		
			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;
			
    		ps.close();
    		
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setHostMainSch] Ready to get out!");
		
		return retVal;
		
	}
	
	/**
	 * Adds a new host maintenance schedule and returns a unique id.
	 * @param hostMainSch
	 * @return
	 */
	public String addHostMainSch(HostMaintenanceSchedule hostMainSch) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addHostMainSch] Inside!");
		
		String id = null;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO " +
					"host_maintenance_sch(id,host_id,start_time,end_time,active) " +
					"VALUES(?,?,?,?,?) "
					);
			
			if (hostMainSch.getId() == null)
				id = UUID.randomUUID().toString();
			else
				id = hostMainSch.getId();
			ps.setString(1, id);
			ps.setInt(2, hostMainSch.getHostId());
			Timestamp startTimeStamp = new Timestamp(
    				hostMainSch.getStartTime().getTime().getTime());
    		ps.setTimestamp(3, startTimeStamp);
    		Timestamp endTimeStamp = new Timestamp(
    				hostMainSch.getEndTime().getTime().getTime());
    		ps.setTimestamp(4, endTimeStamp);
    		ps.setBoolean(5, hostMainSch.isActive());
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
    		ps.execute();
    		
    		ps.close();
    		
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addHostMainSch] Ready to get out!");
		
		return id;
		
	}
	
	/**
	 * Gets all the periods that a host is scheduled for maintenance.
	 * @param host
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	// public synchronized ArrayList<ScheduledEvent> getHostMainSchList(
	public ArrayList<ScheduledEvent> getHostMainSchList(
			int hostId,
			Calendar startTime, 
			Calendar endTime) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostMainSchList] Inside!");
		
		ArrayList<ScheduledEvent> hostUnavailList = new ArrayList<ScheduledEvent>();
		
	    try {
	
	    	PreparedStatement ps = conn.prepareStatement(
	    		"SELECT * FROM host_maintenance_sch WHERE host_id=? AND active='t' AND" +
	    		"((start_time < ? AND start_time >= ?) OR " +
	    		"(end_time > ? AND end_time <= ?) OR" +
	    		"(start_time < ? AND end_time > ?))");
		    
			ps.setInt(1, hostId);
	    	Timestamp startTimeStamp = new Timestamp(startTime.getTime().getTime());
			Timestamp endTimeStamp = new Timestamp(endTime.getTime().getTime());
			ps.setTimestamp(2, endTimeStamp);
			ps.setTimestamp(3, startTimeStamp);
			ps.setTimestamp(4, startTimeStamp);
			ps.setTimestamp(5, endTimeStamp);
			ps.setTimestamp(6, startTimeStamp);
			ps.setTimestamp(7, endTimeStamp);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
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
				
				TimePeriod hostSchedule = new TimePeriod();
				hostSchedule.setStartTime(sTime);
				hostSchedule.setEndTime(eTime);
				ScheduledEvent mainSchEvent = new ScheduledEvent();
				mainSchEvent.setTimePeriod(hostSchedule);
				mainSchEvent.setSchId(schId);
				hostUnavailList.add(mainSchEvent);
		   		
			}
			
			rs.close();
		    ps.close();
		
		}
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostMainSchList] Ready to get out!");
		
		return hostUnavailList;
	
	}

	/**
	 * Gets a VE instance using its is.
	 * @param id
	 * @return
	 */
	public VEInstance getVEInstance(String id) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstance] Inside!");
		
		VEInstance veIns = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM ve_ins WHERE id=?");
	    
			ps.setString(1, id);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				String retId = rs.getString("id");
				String username = rs.getString("username");
				String veTypeName = rs.getString("ve_type");
				VirtualEnvironmentType veType = new VirtualEnvironmentType();
				// TODO
				veType.setVEName(veTypeName);
				int storageId = rs.getInt("storage_id");
				int kserverId = rs.getInt("kserver_id");
				int veFirstFreePort = rs.getInt("first_port");
				int vePortNum = rs.getInt("num_ports");
				int veFirstFreeMac = rs.getInt("first_mac");
				int veMacNum = rs.getInt("num_macs");
				boolean store = rs.getBoolean("store");
				boolean active = rs.getBoolean("active");
				String statusString = rs.getString("status");
				VEInsStatusType status = VEInstance.getStatus(statusString);
				
				veIns = new VEInstance(
						retId, 
						username, 
						veType, 
						storageId, 
						kserverId,
						veFirstFreePort,
						vePortNum, 
						veFirstFreeMac,
						veMacNum, 
						store, 
						active,
						status); 
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstance] Ready to get out!");
		
		return veIns;

	}

	/**
	 * Sets a VE instance using its id.
	 * @param veIns
	 * @return
	 */
	public boolean setVEInstance(VEInstance veIns) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEInstance] Inside!");
		
		boolean retVal = false;
		
		VEInstance prevVEIns = getVEInstance(veIns.getId());
		if (prevVEIns.getStatus() != veIns.getStatus())
			setVEInsStatus(veIns.getId(), veIns.getStatus());
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE ve_ins " +
					"	SET username=?,ve_type=?,storage_id=?,kserver_id=?,first_port=?,num_ports=?," +
					"		first_mac=?,num_macs=?,store=?,active=?,status=?" +
					"	WHERE id=?"
					);
			
			ps.setString(1, veIns.getUsername());
			ps.setString(2, veIns.getVeType().getVEName());
			ps.setInt(3, veIns.getStorageId());
			ps.setInt(4, veIns.getKserverId());
			ps.setInt(5, veIns.getFirstPort());
			ps.setInt(6, veIns.getNumPorts());
			ps.setInt(7, veIns.getFirstMac());
			ps.setInt(8, veIns.getNumMacs());
			ps.setBoolean(9, veIns.isStore());
			ps.setBoolean(10, veIns.isActive());
			ps.setString(11, veIns.getStatus().toString());
			ps.setString(12, veIns.getId());
						
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEInstance] ps: " + ps);
			
			ps.execute();

			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;
						
			ps.close();

			if (!veIns.isActive() && retVal) {
				
				ps = conn.prepareStatement(
						"UPDATE ve_ins_sch SET active='f' " +
						"	WHERE ve_ins_id=?"
				);

				ps.setString(1, veIns.getId());

				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEInstance] ps: " + ps);

	    		ps.execute();
	    		
	    		count = ps.getUpdateCount();
			    if (count > 0)
			    	retVal = true;
				
				ps.close();

				if (retVal) {
					
					ps = conn.prepareStatement(
							"UPDATE vm_ins SET active='f' " +
							"	WHERE ve_ins_id=?"
					);

					ps.setString(1, veIns.getId());

					DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEInstance] ps: " + ps);

					ps.execute();

					count = ps.getUpdateCount();
					if (count > 0)
						retVal = true;

					ps.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEInstance] Ready to get out!");
		
		return retVal;
	
	}

	/**
	 * Sets a VE instance using its id.
	 * @param veIns
	 * @return
	 */
	public boolean setVEInsStatus(String veInsId, VEInsStatusType status) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEInsStatus] Inside!");
		
		boolean retVal = false;
		
		VEInstance prevVEIns = getVEInstance(veInsId);
		if (prevVEIns.getStatus() != status) {
		
			try {

				PreparedStatement ps = conn.prepareStatement(
						"UPDATE ve_ins " +
						"	SET status=?" +
						"	WHERE id=?"
				);

				ps.setString(1, status.toString());
				ps.setString(2, veInsId);

				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEInsStatus] ps: " + ps);

				retVal = ps.execute();

				ps.close();

				/*
				ps = conn.prepareStatement(
						"UPDATE vm_ins SET status=? " +
						"	WHERE ve_ins_id=?"
				);

				ps.setString(1, VMInstance.getStatus(status.toString()).toString());
				ps.setString(2, veInsId);

				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEInsStatus] ps: " + ps);

				ps.execute();

				int count = ps.getUpdateCount();
			    if (count > 0)
			    	retVal = true;
				
				ps.close();

				if (status == VEInsStatusType.DESTROYED) {

					ps = conn.prepareStatement(
							"UPDATE ve_ins SET active='f' " +
							"	WHERE id=?"
					);

					ps.setString(1, veInsId);

					DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEInsStatus] ps: " + ps);

					retVal = ps.execute();

					ps.close();

					ps = conn.prepareStatement(
							"UPDATE ve_ins_sch SET active='f' " +
							"	WHERE ve_ins_id=?"
					);

					ps.setString(1, veInsId);

					DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEInsStatus] ps: " + ps);

					retVal = ps.execute();

					ps.close();

					ps = conn.prepareStatement(
							"UPDATE vm_ins SET active='f' " +
							"	WHERE ve_ins_id=?"
					);

					ps.setString(1, veInsId);

					DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEInsStatus] ps: " + ps);

					retVal = ps.execute();

					ps.close();

				}
				*/

			}
			catch (Exception e) {

				e.printStackTrace();

			}
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEInsStatus] Ready to get out!");
		
		return retVal;
	
	}

	/**
	 * Adds a new VE instance.
	 * @param veIns
	 * @return Returns the newly generate VE instance id.
	 */
	public String addVEInstance(VEInstance veIns) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addVEInstance] Inside!");
		
		String id = null;
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO " +
					"	ve_ins(id,username,ve_type,storage_id,kserver_id,first_port,num_ports," +
					"		first_mac,num_macs,store,active,status) " +
					"	VALUES(?,?,?,?,?,?,?,?,?,?,?,?) " +
					"	RETURNING id"
					);
			
			if (veIns.getId() == null)
				ps.setString(1, UUID.randomUUID().toString());
			else
				ps.setString(1, veIns.getId());
			ps.setString(2, veIns.getUsername());
			ps.setString(3, veIns.getVeType().getVEName());
			ps.setInt(4, veIns.getStorageId());
			ps.setInt(5, veIns.getKserverId());
			ps.setInt(6, veIns.getFirstPort());
			ps.setInt(7, veIns.getNumPorts());
			ps.setInt(8, veIns.getFirstMac());
			ps.setInt(9, veIns.getNumMacs());
			ps.setBoolean(10, veIns.isStore());
			ps.setBoolean(11, veIns.isActive());
			ps.setString(12, veIns.getStatus().toString());
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addVEInstance] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				id = rs.getString("id");
				veIns.setId(id);
				
			}
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addVEInstance] Ready to get out!");
		
		return id;
		
	}
	
	/**
	 * This function creates  a new VE instance and increments the first available 
	 * port number on the associated host record in the database.
	 * @param storage
	 * @param veType
	 * @param startTime
	 * @param endTime
	 * @param store
	 * @return
	 */
	// public synchronized VEInstance creatNewVEIns(
	public VEInstance creatNewVEIns(
			String username,
			Storage storage, 
			KServer kserver,
			VirtualEnvironmentType veType, 
			// Calendar startTime, 
			// Calendar endTime, 
			boolean store) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - createNewVEIns] Inside!");
		
		String veInsId = null;
		int storageId = storage.getId();
		int kserverId = kserver.getId();
		int veFirstFreePort = getVEFirstFreePort();
		int veNumPorts = veType.getVENumPorts();
		int veFirstFreeMac = getVEFirstFreeMac();
		int veNumMacs = veType.getVENumMacs();
		boolean active = true;
		VEInsStatusType status = VEInsStatusType.NOT_PROVISIONED; 
		// storage.setVeFirstFreePort(veFirstFreePort + veNumPorts);
		// setHost(storage);
		
		VEInstance veIns = 
			new VEInstance(
					veInsId, 
					username, 
					veType, 
					storageId,
					kserverId,
					veFirstFreePort, 
					veNumPorts, 
					veFirstFreeMac, 
					veNumMacs, 
					store, 
					active,
					status);
		
		veInsId = addVEInstance(veIns);
		veIns = getVEInstance(veInsId);
		veInsId = veIns.getId();
		
		setVEFirstFreePort(veFirstFreePort + veNumPorts);
		setVEFirstFreeMac(veFirstFreeMac + veNumMacs);
		
		VENodeListType veNodeList = veType.getVENodeList();
		VENodeType[] veNodes = veNodeList.getVENode();
		String name = "";
		String dir = "";
		String domain = "";
		String os = ""; 
		String internalAddress = ""; 
		int accessPort = veFirstFreePort;
		int macSeqNum = veFirstFreeMac;
		String macAddress = getMacAddress(macSeqNum);
		VMInsStatusType vmStatus = VMInsStatusType.NOT_PROVISIONED;
		Calendar lastCheckin = Calendar.getInstance();
		String appName = "";
		String appDir = "";
		boolean vmActive = true;
		String vmInsId = null;
		VirtualApplianceType vaType = null;
		if (veNodes.length > 0) {
			vaType = veNodes[0].getVirtualAppliance();

			// TODO we should read ve_type file and follow it in the below lines
			// Adding w2k3
			vmInsId = null;
			name = vaType.getName(); // "Domain Controller (dc)";
			dir = vaType.getDir(); // "w2k3-1";
			domain = vaType.getDomain(); // "FIU";
			os = vaType.getGuestOS(); // "Microsoft Windows Server 2003";
			internalAddress = vaType.getRole(); // "dc.mr.fiu.edu";
			accessPort = veFirstFreePort;
			macSeqNum = veFirstFreeMac;
			macAddress = getMacAddress(macSeqNum);
			vmStatus = VMInsStatusType.NOT_PROVISIONED;
			lastCheckin = Calendar.getInstance();
			appName = "";
			appDir = "";
			vmActive = true;
			VMInstance w2k3 = 
				new VMInstance(
						vmInsId,
						veInsId,
						name,
						dir,
						domain,
						os,
						internalAddress,
						accessPort,
						macAddress,
						vmStatus,
						lastCheckin,
						appName,
						appDir,
						vmActive);
			addVMInstance(w2k3);
			// w2k3 has two macs
			macSeqNum++;
		}

		if (veNodes.length > 1) {
			vaType = veNodes[1].getVirtualAppliance();

			// Adding xp-1
			vmInsId = null;
			name = vaType.getName(); // "Workstation 1 (ws1)";
			dir = vaType.getDir(); // "xp-1";
			domain = vaType.getDomain(); // "FIU";
			os = vaType.getGuestOS(); // "Microsoft Windows XP";
			internalAddress = vaType.getRole(); // "ws1.scis.fiu.edu";
			accessPort++;
			vmStatus = VMInsStatusType.NOT_PROVISIONED;
			macSeqNum++;
			macAddress = getMacAddress(macSeqNum);
			lastCheckin = Calendar.getInstance();
			appName = "";
			appDir = "";
			vmActive = true;
			VMInstance xp1 = 
				new VMInstance(
						vmInsId,
						veInsId,
						name,
						dir,
						domain,
						os,
						internalAddress,
						accessPort,
						macAddress,
						vmStatus,
						lastCheckin,
						appName,
						appDir,
						vmActive);
			addVMInstance(xp1);
		}
		
		if (veNodes.length > 2) {
			vaType = veNodes[2].getVirtualAppliance();

			// Adding xp-2
			vmInsId = null;
			name = vaType.getName(); // "Guest 1 (guest1)";
			dir = vaType.getDir(); // "xp-2";
			domain = vaType.getDomain(); // "FIU";
			os = vaType.getGuestOS(); // "Microsoft Windows XP";
			internalAddress = vaType.getRole(); // "guest1.gl.fiu.edu";
			accessPort++;
			vmStatus = VMInsStatusType.NOT_PROVISIONED;
			macSeqNum++;
			macAddress = getMacAddress(macSeqNum);
			lastCheckin = Calendar.getInstance();
			appName = "";
			appDir = "";
			vmActive = true;
			VMInstance xp2 = 
				new VMInstance(
						vmInsId,
						veInsId,
						name,
						dir,
						domain,
						os,
						internalAddress,
						accessPort,
						macAddress,
						vmStatus,
						lastCheckin,
						appName,
						appDir,
						vmActive);
			addVMInstance(xp2);
		}
		
		if (veNodes.length > 3) {
			vaType = veNodes[3].getVirtualAppliance();

			// Adding xp-3
			vmInsId = null;
			name = vaType.getName(); // "PC 1 (pc1)";
			dir = vaType.getDir(); // "xp-3";
			domain = vaType.getDomain(); // "";
			os = vaType.getGuestOS(); // "Microsoft Windows XP";
			internalAddress = vaType.getRole(); // "pc1.cec.fiu.edu";
			accessPort++;
			vmStatus = VMInsStatusType.NOT_PROVISIONED;
			macSeqNum++;
			macAddress = getMacAddress(macSeqNum);
			lastCheckin = Calendar.getInstance();
			appName = "";
			appDir = "";
			vmActive = true;
			VMInstance xp3 = 
				new VMInstance(
						vmInsId,
						veInsId,
						name,
						dir,
						domain,
						os,
						internalAddress,
						accessPort,
						macAddress,
						vmStatus,
						lastCheckin,
						appName,
						appDir,
						vmActive);
			addVMInstance(xp3);
		}
		
		if (veNodes.length > 4) {
			vaType = veNodes[4].getVirtualAppliance();

			// Adding xp-4
			vmInsId = null;
			name = vaType.getName(); // "Laptop 1 (laptop1)";
			dir = vaType.getDir(); // "xp-4";
			domain = vaType.getDomain(); // "";
			os = vaType.getGuestOS(); // "Microsoft Windows XP";
			internalAddress = vaType.getRole(); // "laptop1.cec.fiu.edu";
			accessPort++;
			vmStatus = VMInsStatusType.NOT_PROVISIONED;
			macSeqNum++;
			macAddress = getMacAddress(macSeqNum);
			lastCheckin = Calendar.getInstance();
			appName = "";
			appDir = "";
			vmActive = true;
			VMInstance xp4 = 
				new VMInstance(
						vmInsId,
						veInsId,
						name,
						dir,
						domain,
						os,
						internalAddress,
						accessPort,
						macAddress,
						vmStatus,
						lastCheckin,
						appName,
						appDir,
						vmActive);
			addVMInstance(xp4);
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - createNewVEIns] Ready to get out!");
		
		return veIns;
		
	}

	private String getMacAddress(int macSeqNum) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMacAddress] Inside!");
		
		String hexNum = Integer.toHexString(macSeqNum);
		while (hexNum.length() < 6)
			hexNum = "0" + hexNum;
		
		String macAddress = 
			"00:50:56:" + 
			hexNum.substring(0, 2) + ":" +
			hexNum.substring(2, 4) + ":" +
			hexNum.substring(4, 6) ;
		
		macAddress = macAddress.toUpperCase();
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMacAddress] " +
				"macSeqNum: " + macSeqNum + " " +
				"macAddress: " + macAddress + "$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMacAddress] Ready to get out!");
		
		return macAddress;
	}

	private boolean setVEFirstFreeMac(int veFirstFreeMac) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEFirstFreeMac] Inside!");

		boolean retVal = false;
		
		int veFirstFreePort = getVEFirstFreePort();
		
		try {
			
			PreparedStatement ps = 
				conn.prepareStatement( 
						"UPDATE ve_free_ports_and_macs SET active = 'f' " +
						"	WHERE active = 't'");
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEFirstFreeMac] ps: " + ps);
			
			ps.execute();
			
			ps.close();
			
			PreparedStatement ps2 = 
				conn.prepareStatement(
						"INSERT INTO " +
						"	ve_free_ports_and_macs(ve_first_free_port,ve_first_free_mac,active) " +
						"	VALUES(?,?,'t')");

			ps2.setInt(1, veFirstFreePort);
			ps2.setInt(2, veFirstFreeMac);

			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEFirstFreeMac] ps2: " + ps2);

			retVal = ps2.execute();

			ps2.close();

		} catch (SQLException e) {
		
			e.printStackTrace();
	
		}

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEFirstFreeMac] Ready to get out!");
		
		return retVal;
		
	}

	private boolean setVEFirstFreePort(int veFirstFreePort) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEFirstFreePort] Inside!");

		boolean retVal = false;
		
		int veFirstFreeMac = getVEFirstFreeMac();
		
		try {
			
			PreparedStatement ps = 
				conn.prepareStatement(
						"UPDATE ve_free_ports_and_macs SET active = 'f' " +
						"	WHERE active = 't'");
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEFirstFreePort] ps: " + ps);
			
			ps.execute();
			
			ps.close();
			
			PreparedStatement ps2 = 
				conn.prepareStatement(
						"INSERT INTO " +
						"	ve_free_ports_and_macs(ve_first_free_port,ve_first_free_mac,active) " +
						"	VALUES(?,?,'t')");

			ps2.setInt(1, veFirstFreePort);
			ps2.setInt(2, veFirstFreeMac);

			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEFirstFreePort] ps2: " + ps2);

			retVal = ps2.execute();

			ps2.close();

		} catch (SQLException e) {
		
			e.printStackTrace();
	
		}

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEFirstFreePort] Ready to get out!");
		
		return retVal;
		
	}

	private int getVEFirstFreeMac() {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEFirstFreeMac] Inside!");
		
		int veFirstFreeMac = 0;
		
		try {
			
			PreparedStatement ps = 
				conn.prepareStatement(
						"SELECT * FROM ve_free_ports_and_macs WHERE active = 't'");
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEFirstFreeMac] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				veFirstFreeMac = rs.getInt("ve_first_free_mac");
				
			}
			
			rs.close();
			ps.close();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
	
		}

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEFirstFreeMac] Ready to get out!");
		
		return veFirstFreeMac;
	
	}

	private int getVEFirstFreePort() {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEFirstFreePort] Inside!");
		
		int veFirstFreePort = 0;
		
		try {
			
			PreparedStatement ps = 
				conn.prepareStatement(
						"SELECT * FROM ve_free_ports_and_macs WHERE active = 't'");
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEFirstFreePort] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				veFirstFreePort = rs.getInt("ve_first_free_port");
				
			}
			
			rs.close();
			ps.close();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
	
		}

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEFirstFreePort] Ready to get out!");
		
		return veFirstFreePort;
	
	}

	/**
	 * Gets a VE instance schedule record using its unique id.
	 * @param id
	 * @return
	 */
	public VEInstanceSchedule getVEInsSch(String id) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInsSch] Inside!");
		
		VEInstanceSchedule veInsSch = null;
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * from ve_ins_sch WHERE id=?"
					);
			
			ps.setString(1, id);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
			
				String retId = rs.getString("id");
				String veInsId = rs.getString("ve_ins_id");
				int hostId = rs.getInt("host_id");
				Calendar startTime = Calendar.getInstance();
				startTime.setTime(rs.getTimestamp("start_time"));
				Calendar endTime = Calendar.getInstance();
				endTime.setTime(rs.getTimestamp("end_time"));
				boolean done = rs.getBoolean("done");
				boolean active = rs.getBoolean("active");

				veInsSch = 
					new VEInstanceSchedule(
							retId, 
							veInsId, 
							hostId,
							startTime, 
							endTime, 
							done,
							active);
			}
			
			rs.close();
			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInsSch] Ready to get out!");
		
		return veInsSch;
		
	}
	
	/**
	 * Sets a VE instance record using its unique id.
	 * @param veInsSch
	 * @return
	 */
	public boolean setVEInsSch(VEInstanceSchedule veInsSch) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEInsSch] Inside!");
		
		boolean retVal = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE ve_ins_sch " +
					"	SET ve_ins_id=?,host_id=?,start_time=?,end_time=?,done=?,active=? " +
					"	WHERE id=?"
					);
			
			ps.setString(1, veInsSch.getVeInsId());
			ps.setInt(2, veInsSch.getHostId());
			Timestamp startTimeStamp = new Timestamp(veInsSch.getStartTime().getTime().getTime());			
			ps.setTimestamp(3, startTimeStamp);
			Timestamp endTimeStamp = new Timestamp(veInsSch.getEndTime().getTime().getTime());
			ps.setTimestamp(4, endTimeStamp);
			ps.setBoolean(5, veInsSch.isDone());
			ps.setBoolean(6, veInsSch.isActive());
			ps.setString(7, veInsSch.getId());
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ps.execute();

			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;
			
			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVEInsSch] Ready to get out!");
		
		return retVal;
		
	}
	
	/**
	 * Adds a new VE instance schedule and returns its newly generated unique id.
	 * @param veInsSch
	 * @return
	 */
    // public synchronized String addVEInsSch(VEInstanceSchedule veInsSch) {
	public String addVEInsSch(VEInstanceSchedule veInsSch) {
    		
    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addVEInsSch] Inside!");
    	
    	String id = null;
    	
    	try {

    		PreparedStatement ps = conn.prepareStatement(
    				"INSERT INTO " +
    				"	ve_ins_sch(id,ve_ins_id,host_id,start_time,end_time,done,active) " +
    				"	VALUES(?,?,?,?,?,?,?) " +
    				"	RETURNING id"
    				);
    		
    		if (veInsSch.getId() == null)
    			ps.setString(1, UUID.randomUUID().toString());
    		else
    			ps.setString(1, veInsSch.getId());
    		ps.setString(2, veInsSch.getVeInsId());
    		ps.setInt(3, veInsSch.getHostId());
    		Timestamp startTimeStamp = new Timestamp(veInsSch.getStartTime().getTime().getTime());
    		ps.setTimestamp(4, startTimeStamp);
    		Timestamp endTimeStamp = new Timestamp(veInsSch.getEndTime().getTime().getTime());
    		ps.setTimestamp(5, endTimeStamp);
    		ps.setBoolean(6, veInsSch.isDone());
    		ps.setBoolean(7, veInsSch.isActive());
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
    		ResultSet rs = ps.executeQuery();
    		
    		if (rs.next()) {
    		
    			id = rs.getString("id");
    			
    		}
    		
    		rs.close();
    	    ps.close();
    	
    	}
    	catch(SQLException e) {
	    
    		e.printStackTrace();
	
    	}

    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addVEInsSch] Inside!");
    	
    	return id;

    }

	public ArrayList<ScheduledEvent> getVEInsScheduleList(VEInstance veIns,
			Calendar startTime, Calendar endTime) {
		
		ArrayList<ScheduledEvent> veScheduleList = new ArrayList<ScheduledEvent>();
		
		if (veIns != null) {
			
			try {

				PreparedStatement ps = conn.prepareStatement(
						"SELECT * FROM ve_ins_sch WHERE ve_ins_id=? AND active='t' AND" +
						"((start_time < ? AND start_time >= ?) OR " +
						"(end_time > ? AND end_time <= ?) OR" +
				"(start_time < ? AND end_time > ?))");

				ps.setString(1, veIns.getId());
				Timestamp startTimeStamp = new Timestamp(startTime.getTime().getTime());
				Timestamp endTimeStamp = new Timestamp(endTime.getTime().getTime());
				ps.setTimestamp(2, endTimeStamp);
				ps.setTimestamp(3, startTimeStamp);
				ps.setTimestamp(4, startTimeStamp);
				ps.setTimestamp(5, endTimeStamp);
				ps.setTimestamp(6, startTimeStamp);
				ps.setTimestamp(7, endTimeStamp);

				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);

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

					TimePeriod veInsSchedule = new TimePeriod();
					veInsSchedule.setStartTime(sTime);
					veInsSchedule.setEndTime(eTime);
					ScheduledEvent veInsScheduledEvent = new ScheduledEvent();
					veInsScheduledEvent.setTimePeriod(veInsSchedule);
					veInsScheduledEvent.setSchId(schId);
					veScheduleList.add(veInsScheduledEvent);

				}

				rs.close();
				ps.close();

			}
			catch(SQLException e) {

				e.printStackTrace();

			}
		}
		
    	return veScheduleList;

	}
	
	/**
	 * 
	 * @param veType
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	// public synchronized Host assignHost(
	public Host assignHost(
			VirtualEnvironmentType veType, 
			Calendar startTime,
			Calendar endTime) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignHost] Inside!");
		
		Host host = null;
		ArrayList<Host> hostList = new ArrayList<Host>();
		
	    int index = -1;
	    
	    try {

	    	PreparedStatement ps = conn.prepareStatement(
    		"SELECT host.*,count FROM host LEFT JOIN (SELECT host.id,count(host.id) " +
    		"FROM host,ve_ins,ve_ins_sch WHERE host.active='t' AND ve_ins.active='t' " +
    		"AND ve_ins_sch.active='t' AND host.id=ve_ins_sch.host_id AND " +
    		"ve_ins.id=ve_ins_sch.ve_ins_id AND " +
    		"((ve_ins_sch.start_time < ? AND ve_ins_sch.start_time >= ?) OR " +
    		"(ve_ins_sch.end_time > ? AND ve_ins_sch.end_time <= ?) OR " +
    		"(ve_ins_sch.start_time < ? AND ve_ins_sch.end_time > ?)) " +
    		"GROUP BY host.id) " +
    		"as foo ON foo.id=host.id WHERE host.active='t'");
    	    
    		Timestamp startTimeStamp = new Timestamp(startTime.getTime().getTime());
    		Timestamp endTimeStamp = new Timestamp(endTime.getTime().getTime());
    		ps.setTimestamp(1, endTimeStamp);
    		ps.setTimestamp(2, startTimeStamp);
    		ps.setTimestamp(3, startTimeStamp);
    		ps.setTimestamp(4, endTimeStamp);
    		ps.setTimestamp(5, startTimeStamp);
    		ps.setTimestamp(6, endTimeStamp);
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignHost] ps: " + ps);
    		
    		ResultSet rs = ps.executeQuery();
    	    
    		int free = 0;
    		int i = 0;
    		while (rs.next()) {

    	   		int id = rs.getInt("id");
    	   		if (getHostMainSchList(id, startTime, endTime).size() > 0)
    	   			continue;
    	   		
    	   		String name = rs.getString("name");
    	   		int ssh_port = rs.getInt("ssh_port");
    	   		String username = rs.getString("username");
    	   		String password = rs.getString("password");
    	   		int ve_num_cap = rs.getInt("ve_num_cap");
    	   		int ve_first_free_port = rs.getInt("ve_first_free_port");
    	   		int ve_port_num = rs.getInt("ve_port_num");
    	   		boolean active = rs.getBoolean("active");
    	   		boolean newAssignment = rs.getBoolean("new_assignment");
    	   		
    	   		int count = rs.getInt("count");
    	   		if(ve_num_cap - count > free) {
    	   			free = ve_num_cap - count;
    	   			index = i;
    	   		}
          		
        		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignHost] " +
        				" host id: " + id + " i: " + i + " index: " + index + 
        				" free: " + free + " count: " + count + " ve_num_cap: " + ve_num_cap);

        		Host tempHost = new Host(id, name, ssh_port, username, password, ve_num_cap,
          			ve_first_free_port, ve_port_num, active, newAssignment);
          		
          		hostList.add(tempHost);
          		i++;
    		}
    		
    		rs.close();
    	    ps.close();
    	
    	}
    	catch(SQLException e) {
	    
    		e.printStackTrace();
	
    	}
    	
    	if (index >= 0)
    		host = hostList.get(index);
    	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignHost] " +
				" index: " + index);

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignHost] Ready to get out!");
    	
    	return host;
	}

	/**
	 * 
	 * @param hostId
	 * @param veType
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	/*
	public int getRouterNum(int hostId, VirtualEnvironmentType veType,
			Calendar startTime, Calendar endTime) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getRouterNum] Inside!");

		int routerNum = 0;
		
		try {

	    	PreparedStatement ps = conn.prepareStatement(
	    		"SELECT count(*) FROM host,ve_ins,ve_ins_sch WHERE host.id=? AND " +
	    		"host.id=ve_ins_sch.host_id AND ve_ins.id=ve_ins_sch.ve_ins_id AND " +
	    		"host.active='t' AND ve_ins.active='t' AND ve_ins_sch.active='t' AND" +
	    		"((ve_ins_sch.start_time < ? AND ve_ins_sch.start_time >= ?) OR " +
	    		"(ve_ins_sch.end_time > ? AND ve_ins_sch.end_time <= ?) OR " +
	    		"(ve_ins_sch.start_time < ? AND ve_ins_sch.end_time > ?))");
    	    
    		ps.setInt(1, hostId);
	    	Timestamp startTimeStamp = new Timestamp(startTime.getTime().getTime());
    		Timestamp endTimeStamp = new Timestamp(endTime.getTime().getTime());
    		ps.setTimestamp(2, endTimeStamp);
    		ps.setTimestamp(3, startTimeStamp);
    		ps.setTimestamp(4, startTimeStamp);
    		ps.setTimestamp(5, endTimeStamp);
    		ps.setTimestamp(6, startTimeStamp);
    		ps.setTimestamp(7, endTimeStamp);
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
    		ResultSet rs = ps.executeQuery();
    	    
    		if (rs.next()) {

    	   		routerNum = rs.getInt("count") + 1;
    	   		
    		}
    		
    		rs.close();
    	    ps.close();
    	
    	}
    	catch(SQLException e) {
	    
    		e.printStackTrace();
	
    	}

    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getRouterNum] Ready to get out!");

    	return routerNum;

	}
*/
	
	// public synchronized ArrayList<TimePeriod> getHostUserScheduledList(
	public ArrayList<TimePeriod> getHostUserScheduledList(
			int hostId,
			Calendar startTime, 
			Calendar endTime) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostUserScheduledList] Inside!");
		
		ArrayList<TimePeriod> hostUserSchList = new ArrayList<TimePeriod>();
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
				"SELECT * FROM ve_ins,ve_ins_sch WHERE ve_ins_sch.host_id=? AND " +
				"ve_ins.id=ve_ins_sch.ve_ins_id AND ve_ins.active='t' AND " +
				"ve_ins_sch.active='t' AND" +
	    		"((ve_ins_sch.start_time < ? AND ve_ins_sch.start_time >= ?) OR " +
	    		"(ve_ins_sch.end_time > ? AND ve_ins_sch.end_time <= ?) OR " +
	    		"(ve_ins_sch.start_time < ? AND ve_ins_sch.end_time > ?))");
			
    		ps.setInt(1, hostId);
	    	Timestamp startTimeStamp = new Timestamp(startTime.getTime().getTime());
    		Timestamp endTimeStamp = new Timestamp(endTime.getTime().getTime());
    		ps.setTimestamp(2, endTimeStamp);
    		ps.setTimestamp(3, startTimeStamp);
    		ps.setTimestamp(4, startTimeStamp);
    		ps.setTimestamp(5, endTimeStamp);
    		ps.setTimestamp(6, startTimeStamp);
    		ps.setTimestamp(7, endTimeStamp);
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
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
				
				TimePeriod timePeriod = new TimePeriod();
				timePeriod.setStartTime(sTime);
				timePeriod.setEndTime(eTime);
				hostUserSchList.add(timePeriod);
		   		
	    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostUserScheduledList] " +
	    				"hostUserSchList.size: " + hostUserSchList.size());

    		}
    		
    		rs.close();
    	    ps.close();
    	
 		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostUserScheduledList] Ready to get out!");
		
		return hostUserSchList;
	}

	/**
	 * Return all the active & undone tasks of a certain type that are scheduled 
	 * for the time or before.
	 */
	// public synchronized Collection<SchedulingTask> getTasks(
	public Collection<SchedulingTask> getTasks(
							SchedulingTask.TaskType type, 
			Calendar time) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks] Inside!");
		
		ArrayList<SchedulingTask> tasks = new ArrayList<SchedulingTask>();

		try {

			if (type == SchedulingTask.TaskType.STOP) {
				PreparedStatement ps = 
					conn.prepareStatement(
							"SELECT ins.id as ve_ins_id, sch.id as ve_ins_sch_id, " +
							"	sch.host_id, ins.username, ins.ve_type, ins.storage_id, " +
							"	ins.first_port, ins.num_ports, ins.first_mac, ins.num_macs " +
							"	FROM ve_ins as ins, ve_ins_sch as sch, host " +
							"	WHERE ins.id=sch.ve_ins_id AND sch.host_id=host.id AND " +
							"	host.active='t' AND ins.active='t' AND sch.active='t' AND " +
							"	sch.done='f' AND " +
							"	(ins.status=? OR ins.status=? OR ins.status=?) AND " +
							"	sch.end_time<=? " +
							"	ORDER BY sch.end_time");

				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks] time: " + time.getTime());
				Timestamp ts = new Timestamp(time.getTime().getTime());

				ps.setString(1, VEInstance.VEInsStatusType.RUNNING.toString());
				ps.setString(2, VEInstance.VEInsStatusType.PROVISIONING_AND_STARTING.toString());
				ps.setString(3, VEInstance.VEInsStatusType.STARTING.toString());
				ps.setTimestamp(4, ts);

				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks] ps: " + ps);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					String veInsId = rs.getString("ve_ins_id");
					String veInsSchId = rs.getString("ve_ins_sch_id");
					int hostId = rs.getInt("host_id");
					String username = rs.getString("username");
					String veTypeName = rs.getString("ve_type");
					int storageId = rs.getInt("storage_id");
					VirtualEnvironmentType veType = new VirtualEnvironmentType();
					// TODO
					veType.setVEName(veTypeName);
					int firstPort = rs.getInt("first_port");
					int numPorts = rs.getInt("num_ports");
					int firstMac = rs.getInt("first_mac");
					int numMacs = rs.getInt("num_macs");

					PreparedStatement ps2 = 
						conn.prepareStatement(
								"SELECT router_id from host_used_routers " +
								"WHERE ve_ins_id=?");
					
					ps2.setString(1, veInsId);

					DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks] ps2: " + ps2);

					ResultSet rs2 = ps2.executeQuery();

					if (rs2.next()) {

						int routerId = rs2.getInt("router_id");
						
						SchedulingTask t = 
							new SchedulingTask(
									type, 
									veInsId,
									veInsSchId,
									hostId, 
									username, 
									veType,
									firstPort,
									numPorts,
									firstMac,
									numMacs,
									routerId,
									storageId,
									0);
						tasks.add(t);
					
					}

					rs2.close();
					ps2.close();

				}

				rs.close();
				ps.close();
				
			}
			else if (type == SchedulingTask.TaskType.START) {
				PreparedStatement ps = 
					conn.prepareStatement(
							"SELECT ins.id as ve_ins_id, sch.id as ve_ins_sch_id, " +
							"	sch.host_id, ins.username, ins.ve_type, ins.storage_id, " +
							"	ins.first_port, ins.num_ports, ins.first_mac, ins.num_macs " +
							"	FROM ve_ins as ins, ve_ins_sch as sch, host " +
							"	WHERE ins.id=sch.ve_ins_id AND sch.host_id=host.id AND " +
							"	host.active='t' AND ins.active='t' AND sch.active='t' AND " +
							"	sch.done='f' AND " +
							"	(ins.status=? OR ins.status=? OR ins.status=?) " +
							"	AND sch.start_time<=? " +
							"	ORDER BY sch.start_time");

				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks] time: " + time.getTime());
				Timestamp ts = new Timestamp(time.getTime().getTime());

				ps.setString(1, VEInstance.VEInsStatusType.NOT_PROVISIONED.toString());
				ps.setString(2, VEInstance.VEInsStatusType.PAUSED.toString());
				ps.setString(3, VEInstance.VEInsStatusType.PAUSING.toString());
				ps.setTimestamp(4, ts);

				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks] ps: " + ps);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					String veInsId = rs.getString("ve_ins_id");
					String veInsSchId = rs.getString("ve_ins_sch_id");
					int hostId = rs.getInt("host_id");
					String username = rs.getString("username");
					String veTypeName = rs.getString("ve_type");
					int storageId = rs.getInt("storage_id"); 
					VirtualEnvironmentType veType = new VirtualEnvironmentType();
					// TODO
					veType.setVEName(veTypeName);
					int firstPort = rs.getInt("first_port");
					int numPorts = rs.getInt("num_ports");
					int firstMac = rs.getInt("first_mac");
					int numMacs = rs.getInt("num_macs");

					PreparedStatement ps2 = 
						conn.prepareStatement(
								"SELECT * from host_used_routers " +
								"	WHERE host_id=? and ve_ins_id=?");
					
					ps2.setInt(1, hostId);
					ps2.setString(2, veInsId);

					DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks] ps2: " + ps2);

					ResultSet rs2 = ps2.executeQuery();

					int routerId = 0;
					if (rs2.next())
						routerId = rs2.getInt("router_id");

					rs2.close();
					ps2.close();

					SchedulingTask t = 
						new SchedulingTask(
								type, 
								veInsId,
								veInsSchId,
								hostId, 
								username, 
								veType,
								firstPort,
								numPorts,
								firstMac,
								numMacs,
								routerId,
								storageId,
								getRegisterAction(veInsId, hostId, storageId));
					tasks.add(t);

				}

				rs.close();
				ps.close();
				
			}

		}
		catch(SQLException e) {
		
			e.printStackTrace();
		
		}

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks] Ready to get out!");
		
		return tasks;

	}

	public int allocateRouterId(
			String veInsId,
			int hostId,
			int storageId) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - allocateRouterId] Inside!");

		int routerId = 0;
		
		try {
			PreparedStatement ps;
			ps = conn.prepareStatement(
					"SELECT * from host_used_routers " +
					"	WHERE host_id=? order by router_id");

			ps.setInt(1, hostId);

			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks] ps: " + ps);

			ResultSet rs = ps.executeQuery();

			int prevRouterId = 0;
			boolean found = false;

			while (rs.next()) {
				routerId = rs.getInt("router_id");

				if (routerId > prevRouterId+1) {
					routerId = prevRouterId + 1;
					found = true;
					break;
				} else {
					prevRouterId = routerId;
				}
			}

			rs.close();
			ps.close();

			if (!found) {
				Host host = getHost(hostId);
				if (host.getVeNumCap() > routerId) {					
					routerId = routerId + 1;
					found = true;
				}
			}

			if (found)
				addHostUsedRouters(hostId, veInsId, routerId);
			else
				routerId = 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - allocateRouterId] Ready to get out!");

		return routerId;
	}

	/**
	 * 
	 * returns 0, 1, or 2
	 * 0 = needs provisioning, assignment, and registration (First time anywhere)
	 * 1 means that you only need to register (Has already been provisioned and assigned on another host)
	 * 2 means that there is no need to register (Has already been provisioned and assigned on this host)
	 */
	private int getRegisterAction(
			String veInsId,
			int hostId,
			int storageId) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getRegisterAction] Inside!");
		
		int registerAction = -1;
		
		PreparedStatement ps;
		try {
			
			ps = conn.prepareStatement(
					"SELECT * FROM ve_ins_host " +
					"	WHERE ve_ins_id=? AND host_id=?");

			ps.setString(1, veInsId);
			ps.setInt(2, hostId);

			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getRegisterAction] ps: " + ps);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				registerAction = 2;
			} else {
				if (hostId == storageId)
					registerAction = 0;
				else
					registerAction = 1;
			}
			
			rs.close();
			ps.close();

		} catch (SQLException e) {

			e.printStackTrace();
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getRegisterAction] Ready to get out!");
			
		return registerAction;
	}

	/*
	public boolean setTaskIsDone(SchedulingTask task) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setTaskIsDone] Inside!");

		boolean retVal = false;
		
		try {

			PreparedStatement ps = 
				conn.prepareStatement(
						"UPDATE ve_ins SET status=? " +
						"	WHERE active='t' and id=? and host_id=?");

			if (task.getType() == SchedulingTask.TaskType.STOP) 
				ps.setString(1, VEInstance.VEInsStatusType.PAUSED.toString());
			else if (task.getType() == SchedulingTask.TaskType.START) 
				ps.setString(1, VEInstance.VEInsStatusType.RUNNING.toString());
			ps.setString(2, task.getVeInsId());
			ps.setInt(3, task.getHostId());

			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks] ps: " + ps);

			retVal = ps.execute();

			ps.close();
				
		}
		catch(SQLException e) {
		
			e.printStackTrace();
		
		}

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setTaskIsDone] Ready to get out!");
		
		return retVal;
				
	}
	*/

	// public synchronized int getHostUsedRouters(int hostId, String veInsId) {
	public int getHostUsedRouters(int hostId, String veInsId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostUsedPorts] Inside!");

		int routerId = -1;
		
		try {
			
			PreparedStatement ps = 
				conn.prepareStatement(
						"SELECT * FROM host_used_routers " +
						"	WHERE host_id=? and ve_ins_id=?");
			
			ps.setInt(1, hostId);
			ps.setString(2, veInsId);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostUsedPorts] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				
				routerId = rs.getInt("router_id");
				
			}
		
			rs.close();
			ps.close();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostUsedPorts] Ready to get out!");
	
		return routerId;

	}

	// public synchronized boolean addHostUsedRouters(int hostId, String veInsId, int routerId) {
	public boolean addHostUsedRouters(int hostId, String veInsId, int routerId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addHostUsedPorts] Inside!");

		boolean retVal = false;

		if (getHostUsedRouters(hostId, veInsId) != -1)
			return retVal;
		
		try {
			
			PreparedStatement ps = 
				conn.prepareStatement(
						"INSERT INTO " +
						"	host_used_routers(host_id,ve_ins_id,router_id)" +
						"	VALUES(?,?,?)");
			
			ps.setInt(1, hostId);
			ps.setString(2, veInsId);
			ps.setInt(3, routerId);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addHostUsedPorts] ps: " + ps);
			
			retVal = ps.execute();
		
			ps.close();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addHostUsedPorts] Ready to get out!");
	
		return retVal;

	}

	// public synchronized boolean delHostUsedRouters(int hostId, String veInsId, int routerId) {
	public boolean delHostUsedRouters(int hostId, String veInsId, int routerId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delHostUsedPorts] Inside!");

		boolean retVal = false;
		
		if (getHostUsedRouters(hostId, veInsId) == -1)
			return retVal;
		
		try {
			
			PreparedStatement ps = 
				conn.prepareStatement(
						"DELETE FROM host_used_routers " +
						"	WHERE host_id=? and ve_ins_id=? and router_id=?");
			
			ps.setInt(1, hostId);
			ps.setString(2, veInsId);
			ps.setInt(3, routerId);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delHostUsedPorts] ps: " + ps);
			
			ps.execute();
		
			retVal = true;
			
			ps.close();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delHostUsedPorts] Ready to get out!");
	
		return retVal;

	}

	// public synchronized void delHostUsedRoutersByVEInsId(String veInsId) {
	public void delHostUsedRoutersByVEInsId(String veInsId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delHostUsedRoutersByVEInsId] Inside!");

		boolean retVal = false;
		
		try {
			
			PreparedStatement ps = 
				conn.prepareStatement(
						"DELETE FROM host_used_routers " +
						"	WHERE ve_ins_id=?");
			
			ps.setString(1, veInsId);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delHostUsedRoutersByVEInsId] ps: " + ps);
			
			ps.execute();
		
			retVal = true;
			
			ps.close();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delHostUsedRoutersByVEInsId] Ready to get out!");
	
	}

	public Calendar getNextTaskTime() {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getNextTaskTime] Inside!");
		
		Calendar nextTaskTime = null;
		Calendar firstStopTask = null;
		Calendar firstStartTask = null;
		
		Calendar farTime = Calendar.getInstance();
		farTime.add(Calendar.YEAR, 10);
		
		// get the first stop task if any
		ArrayList<SchedulingTask> stopTasks = 
			(ArrayList<SchedulingTask>) getTasks(
				SchedulingTask.TaskType.STOP,
				farTime);
		
		if (stopTasks != null) {
			
			if (stopTasks.size() > 0) {

				VEInstanceSchedule veInsSch = getVEInsSch(stopTasks.get(0).getVeInsSchId());
				firstStopTask = veInsSch.getEndTime();
			
			}

		}
		
		// get the first start task if any
		ArrayList<SchedulingTask> startTasks = 
			(ArrayList<SchedulingTask>) getTasks(
				SchedulingTask.TaskType.START,
				farTime);
		
		if (startTasks != null) {
		
			if (startTasks.size() > 0) {
				
				VEInstanceSchedule veInsSch = getVEInsSch(startTasks.get(0).getVeInsSchId());
				firstStartTask = veInsSch.getStartTime();

			}

		}
		
		if ((firstStopTask == null) && (firstStartTask == null))
			nextTaskTime = null;
		else if ((firstStopTask == null) && (firstStartTask != null))
			nextTaskTime = firstStartTask;
		else if ((firstStopTask != null) && (firstStartTask == null))
			nextTaskTime = firstStopTask;
		else if ((firstStopTask != null) && (firstStartTask != null)) {
		
			if (firstStopTask.before(firstStartTask))
				nextTaskTime = firstStopTask;
			else
				nextTaskTime = firstStartTask;
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getNextTaskTime] Ready to get out!");
		
		return nextTaskTime;

	}

	/**
	 * Gets a VM instance using its id.
	 * @param id
	 * @return
	 */
	public VMInstance getVMInstance(String id) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVMInstance] Inside!");
		
		VMInstance vmIns = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM vm_ins WHERE id=?");
	    
			ps.setString(1, id);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVMInstance] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				String retId = rs.getString("id");
				String veInsId = rs.getString("ve_ins_id");
				String name = rs.getString("name");
				String dir = rs.getString("dir");
				String domain = rs.getString("domain");
				String os = rs.getString("os");
				String internalAddress = rs.getString("internal_address");
				int accessPort = rs.getInt("access_port");
				String macAddress = rs.getString("mac_address");
				String statusString = rs.getString("status");
				VMInsStatusType status = VMInstance.getStatus(statusString);
				Calendar lastCheckin = Calendar.getInstance();
				lastCheckin.setTime(rs.getTimestamp("last_checkin"));
				String appName = rs.getString("app_name");
				String appDir = rs.getString("app_dir");
				boolean active = rs.getBoolean("active");

				vmIns = new VMInstance(
						retId, 
						veInsId,
						name,
						dir,
						domain,
						os,
						internalAddress,
						accessPort,
						macAddress,
						status,
						lastCheckin,
						appName,
						appDir,
						active);
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVMInstance] Ready to get out!");
		
		return vmIns;
	}

	/**
	 * Gets a VM instances of a VE instance.
	 * @param veInsId
	 * @return
	 */
	public ArrayList<VMInstance> getVMInstancesByVEInsId(String veInsId) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVMInstancesByVEInsId] Inside!");
		
		ArrayList<VMInstance> vmInstances = new ArrayList<VMInstance>(); 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM vm_ins WHERE ve_ins_id=? ORDER BY access_port");
	    
			ps.setString(1, veInsId);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVMInstancesByVEInsId] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			while (rs.next()) {
		
				String id = rs.getString("id");
				String retVeInsId = rs.getString("ve_ins_id");
				String name = rs.getString("name");
				String dir = rs.getString("dir");
				String domain = rs.getString("domain");
				String os = rs.getString("os");
				String internalAddress = rs.getString("internal_address");
				int accessPort = rs.getInt("access_port");
				String macAddress = rs.getString("mac_address");
				String statusString = rs.getString("status");
				VMInsStatusType status = VMInstance.getStatus(statusString);
				Calendar lastCheckin = Calendar.getInstance();
				lastCheckin.setTime(rs.getTimestamp("last_checkin"));
				String appName = rs.getString("app_name");
				String appDir = rs.getString("app_dir");
				boolean active = rs.getBoolean("active");

				VMInstance vmIns = new VMInstance(
						id, 
						retVeInsId,
						name,
						dir,
						domain,
						os,
						internalAddress,
						accessPort,
						macAddress,
						status,
						lastCheckin,
						appName,
						appDir,
						active);
				vmInstances.add(vmIns);
				
			}
	
			rs.close();
			ps.close();
	       
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVMInstancesByVEInsId] Ready to get out!");
		
		return vmInstances;
	}

	/**
	 * Gets a VM instance using its macAddress.
	 * @param macAddress
	 * @return
	 */
	public VMInstance getVMInstanceUsingMac(String macAddress) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVMInstanceUsingMac] Inside!");
		
		VMInstance vmIns = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM vm_ins WHERE active='t' and mac_address=?");
	    
			ps.setString(1, macAddress);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVMInstanceUsingMac] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				String id = rs.getString("id");
				String veInsId = rs.getString("ve_ins_id");
				String name = rs.getString("name");
				String dir = rs.getString("dir");
				String domain = rs.getString("domain");
				String os = rs.getString("os");
				String internalAddress = rs.getString("internal_address");
				int accessPort = rs.getInt("access_port");
				String retMacAddress = rs.getString("mac_address");
				String statusString = rs.getString("status");
				VMInsStatusType status = VMInstance.getStatus(statusString);
				Calendar lastCheckin = Calendar.getInstance();
				lastCheckin.setTime(rs.getTimestamp("last_checkin"));
				String appName = rs.getString("app_name");
				String appDir = rs.getString("app_dir");
				boolean active = rs.getBoolean("active");

				vmIns = new VMInstance(
						id, 
						veInsId,
						name,
						dir,
						domain,
						os,
						internalAddress,
						accessPort,
						retMacAddress,
						status,
						lastCheckin,
						appName,
						appDir,
						active);
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVMInstanceUsingMac] Ready to get out!");
		
		return vmIns;
	}

	/**
	 * Sets a VM instance using its id.
	 * @param vmIns
	 * @return
	 */
	public boolean setVMInstance(VMInstance vmIns) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVMInstance] Inside!");
		
		boolean retVal = false;
		
		if (getVMInstance(vmIns.getId()).getStatus() != vmIns.getStatus())
			setVMInsStatus(vmIns.getId(), vmIns.getStatus());
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE vm_ins " +
					"	SET ve_ins_id=?,name=?,dir=?,domain=?,os=?,internal_address=?,access_port=?," +
					"	mac_address=?,status=?,last_checkin=?,app_name=?,app_dir=?,active=? " +
					"	WHERE id=?"
					);
			
			ps.setString(1, vmIns.getVeInsId());
			ps.setString(2, vmIns.getName());
			ps.setString(3, vmIns.getDir());
			ps.setString(4, vmIns.getDomain());
			ps.setString(5, vmIns.getOs());
			ps.setString(6, vmIns.getInternalAddress());
			ps.setInt(7, vmIns.getAccessPort());
			ps.setString(8, vmIns.getMacAddress());
			ps.setString(9, vmIns.getStatus().toString());
			Timestamp ts = new Timestamp(vmIns.getLastCheckin().getTime().getTime());
			ps.setTimestamp(10, ts);
			ps.setString(11, vmIns.getAppName());
			ps.setString(12, vmIns.getAppDir());
			ps.setBoolean(13, vmIns.isActive());
			ps.setString(14, vmIns.getId());
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVMInstance] ps: " + ps);
			
			ps.execute();

			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;
			
			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVMInstance] Ready to get out!");
		
		return retVal;
	
	}

	/**
	 * Sets a VM instance status using its id.
	 * @param vmInsId
	 * @param status
	 * @return
	 */
	public boolean setVMInsStatus(String vmInsId, VMInsStatusType status) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVMInstanceStatus] Inside!");
		
		boolean retVal = false;
		
		// VMInstance prevVMIns = getVMInstance(vmInsId);
		// if (prevVMIns.getStatus() != status) {

		try {

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE vm_ins " +
					"	SET status=?" +
					"	WHERE id=?"
			);

			ps.setString(1, status.toString());
			ps.setString(2, vmInsId);

			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVMInstanceStatus] ps: " + ps);

			ps.execute();

			int count = ps.getUpdateCount();
			if (count > 0)
				retVal = true;

			ps.close();

			// TODO
			/*
			if (status == VMInsStatusType.DESTROYED) {

				VMInstance veIns = getVMInstance(vmInsId);
				veIns.setActive(false);
				setVMInstance(veIns);

			}
			*/
			
			// updateVEInsStatus(prevVMIns.getVeInsId());

		}
		catch (Exception e) {

			e.printStackTrace();

		}

//		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVMInstanceStatus] Ready to get out!");
		
		return retVal;
	
	}

	public boolean setVMInsStatusByVeInsId(
			String veInsId,
			VMInsStatusType status) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVMInsStatusByVeInsId] Inside!");
		
		boolean retVal = false;
		
		try {
	
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE vm_ins " +
					"	SET status=?" +
					"	WHERE ve_ins_id=?"
			);
	
			ps.setString(1, status.toString());
			ps.setString(2, veInsId);
	
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVMInsStatusByVeInsId] ps: " + ps);
	
			ps.execute();
	
			int count = ps.getUpdateCount();
			if (count > 0)
				retVal = true;
	
			ps.close();
	
			// TODO for destroyed
			/*
			if (status == VMInsStatusType.DESTROYED) {
	
				VMInstance veIns = getVMInstance(vmInsId);
				veIns.setActive(false);
				setVMInstance(veIns);
	
			}
			*/
	
			// updateVEInsStatus(prevVMIns.getVeInsId());
	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setVMInsStatusByVeInsId] Ready to get out!");
		
		return retVal;
	}

	public void updateVEInsStatus(String veInsId) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - updateVEInsStatus] Inside!");
		
		boolean checkForUpdate = false;
		VMInsStatusType statusToBeChecked = null;
		
		try {
			
			VEInstance veIns = getVEInstance(veInsId);

			if ((veIns.getStatus() == VEInsStatusType.PROVISIONING_AND_STARTING) ||
				(veIns.getStatus() == VEInsStatusType.STARTING                 )) {
				
				// If the status of the ve instance is PROVISIONING_AND_STARTING or STARTING
				// then we should check to see if there is any changes in the status of the 
				// vm instances of this ve instance.
				checkForUpdate = true;
				statusToBeChecked = VMInsStatusType.RUNNING;
				
			} else if (veIns.getStatus() == VEInsStatusType.PAUSING) {
					
				// First set PAUSED for those vm instances for this ve instance that have been
				// in PAUSING state for the passed 60 seconds. Note that the checkin frequency
				// is assumed to be 30 seconds.
				// TODO I need to create two more variables in the configuration for the 
				// checkin frequency and for the timeout.
				int timeout = 60; // 60 seconds

				PreparedStatement ps = 
					conn.prepareStatement(
							"UPDATE vm_ins SET status=? " +
							"	WHERE ve_ins_id=? AND status=? AND last_checkin<?");

				ps.setString(1, VMInsStatusType.PAUSED.toString());
				ps.setString(2, veInsId);
				ps.setString(3, VMInsStatusType.PAUSING.toString());
				Calendar time = Calendar.getInstance();
				time.add(Calendar.SECOND, -1*timeout);
				Timestamp ts = new Timestamp(time.getTime().getTime());
				ps.setTimestamp(4, ts);

				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - updateVEInsStatus] ps: " + ps);

				ps.execute();

				int count = ps.getUpdateCount();
			    if (count > 0) {
					// If there was some changes in the status of the vm instances of this
					// ve instance, then we should whether we need to change the status of 
					// the ve instance too.
					checkForUpdate = true;			
					statusToBeChecked = VMInsStatusType.PAUSED;
			    }
			    
				ps.close();
				
			} else {
				// there is no need for any updates
				checkForUpdate = false;
			}
			
			if (checkForUpdate) {
				
				PreparedStatement ps = 
					conn.prepareStatement(
							"SELECT count(*) FROM vm_ins " +
							"	WHERE ve_ins_id=? and status=?");
			
				ps.setString(1, veInsId);
				ps.setString(2, statusToBeChecked.toString());
				
				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - updateVEInsStatus] ps: " + ps);
				
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) {
					
					// TODO the number of VMs for a VE Type should be read from VE Type file
					if (rs.getInt("count") == 5) {

						VEInsStatusType veInsStatusType = null;
						if (statusToBeChecked == VMInsStatusType.RUNNING)
							veInsStatusType = VEInsStatusType.RUNNING;
						else if (statusToBeChecked == VMInsStatusType.PAUSED)
							veInsStatusType = VEInsStatusType.PAUSED;
				
						setVEInsStatus(veInsId, veInsStatusType);
					}					
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - updateVEInsStatus] Ready to get out!");
		
	}

	/**
	 * Adds a new VM instance.
	 * @param vmIns
	 * @return Returns the newly generate VM instance id.
	 */
	public String addVMInstance(VMInstance vmIns) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addVMInstance] Inside!");
		
		String id = null;
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO " +
					"	vm_ins(id,ve_ins_id,name,dir,domain,os,internal_address,access_port," +
					"		mac_address,status,last_checkin,app_name,app_dir,active)" +
					"	VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?) " +
					"	RETURNING id"
					);
			
			if (vmIns.getId() == null)
				ps.setString(1, UUID.randomUUID().toString());
			else
				ps.setString(1, vmIns.getId());
			ps.setString(2, vmIns.getVeInsId());
			ps.setString(3, vmIns.getName());
			ps.setString(4, vmIns.getDir());
			ps.setString(5, vmIns.getDomain());
			ps.setString(6, vmIns.getOs());
			ps.setString(7, vmIns.getInternalAddress());
			ps.setInt(8, vmIns.getAccessPort());
			ps.setString(9, vmIns.getMacAddress());
			ps.setString(10, vmIns.getStatus().toString());
			Timestamp ts = new Timestamp(vmIns.getLastCheckin().getTime().getTime());
			ps.setTimestamp(11, ts);
			ps.setString(12, vmIns.getAppName());
			ps.setString(13, vmIns.getAppDir());
			ps.setBoolean(14, vmIns.isActive());
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addVMInstance] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				id = rs.getString("id");
				vmIns.setId(id);
				
			}
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addVMInstance] Ready to get out!");
		
		return id;
		
	}

	public void delVMsByVEInsId(String veInsId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delVMsByVEInsId] Inside!");
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM vm_ins" +
					"	WHERE ve_ins_id=?"
					);
			
			ps.setString(1, veInsId);
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delVMsByVEInsId] ps: " + ps);
			ps.execute();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delVMsByVEInsId] Ready to get out!");
	}

	/*
	public boolean checkin(String macAddress) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - checkin] Inside!");
		
		boolean retVal = false;
		
		VMInstance vmIns = getVMInstanceUsingMac(macAddress);
		vmIns.setStatus(VMInsStatusType.RUNNING);
		vmIns.setLastCheckin(Calendar.getInstance());
		setVMInstance(vmIns);
		retVal = true;
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - checkin] Ready to get out!");
		
		return retVal;
		
	}
	*/
	public void updateVEInstancesStatus() {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - updateVEInstancesStatus] Inside!");
		
		ArrayList<VEInstance> veInstances = getVEInstancesWithTempStatus();
		for (VEInstance veIns : veInstances)
			updateVEInsStatus(veIns.getId());
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - updateVEInstancesStatus] Ready to get out!");		
	}

	private ArrayList<VEInstance> getVEInstancesWithTempStatus() {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstancesWithTempStatus] Inside!");
		
		ArrayList<VEInstance> veInstances = new ArrayList<VEInstance>(); 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM ve_ins " +
					"	WHERE active='t' AND (status=? OR status=? OR status=?)");
	    
			// The temporary statuses are the following ones:
			ps.setString(1, VEInsStatusType.PROVISIONING_AND_STARTING.toString());
			ps.setString(2, VEInsStatusType.STARTING.toString());
			ps.setString(3, VEInsStatusType.PAUSING.toString());
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstancesWithTempStatus] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			while (rs.next()) {
		
				String retId = rs.getString("id");
				String username = rs.getString("username");
				String veTypeName = rs.getString("ve_type");
				VirtualEnvironmentType veType = new VirtualEnvironmentType();
				// TODO
				veType.setVEName(veTypeName);
				int storageId = rs.getInt("storage_id");
				int kserverId = rs.getInt("kserver_id");
				int veFirstFreePort = rs.getInt("first_port");
				int vePortNum = rs.getInt("num_ports");
				int veFirstFreeMac = rs.getInt("first_mac");
				int veMacNum = rs.getInt("num_macs");
				boolean store = rs.getBoolean("store");
				boolean active = rs.getBoolean("active");
				String statusString = rs.getString("status");
				VEInsStatusType status = VEInstance.getStatus(statusString);
				
				VEInstance veIns = 
					new VEInstance(
						retId, 
						username, 
						veType, 
						storageId, 
						kserverId,
						veFirstFreePort,
						vePortNum, 
						veFirstFreeMac,
						veMacNum, 
						store, 
						active,
						status); 
		
				veInstances.add(veIns);	
			}
	
			rs.close();
			ps.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstancesWithTempStatus] Ready to get out!");
		
		return veInstances;
	}

	public ArrayList<VEInstance> getVEInstances() {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstances] Inside!");
		
		ArrayList<VEInstance> veInstances = new ArrayList<VEInstance>(); 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM ve_ins WHERE active='t'");
	    
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstances] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			while (rs.next()) {
		
				String retId = rs.getString("id");
				String username = rs.getString("username");
				String veTypeName = rs.getString("ve_type");
				VirtualEnvironmentType veType = new VirtualEnvironmentType();
				// TODO
				veType.setVEName(veTypeName);
				int storageId = rs.getInt("storage_id");
				int kserverId = rs.getInt("kserver_id");
				int veFirstFreePort = rs.getInt("first_port");
				int vePortNum = rs.getInt("num_ports");
				int veFirstFreeMac = rs.getInt("first_mac");
				int veMacNum = rs.getInt("num_macs");
				boolean store = rs.getBoolean("store");
				boolean active = rs.getBoolean("active");
				String statusString = rs.getString("status");
				VEInsStatusType status = VEInstance.getStatus(statusString);
				
				VEInstance veIns = 
					new VEInstance(
						retId, 
						username, 
						veType, 
						storageId, 
						kserverId,
						veFirstFreePort,
						vePortNum, 
						veFirstFreeMac,
						veMacNum, 
						store, 
						active,
						status); 
		
				veInstances.add(veIns);	
			}
	
			rs.close();
			ps.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstances] Ready to get out!");
		
		return veInstances;
	}

	public ArrayList<VEInstance> getVEInstances(String username) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstances] Inside!");
		
		ArrayList<VEInstance> veInstances = new ArrayList<VEInstance>(); 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM ve_ins WHERE active='t' AND username=?");
	    
			ps.setString(1, username);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstances] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			while (rs.next()) {
		
				String retId = rs.getString("id");
				String retUsername = rs.getString("username");
				String veTypeName = rs.getString("ve_type");
				VirtualEnvironmentType veType = new VirtualEnvironmentType();
				// TODO
				veType.setVEName(veTypeName);
				int storageId = rs.getInt("storage_id");
				int kserverId = rs.getInt("kserver_id");
				int veFirstFreePort = rs.getInt("first_port");
				int vePortNum = rs.getInt("num_ports");
				int veFirstFreeMac = rs.getInt("first_mac");
				int veMacNum = rs.getInt("num_macs");
				boolean store = rs.getBoolean("store");
				boolean active = rs.getBoolean("active");
				String statusString = rs.getString("status");
				VEInsStatusType status = VEInstance.getStatus(statusString);
				
				VEInstance veIns = 
					new VEInstance(
						retId, 
						retUsername, 
						veType, 
						storageId, 
						kserverId,
						veFirstFreePort,
						vePortNum, 
						veFirstFreeMac,
						veMacNum, 
						store, 
						active,
						status); 
		
				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstances] " +
						"vdIns: " + veIns);

				veInstances.add(veIns);	
			}
	
			rs.close();
			ps.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstances] Ready to get out!");
		
		return veInstances;
	}

	public ArrayList<String> getVEMacs(String veInsId) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEMacs] Inside!");
		
		ArrayList<String> macs = new ArrayList<String>();
		
		try {
			
			PreparedStatement ps =
				conn.prepareStatement(
						"SELECT * from vm_ins " +
						"	WHERE ve_ins_id=? and active='t' order by mac_address");
			
			ps.setString(1, veInsId);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEMacs] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
		
				macs.add(rs.getString("mac_address"));
				
			}
		
			rs.close();
			ps.close();
			
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEMacs] Ready to get out!");
		
		return macs;
		
	}

	public String getVEInsIdUsingMac(String macAddress) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInsIdUsingMac] Inside!");
		
		String veInsId = null;
		
		try {
		
			PreparedStatement ps = 
				conn.prepareStatement(
						"SELECT * from vm_ins " +
						"	WHERE active='t' and mac_address=?");
		
			ps.setString(1, macAddress);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInsIdUsingMac] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				veInsId = rs.getString("ve_ins_id");
				
			}
			
			rs.close();
			ps.close();
			
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
	
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInsIdUsingMac] Ready to get out!");
		
		return veInsId;
		
	}

	public boolean reserveResource(ReservedResource reservedResource) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - reserveResource] Inside!");
		
		boolean retVal = false;
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO " +
					"	reserved_resources(ve_type,start_time,end_time,quota,cancel)" +
					"	VALUES(?,?,?,?,?) " +
					"	RETURNING id"
					);
			
			ps.setString(1, reservedResource.getVeType().getVEName());
    		Timestamp startTimeStamp = new Timestamp(reservedResource.getStartTime().getTime().getTime());
    		ps.setTimestamp(2, startTimeStamp);
    		Timestamp endTimeStamp = new Timestamp(reservedResource.getEndTime().getTime().getTime());
    		ps.setTimestamp(3, endTimeStamp);
			ps.setInt(4, reservedResource.getQuota());
			ps.setBoolean(5, reservedResource.isCancel());
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - reserveResource] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				if (rs.getInt("id") > 0)
					retVal = true;
				
			}
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - reserveResource] Ready to get out!");
		
		return retVal;
		
	}
	
	public int addStorage(Storage storage) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addStorage] Inside!");
		
		int id = 0;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO " +
					"	storage(dir_path,gb_size,active)" +
					"   VALUES(?,?,?)" +
					"   RETURNING id");
		
			// ps.setInt(1, storage.getId());
			ps.setString(1, storage.getDirPath());
			ps.setInt(2, storage.getGbSize());
			ps.setBoolean(3, storage.isActive());
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
    		ResultSet rs = ps.executeQuery();

    		if (rs.next())
    			id = rs.getInt("id");
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addStorage] Ready to get out!");
		
		return id;
		
	}
	
	public boolean delStorage(int id) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delStorage] Inside!");
		
		boolean retVal = false;
				
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM storage WHERE id=?");
		
			ps.setInt(1, id);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delStorage] ps: " + ps);
			
			ps.execute();
			
			retVal = true;
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delStorage] Ready to get out!");
		
		return retVal;
		
	}
	
	public Storage getStorage(int id) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getStorage(id)] Inside!");
		
		Storage storage = null;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM storage WHERE id=?");
		
			ps.setInt(1, id);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getStorage(id)] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				storage = 
					new Storage(
						rs.getInt("id"),
						rs.getString("dir_path"),
						rs.getInt("gb_size"),
						rs.getBoolean("active"));
				
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getStorage(id)] Ready to get out!");
		
		return storage;
		
	}
	
	/**
	 * 
	 * @param active
	 * @return
	 */
	public ArrayList<Storage> getStorageList() {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getStorageList] Inside!");
		
		ArrayList<Storage> storageList = getStorageList(true);
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getStorageList] Ready to get out!");
		
		return storageList;
	
	}

	/**
	 * 
	 * @param active
	 * @return
	 */
	public ArrayList<Storage> getStorageList(boolean active) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getStorageList] Inside!");
		
		ArrayList<Storage> storageList = new ArrayList<Storage>();
		Storage storage = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM storage WHERE active=?");
	    
			ps.setBoolean(1, active);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			while (rs.next()) {
		
				storage = new Storage(
						rs.getInt("id"),
						rs.getString("dir_path"),
						rs.getInt("gb_size"),
						rs.getBoolean("active")); 
				storageList.add(storage);
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getStorageList] Ready to get out!");
		
		return storageList;
	
	}

	public boolean setStorage(Storage storage) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setStorage] Inside!");
		
		boolean retVal = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE storage SET dir_path=?,gb_size=?,active=? WHERE id=?");
		
			ps.setString(1, storage.getDirPath());
			ps.setInt(2, storage.getGbSize());
			ps.setBoolean(3, storage.isActive());
			ps.setInt(4, storage.getId());
			
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
			ps.execute();
			
			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setStorage] Ready to get out!");
		
		return retVal;
		
	}
	
	public boolean setStorageStatus(int id, boolean status) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setStorageStatus] Inside!");
		
		boolean retVal = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE storage SET active=? WHERE id=?");
		
			ps.setBoolean(1, status);
			ps.setInt(2, id);
			
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
			ps.execute();
			
			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;
						
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setStorageStatus] Ready to get out!");
		
		return retVal;
		
	}
	
	public boolean addHostStorage(HostStorage hostStorage) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addHostStorage] Inside!");
		
		boolean retVal = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO " +
					"	host_storage(host_id,storage_id,preference,active)" +
					"   VALUES(?,?,?,?)");
		
			ps.setInt(1, hostStorage.getHostId());
			ps.setInt(2, hostStorage.getStorageId());
			ps.setInt(3, hostStorage.getPreference());
			ps.setBoolean(4, hostStorage.isActive());
			
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
			ps.execute();
			
			retVal = true;
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addHostStorage] Ready to get out!");
		
		return retVal;
		
	}
	
	public boolean delHostStorage(int hostId, int storageId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delHostStorage] Inside!");
		
		boolean retVal = false;
				
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM host_storage WHERE host_id=? AND storage_id=?");
		
			ps.setInt(1, hostId);
			ps.setInt(2, storageId);
			
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
			ps.execute();
			
			retVal = true;
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delHostStorage] Ready to get out!");
		
		return retVal;
		
	}
	
	public HostStorage getHostStorage(int hostId, int storageId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostStorage] Inside!");
		
		HostStorage hostStorage = null;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM host_storage WHERE host_id=? AND storage_id=? AND active='t'");
		
			ps.setInt(1, hostId);
			ps.setInt(2, storageId);
			
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				hostStorage = 
					new HostStorage(
						rs.getInt("host_id"),
						rs.getInt("storage_id"),
						rs.getInt("preference"),
						rs.getBoolean("active"));
				
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostStorage] Ready to get out!");
		
		return hostStorage;
		
	}
	
	/**
	 * 
	 * @param active
	 * @return
	 */
	public ArrayList<HostStorage> getHostStorageList(
			int hostId,
			int storageId) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostStorageList] Inside!");
		
		ArrayList<HostStorage> hostStorageList = getHostStorageList(hostId, storageId, true);
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostStorageList] Ready to get out!");
		
		return hostStorageList;
	
	}

	/**
	 * 
	 * @param active
	 * @return
	 */
	public ArrayList<HostStorage> getHostStorageList(
			int hostId,
			int storageId, 
			boolean active) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostStorageList] Inside!");
		
		ArrayList<HostStorage> hostStorageList = new ArrayList<HostStorage>();
		HostStorage hostStorage = null; 
		
		try {
	    
			String query = 
					"SELECT * FROM host_storage as hs, host, storage " +
					"	WHERE hs.active=? AND host.active=? AND storage.active=?" +
					"   AND hs.host_id=host.id AND hs.storage_id=storage.id ";
			if (hostId >= 0)
				query += " AND host_id=?";
			if (storageId >= 0)
				query += " AND storage_id=?";
			
			PreparedStatement ps = conn.prepareStatement(
					query);
	    
			int counter = 1;
			ps.setBoolean(counter, active);
			counter++;
			ps.setBoolean(counter, active);
			counter++;
			ps.setBoolean(counter, active);
			counter++;
			if (hostId >= 0) {
				ps.setInt(counter, hostId);
				counter++;
			}
			if (storageId >= 0){
				ps.setInt(counter, storageId);
				counter++;
			}
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			while (rs.next()) {
		
				hostStorage = 
					new HostStorage(
						rs.getInt("host_id"),
						rs.getInt("storage_id"),
						rs.getInt("preference"),
						rs.getBoolean("active")); 
				hostStorageList.add(hostStorage);
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostStorageList] Ready to get out!");
		
		return hostStorageList;
	
	}

	public boolean setHostStorage(HostStorage hostStorage) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setHostStorage] Inside");
		
		boolean retVal = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE host_storage SET preference=?,active=? " +
					"	WHERE host_id=? AND storage_id=?");
		
			ps.setInt(1, hostStorage.getPreference());
			ps.setBoolean(2, hostStorage.isActive());
			ps.setInt(3, hostStorage.getHostId());
			ps.setInt(4, hostStorage.getStorageId());
			
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
			ps.execute();
			
			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setHostStorage] Ready to get out!");
		
		return retVal;
		
	}
	
	public boolean setHostStorageStatus(int hostId, int storageId, boolean status) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setHostStorageStatus] Inside!");
		
		boolean retVal = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE host_storage SET active=? WHERE host_id=? AND storage_id=?");
		
			ps.setBoolean(1, status);
			ps.setInt(2, hostId);
			ps.setInt(3, storageId);
			
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
			ps.execute();
			
			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;
						
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setHostStorageStatus] Ready to get out!");
		
		return retVal;
		
	}

	// public synchronized Storage assignStorageByHost(Host host) {
	public Storage assignStorageByHost(Host host) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignStorage] Inside!");
		
		Storage storage = null;
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM host_storage WHERE active='t' AND host_id=? ORDER BY preference");
	    
			ps.setInt(1, host.getId());

			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next())
				storage = getStorage(rs.getInt("storage_id"));
	
			rs.close();
			ps.close();
	       
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignStorage] Ready to get out!");
		
		return storage;
		
	}

	/*
	public Host assignHostByStorage(Storage storage) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignStorage] Inside!");
		
		Host host = null;
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM host_storage WHERE active='t' AND storage_id=? ORDER BY preference");
	    
			ps.setInt(1, host.getId());

			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next())
				host = getHost(rs.getInt("host_id"));
	
			rs.close();
			ps.close();
	       
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignStorage] Ready to get out!");
		
		return host;
		
	}
*/
	// public synchronized Host assignHost(
	public Host assignHost(
			VEInstance veIns, 
			Calendar startTime,
			Calendar endTime) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignHost] Inside!");
		
		Host host = null;
		ArrayList<Host> hostList = new ArrayList<Host>();
		
	    int index = 0;
	    
	    try {

	    	PreparedStatement ps = conn.prepareStatement(
    		"SELECT host.*,count FROM host LEFT JOIN (SELECT host.id,count(host.id) " +
    		"FROM host,ve_ins,ve_ins_sch WHERE host.active='t' AND ve_ins.active='t' " +
    		"AND ve_ins_sch.active='t' AND host.id=ve_ins_sch.host_id AND " +
    		"ve_ins.id=ve_ins_sch.ve_ins_id AND " +
    		"((ve_ins_sch.start_time < ? AND ve_ins_sch.start_time >= ?) OR " +
    		"(ve_ins_sch.end_time > ? AND ve_ins_sch.end_time <= ?) OR " +
    		"(ve_ins_sch.start_time < ? AND ve_ins_sch.end_time > ?)) " +
    		"GROUP BY host.id) " +
    		"as foo ON foo.id=host.id WHERE host.active='t'");
    	    
    		Timestamp startTimeStamp = new Timestamp(startTime.getTime().getTime());
    		Timestamp endTimeStamp = new Timestamp(endTime.getTime().getTime());
    		ps.setTimestamp(1, endTimeStamp);
    		ps.setTimestamp(2, startTimeStamp);
    		ps.setTimestamp(3, startTimeStamp);
    		ps.setTimestamp(4, endTimeStamp);
    		ps.setTimestamp(5, startTimeStamp);
    		ps.setTimestamp(6, endTimeStamp);
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
    		ResultSet rs = ps.executeQuery();
    	    
    		int lowestPref = Integer.MAX_VALUE;
    		int free = 0;
    		int i = 0;
    		while (rs.next()) {

    	   		int hostId = rs.getInt("id");
    	   		if (getHostMainSchList(hostId, startTime, endTime).size() > 0)
    	   			continue;
    	   		
    	   		String name = rs.getString("name");
    	   		int ssh_port = rs.getInt("ssh_port");
    	   		String username = rs.getString("username");
    	   		String password = rs.getString("password");
    	   		int ve_num_cap = rs.getInt("ve_num_cap");
    	   		int ve_first_free_port = rs.getInt("ve_first_free_port");
    	   		int ve_port_num = rs.getInt("ve_port_num");
    	   		boolean active = rs.getBoolean("active");
    	   		boolean newAssignment = rs.getBoolean("new_assignment");

    	   		// In the below algorithm, the preference has precedence to the
    	   		// number of free slots.
    	   		int count = rs.getInt("count");
    	   		if (ve_num_cap - count > 0) {
    	   			HostStorage hostStorage = getHostStorage(hostId, veIns.getStorageId());
    	   			if (hostStorage != null) {
    	   				int pref = hostStorage.getPreference();
    	   				if (pref > 0) {
    	   					if (pref < lowestPref) {
    	   						free = ve_num_cap - count;
    	   						lowestPref = pref;
    	   						index = i;    	   						
    	   					} else if (pref == lowestPref) {
    	   						if (ve_num_cap - count > free) {
        	   						free = ve_num_cap - count;
        	   						lowestPref = pref;
        	   						index = i;    	   						
    	   						}
    	   					}
    	   				}    	   			
    	   			}
    	   		}
    	   		/*
    	   		// In the below algorithm, the number of free slots has precedence to 
    	   		// the preference.
    	   		int count = rs.getInt("count");
    	   		if (ve_num_cap - count > 0) {
    	   			HostStorage hostStorage = getHostStorage(hostId, veIns.getStorageId());
    	   			if (hostStorage != null) {
    	   				int pref = hostStorage.getPreference();
    	   				if (pref > 0) {
    	   					if (ve_num_cap - count > free) {
    	   						free = ve_num_cap - count;
    	   						lowestPref = pref;
    	   						index = i;
    	   					} else  
    	   						if (ve_num_cap - count == free) {
    	   							if (pref < lowestPref) {
    	   								lowestPref = pref;
    	   								index = i;
    	   							}
    	   						}
    	   				}    	   			
    	   			}
    	   		}
          		*/
    	   		Host tempHost = 
    	   			new Host(
    	   					hostId, 
    	   					name, 
    	   					ssh_port, 
    	   					username, 
    	   					password, 
    	   					ve_num_cap,
    	   					ve_first_free_port, 
    	   					ve_port_num, 
    	   					active,
    	   					newAssignment);
          		
          		hostList.add(tempHost);
          		i++;
    		}
    		
    		rs.close();
    	    ps.close();
    	
    	}
    	catch(SQLException e) {
	    
    		e.printStackTrace();
	
    	}
    	
    	host = hostList.get(index);
    	
    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignHost] Ready to get out!");
    	
    	return host;
	}

	public ArrayList<Host> getHostList(Storage storage) {

    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostList] Inside!");
    	
    	ArrayList<Host> hostList = new ArrayList<Host>();
    	
    	ArrayList<HostStorage> hostStorageList = 
    		getHostStorageList(-1, storage.getId(), true);
    	
    	for (int i=0; i<hostStorageList.size(); i++)
    		hostList.add(getHost(hostStorageList.get(i).getHostId()));

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostList] Ready to get out!");
	
		return hostList;
	}

	public boolean addVEInsHost(VEInsHost veInsHost) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addVEInsHost] Inside!");
		
		boolean retVal = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO " +
					"	ve_ins_host(ve_ins_id,host_id)" +
					"   VALUES(?,?)");
		
			ps.setString(1, veInsHost.getVeInsId());
			ps.setInt(2, veInsHost.getHostId());
			
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
			ps.execute();
			
			retVal = true;
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addVEInsHost] Ready to get out!");
		
		return retVal;
		
	}
	
	public boolean delVEInsHost(String veInsId, int hostId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delVEInsHost] Inside!");
		
		boolean retVal = false;
				
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM ve_ins_host WHERE ve_ins_id=? AND host_id=?");
		
			ps.setString(1, veInsId);
			ps.setInt(2, hostId);
			
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
			ps.execute();
			
			retVal = true;
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delVEInsHost] Ready to get out!");
		
		return retVal;
		
	}
	
	public boolean delVEInsHost(String veInsId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delVEInsHost] Inside!");
		
		boolean retVal = false;
				
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM ve_ins_host WHERE ve_ins_id=?");
		
			ps.setString(1, veInsId);
			
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
			ps.execute();
			
			retVal = true;
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delVEInsHost] Ready to get out!");
		
		return retVal;
		
	}
	
	public VEInsHost getVEInsHost(String veInsId, int hostId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInsHost] Inside!");
		
		VEInsHost veInsHost = null;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM ve_ins_host WHERE ve_ins_id=? AND host_id=?");
		
			ps.setString(1, veInsId);
			ps.setInt(2, hostId);
			
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				veInsHost = 
					new VEInsHost(
						rs.getString("ve_ins_id"),
						rs.getInt("host_id"));				
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInsHost] Ready to get out!");
		
		return veInsHost;
		
	}

	public VEInstanceSchedule getVEInsCurSch(String veInsId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInsCurSch] Inside!");
		
		VEInstanceSchedule veInsSch = null;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM ve_ins_sch " +
					"	WHERE ve_ins_id=? and active='t' and done='f' and " +
					"	start_time<=? and end_time>?");
		
			ps.setString(1, veInsId);
			Calendar time1 = Calendar.getInstance();
			Calendar time2 = Calendar.getInstance();
			time1.add(Calendar.SECOND, 20);
			Timestamp now1 = new Timestamp(time1.getTime().getTime());
			Timestamp now2 = new Timestamp(time2.getTime().getTime());
			ps.setTimestamp(2,now1);
			ps.setTimestamp(3, now2);
			
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				Calendar startTime = Calendar.getInstance();
				startTime.setTime(rs.getTimestamp("start_time"));
				Calendar endTime = Calendar.getInstance();
				endTime.setTime(rs.getTimestamp("end_time"));

				veInsSch = 
					new VEInstanceSchedule(
							rs.getString("id"),
							rs.getString("ve_ins_id"),
							rs.getInt("host_id"),
							startTime,
							endTime,
							rs.getBoolean("done"),
							rs.getBoolean("active"));				
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInsCurSch] Ready to get out!");
		
		return veInsSch;
	}

	public VEInstance getVEInstanceByVMInsId(String vmInsId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstanceByVMInsId] Inside!");
		
		VEInstance veIns = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM vm_ins WHERE id=?");
	    
			ps.setString(1, vmInsId);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstanceByVMInsId] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				String veInsId = rs.getString("ve_ins_id");
				
				veIns = getVEInstance(veInsId);
				
			}
	
			rs.close();
			ps.close();
	       
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstanceByVMInsId] Ready to get out!");
		
		return veIns;
	}

	public int[] getVEInsHosts(String veInsId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInsHosts] Inside!");
		
		int[] hostIds = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM ve_ins_host WHERE ve_ins_id=?");
	    
			ps.setString(1, veInsId);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInsHosts] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			ArrayList<Integer> ids = new ArrayList<Integer>();
			while (rs.next()) {
		
				int hostId = rs.getInt("host_id");
				ids.add(new Integer(hostId));
				
			}
	
			rs.close();
			ps.close();
	       
			hostIds = new int[ids.size()];
			for (int i=0; i<ids.size(); i++)
				hostIds[i] = ids.get(i).intValue();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInsHosts] Ready to get out!");
		
		return hostIds;
	}

	public void delVEInsSchByVEInsId(String veInsId) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delVEInsSchByVEInsId] Inside!");
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM ve_ins_sch" +
					"	WHERE ve_ins_id=?"
					);
			
			ps.setString(1, veInsId);
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delVEInsSchByVEInsId] ps: " + ps);
			ps.execute();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delVEInsSchByVEInsId] Ready to get out!");
	}

	public void delVEIns(String veInsId) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delVEIns] Inside!");
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM ve_ins" +
					"	WHERE id=?"
					);
			
			ps.setString(1, veInsId);
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delVEIns] ps: " + ps);
			ps.execute();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delVEIns] Ready to get out!");
	}

	public boolean isVEInsDispatched(String veInsId) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - isVEInsDispatched] Inside!");
		
		boolean retVal = false;
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM host_used_routers WHERE ve_ins_id=?");
			
			ps.setString(1, veInsId);
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - isVEInsDispatched] ps: " + ps);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				retVal = true;
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - isVEInsDispatched] Ready to get out!");
		
		return retVal;
	}

	public int getHostIdOfScheduledVEIns(String veInsId) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostIdOfScheduledVEIns] Inside!");

		int hostId = -1;
		
		try {
			
			PreparedStatement ps = 
				conn.prepareStatement(
						"SELECT * FROM host_used_routers " +
						"	WHERE ve_ins_id=?");
			
			ps.setString(1, veInsId);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostIdOfScheduledVEIns] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				
				hostId = rs.getInt("host_id");
				
			}
		
			rs.close();
			ps.close();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostIdOfScheduledVEIns] Ready to get out!");
	
		return hostId;
	}

	public VMInstance getVMInstance(String veInsId, String vmName) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVMInstance] Inside!");
		
		VMInstance vmIns = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM vm_ins WHERE ve_ins_id=? and name=?");
	    
			ps.setString(1, veInsId);
			ps.setString(2, vmName);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVMInstance] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				String retId = rs.getString("id");
				String retVeInsId = rs.getString("ve_ins_id");
				String name = rs.getString("name");
				String dir = rs.getString("dir");
				String domain = rs.getString("domain");
				String os = rs.getString("os");
				String internalAddress = rs.getString("internal_address");
				int accessPort = rs.getInt("access_port");
				String macAddress = rs.getString("mac_address");
				String statusString = rs.getString("status");
				VMInsStatusType status = VMInstance.getStatus(statusString);
				Calendar lastCheckin = Calendar.getInstance();
				lastCheckin.setTime(rs.getTimestamp("last_checkin"));
				String appName = rs.getString("app_name");
				String appDir = rs.getString("app_dir");
				boolean active = rs.getBoolean("active");

				vmIns = new VMInstance(
						retId, 
						veInsId,
						name,
						dir,
						domain,
						os,
						internalAddress,
						accessPort,
						macAddress,
						status,
						lastCheckin,
						appName,
						appDir,
						active);
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVMInstance] Ready to get out!");
		
		return vmIns;
	}

	/**
	 * Return all the active & undone tasks of a certain type that are scheduled 
	 * for the time or before for a specific host.
	 */
	public Collection<SchedulingTask> getTasks4Host(
			int hostId,
			SchedulingTask.TaskType type, 
			Calendar time) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks4Host] Inside!");
		
		ArrayList<SchedulingTask> tasks = new ArrayList<SchedulingTask>();

		try {

			if (type == SchedulingTask.TaskType.STOP) {
				PreparedStatement ps = 
					conn.prepareStatement(
							"SELECT ins.id as ve_ins_id, sch.id as ve_ins_sch_id, " +
							"	sch.host_id, ins.username, ins.ve_type, ins.storage_id, " +
							"	ins.first_port, ins.num_ports, ins.first_mac, ins.num_macs " +
							"	FROM ve_ins as ins, ve_ins_sch as sch, host " +
							"	WHERE ins.id=sch.ve_ins_id AND sch.host_id=host.id AND " +
							"	host.active='t' AND ins.active='t' AND sch.active='t' AND " +
							"	sch.done='f' AND " +
							"	(ins.status=? OR ins.status=? OR ins.status=?) AND " +
							"	sch.end_time<=? AND " +
							"   sch.host_id=? " +
							"	ORDER BY sch.end_time");

				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks4Host] time: " + time.getTime());
				Timestamp ts = new Timestamp(time.getTime().getTime());

				ps.setString(1, VEInstance.VEInsStatusType.RUNNING.toString());
				ps.setString(2, VEInstance.VEInsStatusType.PROVISIONING_AND_STARTING.toString());
				ps.setString(3, VEInstance.VEInsStatusType.STARTING.toString());
				ps.setTimestamp(4, ts);
				ps.setInt(5, hostId);

				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks4Host] ps: " + ps);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					String veInsId = rs.getString("ve_ins_id");
					String veInsSchId = rs.getString("ve_ins_sch_id");
					int retHostId = rs.getInt("host_id");
					String username = rs.getString("username");
					String veTypeName = rs.getString("ve_type");
					int storageId = rs.getInt("storage_id");
					VirtualEnvironmentType veType = new VirtualEnvironmentType();
					// TODO
					veType.setVEName(veTypeName);
					int firstPort = rs.getInt("first_port");
					int numPorts = rs.getInt("num_ports");
					int firstMac = rs.getInt("first_mac");
					int numMacs = rs.getInt("num_macs");

					PreparedStatement ps2 = 
						conn.prepareStatement(
								"SELECT router_id from host_used_routers " +
								"WHERE ve_ins_id=?");
					
					ps2.setString(1, veInsId);

					DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks4Host] ps2: " + ps2);

					ResultSet rs2 = ps2.executeQuery();

					if (rs2.next()) {

						int routerId = rs2.getInt("router_id");
						
						SchedulingTask t = 
							new SchedulingTask(
									type, 
									veInsId,
									veInsSchId,
									retHostId, 
									username, 
									veType,
									firstPort,
									numPorts,
									firstMac,
									numMacs,
									routerId,
									storageId,
									0);
						tasks.add(t);
					
					}

					rs2.close();
					ps2.close();

				}

				rs.close();
				ps.close();
				
			}
			else if (type == SchedulingTask.TaskType.START) {
				PreparedStatement ps = 
					conn.prepareStatement(
							"SELECT ins.id as ve_ins_id, sch.id as ve_ins_sch_id, " +
							"	sch.host_id, ins.username, ins.ve_type, ins.storage_id, " +
							"	ins.first_port, ins.num_ports, ins.first_mac, ins.num_macs " +
							"	FROM ve_ins as ins, ve_ins_sch as sch, host " +
							"	WHERE ins.id=sch.ve_ins_id AND sch.host_id=host.id AND " +
							"	host.active='t' AND ins.active='t' AND sch.active='t' AND " +
							"	sch.done='f' AND " +
							"	(ins.status=? OR ins.status=? OR ins.status=?) " +
							"	AND sch.start_time<=? AND " +
							"   sch.host_id=? " +
							"	ORDER BY sch.start_time");

				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks4Host] time: " + time.getTime());
				Timestamp ts = new Timestamp(time.getTime().getTime());

				ps.setString(1, VEInstance.VEInsStatusType.NOT_PROVISIONED.toString());
				ps.setString(2, VEInstance.VEInsStatusType.PAUSED.toString());
				ps.setString(3, VEInstance.VEInsStatusType.PAUSING.toString());
				ps.setTimestamp(4, ts);
				ps.setInt(5, hostId);

				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks4Host] ps: " + ps);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					String veInsId = rs.getString("ve_ins_id");
					String veInsSchId = rs.getString("ve_ins_sch_id");
					int retHostId = rs.getInt("host_id");
					String username = rs.getString("username");
					String veTypeName = rs.getString("ve_type");
					int storageId = rs.getInt("storage_id"); 
					VirtualEnvironmentType veType = new VirtualEnvironmentType();
					// TODO
					veType.setVEName(veTypeName);
					int firstPort = rs.getInt("first_port");
					int numPorts = rs.getInt("num_ports");
					int firstMac = rs.getInt("first_mac");
					int numMacs = rs.getInt("num_macs");

					PreparedStatement ps2 = 
						conn.prepareStatement(
								"SELECT * from host_used_routers " +
								"	WHERE host_id=? and ve_ins_id=?");
					
					ps2.setInt(1, hostId);
					ps2.setString(2, veInsId);

					DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks4Host] ps2: " + ps2);

					ResultSet rs2 = ps2.executeQuery();

					int routerId = 0;
					if (rs2.next())
						routerId = rs2.getInt("router_id");

					rs2.close();
					ps2.close();

					SchedulingTask t = 
						new SchedulingTask(
								type, 
								veInsId,
								veInsSchId,
								retHostId, 
								username, 
								veType,
								firstPort,
								numPorts,
								firstMac,
								numMacs,
								routerId,
								storageId,
								getRegisterAction(veInsId, hostId, storageId));
					tasks.add(t);

				}

				rs.close();
				ps.close();	
			}
		} catch(SQLException e) {
			e.printStackTrace();	
		}

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTasks4Host] Ready to get out!");
		
		return tasks;

	}

	public ArrayList<Integer> getTaskHostList() {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTaskHostList] Inside!");

		ArrayList<Integer> taskHostList = new ArrayList<Integer>();

		try {

			PreparedStatement ps = 
				conn.prepareStatement(
						"SELECT sch.host_id " +
						"	FROM ve_ins as ins, ve_ins_sch as sch, host " +
						"	WHERE ins.id=sch.ve_ins_id AND sch.host_id=host.id AND " +
						"		host.active='t' AND ins.active='t' AND sch.active='t' " +
						"		AND sch.done='f' AND (((ins.status='RUNNING' OR " +
						"		ins.status='PROVISIONING_AND_STARTING' OR " +
						"		ins.status='STARTING') AND sch.end_time<=?) OR " +
						"		((ins.status='NOT_PROVISIONED' OR ins.status='PAUSED' " +
						"		OR ins.status='PAUSING') AND sch.start_time<=?)) " +
						"		GROUP BY sch.host_id ORDER BY sch.host_id");

			Timestamp ts = new Timestamp(Calendar.getInstance().getTime().getTime());
			ps.setTimestamp(1, ts);
			ps.setTimestamp(2, ts);

			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTaskHostList] ps: " + ps);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int hostId = rs.getInt("host_id");
				taskHostList.add(new Integer(hostId));

			}
			
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getTaskHostList] Ready to get out!");

		return taskHostList;
	}

	public ArrayList<MigrationTask> getMigrationTasks(String groupName) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] Inside!");

		ArrayList<MigrationTask> migTasks = new ArrayList<MigrationTask>();

		try {

			PreparedStatement ps = 
				conn.prepareStatement(
						"SELECT COUNT(*) FROM user_group WHERE group_name=?");
			ps.setString(1, groupName);
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] ps: " + ps);
			ResultSet rs = ps.executeQuery();
			int memberCount = 0;
			if (rs.next()) {
				memberCount = rs.getInt("count");
			}			
			rs.close();
			ps.close();

			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
					"memberCount: " + memberCount);

			if (memberCount > 0) {
				
				ps = 
					conn.prepareStatement(
							"SELECT SUM(ve_num_cap) FROM host WHERE active='t'");
				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] ps: " + ps);
				rs = ps.executeQuery();
				int veNumCapTotal = 0;
				if (rs.next()) {
					veNumCapTotal = rs.getInt("sum");
				}			
				rs.close();
				ps.close();
				
				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
						"veNumCapTotal: " + veNumCapTotal);

				if (veNumCapTotal > 0) {
					
					ArrayList<Host> hosts = getHostList();
					SortedMap hostCurAssignment = getHostCurAssignement(groupName);
					SortedMap hostNewAssignment = new TreeMap();
					// Initializaing
					for (int i=0; i<hosts.size(); i++)
						hostNewAssignment.put(new Integer(hosts.get(i).getId()), new Integer(0));

					DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
							"Initial assignment: ");
					int sumAssigned = 0;
					for (int i=0; i<hosts.size(); i++) {
						int count = hosts.get(i).getVeNumCap() * memberCount / veNumCapTotal;
						sumAssigned += count;
						hostNewAssignment.put(new Integer(hosts.get(i).getId()), new Integer(count));
						DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
								"\thost id: " + hosts.get(i).getId() + " " +
								"cur assignment: " + hostCurAssignment.get(hosts.get(i).getId()) + " " + 						
								"new assignment: " + hostNewAssignment.get(hosts.get(i).getId()));						
					}
					int leftOver = memberCount - sumAssigned;
					DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
							"\tsum assigned: " + sumAssigned + " " +
							"left over: " + leftOver);

					while (leftOver > 0) {
						// Find the most eligible host
						int maxFree = Integer.MIN_VALUE;
						int index = -1;
						DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
								"maxFree: " + maxFree + " index: " + index);
						for (int i=0; i<hosts.size(); i++) {
							Host host = hosts.get(i);
							int newAssignment = ((Integer)hostNewAssignment.get(host.getId())).intValue();
						    if (host.getVeNumCap() - newAssignment > maxFree) {
						    	index = i;
						    	maxFree = host.getVeNumCap() - newAssignment;
						    }
							DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
									"i: " + i + " maxFree: " + maxFree + " index: " + index);
						}
						DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
								"maxFree: " + maxFree + " index: " + index);
						if (index >= 0) {
							leftOver--;
							Host host = hosts.get(index);
							int newAssignment = ((Integer)hostNewAssignment.get(host.getId())).intValue();
							hostNewAssignment.put(new Integer(host.getId()), new Integer(newAssignment+1));
						} else {
							Exception e = new Exception("Error in the code!");
							e.printStackTrace();
						}
					}
					
					DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
							"After more assignments, the left over in now: " + leftOver);
					for (int i=0; i<hosts.size(); i++) {
						DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
								"\thost id: " + hosts.get(i).getId() + " " +
								"cur assignment: " + hostCurAssignment.get(hosts.get(i).getId()) + " " + 						
								"new assignment: " + hostNewAssignment.get(hosts.get(i).getId()));						
					}
					
					ArrayList<Host> sourceHosts = new ArrayList<Host>();
					ArrayList<Host> targetHosts = new ArrayList<Host>();
					boolean moreTask = true;
					while (moreTask) {
						DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
								"moreTask: " + moreTask);
						// Find source and target
						int sourceHostIndex = -1;
						int targetHostIndex = -1;
						for (int i=0; i<hosts.size() && (sourceHostIndex == -1 || targetHostIndex == -1); i++) {
							Host host = hosts.get(i);
							int curAssignment = ((Integer)hostCurAssignment.get(host.getId())).intValue();
							int newAssignment = ((Integer)hostNewAssignment.get(host.getId())).intValue();
							DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
									"i: " + i + " " +
									"curAssignment: " + curAssignment + " " +
									"newAssignment: " + newAssignment);
						    if (sourceHostIndex == -1) {
						    	if (curAssignment > newAssignment) {
						    		sourceHostIndex = i;
						    	}
						    }
						    if (targetHostIndex == -1) {
						    	if (curAssignment < newAssignment) {
						    		targetHostIndex = i;
						    	}
						    }
						}
						DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
								"sourceHostIndex: " + sourceHostIndex + " " +
								"targetHostIndex: " + targetHostIndex);
						if ((sourceHostIndex != -1) && (targetHostIndex != -1)) {
							moreTask = true;
							sourceHosts.add(hosts.get(sourceHostIndex));
							targetHosts.add(hosts.get(targetHostIndex));
							
							DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
									"Migrate " + hosts.get(sourceHostIndex).getId() + 
									" to " + hosts.get(targetHostIndex).getId());
						
							// Change the current assignment!
							int tempSourceCurAssignment = ((Integer)hostCurAssignment.get(hosts.get(sourceHostIndex).getId())).intValue();
							hostCurAssignment.put(new Integer(hosts.get(sourceHostIndex).getId()), new Integer(tempSourceCurAssignment-1));
							int tempTargetCurAssignment = ((Integer)hostCurAssignment.get(hosts.get(targetHostIndex).getId())).intValue();
							hostCurAssignment.put(new Integer(hosts.get(targetHostIndex).getId()), new Integer(tempTargetCurAssignment+1));

						} else {
							moreTask = false;
						}
					}
					
					DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
							"moreTask: " + moreTask);

					DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
							"Migrations: ");
					for (int i=0; i<sourceHosts.size(); i++) {
						DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
								"\tsource host: " + sourceHosts.get(i).getId() + " " +
								"target host: " + targetHosts.get(i).getId());
					}
					
					ps = 
						conn.prepareStatement(
								"SELECT username FROM user_group WHERE group_name=? order by id");
					ps.setString(1, groupName);
					DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] ps: " + ps);
					rs = ps.executeQuery();

					while (rs.next()) {

						String username = rs.getString(1);
						DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
								"username: " + username);
						Host host = getUserAssignedHost(username);
						DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
								"assigned host: " + host.getId());
						boolean found = false;
						int index = -1;
						for (int i=0; i<sourceHosts.size() && !found; i++) {
							if (sourceHosts.get(i).getId() == host.getId()) {
								index = i;
								found = true;
							}
						}
						DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
								"found: " + found + " " +
								"index: " + index);
						if (found) {
							Host sourceHost = sourceHosts.get(index);
							Host targetHost = targetHosts.get(index);
							DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
									"source host: " + sourceHost.getId() + " " +
									"target host: " + targetHost.getId());
							ArrayList<MigrationTask> tempMigTasks = 
								getMigrateUserTasks(
										username,
										targetHost);
							if (tempMigTasks != null) {
								for (MigrationTask migTask: tempMigTasks) {
									DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] " +
											"migTask: " + migTask.getUsername() + " " +
											"to " + migTask.getHostId());
									migTasks.add(migTask);
								}
							}
							sourceHosts.remove(index);
							targetHosts.remove(index);
						}
					}			
					rs.close();
					ps.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrationTasks] Ready to get out!");

		return migTasks;
	}

	private Host getUserAssignedHost(String username) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getUserAssignedHost] Inside!");

		Host host = null;

		try {

			// First get the user's assigend storage id
			int storageId = -1;
			PreparedStatement ps = 
				conn.prepareStatement(
						"SELECT * FROM ve_ins WHERE username=?");
			ps.setString(1, username);
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getUserAssignedHost] ps: " + ps);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				storageId = rs.getInt("storage_id");
			}			
			rs.close();
			ps.close();
			
			if (storageId >= 0) {
				ps = 
					conn.prepareStatement(
					"SELECT * FROM host_storage WHERE storage_id=? AND preference=1");
				ps.setInt(1, storageId);
				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getUserAssignedHost] ps: " + ps);
				rs = ps.executeQuery();
				int hostId = -1;
				if (rs.next()) {
					hostId = rs.getInt("host_id");
					host = getHost(hostId);
				}			
				rs.close();
				ps.close();

				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getUserAssignedHost] " +
						"hostId: " + hostId);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getUserAssignedHost] Ready to get out!");
		
		return host;
	}

	private SortedMap getHostCurAssignement(String groupName) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostCurAssignement] Inside!");
		
		SortedMap hostCurAssignment = new TreeMap();
		// Initializaing
		ArrayList<Host> hosts = getHostList();
		for (int i=0; i<hosts.size(); i++)
			hostCurAssignment.put(new Integer(hosts.get(i).getId()), new Integer(0));
		
		Host host = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT storage_id,COUNT(*) " +
					"	FROM (SELECT DISTINCT ins.username,storage_id " +
					"		FROM user_group AS grp, ve_ins AS ins " +
					"		WHERE grp.group_name=? AND grp.username=ins.username " +
					"		AND active='t' ORDER BY storage_id,username) AS foo GROUP BY storage_id");

			ps.setString(1, groupName);
	    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostCurAssignement] ps: " + ps);	
			
	    	ResultSet rs = ps.executeQuery();
	    
			while (rs.next()) {
		
				int storageId = rs.getInt("storage_id");
				int count = rs.getInt("count");
				
				host = getHost4Storage(storageId);
				hostCurAssignment.put(new Integer(host.getId()), new Integer(count));
				
			}
	
			rs.close();
			ps.close();
	       
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostCurAssignement] Ready to get out!");
		
		return hostCurAssignment;
	
	}

	private ArrayList<Host> getHostListOrderByRevVeNumCap() {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostListOrderByRevVeNumCap] Inside!");
		
		ArrayList<Host> hostList = new ArrayList<Host>();
		Host host = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM host WHERE active='t' ORDER BY ve_num_cap DESC");
			
	    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostListOrderByRevVeNumCap] ps: " + ps);	
			
	    	ResultSet rs = ps.executeQuery();
	    
			while (rs.next()) {
		
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int sshPort = rs.getInt("ssh_port");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int veNumCap = rs.getInt("ve_num_cap");
				int veFirstFreePort = rs.getInt("ve_first_free_port");
				int vePortNum = rs.getInt("ve_port_num");
				boolean active = rs.getBoolean("active");
				boolean newAssignment = rs.getBoolean("new_assignment");
				
				host = new Host(
						id, 
						name, 
						sshPort, 
						username, 
						password, 
						veNumCap, 
						veFirstFreePort,
						vePortNum, 
						active,
						newAssignment); 
				hostList.add(host);
				
			}
	
			rs.close();
			ps.close();
	       
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHostListOrderByRevVeNumCap] Ready to get out!");
		
		return hostList;
	
	}

	private ArrayList<MigrationTask> getMigrateUserTasks(
			String username, 
			Host targetHost) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrateUserTasks] Inside!");

		ArrayList<MigrationTask> migTasks = new ArrayList<MigrationTask>();

		int targetStorageId = getStorage4Host(targetHost.getId());
		
		try {

			if (targetStorageId >= 0) {
				
				PreparedStatement ps = 
					conn.prepareStatement(
							"SELECT * FROM ve_ins WHERE username=?");
				ps.setString(1, username);
				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrateUserTasks] ps: " + ps);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String veTypeName = rs.getString("ve_type");
					int firstPort = rs.getInt("first_port");
					int sourceStorageId = rs.getInt("storage_id");
					if (sourceStorageId != targetStorageId) {
						MigrationTask migTask =
							new MigrationTask(
									targetHost.getId(), 
									username, 
									veTypeName,
									firstPort,
									sourceStorageId, 
									targetStorageId);
						migTasks.add(migTask);
					}
				}			
				rs.close();
				ps.close();				
			} else {
				Exception e = new Exception("Error in code or in DB!");
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMigrateUserTasks] Ready to get out!");

		return migTasks;
	}

	public VEInstance getVEInstance(
			String username, 
			String veTypeName,
			int firstPort) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstance] Inside!");
		
		VEInstance veIns = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM ve_ins WHERE username=? and ve_type=? and first_port=?");
	    
			ps.setString(1, username);
			ps.setString(2, veTypeName);
			ps.setInt(3, firstPort);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				String id = rs.getString("id");
				VirtualEnvironmentType veType = new VirtualEnvironmentType();
				// TODO
				veType.setVEName(veTypeName);
				int storageId = rs.getInt("storage_id");
				int kserverId = rs.getInt("kserver_id");
				int veFirstFreePort = rs.getInt("first_port");
				int vePortNum = rs.getInt("num_ports");
				int veFirstFreeMac = rs.getInt("first_mac");
				int veMacNum = rs.getInt("num_macs");
				boolean store = rs.getBoolean("store");
				boolean active = rs.getBoolean("active");
				String statusString = rs.getString("status");
				VEInsStatusType status = VEInstance.getStatus(statusString);
				
				veIns = new VEInstance(
						id, 
						username, 
						veType, 
						storageId, 
						kserverId,
						veFirstFreePort,
						vePortNum, 
						veFirstFreeMac,
						veMacNum, 
						store, 
						active,
						status); 
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getVEInstance] Ready to get out!");
		
		return veIns;

	}

	public int getKServerIdByPromoId(int promoId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerIdByPromoId] Inside!");
		
		int kServerId = -1; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM promo_kserver WHERE promo_id=?");
	    
			ps.setInt(1, promoId);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerIdByPromoId] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				kServerId = rs.getInt("kserver_id");
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerIdByPromoId] Ready to get out!");
		
		return kServerId;

	}

	public Host getHost4Storage(int storageId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHost4Storage] Inside!");
		
		Host host = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM host_storage WHERE storage_id=? ORDER BY preference");
	    
			ps.setInt(1, storageId);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getHost4Storage] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				int hostId = rs.getInt("host_id");
				host = getHost(hostId);
		
			}
	
			rs.close();
			ps.close();
	       
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB -getHost4Storage] Ready to get out!");
		
		return host;
	
	} 

	public int getStorage4Host(int hostId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getStorage4Host] Inside!");
		
		int storageId = -1;
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM host_storage WHERE host_id=? ORDER BY preference");
	    
			ps.setInt(1, hostId);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getStorage4Host] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				storageId = rs.getInt("storage_id");
		
			}
	
			rs.close();
			ps.close();
	       
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB -getStorage4Host] Ready to get out!");
		
		return storageId;
	
	}

	// Returns the storage assigned to the user, if any
	public Storage getStorage(String username) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getStorage(username)] Inside!");
		
		Storage storage = null;
		
	    try {
	
	    	PreparedStatement ps = conn.prepareStatement(
	    		"SELECT storage_id FROM ve_ins WHERE " +
	    		"	active='t' AND username=?");
		    
			ps.setString(1, username);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getStorage(username)] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
		    
			if (rs.next()) {
	
				int id = rs.getInt("storage_id");
				storage = getStorage(id);
				
			}
			
			rs.close();
		    ps.close();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getStorage(username)] Ready to get out!");
		
		return storage;
	
	}

	// Assigns the most eligible storage, which is the one with the least used preferred host.
	public Storage assignStorage() {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignStorage] Inside!");
		
		Storage storage = null;
		
	    try {
	    	
	    	// SMS: 2013-04-05
	    	// I assume that the preferred host for a storage is the host that storage is
	    	// on it. In other words, storage_id is equal to host_id. This makes things 
	    	// much simpler as really it does not make sense to run a virtual lab residing
	    	// on the hdd of one host on another host.
	    	// SMS: 2014-01-23
	    	// New hosts added, namely, vc9, vc10, and vc11, were not counted in the previous
	    	// select statement; therefore, I revised it with a left join.
	    	PreparedStatement ps = conn.prepareStatement(
		    		"SELECT sc.storage_id, sc.count, ve_num_cap, gb_size, " +
		    		"gb_size*ve_num_cap/(sc.count+1)::float as free_cap " +
		    		"from (select s.id as storage_id, COALESCE(count, 0) as count " +
		    		"from storage as s left join (select storage_id, count(*) " +
		    		"from ve_ins where active ='t' and update_ts >= now() - " +
		    		"'1 month'::interval group by storage_id order by storage_id) " +
		    		"as t on s.id=t.storage_id) as sc, storage, host where " +
		    		"sc.storage_id=storage.id and sc.storage_id=host.id order by " +
		    		"free_cap desc");
	    	/*
	    	PreparedStatement ps = conn.prepareStatement(
		    		"SELECT sc.storage_id, sc.count, ve_num_cap, gb_size, " +
	    			"gb_size*ve_num_cap/(sc.count+1)::float as free_cap " +
	    			"from (select storage_id, count(*) from ve_ins " +
	    			"where active ='t' and update_ts >= now() - '1 month'::interval " +
	    			"group by storage_id order by storage_id) as sc, " +
	    			"storage, host where sc.storage_id=storage.id and " +
	    			"sc.storage_id=host.id order by free_cap desc");
		    */
	    	/* 
	    	PreparedStatement ps = conn.prepareStatement(
	    		"SELECT tmp2.storage_id,count,host_id,ve_num_cap FROM " +
	    		"	(SELECT storage_id,count(*) FROM " +
	    		"		(SELECT storage.id AS storage_id, tmp1.username, tmp1.count " +
	    		"			FROM storage LEFT JOIN " +
	    		"				(SELECT storage_id,username,count(*) " +
	    		"					FROM ve_ins GROUP BY storage_id,username ORDER BY storage_id) as tmp1 " +
	    		"						ON storage.id=tmp1.storage_id) AS tmp " +
	    		"			GROUP BY storage_id) AS tmp2, " +
	    		"			(SELECT * FROM host_storage WHERE active='t' AND preference=1) AS hs,host,storage " +
	    		"				WHERE tmp2.storage_id=hs.storage_id AND hs.host_id=host.id AND " +
	    		"					host.new_assignment='t' AND host.active='t' AND tmp2.storage_id=storage.id " +
	    		"					AND storage.active='t'");
	    		*/
	    	/*
	    	PreparedStatement ps = conn.prepareStatement(
		    		"SELECT tmp2.storage_id,count,host_id,ve_num_cap FROM " +
		    		"	(SELECT storage_id,count(*) FROM " +
		    		"		(SELECT storage_id,username,count(*) FROM " +
		    		"			ve_ins GROUP BY storage_id,username ORDER BY storage_id) AS tmp " +
		    		"			GROUP BY storage_id) AS tmp2, " +
		    		"			(SELECT * FROM host_storage WHERE active='t' AND preference=1) AS hs,host,storage " +
		    		"				WHERE tmp2.storage_id=hs.storage_id AND hs.host_id=host.id AND " +
		    		"					host.new_assignment='t' AND host.active='t' AND tmp2.storage_id=storage.id " +
		    		"					AND storage.active='t'");
*/		    
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignStorage] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
		    
			int storage_id = 0;
			// float min = Float.MAX_VALUE;
			
	    	// SMS: 2013-04-05
			/*
			while (rs.next()) {
	
				int count = rs.getInt("count");
				int veNumCap = rs.getInt("ve_num_cap");
				
				float num = (float)count / (float)veNumCap;
				
				if (num < min) {
					storage_id = rs.getInt("storage_id");
					min = num;
				}
				
			}
			*/

			if (rs.next()) {
				
				storage_id = rs.getInt("storage_id");
				
			}
			
			if (storage_id >= 0)
				storage = getStorage(storage_id);

			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignStorage] storage_id: " + storage_id);

			rs.close();
		    ps.close();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignStorage] Ready to get out!");
		
		return storage;
	
	}

	public Host assignHostByStorage(
			VirtualEnvironmentType veType,
			Calendar startTime, 
			Calendar endTime,
			Storage storage) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignHostByStorage] Inside!");
		
    	// SMS: 2013-04-05
    	// I assume that the preferred host for a storage is the host that storage is
    	// on it. In other words, storage_id is equal to host_id. This makes things 
    	// much simpler as really it does not make sense to run a virtual lab residing
    	// on the hdd of one host on another host.
        Host host = getHost(storage.getId());    	
    	/*
		Host host = null;
		ArrayList<Host> hostList = new ArrayList<Host>();
		
	    int index = -1;
	    
	    try {

	    	PreparedStatement ps = conn.prepareStatement(
    		"SELECT host.*,count FROM host LEFT JOIN (SELECT host.id,count(host.id) " +
    		"FROM host,ve_ins,ve_ins_sch WHERE host.active='t' AND ve_ins.active='t' " +
    		"AND ve_ins_sch.active='t' AND host.id=ve_ins_sch.host_id AND " +
    		"ve_ins.id=ve_ins_sch.ve_ins_id AND " +
    		"((ve_ins_sch.start_time < ? AND ve_ins_sch.start_time >= ?) OR " +
    		"(ve_ins_sch.end_time > ? AND ve_ins_sch.end_time <= ?) OR " +
    		"(ve_ins_sch.start_time < ? AND ve_ins_sch.end_time > ?)) " +
    		"GROUP BY host.id) " +
    		"as foo ON foo.id=host.id WHERE host.active='t'");
    		
    	    
    		Timestamp startTimeStamp = new Timestamp(startTime.getTime().getTime());
    		Timestamp endTimeStamp = new Timestamp(endTime.getTime().getTime());
    		ps.setTimestamp(1, endTimeStamp);
    		ps.setTimestamp(2, startTimeStamp);
    		ps.setTimestamp(3, startTimeStamp);
    		ps.setTimestamp(4, endTimeStamp);
    		ps.setTimestamp(5, startTimeStamp);
    		ps.setTimestamp(6, endTimeStamp);
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignHostByStorage] ps: " + ps);
    		
    		ResultSet rs = ps.executeQuery();
    	    
    		int free = 0;
    		int i = 0;
    		while (rs.next()) {

    	   		int id = rs.getInt("id");
    	   		if (getHostMainSchList(id, startTime, endTime).size() > 0)
    	   			continue;
    	   		
    	   		String name = rs.getString("name");
    	   		int ssh_port = rs.getInt("ssh_port");
    	   		String username = rs.getString("username");
    	   		String password = rs.getString("password");
    	   		int ve_num_cap = rs.getInt("ve_num_cap");
    	   		int ve_first_free_port = rs.getInt("ve_first_free_port");
    	   		int ve_port_num = rs.getInt("ve_port_num");
    	   		boolean active = rs.getBoolean("active");
    	   		boolean newAssignment = rs.getBoolean("new_assignment");
    	   		
    	   		int count = rs.getInt("count");
    	   		if (ve_num_cap - count > free) {
    	   			free = ve_num_cap - count;
    	   			index = i;
    	   		}
          		
    	   		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignHostByStorage] " +
        				" host id: " + id + " i: " + i + " index: " + index + 
        				" free: " + free + " count: " + count + " ve_num_cap: " + ve_num_cap);

        		Host tempHost = new Host(id, name, ssh_port, username, password, ve_num_cap,
          			ve_first_free_port, ve_port_num, active, newAssignment);
          		
          		hostList.add(tempHost);

          		if (ve_num_cap > count) {
    	   			
    	   			Storage tempStorage = assignStorageByHost(tempHost);
        	   		if (tempStorage.getId() == storage.getId()) {
            	   		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignHostByStorage] " +
                				" tempHost.id: " + tempHost.getId() + " " +
                				" tempStorage.id: " + tempStorage.getId() + " " +
                				" hostList.size: " + hostList.size() + " " +
                				" index: " + index);
        	   			free = ve_num_cap - count;
        	   			index = i;
        	   			break;
        	   		}
    	   		}
        		
          		i++;
    		}
    		
    		rs.close();
    	    ps.close();
	    }
    	catch(SQLException e) {
	    
    		e.printStackTrace();
	
    	}
    	
    	if (index >= 0)
    		host = hostList.get(index);
    	
    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignHost] " +
				" index: " + index);

    	*/
    	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignHost] Ready to get out!");
    	
    	return host;
	} 

    /**
	 * Gets a kserver record using its unique id.
	 * @param id
	 * @return
	 */
	public KServer getKServer(int id) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB -getKServer] Inside!");
		
		KServer kserver = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM kserver WHERE id=?");
	    
			ps.setInt(1, id);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				int retId = rs.getInt("id");
				String name = rs.getString("name");
				int httpPort = rs.getInt("http_port");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int totalCap = rs.getInt("total_cap");
				int activeCap = rs.getInt("active_cap");
				boolean active = rs.getBoolean("active");
				boolean newAssignment = rs.getBoolean("new_assignment");
				
				kserver = new KServer(retId, name, httpPort, username, password, 
						totalCap, activeCap, active, newAssignment); 
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB -getKServer] Ready to get out!");
		
		return kserver;
	
	}

	public KServer getKServer(String username, String veInsId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServer] Inside!");
		
		KServer kserver = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM ve_ins WHERE username=? AND id=?");
	    
			ps.setString(1, username);
			ps.setString(2, veInsId);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServer] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				int kserverId = rs.getInt("kserver_id");

				kserver = getKServer(kserverId); 
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB -getKServer] Ready to get out!");
		
		return kserver;
	
	} 
	/**
	 * Gets a kserver record using its name.
	 * @param id
	 * @return
	 */
	public KServer getKServerUsingName(String kserverName) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB -getKServerUsingName] Inside!");
		
		KServer kserver = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM kserver WHERE name=?");
	    
			String shortKserverName = kserverName;
			if (shortKserverName.contains("http://"))
				shortKserverName = shortKserverName.substring(7);
			ps.setString(1, shortKserverName);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				int retId = rs.getInt("id");
				String name = rs.getString("name");
				int httpPort = rs.getInt("http_port");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int totalCap = rs.getInt("total_cap");
				int activeCap = rs.getInt("active_cap");
				boolean active = rs.getBoolean("active");
				boolean newAssignment = rs.getBoolean("new_assignment");
				
				kserver = new KServer(retId, name, httpPort, username, password, 
						totalCap, activeCap, active, newAssignment); 
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB -getKServer] Ready to get out!");
		
		return kserver;
	
	}

	/**
	 * Sets a kserver record using its unique id.
	 * @param kserver
	 * @return
	 */
	public boolean setKServer(KServer kserver) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setKServer] Inside!");
		
		boolean retVal = false;
		
		try {
	
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE kserver SET name=?,http_port=?,username=?,password=?," +
					"total_cap=?,active_cap=?,active=?," +
					"new_assignment=? " +
					"WHERE id=?");
	
			ps.setString(1, kserver.getName());
			ps.setInt(2, kserver.getHttpPort());
			ps.setString(3, kserver.getUsername());
			ps.setString(4, kserver.getPassword());
			ps.setInt(5, kserver.getTotalCap());
			ps.setInt(6, kserver.getActiveCap());
			ps.setBoolean(7, kserver.isActive());
			ps.setBoolean(8, kserver.isNewAssignment());
			ps.setInt(9, kserver.getId());
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ps.execute();
			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;
			
		    DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setKServer] update count: " + count +
		    		" retVal is " + retVal);
		    
		    ps.close();
		
		    
		}
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setKServer] Ready to get out!");
		
		return retVal;
		
	}

	public boolean delKServer(int id) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delKServer] Inside!");
		
		boolean retVal = false;
		
		try {
			// TODO we need to make sure that kserver is not reference anywhere else in the db
			// For example, in the ve_ins_sch table.
			
		/*
			PreparedStatement ps = conn.prepareStatement(
					"SELECT count(*) FROM ve_ins WHERE kserver_id=?");
			
			ps.setInt(1, id);
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			int count = 1;
			
			if (rs.next()) {
				
				count = rs.getInt("count");
				
				DebugTools.println(DEBUG_LEVEL, "[VEScheduler] inside if count: " + count);
				
			}
			
			DebugTools.println(DEBUG_LEVEL, "[VEScheduler] outside if count: " + count);
			
			if (count == 0) {
			*/
				PreparedStatement ps = conn.prepareStatement(
				"DELETE from kserver where id=?");
		
				ps.setInt(1, id);
				
				DebugTools.println(DEBUG_LEVEL, "VEScheduler] ps: " + ps);
				
				ps.execute();
				
				retVal = true;
									
			// }
			
			// rs.close();
			ps.close();
					
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delKServer] Ready to get out!");
		
		return retVal;
	}
	
	/**
     * Adds a kserver record to the kserver table.
     * @param kserver
     * @return returns the auto-generated unique kserver id.
     */
    public int addKServer(KServer kserver) {
    	
    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addKServer] Inside!");
    	
    	int id = 0;
    	
    	try {
    		
    		PreparedStatement ps = conn.prepareStatement(
    				"INSERT INTO kserver(name,http_port,username,password,total_cap," +
    				"active_cap,active,new_assignment) " +
    				"VALUES(?,?,?,?,?,?,?,?) " +
    				"RETURNING id");
    		
    		ps.setString(1, kserver.getName());
    		ps.setInt(2, kserver.getHttpPort());
    		ps.setString(3, kserver.getUsername());
    		ps.setString(4, kserver.getPassword());
    		ps.setInt(5, kserver.getTotalCap());
    		ps.setInt(6, kserver.getActiveCap());
    		ps.setBoolean(7, kserver.isActive());
    		ps.setBoolean(8, kserver.isNewAssignment());
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    	
    		ResultSet rs = ps.executeQuery();
    		
    		if (rs.next()) {
    			
    			id = rs.getInt("id");
    			
    		}
    		
    		rs.close();
    		ps.close();
    		
    	}
    	catch (Exception e) {
    		
    		e.printStackTrace();
    		
    	}
    	
    	DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addKServer] Ready to get out!");
    	
    	return id;
    }
    
    /**
	 * Gets a list of all active kservers in the database.
	 * @return
	 */
	public ArrayList<KServer> getKServerList() {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerList - no param] Inside!");
		
		ArrayList<KServer> kserverList = getKServerList(true, true);
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerList - no param] Ready to get out!");
		
		return kserverList;
		
	}
	
	/**
	 * 
	 * @param active
	 * @return
	 */
	public ArrayList<KServer> getKServerList(boolean active, boolean newAssignment) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerList] Inside!");
		
		ArrayList<KServer> kserverList = new ArrayList<KServer>();
		KServer kserver = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM kserver WHERE active=? and new_assignment=? ORDER BY id");
	    
			ps.setBoolean(1, active);
			ps.setBoolean(2, newAssignment);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			while (rs.next()) {
		
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int httpPort = rs.getInt("http_port");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int totalCap = rs.getInt("total_cap");
				int activeCap = rs.getInt("active_cap");
				boolean retActive = rs.getBoolean("active");
				boolean retNewAssignment = rs.getBoolean("new_assignment");
				
				kserver = new KServer(id, name, httpPort, username, password, totalCap, activeCap,
					retActive, retNewAssignment); 
				kserverList.add(kserver);
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerList] Ready to get out!");
		
		return kserverList;
	
	}

	public int getMaxKServerId() {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMaxKServerId] Inside!");
		
		int maxKServerId = 0; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM kserver");
	    
			DebugTools.println(DEBUG_LEVEL, "[getMaxKServerId] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			while (rs.next()) {
		
				int id = rs.getInt("id");
				if (id > maxKServerId)
					maxKServerId = id;
				
			}
	
			rs.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getMaxKServerId] Ready to get out!");
		
		return maxKServerId;
	
	}

	/**
	 * Gets all the fully booked periods for a kserver during a time period.
	 * @param kserver
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	// public synchronized ArrayList<TimePeriod> getKServerFilledPeriodList(KServer kserver, Calendar startTime,
	public ArrayList<TimePeriod> getKServerFilledPeriodList(KServer kserver, Calendar startTime,
			Calendar endTime) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerFilledPeriodList] Inside!");
		
		ArrayList<TimePeriod> kserverFilledPeriodList = new ArrayList<TimePeriod>();
		ArrayList<TimePeriod> kserverScheduleList = new ArrayList<TimePeriod>();
		
	    try {
	
	    	PreparedStatement ps = conn.prepareStatement(
	    		"SELECT kserver_id,start_time,end_time FROM ve_ins,ve_ins_sch WHERE " +
	    		"ve_ins.active='t' AND ve_ins_sch.active='t' AND kserver_id=? " +
	    		"AND ve_ins.id=ve_ins_sch.ve_ins_id AND" +
	    		"((start_time < ? AND start_time >= ?) OR " +
	    		"(end_time > ? AND end_time <= ?) OR " +
	    		"(start_time < ? AND end_time > ?))");
		    
			ps.setInt(1, kserver.getId());
	    	Timestamp startTimeStamp = new Timestamp(startTime.getTime().getTime());
			Timestamp endTimeStamp = new Timestamp(endTime.getTime().getTime());
			ps.setTimestamp(2, endTimeStamp);
			ps.setTimestamp(3, startTimeStamp);
			ps.setTimestamp(4, startTimeStamp);
			ps.setTimestamp(5, endTimeStamp);
			ps.setTimestamp(6, startTimeStamp);
			ps.setTimestamp(7, endTimeStamp);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
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
				
				TimePeriod veSchedule = new TimePeriod();
				veSchedule.setStartTime(sTime);
				veSchedule.setEndTime(eTime);
				kserverScheduleList.add(veSchedule);
		   		
			}
			
			rs.close();
		    ps.close();
		
		}
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		ArrayList<TimePeriodWithCounter> countedList = 
			TimePeriodTools.countPeriods(kserverScheduleList);
		for (int i = 0; i < countedList.size(); i++) {
			
			if (countedList.get(i).getCounter() >= kserver.getTotalCap()) {
				
				TimePeriodWithCounter timePeriodWithCounter = countedList.get(i);
				TimePeriod timePeriod = new TimePeriod();
				timePeriod.setStartTime(timePeriodWithCounter.getStartTime());
				timePeriod.setEndTime(timePeriodWithCounter.getEndTime());
				kserverFilledPeriodList.add(timePeriod);
			
			}
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerFilledPeriodList] Ready to get out!");
		
		return kserverFilledPeriodList;
	
	}

	/**
	 * Gets a kserver maintenance schedule using its unique id.
	 * @param id
	 * @return
	 */
	// public synchronized KServerMaintenanceSchedule getKServerMainSch(String id) {
	public KServerMaintenanceSchedule getKServerMainSch(String id) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerMainSch] Inside!");
		
		KServerMaintenanceSchedule kserverMainSch = null;
		
		try {
		
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * from kserver_maintenance_sch WHERE id=?"
					);
			
			ps.setString(1, id);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				String retId = rs.getString("id");
				int kserverId = rs.getInt("kserver_id");
				Calendar startTime = Calendar.getInstance();
				startTime.setTime(rs.getTimestamp("start_time"));
				Calendar endTime = Calendar.getInstance();
				endTime.setTime(rs.getTimestamp("end_time"));
				boolean active = rs.getBoolean("active");
				
				kserverMainSch = new KServerMaintenanceSchedule(retId, kserverId, startTime,
						endTime, active);
			}
			
			rs.close();
			ps.close();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerMainSch] Ready to get out!");
		
		return kserverMainSch;
		
	}
	
	/**
	 * Sets a kserver maintenance schedule using its unique id.
	 * @param kserverMainSch
	 * @return
	 */
	public boolean setKServerMainSch(KServerMaintenanceSchedule kserverMainSch) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setKServerMainSch] Inside!");
		
		boolean retVal = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE kserver_maintenance_sch " +
					"SET kserver_id=?,start_time=?,end_time=?,active=? " +
					"WHERE id=?"
					);
			
			ps.setInt(1, kserverMainSch.getKServerId());
			Timestamp startTimeStamp = new Timestamp(
    				kserverMainSch.getStartTime().getTime().getTime());
    		ps.setTimestamp(2, startTimeStamp);
    		Timestamp endTimeStamp = new Timestamp(
    				kserverMainSch.getEndTime().getTime().getTime());
    		ps.setTimestamp(3, endTimeStamp);
    		ps.setBoolean(4, kserverMainSch.isActive());
    		ps.setString(5, kserverMainSch.getId());
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
    		ps.execute();
    		
			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;
			
    		ps.close();
    		
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setKServerMainSch] Ready to get out!");
		
		return retVal;
		
	}
	
	/**
	 * Adds a new kserver maintenance schedule and returns a unique id.
	 * @param kserverMainSch
	 * @return
	 */
	public String addKServerMainSch(KServerMaintenanceSchedule kserverMainSch) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addKServerMainSch] Inside!");
		
		String id = null;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO " +
					"kserver_maintenance_sch(id,kserver_id,start_time,end_time,active) " +
					"VALUES(?,?,?,?,?) "
					);
			
			if (kserverMainSch.getId() == null)
				id = UUID.randomUUID().toString();
			else
				id = kserverMainSch.getId();
			ps.setString(1, id);
			ps.setInt(2, kserverMainSch.getKServerId());
			Timestamp startTimeStamp = new Timestamp(
    				kserverMainSch.getStartTime().getTime().getTime());
    		ps.setTimestamp(3, startTimeStamp);
    		Timestamp endTimeStamp = new Timestamp(
    				kserverMainSch.getEndTime().getTime().getTime());
    		ps.setTimestamp(4, endTimeStamp);
    		ps.setBoolean(5, kserverMainSch.isActive());
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
    		
    		ps.execute();
    		
    		ps.close();
    		
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - addKServerMainSch] Ready to get out!");
		
		return id;
		
	}
	
	/**
	 * Gets all the periods that a kserver is scheduled for maintenance.
	 * @param kserver
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	// public synchronized ArrayList<ScheduledEvent> getKServerMainSchList(
	public ArrayList<ScheduledEvent> getKServerMainSchList(
			int kserverId,
			Calendar startTime, 
			Calendar endTime) {
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerMainSchList] Inside!");
		
		ArrayList<ScheduledEvent> kserverUnavailList = new ArrayList<ScheduledEvent>();
		
	    try {
	
	    	PreparedStatement ps = conn.prepareStatement(
	    		"SELECT * FROM kserver_maintenance_sch WHERE kserver_id=? AND active='t' AND" +
	    		"((start_time < ? AND start_time >= ?) OR " +
	    		"(end_time > ? AND end_time <= ?) OR" +
	    		"(start_time < ? AND end_time > ?))");
		    
			ps.setInt(1, kserverId);
	    	Timestamp startTimeStamp = new Timestamp(startTime.getTime().getTime());
			Timestamp endTimeStamp = new Timestamp(endTime.getTime().getTime());
			ps.setTimestamp(2, endTimeStamp);
			ps.setTimestamp(3, startTimeStamp);
			ps.setTimestamp(4, startTimeStamp);
			ps.setTimestamp(5, endTimeStamp);
			ps.setTimestamp(6, startTimeStamp);
			ps.setTimestamp(7, endTimeStamp);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB] ps: " + ps);
			
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
				
				TimePeriod kserverSchedule = new TimePeriod();
				kserverSchedule.setStartTime(sTime);
				kserverSchedule.setEndTime(eTime);
				ScheduledEvent mainSchEvent = new ScheduledEvent();
				mainSchEvent.setTimePeriod(kserverSchedule);
				mainSchEvent.setSchId(schId);
				kserverUnavailList.add(mainSchEvent);
		   		
			}
			
			rs.close();
		    ps.close();
		
		}
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerMainSchList] Ready to get out!");
		
		return kserverUnavailList;
	
	}

	public KServer assignKServerByHost(Host host) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignKServerByHost] Inside!");
		
		KServer kserver = null;
		
	    try {

	    	PreparedStatement ps = 
	    		conn.prepareStatement(
	    			"SELECT * FROM host_kserver WHERE host_id=? ORDER BY preference");
	    			
    		ps.setInt(1, host.getId());
    		
    		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignKServerByHost] ps: " + ps);
    		
    		ResultSet rs = ps.executeQuery();
    	    
    		if (rs.next()) {

    	   		int kserverId = rs.getInt("kserver_id");
    	   		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignKServerByHost] " +
        				" kserver id: " + kserverId);

        		kserver = getKServer(kserverId);

    		}
    		
    		rs.close();
    	    ps.close();
    	
    	}
    	catch(SQLException e) {
	    
    		e.printStackTrace();
	
    	}
    	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - assignKServerByHost] Ready to get out!");
    	
    	return kserver;
	}

	public boolean setKServer4VEIns(String veInsId, int kServerId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setKServer4VEIns] Inside!");
		
		boolean retVal = false;
		
		try {

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE ve_ins SET kserver_id=? WHERE id=?");

			ps.setInt(1, kServerId);
			ps.setString(2, veInsId);

			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setKServer4VEIns] ps: " + ps);

			ps.execute();

			int count = ps.getUpdateCount();
			if (count > 0)
				retVal = true;

			ps.close();

		}
		catch (Exception e) {

			e.printStackTrace();

		}

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - setKServer4VEIns] Ready to get out!");
		
		return retVal;
	
	}

	public String[] getUserInGroup(String groupName) {

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getUserInGroup] Inside!");

		ArrayList<MigrationTask> migTasks = new ArrayList<MigrationTask>();

		String [] usernames = null;
		
		try {

			PreparedStatement ps = 
				conn.prepareStatement(
						"SELECT * FROM user_group WHERE group_name=?");
			
			ps.setString(1, groupName);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getUserInGroup] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<String> userList = new ArrayList<String>();
			
			while (rs.next()) {
				
				String username = rs.getString("username");
				
				userList.add(username);
				
			}	
			
			usernames = new String[userList.size()];
			for (int i=0; i<userList.size(); i++)
				usernames[i] = userList.get(i);
			
			for (String username : usernames)
				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getUserInGroup] username: " + username);
				
			rs.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getUserInGroup] Ready to get out!");

		return usernames;
	}

	/**
     * Adds a tenant record to the tenant table.
     * @param tenant
     */
    public void addTenant(Tenant tenant) {
    	
    	DebugTools.println(MY_DL, "[VESchedulerDB - addTenant] Inside!");
    	
    	try {
    		
    		PreparedStatement ps = conn.prepareStatement(
    				"INSERT INTO tenant(ve_ins_id,username,password,kserver_id,customer_id,account_id,group_id,url,end_date,agents,admins) " +
    				"VALUES(?,?,?,?,?,?,?,?,?,?,?)");
    		
    		ps.setString(1, tenant.getVeInsId());
    		ps.setString(2, tenant.getUsername());
    		ps.setString(3, tenant.getPassword());
    		ps.setInt(4, tenant.getKserverId());
    		ps.setBigDecimal(5, tenant.getCustomerID());
    		ps.setString(6, tenant.getAccountID());
    		ps.setString(7, tenant.getGroup());
    		ps.setString(8, tenant.getUrl());
    		if (tenant.getEndDate() != null) {
    			Timestamp endDateStamp = new Timestamp(tenant.getEndDate().getTime().getTime());
    			ps.setTimestamp(9, endDateStamp);
    		} else {
    			Timestamp endDateStamp = new Timestamp(Calendar.getInstance().getTime().getTime());
    			ps.setTimestamp(9, endDateStamp);    			
    		}
    		ps.setInt(10, tenant.getAgents());
    		ps.setInt(11, tenant.getAdmins());    		
    		
    		DebugTools.println(MY_DL, "[VESchedulerDB] ps: " + ps);
    	
    		ps.execute();
    		
    		ps.close();
    		
    	}
    	catch (Exception e) {
    		
    		e.printStackTrace();
    		
    	}
    	
    	DebugTools.println(MY_DL, "[VESchedulerDB - addTenant] Ready to get out!");
    	
    }
    
	/**
     * Adds a temporary tenant record until it is created.
     * @param 
     */
    public synchronized Tenant addTempTenant(String veInsId, String promoCode) {
    	
    	DebugTools.println(MY_DL, "[VESchedulerDB - addTempTenant] Inside!");
    	
    	// SMS: 4/29/2014 
    	// Fixing the bleeding issue regarding more than one thread trying to create tenants.
    	if (isAnotherTenantBeingCreated())
    		return null;
    	
    	Tenant tenant = getTenantByVeInsId(veInsId);
    	DebugTools.println(MY_DL, "[VESchedulerDB - addTempTenant] " +
    			"tenant: " + tenant);
    	
    	if (tenant == null) {
    		
    		try {

    			PreparedStatement ps = conn.prepareStatement(
    					// start changes
    					// SMS: I added -_____@ to make sure the its-fw and its-fw-63 do not mix!
    					"SELECT * FROM tenant WHERE username LIKE '" + promoCode.toLowerCase() + "-_____@%' ORDER BY username DESC");
    					// "SELECT * FROM tenant WHERE username LIKE '" + promoCode.toLowerCase() + "%' ORDER BY username DESC");
    					// end changes

    			DebugTools.println(MY_DL, "[VESchedulerDB] ps: " + ps);

    			ResultSet rs = ps.executeQuery();

    			if (rs.next()) {

    				String username = rs.getString("username");
    				DebugTools.println(MY_DL, "[VESchedulerDB - addTempTenant] " +
    						"username: " + username);
    				int atPos = username.indexOf("@");
    				String numStr = username.substring(promoCode.length()+1, atPos);
    				DebugTools.println(MY_DL, "[VESchedulerDB - addTempTenant] " +
    						"numStr: " + numStr);
    				int num = Integer.parseInt(numStr) + 1;
    				DebugTools.println(MY_DL, "[VESchedulerDB - addTempTenant] " +
    						"num]: " + num);
    				DecimalFormat df = new DecimalFormat("00000");
    				numStr = df.format(num);
    				DebugTools.println(MY_DL, "[VESchedulerDB - addTempTenant] " +
    						"numStr: " + numStr);
    				username = promoCode.toLowerCase() + "-" + numStr + "@ita-provisioner.cis.fiu.edu";
    				DebugTools.println(MY_DL, "[VESchedulerDB - addTempTenant] " +
    						"username: " + username);
    				tenant = new Tenant(veInsId, username, "", -1);
    				DebugTools.println(MY_DL, "[VESchedulerDB - addTempTenant] " +
    						"tenant: " + tenant);

    			} else {

    				tenant = new Tenant(veInsId, promoCode.toLowerCase() + "-00001@ita-provisioner.cis.fiu.edu", "", -1);
    				DebugTools.println(MY_DL, "[VESchedulerDB - addTempTenant] " +
    						"tenant: " + tenant);

    			}

    			rs.close();
    			ps.close();

    			addTenant(tenant);

    		}
    		catch (Exception e) {

    			e.printStackTrace();

    		}
    	}
    	
		DebugTools.println(MY_DL, "[VESchedulerDB -getTenantByVeInsId] " +
				"tenant: " + tenant);
		DebugTools.println(MY_DL, "[VESchedulerDB - addTempTenant] Ready to get out!");
    	
    	return tenant;
    }
    
	/**
     * Updates a tenant password.
     * @param tenant
     */
    public boolean updateTenantPassword(String username, String password) {
    	
    	DebugTools.println(MY_DL, "[VESchedulerDB - updateTenantPassword] Inside!");
    	
    	boolean retVal = false;
    	
    	try {
    		
    		PreparedStatement ps = conn.prepareStatement(
    				"UPDATE tenant SET password = ? WHERE username = ?");
    		
    		ps.setString(1, password);
    		ps.setString(2, username);
    		
    		DebugTools.println(MY_DL, "[VESchedulerDB] ps: " + ps);
    	
    		ps.execute();
    		
			int count = ps.getUpdateCount();
		    if (count > 0)
		    	retVal = true;
			
		    ps.close();
    		
    	}
    	catch (Exception e) {
    		
    		e.printStackTrace();
    		
    	}
    	
		DebugTools.println(MY_DL, "[VESchedulerDB - updateTenantPassword] " +
				"retVal: " + retVal);
		
		DebugTools.println(MY_DL, "[VESchedulerDB - updateTenantPassword] Ready to get out!");
    	
    	return retVal;
    }
    
	/**
     * Updates a tenant record, but not its password!
     * @param tenant
     */
    public boolean updateTenant(Tenant tenant) {
    	
    	DebugTools.println(MY_DL, "[VESchedulerDB - updateTenant] Inside!");
    	
    	boolean retVal = false;
    	
    	try {
    		
    		PreparedStatement ps = conn.prepareStatement(
    				"UPDATE tenant SET username=?, password=?, kserver_id=?, customer_id=?, " +
    				"account_id=?, group_id=?, url=?, end_date=?, agents=?, admins=? " +
    				"WHERE ve_ins_id = ?");

    		ps.setString(1, tenant.getUsername());
    		ps.setString(2, tenant.getPassword());
    		ps.setInt(3, tenant.getKserverId());
    		ps.setBigDecimal(4, tenant.getCustomerID());
    		ps.setString(5, tenant.getAccountID());
    		ps.setString(6, tenant.getGroup());
    		ps.setString(7, tenant.getUrl());
			Timestamp endDateStamp = new Timestamp(tenant.getEndDate().getTime().getTime());
			ps.setTimestamp(8, endDateStamp);
    		ps.setInt(9, tenant.getAgents());
    		ps.setInt(10, tenant.getAdmins());
    		ps.setString(11, tenant.getVeInsId());

    		DebugTools.println(MY_DL, "[VESchedulerDB - updateTenant] ps: " + ps);

    		ps.execute();

    		int count = ps.getUpdateCount();
    		if (count > 0)
    			retVal = true;

    		ps.close();

    	}
    	catch (Exception e) {
    		
    		e.printStackTrace();
    		
    	}
    	
		DebugTools.println(MY_DL, "[VESchedulerDB - updateTenant] " +
				"retVal: " + retVal);
		DebugTools.println(MY_DL, "[VESchedulerDB - updateTenant] Ready to get out!");
    	
    	return retVal;
    }
    
    /**
	 * Gets a tenant record using its username.
	 * @param username
	 * @return
	 */
	public Tenant getTenantByUsername(String username) {
		
		DebugTools.println(MY_DL, "[VESchedulerDB -getTenantByUsername] Inside!");
		
		Tenant tenant = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM tenant WHERE username=?");
	    
			ps.setString(1, username);
			
			DebugTools.println(MY_DL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				tenant = new Tenant();
				tenant.setAccountID(rs.getString("account_id"));
				tenant.setAdmins(rs.getInt("admins"));
				tenant.setAgents(rs.getInt("agents"));
				tenant.setCustomerID(rs.getBigDecimal("customer_id"));
				Calendar endDate = Calendar.getInstance();
				endDate.setTime(rs.getTimestamp("end_date"));
				tenant.setEndDate(endDate);
				tenant.setGroup(rs.getString("group_id"));
				tenant.setKserverId(rs.getInt("kserver_id"));
				tenant.setPassword(rs.getString("password"));
				tenant.setUrl(rs.getString("url"));
				tenant.setUsername(rs.getString("username"));
				tenant.setVeInsId(rs.getString("ve_ins_id"));
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(MY_DL, "[VESchedulerDB -getTenantByVeInsId] " +
				"tenant: " + tenant);
		DebugTools.println(MY_DL, "[VESchedulerDB -getTenantByUsername] Ready to get out!");
		
		return tenant;
	
	}

    /**
	 * Gets a tenant record using its veInsId.
	 * @param veInsId
	 * @return
	 */
	public Tenant getTenantByVeInsId(String veInsId) {
		
		DebugTools.println(MY_DL, "[VESchedulerDB -getTenantByVeInsId] Inside!");
		
		Tenant tenant = null; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM tenant WHERE ve_ins_id=?");
	    
			ps.setString(1, veInsId);
			
			DebugTools.println(MY_DL, "[VESchedulerDB] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {

				tenant = new Tenant();
				tenant.setAccountID(rs.getString("account_id"));
				tenant.setAdmins(rs.getInt("admins"));
				tenant.setAgents(rs.getInt("agents"));
				tenant.setCustomerID(rs.getBigDecimal("customer_id"));
				Calendar endDate = Calendar.getInstance();
				endDate.setTime(rs.getTimestamp("end_date"));
				tenant.setEndDate(endDate);
				tenant.setGroup(rs.getString("group_id"));
				tenant.setKserverId(rs.getInt("kserver_id"));
				tenant.setPassword(rs.getString("password"));
				tenant.setUrl(rs.getString("url"));
				tenant.setUsername(rs.getString("username"));
				tenant.setVeInsId(rs.getString("ve_ins_id"));
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(MY_DL, "[VESchedulerDB -getTenantByVeInsId] " +
				"tenant: " + tenant);
		DebugTools.println(MY_DL, "[VESchedulerDB -getTenantByVeInsId] Ready to get out!");
		
		return tenant;
	
	}

	public boolean delTenant(String veInsId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delTenant] Inside!");
		
		boolean retVal = false;
		
		try {
				PreparedStatement ps = conn.prepareStatement(
				"DELETE from tenant where ve_ins_id = ?");
		
				ps.setString(1, veInsId);
				
				DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delTenant] ps: " + ps);
				
				ps.execute();
				
				retVal = true;
									
			// }
			
			// rs.close();
			ps.close();
					
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - delTenant] Ready to get out!");
		
		return retVal;
	}

	public boolean disableTenant(String veInsId) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - disableTenant] Inside!");
		
		boolean retVal = false;
		
		try {

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE tenant SET ve_ins_id = 'Tenant is disabled!' where ve_ins_id = ?");

			ps.setString(1, veInsId);

			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - disableTenant] ps: " + ps);

			ps.execute();

			int count = ps.getUpdateCount();
			if (count > 0)
				retVal = true;
			ps.close();

		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - disableTenant] Ready to get out!");
		
		return retVal;
	}

	// SMS: 4/29/2014 
	// Fixing the bleeding issue regarding more than one thread trying to create tenants.
	private synchronized boolean isAnotherTenantBeingCreated() {
	// public boolean isAnotherTenantBeingCreated() {
		
		DebugTools.println(MY_DL, "[VESchedulerDB - isAnotherTenantBeingCreated] Inside!");
		
		boolean retVal = false; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM tenant WHERE password=''");
	    
			DebugTools.println(MY_DL, "[VESchedulerDB - isAnotherTenantBeingCreated] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next())
				retVal = true;
				
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(MY_DL, "[VESchedulerDB - isAnotherTenantBeingCreated] " +
				"Another tenant is being added is: " + retVal);
		DebugTools.println(MY_DL, "[VESchedulerDB - isAnotherTenantBeingCreated] Ready to get out!");
		
		return retVal;
	
	}

	/**
	 * This functions marks expired schedules as done and false.
	 * It returns the number of expired schedules.
	 */
	public int markExpiredSchedulesAsFasleAndDone() {
		
		int retVal = -1;
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - markExpiredTasksAsFasleAndDone] Inside!");
		
		try {

			PreparedStatement ps = 
				conn.prepareStatement(
					"UPDATE ve_ins_sch SET active='f', done='t' where id in " +
					"(SELECT sch.id FROM ve_ins as ins, ve_ins_sch as sch " +
					"WHERE ins.id=sch.ve_ins_id AND ins.active='t' AND sch.active='t' AND sch.done='f' " +
					"AND (ins.status=? OR ins.status=? OR ins.status=?) " +
					"AND sch.start_time<=now() AND sch.end_time<=now())");

			ps.setString(1, VEInstance.VEInsStatusType.NOT_PROVISIONED.toString());
			ps.setString(2, VEInstance.VEInsStatusType.PAUSED.toString());
			ps.setString(3, VEInstance.VEInsStatusType.PAUSING.toString());

			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - markExpiredTasksAsFasleAndDone] ps: " + ps);

			ps.execute();

			retVal = ps.getUpdateCount();

			ps.close();

		}
		catch(SQLException e) {
		
			e.printStackTrace();
		
		}

		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - markExpiredTasksAsFasleAndDone] Ready to get out!");
				
		return retVal;
	}

	public String getKServerAkamaiName(String kserverName) {
		
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerAkamaiName] Inside!");
		
		String akamaiName = kserverName; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM akamai WHERE kserver_name=?");
	    
			ps.setString(1, kserverName);
			
			DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerAkamaiName] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {
		
				akamaiName = rs.getString("akamai_name");

			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(DEBUG_LEVEL, "[VESchedulerDB - getKServerAkamaiName] Ready to get out!");
		
		return akamaiName;
	
	}

	/**
     * Adds a tenant created record to the tenant_created table.
     * @param username
     */
    public void addTenantCreated(String username) {
    	
    	DebugTools.println(MY_DL, "[VESchedulerDB - addTenantCreated] Inside!");
    	
    	try {
    		
    		PreparedStatement ps = conn.prepareStatement(
    				"INSERT INTO tenant_created(username) " +
    				"VALUES(?)");
    		
    		ps.setString(1, username);
    		
    		DebugTools.println(MY_DL, "[VESchedulerDB - addTenantCreated] ps: " + ps);
    	
    		ps.execute();
    		
    		ps.close();
    		
    	}
    	catch (Exception e) {
    		
    		e.printStackTrace();
    		
    	}
    	
    	DebugTools.println(MY_DL, "[VESchedulerDB - addTenantCreated] Ready to get out!");
    	
    }
    
    /**
	 * Checks to see whether a tenant is created.
	 * @param username
	 * @return
	 */
	public boolean isTenantCreated(String username) {
		
		DebugTools.println(MY_DL, "[VESchedulerDB -isTenantCreated] Inside!");
		
		boolean retVal = false; 
		
		try {
	    
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM tenant_created WHERE username=?");
	    
			ps.setString(1, username);
			
			DebugTools.println(MY_DL, "[VESchedulerDB - isTenantCreated] ps: " + ps);
			
			ResultSet rs = ps.executeQuery();
	    
			if (rs.next()) {

				retVal = true;
				
			}
	
			rs.close();
			ps.close();
	       
		}
	
		catch(SQLException e) {
	    
			e.printStackTrace();
	
		}
	
		DebugTools.println(MY_DL, "[VESchedulerDB -isTenantCreated] Ready to get out!");
		
		return retVal;
	
	}
    
}