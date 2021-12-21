<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15.12.2021
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<form action="/user/authorization" method="post">
    <input type="text" name="username" placeholder="Username"/>
    <input type="password" name="password" placeholder="Password"/>
    <button>Enter</button>
</form>
<p>${message}</p>
</body>
</html>
