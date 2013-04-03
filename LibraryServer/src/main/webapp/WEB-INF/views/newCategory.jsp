<%@ page language="java" contentType="text/html; charset=UTF-8"
				    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="./resources/styles/styles.css" media="screen" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<jsp:include page="top.jsp" />
<jsp:include page="topCategory.jsp" />


<div class="allContent">
<form:form action="category.add" commandName="category"  method="POST">
	<table>
		<tr>
			<td>Title</td>
			<td><form:input path="title"/></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><form:textarea path="description"/></td>
		</tr>
		<tr>
			<td>Parent Category</td>
			<td>
				<form:select path="parentCategory">
				<form:options items="${categories}"  itemLabel="title" />
				</form:select>
			
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Add Category" name="add" /></td>
		</tr>
	</table>
	
</form:form>
</div>

<jsp:include page="bottom.jsp" />