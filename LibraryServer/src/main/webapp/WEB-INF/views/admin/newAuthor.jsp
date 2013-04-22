<%@ page language="java" contentType="text/html; charset=UTF-8"
				    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="../resources/styles/styles.css" media="screen" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<jsp:include page="top.jsp" />
<jsp:include page="topAuthors.jsp" />


<div class="allContent">
<form:form action="author.add" commandName="author"  method="POST">
	<table>
	<form:hidden path="ID"/>
		<tr>
			<td>Name</td>
			<td><form:input path="name"/></td>
			<td><form:errors path="name" cssClass="error"/></td>
		</tr>
		<tr>
			<td>Surname</td>
			<td><form:input path="surname"/></td>
			<td><form:errors path="surname" cssClass="error"/></td>
		</tr>
		<tr>
			<td>Birthday</td>
			<td><input name="birthDay" type="text" value="${birthDay}"/></td>
<%-- 			<td><form:input path="birthDate"/></td> --%>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Add Author" name="add" /></td>
		</tr>
	</table>
	
</form:form>
</div>

<jsp:include page="bottom.jsp" />