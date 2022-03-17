<%-- 
    Document   : index
    Created on : Mar 2, 2022, 12:14:56 AM
    Author     : Vu Dai Luong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>DREAMJOB - WELCOME DREAMJOB</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
            rel="stylesheet"
            />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="components/navbarComponent.jsp" %>
        <!-- Product section-->
        <section class="py-5">
            <div class="container" style="min-height: 100px">
                <h3>List Company</h3>
                <c:if test="${sessionScope.carts.size()==0}">
                    <h1>List Cart is Empty</h1>
                </c:if>
                <c:if test="${sessionScope.carts.size()!=0}">
                <table class="table table-hover" >
                    <thead>
                        <tr>
                            <th scope="col">stt</th>
                            <th scope="col">Image</th>
                            <th scope="col">Name</th>
                            <th scope="col">Salary</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${carts}" var="C">
                        <tr>
                            <th scope="row">${C.value.com.id}</th>
                            <td><img src="${C.value.com.imagine}" width="50"/></td>
                            <td>${C.value.com.name}</td>
                            <td>${C.value.com.salary}</td>
                            <td><a href="delete-cart?companyId=${C.value.com.id}" class="btn btn-outline-danger">Delete</a></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </c:if>
            </div>
        </section>
        <!-- Footer-->

    </body>
</html>
