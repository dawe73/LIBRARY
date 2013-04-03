<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="./resources/styles/style.css" media="screen" />
<title>Library</title>
</head>

<body>
	<!-- begin #container -->
	<div id="container">
		<!-- begin #header -->
		<div id="header">
			<div class="menu">
				<ul>
			  		<li><a href="category">Category</a></li>
					<li><a href="books">Books</a></li>
					<li><a href="authors">Authors</a></li>
					<li><a href="reservation">Reservations</a></li>
					<li><a href="borrowing">Borrowing</a></li>
					<li><a href="<c:url value="j_spring_security_logout" />">Logout</a></li>
				</ul>
			</div>
		</div>
		<!-- end #header -->