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
			"url": "/searchMemberList2",
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
			{"data": "custNm"},
			{"data": "email"},
			{"data": "carrierCd"},
			{"data": "carrierNm"},
			{"data": "phoneNo"},
			{"data": "jboCd"},
			{"data": "jobNm"},
			{"data": "incmAmt"},
			{"data": "hopLoanAmt"},
		]
	});
	/*
	$.ajax({
		url: "/searchMemberList2",
		type: "POST",
		//dataType : "json",
		beforeSend : function(xhr)
		{
			xhr.setRequestHeader(header,token);
		},
		//setRequestHeader : header, token,
		//contentType : "application/json; charset=utf-8",
		success: function(data){

			console.log(data);


			var tableData ="";
			$("#table_tbody").append(tableData);

			$.each(data, function(index, value){
				tableData += '<tr>';
				tableData += '<td data-label="순번">'+value.custNm+'</td>';
				tableData += '<td data-label="기준일자">'+value.email+'</td>';
				tableData += '<td data-label="고객명">'+value.phoneNo+'</td>';
				tableData += '<td data-label="고객명">'+value.jobNm+'</td>';
				tableData += '<tr>';
			});

			$("#table_tbody").empty();
			$("#table_tbody").append(tableData);

			$("#table").DataTable({ });


		},
		//error: function(){
			alert("simpleWithObject err");
			//location.reload();
		}
	}); */
});


