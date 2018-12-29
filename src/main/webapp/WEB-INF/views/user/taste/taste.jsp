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
	<div class="container">
			<h1>제품</h1>
			<hr>
			<!-- 데스크탑: 한 줄에 4개, 태블릿: 한 줄에 2개 씩 배치되도록 그리드 구성 -->
			<div class="row">
				<!-- 게시물 하나 시작 -->
				<div class="col-sm-6 col-md-3">
					<div class="thumbnail">
						<img alt="엔틱 자전거 - my wish list" src="${pageContext.request.contextPath}/assets/img/no_image.jpg">
						<div class="caption">
							<h3>제품명</h3>
							<p>가격여기다가 쓸까</p>
							<p>
								<a href="#" class="btn btn-primary"><i class="glyphicon glyphicon-heart"></i> 찜하기</a>
								<a href="#" class="btn btn-info"><i class="glyphicon glyphicon-shopping-cart"></i> 장바구니담기</a>
							</p>
						</div>
					</div>
				</div>
				<!-- 게시물 하나 끝 -->
				<!-- 게시물 하나 시작 -->
				<div class="col-sm-6 col-md-3">
					<div class="thumbnail">
						<img alt="느낌 아니까!!" src="${pageContext.request.contextPath}/assets/img/no_image.jpg">
						<div class="caption">
							<h3>제품명</h3>
							<p>가격여기다가 쓸까</p>
							<p>
								<a href="#" class="btn btn-primary"><i class="glyphicon glyphicon-heart"></i> 찜하기</a>
								<a href="#" class="btn btn-info"><i class="glyphicon glyphicon-shopping-cart"></i> 장바구니담기</a>
							</p>
						</div>
					</div>
				</div>
				<!--// 게시물 하나 끝 -->
				<!-- 게시물 하나 시작 -->
				<div class="col-sm-6 col-md-3">
					<div class="thumbnail">
						<img alt="그림자놀이" src="${pageContext.request.contextPath}/assets/img/no_image.jpg">
						<div class="caption">
							<h3>제품명</h3>
							<p>가격여기다가 쓸까</p>
							<p>
								<a href="#" class="btn btn-primary"><i class="glyphicon glyphicon-heart"></i> 찜하기</a>
								<a href="#" class="btn btn-info"><i class="glyphicon glyphicon-shopping-cart"></i> 장바구니담기</a>
							</p>
						</div>
					</div>
				</div>
				<!--// 게시물 하나 끝 -->
				<!-- 게시물 하나 시작 -->
				<div class="col-sm-6 col-md-3">
					<div class="thumbnail">
						<img alt="캐리비안의 해적" src="${pageContext.request.contextPath}/assets/img/no_image.jpg">
						<div class="caption">
							<h3>제품명</h3>
							<p>가격여기다가 쓸까</p>
							<p>
								<a href="#" class="btn btn-primary"><i class="glyphicon glyphicon-heart"></i> 찜하기</a>
								<a href="#" class="btn btn-info"><i class="glyphicon glyphicon-shopping-cart"></i> 장바구니담기</a>
							</p>
						</div>
					</div>
				</div>
				<!--// 게시물 하나 끝 -->
			</div>
		</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
	<script src='${pageContext.request.contextPath}/assets/plugins/animate/jquery.animatecss.min.js'></script>
	<script>
		$(function() {
			//왜 안먹음???????????????????????
			$('.navigation').animateCSS('slideInLeft');
			//getProductList(1);
		});
		
		/* function getProductList(type) {
			$.ajax({
				url: "${pageContext.request.contextPath}/user/taste/productList.do",
				data: {
					data: type
				},
				dataType: "json",
				cache: false,
				success: function(json) {
					//json받아서 html동적요소 만들어 박기.
				}
				
			});
		}; */
	</script>

</body>
</html>