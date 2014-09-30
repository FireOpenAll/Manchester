$(document).ready(function(){
	//安全页
	var urlname = get_current_urlname();
	if(urlname == 'account_safe.html'){
		loadPageInfo();
	}
	//手机验证页
	if($("#third_step_content")){
		$("#third_step_content").hide();
		$("#third_step").hide();
		$("#second_step_content").hide();
		$("#second_step").hide();
		updateValidatecode('img_validatecode');
	}
	//手机修改页
	if($("#phone_update_third")){
		$("#phone_update_third").hide();
		$("#phone_update_second").hide();
		$("#phone_update_third_step").hide();
		$("#phone_update_second_step").hide();
		updateValidatecode('img_update_mobile_validatefirst');
	}
	var mailtype = getQueryString("mailtype");
	mailtype = $.trim(mailtype);
	//邮箱验证页
	if(mailtype == '1'){
		$("#div_mailvalidate_first_step").show();
		$("#div_mailvalidate_first").show();
		$("#div_mailvalidate_second_step").hide();
		$("#div_mailvalidate_second").hide();
		$("#div_mailvalidate_third_step").hide();
		$("#div_mailvalidate_third").hide();
	}
	if(mailtype == '3'){
		$("#div_mailvalidate_first_step").hide();
		$("#div_mailvalidate_first").hide();
		$("#div_mailvalidate_second_step").hide();
		$("#div_mailvalidate_second").hide();
		$("#div_mailvalidate_third_step").show();
		$("#div_mailvalidate_third").show();
	}
	//邮箱修改页
	if(mailtype == '2' ){
		$("#div_updateemail_first_step").show();
		$("#div_updateemail_first_1").show();
		$("#div_updateemail_first_2").hide();
		$("#div_updateemail_second_step").hide();
		$("#div_updateemail_second_1").hide();
		$("#div_updateemail_second_2").hide();
		$("#div_updateemail_third_step").hide();
		$("#div_updateemail_third").hide();
	}
	if(mailtype == '4' ){
		$("#div_updateemail_first_step").hide();
		$("#div_updateemail_first_1").hide();
		$("#div_updateemail_first_2").hide();
		$("#div_updateemail_second_step").show();
		$("#div_updateemail_second_1").show();
		$("#div_updateemail_second_2").hide();
		$("#div_updateemail_third_step").hide();
		$("#div_updateemail_third").hide();
	}
	if(mailtype == '6'){
		$("#div_updateemail_first_step").hide();
		$("#div_updateemail_first_1").hide();
		$("#div_updateemail_first_2").hide();
		$("#div_updateemail_second_step").hide();
		$("#div_updateemail_second_1").hide();
		$("#div_updateemail_second_2").hide();
		$("#div_updateemail_third_step").show();
		$("#div_updateemail_third").show();
	}
});//end document.ready

//加载页面信息
function loadPageInfo(){
	 var url = js_huodongshu_domain+'/account/getSafeInfo.do';
	  $.ajax({
			url: url,
			dataType: "json",
			success: function(msg){
             if(msg.status == 1){
           	    //安全等级
            	$("#em_safe_grade").attr("class","level leve_"+msg.data.safegrade);
            	//邮箱验证状态
            	var email_safe_status = msg.data.email_verified == 1?"succeed":"warn";
            	$("#li_email_status").attr("class",email_safe_status);
            	//手机验证状态
            	var mobile_safe_status = msg.data.mobile_verified == 1?"succeed":"warn";
            	$("#li_mobile_status").attr("class",mobile_safe_status);
            	
            	//加载手机，邮箱
            	var mobile = msg.data.mobile;
            	mobile = $.trim(mobile);
            	if(mobile == ''){
            		$("#p_mobile_status").html("你尚无验证的手机");
            		$("#a_validate_mobile").attr("href","/html/account_phoneVerifiction.html");
            		$("#a_validate_mobile").html("验证手机");
            	}else{
            		$("#p_mobile_status").html("您验证的手机："+mobile+"</p>主办方用于接收短信提醒。");
            		$("#a_validate_mobile").attr("href","/html/account_revisePhone.html");
            		$("#a_validate_mobile").html("修改手机");
            	}
            	var email = msg.data.email;
            	email = $.trim(email);
            	if(email == ''){
            		$("#a_link_emailvalidate").attr("href","/html/account_mailVerifiction.html?mailtype=1");
            		$("#a_link_emailvalidate").html("验证邮箱");
            		$("#p_email_status").html("尚未进行邮箱验证");
            	}else{
            		$("#a_link_emailvalidate").attr("href","/html/account_reviseEmail.html?mailtype=2");
            		$("#a_link_emailvalidate").html("修改邮箱");
            		$("#p_email_status").html("邮箱"+email+"已经进行验证");
            		
            	}
            	
            	
             }else{
	           	  var message = msg.msg;
	           	  message = $.trim(message);
	           	  if(message != ''){
	           		  alert(msg.msg);
	           	  }
             }
			}
	   });
}



