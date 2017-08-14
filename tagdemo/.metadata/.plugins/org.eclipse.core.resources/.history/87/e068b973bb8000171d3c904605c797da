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
	
	<c:forEach var="tempStudent" items="${studentList}">
		${tempStudent.firstName} ${tempStudent.lastName}, ${tempStudent.goldCustomer}
		<br/>
	</c:forEach>

</body>
</html>