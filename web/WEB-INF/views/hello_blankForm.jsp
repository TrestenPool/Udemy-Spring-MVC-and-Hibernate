<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tpool
  Date: 6/15/22
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Form</title>
</head>
<body>
    <form action="processForm" method="get">
        <label for="name">Name: </label>
        <input type="text" name="name" id="name">
    </form>
</body>
</html>
