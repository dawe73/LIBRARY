<%@ page language="java" contentType="text/html; charset=UTF-8"
				    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="../resources/styles/styles.css" media="screen" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
    prefix="fn" %>


<jsp:include page="top.jsp" />
<jsp:include page="topAuthors.jsp" />


<div class="allContent">
	<table>
		<tr>
			<th>Name</th>
			<td>${author.name}</td>
		</tr>
		<tr>
			<th>Surname</th>
			<td>${author.surname}</td>
		</tr>
		<tr>
			<th>Birth day</th>
			<td><fmt:formatDate var="date" pattern="dd.MM.yy" value="${author.birthDate}"/>${date}</td>
		</tr>
		<tr>
			<th>Books in library</th>
			<td>${fn:length(author.books)}</td>
		</tr>
	</table>
		<a href="author.edit?id=${author.ID}"><input type="button" value="Edit" name="edit" /></a>
</div>

<jsp:include page="bottom.jsp" />
