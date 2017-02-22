<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="ko">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>로그인</title>
</head>
<body>
<div>
    <h1>로그인</h1>
</div>

<form action="/lgin_action.jsp" method="post">
    <div>
        <%--@declare id="userid"--%><label for="userId">사용자 아이디</label>
        <div>
            <input type="text" name="userId" value=""/>
        </div>
    </div>
    <div>
        <%--@declare id="password"--%><label for="password">비밀번호</label>
        <div>
            <input type="text" name="password" value=""/>
        </div>
    </div>
    <div>
        <div>
            <button type="submit">로그인</button>
        </div>
    </div>
</form>
</body>
</html>