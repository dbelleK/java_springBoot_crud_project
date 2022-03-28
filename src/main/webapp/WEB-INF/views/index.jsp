<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Application</title>
</head>
<body>
    <p>Hello, Spring Boot App</p>
    <c:if test="${empty user.email}"> <%--CustomLoginSuccessHandler에서 세션 user로 잡음--%>
        <p>로그인된 계정이 없습니다.</p>
    </c:if>
    <c:if test="${not empty user.email}">
        <p>
            ${user.email} 님 로그인 되었습니다.
        </p>
    </c:if>
    <p></p>
</body>
</html>


