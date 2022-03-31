<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Documentation - Documentation Bulma Theme</title>
    <!-- Bulma Version 0.9.0-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.2/css/bulma.min.css" />
    <link rel="stylesheet" type="text/css" href="../css/documentation.css" />
    <script src="https://kit.fontawesome.com/2828f7885a.js"
            integrity="sha384-WAsFbnLEQcpCk8lM1UTWesAf5rGTCvb2Y+8LvyjAAcxK1c3s5c0L+SYOgxvc6PWG"
            crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="favicon.png" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap" rel="stylesheet" />
    <script src="/resources/js/bulma/dropdown.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

</head>


<body>

    <nav class="navbar" role="navigation" aria-label="main navigation">
         <div class="navbar-brand">
             <a class="navbar-item" href="https://bulma.io">
                 <img src="https://bulma.io/images/bulma-logo.png" width="112" height="28">
            </a>

             <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
                <span aria-hidden="true"></span>
                <span aria-hidden="true"></span>
                <span aria-hidden="true"></span>
             </a>
         </div>

     <div id="navbarBasicExample" class="navbar-menu">
      <div class="navbar-start">

    <a class="navbar-item">
    Home
    </a>

    <div class="navbar-item has-dropdown is-hoverable">
    <a class="navbar-link">
    Notice
    </a>

    <div class="navbar-dropdown">
    <a class="navbar-item" href="noticeIssues">
    공지사항
    </a>
    <a class="navbar-item">
    문의하기
    </a>
    <a class="navbar-item">
    리뷰
    </a>
<%--    <hr class="navbar-divider">--%>
    <a class="navbar-item">

    </a>
    </div>
    </div>

    <div class="navbar-item has-dropdown is-hoverable">
    <a class="navbar-link">
    Mypage
    </a>

    <div class="navbar-dropdown">
    <a class="navbar-item" href="mypageInfo">
    회원정보수정
    </a>
    <a class="navbar-item">
    주문내역조회
    </a>
    <a class="navbar-item" href="mypageWishList">
    장바구니
    </a>
<%--    <hr class="navbar-divider">--%>
    <a class="navbar-item">
    Report an issue
    </a>
    </div>
    </div>

    </div>

    <div class="navbar-end">
    <div class="navbar-item">
    <div class="buttons">
    <a class="button is-primary" href="signUp">
    <strong>Sign up</strong>
    </a>
    <a class="button is-light" href="login">
    Log in
    </a>
    </a>
    <a class="button is-light" href="logout">
    Log out
    </a>
    </div>
    </div>
    </div>
    </div>
    </nav>

