<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!-- 메뉴바 -->
<div class="navbar navbar-default">
	<div class="container">
		<!-- 로고 영역 -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>	
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<!-- //반응형 메뉴 버튼 -->
			<!-- 로고 -->
			<a class="navbar-brand" href="${pageContext.request.contextPath}/index.do">Hoho's bakery</a>
		</div>
		<!-- //로고 영역 -->
		<!-- 메뉴 영역 -->
		<div class="navbar-collapse collapse">
			<!-- 사이트 메뉴 -->
			<ul class="nav navbar-nav">
				<li><a href="#">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/user/hohoStory/companyInfo.do">HOHO Story</a></li>
				<li><a href="${pageContext.request.contextPath}/user/taste/taste.do">Taste</a></li>
				<li><a href="${pageContext.request.contextPath}/user/qna/qna.do">Q&A</a></li>
			</ul>
			<!-- //사이트 메뉴 -->
			<!-- 로그인 메뉴 -->
			<c:choose>
				<c:when test="${loginInfo==null }">
					<div class="navbar-right">
						<a href="${pageContext.request.contextPath}/user/login/login.do" class="btn btn-outline-primary">Login</a>
						<a href="#" class="btn btn-outline-primary">Sign Up</a>
					</div>
				</c:when>
				<c:otherwise>
					<!-- 로그인 된 경우 -->
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"
							style="padding:5px;">

							${loginInfo.name}님 <span class="caret"></span>
							</a>
							<!-- 로그인 한 경우 표시될 메뉴 -->
							<ul class="dropdown-menu">
								<li><a href="#">로그아웃</a></li>
								<li><a href="#">회원정보 수정</a></li>
								<li><a href="#">회원탈퇴</a></li>
							</ul>
						</li>
					</ul>
					<!-- //로그인 된 경우 -->
				</c:otherwise>
			</c:choose>
		</div>
		<!-- //메뉴 영역 -->
	</div>
</div>
<!-- //메뉴바 -->