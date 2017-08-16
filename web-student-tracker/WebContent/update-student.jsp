<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<title>Update Student</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>
	<div id ="container">
		<h3>Update Student</h3>
		<form action="StudentControllerServlet" method="GET">
			
			<input type="hidden" name="command" value="UPDATE" />
			<input type="hidden" name="studentId" value="${theStudent.id}" />
			<table>
				<tbody>
					<tr>
						<td><lable>First Name:</lable></td>
						<td><input type="text" name="firstName" value="${theStudent.firstName}"/></td>
					</tr>
					<tr>
						<td><lable>Last Name:</lable></td>
						<td><input type="text" name="lastName" value="${theStudent.lastName}"/></td>
					</tr>
					<tr>
						<td><lable>Email:</lable></td>
						<td><input type="text" name="email" value="${theStudent.email}"/></td>
					</tr>
					<tr>
						<td><lable></lable></td>
						<td><input type="submit" value="Update" class="save" /></td>
					</tr>
				</tbody>
			</table>
		
		</form>
		<div style="clear: both;"></div>
		<p>
			<a href="StudentControllerServlet">Back to List</a>
		</p>
	</div>
	
</body>
</html>