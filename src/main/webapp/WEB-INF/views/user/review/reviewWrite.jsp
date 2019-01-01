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
	<form action="${pageContext.request.contextPath}/user/review/reviewWriteOk.do">
		<textarea class="form-control" rows="3"></textarea>
	</form>
</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>