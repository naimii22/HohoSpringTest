<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>productCartList</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
	<div class="container">
		<h1 class="page-header">장바구니</h1>
		
		<!-- 장바구니 목록 시작 -->
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
		        	<tr>
		            	<th class="text-center" style="width: 100px">사진</th>
		            	<th class="text-center">이름</th>
		            	<th class="text-center" style="width: 120px">수량</th>
		            	<th class="text-center" style="width: 100px">금액</th>
		            	<th class="text-center" style="width: 120px">선택</th>
		        	</tr>
		    	</thead>
			    <tbody>
			    	<c:choose>
			    		<c:when test="${fn:length(cartList) > 0}">
			    			<c:forEach var="cart" items="${cartList}" varStatus="status">
			    				<c:set var="product" value="${productList.get(status.index)}" />
			    				<tr>
						            <td>
						            	<%-- productView.do 작성 후에 수정
						            	<c:url var="readUrl" value="user/product/productView.do">
						            		<c:param name="product_id" value="${product.id}" />
						            	</c:url>
						            	<a href="${readUrl}"><img src="${product.image}"></a> --%>
						            	${product.image}
						            </td>
						            <td class="text-center">${product.name}</td>
						            <td class="text-center">수량</td>
						            <td class="text-center">${product.price}</td>
						            <td>
						            	<!-- 삭제하기 버튼 -->
						            	<a data-toggle="modal" href="#cartDeleteModal" class="btn btn-danger">삭제하기</a>
						            	<%-- <a href="${pageContext.request.contextPath}/user/cart/memberCartDelete.do?cartId=${cart.id}"
						            		data-toggle="modal" data-target="cartDeleteModal" class="btn btn-danger">삭제하기</a> --%>
						            </td>
					        	</tr>
			    			</c:forEach>
			    		</c:when>
			    		<c:otherwise>
			    			<tr>
					            <td colspan="5" class="text-center" style="line-height: 100px;">장바구니에 담긴 상품이 없습니다.</td>
					        </tr>
			    		</c:otherwise>
			    	</c:choose>
			    </tbody>
			</table>
		</div>
		<!--// 장바구니 목록 끝 -->
		
		<!-- 결제 버튼 시작 -->
		<div class="clearfix">
		    <div class="pull-right">
		        <%-- memberOrderInsert.do 작성 후 수정
		        <a href="${pageContext.request.contextPath}/user/order/memberOrderInsert.do?member_id=${loginUser.user_id}" class="btn btn-primary">
		        	<span class="glyphicon glyphicon-credit-card"></span> 결제하기
		        </a> --%>
		        <a href="#" class="btn btn-primary"><span class="glyphicon glyphicon-credit-card"></span> 결제하기</a>
			</div>
		</div>
		<!--// 결제 버튼 시작 끝 -->
	</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
	
	<!-- 카트 삭제 모달 -->
	<div id="cartDeleteModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="cartDeleteForm" method="post" action="${pageContext.request.contextPath}/user/cart/memberCartDelete.do">
					<input type="hidden" name="cartId" value="${cart.id}" />
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">상품 삭제</h4>
					</div>
					<div class="modal-body">
						<p>해당 제품을 장바구니에서 삭제하겠습니까?</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
						<button type="submit" class="btn btn-danger">삭제</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!--// 카트 삭제 모달 끝 -->
	
	<!-- <script type="text/javascript">
		$(function() {
			/** 모든 모달창의 캐시 방지 처리 */
			$('.modal').on('hidden.bs.modal', function (e) {
				// 모달창 내의 내용을 강제로 지움.
	    		$(this).removeData('bs.modal');
			});
		});
	</script> -->
</body>
</html>