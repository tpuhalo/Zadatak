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
	border: 1px solid black;
}
</style>
</head>
<body>
	<h2 align="center" style="color: #DF01010">Adresar</h2>
	<hr />
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<div align="center">
		<form:form action="saveCity" method="POST" modelAttribute="cityInfo">
			<table>
				<tr>
					<td>City:</td>
					<td><form:input path="name" placeholder="Enter street name" />
						<form:errors path="name"></form:errors></td>
				</tr>
				<tr>
					<td>Zip:</td>
					<td><form:input path="zipCode" placeholder="Enter zip" /> <form:errors
							path="zipCode"></form:errors></td>
				</tr>
				<tr>
					<td>Country:</td>
					<td><select name="countries">
							<c:forEach items="${countries}" var="country">
								<option value="${country.id}">${country.name}
									${country.alpha2}</option>
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