<%@ page language="java" contentType="text/html; charset=UTF-8"
				    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="../resources/styles/styles.css" media="screen" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="top.jsp" />
<jsp:include page="topAuthors.jsp" />


<div class="allContent">
	<table>
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>Birthday</th>
		</tr>
	
	<c:forEach var="a" items="${authors}">
		<tr>
			<td>
				<a href="author.info?id=${a.ID}">${a.name}</a>
			</td>
			<td>${a.surname}</td>
			<td>${a.birthDate}</td>
			<td>
			<a href="author.edit?id=${c.ID}"><input type="button" value="Edit" name="edit" /></a>
			<a href="author.delete?id=${c.ID}"><input type="button" value="Delete" name="delete"/></a>
			</td>
		</tr>
	</c:forEach>
	</table>
</div>

<jsp:include page="bottom.jsp" />
