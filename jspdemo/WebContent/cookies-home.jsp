<html>
<body>
<h3>Training Portal</h3>
<!-- Read the favorite language cookie -->
<%
	// The default
	String favLang = "Java";
	// Get cookie from browser request
	Cookie[] theCookies = request.getCookies();
	out.println("getting cookies");
	//Find favorite language cookie
	if (theCookies != null) {
		for (Cookie tmpCookie : theCookies) {
			if ("myApp.favoriteLanguage".equals(tmpCookie.getName())) {
				favLang = tmpCookie.getValue();
				out.println(favLang);
				break;
			}
		}
	}
%>
<!-- Show books for this language -->
<h4>Books for <%= favLang %> </h4>
<ul>
	<li>blah blah blah</li>
	<li>blah blah blah</li>
	<li>blah blah blah</li>
	<li>blah blah blah</li>
</ul>
<br/><br/>
<a href = "cookies-personalize.html">Set new language preference</a>
</body>
</html>