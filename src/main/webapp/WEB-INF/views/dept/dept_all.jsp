<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 8. 19.
  Time: 오전 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>부서 목록</h1>

<form method="get" action="#" th:action="@{/dept}">
    <input type="text" name="searchKeyword" placeholder="검색어" th:value="${param.searchKeyword}">
    <button type="submit">검색</button>
</form>

<table border="1">
    <thead>
    <tr>
        <th>부서번호</th>
        <th>부서명</th>
        <th>위치</th>
    </tr>
    </thead>
    <tbody>
    <tr th:each="dept : ${depts}">
        <td th:text="${dept.deptId}">1</td>
        <td th:text="${dept.deptName}">개발부</td>
        <td th:text="${dept.location}">서울</td>
    </tr>
    </tbody>
</table>

<div>
    <span th:text="'총 페이지: ' + ${pages.totalPages}">총 페이지: 3</span>
</div>

</body>
</html>
