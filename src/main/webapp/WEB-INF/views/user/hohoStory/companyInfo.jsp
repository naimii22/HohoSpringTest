<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>companyInfo</title>
	<!-- css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/companyInfo.css">
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
	<h1>호호's 베이커리</h1>
	<table style="margin-top:20px; margin-bottom:50px;">
				<tr>
					<td><textarea rows="15" cols="15" readonly>    오븐에서 방금 꺼낸 빵이 가장 맛있다는 것을 알기에, 호호베이커리는 지금도 더욱 따뜻하고 촉촉한 갓 구운 빵을 제공하기 위해 끊임없이 노력합니다.
    갓 구워낸 빵은 고소한 향기와 따스한 온기로 매장을 가득 채우고, 고객들에게는 가장 맛있는 빵을 맛보는 행복을 선물합니다. 좋은 밀가루도 좋은 빵의 맛을 내는 중요한 요소입니다. 
    호호베이커리는 호호제일제당의 깐깐한 60년 제분 기술 노하우가 축적된 밀가루로 빵을 만드는 베이커리 입니다. 
    호호베이커리의 다양한 맞춤 밀가루는 빵마다의 개성 있는 식감을 살려주고 장시간 동안 그 부드러움이 유지되며, 더 깊은 빵의 풍미를 즐길 수 있도록 합니다.</textarea></td>
				</tr>
	</table>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>