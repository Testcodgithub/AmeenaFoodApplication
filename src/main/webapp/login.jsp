<%--
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
    <link rel="stylesheet" href="login.css"> <!-- Linking the CSS file -->
</head>
<body>
<div class="full-bg">
        <div class="content-center">
            <!-- Title "Sam Foods" with food emoji below -->
            <h1>Ami Foods</h1>
            <div class="emoji">🍽️</div> <!-- Emoji below the title -->
        </div>

        <div class="login-container">
            <% 
                // Displaying an error message if one exists
                String errorMessage = (String) request.getAttribute("Errormessage");
                if (errorMessage != null) { 
            %>
                <p style="color: red;"><%= errorMessage %></p> <!-- Red error message -->
            <% 
                } 
            %>
            <!-- Form starts here -->
            <form action="loginServlet" method="POST">
                <!-- Email Input -->
                <label for="email">Email</label>
                <input type="text" name="email" id="email" required placeholder="Enter your email">

                <!-- Password Input -->
                <label for="password">Password</label>
                <input type="password" name="password" id="password" required placeholder="Enter your password">

                <!-- Submit Button -->
                <input type="submit" value="Login">
            </form>
        </div>
    </div>
</body>
</html>--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="index.css"> <%-- Reusing index.css --%>
</head>
<body>
    <%-- Main authentication container --%>
    <div class="auth-container">
        <h1>Ami Foods</h1>
        <div class="emoji">🍽️</div> <%-- Emoji below the title --%>

        <%-- Login form starts here --%>
        <form class="auth-form" action="loginServlet" method="post">
            <h2>Login</h2>
            <% 
                // Display error message if login fails
                String errorMessage = (String) request.getAttribute("Errormessage");
                if (errorMessage != null) { 
            %>
                <p class="error-message"><%= errorMessage %></p> <%-- Error in red via CSS --%>
            <% 
                } 
            %>
            <input type="email" name="email" id="email" placeholder="Enter your email" required>
            <input type="password" name="password" id="password" placeholder="Enter your password" required>
            <button type="submit">Login</button>
            <p>Not a member? <a href="signUp.jsp" class="switch-link">Sign Up here</a></p>
        </form>
    </div>
</body>
</html>