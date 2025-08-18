<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--    부트스트랩 css  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <!--    개발자 css -->
    <link rel="stylesheet" href="/css/style.css">


</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div class="page mt3">
<%--  enctype="multipart/form-data" : 첨부파일을 벡엔드로 보낸다는 표시  --%>
    <form id="addForm"
          name="addForm"
          method="post"
          enctype="multipart/form-data"
    >
        <div class="mb3">
            <label for="fileTitle" class="form-label">fileTitle</label>
            <input
                    class="form-control"
                    id="fileTitle"
                    name="fileTitle"
                    placeholder="제목" />
        </div>
        <div class="mb3">
            <label for="fileContent" class="form-label">fileContent</label>
            <input type="text"
                   class="form-control"
                   id="fileContent"
                   name="fileContent"
                   placeholder="내용입력" />
        </div>
        <div class="input-group">
            <input type="file"
                   id="image"
                   name="image"
                   class="form-control"
            >
            <button class="btn btn-primary"
                    type="button"
                    onclick="fn_save()"
            >저장</button>
        </div>
    </form>
</div>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<script>
    function fn_save() {
        /* 의미: addForm 태그를 선택해서 속성 action 의 값을 /fileDb/add 변경 */
        $("#addForm").attr("action","/fileDb/add")
            .submit();                      // 실제 컨트롤러로 전송
    }
</script>

<jsp:include page="/common/footer.jsp"/>
</body>
</html>
