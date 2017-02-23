<%@ page import="db.Database" %>
<%@ page import="user.User" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String email = request.getParameter("email");

    User user = new User(userId, password, name, email);
    Database.addUser(user);

    response.sendRedirect("/index.jsp");
%>
