<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<table>
			<tr>
				<th><a href="${contextPath}/contact" style="font-size: 20px">Kontakti</a></th>
				<th><a href="${contextPath}/address" style="font-size: 20px">Adrese</a></th>
				<th><a href="${contextPath}/city" style="font-size: 20px">Gradovi</a></th>
				<th><a href="${contextPath}/country" style="font-size: 20px">Drzave</a></th>
			</tr>

		</table>

	</div>

	<h3>
		<span>${error}</span>
	</h3>
	<div align="center">
		<table>
			<caption style="font-size: 20px; margin-bottom: 10px">
				Adrese <br /> <a href="${contextPath}/newAddress"
					style="font-size: 20px">Dodaj adresu</a>
			</caption>

			<tr>
				<th>Ulica</th>
				<th>Broj</th>
				<th>Grad</th>
			</tr>
			<c:forEach var="add" items="${address}">
				<tr>
					<td><c:out value="${add.street}" /></td>
					<td><c:out value="${add.streetNumber}" /></td>
					<td><c:out value="${add.city.name}" /></td>
					<td><a href="${contextPath}/editAddress?id=${add.id}"
						style="font-size: 20px">Promijeni</a></td>
					<td><a href="${contextPath}/deleteAddress?id=${add.id}"
						style="font-size: 20px">Obrisi</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<hr>
	<div align="right">
		<a href="${contextPath}">Home</a> <br /> Tihomir Puhalo

	</div>
</body>
</html>