<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 메뉴 리스트 -->
<div data-role="page" id="goToMenuList">
	<div data-role="header" data-theme="b" data-position="fixed">
		<a href="#mainPage" class="ui-btn ui-btn-b ui-btn-left ui-btn-inline ui-mini ui-corner-all ui-btn-icon-left ui-icon-back">Back</a>			
		<h1 id="headTitle_menuList">메뉴 리스트</h1>
		<a href="javaScript:showMenuListAll();" class="ui-btn ui-btn-b ui-btn-right ui-btn-inline ui-mini ui-corner-all ui-btn-icon-right ui-icon-refresh" id="menuListRefresh">새로고침</a>
	</div>
	
	<div class="ui-grid-a">
		<div class="ui-block-a" style="width: 75%; margin-left: 5px;">
			<input type="text" placeholder="점심 메뉴를 입력하세요." id="menulist_inputMenuName">
		</div>
		<div class="ui-block-b" style="width: 15%; margin-right: 5px;">
			<a href="#" class="ui-btn ui-btn-b ui-btn-inline ui-mini ui-corner-all ui-btn-icon-right ui-icon-plus" id="btnAddMenu" style="margin-top: 8px;">추가</a>
		</div>
	</div>
	
	<div data-role="main" class="ui-content" id='main_content"'>
		<div class="ui-body ui-body-a ui-corner-all">
			<table data-role="table" data-mode="" class="ui-responsive table-stroke" id="menuListTable">
                <thead>
				    <tr>
					   <td id="menulist_menuName" style="text-align: center; font-weight: bolder; width: 100%;" colspan="3">메  뉴</td>
					   <td></td>
				    </tr>
                </thead>
				<tbody></tbody>
			</table>
		</div>
	</div>
	
	<!-- <div data-role="footer">
		<h1>Footer Text</h1>
	</div> -->
</div>

<!-- 메뉴 룰렛 -->
<div data-role="page" id="goToRoulette">
	<div data-role="header" data-theme="b" data-position="fixed">
		<a href="#mainPage" class="ui-btn ui-btn-b ui-btn-left ui-btn-inline ui-mini ui-corner-all ui-btn-icon-left ui-icon-back">Back</a>			
		<h1 id="headTitle_menuRoulette">메뉴 룰렛</h1>
	</div>
	
	<div data-role="main" class="ui-content">
		<a href="javaScript:runRoulette();" class="ui-btn ui-corner-all ui-icon-recycle ui-btn-icon-right">룰렛 돌리기!!</a>
		
		<div id="choosedMenuDiv" style="margin: 50px 0px 50px 0px; padding: 20px 25px 20px 25px; border-color: white; text-align: center;">
            <input type="hidden" id="choosedMenuNo" value="">
			<span id="choosedMenuName" style="text-align: center; font-weight: bolder; font-size: 50px; width: 100%;"></span>
		</div>
		
		<div data-role="controlgroup" data-type="horizontal" align="center">
			<a href="javaScript:runRoulette();" class="ui-btn ui-btn-a">다시 돌릴래..</a>
			<a href="javaScript:saveTodayMenu();" class="ui-btn ui-btn-b">오늘은 이거다!!</a>
		</div>
	</div>
</div>

</html>