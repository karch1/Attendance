<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>급여 등록</title>
</head>
<body>
<h2>급여 등록</h2>

<form action="${pageContext.request.contextPath}/salary/register" method="post">
    <table>
        <tr>
            <td>사원 선택</td>
            <td>
                <select name="empId" required>
                    <c:forEach var="emp" items="${empList}">
                        <option value="${emp.empId}">${emp.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>지급일</td>
            <td><input type="date" name="payDate" required></td>
        </tr>
        <tr>
            <td>기본급</td>
            <td><input type="number" name="baseSalary" required></td>
        </tr>
        <tr>
            <td>상여</td>
            <td><input type="number" name="bonus" value="0"></td>
        </tr>
        <tr>
            <td>공제</td>
            <td><input type="number" name="withholding" value="0"></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">등록</button>
            </td>
        </tr>
    </table>
</form>

<a href="${pageContext.request.contextPath}/salary/list">목록으로 돌아가기</a>

</body>
</html>
