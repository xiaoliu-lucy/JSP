<%@ page import="jspdemo.jsp.LowerCase" %>
<html>
	<body>
	<h3>Call Java Class from JSP</h3>
	To lower case: <%= LowerCase.makeItLower("FUN FUN FUN") %>
	</body>
</html>