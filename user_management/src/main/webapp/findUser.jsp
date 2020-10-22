<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FIND_USER</title>

<style>
.CENTER {
	max-width: 500px;
	margin: auto;
}

.font_style {
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	color: black;
	background-color: yellowgreen;
}
</style>

</head>
<body class="font_style">

	<div align="center" class="CENTER">
		<p>UserManagement v1.1</p>
		<form action="/findUser" method="post">
			UserId : <input type="text" name="uid"> 
			<input type="submit" value="Get User">
		</form>
	</div>

</body>
</html>