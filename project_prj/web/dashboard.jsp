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
         <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" style="color: #06BBCC" href="main.html">DREAMJOB</a>
                <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                    >
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="home.html">Home</a>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="about.html">About</a></li>
                    </ul>
                    <form action="search" class="d-flex mx-auto">
                        <input
                            class="form-control me-2"
                            type="search"
                            placeholder="Search"
                            aria-label="Search"
                            name="keyword"
                            />
                        <button class="btn btn-outline-success" type="submit">
                            Search
                        </button>
                    </form>
                    <div class="d-flex my-2">
                        <a class="btn btn-outline-success" href="carts">
                            thông tin hoạt động
                            <span class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.carts.size()}</span>
                        </a>
                    </div>
                        <c:choose>
                            <c:when test="${sessionScope.a != null}">
                                <button class="btn btn-outline-primary ms-lg-2">${sessionScope.a.displayname}</button>
                                <a href="logout1"class="btn btn-outline-primary ms-lg-2">Logout</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="login"class="btn btn-outline-primary ms-lg-2">Login</a>
                                </c:otherwise>                                                      
                        </c:choose>                     
                </div>
            </div>
        </nav>
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
                    <a href="addcompany">Create</a>
                </table>               
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

