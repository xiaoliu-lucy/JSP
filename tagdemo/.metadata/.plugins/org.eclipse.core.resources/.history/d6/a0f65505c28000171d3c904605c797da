<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*,tagdemo.jsp.Student" %>

<% 
	// Sample data
	List<Student> data = new ArrayList<>();
	data.add(new Student("John","Doe", false));
	data.add(new Student("Amy","Li", false));
	data.add(new Student("Laura","Wan", false));
	data.add(new Student("Jin","Zheng", true));
	data.add(new Student("Mipha","Dora", false));
	data.add(new Student("Link","Zelda", true));
	pageContext.setAttribute("studentList", data);
	
%>

<html>
<body>
	<table border="1"> 
	<tr>
		<th>Frist Name</th>
		<th>Last Name</th>
		<th>Gold Customer</th>
	</tr>
	<c:forEach var="tempStudent" items="${studentList}">
		<tr>
			<td>${tempStudent.firstName}</td>
			<td>${tempStudent.lastName}</td>
			<td>
				<c:if test = "${tempStudent.goldCustomer}">Special</c:if>
				<c:if test = "${not tempStudent.goldCustomer}">Not Special</c:if>
			</td>
		</tr>		

	</c:forEach>
	</table>
</body>
</html>