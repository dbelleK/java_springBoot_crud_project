<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Application</title>
</head>
<body>
    <p>Hello, Spring Boot App</p>
    <c:if test="${empty sessionUser.email}">
        <p>로그인된 계정이 없습니다.</p>
    </c:if>
    <c:if test="${not empty sessionUser.email}">
        <p>
            ${sessionUser.email} 님 로그인 되었습니다.
        </p>
    </c:if>
    <p></p>
</body>
</html>


