<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
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
		url('https://thumbs.dreamstime.com/z/student-writing-college-university-application-apply-to-school-admission-grant-teacher-computer-principal-headmaster-131140442.jpg');
	background-size: original;
	}
</style>
</head>
<body>
	<fieldset>
		<%
		if (msg != null) {
		%>
		<%=msg%>
		<%
		}
		%>
		<legend>:::LOGIN:::</legend>
		<form method="post" action="./home">
			<table>
				<tr>
					<td><label>UserName</label></td>
					<td><input type="text" name="userName" required></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><input type="text" name="password" required></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>