<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="user.User" %>
<%@ page import="user.UserNotFoundException" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");

    try {
        User.login(userId, password);
        session.setAttribute("userId", userId);

        response.sendRedirect("/index.jsp");
    } catch (UserNotFoundException e) {
        request.setAttribute("errorMessage", "존재하지 않는 사용자 입ㄴ다. 다시 로그인하세요");
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }

%>
