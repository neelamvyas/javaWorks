<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2>Sign Up</h2>
    <form action="SignupServlet" method="post">
        <label>First Name:</label>
        <input type="text" name="firstName" required><br>
        <label>Last Name:</label>
        <input type="text" name="lastName" required><br>
        <label>Email:</label>
        <input type="email" name="email" required><br>
        <label>Password:</label>
        <input type="password" name="password" required><br>
        <input type="submit" value="Sign Up">
    </form>
</body>
</html>
