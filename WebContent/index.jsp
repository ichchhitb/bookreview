<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body bgcolor="#d9d9d9">

<a style="float: right;" href="register.jsp">Sign Up</a>
<h1>&nbsp;</h1>
<center>
	<form action="LoginPage" name="form" method="post" onsubmit="return formValidation();">
	<table border="0">
		<tr>
			<td>Username:</td>
			<td><input type="text" name="loginid" placeholder="User Name" required></td>
			<td><font color="red" ><p id="validateid"></p></font></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" placeholder="Password" required></td>
			<td><font color="red" id="validatepass"></font></td>
		</tr>
		<tr>
		<td colspan="3"><input  type="submit" value="Login" ></td></tr>
	</table>
	</form>
	<script type="text/javascript" src="validateRegistration.js"></script>
</center>
</body>
</html>