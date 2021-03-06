<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Adresar</title>
<style>
table {
	border-collapse: collapse;
}

table, th, td {
	padding: 5px;
	margin: 10px;
	font-size: 20px;
	border: 0.2px solid black;
}

cb {
	font-size: 10px;
	font-color: red
}
</style>
</head>
<body>
	<h2 align="center" style="color: #DF01010">Adresar</h2>
	<hr />
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<div align="center">
		<form:form action="saveContact" modelAttribute="newContact"
			method="POST" accept-charset="UTF-8">
			<table>
				<tr>
					<td>Ime:</td>
					<td><form:input path="firstName" /> <form:errors
							path="firstName" /></td>
				</tr>
				<tr>
					<td>Prezime:</td>
					<td><form:input path="lastName" /> <form:errors
							path="lastName" /></td>
				</tr>

				<tr>
					<td>Telefon:</td>
					<td><form:input path="phone" /> <form:errors path="phone" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /> <form:errors path="email" /></td>
				</tr>
 				<tr>
					<td>Spol:</td>
					<td><select name="sexs">
							<c:forEach items="${sexs}" var="sex">
								<option value="${sex.id}">${sex.name}</option>
							</c:forEach>
						</select></td>
				</tr> 
				<tr>
					<td>Adresa:</td>
					<td><select name="addresses">
							<c:forEach items="${addresses}" var="address">
								<option value="${address.id}">${address.street}
									${address.streetNumber}, ${address.city.name},
									${address.city.country.name}</option>
							</c:forEach>
					</select></td>
				</tr>


				<tr>
					<td align="center"><input type="submit" value="Unesi"></td>
				</tr>
			</table>
		</form:form>
	</div>
	<hr>
	<div align="right">
 <br /> Tihomir Puhalo

	</div>
</body>
</html>