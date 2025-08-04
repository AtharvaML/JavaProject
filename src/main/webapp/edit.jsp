<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDIT</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Base.css">
</head>
<body>

<form action="update" method="post" >
  student id: <input type="text" name="sid" value="${stu.sid}" readonly><br>
  student name: <input type="text" name="sname" value="${stu.sname}"><br>
  student address: <input type="text" name="sadd" value="${stu.sadd}"><br>
  student marks: <input type="text" name="smarks" value="${stu.smarks}"><br>
  student section: <input type="text" name="ssec" value="${stu.ssec}"><br>
  student standard: <input type="text" name="sstd" value="${stu.sstd}"><br>
  <button type="submit">update</button>
</form>


</body>
</html>