<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


    <div>
    <aside class="menu">
    <ul class="menu-list">
    <li>
    <a class="is-active">Mypage</a>
    <ul>
    <li><a>회원정보수정</a></li>
    <li><a>주문내역조회</a></li>
    <li><a>장바구니</a></li>
    </ul>
    </li>
    </aside>
    </div>

    <jsp:include page="../../layout/sidebar.jsp">
        <jsp:param name="pageName" value="header"/>
    </jsp:include>