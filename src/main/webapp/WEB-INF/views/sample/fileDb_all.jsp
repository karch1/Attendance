<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--    부트스트랩 css  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <!--    개발자 css -->
    <link rel="stylesheet" href="/css/style.css">

</head>
<body>
<jsp:include page="/common/header.jsp"/>
${fileDbs} : 데이터 <br>
${pages.totalPages} : 총페이지수 <br>
${pages.number} : 현재페이지번호 <br>
${pages.size} : 화면에 보일개수 <br>
<form class="page mt3" id="listForm" name="listForm" method="get">
    <%-- uuid는 벡엔드로 전송 --%>
    <input type="hidden" id="uuid" name="uuid">
    <%--     TODO: 컨트롤러로 page(현재페이지번호) 값 전송    --%>
    <input type="hidden" id="page" name="page" value="0">
    <div class="input-group mb3 mt3">
        <input type="text"
               class="form-control"
               id="searchKeyword"
               name="searchKeyword"
               value="${param.searchKeyword}"
               placeholder="검색어입력">
        <button class="btn btn-primary"
                type="button"
                onclick="fn_egov_link_page(0)"
        >
            검색
        </button>
    </div>

    <!-- 카드 디자인: 반복문 -->
    <c:forEach var="data" items="${fileDbs}">
        <div class="col3">
            <div class="card">
                <img src="<c:out value="${data.fileUrl}"/>" class="card-img-top"
                     alt="이미지">
                <div class="card-body">
                    <h5 class="card-title"><c:out value="${data.fileTitle}"/></h5>
                    <p class="card-text"><c:out value="${data.fileContent}"/></p>
                    <a href="#" class="btn btn-danger" onclick="fn_delete('${data.uuid}')"
                    >삭제</a>
                </div>
            </div>
        </div>
    </c:forEach>

    <!-- 여기: 페이지번호 -->
    <div class="flex-center clear">
        <ul class="pagination" id="pagination"></ul>
    </div>
</form>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
<%-- 안녕하세요 ㅋㅋ --%>

<script>
    <%--  전체조회  --%>

    function fn_egov_link_page(page) {
        $("#page").val(page);        // input 태그 id=page 이 값이 컨트롤러로 전송됨
        // 의미: listForm 태그를 선택해서 속성 action 값을 /fileDb 변경
        $("#listForm").attr("action", "/fileDb")
            .submit();               // 이 때 컨트롤로로 값이 전송됨
    }

    <%-- 삭제 --%>
    function fn_delete(uuid) {
        $("#uuid").val(uuid);                       // input태그에 uuid 값 넣어서 벡엔드로 보내기
        $("#listForm").attr("action", "/fileDb/delete")
            .attr("method", "post")                 // method 변경 : post
            .submit();
    }
</script>

<%-- 여기 --%>
<!-- 페이징 라이브러리 -->
<script src="/js/jquery.twbsPagination.js" type="text/javascript"></script>

<script type="text/javascript">
    /* 페이징 처리 */
    $('#pagination').twbsPagination({
        totalPages: ${pages.totalPages}, // 총페이지수
        startPage:  ${pages.number+1},   // 첫페이지번호(벡엔드: 0, 프론트: 1)
        visiblePages: ${pages.size},     // 화면에 보일 개수
        initiateStartPageClick: false,
        onPageClick: function (event, page) {  // page(프론트의 현재페이지번호)
            /* 재조회 함수 실행: 벡엔드로 전송(page-1해서) */
            fn_egov_link_page(page - 1)
        }
    });
</script>

<jsp:include page="/common/footer.jsp"/>

</body>
</html>