<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>login</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
	<div>
		<div class="main-content" id="divMain">
	    <div class="container">
	           <div class="row" id="divRow">
	               <div class="col-sm-8 col-sm-offset-2 text">                    
	                   <h1 id="h1-font"><strong>Login to</strong> HOHO's bakery</h1>
	               </div>
	           </div>
	
	           <div class="row" id="divRowMargin">
	               <div class="col-sm-6 col-sm-offset-3">
	                   <div id="LoginModal">
	                       <div class="modal-content panel panel-info">
	                           <form method="post" action="${pageContext.request.contextPath}/member/login_ok.do" 
	                           name="memberLogin" id="frmLogin" class="form-horizontal" role="form">
	                               <input type="hidden" name="Mode" value="Login" />
	                               <div class="modal-body">
	                                   <div class="input-group" id="divMargin">
	                                       <span class="input-group-addon">아 이 디&nbsp;&nbsp;&nbsp;<i class="fa fa-user"></i></span><br>
	                                       <input name="user_id" id="MemberID" type="text" maxlength="60" class="form-control" placeholder="아이디를  입력하세요">
	                                   </div>
	                                   
	                                   <div class="modal-header panel-heading" id="divColor"></div>
	                                    
	                                   <div class="input-group" id="divBottom">
	                                       <span class="input-group-addon">패스워드&nbsp;&nbsp;<i class="fa fa-unlock"></i></span><br>
	                                       <input name="user_pw" id="Password" type="password" maxlength="20" class="form-control" placeholder="패스워드를 입력하세요">
	                                   </div>
	                               </div>
	                               
	                               <div id="div-login-button">
										<input type="submit" class="btn btn-info" id="button_login" value="Login">
	                               </div>
	                               <div id="message">${message}</div>
	                           </form>
	                           <div class="modal-header panel-footer">
	                               <div id="modal-font">HOHO's Bakery에 처음이세요? 지금 가입하세요 » &nbsp;&nbsp;&nbsp;&nbsp; 
	                               <a href="${pageContext.request.contextPath}/user/signUp/memberJoin.do" class="btn btn-default btn-xs">회원가입</a></div>
	                           </div>
	                       </div>
	                   </div>
	   			</div>
			</div>
		</div>
	</div>
		
	</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>