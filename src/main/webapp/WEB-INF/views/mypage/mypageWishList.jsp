<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.example.crud.domain.CartDTO" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

<%--    <link type="text/css" rel="stylesheet" href="/resources/css/mypage/mypage1.css"/>--%>


</head>
<body>
<div align="center">
    <h3>[장바구니 보기]</h3>
    <table border="1">
        <tr>
            <th>번호</th> ${user.email}
            <th>상품명</th>
            <th>주문 수량</th>
            <th>가격</th>
        </tr>

        <tr align='center'>
            <td colspan= '5'>
                장바구니에 담긴 상품이 없습니다.
                <a href= '../../UserMain.jsp'>주문하기</a>
            </td>
        </tr>

        <tr align= 'center'>

        <tr align = 'center'>
            <td colspan= '4'>
                <input type='button' value='결제하기' onclick='fnPay()' />
                <input type='button' value='장바구니 비우기' onclick='fnClear()' />
                <input type='button' value='쇼핑 계속하기' onclick='fnGo()' />
            </td>

        </tr>

    </table>
</div>
</body>
</html>
