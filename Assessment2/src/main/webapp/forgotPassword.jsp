<!DOCTYPE html>
<html>
<head>
    <title>Forgot Password</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2>Forgot Password</h2>
    <form action="ForgotPasswordServlet" method="post">
        <label>Email:</label>
        <input type="email" name="email" required><br>
        <label>New Password:</label>
        <input type="password" name="newPassword" required><br>
        <input type="submit" value="Reset Password">
    </form>
</body>
</html>
