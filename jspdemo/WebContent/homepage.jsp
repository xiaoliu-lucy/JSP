
<html>
	<body>
	<jsp:include page="myHeader.html" />
	</br>
	<h3 align="center">Student Login</h3>
	</br></br>	
	<form action="student-response.jsp" >
	  First name: <input type="text" name="firstName" />
	  </br></br>
	  Last name: <input type="text" name="lastName" />
	  </br></br>
	  Country: <select name="country"> 
	  		   <option>China</option>
	  		   <option>Japan</option>
	  		   <option>U.S</option>
	  		   <option>Russia</option>
	  		   </select> 
	  </br></br>
	  Programming Language: <input type="radio" name="favoriteLanguage" value="Java" /> Java
	                        <input type="radio" name="favoriteLanguage" value="Python" /> Python
	                        <input type="radio" name="favoriteLanguage" value="C#" /> C#
	                        <input type="radio" name="favoriteLanguage" value="C++" /> C++
	  </br></br>
	  Programming Language: <input type="checkbox" name="favoriteFood" value="Chicken" /> Chicken
	                        <input type="checkbox" name="favoriteFood" value="Beef" /> Beef
	                        <input type="checkbox" name="favoriteFood" value="Vegetable" /> Vegetable
	                        <input type="checkbox" name="favoriteFood" value="Fish" /> Fish
	  </br></br>
	  <input type="submit" value="Submit" />
	  
	</form> 
	<jsp:include page="myFooter.jsp" />
	</body>
</html>