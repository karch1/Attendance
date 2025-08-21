<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post" accept-charset="UTF-8">
    사번: <input type="text" name="empId" required/><br/>
    비밀번호: <input type="password" name="pw" required/><br/>
    <button type="submit">로그인</button>
</form>
</body>
</html>
