package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CourseRegisterAccess {

	public Course saveRegisterCourse(String register_name, String register_courses, String register_date,
			String register_session, String register_email,String register_contact) {
		
		// TODO Auto-generated method stub
		Course reg_course=new Course();
		
		try {
			// step2: Register Driver
			Class.forName("com.mysql.jdbc.Driver");

			// Step 3: Create Connection
			String url = "jdbc:mysql://localhost/trainingdb";
			Connection con = DriverManager.getConnection(url, "root", "37353**ayepaing");

			System.out.println("Connenction " + con);

			// step4: Create a Statement
			Statement stmt = con.createStatement();

			// Insert to the database (Used executeUpdate for insert/delete and update)
			int result = stmt.executeUpdate(
					"insert into register (name, courses, trainingdate, session, email, contact) values ('"
							+  register_name + "','" + register_courses + "','"
							+ register_date + "','" + register_session+"','" +register_email+"','" +register_contact+ "');");
			System.out.println("Insert Result is " + result);

			

				// Put the data to access from controller/JSP
				
				reg_course.setName(register_name);
				reg_course.setCourses(register_courses);
				reg_course.setTrainingdate(register_date);
				reg_course.setSession(register_session);
				reg_course.setEmail(register_email);
				reg_course.setContact(register_contact);
				

			// step 7: Close the statement and connection
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return reg_course;
	}
}
