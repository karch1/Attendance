<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>내 급여 내역</title>
</head>
<body>
<h2>${salaryList[0].emp.name} 님의 급여 내역</h2>

<table border="1">
  <thead>
  <tr>
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
      <td><fmt:formatDate value="${salary.payDate}" pattern="yyyy-MM-dd"/></td>
      <td><fmt:formatNumber value="${salary.baseSalary}" type="currency"/></td>
      <td><fmt:formatNumber value="${salary.bonus}" type="currency"/></td>
      <td><fmt:formatNumber value="${salary.withholding}" type="currency"/></td>
      <td><fmt:formatNumber value="${salary.netPay}" type="currency"/></td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>
