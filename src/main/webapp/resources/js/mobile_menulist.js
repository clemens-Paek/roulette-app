
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

//초기화
(function(){
})();