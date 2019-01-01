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
			<!-- href="${pageContext.request.contextPath}/user/taste/taste.do?ptype=1" -->
			<li><a onclick="getProductList(1, 1)">Cake</a></li>
			<li><a onclick="getProductList(2, 1)">Bread</a></li>
			<li><a onclick="getProductList(3, 1)">Drink</a></li>
		</ul>
	</div>

	<div class="container">
		<h1 class="page-header">제품</h1>
		<hr>
		<div class="content">
<!-- 			<div class="row">
			
			</div> -->
		</div>
	
	</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
	<!-- image있고 음료아는 제품 -->
	<script id="templ_image" type="text/x-handlebars-template">
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail">
				<a href="${pageContext.request.contextPath}/user/taste/productView.do?id={{id}}">
					<img alt="{{name}}" src="${pageContext.request.contextPath}/assets/img/no_image.jpg"></a>
						<div class="caption">
							<h3>{{name }}</h3>
							<p>{{price }} 원</p>
							<p>
								<a href="#" class="btn btn-primary"><i class="glyphicon glyphicon-heart"></i> 찜하기</a>
								<a href="#" class="btn btn-info"><i class="glyphicon glyphicon-shopping-cart"></i> 장바구니담기</a>
							</p>
						</div>
			</div>
		</div>
	</script>
	
	<!-- 이미지있고 음료 제품 -->
 	<script id="templ_drink" type="text/x-handlebars-template">
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail">
				<img alt="{{name}}" src="${pageContext.request.contextPath}/assets/img/{{image}}" />
					<div class="caption">
						<h3>{{name}}</h3>
						<p>{{price}}원</p>
						<p>{{info}}</p>
					</div>
			</div>
		</div>
	</script>
	
<!--	<script id="templ_no_image" type="text/x-handlebars-template">
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail">
				<a href="${pageContext.request.contextPath}/user/taste/productView.do?id={{id}}">
					<img alt="{{name}}" src="${pageContext.request.contextPath}/assets/img/no_image.jpg"></a>
						<div class="caption">
							<h3>{{name}}</h3>
							<p>{{price}} 원</p>
							<p>
								<a href="#" class="btn btn-primary"><i class="glyphicon glyphicon-heart"></i> 찜하기</a>
								<a href="#" class="btn btn-info"><i class="glyphicon glyphicon-shopping-cart"></i> 장바구니담기</a>
							</p>
						</div>
			</div>
		</div>
	</script>

	<script id="templ_drink_no_imgae" type="text/x-handlebars-template">
		<div class="col-sm-6 col-md-3">
			<div class="thumbnail">
				<img alt="{{name}}" src="${pageContext.request.contextPath}/assets/img/no_image.jpg" />
					<div class="caption">
						<h3>{{name}}</h3>
						<p>{{price}}원</p>
						<p>{{info}}</p>
					</div>
			</div>
		</div>
	</script>
 -->
	<script src='${pageContext.request.contextPath}/assets/plugins/animate/jquery.animatecss.min.js'></script>
	<script>
		$(function() {
			//왜 안먹음???????????????????????
			//$('.navigation').animateCSS('slideInLeft');
			getProductList(1, 0);
		});
		
		//처음 로딩시 이루어지는 ajax 시작
		function getProductList(type, state) {
			$.ajax({
				url: "${pageContext.request.contextPath}/user/taste/productList.do",
				data: {
					data: type
				},
				dataType: "json",
				cache: false,
				beforeSend: function(){
					if (state > 0) {
						$('.content').html('');
					}
				},
				success: function(json) {
					$('.content').append('<div class="row"></div>');
					var eq = 0;
					
					for(var i= 0; i<json.productList.length; i++) {
						if ((i>0) && (i%4 == 0)) {
							eq += 1;
							$('.content').append('<div class="row"></div>');
						}//if - 한 row에 4개의 상품만 넣은 후 row추가를 하기 위함
						
						var html;
						
						/* if (product.image = "") { //image가 없을 경우
							alert("image 없음");
							var tmpl_no_image = Handlebars.compile($('#templ_no_image').html());
							html = tmpl_no_image(product);
							
						} else if (product.type == '3') { //type이 음료일 경우
							alert("음료");
							var tmpl_drink = Handlebars.compile($('#templ_drink').html());
							html = tmpl_drink(product);
							
						} else if (product.type == '3' && product.image == "") { //음료이면서 이미지가 없을 경우
							alert("음료이면서 이미지 없음");
							var tmpl_drink_no_image = Handlebars.compile($('#templ_drink_no_image').html());
							html = tmpl_drink_no_imgae(product);
						
						} else { */
							//일반 템플릿
						//}
							if (type == '3') {
								var tmpl_drink = Handlebars.compile($('#templ_drink').html());
								html = tmpl_drink(json.productList[i]);
							} else {
								var tmpl_image = Handlebars.compile($('#templ_image').html());
								html = tmpl_image(json.productList[i]);
							}
							

						$('.container > .content > .row:eq(' + eq + ')').append(html);
					}//for

				}//success
				
			});
		}; //처음 로딩시 이루어지는 ajax 끝
	</script>
</body>
</html>