var register_token = '';
var usernametype = 0;//1手机2，邮箱


var forgetpwd_token = '';//忘记密码的token
var forgetpwd_first_receivecode = '';//忘记密码第一步获取到的验证码
var forgetpwd_emailormobile = '';//忘记密码第一步的邮箱或者手机
var consttime = '';//倒计时
function getValidatefoRegister(){
	$("#register_a_getcode").attr("href","javascript:void(0);");
	var username = $("#input_register_username").val();
	var passwd =  $("#input_register_pwd").val();
	var repasswd =  $("#input_register_repwd").val();
	var validatecode = $("#pic_register_validatecode").val();
	username = $.trim(username);
	passwd = $.trim(passwd);
	repasswd = $.trim(repasswd);
	validatecode = $.trim(validatecode);
	if(hds_isEmail(username)){
		usernametype = 2;
	}else if(hds_ismobile(username)){
		usernametype = 1;
	}else{
		alert('用户名只能是邮箱或者是手机！');
		$("#register_a_getcode").attr("href","javascript:getValidatefoRegister();");
		return;
	}
	if(passwd.length < 6 || passwd.length > 16){
		alert('密码长度应6-16位！');
		$("#register_a_getcode").attr("href","javascript:getValidatefoRegister();");
		return;
	}
	if(passwd != repasswd){
		alert('两次密码输入不一致');
		$("#register_a_getcode").attr("href","javascript:getValidatefoRegister();");
		return;
	}
	
	$.ajax({ url: js_huodongshu_domain+"/account/register.do",
		async:false,
		type:"POST",
		dataType:"json",
		data:{username:username,password:passwd,validatecode:validatecode},
		success:function(msg){
			if(msg.status == 1){
				register_token = msg.data.token;
			    $("#input_register_username").attr("readonly","readonly");
				$("#input_register_pwd").attr("readonly","readonly");
				$("#input_register_repwd").attr("readonly","readonly");
				$("#pic_register_validatecode").attr("readonly","readonly");
				if(hds_isEmail(username)){
					usernametype = 2;
					$("#register_mobile_receive").attr("placeholder","请输入邮箱验证码！");
					alert('验证码已经发送到你邮箱，请查收！');
				}else if(hds_ismobile(username)){
					usernametype = 1;
					$("#register_mobile_receive").attr("placeholder","请输入手机验证码！");
					alert('验证码已经发送到你手机，请查收！');
				}
				
				//倒计时
				var nowtime = new Date().getTime();
				consttime = setInterval("hds_counttime("+nowtime+",'web_register',60000);",100);
				
			}else{
				alert(msg.msg);
				$("#register_a_getcode").attr("href","javascript:getValidatefoRegister();");
			}
	    }
	});
}

function registerforvalidate(){
	
	var len = $("#input_tongyixieyi:checked").length;
	if(len == 0){
		alert('请同意活动树服务协议后点击注册！');
		return;
	}
	var token = register_token;
	token = $.trim(token);
	var validatecode = $("#register_mobile_receive").val();
	validatecode = $.trim(validatecode);
	if(token == ''){
		alert('请先完成上面的步聚！');
		return;
	}
	
	if(usernametype == 2){//邮箱
		$.ajax({ url: js_huodongshu_domain+"/account/emailValidate.do",
			type:"POST",
			dataType:"json",
			data:{validatecode:validatecode,token:token},
			success:function(msg){
				if(msg.status == 0){
					alert(msg.msg);
				}else if(msg.status == 1){
					window.location.href = '/html/index.html';
				}
		    }
		});
	}else{//手机
		$.ajax({ url: js_huodongshu_domain+"/account/mobileValidate.do",
			type:"POST",
			dataType:"json",
			data:{validatecode:validatecode,token:token},
			success:function(msg){
				if(msg.status == 0){
					alert(msg.msg);
				}else if(msg.status == 1){
					window.location.href = '/html/index.html';
				}
		    }
		});
	}
	
}

