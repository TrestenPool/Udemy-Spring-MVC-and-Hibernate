<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tpool
  Date: 6/5/22
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Process Form</title>
</head>
<body>
    <h2>Process Form</h2>
    The student ${student.firstName} ${student.lastName} has been processed...
    <br>
    The student is from ${student.country}
    <br>
    The student programming language of choice is ${student.favoriteLanguage}

    <br><br>
    Operating Systems Experience:
    <ul>
        <c:forEach var="temp" items="${student.operatingSystems}">
            <li>${temp}</li>
        </c:forEach>
    </ul>
</body>
</html>
