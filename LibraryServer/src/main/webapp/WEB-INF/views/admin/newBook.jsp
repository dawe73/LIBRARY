<%@ page language="java" contentType="text/html; charset=UTF-8"
				    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="../resources/styles/styles.css" media="screen" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<jsp:include page="top.jsp" />
<jsp:include page="topBooks.jsp" />


<div class="allContent">
<form:form action="book.add" commandName="book"  method="POST">
	<table>
	<form:hidden path="ID" value="${ID}"/>
	
		<tr>
			<td>Category</td>
			<td>
				<select name="categoryID">
					<c:forEach items="${categories}" var="c">
						<option value="${c.ID}">${c.title}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>Title</td>
			<td><form:input path="title"/></td>
			<td><form:errors path="title" cssClass="error"/></td>
		</tr>
		<tr>
			<td>Count</td>
			<td><form:input path="count"/></td>
			<td><form:errors path="count" cssClass="error"/></td>
		</tr>
		<c:forEach var="num" begin="1" end="${numberOfAuthors}">
			<tr>
				<td>Author ${num}</td>
				<td><select name="authorsID[]">
						<c:forEach items="${authors}" var="a">
							<option value="${a.ID}">${a.name} ${a.surname}</option>
						</c:forEach>
				</select></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td>
			<input type="submit" value="Next author" name="action" />
			<input type="submit" value="Remove last" name="action" />
			</td>
		</tr>
		<tr>
			<td>Released</td>
			<td><input name="releasedDate" type="text" value="${releasedDate}"/></td>
		</tr>
		<tr>
			<td>ISBN</td>
			<td><form:input path="ISBN"/></td>
			<td><form:errors path="ISBN" cssClass="error"/></td>
		</tr>
		<tr>
			<td>Keyword</td>
			<td><form:textarea path="keywords"/></td>
			<td><form:errors path="keywords" cssClass="error"/></td>
		</tr>
		<tr>
			<td>Page Count</td>
			<td><form:input path="pageCount"/></td>
			<td><form:errors path="pageCount" cssClass="error"/></td>
		</tr>
		<tr>
			<td>Printer info</td>
			<td><form:textarea path="printerInfo"/></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="Add book" name="action" /></td>
		</tr>
	</table>
	
</form:form>
</div>

<jsp:include page="bottom.jsp" />