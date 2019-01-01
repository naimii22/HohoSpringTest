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
	<h1 class="page-header">제품</h1>
	<hr>
	<div class="row">
	
	</div>

</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
 	<script id="templ_no_image" type="text/x-handlebars-template">
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
<%-- 			<div class="col-sm-6 col-md-3">
			<div class="thumbnail">
				<a href="${pageContext.request.contextPath}/user/taste/productView.do?id=${product.id}">
					<img alt="{{name}}" src="${pageContext.request.contextPath}/assets/img/no_image.jpg" /></a>
					<div class="caption">
						<h3>{{name}}</h3>
						<p>{{price}}원</p>
						<p>
							<a href="#" class="btn btn-primary"><i class="glyphicon glyphicon-heart"></i> 찜하기</a>
							<a href="#" class="btn btn-info"><i class="glyphicon glyphicon-shopping-cart"></i> 장바구니담기</a>
						</p>
					</div>
			</div>
		</div> --%>
	
	
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
	<script src='${pageContext.request.contextPath}/assets/plugins/animate/jquery.animatecss.min.js'></script>
	<script>
		$(function() {
			//왜 안먹음???????????????????????
			//$('.navigation').animateCSS('slideInLeft');
			getProductList(1);
		});
		
		function getProductList(type) {
			$.ajax({
				url: "${pageContext.request.contextPath}/user/taste/productList.do",
				data: {
					data: type
				},
				dataType: "json",
				cache: false,
				success: function(json) {
					alert("통신 됨");
					var eq = 0;
					var selector = "'.container > .row:eq(" + eq + ")'";
					//var i = 0;
					
					for(var i= 0; i< json.productList.length; i++) {
						if ((i>0) && (i%4 == 0)) {
							alert("if문 입장");
							eq += 1;
							$('.container').append('<div class="row"></div>');
							//selector = ".container > .row:eq(" + eq + ")";
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
							
							var tmpl_image = Handlebars.compile($('#templ_image').html());
							html = tmpl_image(json.productList[i]);
							
						//}
						alert("탬플릿 하구 selector위까지 접근");
						$('.container > .row:eq(' + eq + ')').append(html);
						alert("selector됨");
						
						//i += 1;
					}//for
					
					
				}//success
				
			});
		};
	</script>
</body>
</html>