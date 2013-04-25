<%@ page language="java" contentType="text/html; charset=UTF-8"
				    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="../resources/styles/styles.css" media="screen" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
    prefix="fn" %>

<jsp:include page="top.jsp" />
<jsp:include page="topCategory.jsp" />


<div class="allContent">
	<h2>${category.title}</h2>
	<table>
	<tr>
		<th>Title</th>
		<th>Author</th>
		<th>ISBN</th>
	</tr>
	<c:forEach var="b" items="${books}">
	<tr>
		<td>
			<a href="book.info?id=${b.ID}">${b.title}</a>
		</td>
		<td>
			<c:set var="index" value="0"/>
			<c:forEach items="${b.authors}" var="a" end="1">
				<a href="author.info?id=${a.ID}">${a.name} ${a.surname}</a>	
				<c:if test="${fn:length(b.authors) > 1 && index==0}" >, </c:if>
				<c:if test="${index == 1}">...</c:if>					
			<c:set var="index" value="${index+1 }"/>
			</c:forEach>
		</td>
		<td>
			${b.ISBN}
		</td>
	</c:forEach>
	
	</table>
</div>

<jsp:include page="bottom.jsp" />
