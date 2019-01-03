<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<form id="pay_ok_form" method="post" action="${pageContext.request.contextPath}/user/order/memberOrderView.do">
	<input type="hidden" name="order_id" value="${order_id}" />
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title">결제 완료</h4>
	</div>
	<div class="modal-body">
		<p>결제가 완료되었습니다.</p>
	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-danger">주문 확인하러 가기</button>
	</div>
</form>