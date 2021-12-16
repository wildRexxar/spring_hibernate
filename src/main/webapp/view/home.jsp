<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15.12.2021
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<c:if test="${sessionScope.authUser == null}">
    <p>Hello Guest!</p>
    <a href="/user/registration">Registration</a>
    <a href="/user/authorization">Authorization</a>
</c:if>

<c:if test="${sessionScope.authUser != null}">
    <p>Hello ${sessionScope.authUser.login}</p>
    <p>Your  number is ${sessionScope.authUser.id}</p>
    <a href="/user/logout">Logout</a>
</c:if>
</body>
</html>
