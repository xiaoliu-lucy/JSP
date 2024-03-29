<%@ page import="java.util.*" %>
<html>
  <body>
  <!-- Step 1: create HTML form -->
  <form action="myTodo.jsp">
    Add new item: <input type = "text" name = "theItem" />
    <input type = "submit" value = "Submit" />
  </form>
  <br>
  <!-- Step 2: add new item to to do list -->
    <%
      // get the to do items from session
      List<String> items = (List<String>) session.getAttribute("myTodoList");
      // if the to do list doesn't exist, create a new one
      if (items == null) {
    	  items = new ArrayList<String>();
    	  session.setAttribute("myTodoList", items);
      }
      // see if there is form data to add
      String theItem = request.getParameter("theItem");
      if (theItem != null && !theItem.trim().equals("")) {
    	  items.add(theItem);
      }
    %>
  <!-- Stemp 3: display to do list -->
  <ol> <!-- order list (ol) -->
    <%
      for (String temp: items) {
    	  out.println("<li>" + temp + "</li>");
      }
    %>
  </ol>
  </body>
</html>