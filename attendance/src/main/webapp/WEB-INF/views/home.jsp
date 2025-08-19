<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 	부트스트랩 css  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <!-- FullCalendar CSS: 달력 스타일 제공 -->
    <link href="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.4/index.global.min.css" rel="stylesheet">
    <!-- 	개발자 css -->
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<jsp:include page="/common/header.jsp"/>
<div class="page">

    <div class="container mt-5">
        <!-- ================= 달력 섹션 ================= -->
        <div class="row mb-4">
            <div class="col-md-12">
                <!-- FullCalendar 달력 표시 -->
                <div id="calendar"></div>
            </div>
        </div>
        <!-- ================= 카드 섹션 ================= -->
        <div class="row mb-4">
            <!-- 출퇴근 카드 -->
            <div class="col-md-4">
                <div class="card text-center">
                    <div class="card-header">출퇴근 현황</div>
                    <div class="card-body">
                        <h5 class="card-title">오늘 출근: 5명</h5>
                        <p class="card-text">결근: 1명</p>
                        <a href="#" class="btn btn-primary">자세히 보기</a>
                    </div>
                </div>
            </div>

            <!-- 급여 카드 -->
            <div class="col-md-4">
                <div class="card text-center">
                    <div class="card-header">급여 알림</div>
                    <div class="card-body">
                        <h5 class="card-title">이번 달 지급: 5명</h5>
                        <p class="card-text">총액: 16,000,000원</p>
                        <a href="#" class="btn btn-primary">자세히 보기</a>
                    </div>
                </div>
            </div>

            <!-- 휴가 카드 -->
            <div class="col-md-4">
                <div class="card text-center">
                    <div class="card-header">휴가 현황</div>
                    <div class="card-body">
                        <h5 class="card-title">승인 대기: 2명</h5>
                        <p class="card-text">연차: 3명, 병가: 1명</p>
                        <a href="#" class="btn btn-primary">자세히 보기</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- ================= 차트 섹션 ================= -->
        <div class="row mb-4">
            <div class="col-md-12">
                <!-- Chart.js로 출근 인원 시각화 -->
                <canvas id="attendanceChart" height="100"></canvas>
            </div>
        </div>
    </div>
</div>
<br><br>

<!-- ================= JS 불러오기 (순서 바뀌면 충돌 일어남) ================= -->
<!-- jQuery: Bootstrap JS와 호환 위해 필요 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<!-- Bootstrap JS: 메뉴, 모달 등 동적 기능 제공 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- Chart.js: 그래프 시각화 라이브러리 -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<!-- FullCalendar JS: 달력 기능 제공 -->
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.4/index.global.min.js"></script>

<script>
    // ================= Chart.js 바 차트 =================
    const ctx = document.getElementById('attendanceChart').getContext('2d');
    const attendanceChart = new Chart(ctx, {
        type: 'bar', // 막대 그래프
        data: {
            labels: ['월','화','수','목','금'], // X축 라벨
            datasets: [{
                label: '출근 인원', // 그래프 제목
                data: [5,4,5,5,3], // 각 요일별 데이터
                backgroundColor: 'rgba(54,162,235,0.7)' // 막대 색상
            }]
        },
        options: {
            responsive: true, // 화면 크기 따라 자동 조정
            plugins: { legend: { position: 'top' } } // 범례 위치
        }
    });

    // ================= FullCalendar 달력 =================
    document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
            initialView: 'dayGridMonth', // 월간 달력
            height: 500, // 달력 높이
            headerToolbar: { // 상단 툴바 구성
                left: 'prev,next today',
                center: 'title',
                right: 'dayGridMonth,timeGridWeek,timeGridDay'
            },
            events: [
                { title: '출근', start: '2025-08-01', color: 'green' },
                { title: '휴가', start: '2025-08-05', end: '2025-08-07', color: 'red' },
                { title: '결근', start: '2025-08-03', color: 'gray' }
            ]
        });
        calendar.render(); // 달력 화면에 표시
    });
</script>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>