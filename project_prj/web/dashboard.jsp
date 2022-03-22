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
        <link href="${pageContext.servletContext.contextPath}/css/styles.css" rel="stylesheet"/>
    </head>
    <body>
        <%@include file="components/navbarComponent.jsp" %>
        <!-- Product section-->
        <section class="py-5">
            <div class="container" style="min-height: 100px">
                <h3>List Company</h3>
                <table class="table table-hover" >
                    <thead>
                        <tr>
                            <th scope="col">stt</th>
                            <th scope="col">Image</th>
                            <th scope="col">Name</th>                            
                            <th scope="col">Salary</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                        <c:forEach items="${listcp}" var="C">
                            <tr>
                                <th scope="row">${C.id}</th>
                                <td><img src="${C.imagine}" width="50"/></td>
                                <td>${C.name}</td>
                                <td>${C.salary}</td>
                                <td>${C.quantity}</td>                          
                                    <td><a href="#" onclick="showMess(${C.id})" class="btn btn-outline-danger">Delete</a></td>
                                    <td><a href="update?sid=${C.id}"  class="btn btn-outline-success">Edit</a></td>   
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="addcompany">Create</a>
            </div>
        </section>
        <!-- Footer-->
    </body>
    <script>
        function showMess(id){
            var option = confirm('Really want to delete ???');
            if(option === true){
                window.location.href = 'delete?sid='+id;
            } 
        } 
    </script>
</html>

