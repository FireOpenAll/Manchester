<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1.0,  user-scalable=no" >
	<title></title>

<!-- Bootstrap CSS -->
	<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-theme.min.css">

	<script src="http://cdn.bootcss.com/jquery/1.9.1/jquery.min.js"></script>
	<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/lepeng.css">


<meta name="keywords" content="注册乐朋网">
<meta name="description" content="注册乐朋网">
<meta name="author" content="乐朋网">
<meta name="copyright" content="Lookpeng Inc. All Rights Reserved">
<script type="text/javascript" src="/resources/js/jquery.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/resources/js/common_register.js"
	charset="utf-8"></script> 
	
	<script type="text/javascript"
		src="/resources/js/jquery.validation.min.js" charset="utf-8"></script>
</head>

</head>
<body>
  <br>
		<div class="row">
			<center>
					<img src="/resources/bootstrap/images/logo.png" class="img-responsive" alt="Image">
			</center>
					
			
		</div>	
		
<div class="panel col-md-4 col-md-offset-4 col-xs-10 col-xs-offset-1">
      <div class="panel-heading">
        <h3 class="panel-title">欢迎注册乐朋</h3>
      </div>
      <div class="panel-body panel-danger">
        <form id="register_form" method="post" action="/user/register">
				<div class="form-group">
					<div>
						<input type="text" class="field-control" name="username" id="username" placeholder="输入用户名／验证邮箱／验证手机号">
						<label for="username" generated="true" class="error error_reg"
								style="display: none;"></label>
					</div>
				</div>
				<div class="form-group">
					
					<div>
						<input type="text" class="field-control" id="email" name="email" placeholder="邮箱">
						<label id="email_error" class="error error_reg" for="email"
								generated="true" style="display: none;"></label>
					</div>
				</div>
				<div class="form-group">
					
					<div>
						<input type="text" class="field-control" id="password" name="password" placeholder="密码">
						<label class="error error_reg" for="password" generated="true"
								style="display: none;"></label>
					</div>
				</div>
				<div class="form-group">
					
					<div>
						<input type="text" class="field-control" id="password_confirm" name="password_confirm" placeholder="确认密码">
						<label class="error error_reg" for="password_confirm"
								generated="true" style="display: none;"></label>
					</div>
				</div>
				<div class="row">
					  <div class="col-xs-5">
					    <input type="text" class="field-control" id="captcha" name="captcha" placeholder="验证码">
					    <label for="captcha" generated="true" class="error error_reg"
								style="display: none;"></label>
					  </div>

					<div class="col-xs-5">
				  		<label for="input-id" class="col-sm-2">
				  			 <a
									href="javascript:void(0);"
									onclick="javascript:document.getElementById('codeimage').src='/api/v1/code/image_code?t=' + Math.random();">
									<img border="0" class="fl" id="codeimage" name="codeimage" style="width:100px"
									title="" src="/api/v1/code/image_code">
									</a>
				  		</label>
				  	</div>
				</div>
				<div class="form-group"></div>
				<div class="form-group">
					<div>
						 <button type="submit" class="btn btn-large btn-block btn-danger">立即注册</button>
					</div>
				</div>
				 <div class="form-group">
					<div>
						  <a href="/user/login" class="btn btn-large btn-block btn-info">登陆</a>
					</div>
				</div>
			</form>
			</div>
			</div>
			<script type="text/javascript">
		$(function() {    
			jQuery.validator.addMethod("passwordLimit",
					function(value, element) {
						return this.optional(element)
								|| /^[a-zA-Z0-9_]{6,20}$/i.test(value);
					}, "密码须由字母、数字和下划线组成，6-20字符");
			jQuery.validator.addMethod("lettersonly", function(value, element) {
				return this.optional(element)
						|| /^[a-zA-Z][a-zA-Z0-9_]{5,19}$/i.test(value);
			}, "用户名须由字母、数字和下划线组成，以字母开头，6-20字符");
			jQuery.validator.addMethod("lettersmin", function(value, element) {
				return this.optional(element) || ($.trim(value).length >= 6);
			}, "Letters min please");
			jQuery.validator.addMethod("lettersmax", function(value, element) {
				return this.optional(element) || ($.trim(value).length <= 20);
			}, "Letters max please");

			jQuery.validator.addMethod("phones", function(value, element) {
				return this.optional(element)
						|| /^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$/i
								.test(value);
			}, "phone number please");
			$('#submitBtn')
					.click(
							function() {
								if ($("#register_form").valid()) {
									$("#register_form").submit();
								} else {
									document.getElementById('codeimage').src = '/api/v1/code/image_code?t='
											+ Math.random();
								}
							});
			$("#register_form").validate({
				rules : {
					username : {
						required : true,
						lettersmin : true,
						lettersmax : true,
						lettersonly : true,
						remote : {
							url : '/check/user/username',
							type : 'get',
							data : {
								username : function() {
									return $('#username').val();
								},
			                    t:Math.random()
							}
						}
					},
					password : {
						required : true,
						minlength : 6,
						maxlength : 20,
						passwordLimit : "密码须由字母、数字和下划线组成，6-20字符!"
					},
					password_confirm : {
						required : true,
						equalTo : '#password'
					},
					email : {
						required : true,
						email : true,
						remote : {
							url : '/check/user/email',
							type : 'get',
							data : {
								email : function() {
									return $('#email').val();
								},
			                    t:Math.random()
							}
						}
					},
					captcha : {
						required : true,
						remote : {
							url : '/api/v1/code/check_image',
							type : 'get',
							data : {
								captcha : function() {
									return $('#captcha').val();
								},
			                    t:Math.random()
							}
						}
					},
					agree : {
						required : true
					}
				},
				messages : {
					username : {
						required : '用户名不能为空!',
						lettersmin : '用户名必须在6-20个字符之间!',
						lettersmax : '用户名必须在6-20个字符之间!',
						lettersonly : '用户名必须是字母、数字和下划线组成，以字母开头，6-20字符',
						remote : '该用户名已经存在'
					},
					password : {
						required : '密码不能为空!',
						minlength : '密码长度应在6-20个字符之间',
						maxlength : '两次输入的密码不一致'
					},
					password_confirm : {
						required : '密码不能为空!',
						equalTo : '两次输入的密码不一致'
					},
					email : {
						required : '电子邮箱不能为空',
						email : '这不是一个有效的电子邮箱',
						remote : '电子邮箱已经存在'
					},
					captcha : {
						required : '请输入验证码',
						remote : '验证码不正确'
					},
					agree : {
						required : '请阅读并同意该协议'
					}
				}
			});
		});
	</script>
			</body>
</html>