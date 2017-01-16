<%@page import="entities.Book"%>
<%@page import="database.BookDAO"%>
<%@page import="database.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="entities.User , constants.BookReviewConstants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!Connection connection = ConnectionFactory.getConnection();%>
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
<style>
.featured {
	margin: 0 15px 0 15px;
}

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
			User admin = (User) session.getAttribute("user");
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
				<%
					if (BookReviewConstants.ADMIN.equals(admin.getRole().getRoleName())) {
				%>
				<li><a href="Insert.jsp">INSERT</a></li>
				<%
					}
				%>
				<li><a href="Logout">SIGN OUT</a></li>
			</ul>

		</div>

	</div>
	</nav>
	<h1>&nbsp;</h1>
	<h1>&nbsp;</h1>
	<center>
		<h1>
			<font color="white" style="font-family: cursive;">Welcome to
				Book Review System</font>
		</h1>
	</center>
	<h1>&nbsp;</h1>
	<div class="container-fluid text-center">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<div class="jumbotron">
				<div class="search-container" align="center">
					<div class="ui-widget">
						<form action="DisplayBook" method="get">
							<div class="col-md-11">
								<input type="text" id="search" name="search"
									class="search form-control input-lg"
									placeholder="Search for..." required>


							</div>
							<button type="submit" class="btn btn-secondary input-lg">
								<span><i class="glyphicon glyphicon-search"></i></span>
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-2"></div>

	</div>
	<center>
		<h2>
			<font color="white" style="font-family: cursive;"><b>Featured
					Books</b></font>
		</h2>
	</center>
	<div class="container-fluid text-center">
		<%
			BookDAO dao = new BookDAO(connection);
				for (Book featuredBook : dao.getFeaturedBooks()) {
		%>
		<a href="DisplayBook?search=<%=featuredBook.getBookName()%>"><img
			src="<%=featuredBook.getBookImage()%>" class="img-thumbnail featured"
			alt="Cinque Terre" height="200" width="200"> </a>
		<%
			}
				if (session.getAttribute("delete message") != null) {
		%>
		<script> alert('<%=session.getAttribute("delete message")%>');
		</script>
		<%
			session.setAttribute("delete message", null);
				}
				if (session.getAttribute("no book") != null) {
		%>
		<script> alert('<%=session.getAttribute("no book")%>');
		</script>
		<%
				session.setAttribute("no book", null);
		}
		%>
	</div>
	<%
		}
	%>
</body>
</html>