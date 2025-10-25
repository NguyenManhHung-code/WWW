<%@ page language="java" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee</title>
</head>
<body>
<h1>Employee List</h1>
<a href="${pageContext.request.contextPath}/show-form">+ Add</a>
<table>
    <tr>
        <td>Id</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Action</td>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>
                <a href="${pageContext.request.contextPath}/show-form-update?employeId=${employee.id}">Update</a>
                | Delete
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>