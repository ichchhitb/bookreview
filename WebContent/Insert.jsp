<%@page import="entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
#asterisk {
	color: red;
}
</style>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	font-family: cursive;
}
</style>
</head>
<body background="img/background.jpg">

	<%
		if (session.getAttribute("user") == null)
			response.sendRedirect("index.jsp");
		else {
				User admin=(User)session.getAttribute("user");
	%>
	
	
	
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="Welcome.jsp"><img
				src="img/bookicon.png" class="img-rounded" alt="Cinque Terre"
				width="25" height="25"></a> <a class="navbar-brand">Hello <%=admin.getLoginId()%></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="Welcome.jsp">HOME</a></li>
				<li><a href="Insert.jsp">INSERT</a></li>
				<li><a href="Logout">SIGN OUT</a></li>
			</ul>
			
			</div>

		</div>
	</div>
	</nav>
	
	<h1>&nbsp;</h1>
	<h1>&nbsp;</h1>
	<div class="container container-fluid">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="jumbotron text-center">
				<img src="img/addicon.png" class="img-rounded" alt="Cinque Terre"
					width="120" height="120">

				<form action="Insert" method="post">
					<br />
					<div class="input-group">
						<input type="text" class="form-control input-lg"
							name="ISBN_insert" placeholder="ISBN" required /> <span
							class="input-group-addon"><i
							class="glyphicon glyphicon-barcode"></i></span>
					</div>
					<br />
					<div class="input-group">
						<input class="form-control input-lg" type="text" name="bookName"
							placeholder="Book Name" required> <span
							class="input-group-addon"><i
							class="glyphicon glyphicon-book"></i></span>
					</div>
					<br />
					<div class="input-group">
						<input type="text" class="form-control input-lg" name="author"
							placeholder="Book Author" required> <span
							class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span>
					</div>
					<br />
					<div class="input-group">
						<td><select class="form-control input-lg" name="bookTypeName">
								<option value="biography">Biography</option>
								<option value="fiction">Fiction</option>
								<option value="horror">Horror</option>
						</select> <span class="input-group-addon"><i
								class="glyphicon glyphicon-list"></i></span>
					</div>
					<br />
					<div class="input-group">
						<input type="text" class="form-control input-lg" name="summary"
							placeholder="Book Summary" required> <span
							class="input-group-addon"><i
							class="glyphicon glyphicon-pencil"></i></span>
					</div>
					<br />
					<div class="input-group">
						<input type="text" class="form-control input-lg" name="image"
							placeholder="Image URL" required> <span
							class="input-group-addon"><i
							class="glyphicon glyphicon-link"></i></span>
					</div>
					<br />
						<input type="submit" class="btn btn-lg btn-success btn-block"
							style="font-size: 200%;" value="Insert" />

				</form>
				<%
					if (session.getAttribute("insert message") != null) {
				%>
				<script>
						alert('<%=session.getAttribute("insert message")%>');
				</script>
				<%
					session.setAttribute("insert message", null);
						}
				%>
			</div>
		</div>
	</div>
	<%
		}
	%>
</body>
</html>