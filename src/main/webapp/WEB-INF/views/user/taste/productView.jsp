<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/productView.css" />
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>title</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
	<div class="container">
			<!-- 제품정보 상세 시작 -->
			<h1 class="page-header">제품 상세</h1>
			<hr>
			<div class="product-view clearfix">
				<div class="product-image pull-left">
					<img class="image-size" src="${pageContext.request.contextPath}/assets/img/no_image.jpg"/>
					<%-- 	
						<c:url var="downloadUrl" value="/download.do">
							<c:param name="file" value="${product.image}" />
						</c:url>
						<img src="${downloadUrl}" class="image-size img-responsive" />
						
					 --%>
				</div>
				<div class="product-info pull-left">
					<div class="row name"><h3>${product.name }</h3></div>
					<div class="row price underline">
						<div class="pull-left"><h4>${product.price } 원</h4></div>
						<div class="pull-right">
							<a href="#" class="btn btn-primary"><i class="glyphicon glyphicon-heart"></i> 찜하기</a>
							<a href="#" class="btn btn-info"><i class="glyphicon glyphicon-shopping-cart"></i> 장바구니담기</a>
						</div>
					</div>
					<p>${product.info }</p>
					<div class="product-describe"></div>
				</div>
			</div>
			<!-- 제품정보 상세 끝 -->
			
			
			<!-- 후기리스트 시작 -->
			<h1 class="display-inline">후기</h1>
			<div class="pull-right"><a href="${pageContext.request.contextPath}/user/review/reviewWrite.do?product_id=${product.id}" class="btn btn-primary">후기 작성</a></div>
			<hr>
			<div class="row underline">
					<div class="col-sm-1 col-md-1">순번</div>
					<div class="col-sm-2 col-md-2">이미지</div>
					<div class="col-sm-2 col-md-2">제목</div>
					<div class="col-sm-2 col-md-2">별점</div>
					<div class="col-sm-2 col-md-2">작 성 자</div>
					<div class="col-sm-2 col-md-2">날짜</div>
					<div class="col-sm-1 col-md-1">조회수</div>
			</div>
			
			<c:set var="length" value="${fn:length(memberList)}" /><!-- memberList의 마지막위치 숫자 -->
			<c:forEach items="${reviewList }" var="review" varStatus="status">
			<c:set var="member" value="${memberList.get(status.index)}" />
				<div class="row underline">
					<div class="col-sm-1 col-md-1 height"><div class="height-center">${review.id }</div></div>
					<!-- reviewList에서 review뽑고, 파라미터로 reviewId넘기기 -->
					<div class="col-sm-2 col-md-2">
						<c:url var="downloadUrl" value="/download.do">
							<c:param name="file" value="${review.image }" />
						</c:url>
						<img src="${downloadUrl}" class="img-responsive"  width="70" height="70"/>
						<%-- <img src="${pageContext.request.contextPath}/assets/img/no_image.jpg" width="70" height="70" alt="이미지"> --%>
					</div>
					<div class="col-sm-2 col-md-2 height"><div class="height-center">
						<a href="${pageContext.request.contextPath}/user/review/reviewView.do?
							id=${review.id}&user_id=${member.user_id}">${review.title }</a></div>
					</div>
					<div class="col-sm-2 col-md-2 height"><div class="height-center">${review.rating }</div></div>
					<div class="col-sm-2 col-md-2 height"><div class="height-center">${member.user_id }</div></div>
					<div class="col-sm-2 col-md-2 height"><div class="height-center">${review.edit_date }</div></div>
					<div class="col-sm-1 col-md-1 height"><div class="height-center">${review.hit }</div></div>
				</div>
			</c:forEach>
			
			<!-- db연결 안한 샘플 -->
			<div class="row underline">
				<div class="col-sm-1 col-md-1 height"><div class="height-center">순번</div></div>
				<div class="col-sm-2 col-md-2"><img src="${pageContext.request.contextPath}/assets/img/no_image.jpg" width="70" height="70" alt="도심의 야경"></div>
				<div class="col-sm-2 col-md-2 height"><div class="height-center"><a href="${pageContext.request.contextPath}/user/review/reviewView.do">후기의 제목</a></div></div>
				<div class="col-sm-2 col-md-2 height"><div class="height-center">별점 ★ ★ ★ ★ ★</div></div>
				<div class="col-sm-2 col-md-2 height"><div class="height-center">바 켸 련</div></div>
				<div class="col-sm-2 col-md-2 height"><div class="height-center">2019-01-01</div></div>
				<div class="col-sm-1 col-md-1 height"><div class="height-center">1</div></div>
			</div>
			<!-- 후기리스트 끝 -->
			
		</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>