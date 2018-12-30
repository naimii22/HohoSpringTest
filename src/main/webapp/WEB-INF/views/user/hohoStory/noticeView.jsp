<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>noticeView</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/noticeView.css" />
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
	<div class="container">
		<div class="row" id="wrap">
			<br>
			<font>공지사항 보기</font><br><br><br>
			<table class="table" id="font-arita">
				<tr>
					<th id="title">제목</th>
					<td>${notice.title}</td>
					<th id="rc">조회수</th>
					<td id="rc">${notice.hit}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"><pre>${notice.content}</pre></td>
				</tr>
			</table><br>
			<input type="button" class="btn btn-outline-success" value="목록" 
				onclick="location.href='${pageContext.request.contextPath}/user/hohoStory/notice.do'">
		</div>
	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>