<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 시큐리티 태그 --%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="<c:url value='/images/simple-coding.png'/>" width="20" height="20"/>
            simple-coding
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        부서
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value='/dept'/>">Dept</a></li>
                        <li><a class="dropdown-item" href="<c:url value='/dept/addition'/>">Add Dept</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        사원(퀴즈)
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value='/emp'/>">Emp</a></li>
                        <li><a class="dropdown-item" href="<c:url value='/emp/addition'/>">Add Emp</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Faq(마무리퀴즈)
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value='/faq'/>">Faq</a></li>
                        <li><a class="dropdown-item" href="<c:url value='/faq/addition'/>">Add Faq</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        fileDb
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value='/fileDb'/>">fileDb</a></li>
                        <li><a class="dropdown-item" href="<c:url value='/fileDb/addition'/>">Add fileDb</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        gallery
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="<c:url value='/gallery'/>">gallery</a></li>
                        <li><a class="dropdown-item" href="<c:url value='/gallery/addition'/>">Add gallery</a></li>
                    </ul>
                </li>
            </ul>

            <!-- 메뉴(오른쪽) -->
            <ul class="navbar-nav">
                <!-- {/* TODO: 로그인 시작 */} -->
                <!-- ROLE_ADMIN 권한이 있으면 메뉴을 보이고, 없으면 안보임 -->
                <sec:authorize access="hasAuthority('ROLE_ADMIN')">
                    <%-- authorize(권한,인가), authentication(인증,로그인) --%>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/admin/register">회원가입(권한등록)</a>
                    </li>
                </sec:authorize>

                <!-- 로그인 안 한 사람만 메뉴가 보이고, 아니면 안보임 -->
                <sec:authorize access="isAnonymous()">
                    <li class="nav-item">
                        <a class="nav-link active" href="/auth/register"> 회원가입 </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/auth/login"> 로그인 </a>
                    </li>
                </sec:authorize>

                <!-- {/* 로그인 끝 */} -->

                <!-- {/* 로그아웃 시작 */} -->
                <!-- 로그인(인증) 한 사람만 메뉴가 보이고, 아니면 안보임 -->
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                            <%-- 로그인/로그아웃 모두 post 방식을 꼭 사용해야 한다 --%>
                            <%-- 로그인에서 post 방식일 경우 : csrf 공격 방어(csrf input 태그 넣기) --%>
                        <form action="/auth/logout" method="post">
                            <button type="submit" class="btn">Logout</button>
                                <%-- csrf 공격 : 방어를 위해 csrf 인증토큰이 필요(Post방식에는 모두 넣을것!) --%>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </li>
                </sec:authorize>
                <!-- {/* 로그아웃 끝 */} -->
            </ul>
        </div>
    </div>
</nav>
