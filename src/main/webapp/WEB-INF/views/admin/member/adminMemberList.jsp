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
	<div class="container">
		<div class="row" id="wrap">
			<h1 class="Listheading">회원 리스트 - 관리자 페이지</h1>
			<table class="table table-hover" id="memberList">
			<thead>
				<tr>
					<th scope="col">아이디</th>
					<th scope="col">비밀번호</th>
					<th scope="col">이름</th>
					<th scope="col">성별</th>
					<th scope="col">생일</th>
					<th scope="col">휴대폰 번호</th>
					<th scope="col">이메일</th>
					<th scope="col">주소</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${memberList}">
					<tr>
						<th scope="row">${member.memberNum }</th>
						<td>${member.id}</td>
						<td>${member.pwd }</td>
						<td>${member.name }</td>
						<td>
							<c:choose>
								<c:when test="${member.gender == 1 }">여성</c:when>
								<c:otherwise>남성</c:otherwise>
							</c:choose>
						</td>
						<td>${member.birth }</td>
						<td>${member.phone }</td>
						<td>${member.email }</td>
						<td><small class="d-block text-right mt-3"><a href="BakeryServlet?command=memberDelete&id=${member.id}&loginUserId=${loginUser.id}">회원 삭제</a></small></td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
	</div>
</body>
</html>