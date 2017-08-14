<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
Length of the list: ${fn:length(studentList)}
<br/>
<c:set var="data" value = "jiaming" />
Uppercase of string <b>${data}</b>: ${fn:toUpperCase(data)} 
<br/>
Does the string start with <b>j</b>: ${fn:startsWith(data,"j")}
<br/>
<c:set var="cities" value = "Beijing, Tianjin, Shanghai" />
<c:set var="citiesArray" value = "${fn:split(cities,',')}" />
<c:forEach var="city" items="${citiesArray}">${city},</c:forEach>
<br/>
<c:set var="rejoin" value="${fn:join(citiesArray,'*')}" />
${rejoin}
</body>
</html>