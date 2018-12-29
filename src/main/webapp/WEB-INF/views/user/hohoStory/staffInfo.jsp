<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>staffInfo</title>
	<!-- css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/companyInfo.css">
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
	<fieldset>
		<h1 class="font">직원정보</h1>
		<table class="type07" id="tableSty">
			<thead>
				<tr>
					<th scope="col" class="textCenter">#</th>
					<th scope="col">이름</th>
					<th scope="col">직위</th>
					<th scope="col">연락처</th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<th scope="row" class="textCenter">1</th>
					<td>이나임</td>
					<td>사장</td>
					<td>010-1234-5678</td>
				</tr>
				<tr>
					<th scope="row" class="textCenter">2</th>
					<td>박혜련</td>
					<td>제빵사</td>
					<td>010-2151-7363</td>
				</tr>
				<tr>
					<th scope="row" class="textCenter">3</th>
					<td>소연희</td>
					<td>제빵사</td>
					<td>010-8425-2412</td>
				</tr>
				<tr>
					<th scope="row" class="textCenter">4</th>
					<td>곽로용</td>
					<td>바리스타</td>
					<td>010-2152-2425</td>
				</tr>
			</tbody>
		</table>
	</fieldset>

	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>