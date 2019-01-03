<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<form id="cart_delete_form" method="post" action="${pageContext.request.contextPath}/user/cart/memberCartDeleteOk.do">
	<input type="hidden" name="cart_id" value="${cart_id}" />
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

<script>
$("cart_delete_form").submit(function(e) {
	var form = $(this);
    var url = form.attr('action');
		
	$.ajax({
		type: "POST",
		url: url,
		data: form.serialize(),
		success: function(data) {
			alert("삭제되었습니다.");
			$("#cart_delete_modal").modal('hide');	// modal 강제로 닫기
			
			var cart_id = json.cart_id;
			$("#cart_" + cart_id).remove();
		}
	})
});
</script>