<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
	
	<link rel="stylesheet" href="../../css/roulette.mobile.css" />
	
    <title>Welcome to the roulette!!</title>
</head>
<body>

<div data-role="page" id="mainPage">
	<div data-role="header" data-theme="b" data-position="fixed">
		<h1>오늘 점심  뭐먹지?</h1>
	</div>
	
	<div data-role="main" class="ui-content" style="padding-top: 2em;">
		<a href="#goToRoulette" class="ui-btn">메뉴 고르기</a>
	</div>
	
	<div data-role="main" class="ui-content">
		<a href="#goToMenuList" class="ui-btn" onClick="javaScript:showMenuListAll();">메뉴 추가하기</a>
	</div>
	
	<!-- <div data-role="footer">
		<h1>Footer Text</h1>
	</div> -->
</div>

<jsp:include page="mobile_menulist.jsp" flush="false" />
</body>
<script src="../../js/mobile_menulist.js"></script>
</html>