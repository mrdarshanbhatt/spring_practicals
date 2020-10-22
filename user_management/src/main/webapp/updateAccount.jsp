<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE_ACCOUNT</title>
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
        <label class="font_design">Update Account in UserManagment v1.1</label>
        <br><br>
        <form action="/updateUser" method="post">
            <table>
                <tr align="right">
                    <td>
                        Firstname : <input type="text" name="fname"><br><br>
                    </td>
                </tr>
                <tr align="right">
                    <td>
                        Lastname : <input type="text" name="lname"><br><br>
                    </td>
                </tr>
                <tr align="right">
                    <td>
                        UserId : <input type="text" name="uid" required="required"><br><br>
                    </td>
                </tr>
                <tr align="right">
                    <td>
                        Email : <input type="text" name="email"><br><br>
                    </td>
                </tr>
                <tr align="right">
                    <td>
                        Contact : <input type="text" name="mobile"><br><br>
                    </td>
                </tr>
                <tr align="right">
                    <td>
                        City : <input type="text" name="city"><br><br>
                    </td>
                </tr>
                <tr align="right">
                    <td>
                        Password : <input type="password" name="pass" required="required"><br><br>
                    </td>
                </tr>
                <tr align="center">
                    <td>
                        <input type="submit" value="Update">
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <br>
        If You want to Update Your Password then Click Below Link...
        <br>
        <br>
        <a href="updatePSW.jsp">Update Password</a>

    </div>

</body>
</html>