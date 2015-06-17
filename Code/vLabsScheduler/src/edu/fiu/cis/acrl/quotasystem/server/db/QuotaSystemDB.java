package edu.fiu.cis.acrl.quotasystem.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.fiu.cis.acrl.quotasystem.entity.Course;
import edu.fiu.cis.acrl.quotasystem.entity.CreditType;
import edu.fiu.cis.acrl.quotasystem.entity.Policy;
import edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment;
import edu.fiu.cis.acrl.quotasystem.entity.UsedQuota;
import edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota;
import edu.fiu.cis.acrl.quotasystem.entity.UserProfile;
import edu.fiu.cis.acrl.quotasystem.server.QuotaSystem;
import edu.fiu.cis.acrl.tools.debug.DebugTools;

public class QuotaSystemDB {

	// Debug level for this class
	private static int DEBUG_LEVEL = 2;
	
	private Connection conn;

	public QuotaSystemDB() {
	}

	public boolean connect(String user, String password, String host,
			String database) {

		try {
			Class.forName("org.postgresql.Driver");

			conn = DriverManager.getConnection("jdbc:postgresql://" + host
					+ "/" + database, user, password);
		}

		catch (ClassNotFoundException cnfe) {

			System.err.println("Could not find JDBC driver");
			return false;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}

		return true;
	}

