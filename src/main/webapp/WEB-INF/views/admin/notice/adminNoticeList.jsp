<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>adminNoticeList</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbarAdmin.jsp" %>
	
	<div class="container">
		<h1 class="page-header">공지사항 관리</h1>
			
		<!-- 글 목록 시작 -->
		<div class="table-responsive">
			<table class="table table-hover">
			    <thead>
			    	<tr>
			    		<td>
			    			<input type="button" class="btn btn-outline-success" value="공지사항 작성" 
			    				onclick="location.href='${pageContext.request.contextPath}/admin/notice/adminNoticeWrite.do'">
			    		</td>
			    	</tr>
			        <tr>
			            <th class="text-center" style="width: 100px">번호</th>
			            <th class="text-center">제목</th>
			            <th class="text-center" style="width: 100px">조회수</th>
			        </tr>
			    </thead>
			    <tbody>
			    	<c:choose>
			    		<c:when test="${fn:length(noticeList) > 0}">
			    			<c:forEach var="notice" items="${noticeList}">
			    				<tr>
						            <td class="text-center">${maxPageNo}</td>
						            <td>
						            	<c:url var="viewURL" value="/admin/notice/adminNoticeView.do">
						            		<c:param name="notice_id" value="${notice.id}" />
						            	</c:url>
						            	<a href="${viewURL}">${notice.title}</a>
						            </td>
						            <td class="text-center">${notice.hit}</td>
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
		
		<!-- 공지사항 목록 페이지 번호 include -->
		<%@ include file="/WEB-INF/inc/noticePageNumber.jsp" %>
	</div>
	
</body>
</html>