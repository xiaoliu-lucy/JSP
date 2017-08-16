package webStudentTracker.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	private DataSource dataSource;
	
	public StudentDbUtil (DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Student> getStudents() throws Exception {
		
		List<Student> students = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// Get Connection
			myConn = dataSource.getConnection();
			
			// Create Sql statement
			myStmt = myConn.createStatement();
			String sql = "Select * from student order by last_name";
			
			// Execute query
			myRs = myStmt.executeQuery(sql);
			
			// Process result set
			while(myRs.next()) {
				
				// Retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				// Create new student object 
				Student tmpStudent = new Student(id, firstName, lastName, email);
				
				// Add into Array List
				students.add(tmpStudent);
			}
			
			return students;
			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		// TODO Auto-generated method stub
		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addStudent(Student theStudent) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		
		try {
			// Get Connection
			myConn = dataSource.getConnection();
			
			// Create Sql statement
			
			String sql = "insert into student " + "(first_name,last_name,email) "
						+ "values (? , ? , ?)";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmail());
			// Execute query
			myStmt.execute();
			
			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt,null);
		}
		
	}

	public Student getStudents(String theId) throws Exception{
		Student theStudent = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int studentId;
		try {
			// Convert student id to int
			studentId = Integer.parseInt(theId);
			// Get Connection
			myConn = dataSource.getConnection();
			
			// Create Sql statement
			String sql = "Select * from student where id = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, theId);
			// Execute query
			myRs = myStmt.executeQuery();
			
			// Process result set
			if (myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				
				theStudent = new Student(studentId, firstName, lastName, email);
			}
			else {
				throw new Exception("Could not find student id: " + studentId);
			}	
			return theStudent;
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
	}

	public void update(Student theStudent) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// Get Connection
			myConn = dataSource.getConnection();
			
			// Create Sql statement
			
			String sql = "update student " + "set first_name=?, last_name=?, email=?  "
						+ "where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getEmail());
			myStmt.setInt(4, theStudent.getId());
			// Execute query
			myStmt.execute();
						
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt,null);
		}
		
	}

	public void deleteStudent(int theId) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// Get Connection
			myConn = dataSource.getConnection();
			
			// Create Sql statement
			
			String sql = "delete from student where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, theId);
			// Execute query
			myStmt.execute();
						
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt,null);
		}
	}

}
