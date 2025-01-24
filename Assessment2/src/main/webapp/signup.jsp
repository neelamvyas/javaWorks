<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <style>
        .form-container {
            margin: 20px;
            padding: 20px;
            border: 1px solid #ccc;
            width: 300px;
        }
        .form-container label {
            display: block;
            margin-top: 10px;
        }
        .form-container input, .form-container textarea {
            width: 100%;
            padding: 5px;
            margin-top: 5px;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>User Sign Up</h2>
        <form action="SignupServlet" method="post">
            <label>First Name:</label>
            <input type="text" name="firstName" required>
            <label>Last Name:</label>
            <input type="text" name="lastName" required>
            <label>Email:</label>
            <input type="email" name="email" required>
            <label>Mobile:</label>
            <input type="text" name="mobile" required>
            <label>Address:</label>
            <textarea name="address" rows="3"></textarea>
            <label>Gender:</label>
            <input type="radio" name="gender" value="Male" required> Male
            <input type="radio" name="gender" value="Female" required> Female
            <label>Password:</label>
            <input type="password" name="password" required>
            <label>Confirm Password:</label>
            <input type="password" name="confirmPassword" required>
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
