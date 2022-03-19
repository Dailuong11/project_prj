<%-- 
    Document   : login
    Created on : Mar 18, 2022, 10:24:55 PM
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
            <table >
            <tbody>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="name" value="" /></td>
                </tr>
                 <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" value="" /></td>
                </tr>
                <tr>
                    <td><input type="submit"  value="login" /></td>
                    <td></td>
                </tr>
            </tbody>
           
        </table>
        </form>
        <h3>${mess}</h3>
    </body>
</html>