//图片验证1
//type值1手机验证第一步2手机修改第一个获取验证码按钮{3手机验证第二步(提交按钮)4手机修改第一个下一步按钮}
//5手机修改第二步获取验证码按钮（6手机修改第二步填写手机收到的验证码）
//receivetype1邮箱2手机
function validatefirst(receiveinputid,validatepictureid,type,receivetype){
	
	var receiveinputid = $("#"+receiveinputid).val();
	receiveinputid = $.trim(receiveinputid);
	var validatepictureid =  $("#"+validatepictureid).val();
	validatepictureid = $.trim(validatepictureid);
	type = $.trim(type);
	receivetype = $.trim(receivetype);
	var url = js_huodongshu_domain+'/account/theValidate.do';
	$.ajax({
			url: url,
			dataType: "json",
			data:{type:type,validatecode:validatepictureid,mobile:receiveinputid,receivetype:receivetype},
			success: function(msg){
              if(msg.status == 0){
            	  //更换验证码
            	  if($("#img_validatecode").length == 1){
            		  updateValidatecode('img_validatecode');
            	  }else if($("#img_mail_validate_first").length == 1){//
            		  updateValidatecode('img_mail_validate_first');
            	  }else if($("#img_updateemail_first_1").length == 1){//
            		  updateValidatecode('img_updateemail_first_1');
            	  }else if($("#img_updateemail_second_1").length == 1){//
            		  updateValidatecode('img_updateemail_second_1');
            	  }
            	  else if($("#img_update_mobile_validatefirst").length == 1){//
            		  updateValidatecode('img_update_mobile_validatefirst');
            	  }
            	  else if($("#img_update_mobile_validatesecond").length == 1){//
            		  updateValidatecode('img_update_mobile_validatesecond');
            	  }
            	  else if($("#img_validatecode").length == 1){//
            		  updateValidatecode('img_validatecode');
            	  }
            	  
            	  //错误信息提示
            	  if(receivetype == 1 && type == 1){//邮箱验证第一步
            		  $("#email_validate_ul").attr("class","error");
            		  $("#email_validate_ul_error").html('<span class="icon"></span>'+msg.msg);
            	  }else if(receivetype == 1 && type == 2){//邮箱修改第一步
            		  $("#email_update_ul").attr("class","error");
            		  $("#email_update_ul_error").html('<span class="icon"></span>'+msg.msg);
            	  }else if(receivetype == 1 && type == 5){//邮箱修改第二步 
            		  $("#xin_email_error").attr("class","error");
            		  $("#xin_email_error_ul_error").html('<span class="icon"></span>'+msg.msg);
            	  }else if(receivetype == 2 && type == 1){//手机验证第一步  
            		  $("#ul_phone_validate").attr("class","error");
            		  $("#ul_phone_validate_error").html('<span class="icon"></span>'+msg.msg);
            	  }else if(receivetype == 2 && type == 2){//手机修改第一步 
            		  $("#ul_mobile_update_f").attr("class","error");
            		  $("#ul_mobile_update_f_error").html('<span class="icon"></span>'+msg.msg);
            	  }else if(receivetype == 2 && type == 5){//手机修改第二步 
            		  $("#ul_mobile_update_f2").attr("class","error");
            		  $("#ul_mobile_update_f2_error").html('<span class="icon"></span>'+msg.msg);
            	  }
            	  else{
            		  alert(msg.msg);
            	  }
            	 
              }else if(msg.status == 1){
 
            	  if(type == 1 && receivetype == 2){//手机验证第一步获取图片验证码
            		    $("#first_step").hide();
            		    $("#first_step_content").hide();
            			$("#third_step_content").hide();
            			$("#third_step").hide();
            			$("#second_step_content").show();
            			$("#second_step").show();
            		  
            	  }else if(type == 2 && receivetype == 2){//手机修改第一步获取图片验证码
            		    $("#input_first_phoneupdate").attr("redonly","redonly");
          		        $("#input_first_phoneupdate_validatecode").attr("redonly","redonly");
            		    alert('验证码已经发送到你手机，请填写下方的验证码');
            	  }else if(type == 5 && receivetype == 2){//手机修改第二步获取图片验证码
            		    $("#input_phoneupdate_second").attr("redonly","redonly");
        		        $("#input_phoneupdate_second_validatecode").attr("redonly","redonly");
          		        alert('验证码已经发送到你新手机，请填写下方的验证码');
            		  
            	  }else if(type == 1 && receivetype == 1){//邮箱验证第一步获取图片验证码
            		    $("#div_mailvalidate_first_step").hide();
            			$("#div_mailvalidate_first").hide();
            			$("#div_mailvalidate_second_step").show();
            			$("#div_mailvalidate_second").show();
            			$("#mb_span_email").html(receiveinputid);//动态邮箱值
            			$("#div_mailvalidate_third_step").hide();
            			$("#div_mailvalidate_third").hide();
            		  
            	  }else if(type == 2 && receivetype == 1){//邮箱修改第一步获取图片验证码
            		    $("#div_updateemail_first_step").show();
            			$("#div_updateemail_first_1").hide();
            			$("#div_updateemail_first_2").show();
            			$("#div_updateemail_first_2_span").html(receiveinputid);//动态邮箱值
            			$("#div_updateemail_second_step").hide();
            			$("#div_updateemail_second_1").hide();
            			$("#div_updateemail_second_2").hide();
            			$("#div_updateemail_third_step").hide();
            			$("#div_updateemail_third").hide();
            		  
            	  }else if(type == 5 && receivetype == 1){//邮箱修改第二步获取图片验证码
	            		$("#div_updateemail_first_step").hide();
	          			$("#div_updateemail_first_1").hide();
	          			$("#div_updateemail_first_2").hide();
	          			$("#div_updateemail_second_step").show();
	          			$("#span_email_has_send").html(receiveinputid);//动态邮箱值
	          			$("#div_updateemail_second_1").hide();
	          			$("#div_updateemail_second_2").show();
	          			$("#div_updateemail_third_step").hide();
	          			$("#div_updateemail_third").hide();
            	  }
              }
			}
	});

}
//接收码验证
//type值1手机验证第一步2手机修改第一个获取验证码按钮{3手机验证第二步(提交按钮)4手机修改第一个下一步按钮}
//5手机修改第二步获取验证码按钮（6手机修改第二步填写手机收到的验证码）
function validateSecond(receiveinputid,type){
	  var receiveinputid = $("#"+receiveinputid).val();
	  receiveinputid = $.trim(receiveinputid);
	  type = $.trim(type);
	  
	  if(type == 3){//手机验证第二步
		   
	  }else if(type == 4){//手机修改第一步
		   var mobile_phone = $("#input_first_phoneupdate").val();
		   if(mobile_phone == ''){
			   alert('请输入手机号');
			   return;
		   }
		   if(!hds_ismobile(mobile_phone)){
			   alert('手机号格式有误！');
			   return;
		   }
		  
	  }else if(type == 6){//手机修改第二步
		   
	  }
	  
	  
	  var url = js_huodongshu_domain+'/account/theValidatesecond.do';
	  $.ajax({
			url: url,
			dataType: "json",
			data:{type:type,mobile_receivecode:receiveinputid},
			success: function(msg){
				  if(msg.status == 0){
					  alert(msg.msg);
	              }else if(msg.status == 1){
	            	  if(type == 3){//手机验证第二步
	            		    $("#first_step").hide();
	            		    $("#first_step_content").hide();
	            			$("#third_step_content").show();
	            			$("#third_step").show();
	            			$("#second_step_content").hide();
	            			$("#second_step").hide();
	            	  }else if(type == 4){//手机修改第一步
	            		    $("#phone_update_first").hide();
	            		    $("#phone_update_first_step").hide();
	            		    $("#phone_update_third").hide();
	            			$("#phone_update_second").show();
	            			$("#phone_update_third_step").hide();
	            			$("#phone_update_second_step").show();
	            		  
	            	  }else if(type == 6){//手机修改第二步
	            		    $("#phone_update_first").hide();
	            		    $("#phone_update_first_step").hide();
	            		    $("#phone_update_third").show();
	            			$("#phone_update_second").hide();
	            			$("#phone_update_third_step").show();
	            			$("#phone_update_second_step").hide();
	            	  }
	              }
			}
	 });
}

