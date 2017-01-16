<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>

</head>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>

<body>
	<!-- 	<h1>Registration Form</h1>
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
	</div> -->



	<div class="container text-center">
		<h3>&nbsp;</h3>
		<h3>&nbsp;</h3>
		<h2>
			<font color="white">Registration Page</font>
		</h2>
		<h3>&nbsp;</h3>
		<h3>&nbsp;</h3>
		<div class="col-md-3"></div>
		<div class=" col-md-6 jumbotron">
			<div>
				<form class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-2" for="email">Username:</label>
						<div class="col-xs-4">
							<input type="text" name="loginid" class="form-control" id="email">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">Password:</label>
						<div class="col-xs-4">
							<input type="password" name="password" class="form-control" id="pwd">
						</div>
					</div>


					<div class="control-label col-sm-2">
						<button type="submit" value="register" class="btn btn-primary">Submit</button>
					</div>


				</form>
			</div>
		</div>
	</div>
</body>
</html>
