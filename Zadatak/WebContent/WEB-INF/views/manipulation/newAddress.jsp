<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
		<form:form action="saveAddress" modelAttribute="addressInfo"
			method="POST">
			<table>
				<tr>
					<td>Ulica:</td>
					<td><form:input path="street" placeholder="Enter street name"></form:input>
						<form:errors path="street"></form:errors></td>
				</tr>
				<tr>
					<td>Ulični broj:</td>
					<td><form:input path="streetNumber"
							placeholder="Enter street number"></form:input> <form:errors
							path="streetNumber"></form:errors></td>
				</tr>
				<tr>
					<td>Grad:</td>
					<td><select name="cities">
							<c:forEach items="${cities}" var="city">
								<option value="${city.id}">${city.name}
									${city.zipCode}, ${city.country.name}</option>
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