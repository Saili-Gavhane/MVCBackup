<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br><br>
	     <form action="http://localhost:7070/UserMVC/AddUserController" method="post">
            Enter id:<input type="number" name="id">
            <br><br>
             Enter Name:<input type="text" name="name">
            <br><br>
              Enter email:<input type="text" name="email">
            <br><br>
            Enter password:<input type="password" name="password">
            <br><br>
           
            <input type="submit" name="button" value="Add">
            
            </form>
       
</body>
</html>