<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="ko">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Title</title>
</head>
<body>
<ul class="nav">
    <%
        Object userId = session.getAttribute("userId");
    %>
    <li><a href="/">Home</a></li>
    <%
        if (userId == null) {

    %>
    <li><a href="/login.jsp">로그인</a></li>
    <li><a href="/form.jsp">회원가입</a></li>
    <%
    } else {
    %>
    <li><a href="logout.jsp">로그아웃</a></li>
    <li><a href="">개인정보수정</a></li>
    <%
        }
    %>
</ul>
</body>
</html>