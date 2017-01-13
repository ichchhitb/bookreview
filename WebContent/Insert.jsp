<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#d9d9d9">

	<%
		if (session.getAttribute("user") == null)
			response.sendRedirect("index.jsp");
		else {
	%>
	<a href="Logout" style="float: right;">Sign Out</a>
	<center>
		<form action="Insert" method="post">
			<table border="0">
				<tr>
					<td>ISBN:</td>
					<td><input type="text" name="ISBN_insert" placeholder="ISBN"
						required></td>
				</tr>
				<tr>
					<td>Book Name:</td>
					<td><input type="text" name="bookName" placeholder="Book Name"
						required></td>
				</tr>
				<tr>
					<td>Author:</td>
					<td><input type="text" name="author" placeholder="Book Author"
						required></td>
				</tr>
				<tr>
					<td>Book Type:</td>
					<td><select name="bookTypeName">
							<option value="biography">Biography</option>
							<option value="fiction">Fiction</option>
							<option value="horror">Horror</option>
					</select></td>
				</tr>
				<tr>
					<td>Summary:</td>
					<td><input type="text" name="summary"
						placeholder="Book Summary" required></td>
				</tr>
				<tr>
					<td>Image URL:</td>
					<td><input type="text" name="image" placeholder="Image URL"
						required></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" name="Insert"
						value="Insert"></input></td>
				</tr>
			</table>
		</form>
	</center>
	<%
		}
	%>
</body>
</html>