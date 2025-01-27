<!DOCTYPE html>
<html>
<head>
    <title>Change Password</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2>Change Password</h2>
    <form action="ChangePasswordServlet" method="post">
        <label>Old Password:</label>
        <input type="password" name="oldPassword" required><br>
        <label>New Password:</label>
        <input type="password" name="newPassword" required><br>
        <input type="submit" value="Change Password">
    </form>
</body>
</html>
