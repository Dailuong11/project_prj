<%-- 
    Document   : login
    Created on : Mar 19, 2022, 12:26:37 AM
    Author     : Vu Dai Luong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Username: <input type="text" name="username" value="" /><br/>
            Password: <input type="text" name="password" value="" /><br/>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
