<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>관리자 페이지</title>
</head>
<body>
<h2>관리자 페이지</h2>

<a href="<c:url value='/admin/register'/>">직원 등록</a>
<a href="<c:url value='/salary/list'/>">급여 목록</a>

<c:if test="${sessionScope.ROLE == 'ROLE_ADMIN'}">
    <table border="1">
        <thead>
        <tr>
            <th>사원ID</th>
            <th>이름</th>
            <th>성별</th>
            <th>전화번호</th>
            <th>부서ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="emp" items="${empList}">
            <tr>
                <td>${emp.empId}</td>
                <td>${emp.name}</td>
                <td>${emp.gender}</td>
                <td>${emp.phone}</td>
                <td>${emp.deptId}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html>
