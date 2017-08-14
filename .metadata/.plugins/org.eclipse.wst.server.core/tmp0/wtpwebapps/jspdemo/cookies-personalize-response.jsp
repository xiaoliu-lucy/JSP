<html>

<%
//Step 1: read form data
String favLang = request.getParameter("favoriteLanguage");
//Step 2: Create cookie
Cookie theCookie = new Cookie("myApp.favoriteLanguage", favLang);
//Step 3: set the life span of cookie
theCookie.setMaxAge(60*60*24*365);
//Step 4: send cookie to browser
response.addCookie(theCookie);
%>
<body>
Your favorite programming language is set to ${param.favoriteLanguage}
<br/><br/>
<a href="cookies-home.jsp">Return to homepage</a>
</body>	
</html>