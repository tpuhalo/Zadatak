<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
cb{
font-size: 10px;
font-color:red
}
</style>
</head>
<body>
	<h2 align="center" style="color: #DF01010">Adresar</h2>
	<hr />
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<div align="center">
		<form:form action="saveContact" modelAttribute="newContact" method="POST">
			<table>
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" />
					<form:errors path="firstName" cssClass="cb"/></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" /><form:errors path="lastName" cssClass="cb"/></td>
				</tr>

				<tr>
					<td>Telephone:</td>
					<td><form:input path="phone" />
					<form:errors path="phone" cssClass="cb"/></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" />
					<form:errors path="email" cssClass="cb"/></td>
				</tr>
				<tr>
					<td>Sex: </td>
					<td><form:select path="sex">
							<c:forEach items="${sexs}" var="sex">
								<option value="${sex.id}">${sex.name}</option>
							</c:forEach>
						</form:select></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><select name="addresses">
							<c:forEach items="${addresses}" var="address">
								<option value="${address.id}">${address.street}
									${address.streetNumber}, ${address.city.name},
									${address.city.country.name}</option>
							</c:forEach>
					</select></td>
				</tr>


				<tr>
					<td align="center"><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form:form>
	</div>
	<hr>
	<div align="right">
		<a href="${contextPath}">Home</a> <br /> Tihomir Puhalo

	</div>
</body>
</html>