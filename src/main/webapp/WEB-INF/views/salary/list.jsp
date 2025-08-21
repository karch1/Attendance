<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>급여 목록</title>
</head>
<body>
<h2>급여 목록</h2>

<a href="<c:url value='/salary/register'/>">급여 등록</a>

<table border="1">
    <thead>
    <tr>
        <th>사원 이름</th>
        <th>지급일</th>
        <th>기본급</th>
        <th>상여</th>
        <th>공제</th>
        <th>총 급여</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="salary" items="${salaryList}">
        <tr>
            <td>${salary.emp.name}</td>
            <td>${salary.payDate}</td>
            <td>${salary.baseSalary}</td>
            <td>${salary.bonus}</td>
            <td>${salary.withholding}</td>
            <td>${salary.netPay}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<a href="<c:url value='/admin'/>">관리자 홈으로 돌아가기</a>
</body>
</html>
