<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tpool
  Date: 6/5/22
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Page</title>
</head>
<body>

    <!-- Form -->
    <form:form action="processForm" modelAttribute="student">
        <!-- first name field -->
        First name: <form:input path="firstName"/>
        <br><br>

        <!-- last name field -->
        Last name: <form:input path="lastName"/>
        <br><br>

        <input type="submit" value="submit"/>
    </form:form>

</body>
</html>
