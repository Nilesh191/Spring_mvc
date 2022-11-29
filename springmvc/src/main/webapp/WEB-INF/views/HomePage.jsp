<%@page import="com.jspiders.springmvc.dto.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="NavBar.jsp"></jsp:include>
<%
StudentDTO student = (StudentDTO) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style type="text/css">
form {
	margin-top: 10px;
}
form table {
	margin: auto;
	width: 100%;
}
tr {
	text-align: center;
}
fieldset table {
	margin: auto;
	text-align: left;
}
fieldset {
	margin: 15px 520px;
	text-align: center;
}
legend {
	color: white;
	background-color: #333;
}
body {
	background-image:
		url('https://thumbs.dreamstime.com/z/graduation-cap-stack-books-1425111.jpg');
	background-size: 100%;
}
</style>
</head>
<body>
    <img src=""></img>
	<%
	if (student != null) {
	%>
	    ::Student Details::<br>		
	    Student Id:
		<%=student.getId()%><br>
		Student Name:
		<%=student.getName() %><br>
		Student Course:
		<%=student.getStandard() %>
	<%
	}
	%>

</body>
</html>