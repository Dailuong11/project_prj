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
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="${cp.imagine}" alt="..." /></div>
                    <div class="col-md-6">
                        <h1 class="display-5 fw-bolder">${cp.name}</h1>
                        <div class="fs-5 mb-5">
                            <span >salary</span>
                            <span>$${cp.salary}</span>
                        </div>
                        <h3>Description</h3>
                        <p class="lead"> ${cp.description}</p>
                        <div class="d-flex">
                            <!--                           <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />-->
                            <button class="btn btn-outline-success flex-shrink-0 ms-2" type="button">
                                <a href="add-to-card?companyId=${cp.id}" class="bi-cart-fill me-1">UNG TUYEN</a>
                            </button>
                            <button class="btn btn-outline-success flex-shrink-0 ms-2" type="button">
                                <a href="survey.html" class="bi-cart-fill me-1">DANG KI HO SO</a>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Related items section-->
        <!-- Footer-->
        <%@include file="components/footerComponents.jsp" %>

    </body>
</html>
