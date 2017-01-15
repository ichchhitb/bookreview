<%@page import="constants.BookReviewConstants"%>
<%@page import="entities.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.ReviewDAO"%>
<%@page import="database.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@page import="entities.User"%>
<%@page import="entities.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/updateRating.js"></script>
<%!Connection connection = ConnectionFactory.getConnection();%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<style>
#delete:hover {
	cursor: pointer;
}

.rated {
	overflow: hidden;
	display: inline-block;
}

.rating {
	overflow: hidden;
	display: inline-block;
}

.rating-input {
	float: right;
	width: 16px;
	height: 16px;
	padding: 0;
	margin: 0 0 0 -16px;
	opacity: 0;
}

.rating-star:hover {
	background-position: 0 0;
}

.rating-star {
	position: relative;
	float: right;
	display: block;
	width: 16px;
	height: 16px;
	background: url('img/star.png') 0 -16px;
}

.rated-star {
	position: relative;
	float: right;
	display: block;
	width: 16px;
	height: 16px;
	background: url('img/star.png') 0 0;
}

.unrated-star {
	position: relative;
	float: right;
	display: block;
	width: 16px;
	height: 16px;
	background: url('img/star.png') 0 -16px;
}

.rating-star:hover, .rating-star:hover ~ .rating-star {
	background-position: 0 0;
}

.rating-star:hover, .rating-star:hover ~ .rating-star, .rating-input:checked 
	 ~ .rating-star {
	background-position: 0 0;
}

.rating:hover .rating-star:hover, .rating:hover .rating-star:hover ~
	.rating-star, .rating-input:checked ~ .rating-star {
	background-position: 0 0;
}

.rating-star, .rating:hover .rating-star {
	position: relative;
	float: right;
	display: block;
	width: 16px;
	height: 16px;
	background: url('img/star.png') 0 -16px;
}
body{
	background-color: #FF9633;
	color: white;
	font-family: cursive;
}
.panel, input, textarea{
	color:black;
}
</style>



<title>Insert title here</title>
</head>
<body>

	<%
		if (session.getAttribute("user") == null)
			response.sendRedirect("index.jsp");
		else {
			Book book = (Book) session.getAttribute("book");
			User user = (User) session.getAttribute("user");
			ReviewDAO dao = new ReviewDAO(connection);
			ArrayList<Review> list = dao.getAllReviewsForBook(book);
	%>
	<a href="Logout" style="float: right;">Sign Out</a>
	<h3>&nbsp;</h3>
	<div class="container container-fluid">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="jumbotron text-center">
				<%
					if (BookReviewConstants.ADMIN.equals(user.getRole().getRoleName())) {
				%>
				<a href="DeleteBook?isbn=<%=book.getIsbn()%>"><img id="delete"
					alt="delete" src="img/delete.png" style="float: right;" width="25"
					height="25"></a>
				<%
					}
				%>
				<img src="<%=book.getBookImage()%>" class="img-thumbnail"
					alt="Cinque Terre" width="250" height="400">
			</div>
			<div>
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#sectionA">Overview</a></li>
					<li><a data-toggle="tab" href="#sectionB">Review</a></li>
					<li><a data-toggle="tab" href="#sectionC">Details</a></li>
				</ul>

				<div class="tab-content">
					<div id="sectionA" class="tab-pane fade in active">
						<h3><b>Summary</b></h3>
						<p><%=book.getSummary()%></p>
					</div>
					<div id="sectionB" class="tab-pane fade">
						<h3><b>Reviews</b></h3>
						<div>
							<input type="hidden" id="avgrating" value="<%=dao.getAverageRatingForBook(book) %>" /> <span
								class="rated"> <input type="radio" class="rating-input"
								id="rated-input-1-5"> <label for="rated-input-1-5" id="ratedstar-5"
								class="unrated-star"></label> <input type="radio"
								class="rating-input" id="rated-input-1-4"> <label
								for="rated-input-1-4" class="unrated-star" id="ratedstar-4"></label> <input
								type="radio" class="rating-input" id="rated-input-1-3">
								<label for="rated-input-1-3" class="unrated-star" id="ratedstar-3"></label> <input
								type="radio" class="rating-input" id="rated-input-1-2">
								<label for="rated-input-1-2" class="unrated-star" id="ratedstar-2"></label> <input
								type="radio" class="rating-input" id="rated-input-1-1">
								<label for="rated-input-1-1" class="unrated-star" id="ratedstar-1"></label>
							</span>



						</div>



						<div id="c1" style="overflow: auto; max-height: 300px;">
							<div>
								<%
									for (Review review : list) {
								%>
								<h4><%=review.getUser().getLoginId()%></h4>
								<div class="panel panel-default">
									<div class="panel-heading">
										<b><i><%=review.getReviewTitle()%></i></b>
									</div>
									<div class="panel-body"><%=review.getComments()%></div>
								</div>
								<%
									}
								%>
							</div>
						</div>



						<div>
							<form action="AddReview" method="get">
								<input type="hidden" value="1000" name="isbn" />
								<h3><b>Give your review</b></h3>
								<span class="rating"> <input type="radio"
									class="rating-input" id="rating-input-1-5" value="5"
									name="rating"> <label for="rating-input-1-5"
									class="rating-star"></label> <input type="radio"
									class="rating-input" id="rating-input-1-4" value="4"
									name="rating"> <label for="rating-input-1-4"
									class="rating-star"></label> <input type="radio"
									class="rating-input" id="rating-input-1-3" value="3"
									name="rating"> <label for="rating-input-1-3"
									class="rating-star"></label> <input type="radio"
									class="rating-input" id="rating-input-1-2" value="2"
									name="rating"> <label for="rating-input-1-2"
									class="rating-star"></label> <input type="radio"
									class="rating-input" id="rating-input-1-1" value="1"
									name="rating"> <label for="rating-input-1-1"
									class="rating-star"></label>
								</span>
								<h5>Title</h5>
								<input type="text" name="reviewtitle" />
								<h5>Comments</h5>
								<textarea rows="4" cols="50" name="comments"></textarea>
								<br> <br> <input type="submit" value="Add Review" />
							</form>
						</div>
					</div>
					<div id="sectionC" class="tab-pane fade">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h5>
									<b>ISBN</b>
								</h5>
							</div>
							<div class="panel-body"><%=book.getIsbn()%></div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h5>
									<b>Book Name</b>
								</h5>
							</div>
							<div class="panel-body"><%=book.getBookName()%></div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h5>
									<b>Author</b>
								</h5>
							</div>
							<div class="panel-body"><%=book.getBookAuthor()%></div>
						</div>
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
