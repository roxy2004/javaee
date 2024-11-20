<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户添加成功</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h2>${message}</h2>
<h3>所有用户信息：</h3>
<table>
    <tr>
        <th>用户名</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.username}</td>
        </tr>
    </c:forEach>
</table>
<a href="addUser.jsp">继续添加用户</a>
</body>
</html>