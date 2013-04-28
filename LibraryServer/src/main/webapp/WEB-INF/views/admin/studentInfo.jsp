<%@ page language="java" contentType="text/html; charset=UTF-8"
				    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="../resources/styles/styles.css" media="screen" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
    prefix="fn" %>


<jsp:include page="top.jsp" />


<div class="allContent">
	
	<table>
		<tr>
			<th>Name</th>
			<td>${student.name}</td>
		</tr>
		<tr>
			<th>Surname</th>
			<td>${student.surname}</td>
		</tr>
		<tr>
			<th>Mail</th>
			<td>${student.mail}</td>
		</tr>
		
	</table>

<h2>Reservations</h2>
<table>
	<tr>
		<th>Book</th>
		<th>From</th>
		<th>To</th>
		<th></th>
	</tr>
	<c:forEach items="${student.reservations}" var="r">
		<tr>
			<td><a href="book.info?id=${r.book.ID}">${r.book.title}</a></td>
			<td><fmt:formatDate var="date" pattern="dd.MM.yy" value="${r.dateFrom}"/>${date}</td>
			<td><fmt:formatDate var="date2" pattern="dd.MM.yy" value="${r.dateTo}"/>${date2}</td>
		</tr>
	</c:forEach>
</table>

<h2>Borrowings</h2>
<table>
	<tr>
		<th>Book</th>
		<th>From</th>
		<th>To</th>
		<th>Active</th>
		<th>Received</th>
		<th></th>
	</tr>
	<c:forEach items="${student.borrowings}" var="b">
		<tr>
			<td><a href="book.info?id=${b.book.ID}">${b.book.title}</a></td>
			<td><fmt:formatDate var="date" pattern="dd.MM.yy" value="${b.dateFrom}"/>${date}</td>
			<td><fmt:formatDate var="date2" pattern="dd.MM.yy" value="${b.dateTo}"/>${date2}</td>
			<c:if test="${b.dateReceived !=null}"><td></td></c:if>
			<c:if test="${b.dateReceived == null}"><td class="green"></td></c:if>
			<td><fmt:formatDate var="date3" pattern="dd.MM.yy" value="${b.dateReceived}"/>${date3}</td>
			
		</tr>
	</c:forEach>
</table>

</div>

<jsp:include page="bottom.jsp" />
