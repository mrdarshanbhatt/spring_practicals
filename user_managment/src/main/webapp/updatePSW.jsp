<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE_PASSWORD</title>
<style>
.font_design {
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	color: black;
	background-color: yellowgreen;
	max-width: 500px;
	margin: auto;
}
</style>
</head>
<body style="background-color: yellowgreen;">

	<div align="center" class="font_design">

		<label class="font_design">Change & Forget Password</label> <br>
		<br>
		Change & Forget The Password only 5 times, then your Account is Blocked....<br><br>
		<form action="/updatePass" method="post">
			<table>
			<tr align="right">
					<td>
						UserId : <input type="text" name="uid" required="required"><br><br>
					</td>
				</tr>
				<tr align="right">
					<td>
						Current Password : <input type="password" name="currentPass" required="required"><br><br>
					</td>
				</tr>
				<tr align="right">
					<td>
						New Password : <input type="password" name="newPass" required="required"><br><br>
					</td>
				</tr>
				<tr align="right">
					<td>
						Confirm Password : <input type="password" name="confirmPass" required="required"><br><br>
					</td>
				</tr>
				<tr align="center">
					<td>
					       <input type="submit" value="Update PSW">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>