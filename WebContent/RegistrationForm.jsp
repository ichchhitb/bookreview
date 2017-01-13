<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	border: 5px solid grey;
	margin: 0px
}
</style>
<body>
	<h1>Registration Form</h1>
	<div class="ex">
		<form action="registration" name="form" method="post"
			onsubmit="return formValidation();">
			<table style="with: 50%">
				<tr>
					<td>User Name</td>
					<td><input type="text" name="loginid" required="required" /></td>
					<td><p id="validateid"></p></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required="required" /></td>
					<td><p id="validatepass"></p></td>
				</tr>
			</table>
			<input type="submit" value="register" />
		</form>
	</div>
	<script type="text/javascript" src="js/validateRegistration.js"></script>

</body>
</html>