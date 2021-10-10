<%-- 
    Document   : login
    Created on : Oct 10, 2021, 1:32:28 AM
    Author     : 854292
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form>
            <label>Username:</label>
            <input type="text" name="username">
            <br>
            <label>Password:</label>
            <input type="text" name="password">
            <br>
            <input type="submit" value="Log in">
        </form>
        <p>${message}</p>
    </body>
</html>
