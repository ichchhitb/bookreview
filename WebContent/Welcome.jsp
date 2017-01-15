<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="entities.User , constants.BookReviewConstants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<head>
<meta charset="ISO-8859-1">
<title>search</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="js/autoCompleter.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
</head>

<body background="img/background.jpg">
	<%
		if (session.getAttribute("user") == null)
			response.sendRedirect("index.jsp");
		else {
	%>
	<a href="Logout" style="float: right;">Sign Out</a>
	<h1>&nbsp;</h1>
	<center>
		<h1>
			<font color="white" style="font-family: cursive;">Welcome to
				Book Review System</font>
		</h1>
	</center>
	<h1>&nbsp;</h1>
	<h1>&nbsp;</h1>
	<div class="container-fluid text-center">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="jumbotron">
				<div class="search-container" align="center">
					<div class="ui-widget">
						<!-- <span id = "errorMessage"> not found</span> -->
						<form action="DisplayBook" method="get">
							<!-- <input type="text" id="search" name="search" class="search" /> <input
								type="submit" value="get details" /> -->
							<div class="row">
								<div class="input-group">
									<input type="text" id="search" name="search"
										class="search form-control" placeholder="Search for...">
									<span class="input-group-btn">
										<input class="btn btn-secondary" value="Go!" type="submit"/>
									</span>
								</div>
							</div>

							<%
								User admin = (User) session.getAttribute("user");
									if (BookReviewConstants.ADMIN.equals(admin.getRole().getRoleName())) {
							%>

							<input type="submit" value="Insert Book" formaction="Insert.jsp" />

							<%
								}
							%>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
		}
	%>
</body>
</html>