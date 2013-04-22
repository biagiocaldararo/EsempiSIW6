<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title> Login </title>
	</head>
	<body>
		<form action="login" method="post">
			<h2> Login </h2>
			<p>Username <input type="text" name="username"/>
			   Password  <input type="password" name="password"/></p>
			<p><font color="red">${errore}</font></p>
			<input type="submit" name="risp" value="Login"/>
			<input type="reset" value="Reset"/>
		</form>
	</body>
</html>