<%@ page import="iuh.fit.se.entities.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Result</title>
</head>
<body>
<%
    Student s = (Student) request.getAttribute("student");
%>
<h2>Student Registration Details</h2>
<ul>
    <li>First Name: <%= s.getFirstName() %></li>
    <li>Last Name: <%= s.getLastName() %></li>
    <li>Date of Birth: <%= s.getDob() %></li>
    <li>Email: <%= s.getEmail() %></li>
    <li>Mobile: <%= s.getMobile() %></li>
    <li>Gender: <%= s.getGender() %></li>
    <li>Address: <%= s.getAddress() %></li>
    <li>City: <%= s.getCity() %></li>
    <li>Pin Code: <%= s.getPincode() %></li>
    <li>State: <%= s.getState() %></li>
    <li>Country: <%= s.getCountry() %></li>
    <li>Hobbies: <%= s.getHobbies() %></li>
    <li>Qualification:<br/> <%= s.getQualification() %></li>
    <li>Course Applied: <%= s.getCourse() %></li>
</ul>
</body>
</html>
