<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 8. 19.
  Time: 오후 7:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/admin/register" method="post">
    이름: <input type="text" name="name"/><br/>
    성별:
    <select name="gender">
        <option value="M">남</option>
        <option value="F">여</option>
    </select><br/>
    전화번호: <input type="text" name="phone"/><br/>
    비밀번호: <input type="password" name="pw"/><br/>
    권한:
    <select name="role">
        <option value="ROLE_ADMIN">관리자</option>
        <option value="ROLE_USER">사원</option>
    </select><br/>
    <button type="submit">등록</button>
</form>

</body>
</html>
