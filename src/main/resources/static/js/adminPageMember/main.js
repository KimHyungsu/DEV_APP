var editor;

$(document).ready(function() {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");


	editor = new $.fn.dataTable.Editor( {
		ajax: {
			create: {
				type: 'POST',
				url:  '/insertloanCustInfo',
				data: function(d){
					return $.extend({},d, {
						"BASE_DT" : $('#DTE_Field_base_DT').val(),
						"PHONE_NO" : $('#DTE_Field_phone_NO').val(),
						"CUST_NM" : $('#DTE_Field_cust_NM').val(),
						"APRV_AMT" : $('#DTE_Field_aprv_AMT').val(),
						"COLT_AMT" : $('#DTE_Field_colt_AMT').val(),
						"USEDT_CNT" : $('#DTE_Field_usedt_CNT').val(),
					});
				},
				dataType : "json",
				beforeSend : function(xhr)
				{
					xhr.setRequestHeader(header,token);
				},
				success: function(data){
					//console.log("성공 : " +data);

					var table = $('#table').DataTable();
					table.ajax.reload(); //데이터 테이블 리로드

					return true;
				},
				error: function(){
					alert("simpleWithObject err");
					//location.reload();
				},
				complete:function(){
					return true;
					//progress image close
				}
			},
			edit: {
				type: 'PUT',
				url:  '#'
			},
			remove: {
				type: 'DELETE',
				url:  '#'
			}
		},
		table: "#table",
		fields: [ /*{
			label: "순번:",
			name: "seq"
		},*/ {
			label: "기준일자:",
			name: "base_DT"
		}, {
			label: "휴대전화번호:",
			name: "phone_NO"
		}, {
			label: "고객명:",
			name: "cust_NM"
		}, {
			label: "승인금액:",
			name: "aprv_AMT"
		}, {
			label: "회수금액:",
			name: "colt_AMT"
		}/*, {
			label: "회차:",
			name: "round"
		}*/, {
			label: "사용일수:",
			name: "usedt_CNT"
		}
		]
	} );

	$('#table').DataTable( {
		dom: "Bfrtip",
		ajax: {
			"url": "/searchloanCustInfo",
			"type": "POST",
			beforeSend : function(xhr)
			{
				xhr.setRequestHeader(header,token);
			},
			"dataSrc": function(res) {
				console.log(res);

				var data = '';

				data = res;//.data;

				return data;
			},
		},
		columns: [
			/*
			{ data: null, render: function ( data, type, row ) {
					// Combine the first and last names into a single table field
					return data.first_name+' '+data.last_name;
				} },

			 */
			{ data: "seq"},
			{ data: "base_DT"},
			{ data: "phone_NO"},
			{ data: "cust_NM"},
			{ data: "aprv_AMT"},
			{ data: "colt_AMT"},
			{ data: "usedt_CNT"},
			{ data: "round"},
			{ data: "today_COLT_AMT"},
			{ data: "tot_COLT_AMT"},
		],
		select: true,
		buttons: [
			{ extend: "create", editor: editor },
			{ extend: "edit",   editor: editor },
			{ extend: "remove", editor: editor }
		]
	} );
} );

/*
	$('#btn-search').on('click', function(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	var lang_kor = {
		"decimal" : "",
		"emptyTable" : "데이터가 없습니다.",
		"info" : "_START_ - _END_ (총 _TOTAL_ 명)",
		"infoEmpty" : "0명",
		"infoFiltered" : "(전체 _MAX_ 명 중 검색결과)",
		"infoPostFix" : "",
		"thousands" : ",",
		"lengthMenu" : "_MENU_ 개씩 보기",
		"loadingRecords" : "로딩중...",
		"processing" : "처리중...",
		"search" : "검색 : ",
		"zeroRecords" : "검색된 데이터가 없습니다.",
		"paginate" : {
			"first" : "첫 페이지",
			"last" : "마지막 페이지",
			"next" : "다음",
			"previous" : "이전"
		},
		"aria" : {
			"sortAscending" : " :  오름차순 정렬",
			"sortDescending" : " :  내림차순 정렬"
		}
	};

	$('#table').DataTable().destroy(); //데이터테이블 초기화
	$("#table").DataTable({
		"serverSide": false,
		"processing": true,
		"ajax": {
			"url": "/searchloanCustInfo",
			"type": "POST",
			beforeSend : function(xhr)
			{
				xhr.setRequestHeader(header,token);
			},
			"dataSrc": function(res) {
				console.log(res);

				var data = '';

				data = res;//.data;

				return data;
			},
		},
		//language:lang_kor,
		"columns" : [
			{"data": "seq"},
			{"data": "base_DT"},
			{"data": "phone_NO"},
			{"data": "cust_NM"},
			{"data": "aprv_AMT"},
			{"data": "colt_AMT"},
			{"data": "round"},
			{"data": "usedt_CNT"},
			//{"data": "rgst_ID"},
			//{"data": "rgst_DTTM"},
			//{"data": "chng_ID"},
			//{"data": "chng_DTTM"},
		]
	});
});
*/

