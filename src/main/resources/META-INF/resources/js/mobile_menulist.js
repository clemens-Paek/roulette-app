/**
 * 메뉴 정하기
 * @returns
 */

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
					+ '<td style="width: 90%;"><span style="margin-left: 5px;" id="menuSpan' + menuList.menuNo + '">' + menuList.menuName + '</span></td>'
					+ '<td id="editBtnTd' + menuList.menuNo + '">'
					+ '<a href="#" onClick="javaScript:editMenu(' + menuList.menuNo + ', \'' + menuList.menuName + '\');" class="ui-btn ui-corner-all ui-mini ui-icon-edit ui-btn-icon-notext" style="text-align: right;"></a>'
					+ '</td>'
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
 * 엔터 클릭
 */
$('#menulist_inputMenuName').keypress(function(e){
	if(e.keyCode == 13){		
		$('#btnAddMenu').click();
	}
});

/*
 * 수정 버튼 클릭
 */
function editMenu(menuNo, menuName) {
	$('#menuSpan' + menuNo).html('<input type="text" style="width: 90%;" id="menuInput' + menuNo + '" value="' + menuName + '">');
	$('#editBtnTd' + menuNo).html(
		'<a href="#" onClick="javaScript:updateMenu(' + menuNo + ');" '
		+ 'class="ui-btn ui-btn-b ui-corner-all ui-mini ui-icon-check ui-btn-icon-notext" style="text-align: right;"></a>'	
	);
}

/*
 * 업데이트 버튼 클릭
 */
function updateMenu(menuNo) {
	var menuName = $('#menuInput' + menuNo).val();
	var params = {
			"menuNo": menuNo,
			"menuName": menuName
	};
	
	$.mobile.loading('show');
	$.ajax({
		type: 'POST',
		dataType: 'JSON',
		data: params,
		url: '/menu/list/update',
		error: function() {
			$.mobile.loading("hide");
			alert("에러!!");
		},
		success: function(returnJSON) {
			$.mobile.loading("hide");
			$('#menuSpan' + menuNo).html(menuName);
			$('#editBtnTd' + menuNo).html(
				'<a href="#" onClick="javaScript:editMenu(' + menuNo + ', \'' + menuName + '\');" '
				+ 'class="ui-btn ui-corner-all ui-mini ui-icon-edit ui-btn-icon-notext" style="text-align: right;"></a>'
			);
		}
	});
}

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
 * 룰렛 돌리기
 */
function runRoulette() {
	$('#choosedMenuNo').val('');
	$('#choosedMenuName').html('');
	
	$.mobile.loading('show');
	setTimeout(function() {
		$.ajax({
			type: 'POST',
			dataType: 'JSON',
			url: '/menu/list/roulette',
			error: function() {
				$.mobile.loading("hide");
				alert("에러!!");
			},
			success: function(returnJSON) {
				$.mobile.loading("hide");
				$('#choosedMenuNo').val(returnJSON.data.menuNo);
				$('#choosedMenuName').html(returnJSON.data.menuName);
			}
		});
	}, 1000);
}

/*
 * 정한 메뉴 저장하기
 */
function saveTodayMenu() {
	var params = {
			"menuNo": $('#choosedMenuNo').val(),
			"menuName": $('#choosedMenuName').html()
	}
	
	$.mobile.loading('show');
	$.ajax({
		type: 'POST',
		dataType: 'JSON',
		data: params,
		url: '/menu/list/save',
		error: function() {
			$.mobile.loading("hide");
			alert("에러!!");
		},
		success: function(returnJSON) {
			$.mobile.loading("hide");
			alert('저장 완료!');
		}
	});
}

/*
 * 선택된 메뉴이름 초기화
 */
function initChoosedMenuName() {
	$('#choosedMenuName').html('');
}

//초기화
(function(){
})();