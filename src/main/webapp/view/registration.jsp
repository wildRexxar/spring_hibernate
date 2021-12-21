<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15.12.2021
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<s:form action="/user/registration" method="post" modelAttribute="user">
<s:input path="username" placeholder="Username"/>
<br>
<s:errors path="username"/>
<br>
<s:input path="password" placeholder="Password"/>
<br>
<s:errors path="password"/>
<br>
<s:button>Submit</s:button>
</s:form>

<a href="/"><button>Home</button></a>
    ${message}
</body>
</html>
