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
		<h1 class="page-header">제품 리스트</h1>
			
		<!-- 글 목록 시작 -->
		<div class="table-responsive">
			<table class="table table-hover">
			    <thead>
			    	<tr>
			    		<td>
			    			<input type="button" class="btn btn-outline-success" value="제품 추가" 
			    				onclick="location.href='${pageContext.request.contextPath}/admin/product/adminProductWrite.do'">
			    		</td>
			    	</tr>
			        <tr>
			            <th class="text-center" style="width: 100px">번호</th>
			            <th class="text-center">이름</th>
			            <th class="text-center">가격</th>
			            <th class="text-center">사진</th>
			            <th class="text-center">종류</th>
			            <th class="text-center" style="width: 100px"> </th>
			            <th class="text-center" style="width: 100px"> </th>
			        </tr>
			    </thead>
			    <tbody>
			    	<c:choose>
			    		<c:when test="${fn:length(productList) > 0}">
			    			<c:forEach var="product" items="${productList}">
			    				<tr>
						            <td class="text-center">${maxPageNo}</td>
						            <td class="text-center">${product.name}</td>
						            <td class="text-center">${product.price}</td>
						            <td class="text-center">${product.image}</td>
						            <td class="text-center">${product.type}</td>
						            <td class="text-center">
						            	<c:url var="viewURL" value="/admin/product/adminProductUpdate.do">
						            		<c:param name="product_id" value="${product.id}" />
						            	</c:url>
						            	<a href="${viewURL}">제품수정</a>
						            </td>
						            <td class="text-center">
						            	<c:url var="viewURL" value="/admin/product/adminProductDelete.do">
						            		<c:param name="product_id" value="${product.id}" />
						            	</c:url>
						            	<a href="${viewURL}">제품삭제</a>
						            </td>						       
					        	</tr>
					        	<c:set var="maxPageNo" value="${maxPageNo-1}"/>
			    			</c:forEach>
			    		</c:when>
			    		<c:otherwise>
			    			<tr>
					            <td colspan="5" class="text-center" style="line-height: 100px;">
					               	준비된 제품이 없습니다.
					            </td>
					        </tr>
			    		</c:otherwise>
			    	</c:choose>
			    </tbody>
			</table>
		</div>
		<!--// 글 목록 끝 -->
		
		<!-- 공지사항 목록 페이지 번호 include -->
		<%@ include file="/WEB-INF/inc/paging/adminProductPageNumber.jsp" %>
	</div>
	
</body>
</html>