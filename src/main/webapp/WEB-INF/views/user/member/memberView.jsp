<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>memberView</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	<div class='container'>
    <div class='page-header'>
        <h1>회원정보 보기</h1>
    </div>
    <!-- 가입폼 시작 -->
        <div class="form-group">
            <label for='userid' class="col-md-2">아이디</label>
            <div class="col-md-10">
                <!-- 아이디는 변경할 수 없기 때문에 출력만 한다. -->
                <p class="form-control-static">${loginInfo.userId}</p>
            </div>
        </div>

        <div class="form-group">
            <label for='name' class="col-md-2">이름</label>
            <div class="col-md-10">
                <p class="form-control-static">${loginInfo.name}</p>
            </div>
        </div>

        <div class="form-group">
            <label for='email' class="col-md-2">이메일</label>
            <div class="col-md-10">
                <p class="form-control-static">${loginInfo.email}</p>
            </div>
        </div>

        <div class="form-group">
            <label for='tel' class="col-md-2">연락처</label>
            <div class="col-md-10">
                <p class="form-control-static">${loginInfo.tel}</p>
            </div>
        </div>

        <div class="form-group">
            <label for='birthdate' class="col-md-2">생년월일</label>
            <div class="col-md-10">
                <p class="form-control-static">${loginInfo.birthdate}</p>
            </div>
        </div>

        <div class="form-group">
            <label for='gender1' class="col-md-2">성별</label>
            <div class="col-md-10">
            	<p class="form-control-static">
            		<c:if test="${loginInfo.gender == 'M' }">남자</c:if>
            		<c:if test="${loginInfo.gender == 'F' }">여자</c:if>
                </p>
            </div>
        </div>

        <div class="form-group">
            <label for='postcode' class="col-md-2">우편번호</label>
            <div class="col-md-10 clearfix">
            	<p class="form-control-static" style='width: 120px; margin-right: 5px'>${loginInfo.postcode}</p>
            </div>
        </div>

        <div class="form-group">
            <label for='addr1' class="col-md-2">주소</label>
            <div class="col-md-10">
            	<p class="form-control-static">${loginInfo.addr1}</p>
            </div>
        </div>

        <div class="form-group">
            <label for='addr2' class="col-md-2">상세주소</label>
            <div class="col-md-10">
                <p class="form-control-static">${loginInfo.addr2}</p>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <button onclick="${pageContext.request.contextPath}/user/member/memberUpdate.do" class="btn btn-primary">회원정보 수정</button>
                <button onclick="${pageContext.request.contextPath}/user/member/memberDelete.do"  class="btn btn-danger">회원 탈퇴</button>
            </div>
        </div>
    <!-- 가입폼 끝 -->
</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>