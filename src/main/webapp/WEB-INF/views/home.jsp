<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<meta charset='utf-8' />
	<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
	<title>Home</title>
	<!-- Bootstrap + jQuery -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!--// Bootstrap + jQuery -->
</head>
<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>

<h3>Test</h3>
<a href="${pageContext.request.contextPath}/user/hohoStory/companyInfo.do">회사정보</a><br>
<a href="${pageContext.request.contextPath}/user/hohoStory/hohoMap.do">지도</a><br>
<a href="${pageContext.request.contextPath}/user/hohoStory/staffInfo.do">직원정보</a><br>
<a href="${pageContext.request.contextPath}/user/hohoStory/notice.do">공지사항</a><br>
<a href="${pageContext.request.contextPath}/user/hohoStory/noticeView.do">공지 상세보기</a><br>
<hr/>
<a href="${pageContext.request.contextPath}/user/qna/qna.do">Q & A</a><br>

</body>
</html>
