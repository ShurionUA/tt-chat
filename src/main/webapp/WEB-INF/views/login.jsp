<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<h4 style="color:red">
    ${errorMsg}
</h4>
<form method="post" id="login" action="${pageContext.request.contextPath}/login"></form>
<h1>Enter your login name:</h1>
<table border="1">
    <tr>
        <th>Enter Login</th>
        <th>login</th>
    </tr>
    <tr>
        <td>
            <input type="text" name="login" form="login" required>
        </td>
        <td>
            <input type="submit" name="let's go!" form="login">
        </td>
    </tr>
    <tr>
    </tr>
</table>
</body>
</html>
