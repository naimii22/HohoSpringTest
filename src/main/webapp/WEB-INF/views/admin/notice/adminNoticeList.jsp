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
	<link href="${pageContext.request.contextPath}/assets/css/noticeList.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbarAdmin.jsp" %>
	
	<div class="container">
		<div class="row" id="wrap">
			<h1 id="font-BM">공&nbsp;지&nbsp;사&nbsp;항</h1><br>
			<input type="button" id="adminNotice" class="btn btn-outline-success" value="공지사항 작성" onclick="location.href='BakeryServlet?command=adminNoticeWriteForm'">
			<table class="table table-hover">
				<thead class="none-hover">
					<tr id="font-Arita">
						<th class="width-200">번호</th>
						<th class="align-left-55">제목</th>
						<th class="width-200">조회수</th>
					</tr>
				</thead>
				<c:forEach var="notice" items="${noticeList}">
					<tbody>
						<tr id="font-Arita">
							<td>${notice.id}</td>
							<td class="align-left">
								<a href="${pageContext.request.contextPath}/user/hohoStory/noticeView.do">${notice.title}</a>
							</td>
							<td>${notice.hit}</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</div><br><br><br>
</body>
</html>