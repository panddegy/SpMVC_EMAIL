<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/include/include_head.jspf" %>
</head>
<style>

</style>
<script>
$(function(){
	$("#btn-submit").click(function(){
		$("form").submit()
	})
	$("#btn-delete").click(function(){
		let id=$("#email-id").val()
		location.href="${rootpath}/delete?id="+id
	})
})
</script>
<body>
<header>
	<h2>E-Mail</h2>
	<nav>
		<a href="${rootpath}/" >Home</a>
		<a href="${rootpath}/write">Email</a>
		<a href="${rootpath}/list">List</a>
		<a href="#">About</a>
	</nav>
</header>
<section>
	<c:if test="${BODY=='WRITE'}">
		<%@include file="/WEB-INF/views/bodies/write_form.jspf" %>
	</c:if>
	<c:if test="${BODY=='LIST'}">
		<%@include file="/WEB-INF/views/bodies/email_list.jspf" %>
	</c:if>
	<c:if test="${BODY=='UPDATE'}">
		<%@include file="/WEB-INF/views/bodies/write_form.jspf" %>
	</c:if>
</section>
<footer>
	<c:if test="${BODY=='WRITE'}">
		<button class="btns" id="btn-submit">Submit</button>
	</c:if>
	<c:if test="${BODY=='UPDATE'}">
		<button class="btns" id="btn-submit">Update</button>
	</c:if>
	<c:if test="${BODY=='UPDATE'}">
		<button class="btns" id="btn-delete">Delete</button>
	</c:if>
</footer>

</body>
</html>




















