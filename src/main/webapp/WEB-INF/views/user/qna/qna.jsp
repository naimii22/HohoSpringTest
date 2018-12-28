<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>qna</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
	<div class="container">
			<h1>자주하는 질문</h1>
			
			<!-- 아코디언 영역 -->
			<div class="panel-group" id="accordion">
				<!-- 항목(1) -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" 
						href="#collapseOne"> Q. 호호 제품은 유통기한이 얼마인가요? </a></h4>
					</div>
					<div id="collapseOne" class="panel-collapse collapse in">
						<div class="panel-body">
							A. 모든 제품의 유통기한은 4일입니다.
						</div>
					</div>
				</div>
				<!-- 항목(2) -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
						href="#collapseTwo"> Q. 케이크는 어디에 보관해야 하나요? </a></h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse">
						<div class="panel-body">
							A. 모든 케이크는 냉장 보관해야 하며 개봉 후 빨리 드셔야 합니다.
						</div>
					</div>
				</div>
				<!-- 항목(3) -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
						href="#collapseThree"> Q. 주문을 취소하고 싶어요! </a></h4>
					</div>
					<div id="collapseThree" class="panel-collapse collapse">
						<div class="panel-body">
							주문 취소는 배송 전에만 가능하며, '로그인 > 마이페이지 > 주문확인'에서 취소가 가능합니다.
						</div>
					</div>
				</div>
				<!-- 항목(4) -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
						href="#collapseFour"> Q. 주문 시 배송은 언제 되나요? </a></h4>
					</div>
					<div id="collapseFive" class="panel-collapse collapse">
						<div class="panel-body">
							고객님께 신선한 케이크를 전달해 드리기 위해 당일 배송해드립니다.
						</div>
					</div>
				</div>
				<!-- 항목(5) -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title"><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"
						href="#collapseFive"> Q. 회원정보변경은 어떻게 하나요? </a></h4>
					</div>
					<div id="collapseThree" class="panel-collapse collapse">
						<div class="panel-body">
							호호's 베이커리 회원이시라면 '로그인 > 마이페이지 > 회원정보'에서 수정이 가능합니다.
						</div>
					</div>
				</div>
			</div>
			<!--// 아코디언 영역 -->
		</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>