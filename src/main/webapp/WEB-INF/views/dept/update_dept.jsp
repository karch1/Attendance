<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 8. 21.
  Time: 오후 6:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- 	부트스트랩 css  -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <!-- 	개발자 css -->
  <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div class="page mt3">
  <form id="addForm" name="addForm" method="post">
    <input type="hidden" name="deptId" value="<c:out value='${dept.deptId}' />">
    <div class="mb3">
      <label for="deptName" class="form-label">deptName</label>
      <input type="text"
             class="form-control"
             id="deptName"
             name="deptName"
             value="<c:out value='${dept.deptName}' />"
             placeholder="deptName" />
    </div>
    <div class="mb3">
      <label for="location" class="form-label">location</label>
      <input type="text"
             class="form-control"
             id="location"
             name="location"
             value="<c:out value='${dept.location}' />"
             placeholder="location" />
    </div>
    <div class="mb3">
      <button type="button"
              class="btn btn-warning"
              onclick="fn_save()"
      >수정</button>

      <button type="button"
              class="btn btn-danger"
              onclick="fn_delete()"
      >삭제</button>
    </div>
  </form>
</div>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!-- 유효성체크 플러그인 -->
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.21.0/dist/jquery.validate.min.js"></script>
<script src="/js/dept/dept-validation-config.js"></script>

<script type="text/javascript">
  function fn_save() {
    $("#addForm").attr("action",'/dept/edit')
            .submit();
  }

  function fn_delete() {
    $("#addForm").attr("action",'/dept/delete')
            .submit();
  }
</script>
</body>
</html>
