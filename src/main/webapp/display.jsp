<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DISPLAY</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Base.css">
</head>
<body>
	<table align="center">
		<thead>

			<tr>

				<th>ID</th>
				<th>Name</th>
				<th>Marks</th>
				<th>Address</th>
				<th>Section</th>
				<th>Standard</th>


			</tr>
		</thead>
		<c:forEach var="dis" items="${User}">

			<tr>
				<td data-label="ID">${dis.sid}</td>
				<td data-label="Name">${dis.sname}</td>
				<td data-label="Marks">${dis.smarks}</td>
				<td data-label="Address">${dis.sadd}</td>
				<td data-label="Section">${dis.ssec}</td>
				<td data-label="Standard">${dis.sstd}</td>
			</tr>

			<tr>
				<td colspan="6"><a
					href="${pageContext.request.contextPath}/edit/${dis.sid}"
					name="button" class="btn btn_lg btn_success">edit</a> <a
					href="${pageContext.request.contextPath}/Delete/${dis.sid}"
					name="button" class="btn btn_lg btn_success">delete</a> <a
					href="Index.html" name="button" class="btn btn_lg btn_success">back</a></td>
			</tr>
		</c:forEach>


	</table>


</body>
</html>