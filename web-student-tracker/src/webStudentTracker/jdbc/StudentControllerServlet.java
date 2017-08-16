package webStudentTracker.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentDbUtil studentDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	

	@Override
	public void init() throws ServletException {
		super.init();
		
		// Create student db util and pass in the conn pool / datasource
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// list students in MVC fashion
		try {
			// Read the command parameter
			String theCommand = request.getParameter("command");
			
			// route to the appropriate method
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			switch (theCommand) {
			
			case "LIST":
				listStudents(request,response);
				break;
			
			case "ADD":
				addStudent(request,response);
				break;
			case "LOAD":
				loadStudent(request,response);
				break;
			case "UPDATE":
				updateStudent(request,response);
				break;
			case "DELETE":
				deleteStudent(request,response);
				break;
			default:
				listStudents(request,response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}



	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get student info from data
		int theId = Integer.parseInt(request.getParameter("studentId"));
		// find student in database and delete
		studentDbUtil.deleteStudent(theId);
		// list student
		listStudents(request,response);
		
	}



	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get student info from data
		String theId = request.getParameter("studentId");
		int id = Integer.parseInt(theId);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		// create new student object
		Student theStudent = new Student(id, firstName, lastName, email);
		// perform update on database
		studentDbUtil.update(theStudent);
		//send them back to list student page
		listStudents(request,response);
		
	}



	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get student info from data
		String theId = request.getParameter("studentId");
		// get student from database
		Student theStudent = studentDbUtil.getStudents(theId);
		// place student in the request attribute
		request.setAttribute("theStudent", theStudent);
		// send to jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-student.jsp");
		dispatcher.forward(request, response);
	}



	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read student info
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		// create new student object
		Student theStudent = new Student(firstName, lastName, email);
		// add student to database
		studentDbUtil.addStudent(theStudent);
		// send back to main page
		listStudents(request,response);
	}



	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db Util
		List<Student> students = studentDbUtil.getStudents();
		
		// add students to request
		request.setAttribute("Student_List", students);
		
		// send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-student.jsp");
		dispatcher.forward(request, response);
	}



}
