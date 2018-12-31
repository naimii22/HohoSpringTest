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
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
<div class="container">
	<h1 class="page-header">후기 수정</h1>

	<form class="form-horizontal" enctype="multipart/form-data" id="review_update_form" method="post" 
								action="${pageContext.request.contextPath}/user/review/reviewUpdateOk.do">
		<input type="hidden" name="review_id" value="${review.id }">
		<input type="hidden" name="user_id" value="${user_id}">
		<!-- 제목 -->
		<div class="form-group">
			<label for="subject" class="col-md-1 control-label">글 제목</label>
			<div class="col-md-11">
				<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력하세요." value="${review.title}" >
			</div>
		</div>
		
		<div class="form-group">
			<label for="content" class="col-md-1 control-label">내 용</label>
			<div class="col-md-11">
				<textarea class="form-control ckeditor" name="content" id="content" rows="10">${review.content}</textarea>
			</div>
		</div>
		<div class="form-group">
			<label for="image" class="col-md-1 control-label">이 미 지</label>
			<div class="col-md-3">
				<input class="form-control" type="file" name="image" id="image"/>
			</div>
			<em style="color: red;">* 이미지 변경을 원할 경우에만 선택</em>
		</div>
		
		<div class="form-group">
			<label for="image" class="col-md-1 control-label">별 점</label>
			<div class="col-md-11">
				<div class="form-control">별점어쩔</div>
			</div>
		</div>

		<div class="pull-right">
			<button type="submit" class="btn btn-danger">수정</button>
			<button type="button" class="btn btn-default">취소</button>
		</div>
	</form>
</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>