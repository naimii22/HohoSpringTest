<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/reviewView.css" />
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>title</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
	<div class="container">
    	<h1>후기 상세</h1>
    	<hr>
    	<!-- 리뷰 시작 -->
    	<div class="review">
	    	<div class="row">
	    		<div class="col-sm-2 col-md-2"> 제 목 </div>
	    		<div class="col-sm-2 col-md-2">제목여기다가 뽑아오기</div>
	    		<div class="col-sm-4 col-md-4 pull-right">
	    			<a href="#" class="btn btn-primary">수 정</a>
	    			<a href="#" class="btn btn-primary">삭 제</a>
	    		</div>
	    	</div>
	    	<div class="row">
	    		<div class="col-sm-2 col-md-2">작 성 자</div>
	    		<div class="col-sm-2 col-md-2 text-left">바 켸 련</div>
	    		<div class="col-sm-2 col-md-2">작 성 날 짜</div>
	    		<div class="col-sm-3 col-md-3 text-left">2012-02-05</div>
	    		<div class="col-sm-2 col-md-2 text-right">조 회 수</div>
	    		<div class="col-sm-1 col-md-1 text-left">1</div>
	    	</div>
	    	<div class="image">
	    		<img src="">
	    	</div>
	    	<div class="row">
	    		<div class="col-sm-2 col-md-2">내 용</div>
	    	</div>
	    	<div class="row">
	    		<p>내용은 여기다가 보여주기</p>
	    	</div>
	    </div>
	    <!-- 리뷰 끝 -->
	    
	    <!-- 댓글 시작 -->
	    <!-- 댓글 끝 -->
    </div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>