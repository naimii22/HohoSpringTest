<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>title</title>
	
	<style>
		/* 하트 크기와 색깔 */
    	.glyphicon {
    		font-size: 2em;
    		color: red;
    	}
    </style>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
<div class="container">
	<form class="form-horizontal" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user/review/reviewWriteOk.do">
		<input type="hidden" name="product_id" value="${product_id }">
		<div class="form-group">
			<label class="col-sm-2 control-label">제 목</label>
		    <div class="col-sm-10">
			      <input class="form-control" type="text" name="title" id="title"/>
		    </div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">내 용</label>
		    <div class="col-sm-10">
		      <textarea class="form-control ckeditor" name="content" id="content" rows="3"></textarea>
		    </div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">별 점</label>
		    <div class="col-sm-10">
				<div class="form-group">
					<div class="glyphicon glyphicon-heart-empty" style="display: inline-block;" onclick="getScore(1)"></div>
					<div class="glyphicon glyphicon-heart-empty" style="display: inline-block;" onclick="getScore(2)"></div>
					<div class="glyphicon glyphicon-heart-empty" style="display: inline-block;" onclick="getScore(3)"></div>
					<div class="glyphicon glyphicon-heart-empty" style="display: inline-block;" onclick="getScore(4)"></div>
					<div class="glyphicon glyphicon-heart-empty" style="display: inline-block;" onclick="getScore(5)"></div>
				</div>
				<input class="rating" type="hidden" name="rating" value="">
		    </div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">사 진</label>
		    <div class="col-sm-10">
		     	<input class="form-control" type="file" name="image" id="image"/>
		    </div>
		</div>
		<div class="pull-right">
			<input type="submit" value="확인">
			<input type="reset" value="재작성" onclick="resetContent();">
		</div>
	</form>
</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
	<script>
		//click시 채워진 하트로 바뀜
		$('.glyphicon').click(function() {
			if ($(this).hasClass('glyphicon-heart-empty')) {
				//이전
				$(this).prevAll().removeClass('glyphicon-heart-empty');
				$(this).prevAll().addClass('glyphicon-heart');
				$(this).removeClass('glyphicon-heart-empty');
				$(this).addClass('glyphicon-heart');
				
				//이후
				$(this).nextAll().addClass('glyphicon-heart-empty');
				$(this).nextAll().removeClass('glyphicon-heart');
			} else {
				//이전
				$(this).prevAll().removeClass('glyphicon-heart-empty');
				$(this).prevAll().addClass('glyphicon-heart');
				$(this).removeClass('glyphicon-heart-empty');
				$(this).addClass('glyphicon-heart');
				
				//이후
				$(this).nextAll().addClass('glyphicon-heart-empty');
				$(this).nextAll().removeClass('glyphicon-heart');
			}// else
		});
		
		//하트 click시 점수 가져옴
		function getScore(score) {
			var score = score;
			$('.rating').attr('value', score);
		}
		
		//reset버튼 누를 경우
		function resetContent() {
			if($('.glyphicon').hasClass('glyphicon-heart')) {
				$('.glyphicon').removeClass('glyphicon-heart');
				$('.glyphicon').addClass('glyphicon-heart-empty');
			}
		}
	</script>
</body>
</html>