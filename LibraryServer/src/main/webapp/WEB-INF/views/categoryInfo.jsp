<%@ page language="java" contentType="text/html; charset=UTF-8"
				    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="./resources/styles/styles.css" media="screen" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="top.jsp" />
<jsp:include page="topCategory.jsp" />


<div class="allContent">
	<h2>${category.title}</h2>
	seznam knížek s id kategorie
</div>

<jsp:include page="bottom.jsp" />
