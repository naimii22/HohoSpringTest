<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="false" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>adminPayEmail</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbarAdmin.jsp" %>
	
	<div class="container">
		<!-- 제목 -->
		<div class="page-header"> <h1>결제 완료 메일 발송</h1> </div>
	
		<!-- 메일 폼 영역 -->
		<form class="form-horizontal" method="post" 
	        action="${pageContext.request.contextPath}/admin/order/mail_ok.do">
			<div class="form-group">
	            <label class="control-label col-sm-2" for="sender">보내는주소</label>
	            <div class="col-sm-10">
	                <input type="text" name="sender" id="sender" class="form-control" value="HOHO's email 주소" readonly/>
	            </div>
	        </div>
	
	        <div class="form-group">
	            <label class="control-label col-sm-2" for="receiver">받는주소</label>
	            <div class="col-sm-10">
	                <input type="text" name="receiver" id="receiver" class="form-control" value="${member.email}"/>
	            </div>
	        </div>
	                
	        <div class="form-group">
	            <label class="control-label col-sm-2" for="subject">메일 제목</label>
	            <div class="col-sm-10">
	                <input type="text" name="subject" id="subject" class="form-control"
	                	value="HoHo's Bakery 결제 확인 메일입니다."/>
	            </div>
	        </div>
	
	        <div class="form-group">
	            <label class="control-label col-sm-2" for="content">내용입력</label>
	            <div class="col-sm-10">
	                <textarea name="content" id="content" class="ckeditor" >
	                -HOHO's Bakery 결제 확인 메일-
	                ${member.name}님의 주문 결제가 완료되었습니다.
	               	주문번호 : ${order.id}
	               	주문일자 : ${order.reg_date}
	               	결제금액 : ${order.total}원
	               	
	               	* 위 사항에 문제 혹은 변동 사항이 있을 시, HOHO 매장으로 연락바랍니다.
	               	tel) 02-111-2222
	               	</textarea>
	            </div>
	        </div>
	                
	        <div class="col-sm-10 col-sm-offset-2 text-right">
	            <input type="submit" class="btn btn-primary" value="메일보내기" />
	            <input type="reset" class="btn btn-default" value="다시작성" />
	        </div>
		</form>
	</div>
	
</body>
</html>