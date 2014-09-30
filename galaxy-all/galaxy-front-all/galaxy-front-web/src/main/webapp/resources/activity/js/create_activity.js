/*huangshanqi*/

$(document).ready(function(){
	
	/*检查活动名*/
	$("#event_name").blur(
			function(){
				var event_name = $("#event_name").val();
				//alert(event_name);
				var result = checkSpecialChar(event_name);
				if(!result){
					var message = '<span class="icon"></span><font color=\'red\'>活动名称不能含特殊字符！</font>';
					$("#error_event_name").html(message);
					$("#event_name").focus();
				}	
			}		
			);
	/*检查地点名*/
	$("#event_address_name").blur(
			function(){
				var address_name = $("#event_address_name").val();
				var result = checkSpecialChar(address_name);
				if(!result){
					var message = '<span class="icon"></span><font color=\'red\'>地点不能含特殊字符！</font>';
					$("#error_event_address_name").html(message);
					$("#event_address_name").focus();
				}	
			}		
			);
	
	/*检查详细地址*/
	$("#detail_address_name").blur(
			function(){
				var address_name = $("#detail_address_name").val();
				var result = checkSpecialChar(address_name);
				if(!result){
					var message = '<span class="icon"></span><font color=\'red\'>详细地址不能含特殊字符！</font>';
					$("#error_detail_address").html(message);
					$("#detail_address_name").focus();
				}	
			}		
			);
	
	/*检查手机号码*/
	$("#event_refer_telephone").blur(
			function(){
				var telephone = $("#event_refer_telephone").val().trim();
				var reg=/^\d{1}([0-9-]){1,20}[;]?([0-9-]){1,20}$/;
				var result = reg.test(telephone);
				if(!result){
					var message = '<span class="icon"></span><font color=\'red\'>咨询电话格式有误！</font>';
					$("#error_event_refer_telephone").html(message);
					$("#event_refer_telephone").focus();
				}	
			}		
			);
	
	/*检查活动介绍*/
	$("#huodongjieshao").blur(
			function(){
				var huodongjieshao = $("#huodongjieshao").val();
				alert(huodongjieshao);
				var result = checkSpecialChar(address_name);
				if(!result){
					var message = '<span class="icon"></span><font color=\'red\'>详细地址不能含特殊字符！</font>';
					$("#error_detail_address").html(message);
					$("#huodongjieshao").focus();
				}	
			}		
			);
	
	var huodongjianjie = $("textarea[name='huodongjianjie']").val();
}
);

/*检查名字是否有特殊字符*/
function checkSpecialChar(str){
	str = $.trim(str);
    if(str.indexOf("\"") == -1 && str.indexOf("'") == -1 && str.indexOf("<") == -1 && str.indexOf(">") == -1  && str.indexOf("*") == -1  && str.indexOf("%") == -1 && str.indexOf("&") == -1 && str.indexOf("$") == -1    && str.indexOf("!") == -1){
      return true;
    }    
    return false;
}