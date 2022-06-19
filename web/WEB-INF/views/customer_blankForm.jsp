<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tpool
  Date: 6/16/22
  Time: 9:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Customer Blank Form</title>

    <style>
        .error {
            color:red;
        }
    </style>

</head>
<body>
    <h1>Customer Blank Form</h1>
  <form:form action="processForm" modelAttribute="customer">
      First name: <form:input path="firstName" />

      <br><br>

      Last name (*): <form:input path="lastName" />
      <form:errors path="lastName" cssClass="error"/>

      <br><br>

      Number of free forms (must be between 0 and 10) <form:input path="freePasses"/>
      <form:errors path="freePasses" cssClass="error"/>

      <br><br>

      Postal code (5 digits/chars) <form:input path="postalCode"/>
      <form:errors path="postalCode" cssClass="error"/>

      <br><br>

      <input type="submit" value="Submit"/>
  </form:form>
</body>
</html>
