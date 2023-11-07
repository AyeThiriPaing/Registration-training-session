package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Course;
import model.CoursesAccess;


public class TrainingSessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
				// Create the CoursesAccess class Object
				CoursesAccess coursesAccess = new CoursesAccess(); 
				
				//Call the Method to get a list of course
				List<String> coursesfromexcel=coursesAccess.readCourses();
				
				System.out.println("Courses from excel is "+coursesfromexcel.toString());
				
				req.setAttribute("mycourses", coursesfromexcel);
				

		// Dispatch the JSP 
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/trainingForm.jsp"); 
		rd.forward(req, resp); 
		
	}
}
