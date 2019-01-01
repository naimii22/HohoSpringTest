<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
</button>
	<form id="memberJoin_ok_form" 
			action="${pageContext.request.contextPath}/user/member/JoinOk.do">
		<input type="hidden" name="user_id" value="${user_id}">
		<input type="hidden" name="user_pw" value="${user_pw}">
		<input type="hidden" name="user_pw_re" value="${user_pw_re}">
		<input type="hidden" name="name" value="${name}">
		<input type="hidden" name="gender" value="${gender}">
		<input type="hidden" name="birthdate" value="${birthdate}">
		<input type="hidden" name="tel" value="${tel}">
		<input type="hidden" name="postcode" value="${postcode}">
		<input type="hidden" name="addr1" value="${addr1}">
		<input type="hidden" name="addr2" value="${addr2}">
		<input type="hidden" name="email" value="${email}">			
		<div style='width: 300px; margin: auto;'>
			<div class="modal-body">
				<div class="form-group" style="text-align: center;">
					<h3>회원가입이 완료되었습니다.</h3>
				</div>
			</div>
			<div class="row" style="margin-bottom: 20px;">
				<button type="submit" class='btn btn-danger col-md-6'>로그인 하기</button>
				<button type="button" class='btn btn-primary col-md-6' data-dismiss="modal">취 소</button>
			</div>
		</div>
	</form>
</body>
</html>