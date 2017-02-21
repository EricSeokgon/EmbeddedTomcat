<%@ page import="db.Database" %>
<%@ page import="user.User" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String email = request.getParameter("email");

    //out.print(userId + " : " + password + " : " + name + " : " + email);

    User user = Database.findByUserId(userId);

    if (user == null) {
        //사용자가 존재하지 않는다는 것을 에러 메시지 전송
    }

    if (password.equals(user.getPassword())) {
        //로그인 처리
    }


%>