	public void close() {

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//***********************************************************
	//	Users Management
	//***********************************************************


	public void addUser( int id, String username, String email) {

		try {

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] addUser("+id+",'"+username+"','"+email+"') Inside!");
			String sql = "INSERT INTO user_profile (id,username, email) VALUES(?,?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setString(2, username);
			ps.setString(3, email);
			ps.executeUpdate();
			ps.close();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] addUser out!");

		} catch (SQLException e) {
			throw new Error(e.getMessage());
		}

	}

	public void modifyUser( int id, String username, String email) {

		try {

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] modifyUser("+id+",'"+username+"','"+email+"') Inside!");
			String sql = "UPDATE user_profile SET username=?, email=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(3,id);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.executeUpdate();
			ps.close();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] modifyUser out!");

		} catch (SQLException e) {
			throw new Error(e.getMessage());
		}

	}

	public void deleteUser(int id) {

		try {

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] deleteUser("+id+") out!");
			String sql = "DELETE FROM user_profile WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
			ps.close();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] deleteUser out!");

		} catch (SQLException e) {
			throw new Error(e.getMessage());
		}

	}

	public UserProfile getUserByUsername(String username) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserByUsername("+username+") Inside!");
		UserProfile user =  null;
		try {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_profile WHERE username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user =  new UserProfile();
				String email = rs.getString("email");
				user.setUsername(username);
				user.setEmail(email);
				user.setId(rs.getInt("id"));
			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserByUsername out!");

		return user;
	}

	public UserProfile getUserById(int userId) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserById("+userId+") Inside!");
		UserProfile user =  null;
		try {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_profile WHERE id = ?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String username = rs.getString("username");
				String email = rs.getString("email");
				//String type = rs.getString("type");

				user = new UserProfile();
				user.setId(userId);
				user.setUsername(username);
				user.setEmail(email);

			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}


		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserById out!");
		return user;
	}

	public List<UserProfile> getUsers() {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] getUsers Inside!");

		List<UserProfile> usersList = new ArrayList<UserProfile>();

		String sql = "SELECT * FROM user_profile";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("id");
				String username = rs.getString("username");
				String email = rs.getString("email");

				UserProfile user = new UserProfile();
				user.setId(userId);
				user.setUsername(username);
				user.setEmail(email);;
				usersList.add(user);

			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUsers out!");

		return usersList;
	}

	public List<UserProfile> getUsersByCourse(int[] courses) {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] getUsersByCourse Inside!");

		List<UserProfile> usersList = new ArrayList<UserProfile>();

		String sql = "SELECT DISTINCT * FROM user_profile WHERE id IN("+
						"SELECT user_id FROM course_enrollment WHERE course_id = "+courses[0];


		if (courses.length > 1) {
			for (int i = 1; i < courses.length; i++) {
				sql += " OR course_id = " + courses[i];

			}

		}

		sql += ")";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int userId = rs.getInt("id");
				String username = rs.getString("username");
				String email = rs.getString("email");

				UserProfile user = new UserProfile();
				user.setId(userId);
				user.setUsername(username);
				user.setEmail(email);
				usersList.add(user);
			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}


		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUsersByCourse out!");

		return usersList;
	}

	public List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> getNewStudents(String purchaseId, edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType){

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] getNewStudents Inside!");

		List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> newStudents =
			new ArrayList<edu.fiu.cis.acrl.quotasystem.entity.UserProfile>();
		List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> students =
			creditType.getCourse().getUserProfiles();


		//Iterate through students
		for(edu.fiu.cis.acrl.quotasystem.entity.UserProfile student:students){

			try {
				//Check that assignment has not been done before to this student which means
				// he is not a new student
				edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota assignedQuota =
					getUserAssignedQuotaByPurchaseAndCreditTypeAndUser(purchaseId, student.getId(), creditType.getId());
				if(assignedQuota == null){
					newStudents.add(student);
				}

			} catch (Error e) {
				DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB]" + e.getMessage());
				e.printStackTrace();
			}
		}
		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] getNewStudents out!");
		return newStudents;
	}

	//***********************************************************
	//	Course Management
	//***********************************************************

	public void addCourse(int id, String shortname, String fullname) {

		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] addCourse("+id+",'"+shortname+"','"+fullname+"') Inside!");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO course(shortname, fullname, id ) VALUES(?, ?, ?)");
			ps.setString(1, shortname);
			ps.setString(2, fullname);
			ps.setInt(3, id);
			ps.executeUpdate();
			ps.close();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] addCourse out!");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

	}

	public void modifyCourse(int id, String shortname, String fullname) {

		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] modifyCourse("+id+",'"+shortname+"','"+fullname+"') Inside!");
			PreparedStatement ps = conn.prepareStatement("UPDATE course SET shortname=?, fullname =?  WHERE id = ?");
			ps.setString(1, shortname);
			ps.setString(2, fullname);
			ps.setInt(3, id);
			ps.executeUpdate();
			ps.close();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] modifyCourse out!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

	}

	public void deleteCourse(int id) {

		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] deleteCourse("+id+") inside!");
			PreparedStatement ps = conn.prepareStatement("DELETE FROM course WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] deleteCourse out!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

	}

	public Course getCourseByFullName(String fullname){
		Course course = null;
		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCourseByFullName Inside! "+fullname);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM course WHERE fullname = ?");

			ps.setString(1, fullname.trim());
			ResultSet rs = ps.executeQuery();


			if (rs.next()) {
				int id = rs.getInt("id");
				String shortname = rs.getString("shortname");
				course = new Course();
				course.setId(id);
				course.setFullname(fullname);
				course.setShortname(shortname);

				int[] courseids = {id};

				List<CreditType> creditTypes = this.getCreditTypesByCourse(courseids);
				course.setCreditTypes(creditTypes);

			}
			ps.close();

		} catch (SQLException e) {
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] SQL Exception " + e.getMessage());
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCourseByFullName out!");
		return course;
	}

	public Course getCourseById(int id)
	{
		Course course = null;
		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCourseById Inside!");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM course WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String shortname = rs.getString("shortname");
				String fullname = rs.getString("fullname");

				int[] coursesParam = new int[1];
				coursesParam[0] = id;
				List<UserProfile> users = getUsersByCourse(coursesParam);

				course = new Course();
				course.setId(id);
				course.setShortname(shortname);
				course.setFullname(fullname);
				course.setUserProfiles(users);

			}
			ps.close();

		} catch (SQLException e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] SQL Exception " + e.getMessage());
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCourseById out!");

		return course;
	}

	public List<Course> getCourses()
	{
		List<Course> courses = new ArrayList<Course>();

		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCourses Inside!");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM course");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Course course = new Course();
				int id = rs.getInt("id");
				String shortname = rs.getString("shortname");
				String fullname = rs.getString("fullname");

				int[] coursesParam = new int[1];
				coursesParam[0] = id;
				List<UserProfile> users = getUsersByCourse(coursesParam);
				course.setId(id);
				course.setShortname(shortname);
				course.setFullname(fullname);
				course.setUserProfiles(users);
				courses.add(course);

			}
			ps.close();

		} catch (SQLException e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] SQL Exception " + e.getMessage());
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCourses out!");

		return courses;
	}


	//***********************************************************
	//	Enrollment Management
	//***********************************************************

	public void addEnrollment(int id, int userId, int courseId){
		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] addEnrollment("+id+","+userId+","+courseId+") inside!");
			String sql = "INSERT INTO course_enrollment (id, user_id, course_id) VALUES(?,?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, userId);
			ps.setInt(3, courseId);
			ps.executeUpdate();
			ps.close();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] addEnrollment out!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

	}

	public void deleteEnrollment(int id){
		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] deleteEnrollment("+id+") inside!");
			String sql = "DELETE FROM course_enrollment WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] deleteEnrollment out!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

	}

	public int getEnrollmentId(int courseId, int userId){

		int id= 0;

		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getEnrollmentId("+userId+","+courseId+") inside!");
			String sql = "SELECT * FROM course_enrollment WHERE user_id=? and course_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, courseId);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				id = rs.getInt("id");
			ps.close();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getEnrollmentId out!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}
		return id;

	}

	public int[] getCourseIdsByUserId(int userId)
	{
		List<Integer> courses = new ArrayList<Integer>();

		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCoursesByUserId Inside!");
			PreparedStatement ps = conn.prepareStatement("SELECT c.* FROM course c WHERE id IN (SELECT ce.course_id FROM course_enrollment ce WHERE ce.user_id = ?)");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				courses.add(id);
			}
			ps.close();

		} catch (SQLException e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] SQL Exception " + e.getMessage());
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCoursesByUserId out!");
		int[] result = new int[courses.size()];
		int i=0;
		for(Integer cid : courses)
			result[i++]=cid;
		return result;
	}

	//***********************************************************
	//	Credit type Management
	//***********************************************************

	public int addCreditType(String name, String resource, int courseId, int policyId,
			Boolean active, Boolean assignable) {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] addCreditType Inside!");

		try {

			String sql = "INSERT INTO credit_type(";
			sql+=	"name, " +
					"resource, " +
					"course_id, " +
					"active, " +
					"assignable";
			if(policyId>0)
				sql+=",policy_id";
			sql+=") ";
			sql+=" VALUES(?,?,?,?,?";
			if(policyId>0)
				sql+=",?";
			sql+=")";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, resource);
			ps.setInt(3, courseId);
			ps.setBoolean(4, active);
			ps.setBoolean(5, assignable);

			if(policyId>0)
				ps.setInt(6, policyId);
			int id = 0;
			ps.executeUpdate();

			sql = "SELECT * FROM credit_type WHERE name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}

			ps.close();

			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] addCreditType out!");

			return id;

		} catch (SQLException e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}

	}

	public void modifyCreditType(int id, String name, String resource, int courseId, int policyId,
			Boolean active, Boolean assignable) {

		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] modifyCreditType Inside!");
			String sql = "UPDATE credit_type SET ";
			sql+=	"name = ?, "	+
					"resource = ?, " 	+
					"course_id = ?, " 	+
					"active = ?, "	+
					"assignable = ? ";
			if(policyId>0)
				sql+= ",policy_id = ? "	;
			else
				sql+= ",policy_id = null ";
			sql+=	"WHERE id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, resource);
			ps.setInt(3, courseId);
			ps.setBoolean(4, active);
			ps.setBoolean(5, assignable);

			if(policyId>0){
				ps.setInt(6, policyId);
				ps.setInt(7, id);
			}else{
				ps.setInt(6, id);
			}


			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] modifyCreditType out!");
	}

	public void deleteCreditType(int id) {
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] deleteCreditType Inside!");
		try {

			String sql = "DELETE FROM credit_type WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] deleteCreditType out!");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}
	}

	public boolean isCreditTypeAssigned(int creditTypeId)
	{
		boolean response =  false;
		try{
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] isCreditTypeAssigned Inside!");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_assigned_quota WHERE credit_type_id = ?");
			ps.setInt(1, creditTypeId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				response = true;
			}
			ps.close();

		}catch(SQLException e){
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] "+e.getMessage());
			throw new Error(e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] "+e.getMessage());
			throw new Error(e.getMessage());

		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] isCreditTypeAssigned out! ");
		return response;

	}

	public CreditType getCreditTypeById(int id) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCreditType Inside!");
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCreditType id = " + id);

		CreditType creditType = null;
		try {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM credit_type WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				String resource = rs.getString("resource");
				int courseId = rs.getInt("course_id");
				int policyId = rs.getInt("policy_id");
				Boolean active = rs.getBoolean("active");
				Boolean assignable = rs.getBoolean("assignable");

				creditType = new CreditType();
				creditType.setId(id);
				creditType.setName(name);
				creditType.setResource(resource);

				Course course = this.getCourseById(courseId);
				creditType.setCourse(course);

				if(policyId > 0){
					Policy policy = this.getPolicyById(policyId);
					creditType.setPolicy(policy);

				}

				creditType.setActive(active);
				creditType.setAssignable(assignable);
				DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] " + creditType.toString());

			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}

		if (creditType == null)
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCreditType creditType is null!");
		else
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCreditType creditType is " + creditType);
			
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCreditType out!");
		return creditType;
	}

	public List<CreditType> getCreditTypesByPolicy(int policyId){
		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] getCreditTypesByPolicy Inside!");
		List<CreditType> creditTypesArr = new ArrayList<CreditType>();

		String sql = "SELECT * FROM credit_type WHERE policy_id = "+policyId;
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String resource = rs.getString("resource");
				int courseId = rs.getInt("course_id");
				Boolean active = rs.getBoolean("active");
				Boolean assignable = rs.getBoolean("assignable");
				CreditType creditType = new CreditType();
				creditType.setId(id);
				creditType.setName(name);
				creditType.setResource(resource);

				Course course = this.getCourseById(courseId);
				creditType.setCourse(course);

				if(policyId != 0){
					Policy policy = this.getPolicyById(policyId);
					creditType.setPolicy(policy);

				}

				creditType.setActive(active);
				creditType.setAssignable(assignable);

				creditTypesArr.add(creditType);

			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] getCreditTypesByPolicy out!");
		return creditTypesArr;
	}


	public List<CreditType> getCreditTypesByCourse(int[] courses) {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] getCreditTypesByCourse Inside!");

		List<CreditType> creditTypesArr = new ArrayList<CreditType>();

		String sql = "SELECT * FROM credit_type WHERE course_id = "+courses[0];

		if (courses.length > 1) {
			for (int i = 1; i < courses.length; i++) {
				sql += " or course_id = " + courses[i];

			}

		}

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String resource = rs.getString("resource");
				int courseId = rs.getInt("course_id");
				int policyId = rs.getInt("policy_id");
				Boolean active = rs.getBoolean("active");
				Boolean assignable = rs.getBoolean("assignable");
				CreditType creditType = new CreditType();
				creditType.setId(id);
				creditType.setName(name);
				creditType.setResource(resource);

				Course course = this.getCourseById(courseId);
				creditType.setCourse(course);

				if(policyId != 0){
					Policy policy = this.getPolicyById(policyId);
					creditType.setPolicy(policy);

				}

				creditType.setActive(active);
				creditType.setAssignable(assignable);

				creditTypesArr.add(creditType);

			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCreditTypesByCourse out!");

		return creditTypesArr;
	}

	public List<CreditType> getCreditTypesByCourseAndResource(int courseId, String resource) {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] getCreditTypesByCourseAndResource Inside!");

		List<CreditType> creditTypesArr = new ArrayList<CreditType>();

		String sql = "SELECT * FROM credit_type WHERE course_id = "+courseId+" and resource = '"+resource+"'";

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] SQL query:" + sql);

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int policyId = rs.getInt("policy_id");
				Boolean active = rs.getBoolean("active");
				Boolean assignable = rs.getBoolean("assignable");
				CreditType creditType = new CreditType();
				creditType.setId(id);
				creditType.setName(name);
				creditType.setResource(resource);

				Course course = this.getCourseById(courseId);
				creditType.setCourse(course);

				if(policyId != 0){
					Policy policy = this.getPolicyById(policyId);
					creditType.setPolicy(policy);

				}

				creditType.setActive(active);
				creditType.setAssignable(assignable);

				creditTypesArr.add(creditType);

				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + name+ " was added!");

			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCreditTypesByCourse out!");

		return creditTypesArr;
	}

	public List<CreditType> getCreditTypes() {

		List<CreditType> creditTypesArr = new ArrayList<CreditType>();

		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCreditTypes Inside!");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM credit_type");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String resource = rs.getString("resource");
				int courseId = rs.getInt("course_id");
				int policyId = rs.getInt("policy_id");
				boolean assignable = rs.getBoolean("assignable");
				boolean active = rs.getBoolean("active");

				CreditType creditType = new CreditType();
				creditType.setId(id);
				creditType.setName(name);
				creditType.setResource(resource);

				Course course = this.getCourseById(courseId);
				creditType.setCourse(course);

				if(policyId > 0){
					Policy policy = this.getPolicyById(policyId);
					creditType.setPolicy(policy);

				}

				creditType.setActive(active);
				creditType.setAssignable(assignable);
				creditTypesArr.add(creditType);

			}
			ps.close();

		} catch (SQLException e) {
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] SQL Exception " + e.getMessage());
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCreditTypes out!");
		return creditTypesArr;
	}

	public List<CreditType> getAssignableCreditTypes() {
		List<CreditType> creditTypesArr = new ArrayList<CreditType>();

		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getAssignableCreditTypes Inside!");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM credit_type WHERE assignable = ?");
			ps.setBoolean(1, true);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String resource = rs.getString("resource");
				int courseId = rs.getInt("course_id");
				int policyId = rs.getInt("policy_id");
				boolean active = rs.getBoolean("active");
				boolean assignable = rs.getBoolean("assignable");

				CreditType creditType = new CreditType();
				creditType.setId(id);
				creditType.setName(name);
				creditType.setResource(resource);

				Course course = this.getCourseById(courseId);
				creditType.setCourse(course);

				if(policyId != 0){
					Policy policy = this.getPolicyById(policyId);
					creditType.setPolicy(policy);

				}

				creditType.setActive(active);
				creditType.setAssignable(assignable);
				creditTypesArr.add(creditType);

			}
			ps.close();

		} catch (SQLException e) {
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] SQL Exception " + e.getMessage());
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getAssignableCreditTypes out!");
		return creditTypesArr;
	}

	//***********************************************************
	//	Quota Management
	//***********************************************************

	public void assignQuotaToCourse(int creditTypeId, Float quantity,
			String purchaseId,Timestamp startDate)
	{
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] assignQuotaToCourse Inside!");
		try {


			String sql = "INSERT INTO course_assigned_quota";
			sql += "(credit_type_id, quantity,purchase_id, start_date, active) ";
			sql += "VALUES(?, ?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, creditTypeId);
			ps.setFloat(2, quantity);
			ps.setString(3, purchaseId);
			ps.setTimestamp(4, startDate);
			ps.setBoolean(5,true);

			ps.executeUpdate();
			ps.close();

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] assignQuotaToCourse out!");


		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());

		}
	}

	public void modifyCourseQuota(String purchaseId, int creditTypeId,Float quantity,Timestamp startDate) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] modifyCourseQuota Inside!");
		try {

				String sql = "UPDATE course_assigned_quota SET ";
				sql += "quantity = ?, ";
				sql += "start_date =? ";
				sql += "WHERE  credit_type_id = ? and purchase_id = ?";


				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setFloat(1, quantity);
				ps.setTimestamp(2, startDate);
				ps.setInt(3, creditTypeId);
				ps.setString(4, purchaseId);

				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB]"+ps.executeUpdate());

				ps.close();

				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] modifyCourseQuota out!");


		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());

		}


	}

	public void cancelCourseQuota(String purchaseId,int  creditTypeId) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] cancelCourseQuota Inside!");
		try {

				String sql = "UPDATE course_assigned_quota SET ";
				sql += "active = ? ";
				sql += "WHERE  credit_type_id=? and purchase_id = ?";


				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setBoolean(1, false);
				ps.setInt(2, creditTypeId);
				ps.setString(3, purchaseId);
				ps.executeUpdate();
				ps.close();

				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] cancelCourseQuota out!");


		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());

		}


	}


	public List<QuotaAssignment> getActiveCourseAssignedQuota(int courseId){
		List<QuotaAssignment> assignments = new ArrayList<QuotaAssignment>();

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCourseAssignedQuota Inside!");

		try {
			String sql = "SELECT * FROM course_assigned_quota WHERE credit_type_id IN ( SELECT id FROM credit_type WHERE course_id = ? and active = ?) and active = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, courseId);
			ps.setBoolean(2, true);
			ps.setBoolean(3, true);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				
				QuotaAssignment assignment = new QuotaAssignment();
				assignment.setPurchaseId(rs.getString("purchase_id"));
				assignment.setCreditType(getCreditTypeById(rs.getInt("credit_type_id")));
				assignment.setQuantity(rs.getFloat("quantity"));
				assignment.setActive(rs.getBoolean("active"));
				assignments.add(assignment);
				
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] assignment :"+assignment.toString());
			}

			ps.close();

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getCourseAssignedQuota out!");


		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());

		}

		return assignments;
	}


	public void assignQuota(int creditTypeId, int userId, Float quantity,
		Boolean active, Timestamp startDate,String purchaseId, boolean payment) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] assignQuota Inside!");
		try {


			String sql = "INSERT INTO user_assigned_quota";
			sql += "(credit_type_id, user_id, quantity,purchase_id, start_date, active, payment) ";
			sql += "VALUES(?, ?,?,?,?,?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, creditTypeId);
			ps.setInt(2, userId);
			ps.setFloat(3, quantity);
			ps.setString(4, purchaseId);
			ps.setTimestamp(5, startDate);
			ps.setBoolean(6,active);
			ps.setBoolean(7,payment);


			ps.executeUpdate();
			ps.close();

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] assignQuota out!");


		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());

		}


	}

	public void modifyQuota(int creditTypeId, Float quantity,Timestamp startDate,String purchaseId) {

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] modifyQuota Inside!");
			try {

					String sql = "UPDATE user_assigned_quota SET ";
					sql += "quantity = ?, ";
					sql += "start_date =? ";
					sql += "WHERE purchase_id = ? and credit_type_id = ? and active = ?";


					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setFloat(1, quantity);
					ps.setTimestamp(2, startDate);
					ps.setString(3, purchaseId);
					ps.setInt(4, creditTypeId);
					ps.setBoolean(5, true);

					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] "+ps.executeUpdate());

					ps.close();

					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] modifyQuota out!");


			} catch (SQLException e) {
				e.printStackTrace();
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
				throw new Error(e.getMessage());

			}


	}

	public void cancelQuota(int creditTypeId, String purchaseId) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] cancelQuota Inside!");
		try {

				String sql = "UPDATE user_assigned_quota SET ";
				sql += "active = ? ";
				sql += "WHERE purchase_id = ? and credit_type_id = ?";


				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setBoolean(1, false);
				ps.setString(2, purchaseId);
				ps.setInt(3, creditTypeId);

				ps.executeUpdate();

				ps.close();

				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] cancelQuota out!");


		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());

		}


	}

	public void allocateQuota(int periodNumber, int quota, String appointmentId, String affiliationId, int userAssignedQuotaId, Calendar start, Calendar end, boolean cancelled) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] allocateQuota Inside!");

		try {

			String sql = "INSERT INTO used_quota(period_number,quota,appointment_id,affiliation_id,user_assigned_quota_id,start_time,end_time,cancelled) "+
			"VALUES(?,?,?,?,?,'"+start.getTime().toString()+"','"+end.getTime().toString()+"',?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,periodNumber);
			ps.setInt(2,quota);
			ps.setString(3,appointmentId);
			ps.setString(4,affiliationId);
			ps.setInt(5,userAssignedQuotaId);
			ps.setBoolean(6, cancelled);
			ps.executeUpdate();
			ps.close();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] allocateQuota out!");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

	}

	public boolean cancelAppointment(String appointmentId) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] cancelAppointment Inside!");

		try {

			String sql = "UPDATE used_quota SET cancelled = ? WHERE appointment_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, true);
			ps.setString(2, appointmentId);

			ps.executeUpdate();
			ps.close();

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] cancelAppointment out!");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		return true;
	}

	public boolean cancelAppointmentById(int id) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] cancelAppointmentById Inside!");

		try {

			String sql = "UPDATE used_quota SET cancelled = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, true);
			ps.setInt(2, id);

			ps.executeUpdate();
			ps.close();

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] cancelAppointmentById out!");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		return true;
	}

    /*
     * Modified by Masoud Sadjadi on Nov. 22, 2014  to address the following bug!
     * When modification is not successful, the restore function much first look for the 
     * portion of the canceled appointment that was in the past, delete that one, and then
     * look for the original appointment that was set to cancel and make it active again.
     * Note that an appointment may go to more than one modification and restoring means 
     * just to fix the top of the stack and not all the previous modifications too! 
     */
	public boolean restoreAppointment(String appointmentId) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment Inside!");

		try {

			// First, find all the records for this appointment in the reverse order.
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment: "
					+ "finding the records for this appointment.");
			String sql1 = "SELECT * from used_quota WHERE appointment_id = ? order by id desc";
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setString(1, appointmentId);
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment, ps1: " + ps1);
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()) {
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment: "
						+ "Checking to see if the next record is recent.");
				Timestamp updateTimestamp = rs1.getTimestamp("update_ts");
				Calendar updateTime = Calendar.getInstance();
				updateTime.setTimeInMillis(updateTimestamp.getTime());
				Calendar now = Calendar.getInstance();
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment: "
						+ "updateTime is " + updateTime.getTime() + " and now is " + now.getTime());
				if (updateTime.getTime().getTime() > (now.getTime().getTime() - 2000)) {
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment: "
							+ "updateTime is recent (within the past 2 seconds).");
					int id = rs1.getInt("id");
					boolean cancelled = rs1.getBoolean("cancelled");
					if (!cancelled) {			
						DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment: "
								+ "Deleting used_quota record with id: " + id);
						String sql2 = "DELETE FROM used_quota WHERE id = ?";
						PreparedStatement ps2 = conn.prepareStatement(sql2);
						ps2.setInt(1, id);
						DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment, ps2: " + ps2);
						ps2.executeUpdate();
						ps2.close();
						DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment: "
								+ "Record id " + id + " was deleted from used_quota.");
					} else {
						DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment: "
								+ "See if the cancelled record's end time is in the future.");
						Timestamp endTimestamp = rs1.getTimestamp("end_time");
						Calendar endTime = Calendar.getInstance();
						endTime.setTimeInMillis(endTimestamp.getTime());
						DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment: "
								+ "See if the cancelled record's end time is in the future.");
						DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment: "
								+ "endTime is " + endTime.getTime() + " and now is " + now.getTime());
						if (endTime.getTime().getTime() > now.getTime().getTime()) {
							DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment: "
									+ "endTime is in the future.");
							String sql3 = "UPDATE used_quota SET cancelled = ? WHERE id = ?";
							PreparedStatement ps3 = conn.prepareStatement(sql3);
							ps3.setBoolean(1, false);
							ps3.setInt(2, id);
							DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment, ps3: " + ps3);
							ps3.executeUpdate();
							ps3.close();
							DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment: "
									+ "Record id " + id + " was updated within used_quota.");						
						} else {
							DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment: "
									+ "endTime is in the past.");
							// break;

						}
					}
				} else {
					DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment: "
							+ "updateTime is recent (within the past 2 seconds).");
					break;
				}
			}
			ps1.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment out!");

		return true;
	}
