
/*
 * "메뉴 추가하기" or "새로고침" 버튼 클릭
 */
function showMenuListAll() {
	var records = "";
	
	$.mobile.loading('show');
	$.ajax({
		type: 'POST',
		dataType: 'JSON',
		url: '/menu/list/all',
		error: function() {
			$.mobile.loading("hide");
			alert("에러!!");
		},
		success: function(returnJSON) {
			$.mobile.loading("hide");
			$.each(returnJSON.items, function(i, menuList) {
				records +='<tr>'
					+ '<td style="width: 90%;"><span style="margin-left: 5px;">' + menuList.menuName + '</span></td>'
					+ '<td>'
					+ '<a href="#" onClick="javaScript:deleteMenu(' + menuList.menuNo + ');" class="ui-btn ui-corner-all ui-mini ui-icon-delete ui-btn-icon-notext" style="text-align: right;"></a>'
					+ '</td>'
					+ '</tr>';
			});
			$('#menuListTable > tbody').html(records);
			
		}
	});
}

/*
 * 추가 버튼 클릭
 */
$('#btnAddMenu').click(function() {
	alert('addMenu 들어옴!');
	var params = {
			"menuName": $('#menulist_inputMenuName').val()
	};
	
	$.mobile.loading('show');
	$.ajax({
		type: 'POST',
		dataType: 'JSON',
		data: params,
		url: '/menu/list/add',
		error: function() {
			$.mobile.loading("hide");
			alert("에러!!");
		},
		success: function(returnJSON) {
			$('#menulist_inputMenuName').val('');
			showMenuListAll();
		}
	});
});

/*
 * 삭제 버튼 클릭
 */
function deleteMenu(menuNo) {
	var params = {
			"menuNo": menuNo
	};
	
	$.mobile.loading('show');
	$.ajax({
		type: 'POST',
		dataType: 'JSON',
		data: params,
		url: '/menu/list/delete',
		error: function() {
			$.mobile.loading("hide");
			alert("에러!!");
		},
		success: function(returnJSON) {
			showMenuListAll();
		}
	});
}

/*
 * 엔터 클릭
 */
$('#menulist_inputMenuName').keypress(function(e){
	if(e.keyCode == 13){		
		$('#btnAddMenu').click();
	}
});

//초기화
(function(){
})();