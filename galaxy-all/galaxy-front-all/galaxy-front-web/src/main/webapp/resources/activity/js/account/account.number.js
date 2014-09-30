$(document).ready(function(){
	//加载当前用户支付宝信息
	loadcurrentUserAlipayInfo();
	var result = getQueryString("errormessage");
	if(result){
		alert(result);
	}
});


//加载当前用户支付宝信息
function loadcurrentUserAlipayInfo(){
	var url = js_huodongshu_domain+'/account/getcustalipayinfo.do';
	$.ajax({
		url: url,
		dataType: "json",
		success: function(msg){
           var custinfo = msg.data;
           var alipay_number = $.trim(custinfo.alipay_number);
           $("#account_alipay").val(alipay_number);
		}
   });
}


//账户支付宝信息保存
function account_number_save(){
	var url = js_huodongshu_domain+'/account/updateAlipayInfo.do';
	var account_alipay = $("#account_alipay").val(); 
	account_alipay = $.trim(account_alipay);
	if(account_alipay == ''){
		var error = "<font color='red'>支付宝信息必填!<font>";
		$("#error_account_alipay").html(error);
	}else{
		$.ajax({
			type: "POST",
			url: url,
			data: {account_alipay:account_alipay},
			dataType : "json",
			success: function(msg){
				if(msg.status == 0){
					alert(msg.msg);
				}else{
					alert('保存成功');
				}
			}
	    });
	}
}