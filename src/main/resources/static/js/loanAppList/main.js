$('#btn-search').on('click', function(){
    var sendData = {
        "CUST_NM" : $('#CUST_NM').val() ,
        "PHONE_NO" : $('#PHONE_NO').val()
    }
    $.ajax({
        url: "searchCheat",
        type: "POST",
        data:  sendData,
        dataType : "json",
        //contentType : "application/json; charset=utf-8",
        success: function(data){

            var tableData ="";

            console.log(data);
            tableData += '    <thead>\n' +
                            '     <tr>\n' +
                            '      <th scope="col">등록순번</th>\n' +
                            '      <th scope="col">기준일자</th>\n' +
                            '      <th scope="col">고객명</th>\n' +
                            '      <th scope="col">휴대전화번호</th>\n' +
                            '      <th scope="col">생년월일</th>\n' +
                            '      <th scope="col">소득구분명</th>\n' +
                            '      <th scope="col">진행구분명</th>\n' +
                            '      <th scope="col">지역명</th>\n' +
                            '      <th scope="col">소득금액</th>\n' +
                            '      <th scope="col">대출금액</th>\n' +
                            '      <th scope="col">메모</th>\n' +
                            '    </tr>\n' +
                            '    </thead>' +
                '';
            tableData += '<tbody>';
            $.each(data, function(index, value){
                tableData += '<tr>';
                tableData += '<td class="col col-1" data-label="순번">'+value.SEQ+'</td>';
                tableData += '<td class="col col-2" data-label="기준일자">'+value.BASE_DT+'</td>';
                tableData += '<td class="col col-3" data-label="고객명">'+value.CUST_NM+'</td>';
                tableData += '<td class="col col-4" data-label="휴대전화번호">'+value.PHONE_NO+'</td>';
                tableData += '<td class="col col-5" data-label="생년월일">'+value.BIRTH_YMD+'</td>';
                tableData += '<td class="col col-6" data-label="소득구분명">'+value.SALARY_DIV_NM+'</td>';
                tableData += '<td class="col col-7" data-label="진행구분명">'+value.ING_DIV_NM+'</td>';
                tableData += '<td class="col col-8" data-label="지역명">'+value.COUNTRY_NM+'</td>';
                tableData += '<td class="col col-9" data-label="소득금액">'+value.INCOME_AMT+'</td>';
                tableData += '<td class="col col-10" data-label="대출금액">'+value.OUT_AMT+'</td>';
                tableData += '<td class="col col-11" data-label="메모">'+value.MEMO+'</td>';
                tableData += '<tr>';
            });
            tableData += '</tbody>';

            $("#table").empty();
            $("#pagination").empty();

            $("#table").append(tableData);
            pagination();

            //$("#usrInfo").append(data);
        },
        error: function(){
            alert("simpleWithObject err");
            //location.reload();
        }
    });
});


function pagination(){
    var req_num_row=10;
    var $tr=jQuery('tbody tr');
    var total_num_row=$tr.length/2; //이상함..........length가 2배로나옴 ㅡㅡ
    var num_pages=0;
    console.log(total_num_row);
    if(total_num_row % req_num_row ==0){
        num_pages=total_num_row / req_num_row;
    }
    if(total_num_row % req_num_row >=1){
        num_pages=total_num_row / req_num_row;
        num_pages++;
        num_pages=Math.floor(num_pages++);
    }

    jQuery('.pagination').append("<li><a class=\"prev\">◀</a></li>");

    for(var i=1; i<=num_pages; i++){
        jQuery('.pagination').append("<li><a>"+i+"</a></li>");
        jQuery('.pagination li:nth-child(2)').addClass("active");
        jQuery('.pagination a').addClass("pagination-link");
    }

    jQuery('.pagination').append("<li><a class=\"next\">▶</a></li>");

    $tr.each(function(i){
        jQuery(this).hide();
        if(i+1 <= req_num_row){
            $tr.eq(i).show();
        }
    });

    jQuery('.pagination a').click('.pagination-link', function(e){
        e.preventDefault();
        $tr.hide();
        var page=jQuery(this).text();
        var temp=page-1;
        var start=temp*req_num_row;
        var current_link = temp;

        jQuery('.pagination li').removeClass("active");
        jQuery(this).parent().addClass("active");

        for(var i=0; i< req_num_row; i++){
            $tr.eq(start+i).show();
        }

        if(temp >= 1){
            jQuery('.pagination li:first-child').removeClass("disabled");
        }
        else {
            jQuery('.pagination li:first-child').addClass("disabled");
        }

    });

    jQuery('.prev').click(function(e){
        e.preventDefault();
        jQuery('.pagination li:first-child').removeClass("active");
    });

    jQuery('.next').click(function(e){
        e.preventDefault();
        jQuery('.pagination li:last-child').removeClass("active");
    });

}
/*
jQuery('document').ready(function(){
    //pagination();

    jQuery('.pagination li:first-child').addClass("disabled");

}
);*/