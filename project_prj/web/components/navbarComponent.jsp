<%-- 
    Document   : navbarComponent
    Created on : Mar 5, 2022, 1:12:51 AM
    Author     : Vu Dai Luong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!-- Navigation-->
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
                            th??ng tin ho???t ?????ng
                            <span class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.carts.size()}</span>
                        </a>
                    </div>
                        <c:choose>
                            <c:when test="${sessionScope.a != null}">
                                <button class="btn btn-outline-primary ms-lg-2">${sessionScope.a.displayname}</button>
                                <a href="logout"class="btn btn-outline-primary ms-lg-2">Logout</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="login"class="btn btn-outline-primary ms-lg-2">Login</a>
                                </c:otherwise>                                                      
                        </c:choose>                     
                </div>
            </div>
        </nav>
