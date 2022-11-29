<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
ul {
	list-style-type: none;
	background-color: black;
	overflow: hidden;
	background-color: #333;
}
li {
	float: right;
}
li a {
	display: block;
	margin: 0px;
	padding: 15px;
}
li a:hover {
	background-color: #111;
}
a{
text-decoration:none
}
</style>

</head>
<body>
<ul>
		<li><a style="color: white;" 
		href="./logout">Logout</a></li>
		<li><a style="color: white;" 
		href="./searchStudent">Search Student</a></li>
		<li><a style="color: white;" 
		href="./addStudent">Insert Student</a></li>
		<li><a style="color: white;" 
		href="./updateStudent">Update Student</a></li>
		<li><a style="color: white;" 
		href="./removeStudent">Remove Student</a></li>
		<li><a style="color:white;"
		href="./fee">Fee</a></li>
	</ul>
</body>
</html>