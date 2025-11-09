<%@ page import="iuh.fit.se.entities.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kết quả đăng ký</title>
</head>
<body>
<%
    Student student = (Student) request.getAttribute("student");
    if (student != null) {
%>
<h2>Thông tin bạn đã nhập:</h2>
<p><strong>Họ và tên:</strong> <%= student.getFirstName() %> <%= student.getLastName() %></p>
<p><strong>Tên đăng nhập:</strong> <%= student.getUsername() %></p>
<p><strong>Email:</strong> <%= student.getEmail() %></p>
<p><strong>Facebook:</strong> <%= student.getFb() %></p>
<p><strong>Giới thiệu bản thân:</strong> <%= student.getBio() %></p>
<%
} else {
%>
<p>Dữ liệu không tồn tại!</p>
<%
    }
%>
</body>
</html>
