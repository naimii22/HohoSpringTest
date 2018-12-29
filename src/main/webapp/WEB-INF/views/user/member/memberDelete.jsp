<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>memberDelete</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	<div class="container" id="container">
      <div class="row">
         <h2 class="align-center">회원탈퇴에 앞서 <em>유의사항</em> 및 안내를 반드시 읽고 진행해 주세요!</h2>
      </div>
        <div class="row" id="box">
           <h5 class="h5-style">아이디는 재사용 및 복구 불가</h5>
           <br>
           <div id="border">
           회원탈퇴 진행 시 본인을 포함한 타인 모두 아이디 재사용이나 복구가 불가능합니다.<br>
         신중히 선택하신 후 결정해주세요.
         </div>
      </div>
      <div class="row" id="box">
           <h5 class="h5-style">내정보 및 개인형 서비스 이용 기록 삭제 안내</h5>
           <br>
           <div id="border">
           내정보 및 개인형 서비스 이용기록이 모두 삭제되며,삭제된 데이터는 복구되지 않습니다.<br>
         삭제되는 서비스를 확인하시고, 필요한 데이터는 미리 백업을 해주세요.
         </div>
      </div>
      <div class="row" id="box">
           <h5 class="h5-style">게시판형 서비스에 등록한 게시글 삭제 불가 안내</h5>
           <br>
           <div id="border">
           삭제를 원하는 게시글이 있다면 반드시 회원탈퇴 전 삭제하시기 바랍니다.<br>
         탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어,<br>
         게시글을 임의로 삭제해드릴 수 없습니다.
         </div>
      </div>
      <div id="button">
         <form name="frm" method="post" 
				action="${pageContext.request.contextPath}/member/out_ok.do">
            <input type="submit" class="btn btn-info" value="예">
            <input type="button" class="btn btn-info" value="아니오" onclick="${pageContext.request.contextPath}/user/member/memberView.do">
         </form>
      </div>
   </div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>