<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/navigation.css" /> 
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>title</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
	<div class="navigation">
		<ul>
			<li><a href="#" class="getProductList(1)">Cake</a></li>
			<li><a href="#" class="getProductList(2)">Bread</a></li>
			<li><a href="#" class="getProductList(3)">Drink</a></li>
		</ul>
	</div>
	<div class="content">
	
	</div>
	<%@ include file="/WEB-INF/inc/footer.jsp" %>

	<script src='${pageContext.request.contextPath}/assets/plugins/animate/jquery.animatecss.min.js'></script>
	<script>
		$(function() {
			//왜 안먹음???????????????????????
			$('.navigation').animateCSS('slideInLeft');
			//goProductList(1);
			goProductList();
		});
		
		function goProductList(type) {
			var url = "productList.html"; 
			$.ajax({
				url: url,
				data: { type: type },
				dataType: 'html',
				success: function(html) {
					$('.content').append(html);
				}
			});
		};
	</script>
 -->
</body>
</html>
