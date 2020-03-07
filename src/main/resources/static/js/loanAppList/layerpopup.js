$('.btn-custsave').click(function(){
    var $href = $(this).attr('href');
    layer_popup($href);
});

function layer_popup(el){


    var $el = $(el);        //레이어의 id를 $el 변수에 저장
    var isDim = $el.prev().hasClass('dimBg');   //dimmed 레이어를 감지하기 위한 boolean 변수

    isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

    var $elWidth = ~~($el.outerWidth()),
        $elHeight = ~~($el.outerHeight()),
        docWidth = $(document).width(),
        docHeight = $(document).height();

    // 화면의 중앙에 레이어를 띄운다.
    if ($elHeight < docHeight || $elWidth < docWidth) {
        $el.css({
            marginTop: -$elHeight /2,
            marginLeft: -$elWidth/2
        })
    } else {
        $el.css({top: 0, left: 0});
    }

    $el.find('a.btn-layerClose').click(function(){
        isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
        return false;
    });

    $el.find('a.btn-layerSave').click(function(){
        //alert('저장');
        var sendData = {
            "BASE_DT" : $('#sDate').val() ,
            "CUST_NM" : $('#sName').val(),
            "PHONE_NO" : $('#sPhone').val(),
            "BIRTH_YMD" : $('#sBirthYMD').val(),
            "SALARY_DIV_NM" : $('#sSalaryDiv').val(),
            "ING_DIV_NM" : $('#sIngYn').val(),
            "COUNTRY_NM" : $('#sCountry').val(),
            "INCOME_AMT" : $('#sIncomeAmt').val(),
            "OUT_AMT" : $('#sOutAmt').val(),
            "MEMO" : $('#sMemo').val(),
            "RGST_ID" : "TEST",//$('#sCountry').val(),
            "CHNG_ID" : "TEST"//$('#sCountry').val(),

        }
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $.ajax({
            url: "insertCheat",
            type: "POST",
            data:  sendData,
            async: false, //동기처리
            dataType : "json",
            beforeSend : function(xhr)
            {
                xhr.setRequestHeader(header,token);
            },
            //contentType : "application/json; charset=utf-8",
            success: function(data){
                //성공시 창을 닫는다
                $('.dim-layer').fadeOut();
                sendData  = "";
                location.reload();
                //return false;
                //alert("ajax");
            },
            error: function(){
                alert("simpleWithObject err");
                //location.reload();
            }
        });

        return false;
    });

    $('.layer .dimBg').click(function(){
        $('.dim-layer').fadeOut();
        return false;
    });

}
/* 오늘 날짜 구하는 함수 */
Date.prototype.toDateInputValue = (function() {
    var local = new Date(this);
    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
    return local.toJSON().slice(0,10);
});

/* 디폴트 값 설정 */
jQuery('document').ready(function(){
        $('#sDate').val(new Date().toDateInputValue());
});