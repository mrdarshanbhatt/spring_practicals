<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGN_UP</title>
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
        <label class="font_design">Create Account in UserManagment v1.1</label>
        <br><br>
        <form action="/addUser" method="post">
            <table>
                <tr align="right">
                    <td>
                        Firstname : <input type="text" name="fname" required="required"><br><br>
                    </td>
                </tr>
                <tr align="right">
                    <td>
                        Lastname : <input type="text" name="lname" required="required"><br><br>
                    </td>
                </tr>
                <tr align="right">
                    <td>
                        UserId : <input type="text" name="uid" required="required"><br><br>
                    </td>
                </tr>
                <tr align="right">
                    <td>
                        Email : <input type="text" name="email" required="required"><br><br>
                    </td>
                </tr>
                <tr align="right">
                    <td>
                        Contact : <input type="text" name="mobile" required="required"><br><br>
                    </td>
                </tr>
                <tr align="right">
                    <td>
                        City : <input type="text" name="city" required="required"><br><br>
                    </td>
                </tr>
                <tr align="right">
                    <td>
                        Password : <input type="password" name="pass" required="required"><br><br>
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <input type="submit" value="signUp">
                    </td>
                </tr>
            </table>
        </form>

    </div>

</body>
</html>