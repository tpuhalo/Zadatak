<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
<head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-2" />

<title>Adresar</title>
<style>
h2 {
	color: #08298A;
	text-align: center;
}
</style>
</head>
<body>
	<h2>Login za adresar</h2>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div align="center">
		<h3>Unesite ime i lozinku</h3>

		<form th:action="@{/login}" method="post">
			<table>
				<tr>
					<td>Ime:</td>
					<td><input type='text' name='username'></td>
				</tr>
				<tr>
					<td>Lozinka:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td><input name="submit" type="submit" value="Log in" /></td>
				</tr>
			</table>
		</form>
	</div>
</html>