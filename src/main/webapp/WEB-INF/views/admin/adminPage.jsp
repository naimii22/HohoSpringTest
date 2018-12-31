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
	
	<div>
		<a href="${pageContext.request.contextPath}/admin/member/adminMember_ok.do">회원관리</a><br>
		<a href="${pageContext.request.contextPath}/admin/order/adminOrderList.do">주문관리</a><br>
		<a href="${pageContext.request.contextPath}/admin/notice/adminNoticeList.do">공지관리</a><br>
	</div>
</body>
</html>