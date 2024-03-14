<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<% String username = (String)session.getAttribute("username");%>
    <h1>You have successfully logged in as <%= username %>.</h1>
    <% 
       request.getSession().setAttribute("username", username); 
 %>
    <form action="DeleteAccountServlet" method="post">
        <input type="submit" value="Delete Account">
    </form>
</body>
</html>
