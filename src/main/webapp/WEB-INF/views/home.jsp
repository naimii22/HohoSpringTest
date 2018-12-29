<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!doctype html>
<html lang='ko'>
<head>
	<meta charset='utf-8' />
	<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
	<title>Home</title>
	<!-- Bootstrap + jQuery -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!--// Bootstrap + jQuery -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/home.css">
</head>
<body>
    <div id="video-bg">
        <!-- 컨트롤 버튼 -->
        <div id="controlls">
            <a href="#" class="tubular-play">play</a> <!-- class이름과 하단 플러그인 참고에서 Button: '여기'하고만 같으면 됨. -->
            <a href="${pageContext.request.contextPath}/user/hohoStory/companyInfo.do">회사</a>
			<a href="${pageContext.request.contextPath}/user/hohoStory/hohoMap.do">지도</a>
			<a href="${pageContext.request.contextPath}/user/hohoStory/staffInfo.do">직원</a>
			<a href="${pageContext.request.contextPath}/user/hohoStory/notice.do">공지사항</a>
			<a href="${pageContext.request.contextPath}/user/hohoStory/noticeView.do">공지상세</a>
			<a href="${pageContext.request.contextPath}/user/qna/qna.do">Q & A</a>
			<a href="${pageContext.request.contextPath}/user/cart/productCartList.do">장바구니</a>
			<a href="${pageContext.request.contextPath}/user/like/productLikeList.do">찜</a>
			<a href="${pageContext.request.contextPath}/user/order/memberOrderList.do">주문목록</a>
			<a href="${pageContext.request.contextPath}/user/order/memberOrderView.do">주문상세</a>
			<a href="${pageContext.request.contextPath}/user/login/login.do">로그인</a>
        </div>

        <!-- 페이지 컨텐츠 -->
        <div class="front-content">
            <!-- <h1>Hoho's bakery</h1> -->
            <p><a class="logo" href="https://www.naver.com/"><img src="${pageContext.request.contextPath}/assets/img/logo_home.png" /></a></p>
        </div>
    </div>

    <script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/tubular/jquery.tubular.1.0.js"></script>
    <script>
        $(function() {
            $('#video-bg').tubular({ 
                videoId: 'qssE3pmKmhM',                 // 영상 id

                /** 옵션 */
                ratio: 16/9,                            // 영상비율 4/3 or 16/9
                mute: false,                            // 음소거 설정 (true,false)
                repeat: true,                           // 반복재생 설정
                width: $("#video-bg").width(),          // 동영상의 넓이 (부모요소의 넓이로 지정한다.)
                wrapperZIndex: 99,                      // z-index 설정값
                start: 102,                               // 재생 시작 위치 (초) --> 3초후 위치부터 재생시작

                /** 동작버튼. 여기서 설정한 클래스의 버튼을 찾아 기능이 부여된다 */
                playButtonClass: 'tubular-play',        // 재생버튼의 클래스
            });

            setTimeout(function() {
                $(".front-content").fadeIn(4000);
            }, 7000);
        });
    </script>
</body>
</html>
