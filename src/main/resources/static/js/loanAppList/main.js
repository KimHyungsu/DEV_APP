$('#btn-search').on('click', function(){
    var sendData = {
        "name" : $('#name').val() ,
        "phone" : $('#phone').val()
    }
    $.ajax({
        url: "searchUsrInfo2",
        type: "POST",
        data:  sendData,
        dataType : "json",
        //contentType : "application/json; charset=utf-8",
        success: function(data){

            var tableData ="";
            console.log(data);

            tableData += '<tbody>';
            $.each(data, function(index, value){
                tableData += '<tr>';
                tableData += '<td class="col col-1" data-label="신청순번">'+value.seq+'</td>';
                tableData += '<td class="col col-2" data-label="고객명">'+value.custNm+'</td>';
                tableData += '<td class="col col-3" data-label="이메일">'+value.email+'</td>';
                tableData += '<td class="col col-4" data-label="통신사">'+'SKT'+'</td>';
                tableData += '<td class="col col-5" data-label="휴대전화번호">'+value.phoneNo+'</td>';
                tableData += '<td class="col col-6" data-label="직업">'+value.jobNm+'</td>';
                tableData += '<td class="col col-7" data-label="소득금액">'+value.incmAmt+'</td>';
                tableData += '<td class="col col-8" data-label="희망대출금액">'+value.hopLoanAmt+'</td>';
                tableData += '<tr>';
            });
            tableData += '</tbody>';

            $("#table").empty();
            $("#pagination").empty();

            $("#table").append(tableData);
            pagination();;
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