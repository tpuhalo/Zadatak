<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
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
	<div align="right">
		<form action="logout" method="POST">
		    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" value="Log out" />
		</form>
	</div>


	<div align="center">


		<table>
			<tr>
				<th><a href="${contextPath}/contact" style="font-size: 20px">Kontakti</a></th>
				<th><a href="${contextPath}/address" style="font-size: 20px">Adrese</a></th>
				<th><a href="${contextPath}/city" style="font-size: 20px">Gradovi</a></th>
				<th><a href="${contextPath}/country" style="font-size: 20px">Države</a></th>
			</tr>

		</table>

	</div>
	
		<h3>
		<span>${error}</span>
	</h3>
	<div align="center">
		<table>
			<caption style="font-size: 20px; margin-bottom: 10px">
				Grad <br /> <a href="${contextPath}/newCity"
					style="font-size: 20px">Dodaj grad</a>
			</caption>


			<tr>
				<th>Grad</th>
				<th>Zip</th>
				<th>Država</th>

			</tr>
			<c:forEach var="city" items="${city}">
				<tr>
					<td><c:out value="${city.name}" /></td>
					<td><c:out value="${city.zipCode}" /></td>
					<td><c:out value="${city.country.name}" /></td>
					<td><a href="${contextPath}/editCity?id=${city.id}"
						style="font-size: 20px">Promijeni</a></td>
					<td><a href="${contextPath}/deleteCity?id=${city.id}"
						style="font-size: 20px">Obriši</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<hr>
	<div align="right">
<br /> Tihomir Puhalo

	</div>
</body>
</html>