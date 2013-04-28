<%@ page language="java" contentType="text/html; charset=UTF-8"
				    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="../resources/styles/styles.css" media="screen" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
    prefix="fn" %>


<jsp:include page="top.jsp" />
<jsp:include page="topBooks.jsp" />


<div class="allContent">
	<table>
		<tr>
			<th>Title</th>
			<td>${book.title}</td>
		</tr>
		<tr>
			<th>Category</th>
			<td>
				<a href="category.info?id=${book.category.ID}">${book.category.title}</a>
			</td>
		</tr>
		<tr>
			<th>Authors</th>
			<td>
				<c:set var="index" value="0"/>
				<c:forEach items="${book.authors}" var="a" >
					<a href="author.info?id=${a.ID}">${a.name} ${a.surname}</a>					
					<c:set var="index" value="${index+1 }"/> 
					<c:if test="${fn:length(book.authors) > 1 && index != fn:length(book.authors)}" >, </c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th>ISBN</th>
			<td>${book.ISBN}</td>
		</tr>
		<tr>
			<th>Keywords</th>
			<td>${book.keywords}</td>
		</tr>
		<tr>
			<th>Page count</th>
			<td>${book.pageCount}</td>
		</tr>
		<tr>
			<th>Printer info</th>
			<td>${book.printerInfo}</td>
		</tr>
		<tr>
			<th>Count</th>
			<td>${book.count}</td>
		</tr>
		<tr>
			<th>Available</th>
			<td>${book.availableCount}</td>
		</tr>
		<tr>
			<th>Borrowed</th>
			<td>${book.count-book.availableCount}</td>
		</tr>
	</table>
		<a href="book.edit?id=${book.ID}"><input type="button" value="Edit" name="edit" /></a>
</div>

<jsp:include page="bottom.jsp" />
