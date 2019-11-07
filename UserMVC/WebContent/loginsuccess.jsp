<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.lti.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
User u = (User)session.getAttribute("user");
%>
Name: <%= u.getName() %> <br><br>
Id: <%= u.getId() %> <br><br>
Email: <%= u.getEmail() %> <br><br>

<hr>
<form action="http://localhost:7070/UserMVC/FetchController" method="post">
Enter id: <input type="number" name="id"> 
<input type="submit" value="Get details">
</form>


</body>
</html>