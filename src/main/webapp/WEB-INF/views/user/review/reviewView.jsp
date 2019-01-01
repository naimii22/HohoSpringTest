<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/reviewView.css" />
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>title</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
	<div class="container">
    	<h1 class="page-header">후기 상세</h1>
    	<hr>
    	<!-- 리뷰 시작 -->
    	<div class="review">
	    	<div class="row">
	    		<div class="col-sm-2 col-md-2"> 제 목 </div>
	    		<div class="col-sm-2 col-md-2">${review.title }</div>
	    		<div class="col-sm-4 col-md-4 pull-right">
	    			<a href="${pageContext.request.contextPath}/user/review/reviewUpdate.do?
							id=${review.id}&user_id=${user_id}" class="btn btn-primary">수 정</a>
	    			<a href="${pageContext.request.contextPath}/user/review/reviewDelete.do?
							id=${review.id}&user_id=${user_id}" class="btn btn-primary"
							data-toggle="modal" data-target="#review_delete_modal">삭 제</a>
	    		</div>
	    	</div>
	    	<div class="row">
	    		<div class="col-sm-2 col-md-2">작 성 자</div>
	    		<div class="col-sm-2 col-md-2 text-left">${user_id }</div>
	    		<div class="col-sm-2 col-md-2">작 성 날 짜</div>
	    		<div class="col-sm-3 col-md-3 text-left">${review.reg_date }</div>
	    		<div class="col-sm-2 col-md-2 text-right">조 회 수</div>
	    		<div class="col-sm-1 col-md-1 text-left">${review.hit }</div>
	    	</div>
	    	<div class="image">
	    		<img src="">
	    	</div>
	    	<div class="row">
	    		<div class="col-sm-2 col-md-2">내 용</div>
	    	</div>
	    	<div class="row">
	    		<p>${review.content }</p>
	    	</div>
	    </div>
	    <!-- 리뷰 끝 -->
	    
	    <!-- 댓글 시작 -->
	    <!-- 댓글 끝 -->
	    
	<div id="review_delete_modal" tabindex="-1" class="modal fade">
    	<div class="modal-dialog">
    		<div class="modal-content">

    		</div>
  		</div>
    </div>
    </div>
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
	<script>
		$(document).on('submit', '#review_delete_form', function(e) {
			e.preventDefault();
			
			$(this).ajaxSubmit(function(json) {
				if (json.rt != "OK") {
					alert(json.rt);
					return false;
				}
				alert("삭제되었습니다.");
				
				$("#review_delete_modal").modal('hide');
			});
		});
	</script>
</body>
</html>