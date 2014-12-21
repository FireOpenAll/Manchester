<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html> 
<html> 
<head> 
  <title>登陆乐朋</title> 
  <meta name="viewport" content="width=device-width, initial-scale=1"> 
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  
 <!-- Bootstrap CSS -->
		<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

		<script src="/resources/bootstrap/js/jquery.min.js"></script>
		<script src="/resources/bootstrap/js/bootstrap.min.js"></script>

		<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/lepeng.css">
		
	<script type="text/javascript"
		src="/resources/js/jquery.js" charset="utf-8"></script>
	<script type="text/javascript"
		src="/resources/js/common_register.js" charset="utf-8"></script>
	<script type="text/javascript" src="/resources/js/jquery.validation.min.js" charset="utf-8"></script>

</head> 
<body> 
<div class="row">
			<br>
			<center>
					<img src="/resources/bootstrap/images/logo.png" class="img-responsive" alt="Image">
			</center>
		</div>	

		<div class="panel col-md-4 col-md-offset-4 col-xs-10 col-xs-offset-1">
	      <div class="panel-heading text-center">
	        <h3 class="panel-title">欢迎登陆乐朋</h3>
	      </div>
	      <div class="panel-body panel-danger">
			<form id="login_form" method="post" novalidate="novalidate" action="/user/login">
				<div class="form-group">
						<input type="text" class="field-control" name="username" id="username" placeholder="输入用户名／验证邮箱／验证手机号">
					<label for="username" generated="true" class="error error_reg" style="display:none;"></label>
				</div>
				<div class="form-group">
						<input type="password" id="password" autocomplete="off" name="password" class="field-control" id="" placeholder="密码">
					 <label for="password" generated="true" class="error error_reg" style="display:none;"></label>
				</div>
				<div class="row">
					  <div class="col-xs-5 col-md-8">
					    <input type="text" class="field-control" placeholder="验证码" name="captcha" id="captcha">
					    <label for="captcha" generated="true" class="error error_reg" style="display:none;"></label>
					  </div>

					<div class="col-xs-5 col-md-4">
				  	
				  		<label for="input-id" class="col-sm-2">
				  			
	            	<a href="javascript:void(0);" onclick="javascript:document.getElementById('codeimage').src='/api/v1/code/image_code?t=' + Math.random();">
	            		<img border="0" class="fl" id="codeimage" name="codeimage" style="width:100px" title="" src="/api/v1/code/image_code">
	            	</a>
				  		</label>
				  	</div>
				</div>
				<div class="form-group"></div>
				<div class="form-group">
					<div>
						 <button type="button" id="loginSubmit"  name="Submit" class="btn btn-large btn-block btn-danger">登陆</button>
					</div>
				</div>
				<div class="form-group">
					<div>
						 <a href="/user/register" class="btn btn-large btn-block btn-info">注册</a>
					</div>
				</div>
				 
			</form>
		</div>
	</div>
<script>
$(document).ready(function(){
	$("#loginSubmit").click(function(){
		
        if($("#login_form").valid()){
        	/*
        	var username = $("#username").val();
        	alert('username:' + username)
        	if(/^([a-z0-9A-Z_]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$/i.test(username)){
        		$("#type").val("email");
        	}else if(/^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$/i.test(username)){
        		$("#type").val("mobile");
        	}else{
        		$("#type").val("username");
        	}
        	alert($("#type").val())
        	*/
        	
        	
        	$("#login_form").submit();
        } else{
        	document.getElementById('codeimage').src='/api/v1/code/image_code?t=' + Math.random();
        }
    });
	$("#login_form").validate({
        errorPlacement: function(error, element){
			error.appendTo('.error_login');
        },
		rules: {
			username: "required",
			password: "required",
            captcha : {
                required : true,
                remote   : {
                    url : '/api/v1/code/check_image',
                    type: 'get',
                    data:{
                        captcha : function(){
                            return $('#captcha').val();
                        }
                    }
                }
            }
		},
		messages: {
			username: "登录用户名不能为空!",
			password: "登录密码不能为空!",
		    captcha : {
                required : '请输入验证码',
		   		remote	 : '验证码不正确'
            }
		}
	});
});
</script>
</body>
</html>

