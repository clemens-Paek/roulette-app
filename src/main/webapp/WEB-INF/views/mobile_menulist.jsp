<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div data-role="page" id="goToMenuList">
	<div data-role="header" data-theme="b" data-position="fixed">
		<a href="#mainPage" class="ui-btn ui-btn-b ui-btn-left ui-btn-inline ui-mini ui-corner-all ui-btn-icon-left ui-icon-back">Back</a>			
		<h1 id="headTitle">메뉴 리스트</h1>
		<a href="#" class="ui-btn ui-btn-b ui-btn-right ui-btn-inline ui-mini ui-corner-all ui-btn-icon-right ui-icon-refresh" id="menuListRefresh">새로고침</a>
	</div>
	
	<div class="ui-grid-a">
		<div class="ui-block-a" style="width: 80%">
			<input type="text" placeholder="점심 메뉴를 입력하세요." id="menulist_inputMenuName">
		</div>
		<div class="ui-block-b" style="width: 20%">
			<a href="#" class="ui-btn ui-btn-b ui-btn-inline ui-mini ui-corner-all ui-btn-icon-right ui-icon-plus" id="btnAddMenu" style="margin-top: 8px;">추가</a>
		</div>
	</div>
	
	<div role="main" class="ui-content" id='main_content"'>
		<div class="ui-body ui-body-a ui-corner-all">
			<table data-role="table" data-mode="" class="ui-responsive table-stroke">
				<tr>
					<th id="menulist_menuName" name="menuName">메뉴</th>
				</tr>
			</table>
		</div>
	</div>
	
	<!-- <div data-role="footer">
		<h1>Footer Text</h1>
	</div> -->
</div>

</html>