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
		<h1 class="page-header">주문 리스트</h1>
			
		<!-- 글 목록 시작 -->
		<div class="table-responsive">
			<table class="table table-hover">
			    <thead>
			        <tr>
			            <th class="text-center" style="width: 100px">주문번호</th>
			            <th class="text-center">주문자</th>
			            <th class="text-center">주문날짜</th>
			            <th class="text-center">결제금액</th>
			            <th class="text-center">주문상태</th>
			        </tr>
			    </thead>
			    <tbody>
			    	<c:choose>
			    		<c:when test="${fn:length(orderList) > 0}">
			    			<c:forEach var="order" items="${orderList}">
			    				<tr>
						            <td class="text-center">${maxPageNo}</td>
						            <td class="text-center">${order.id}</td>
						            <td></td>
						            <!-- <td class="text-center">${member.name}</td> -->
						            <td class="text-center">${order.reg_date}</td>
						            <td class="text-center">${order.total}</td>
						            <td class="text-center">
						            	<a href="#" class="btn btn-info">결제완료</a>
						            	<a href="#" class="btn btn-info">주문취소</a>
						            	<a href="#" class="btn btn-info">최종완료</a>
						            </td>
					        	</tr>
					        	<c:set var="maxPageNo" value="${maxPageNo-1}"/>
			    			</c:forEach>
			    		</c:when>
			    		<c:otherwise>
			    			<tr>
					            <td colspan="5" class="text-center" style="line-height: 100px;">
					               	조회된 글이 없습니다.
					            </td>
					        </tr>
			    		</c:otherwise>
			    	</c:choose>
			    </tbody>
			</table>
		</div>
		<!--// 글 목록 끝 -->
		
	</div>
	
</body>
</html>