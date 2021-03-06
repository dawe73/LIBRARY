<%@ page language="java" contentType="text/html; charset=UTF-8"
				    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="../resources/styles/styles.css" media="screen" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="top.jsp" />


<div class="allContent">
<table>
	<tr>
		<th>Book</th>
		<th>From</th>
		<th>To</th>
		<th>Student</th>
		<th>Active</th>
		<th>Received</th>
		<th></th>
	</tr>
	<c:forEach items="${borrowing}" var="b">
		<tr>
			<td><a href="book.info?id=${b.book.ID}">${b.book.title}</a></td>
			<td><fmt:formatDate var="date" pattern="dd.MM.yy" value="${b.dateFrom}"/>${date}</td>
			<td><fmt:formatDate var="date2" pattern="dd.MM.yy" value="${b.dateTo}"/>${date2}</td>
			<td><a href="student.info?id=${b.student.ID}">${b.student.mail}</a></td>
			<c:if test="${b.dateReceived !=null}"><td></td></c:if>
			<c:if test="${b.dateReceived == null}"><td class="green"></td></c:if>
			<td><fmt:formatDate var="date3" pattern="dd.MM.yy" value="${b.dateReceived}"/>${date3}</td>
			<c:if test="${b.dateReceived ==null}"><td><a href="borrowing.end?id=${b.ID}"><input type="button" value="Finish" name="Finish" /></a></td></c:if>
			
		</tr>
	</c:forEach>
</table>
</div>

<jsp:include page="bottom.jsp" />