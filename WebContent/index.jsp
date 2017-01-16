<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body background="img/background.jpg">
	<%
		if (session.getAttribute("user") != null)
			response.sendRedirect("Welcome.jsp");
	%>
	<h1>&nbsp;</h1>
	<center>
		<h1>
			<font color="white" style="font-family: cursive;">Book Review
				System</font>
		</h1>
	</center>
	<h1>&nbsp;</h1>
	<div class="container container-fluid">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="jumbotron text-center">
				<img src="img/bookicon.png" class="img-rounded" alt="Cinque Terre"
					width="120" height="120">

				<form action="LoginPage" name="form" method="post"
					onsubmit="return formValidation();">
					<br />
					<div class="input-group">
						<input id="loginid" type="text" class="form-control input-lg"
							name="loginid" placeholder="User Name" required/> <span
							class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span>
					</div>
					<br />
					<div class="input-group">
						<input id="password" type="password" class="form-control input-lg"
							name="password" placeholder="Password" required/> <span
							class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span>
					</div>
					<br /> <span style="float: right;">Not Registered?&nbsp;<a
						href="RegistrationForm.jsp">Create an account</a></span> <br /> <br />
					
						<input type="submit" class="btn btn-lg btn-success btn-block"
							style="font-size: 200%;" value="Login" />
					

				</form>
			</div>
		</div>
	</div>
</body>
</html>