<html>
<body>
	The student from ${param.country} is confirmed: 
	</br></br>
	<%= request.getParameter("firstName") %> <%= request.getParameter("lastName") %>
	</br></br>
	Programming Language selected: ${param.favoriteLanguage}
	</br></br>
	
	Food Preference: 
	<ul>
		<% String[] langs = request.getParameterValues("favoriteFood");
		   if (langs != null) {
			  for (String temp: langs) {
				  out.println("<li>" + temp + "</li>");
			  }
		   }
		   else {
			   out.println("No preference selected");
		   }
		 %>
	</ul>

</body>
</html>