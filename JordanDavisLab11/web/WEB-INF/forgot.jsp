<%-- 
    Document   : forgot
    Created on : 29-Nov-2020, 9:50:56 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgotten Password</title>
    </head>
    <body>
        <h1>Notes App Forgotten Password</h1>
        <h2>Please enter the email of the lost account</h2>
        <form action="forgot" method="post">
            email: <input type="text" name="email"><br>
            <input type="submit" value="Send email">
            ${message}
        </form>
    </body>
</html>
