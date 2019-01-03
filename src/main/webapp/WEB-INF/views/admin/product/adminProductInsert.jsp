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
			action="${pageContext.request.contextPath}/admin/notice/adminProductInsert_ok.do">
		
			<!-- 제품명 -->
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">제품명</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name" />
				</div>
			</div>
			
			<!-- 제품 종류 선택 -->
			<div class="form-group">
				<label for="type" class="col-sm-2 control-label">제품 종류</label>
				<div class="col-sm-10">
					<select name="type" id="type">
						<option value="" selected>-- 제품종류선택 --</option>
						<option value=1>케이크</option>
						<option value=2>빵</option>
						<option value=3>음료</option>
					</select>
				</div>
			</div>
			
			<!-- 가격 -->
			<div class="form-group">
				<label for="price" class="col-sm-2 control-label">가격</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="price" name="price" />
				</div>
			</div>
			
			<!-- 내용 -->
			<div class="form-group">
				<label for="info" class="col-sm-2 control-label">제품 설명</label>
				<div class="col-sm-10">
					<textarea id="info" name="info" class="ckeditor"></textarea>
				</div>
			</div>
			
			<!-- 사진 업로드 -->
			<div class="form-group">
				<label for="file" class="col-sm-2 control-label">제품 사진 선택</label>
				<div class="col-sm-10">
					<input type="file" class="form-control" id="file" name="file" multiple />
				</div>
			</div>
			
			<!-- 버튼들 -->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">저장하기</button>
					<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/admin/product/adminProductList.do'">목록</button>
					<button type="button" class="btn btn-danger" onclick="history.back();">작성취소</button>
				</div>
			</div>
			
		</form>
	</div>
	
</body>
</html>