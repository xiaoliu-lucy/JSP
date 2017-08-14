<html>
<body>
	<h2>JSP Expressions</h2>
	Converting a string to uppercase:
	<%=new String("hello world").toUpperCase()%>
	<br />
	<br /> 25 multiplied by 4 equals:
	<%=25 * 4%>
	<br />
	<br /> Is 75 less than 69?
	<%=75 < 69%>
	<br />
	<br />
	<h2>JSP Scriplets</h2>
	<%
		for (int i = 0; i < 5; i++) {
			out.println("<br/> I really love to code: " + i);
		}
	%>
	<h2>JSP Declarations</h2>
	<%!String makeItLower(String data) {
		return data.toLowerCase();
	}%>
	Lower case Hello World:
	<%=makeItLower("HELLO WORLD")%>
	
</body>
</html>