<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background: #fff;
            padding: 25px 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.2);
            width: 350px;
        }

        .container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-group {
            display: flex;
            justify-content: space-between;
            margin-bottom: 15px;
        }

        .form-group input {
            width: 48%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-control {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-size: 14px;
        }

        .gender {
            margin: 10px 0;
        }

        .gender input {
            margin-right: 5px;
        }

        .btn {
            width: 100%;
            padding: 10px;
            background: #1877f2;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        .btn:hover {
            background: #0d65d9;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>User Registration Form</h2>
    <form action="register" method="post">
        <div class="form-group">
            <input type="text" name="firstName" placeholder="First Name" required/>
            <input type="text" name="lastName" placeholder="Last Name" required/>
        </div>
        <input type="email" name="email" class="form-control" placeholder="Your Email" required/>
        <input type="email" name="confirmEmail" class="form-control" placeholder="Re-enter Email" required/>
        <input type="password" name="password" class="form-control" placeholder="New Password" required/>

        <label>Birthday</label>
        <div class="form-group">
            <select name="month" class="form-control" style="width:32%">
                <option>Month</option>
                <% for (int i = 1; i <= 12; i++) { %>
                <option><%= i %></option>
                <% } %>
            </select>
            <select name="day" class="form-control" style="width:32%">
                <option>Day</option>
                <% for (int i = 1; i <= 31; i++) { %>
                <option><%= i %></option>
                <% } %>
            </select>
            <select name="year" class="form-control" style="width:32%">
                <option>Year</option>
                <% for (int i = 1950; i <= 2025; i++) { %>
                <option><%= i %></option>
                <% } %>
            </select>
        </div>

        <div class="gender">
            <input type="radio" name="gender" value="Female"/> Female
            <input type="radio" name="gender" value="Male"/> Male
        </div>

        <button type="submit" class="btn">Sign Up</button>
    </form>
</div>
</body>
</html>