$(document).ready(function(){
	if($("#findpsd_fist_step")){
		$("#findpsd_fist_step").show();
		$("#findpsd_fist").show();
		$("#findpsd_second_step").hide();
		$("#findpsd_second").hide();
		$("#findpsd_third_step").hide();
		$("#findpsd_third").hide();
	}
});

//忘记密码-获取验证码按钮(发送邮件或者短信)
function forgetPwd_firstStep(){
	var username = $("#input_findpwd_name").val();
	if(hds_isEmail(username)){
		
	}else if(hds_ismobile(username)){
		
	}else{
		alert('只能是邮箱或者是手机！');
		return;
	}
	forgetpwd_emailormobile = username;
	var url = js_huodongshu_domain+'/account/findPassword.do';
	$.ajax({ url: url,
		async:false,
		type:"POST",
		dataType:"json",
		data:{username:username},
		success:function(msg){
			if(msg.status == 1){
				forgetpwd_token = msg.data.token;
				if(hds_isEmail(username)){
					$("#findpwd_span_tip").html("校验码已发送至邮件："+username);
					$("#findpwd_span_tip").show();
				}else if(hds_ismobile(username)){
					$("#findpwd_span_tip").html("校验码已发送至手机："+username);
					$("#findpwd_span_tip").show();
					
				}
				//倒计时
				var nowtime = new Date().getTime();
				consttime = setInterval("hds_counttime("+nowtime+",'web_findpwd',60000);",100);
			}else{
				alert(msg.msg);
			}
	    }
	});
}
//忘记密码-下一步按钮(验证一下收到的验证码是否正确并进入下一步)
function forgetPwd_secondStep(){
	forgetpwd_first_receivecode = $("#findpwd_receive_code").val();
	forgetpwd_first_receivecode = $.trim(forgetpwd_first_receivecode);
	forgetpwd_token = $.trim(forgetpwd_token);
	
	var url = js_huodongshu_domain+'/account/checkcodeforfindpwd.do';
	$.ajax({ url: url,
		async:false,
		type:"POST",
		dataType:"json",
		data:{code:forgetpwd_first_receivecode,token:forgetpwd_token},
		success:function(msg){
			if(msg.status == 1){
				$("#findpsd_fist_step").hide();
				$("#findpsd_fist").hide();
				$("#findpsd_second_step").show();
				$("#findpsd_second").show();
				$("#findpsd_third_step").hide();
				$("#findpsd_third").hide();
			}else{
				alert(msg.msg);
			}
	    }
	});
	
}
//忘记密码-提交按钮 （再次验证手机或者邮箱接收的验证码是否正确，正确了给重置密码）
function forgetPwd_thirdStep(){
	var token = $.trim(forgetpwd_token);
	var validatecode = forgetpwd_first_receivecode;
	var passwd = $("#frinpwd_input_passwd").val();
	var repasswd = $("#frinpwd_input_passwd_re").val();
	var type = '';
	if(hds_isEmail(forgetpwd_emailormobile)){
		type = '2';
	}else if(hds_ismobile(forgetpwd_emailormobile)){
		type = '1';
	}else{
		alert('参数有误！');
		return;
	}
	passwd = $.trim(passwd);
	repasswd = $.trim(repasswd);
	if(passwd != repasswd){
		$("#ul_newpwd_3").attr("class","error");
		$("#li_error_newpwd3").html('<span class="icon"></span>两次密码不一致！');
		return;
	}
	
	
	var url = js_huodongshu_domain+'/account/resetPassword.do';
	$.ajax({ url: url,
		async:false,
		type:"POST",
		dataType:"json",
		data:{token:token,validatecode:validatecode,passwd:passwd,type:type},
		success:function(msg){
			if(msg.status == 1){
				$("#findpsd_fist_step").hide();
				$("#findpsd_fist").hide();
				$("#findpsd_second_step").hide();
				$("#findpsd_second").hide();
				$("#findpsd_third_step").show();
				$("#findpsd_third").show();
			}else{
				alert(msg.msg);
			}
	    }
	});
}

