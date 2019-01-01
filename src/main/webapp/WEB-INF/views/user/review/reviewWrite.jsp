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
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
<div class="container">
	<form action="${pageContext.request.contextPath}/user/review/reviewWriteOk.do">
		<div class="form-group">
			<label class="col-sm-2 control-label">제 목</label>
		    <div class="col-sm-10">
			      <input class="form-control" type="text" name="tile" id="title" />
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
		      	<div class="form-control">★★★★★</div>
		    </div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">사 진</label>
		    <div class="col-sm-10">
		     	<input class="form-control" type="file" name="image" id="image"/>
		    </div>
		</div>
	</form>
</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>