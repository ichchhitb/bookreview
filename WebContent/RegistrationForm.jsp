<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
<body background="img/background.jpg">
	<h1>&nbsp;</h1>
	<center>
		<h1>
			<font color="white" style="font-family: cursive;">Register
				Here</font>
		</h1>
	</center>
	<div class="container container-fluid">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="jumbotron text-center">
				<img src="img/register.png" class="img-rounded" alt="Cinque Terre"
					width="120" height="120">

				<form action="registration" name="form" method="post"
					onsubmit="return formValidation();">
					<br />
					<div class="input-group">
						<input id="loginid" type="text" class="form-control input-lg"
							name="loginid" placeholder="User Name" required /> <span
							class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span>
					</div>
					<br />
					<div class="input-group">
						<input id="password" type="password" class="form-control input-lg"
							name="password" placeholder="Password" required /> <span
							class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span>
					</div>
					<br /> <input type="submit"
						class="btn btn-success btn-lg btn-block" style="font-size: 200%;"
						value="Register" />

				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/validateRegistration.js"></script>

</body>
</html>