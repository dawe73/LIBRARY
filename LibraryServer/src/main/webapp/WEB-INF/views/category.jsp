<%@ page language="java" contentType="text/html; charset=UTF-8"
				    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="./resources/styles/styles.css" media="screen" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="top.jsp" />
<jsp:include page="topCategory.jsp" />


<div class="allContent">
	<table>
		<tr>
			<th>Title</th>
			<th>Level</th>
			<th>Parent Category</th>
			<th>Description</th>
		</tr>
	
	<c:forEach var="c" items="${categories}">
		<tr>
			<td>
				<a href="category.info?id=${c.ID}">${c.title}</a>
			</td>
			<td>${c.level}</td>
			<td>${c.parentCategory.title}</td>
			<td>${c.description}</td>
			<td>
			<a href="category.edit?id=${c.ID}"><input type="button" value="Edit" name="edit" /></a>
			<a href="category.delete?id=${c.ID}"><input type="button" value="Delete" name="delete"/></a>
			</td>
		</tr>
	</c:forEach>
	</table>
</div>

<jsp:include page="bottom.jsp" />
