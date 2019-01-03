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
		<h1 class="page-header">공지사항 수정</h1>
	
		<form class="form-horizontal" method="post"
			action="${pageContext.request.contextPath}/admin/notice/adminNoticeUpdate_ok.do">
		
			<!-- 수정 대상에 대한 상태유지 -->
			<input type="hidden" name="product_id" value="${readProduct.id}" />
			
			<!-- 제품명 -->
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">제품명</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name" value="${readProduct.name}" />
				</div>
			</div>
			
			<!-- 제품 종류 선택 -->
			<div class="form-group">
				<label for="type" class="col-sm-2 control-label">제품 종류</label>
				<div class="col-sm-10">
					<select name="type" id="type">
						<option value="">-- 제품종류선택 --</option>
						<option value=1 <c:if test="${readProduct.type == 1}">selected</c:if>>케이크</option>
						<option value=2	<c:if test="${readProduct.type == 2}">selected</c:if>>빵</option>
						<option value=3	<c:if test="${readProduct.type == 3}">selected</c:if>>음료</option>
					</select>
				</div>
			</div>
			
			<!-- 가격 -->
			<div class="form-group">
				<label for="price" class="col-sm-2 control-label">가격</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="price" name="price" value="${readProduct.price}"/>
				</div>
			</div>
			
			<!-- 내용 -->
			<div class="form-group">
				<label for="info" class="col-sm-2 control-label">제품 설명</label>
				<div class="col-sm-10">
					<textarea id="info" name="info" class="ckeditor">${readProduct.info}</textarea>
				</div>
			</div>
			
			<!-- 사진 업로드 -->
			<div class="form-group">
				<label for="file" class="col-sm-2 control-label">파일첨부</label>
				<div class="col-sm-10">
					<input type="file" class="form-control" id="file" name="file" multiple />
					
					<!-- 첨부파일 리스트가 존재할 경우만 삭제할 항목 선택 가능 -->
					<c:if test="${fileList != null}">
						<c:forEach var="file" items="${fileList}">
		            		<!-- 이미지를 다운받기 위한 URL 구성 -->
			            	<c:url value="/download.do" var="downloadUrl">
			            		<c:param name="file" value="${file.fileDir}/${file.fileName}" />
			            	</c:url>
			            	<div>${file.originName}</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
			
			<!-- 버튼들 -->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">저장하기</button>
					<button type="button" class="btn btn-primary" 
						onclick="location.href='${pageContext.request.contextPath}/admin/product/adminProductList.do'">목록</button>
					<button type="button" class="btn btn-danger" onclick="history.back();">작성취소</button>
				</div>
			</div>
			
		</form>
	</div>
	
</body>
</html>