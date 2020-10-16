<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    
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

<body style="background-color: yellowgreen;">

    <div align="center" class="CENTER">
        <form action="/login" method="post">
            <label for="login" class="font_style">Login</label>
           
            <br><br>
           
            <label for="UserId" class="font_style">&nbspUserId&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp: </label>
            <input type="text" name="uid">
           
            <br><br>
           
            <label for="Password" class="font_style">Password : </label>
            <input type="password" name="pass">
           
            <br><br>
           
            <input type="submit" value="Login" />
        </form>
    </div>
    
    <br><br><br><br>
    
    <div align="center" class="CENTER">
        <p class="font_style">UserManagement v1.1</p>
    </div>

</body>

</html>