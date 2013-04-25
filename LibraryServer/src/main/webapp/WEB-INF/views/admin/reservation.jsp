<%@ page language="java" contentType="text/html; charset=UTF-8"
				    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="../resources/styles/styles.css" media="screen" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="top.jsp" />
<jsp:include page="topReservation.jsp" />


<div class="allContent">
<table>
	<tr>
		<th>Book</th>
		<th>From</th>
		<th>To</th>
		<th>Student</th>
		<th></th>
	</tr>
	<c:forEach items="${reservations}" var="r">
		<tr>
			<td><a href="book.info?id=${r.book.ID}">${r.book.title}</a></td>
			<td><fmt:formatDate var="date" pattern="dd.MM.yy" value="${r.dateFrom}"/>${date}</td>
			<td><fmt:formatDate var="date2" pattern="dd.MM.yy" value="${r.dateTo}"/>${date2}</td>
			<td><a href="student.info?id=${r.student.ID}">${r.student.mail}</a></td>
			<td>
				<a href="reservation.accept?id=${r.ID}"><input type="button" value="Accept" name="accept" /></a>
				&nbsp;
				<a href="reservation.delete?id=${r.ID}"><input type="button" value="Delete" name="delete" /></a>
			</td>
		</tr>
	</c:forEach>
</table>
</div>

<jsp:include page="bottom.jsp" />