/*
	public boolean restoreAppointment(String appointmentId) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment Inside!");

		try {

			String sql = "UPDATE used_quota SET cancelled = ? WHERE appointment_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, false);
			ps.setString(2, appointmentId);

			ps.executeUpdate();
			ps.close();

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] restoreAppointment out!");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		return true;
	}
*/
	public boolean cancelAllAppointments(String affiliationId) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] cancelAllAppointments Inside!");

		try {

			String sql = "UPDATE used_quota SET cancelled = ? WHERE affiliation_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, true);
			ps.setString(2, affiliationId);

			ps.executeUpdate();
			ps.close();

			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] cancelAllAppointments out!");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		return true;
	}

	public UserAssignedQuota getUserAssignedQuotaByPurchaseAndCreditTypeAndUser(String purchaseId, int userId, int creditTypeId) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserAssignedQuotaByPurchaseAndCreditTypeAndUser inside!");


		UserAssignedQuota assignedQuota= null;

		try {
			String sql = "SELECT * FROM user_assigned_quota WHERE purchase_id=? and user_id =? and credit_type_id=? and active = TRUE";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, purchaseId);
			ps.setInt(2, userId);
			ps.setInt(3, creditTypeId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				assignedQuota =  new UserAssignedQuota();
				assignedQuota.setId(rs.getInt("id"));
				assignedQuota.setPurchaseId(rs.getString("purchase_id"));
				assignedQuota.setActive(rs.getBoolean("active"));
				assignedQuota.setQuantity(rs.getFloat("quantity"));
				assignedQuota.setStartDate(rs.getTimestamp("start_date"));

				CreditType creditType = getCreditTypeById(rs.getInt("credit_type_id"));
				UserProfile user = getUserById(rs.getInt("user_id"));

				assignedQuota.setCreditType(creditType);
				assignedQuota.setUserProfile(user);

			}
			ps.close();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserAssignedQuotaByPurchaseAndCreditTypeAndUser out!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}
		return assignedQuota;
	}

	public UserAssignedQuota getUserAssignedQuotaByPurchaseAndCreditType(String purchaseId, int creditTypeId) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserAssignedQuotaByPurchaseAndCreditType inside!");


		UserAssignedQuota assignedQuota= null;

		try {

			String sql = "SELECT * FROM user_assigned_quota WHERE purchase_id=? and credit_type_id = ? and active = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, purchaseId);
			ps.setInt(2, creditTypeId);
			ps.setBoolean(3,true);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				assignedQuota =  new UserAssignedQuota();
				assignedQuota.setId(rs.getInt("id"));
				assignedQuota.setPurchaseId(rs.getString("purchase_id"));
				assignedQuota.setActive(rs.getBoolean("active"));
				assignedQuota.setQuantity(rs.getFloat("quantity"));
				assignedQuota.setStartDate(rs.getTimestamp("start_date"));

				CreditType creditType = getCreditTypeById(rs.getInt("credit_type_id"));
				UserProfile user = getUserById(rs.getInt("user_id"));

				assignedQuota.setCreditType(creditType);
				assignedQuota.setUserProfile(user);


			}
			ps.close();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserAssignedQuotaByPurchaseAndCreditType out!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}
		return assignedQuota;
	}

	public List<UserAssignedQuota> getUserAssignedQuotaByPurchase(String purchaseId) {


		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserAssignedQuotaByPurchase inside!");

		List<UserAssignedQuota> assignedQuotas = new ArrayList<UserAssignedQuota>();

		UserAssignedQuota assignedQuota= null;

		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserAssignedQuotaByPurchaseAndCreditType() inside!");
			String sql = "SELECT * FROM user_assigned_quota WHERE purchase_id=? and active = TRUE";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, purchaseId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				assignedQuota =  new UserAssignedQuota();
				assignedQuota.setId(rs.getInt("id"));
				assignedQuota.setPurchaseId(rs.getString("purchase_id"));
				assignedQuota.setActive(rs.getBoolean("active"));
				assignedQuota.setQuantity(rs.getFloat("quantity"));
				assignedQuota.setStartDate(rs.getTimestamp("start_date"));

				CreditType creditType = getCreditTypeById(rs.getInt("credit_type_id"));
				UserProfile user = getUserById(rs.getInt("user_id"));

				assignedQuota.setCreditType(creditType);
				assignedQuota.setUserProfile(user);

				assignedQuotas.add(assignedQuota);

			}
			ps.close();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserAssignedQuotaByPurchase out!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}
		return assignedQuotas;
	}

	public List<UserAssignedQuota> getUserAssignedQuotaByUser(UserProfile user) {
		List<UserAssignedQuota> assignedQuota = new ArrayList<UserAssignedQuota>();
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserAssignedQuotaByUser("+user.getUsername()+") Inside!");

		try {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_assigned_quota WHERE user_id = ? and active = ?");
			ps.setInt(1, user.getId());
			ps.setBoolean(2, true);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String purchaseId = rs.getString("purchase_id");
				Timestamp startDate = rs.getTimestamp("start_date");
				int quantity = rs.getInt("quantity");
				boolean active = rs.getBoolean("active");
				int creditTypeId = rs.getInt("credit_type_id");

				UserAssignedQuota userAssignedQuota = new UserAssignedQuota();
				userAssignedQuota.setId(id);
				userAssignedQuota.setPurchaseId(purchaseId);
				userAssignedQuota.setStartDate(startDate);
				userAssignedQuota.setQuantity(quantity);
				userAssignedQuota.setActive(active);
				userAssignedQuota.setUserProfile(user);
				userAssignedQuota.setCreditType(this.getCreditTypeById(creditTypeId));
				assignedQuota.add(userAssignedQuota);

				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] "+userAssignedQuota.toString());
			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}


		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserAssignedQuotaByUser out!");

		return assignedQuota;


	}

	public List<UserAssignedQuota> getUserAssignedQuota(int creditTypeId, int userId) {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] getUserAssignedQuota Inside!");

		UserProfile user = getUserById(userId);
		CreditType creditType = getCreditTypeById(creditTypeId);

		List<UserAssignedQuota> assignedQuotaList = new ArrayList<UserAssignedQuota>();

		String sql = "SELECT * FROM user_assigned_quota WHERE user_id='"+userId+"' and credit_type_id='"+creditTypeId+"'";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String purchaseId = rs.getString("purchase_id");
				Timestamp startDate = rs.getTimestamp("start_date");
				int quantity = rs.getInt("quantity");
				boolean active = rs.getBoolean("active");

				UserAssignedQuota userAssignedQuota = new UserAssignedQuota();
				userAssignedQuota.setId(id);
				userAssignedQuota.setPurchaseId(purchaseId);
				userAssignedQuota.setStartDate(startDate);
				userAssignedQuota.setQuantity(quantity);
				userAssignedQuota.setActive(active);
				userAssignedQuota.setUserProfile(user);
				userAssignedQuota.setCreditType(creditType);

				//Add not cancelled used quotas for this assigned quota
				userAssignedQuota.setUsedQuotas(getUsedQuota(id));
				assignedQuotaList.add(userAssignedQuota);

			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserAssignedQuota out!");

		return assignedQuotaList;
	}

	public UserAssignedQuota getUserAssignedQuotaById(int assignedQuotaId) {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] getUserAssignedQuota Inside!");

		UserAssignedQuota userAssignedQuota = null;

		String sql = "SELECT * FROM user_assigned_quota WHERE id='"+assignedQuotaId+"'";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String purchaseId = rs.getString("purchase_id");
				Timestamp startDate = rs.getTimestamp("start_date");
				int quantity = rs.getInt("quantity");
				boolean active = rs.getBoolean("active");
				int userId = rs.getInt("user_id");
				int creditTypeId = rs.getInt("credit_type_id");

				UserProfile user = getUserById(userId);
				CreditType creditType = getCreditTypeById(creditTypeId);

				userAssignedQuota = new UserAssignedQuota();
				userAssignedQuota.setId(id);
				userAssignedQuota.setPurchaseId(purchaseId);
				userAssignedQuota.setStartDate(startDate);
				userAssignedQuota.setQuantity(quantity);
				userAssignedQuota.setActive(active);
				userAssignedQuota.setUserProfile(user);
				userAssignedQuota.setCreditType(creditType);

				//Add not cancelled used quotas for this assigned quota
				userAssignedQuota.setUsedQuotas(getUsedQuota(id));

			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUserAssignedQuota out!");

		return userAssignedQuota;
	}

	public List<UsedQuota> getUsedQuota(int assignedQuotaId) {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] getUsedQuota Inside!");
		List<UsedQuota> usedQuotaList = new ArrayList<UsedQuota>();

		try {
			String sql = "SELECT * FROM used_quota WHERE user_assigned_quota_id= ? and cancelled= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, assignedQuotaId);
			ps.setBoolean(2, false);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int periodNumber = rs.getInt("period_number");
				int quota = rs.getInt("quota");
				boolean cancelled = rs.getBoolean("cancelled");
				String appointmentId = rs.getString("appointment_id");
				Timestamp start = rs.getTimestamp("start_time");
				Timestamp end = rs.getTimestamp("end_time");

				UsedQuota usedQuota = new UsedQuota();
				usedQuota.setId(id);
				usedQuota.setPeriodNumber(periodNumber);
				usedQuota.setCancelled(cancelled);
				usedQuota.setAppointmentId(appointmentId);
				usedQuota.setQuota(quota);
				usedQuota.setStartTime(start);
				usedQuota.setEndTime(end);

				usedQuotaList.add(usedQuota);
				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " +usedQuota.getId()+ " was added!");

			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUsedQuota out!");

		return usedQuotaList;
	}

	public List<UsedQuota> getUsedQuotaByAppointmentId(String appointmentId) {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] getUsedQuotaByAppointmentId Inside!");
		List<UsedQuota> usedQuotaList = new ArrayList<UsedQuota>();

		try {
			String sql = "SELECT * FROM used_quota WHERE appointment_id= ? and cancelled= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, appointmentId);
			ps.setBoolean(2, false);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int periodNumber = rs.getInt("period_number");
				int quota = rs.getInt("quota");
				boolean cancelled = rs.getBoolean("cancelled");
				String affiliationId = rs.getString("affiliation_id");
				Timestamp start = rs.getTimestamp("start_time");
				Timestamp end = rs.getTimestamp("end_time");
				int assignedQuotaId = rs.getInt("user_assigned_quota_id");

				UsedQuota usedQuota = new UsedQuota();
				usedQuota.setId(id);
				usedQuota.setPeriodNumber(periodNumber);
				usedQuota.setCancelled(cancelled);
				usedQuota.setAppointmentId(appointmentId);
				usedQuota.setAffiliationId(affiliationId);
				usedQuota.setQuota(quota);
				usedQuota.setStartTime(start);
				usedQuota.setEndTime(end);
				usedQuota.setUserAssignedQuota(getUserAssignedQuotaById(assignedQuotaId));

				usedQuotaList.add(usedQuota);

			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUsedQuotaByAppointmentId out!");

		return usedQuotaList;
	}

	public List<UsedQuota> getUsedQuotaByAffiliationId(String affiliationId) {

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] getUsedQuotaByAffiliationId Inside!");
		List<UsedQuota> usedQuotaList = new ArrayList<UsedQuota>();

		try {
			String sql = "SELECT * FROM used_quota WHERE affiliation_id= ? and cancelled= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, affiliationId);
			ps.setBoolean(2, false);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int periodNumber = rs.getInt("period_number");
				int quota = rs.getInt("quota");
				boolean cancelled = rs.getBoolean("cancelled");
				String appointmentId = rs.getString("appointment_id");
				Timestamp start = rs.getTimestamp("start_time");
				Timestamp end = rs.getTimestamp("end_time");
				int assignedQuotaId = rs.getInt("user_assigned_quota_id");

				UsedQuota usedQuota = new UsedQuota();
				usedQuota.setId(id);
				usedQuota.setPeriodNumber(periodNumber);
				usedQuota.setCancelled(cancelled);
				usedQuota.setAppointmentId(appointmentId);
				usedQuota.setAffiliationId(affiliationId);
				usedQuota.setQuota(quota);
				usedQuota.setStartTime(start);
				usedQuota.setEndTime(end);
				usedQuota.setUserAssignedQuota(getUserAssignedQuotaById(assignedQuotaId));

				usedQuotaList.add(usedQuota);

			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getUsedQuotaByAffiliationId out!");

		return usedQuotaList;
	}

	public List<QuotaAssignment> addQuotaAssignments( List<QuotaAssignment> assignments, UserProfile user, boolean payment){

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] addQuotaAssignments inside!");

		// Iterate through assignments array
		for(edu.fiu.cis.acrl.quotasystem.entity.QuotaAssignment assignment:assignments){
			if(assignment.isActive()){
				//Get assignments values
				edu.fiu.cis.acrl.quotasystem.entity.CreditType creditType = assignment.getCreditType();
				float quantity = assignment.getQuantity();
				String purchaseId = assignment.getPurchaseId();

				// If policy is assigned, set the respective start date
				Timestamp startDateTs = new Timestamp(System.currentTimeMillis());
				edu.fiu.cis.acrl.quotasystem.entity.Policy policy = creditType.getPolicy();
				if (policy != null) {
					if (policy.getAbsolute()){
						startDateTs = policy.getStartDate();
					}else{
						Calendar startDate = Calendar.getInstance();
						startDate.setTime(startDateTs);
						startDate.add(Calendar.DAY_OF_MONTH, policy.getDaysToRelStart());
						startDateTs.setTime(startDate.getTimeInMillis());
					}

				}

				//Save quota in quota system database
				try {
					assignQuota(creditType.getId(), user.getId(), quantity,true, startDateTs, purchaseId, payment);

				} catch (Error e) {
					e.printStackTrace();
					assignment.setActive(false);
				}
			}
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] addQuotaAssignments out!");
		return assignments;
	}

	public boolean isQuotaAssignmentUsed(QuotaAssignment assignment) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] isQuotaAssignmentUsed inside!");

		boolean response = false;

		List<edu.fiu.cis.acrl.quotasystem.entity.UserProfile> students =
			assignment.getCreditType().getCourse().getUserProfiles();

		// Iterate through students
		for(edu.fiu.cis.acrl.quotasystem.entity.UserProfile student:students){

			edu.fiu.cis.acrl.quotasystem.entity.UserAssignedQuota assignedQuota =
				getUserAssignedQuotaByPurchaseAndCreditTypeAndUser(assignment.getPurchaseId(),student.getId(), assignment.getCreditType().getId());

			if(assignedQuota!=null){
				assignedQuota.setUsedQuotas(getUsedQuota(assignedQuota.getId()));
				float usedQuota = assignedQuota.getUsedQuotaTotal();
				if (usedQuota > 0) {
					response = true;
					break;
				}
			}
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] isQuotaAssignmentUsed out!");

		return response;
	}

	//***********************************************************
	//	Policy Management
	//***********************************************************

	public int addNoExpirationPolicy(String name, String description,
    Calendar startDate, int daysToRelStart, Boolean active, int quotaInPeriod,
    boolean absolute,boolean assignable) {

		DebugTools.println(DEBUG_LEVEL,
				"[QuotaSystem - DB] addNoExpirationPolicy Inside!");

		int id = 0;

		String sql = "INSERT INTO policy ";

		if (absolute)// FIXED-ABS
		{
			sql += "(name, description,  number_of_periods, active, days_in_period, maximum, minimum,absolute, assignable, quota_in_period ,policy_type, start_date )  ";
			sql += "VALUES(?,?,?,?,?,?,?,?,?,?,'" + QuotaSystem.POLICIES[3] + "','"+ startDate.getTime().toString() + "')";

		} else // FIXED-REL
		{
			sql += "(name, description, number_of_periods, active, days_in_period, maximum, minimum,absolute, assignable, quota_in_period, policy_type, days_to_rel_start)  ";
			sql += "VALUES(?,?,?,?,?,?,?,?,?,?,'" + QuotaSystem.POLICIES[3] + "',"+daysToRelStart+")";

		}

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setInt(3, 1);
			ps.setBoolean(4, active);
			ps.setInt(5,Integer.MAX_VALUE);
			ps.setInt(6, quotaInPeriod);
			ps.setInt(7, quotaInPeriod);
			ps.setBoolean(8, absolute);
			ps.setBoolean(9, assignable);
			ps.setFloat(10, quotaInPeriod);
			ps.executeUpdate();
			ps.close();

			sql = "SELECT * FROM policy WHERE name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] addNoExpirationPolicy out!");
		return id;

	}

	public int addFixedPolicy(String name, String description,
    Calendar startDate, int daysInPeriod,int daysToRelStart, int numberOfPeriods,
	Boolean active, int quotaInPeriod, boolean absolute,
	boolean assignable) {

		DebugTools.println(DEBUG_LEVEL,
				"[QuotaSystem - DB] addFixedPolicy Inside!");

		int id = 0;

		String sql = "INSERT INTO policy ";

		if (absolute)// FIXED-ABS
		{
			sql += "(name, description,  number_of_periods, active, days_in_period, maximum, minimum,absolute, assignable, quota_in_period, policy_type, start_date ) ";
			sql += "VALUES(?,?,?,?,?,?,?,?,?,?,'" + QuotaSystem.POLICIES[0] + "','"+ startDate.getTime().toString() + "')";

		} else // FIXED-REL
		{
			sql += "(name, description, number_of_periods, active, days_in_period, maximum, minimum,absolute, assignable, quota_in_period, policy_type, days_to_rel_start) ";
			sql += "VALUES(?,?,?,?,?,?,?,?,?,?,'" + QuotaSystem.POLICIES[0] + "',"+daysToRelStart+")";

		}

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setInt(3, 1);
			ps.setBoolean(4, active);
			ps.setInt(5, daysInPeriod);
			ps.setInt(6, quotaInPeriod);
			ps.setInt(7, quotaInPeriod);
			ps.setBoolean(8, absolute);
			ps.setBoolean(9, assignable);
			ps.setFloat(10, quotaInPeriod);
			ps.executeUpdate();
			ps.close();

			sql = "SELECT * FROM policy WHERE name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] addFixedPolicy out!");
		return id;

	}

	public int addGradualPolicy(String name, String description,
			Calendar startDate, int daysInPeriod, int daysToRelStart,int numberOfPeriods,
			Boolean active, int quotaInPeriod,boolean absolute,boolean assignable)

	{

		DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] addGradualPolicy Inside!");

		int id = 0;

		String sql = "INSERT INTO policy ";


		if (absolute)// GRADUALEXP-ABS
		{
			sql += "(name, description,  days_in_period, number_of_periods, active, maximum, minimum, absolute, assignable, quota_in_period, policy_type,  start_date) ";
			sql += "VALUES(?,?,?,?,?,?,?,?,?,?,'" + QuotaSystem.POLICIES[1] + "','"+ startDate.getTime().toString() + "')";

		} else//GRADUALEXP-REL
		{
			sql += "(name, description,  days_in_period, number_of_periods, active,maximum, minimum, absolute, assignable, quota_in_period,  policy_type, days_to_rel_start ) ";
			sql += "VALUES(?,?,?,?,?,?,?,?,?,?,'" + QuotaSystem.POLICIES[1] + "',"+daysToRelStart+")";

		}

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setInt(3, daysInPeriod);
			ps.setInt(4, numberOfPeriods);
			ps.setBoolean(5, active);
			ps.setInt(6, quotaInPeriod);
			ps.setInt(7, quotaInPeriod);
			ps.setBoolean(8, absolute);
			ps.setBoolean(9, assignable);
			ps.setInt(10, quotaInPeriod);
			ps.executeUpdate();
			ps.close();

			sql = "SELECT * FROM policy WHERE name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL,
				"[QuotaSystem - DB] addGradualPolicy out!");

		return id;

	}

	public int addMinMaxPolicy(String name, String description,
			Calendar startDate, int daysInPeriod,int daysToRelStart, int numberOfPeriods,
			Boolean active, int maximum, int minimum, int quotaInPeriod,
			boolean absolute, boolean assignable) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] addMinMaxPolicy Inside!");

		int id = 0;
		String sql = "INSERT INTO policy ";

		if (absolute)// MINMAXEXP-ABS
		{
			sql += "(name, description,  days_in_period, number_of_periods, active, maximum, minimum,policy_type, start_date, absolute, assignable, quota_in_period) ";
			sql += "VALUES(?,?,?,?,?,?,?,'" + QuotaSystem.POLICIES[2] + "','"
					+ startDate.getTime().toString() + "',?,?,?)";

		} else// //MINMAXEXP-REL
		{
			sql += "(name, description,  days_in_period, number_of_periods, active, maximum, minimum, policy_type, absolute, assignable, quota_in_period, days_to_rel_start) ";
			sql += "VALUES(?,?,?,?,?,?,?,'" + QuotaSystem.POLICIES[2] + "',?,?,?,"+daysToRelStart+")";

		}

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setInt(3, daysInPeriod);
			ps.setInt(4, numberOfPeriods);
			ps.setBoolean(5, active);
			ps.setInt(6, maximum);
			ps.setInt(7, minimum);
			ps.setBoolean(8, absolute);
			ps.setBoolean(9, assignable);
			ps.setInt(10, quotaInPeriod);
			ps.executeUpdate();
			ps.close();

			sql = "SELECT * FROM policy WHERE name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			}

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] addMinMaxPolicy out!");
		return id;

	}

	public void modifyPolicy(int id, String name, String description,
			Calendar startDate, int daysInPeriod, int daysToRelStart, int numberOfPeriods,
			Boolean active, int maximum, int minimum, int quotaInPeriod,
			boolean absolute, boolean assignable, String type) {

		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] modifyPolicy Inside!");
			String sql = "UPDATE policy SET ";
			sql+=	"name = ?, "	+
					"description = ?, " +
					"policy_type = '" +type+"', "+

					"active = ?, "	+
					"assignable = ?, "+

					"absolute = ?, ";
					if(absolute){
						sql+="start_date = '"+startDate.getTime().toString()+"', ";
					}else{
						sql+="start_date = null, ";
					}
			sql+=	"days_in_period = ? , " +
					"number_of_periods = ?, " +

					"maximum = ? , " +
					"minimum = ? , " +
					"quota_in_period = ? ,"+
					"days_to_rel_start = ? " +

					"WHERE id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setBoolean(3, active);
			ps.setBoolean(4, assignable);
			ps.setBoolean(5, absolute);
			ps.setInt(6, daysInPeriod);
			ps.setInt(7, numberOfPeriods);
			ps.setInt(8, maximum);
			ps.setInt(9, minimum);
			ps.setInt(10, quotaInPeriod);
			ps.setInt(11, daysToRelStart);
			ps.setInt(12, id);

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + e.getMessage());
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] modifyPolicy out!");
	}

	public void deletePolicy(int id) {

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] deletePolicy inside!");
		try {

			String sql = "DELETE FROM policy WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Error(e.getMessage());
		}
		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] deletePolicy out!");
	}

	public List<Policy> getPolicies() {

		List<Policy> policiesArr = new ArrayList<Policy>();

		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getPolicies Inside!");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM policy");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String type = rs.getString("policy_type");
				boolean absolute = rs.getBoolean("absolute");
				Timestamp startDate = rs.getTimestamp("start_date");
				int daysInPeriod = rs.getInt("days_in_period");
				int numberOfPeriods = rs.getInt("number_of_periods");
				int minimum = rs.getInt("minimum");
				int maximum = rs.getInt("maximum");
				int quotaInPeriod = rs.getInt("quota_in_period");
				boolean active = rs.getBoolean("active");
				boolean assignable = rs.getBoolean("assignable");
				int daysToRelStart = rs.getInt("days_to_rel_start");

				Policy policy = new Policy();
				policy.setId(id);
				policy.setName(name);
				policy.setDescription(description);
				policy.setPolicyType(type);
				policy.setAbsolute(absolute);
				policy.setStartDate(startDate);
				policy.setDaysInPeriod(daysInPeriod);
				policy.setDaysToRelStart(daysToRelStart);
				policy.setNumberOfPeriods(numberOfPeriods);
				policy.setMaximum(maximum);
				policy.setMinimum(minimum);
				policy.setQuotaInPeriod(quotaInPeriod);
				policy.setActive(active);
				policy.setAssignable(assignable);


				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB]"+policy.toString());
				policiesArr.add(policy);

			}
			ps.close();

		} catch (SQLException e) {
			DebugTools.println(DEBUG_LEVEL,"[QuotaSystem - DB] SQL Exception " + e.getMessage());
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getPolicies out!");

		return policiesArr;
	}

	public List<Policy> getAssignablePolicies() {

		List<Policy> policiesArr = new ArrayList<Policy>();

		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getAssignablePolicies Inside!");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM policy WHERE assignable = ?");
			ps.setBoolean(1, true);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String type = rs.getString("policy_type");
				boolean absolute = rs.getBoolean("absolute");
				Timestamp startDate = rs.getTimestamp("start_date");
				int daysInPeriod = rs.getInt("days_in_period");
				int numberOfPeriods = rs.getInt("number_of_periods");
				int minimum = rs.getInt("minimum");
				int maximum = rs.getInt("maximum");
				int quotaInPeriod = rs.getInt("quota_in_period");
				boolean active = rs.getBoolean("active");

				Policy policy = new Policy();
				policy.setId(id);
				policy.setName(name);
				policy.setDescription(description);
				policy.setPolicyType(type);
				policy.setAbsolute(absolute);
				policy.setStartDate(startDate);
				policy.setDaysInPeriod(daysInPeriod);
				policy.setNumberOfPeriods(numberOfPeriods);
				policy.setMaximum(maximum);
				policy.setMinimum(minimum);
				policy.setQuotaInPeriod(quotaInPeriod);
				policy.setActive(active);
				policy.setAssignable(true);

				DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] " + policy.toString());

				policiesArr.add(policy);

			}
			ps.close();

		} catch (SQLException e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] SQL Exception " + e.getMessage());
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getAssignablePolicies out!");

		return policiesArr;
	}

	public Policy getPolicyById(int id) {

		Policy policy = null;

		try {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getPolicyById Inside!");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM policy WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String name = rs.getString("name");
				String description = rs.getString("description");
				String type = rs.getString("policy_type");
				boolean absolute = rs.getBoolean("absolute");
				Timestamp startDate = rs.getTimestamp("start_date");
				int daysInPeriod = rs.getInt("days_in_period");
				int daysToRelStart = rs.getInt("days_to_rel_start");
				int numberOfPeriods = rs.getInt("number_of_periods");
				int minimum = rs.getInt("minimum");
				int maximum = rs.getInt("maximum");
				int quotaInPeriod = rs.getInt("quota_in_period");
				boolean active = rs.getBoolean("active");
				boolean assignable = rs.getBoolean("assignable");

				policy = new Policy();
				policy.setId(id);
				policy.setName(name);
				policy.setDescription(description);
				policy.setPolicyType(type);
				policy.setAbsolute(absolute);
				policy.setStartDate(startDate);
				policy.setDaysInPeriod(daysInPeriod);
				policy.setDaysToRelStart(daysToRelStart);
				policy.setNumberOfPeriods(numberOfPeriods);
				policy.setMaximum(maximum);
				policy.setMinimum(minimum);
				policy.setQuotaInPeriod(quotaInPeriod);
				policy.setActive(active);
				policy.setAssignable(assignable);

			}
			ps.close();

		} catch (SQLException e) {
			DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] SQL Exception " + e.getMessage());
			e.printStackTrace();
			throw new Error(e.getMessage());
		}

		DebugTools.println(DEBUG_LEVEL, "[QuotaSystem - DB] getPolicyById out!");

		return policy;
	}


}




