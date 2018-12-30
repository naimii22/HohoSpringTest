<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>title</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbarAdmin.jsp" %>
	
	<div class="container">
		<h1 class="page-header">공지사항 작성</h1>
	
		<form class="form-horizontal" method="post"
			action="${pageContext.request.contextPath}/admin/notice/adminNoticeWrite_ok.do">
		
			<!-- 제목 -->
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">제목</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title" />
				</div>
			</div>
			
			<!-- 내용 -->
			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">내용</label>
				<div class="col-sm-10">
					<textarea id="content" name="content" class="ckeditor"></textarea>
				</div>
			</div>
			
			<!-- 버튼들 -->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">저장하기</button>
					<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/admin/notice/adminNoticeList.do'">목록</button>
					<button type="button" class="btn btn-danger" onclick="history.back();">작성취소</button>
				</div>
			</div>
			
		</form>
	</div>
	
</body>
</html>