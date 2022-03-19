<%-- 
    Document   : employees
    Created on : Mar 18, 2022, 1:32:25 AM
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
        <form action="employees" method="POST">
            <table>
            <tbody>
                <tr>
                    <td>name</td>
                    <td><input type="text" name="name"  /></td>
                </tr>
                <tr>
                    <td>sex</td>
                    <td><input type="radio"  name="sex" checked="checked"/>Male
                        <input type="radio" name="sex"/>Female
                    </td>
                </tr>
                <tr>
                    <td><button type="button" >submit</button></td>
                </tr>
            </tbody>   
        </table>
        </form>
        ${alert}
        <c:forEach var="o" items="${listS}">
            ${o.name}  
            -
            ${o.gender} <br>
        </c:forEach>
    </body>
</html>
