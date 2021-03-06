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
				Kontakti <br /> <a href="newContact" style="font-size: 20px">
					Dodaj kontakt</a>
			</caption>

			<tr>
				<th>Ime</th>
				<th>Prezime</th>
				<th>Telefon</th>
				<th>Email</th>
				<th>Spol</th>
				<th>Adresa</th>
				<th>Grad</th>
				<th>Država</th>
			</tr>
			<c:forEach var="con" items="${contact}">
				<tr>
					<td><c:out value="${con.firstName}" /></td>
					<td><c:out value="${con.lastName}" /></td>
					<td><c:out value="${con.phone}" /></td>
					<td><c:out value="${con.email}" /></td>
					<td><c:out value="${con.sex.name}" /></td>
					<td><c:out value="${con.address.street}" /> <c:out
							value="${con.address.streetNumber}" /></td>
					<td><c:out value="${con.address.city.name}" /></td>
					<td><c:out value="${con.address.city.country.name}" /></td>
					<td><a href="${contextPath}/editContact?id=${con.id}"
						style="font-size: 20px">Promijeni</a></td>
					<td><a href="${contextPath}/deleteContact?id=${con.id}"
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