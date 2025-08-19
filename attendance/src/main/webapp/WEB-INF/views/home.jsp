<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 	부트스트랩 css  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <!-- 	개발자 css -->
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<jsp:include page="/common/header.jsp" />
<div class="container mt-5">
    <div class="row">
        <div class="col-md-8">
            <h2>오늘 출근 기록</h2>
            <div class="attendance-summary p-3 border rounded">
                <p>총 출근: 5명</p>
                <p>결근: 1명</p>
            </div>
        </div>
        <div class="col-md-4">
            <h2>급여 알림</h2>
            <div class="salary-summary p-3 border rounded">
                <p>이번 달 지급: 5명</p>
                <p>총액: 16,000,000원</p>
            </div>
        </div>
    </div>
</div>

<br><br><br><br><br><br>

<div class="card text-center mt-3">
    <div class="card-header">
        휴가 현황
    </div>
    <div class="card-body">
        <h5 class="card-title">승인 대기: 2명</h5>
        <p class="card-text">연차: 3명, 병가: 1명</p>
        <a href="#" class="btn btn-primary">자세히 보기</a>
    </div>
</div>
<br><br><br><br><br><br>

<canvas id="attendanceChart" width="400" height="200"></canvas>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
    const ctx = document.getElementById('attendanceChart').getContext('2d');
    const attendanceChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['월', '화', '수', '목', '금'],
            datasets: [{
                label: '출근 인원',
                data: [5, 4, 5, 5, 3],
                backgroundColor: 'rgba(54, 162, 235, 0.7)'
            }]
        },
        options: {
            responsive: true,
            plugins: { legend: { position: 'top' } }
        }
    });
</script>
<!-- 꼬리말 -->
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- 부트스트랩 js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<jsp:include page="/common/footer.jsp" />
</body>
</html>