<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        .form-container {
            margin: 20px;
            padding: 20px;
            border: 1px solid #ccc;
            width: 300px;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Login</h2>
        <form action="LoginServlet" method="post">
            <label>Email:</label>
            <input type="email" name="email" required>
            <label>Password:</label>
            <input type="password" name="password" required>
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
