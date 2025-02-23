<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="ISO-8859-1">
   <title>SignUp or Login Page</title>
    <link rel="stylesheet" href="index.css"> 
</head>
<body>
<center>
    <h1>Welcome To Ami Online Foods</h1>
            
    <h3><a href="signUp.jsp">SignUp ||<a href="login.jsp">Login</a></h3>
</center>
</body>
</html>--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="ISO-8859-1">
   <title>SignUp or Login Page</title>
   <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap" rel="stylesheet">
   <link rel="stylesheet" href="index.css"> 
</head>
<body>
    <div class="auth-container">
        <h1>Welcome To Ami Online Foods</h1>
        
        <!-- Login Form (Displays by default) -->
        <form class="auth-form" action="login.jsp" method="post">
            <h2>Login</h2>
            <input type="email" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
            <p>Not a member? <a href="signUp.jsp" class="switch-link">Sign Up here</a></p>
        </form>
    </div>
</body>
</html>