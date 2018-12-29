<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>productCartList</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
	<div class="container">
		<h1 class="page-header">장바구니</h1>
		
		<!-- 장바구니 목록 시작 -->
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
		        	<tr>
		            	<th class="text-center" style="width: 100px">사진</th>
		            	<th class="text-center">이름</th>
		            	<th class="text-center" style="width: 120px">수량</th>
		            	<th class="text-center" style="width: 100px">금액</th>
		            	<th class="text-center" style="width: 120px">선택</th>
		        	</tr>
		    	</thead>
			    <tbody>
			    	<c:choose>
			    		<c:when test="${fn:length(documentList) > 0}">
			    			<c:forEach var="document" items="${documentList}">
			    				<tr>
						            <td class="text-center">${maxPageNo}</td>
						            <td>
						            	<c:url var="readUrl" value="/bbs/document_read.do">
						            		<c:param name="category" value="${document.category}" />
						            		<c:param name="document_id" value="${document.id}" />
						            	</c:url>
						            	<a href="${readUrl}">${document.subject}</a>
						            </td>
						            <td class="text-center">${document.writerName}</td>
						            <td class="text-center">${document.hit}</td>
						            <td class="text-center">${document.regDate }</td>
					        	</tr>
					        	<c:set var="maxPageNo" value="${maxPageNo-1}"/>
			    			</c:forEach>
			    		</c:when>
			    		<c:otherwise>
			    			<tr>
					            <td colspan="5" class="text-center" style="line-height: 100px;">장바구니에 담긴 상품이 없습니다.</td>
					        </tr>
			    		</c:otherwise>
			    	</c:choose>
			    </tbody>
			</table>
		</div>
		<!--// 장바구니 목록 끝 -->
		
		<!-- 결제 버튼 시작 -->
		<div class="clearfix">
		    <div class="pull-right">
		        <a href="${pageContext.request.contextPath}/bbs/document_write.do?category=${category}" class="btn btn-primary">
		        	<i class="glyphicon glyphicon-pencil"></i> 글쓰기
		        </a>
			</div>
		</div>
		<!--// 결제 버튼 시작 끝 -->
	</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>