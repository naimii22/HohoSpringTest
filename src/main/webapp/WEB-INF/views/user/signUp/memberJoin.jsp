<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<%@ include file="/WEB-INF/inc/head.jsp" %>
	<title>memberJoin</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/topbar.jsp" %>
	
	<div>
		 <div class="container" id="container">
      <div class="row" id="wrap">
         <form name="frm" name="myform" method="post"  enctype="multipart/form-data"
        action="${pageContext.request.contextPath}/member/join_ok.do">
            
            <h1 id="h1-style">회원가입</h1>
            <br>
            <table id="table-font">
               <tr>
                  <td>아이디<em>*</em></td>
                  <td><input type="text" class="form-control td-style" placeholder="아이디를 입력하세요" aria-label="name" aria-describedby="basic-addon1" name="id"></td>
                  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="btn btn-outline-info" value="중복체크" onclick="idCheck()"></td>
               </tr>
               <tr>
                  <td>비밀번호<em>*</em></td>
                  <td><input type="password" name="pwd" class="form-control td-style" placeholder="비밀번호를 입력하세요" aria-label="pwd" aria-describedby="basic-addon1" ></td>
               </tr>
               <tr>
                  <td>비밀번호 확인<em>*</em></td>
                  <td><input type="password" class="form-control td-style" name="pwdConfirm" aria-describedby="basic-addon1"></td>
               </tr>
               <tr>
                  <td>이름<em>*</em></td>
                  <td><input type="text" class="form-control td-style" placeholder="이름을 입력하세요" aria-label="name" aria-describedby="basic-addon1" name="name"></td>
               </tr>
               <tr>
                  <td>성별</td>
                  <td>&nbsp;&nbsp;&nbsp;<input type="radio" name="gender" value="1">여성&nbsp;&nbsp;&nbsp;&nbsp;
                     <input type="radio" name="gender" value="2">남성</td>
               </tr>
               <tr>
                  <td>생일</td>
                  <td><input type="date" class="form-control td-style" aria-label="birth" aria-describedby="basic-addon1" name="birth"></td>
               </tr>
               <tr>
                  <td>휴대폰 번호<em>*</em></td>
                  <td><input type="text" class="form-control td-style"  placeholder="전화번호를 입력하세요" aria-label="phone" aria-describedby="basic-addon1" name="phone"></td>
               </tr>
               <tr>
         			<td>우편번호</td>
                	<td colspan="2"><input type="text" name="postcode" id="postcode" class="form-control pull-left" style='width: 120px; margin-right: 5px'/>                
               		<!-- 클릭 시, Javascript 함수 호출 : openDaumPostcode() -->
               		<input type='button' value='우편번호 찾기' class='btn btn-warning' onclick='execDaumPostcode("postcode", "addr1", "addr2")'/>
      				</td>
        		</tr>
        		<tr>
            		<td>주소<em>*</em></td>
            		<td><input type="text" name="addr1" id="addr1" class="form-control td-style"/></td>
       			</tr>
       			<tr>
            		<td>상세주소</td>
            		<td><input type="text" name="addr2" id="addr2" class="form-control td-style"/></td>
           		</tr>
               <tr>
                  <td>이메일</td>
                  <td><input type="text" class="form-control td-style"  placeholder="이메일을 입력하세요" aria-label="email" aria-describedby="basic-addon1" name="email"></td>
               </tr>
            </table>
            <br><br>
               <input type="submit" class="btn btn-info" id="button" value="회원가입">
               <input type="reset" class="btn btn-info" id="button" value="취&nbsp;&nbsp;소">
           </form>
        </div>
      </div>
	</div>
	
	<%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>