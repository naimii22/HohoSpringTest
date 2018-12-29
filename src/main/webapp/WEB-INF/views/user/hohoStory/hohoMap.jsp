<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>hohoMap</title>
	<!-- css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/companyInfo.css">
	<!-- map javascript -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/map.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bd1d3e09d61eabe1a970739f5d7de6ad"></script>
</head>

<body onload="map()">
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
	<div class="container">
		<div class="row" id="wrap">
			<h1 class="font">오시는 길</h1>
				<div id="map" style="width:700px;height:400px;"></div><br>
				<span id="span-text-style">강남역10번출구150M직진 > 스킨푸드옆 아리따움건물13층 또는 신논현역6번출구50M직진 > 아리따움건물13층</span>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>