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

		<h2>Unesite ime i lozinku:</h2>

		<c:if test="${not empty error}">
			<div align="right">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div align="right">${msg}</div>
		</c:if>

		<form name='loginForm'
			action="login" method='POST'>

			<table>
				<tr>
					<td>Ime:</td>
					<td><input type='text' name='username' value=''></td>
				</tr>
				<tr>
					<td>Lozinka:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" /></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>
</html>