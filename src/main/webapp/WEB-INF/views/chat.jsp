<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat</title>
</head>
<body>
<h1>Messages(last 50):</h1>
<form method="get" id="refresh" action="${pageContext.request.contextPath}/chat"></form>
<button type="submit" form="refresh">refresh</button>
<table>
    <c:forEach var="message" items="${messages}">
        <tr>
            <td>
                <c:out value="${message.user.name}: ${message.message}"/>
            </td>
        </tr>
    </c:forEach>
</table>
<tr>
    <form method="post" id="send" action="${pageContext.request.contextPath}/chat"></form>
    <td>
        <input type="text" name="message" form="send" required>
    </td>
    <td>
        <button type="submit" form="send">send</button>
    </td>
</tr>
</body>
</html>
