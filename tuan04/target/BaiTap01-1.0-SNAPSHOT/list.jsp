<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, iuh.fit.se.entity.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh Sách Tài Khoản</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            padding: 30px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }
        th {
            background: #1877f2;
            color: white;
        }
        tr:nth-child(even) {
            background: #f2f2f2;
        }
    </style>
</head>
<body>
<h2>Danh Sách Tài Khoản</h2>
<table>
    <tr>
        <th>First Name</th><th>Last Name</th><th>Email</th><th>Gender</th><th>Birthday</th>
    </tr>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
        if (users != null) {
            for (User u : users) {
    %>
    <tr>
        <td><%= u.getFirstName() %></td>
        <td><%= u.getLastName() %></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getGender() %></td>
        <td><%= u.getBirthday() %></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
