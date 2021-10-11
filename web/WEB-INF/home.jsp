<%-- 
    Document   : home
    Created on : Oct 10, 2021, 1:32:44 AM
    Author     : 854292
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <p>Hello ${sessionUsername}.</p>
        <a href="/MyLogin/login?logout">Log out</a>
    </body>
</html>
