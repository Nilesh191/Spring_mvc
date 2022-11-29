<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
body {
	background-image:
		url('https://thumbs.dreamstime.com/z/admission-word-cloud-concept-grey-background-90878637.jpg');
	background-size: 100%;
	}
</style>
</head>
<body>
	<fieldset>
		<legend>:: Insert Student Details ::</legend>
		<form method="post" action="./addStudent">

			<table>
				<tr>
					<td><label>Name</label></td>
					<td><input type="text" name="name"></td>
				</tr>
				
				<tr>
					<td><label>Email</label></td>
					<td><input type="text" name="email"></td>
				</tr>
				
				<tr>
					<td><label>UserName</label></td>
					<td><input type="text" name="userName"></td>
				</tr>
				
				<tr>
					<td><label>Student STD</label></td>
					<td><input type="text" name="standard" ></td>
				</tr>
				<tr>
					<td><label>password</label></td>
					<td><input type="password" name="password" ></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="ADD Student"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%
	if(name!=null){
	%>
	<h3>Successfully Added</h3>
	<%=name %>
	<%
	}
	%>
</body>
</html>