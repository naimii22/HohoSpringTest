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
		<h1 class="page-header">공지사항 상세보기</h1>
			
		<!-- 제목, 조회수 -->
		<div class="alert alert-info">
			<h3 style="margin: 0">
			    ${readNotice.title} &nbsp; <small> / 조회수 : ${readNotice.hit}</small>
			</h3>
		</div>
		
		<!-- 내용 -->
		<section style="padding: 0 10px 20px 10px">
			${readNotice.content}
		</section>
			
		<!-- 다음글/이전글 -->
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th class="success" style="width: 100px">다음글</th>
					<td>
						<c:choose>
							<c:when test="${nextNotice != null}">
								<c:url var="nextUrl" value="/admin/notice/adminNoticeView.do">
									<c:param name="notice_id" value="${nextNotice.id}" />
								</c:url>
								<a href="${nextUrl}">${nextNotice.title}</a>
							</c:when>
							<c:otherwise>
								다음글이 없습니다.
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<th class="success" style="width: 100px">이전글</th>
					<td>
						<c:choose>
							<c:when test="${prevNotice != null}">
								<c:url var="prevUrl" value="/admin/notice/adminNoticeView.do">
									<c:param name="notice_id" value="${prevNotice.id}" />
								</c:url>
								<a href="${prevUrl}">${prevNotice.title}</a>
							</c:when>
							<c:otherwise>
								이전글이 없습니다.
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</tbody>
		</table>
			
		<!-- 버튼 -->
		<div class="clearfix">
			<div class="pull-right">
				<a href="${pageContext.request.contextPath}/admin/notice/adminNoticeUpdate.do" 
					class="btn btn-info">수정</a>
				<a href="${pageContext.request.contextPath} 삭제 모달 넣기" 
					class="btn btn-info">삭제</a>
				<a href="${pageContext.request.contextPath}/admin/notice/adminNoticeList.do" 
					class="btn btn-info">목록</a>
			</div>
		</div>
	</div>
</body>
</html>