<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>

	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>Main</title>
<link href="${pageContext.request.contextPath}/assets/css/bakery.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/css/modern-business.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/css/main.css" rel="stylesheet">

</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
<div role="main">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img id="mainPic" alt="main1"
					src="${pageContext.request.contextPath}/assets/img/main_picture01.jpg" alt="First slide">
				<div class="container">
					<div class="carousel-caption text-left"></div>
				</div>
			</div>
			<div class="carousel-item">
				<img id="mainPic"
					src="${pageContext.request.contextPath}/assets/img/main_picture02.jpg" alt="Second slide">
				<div class="container">
					<div class="carousel-caption"></div>
				</div>
			</div>
			<div class="carousel-item">
				<img id="mainPic"
					src="${pageContext.request.contextPath}/assets/img/main_picture03.jpg" alt="Third slide">
				<div class="container">
					<div class="carousel-caption text-right"></div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			<span class="icon-prev" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			<span class="icon-next" aria-hidden="true"></span> <span class="sr-only">Next</span>
		</a>
	</div>
	<br>
	<br>

	<!-- Marketing messaging and featurettes
      ================================================== --> <!-- Wrap the rest of the page in another container to center all the content. -->

	<div class="container marketing">

		<!-- Three columns of text below the carousel -->
		<div class="row">
			<div class="col-lg-4">
				<img class="rounded-circle" src="${pageContext.request.contextPath}/assets/img/main_notice.png" alt="Generic placeholder image" width="140" height="140">
				<h2 id="title">Notice</h2>
				<ul id="description_1">
					<li>예약은 케이크만 가능합니다^^</li>
					<li>예약한 케이크는 현장수령만 가능합니다. 양해 부탁드려요~</li>
					<li>케이크 수령일을 꼭 적어주시고, 날짜를 지켜주시길 부탁드립니다!</li>
				</ul>
				<p>
					<a class="btn btn-outline-warning" href="BakeryServlet?command=adminNoticeList" role="button">더 보기&raquo;</a>
				</p>
			</div>
			<div class="col-lg-4">
				<img class="rounded-circle" src="${pageContext.request.contextPath}/assets/img/main_cake.jpg" alt="Generic placeholder image" width="140" height="140">
				<h2 id="title">Cake</h2>
				<ul id="description_1">
					<li>레드벨벳 케이크</li>
					<li>딸기 타르트</li>
					<li>청포도 타르트</li>
					<li>블루베리 타르트</li>
					<li>티라미수</li>
				</ul>
				
				<p>
					<a class="btn btn-outline-warning" href="BakeryServlet?command=productList&type=cake&code=1" role="button">더 보기&raquo;</a>
				</p>
			</div>
			<div class="col-lg-4">
				<img class="rounded-circle" src="${pageContext.request.contextPath}/assets/img/main_bread.jpg" alt="Generic placeholder image" width="140" height="140">
				<h2 id="title">Bread</h2>
				<ul id="description_1">
					<li>호호 브라우니</li>
					<li>견과류 브라우니</li>
					<li>딸기 페스츄리</li>
					<li>블루베리 페스츄리</li>
					<li>초코 페스츄리</li>
				</ul>
				<p>
					<a class="btn btn-outline-warning" href="BakeryServlet?command=productList&type=bread&code=2" role="button">더 보기&raquo;</a>
				</p>
			</div>
		</div>

		<!-- START THE FEATURETTES -->

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7">
				<h2 id="title" class="featurette-heading">
					"호호's Bakery"만의 특별한 딸기 케이크!
				</h2>
				<p id="description_2" class="lead"><span class="text-muted">
					유크림이 풍부한 유럽산 생크림을 사용한 고품격 딸기 생크림 케이크.<br>
					부드러운 생크림과 딸기의 상큼함을 함께 느껴보세요^^</span>
					<br><br>
					<span id="caution">* 계절에 따라 딸기 외 대체 과일 데코레이션으로 운영 될 수 있습니다 *</span>
				</p>
			</div>
			<div class="col-md-5">
				<img class="featurette-image img-fluid mx-auto" data-src="holder.js/500x500/auto" src="${pageContext.request.contextPath}/assets/img/sb_cake_main.jpg" alt="Generic placeholder image">
			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7 order-md-2">
				<h2 id="title" class="featurette-heading">
					눈과 입을 모두 즐겁게 하는 마법의 마카롱!
				</h2>
				<p id="description_2" class="lead"><span class="text-muted">
					눈길을 사로잡는 생생한 컬러, 풍부한 크림의 촉촉한 부드러움,<br>
					한입 베어 물었을 때 녹아내리듯 부서지는 크런치함까지!<br>
					입안 가득 퍼지는 달콤한 마카롱을 맛 보세요^^</span>
					<br><br>
					<span id="caution">* 원산지 및 영양성분은 개별 제품 정보를 확인해주세요 *</span>
				</p>
			</div>
			<div class="col-md-5 order-md-1">
				<img class="featurette-image img-fluid mx-auto" data-src="holder.js/500x500/auto" src="${pageContext.request.contextPath}/assets/img/macaron.jpg" alt="Generic placeholder image">
			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7">
				<h2 id="title" class="featurette-heading">
					활기찬 하루 시작을 위한 상큼한 에이드!
				</h2>
				<p id="description_2" class="lead"><span class="text-muted">
					싱싱한 과일을 통째로 에이드에 쏙~<br>
					호호's Bakery만의 레몬에이드에 빠져보세요^^<br>
					레몬의 상큼함과 톡 쏘는 탄산의 시원함을 함께 즐길 수 있는 음료!</span>
					<br><br>
					<span id="caution">* 저희 Bakery는 에이드에 시럽이 아닌 생과일을 사용합니다 *</span>
				</p>
			</div>
			<div class="col-md-5">
				<img class="featurette-image img-fluid mx-auto" data-src="holder.js/500x500/auto" src="${pageContext.request.contextPath}/assets/img/remon_ade_main.jpg" alt="Generic placeholder image">
			</div>
		</div>	
	</div>
</div>
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>