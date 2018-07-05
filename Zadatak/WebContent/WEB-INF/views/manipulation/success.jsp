<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successfull</title>
</head>
<body>
	<c:if test="${ error} != null">
		<div class="generic-container">
			<div class="alert alert-success lead"></div>

			<span class="well floatRight"> Go to <a
				href="<c:url value='/${goto }' />">list</a>
			</span>
		</div>
	</c:if>
	<c:otherwise>
		<div class="generic-container">
			<div class="alert alert-success lead">${success}</div>

			<span class="well floatRight"> Go to <a
				href="<c:url value='/${goto }' />">list</a>
			</span>
		</div>
	</c:otherwise>
</body>

</html>
</body>
</html>