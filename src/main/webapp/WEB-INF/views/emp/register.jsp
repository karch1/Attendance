<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>직원 등록</title>
</head>
<body>

<h2>직원 등록</h2>

<form action="${pageContext.request.contextPath}/admin/register" method="post">
    이름:<br/>
    <input type="text" name="name" required/><br/><br/>

    성별:<br/>
    <select name="gender" required>
        <option value="M">남</option>
        <option value="F">여</option>
    </select><br/><br/>

    전화번호:<br/>
    <input type="text" name="phone" required/><br/><br/>

    비밀번호:<br/>
    <input type="password" name="pw" required/><br/><br/>

    권한:<br/>
    <select name="role" required>
        <option value="ROLE_ADMIN">관리자</option>
        <option value="ROLE_USER">사원</option>
    </select><br/><br/>

    <button type="submit">등록</button>
</form>

</body>
</html>
