<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<% String message=request.getParameter("message"); %>
<center>
<form action="http://localhost:7070/UserMVC/LoginController" method="post">
				<% if(message==null)
				{
					
				}
				else
				{
				%>
				<b>Invalid credentials</b>
				<%
				}%>
				
			<h1>Login here</h1>	
              Enter email:<input type="text" name="email">
            <br><br>
            Enter password:<input type="password" name="password">
            <br><br>
           
            <input type="submit" value="Login">
            </form>
          </center>  
            
</body>
</html>