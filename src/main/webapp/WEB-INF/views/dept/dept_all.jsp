<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25. 8. 19.
  Time: 오전 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 	부트스트랩 css  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <!-- 	개발자 css -->
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div class="page mt3">
    <form id="listForm" name="listForm" method="get">
        <!-- 수정페이지 열기때문에 필요 -->
        <input type="hidden" id="deptId" name="deptId">
        <!-- TODO: 컨트롤러로 보낼 페이지번호 -->
        <input type="hidden" id="page" name="page" value="0">

        <!-- jsp -> 컨트롤러(검색어): input 태그의 name 속성을 이용 -->
        <div class="input-group mb3 mt3">
            <input type="text"
                   class="form-control"
                   id="searchKeyword"
                   name="searchKeyword"
                   placeholder="부서명입력"
                   value="${param.searchKeyword}"
            >
            <button type="button"
                    class="btn btn-primary"
                    onclick="fn_egov_link_page(0)"
            >
                검색
            </button>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">deptId</th>
                <th scope="col">deptName</th>
                <th scope="col">location</th>
            </tr>
            </thead>
            <tbody>
            <!-- 반복문 -->
            <c:forEach var="data" items="${depts}">
                <tr>
                    <td>
                        <a href="/dept/edition?deptId=${data.deptId}">
                            <c:out value="${data.deptId}"></c:out>
                        </a>

                    </td>
                    <td><c:out value="${data.deptName}"></c:out></td>
                    <td><c:out value="${data.location}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:if test="${empty depts}">
            데이터가 없습니다.
        </c:if>
        <!-- 여기: 페이지번호 -->
        <div class="flex-center">
            <ul class="pagination" id="pagination"></ul>
        </div>
    </form>
</div>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>

<script>
    function fn_egov_link_page(page) {
        $("#page").val(page);
        $("#listForm").attr("action", "/dept")
            .submit();
    }
</script>

<!-- TODO: 페이징 라이브러리(CDN 사용) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js"></script>
<script type="text/javascript">
    /* 페이징 처리 */
    $('#pagination').twbsPagination({
        totalPages: ${pages.totalPages},
        startPage:${pages.number+1},            // 프론트 현재페이지: 첫페이지번호(벡엔드: 0, 프론트: 1)
        visiblePages: ${pages.size},
        initiateStartPageClick: false,
        onPageClick: function (event, page) {
            fn_egov_link_page(page - 1)           // 벡엔드 현재페이지: 벡엔드는 -1 해서 전송합니다.
        }
    });
</script>
</body>
</html>
