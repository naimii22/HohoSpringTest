<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>adminMemberList</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbarAdmin.jsp" %>
	<!-- modal 창 -->
	<div id="myModal" class="modal fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
		<!-- modal-dialog -->
		<div class="modal-dialog">
			<!-- modal-content -->
			<div class="modal-content">
				<form id="memberDeleteForm" method="post" 
				action="${pageContext.request.contextPath}/admin/member/adminMemberDelet_Ok.do">
					<input type="hidden" name="member_id" value="${member.id}" />
					<!-- 제목 -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">회원 삭제</h4>
					</div>
					<!-- 내용 -->
					<div class="modal-body">
						<h4>해당 회원을 탈퇴 시키겠습니까?</h4>
						<p>회원 정보가 맞는지 다시 한번 확인해주세요.</p>
					</div>
					<!-- 하단 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
						<button type="submit" class="btn btn-primary">확인</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row" id="wrap">
			<h1 class="Listheading">회원 리스트 - 관리자 페이지</h1>
			<table class="table table-hover" id="memberList">
			<thead>
				<tr>
					<th scope="col">회원번호</th>
					<th scope="col">아이디</th>
					<th scope="col">비밀번호</th>
					<th scope="col">이름</th>
					<th scope="col">성별</th>
					<th scope="col">생일</th>
					<th scope="col">휴대폰 번호</th>
					<th scope="col">이메일</th>
					<th scope="col">우편번호</th>
					<th scope="col">주소</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
			    		<c:when test="${fn:length(memberList) > 0}">
			    			<c:forEach var="member" items="${memberList}" varStatus="status">
			    				<tr>
									<th scope="row">${member.id }</th>
									<td>${member.user_id}</td>
									<td>${member.user_pw}</td>
									<td>${member.name }</td>
									<td>
										<c:choose>
											<c:when test="${member.gender == 1 }">여성</c:when>
											<c:otherwise>남성</c:otherwise>
										</c:choose>
									</td>
									<td>${member.birthdate }</td>
									<td>${member.tel}</td>
									<td>${member.email }</td>
									<td>${member.postcode}</td>
									<td>${member.addr1}&nbsp;{member.addr2}</td>
									<!-- 모달창 여는 링크 -->
									<td><small class="d-block text-right mt-3"><a data-toggle="modal" href="#myModal">회원 삭제</a></small></td>
								</tr>
			    			</c:forEach>
			    		</c:when>
			    		<c:otherwise>
			    			<tr>
					            <td colspan="11" class="text-center" style="line-height: 100px;">가입된 회원이 없습니다.</td>
					        </tr>
			    		</c:otherwise>
			    	</c:choose>				
			</tbody>
			</table>
		</div>
	</div>
</body>
</html>