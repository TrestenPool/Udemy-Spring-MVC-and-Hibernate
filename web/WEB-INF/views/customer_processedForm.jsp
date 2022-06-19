<%--
  Created by IntelliJ IDEA.
  User: tpool
  Date: 6/16/22
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer processed form</title>
</head>

<body>
    <h1>Processed form for the customer</h1>

    Customer ${customer.firstName} ${customer.lastName} has been processed.

    <br><br>

    They received ${customer.freePasses} free passes.

    <br><br>

    Postal Code: ${customer.postalCode}
</body>

</html>
