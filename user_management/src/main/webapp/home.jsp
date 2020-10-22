<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management v1.1</title>

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
<body style="background-color: yellowgreen">

	<div align="center" class="CENTER">
		<p class="font_style">UserManagement v1.1</p>
		<br> <br>
		<form action="signUp.jsp">
			<input type="submit" value="     signUp     ">
		</form>
		<br> <br>
		<form action="login.jsp">
			<input type="submit" value="      Login      ">
		</form>
		<br> <br>
		<form action="findUser.jsp">
			<input type="submit" value="    Get User    ">
		</form>
		<br> <br>
		<form action="deleteUser.jsp">
			<input type="submit" value="  Delete User  ">
		</form>
		<br> <br>
		<form action="updateAccount.jsp">
			<input type="submit" value="      Update      ">
		</form>
		<br> <br>
		<form action="updatePSW.jsp">
			<input type="submit" value=" Update PSW ">
		</form>
		<br> <br>
		<form action="/logout" method="get">
			<input type="submit" value="      Logout      ">
		</form>
	</div>

</body>

</html>