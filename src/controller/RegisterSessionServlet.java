package controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import model.CourseRegisterAccess;
import model.CoursesAccess;
import model.SendEmail;

public class RegisterSessionServlet extends HttpServlet {

	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String register_name = req.getParameter("name");
		String register_courses = req.getParameter("courses");
		String register_date = req.getParameter("trainingdate");
		String d[]=new String[3];
		d[0]=req.getParameter("date1");
		d[1]=req.getParameter("date2");
		d[2]=req.getParameter("date3");
		
		String register_session = req.getParameter("session");
		String s[]=new String[1];
		s[0]=req.getParameter("session1");
		
		String register_email = req.getParameter("email");
		String register_contact = req.getParameter("contact");
		

		System.out.print(" The Register Name is " + register_name);
		System.out.print(" The Register Courses is " + register_courses);
		System.out.print(" The Register date is " + register_date);
		System.out.print(" The Register session is " + register_session);
		System.out.print(" The Register email is " + register_email);
		System.out.print(" The Register Contact is " + register_contact);
		

		CourseRegisterAccess courseReg = new CourseRegisterAccess();

		// Call the Method to save the register course
		Course reg_course = courseReg.saveRegisterCourse(register_name,register_courses,register_date,register_session,register_email,
				register_contact);

		
		// Send Email To User
		SendEmail mm=new SendEmail();
		String title="Greeting from Training Department";
		String message="Thank you for interesting to attend the session:"
				+ "Your Register Course is  "+register_courses;
	
	    
	    mm.send("atp742002atp7a5@gmail.com","ayethiripaing742002",register_email,title,message);  
		
		req.setAttribute("register_course", reg_course);

		// Dispatch the JSP
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/success.jsp");
		rd.forward(req, resp);
	}
}
