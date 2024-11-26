<%@ page import="cn.edu.zjut.service.ItemService" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Item List</title>
</head>
<body>
<h1>Item List</h1>
<table border="1">
    <tr>
        <th>Title</th>
        <th>Cost</th>
        <th>Average Cost</th>
    </tr>
    <%
        ItemService itemService = new ItemService();
        List<Object[]> items = itemService.findByHql();
        for (Object[] item : items) {
            String title = (String) item[0];
            Float cost = (Float) item[1];
            Double avgCost = (Double) item[2];
    %>
    <tr>
        <td><%= title %></td>
        <td><%= cost %></td>
        <td><%= avgCost %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>