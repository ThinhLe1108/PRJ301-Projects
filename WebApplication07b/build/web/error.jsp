<%-- 
    Document   : error
    Created on : May 30, 2025, 8:39:55 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.lang.String" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String mag = request.getAttribute("message") /%>
        <h1>Hello World!</h1>
    </body>
</html>
