<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Employees</title></head>
<body>
<h2>직원 목록</h2>
<table border="1">
    <tr>
        <th>사원번호</th>
        <th>이름</th>
        <th>성별</th>
        <th>전화번호</th>
        <th>부서번호</th>
    </tr>
    <c:forEach var="emp" items="${empList}">
        <tr>
            <td>${emp.empId}</td>
            <td>${emp.name}</td>
            <td>${emp.gender}</td>
            <td>${emp.phone}</td>
            <td>${emp.deptId}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
