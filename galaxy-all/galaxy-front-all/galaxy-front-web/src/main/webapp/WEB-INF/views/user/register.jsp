<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!-- saved from url=(0059)http://www.o2olive.net/demo/index.php?act=login&op=register -->
<html>
<head>
<title>欢迎注册乐朋网</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9">
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control"      content="no-cache">  

<meta name="keywords" content="注册乐朋网">
<meta name="description" content="注册乐朋网">
<meta name="author" content="乐朋网">
<meta name="copyright" content="Lookpeng Inc. All Rights Reserved">
<link rel="stylesheet" type="text/css" href="/resources/css/base.css">
<link rel="stylesheet" type="text/css" href="/resources/css/offline.css">
<link rel="stylesheet" type="text/css" href="/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="/resources/css/dialog.css">
<script type="text/javascript" src="/resources/js/jquery.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/resources/js/common_register.js"
	charset="utf-8"></script> 
</head>
<body id="pagetop">
	<!-- 导航 -->
	<div id="header">
		<div id="header-bottom">
			<div id="header-bottom-new" style="width: 990px;">
				<div id="logo">
					<a href="http://www.lookpeng.com"><img
						src="/resources/images/lookpeng3.png"></a>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="/resources/js/jquery.validation.min.js" charset="utf-8"></script>
	<div id="main-wrap">
		<div class="left_pic">
			<img src="/resources/images/login_baner.jpg">
		</div>
		<div class="register_page">
			<div class="page_hd">
				<h2>
					注册<span>&nbsp;Register</span>
				</h2>
				<p style="color: ff0000"><%="${message}"%></p>
			</div>
			<div class="register_bd">
				<form id="register_form" method="post" action="/user/register">
					<dl>
						<dt></dt>
						<dd>
							<span class="ipt03 in_b"> <input type="text"
								placeholder="用户名" name="username" id="username">
							</span> <label for="username" generated="true" class="error error_reg"
								style="display: none;"></label>
						</dd>
					</dl>
					<dl>
						<dt></dt>
						<dd>
							<span class="ipt06 in_b"> <input type="text" title=""
								placeholder="邮箱" name="email" id="email">
							</span> <label id="email_error" class="error error_reg" for="email"
								generated="true" style="display: none;"></label>
						</dd>
					</dl>
					<dl>
						<dt></dt>
						<dd>
							<span class="ipt04 in_b"> <input type="password" title=""
								placeholder="密码" name="password" id="password">
							</span> <label class="error error_reg" for="password" generated="true"
								style="display: none;"></label>
						</dd>
					</dl>
					<dl>
						<dt></dt>
						<dd>
							<span class="ipt05 in_b"> <input type="password" title=""
								placeholder="确认密码" name="password_confirm" id="password_confirm">
							</span> <label class="error error_reg" for="password_confirm"
								generated="true" style="display: none;"></label>
						</dd>
					</dl> 
					<dl>
						<dt></dt>
						<dd>
							<span class="ipt07 in_b" style="padding-left: 10px;"> <input
								type="text" title="" size="10" maxlength="4"
								placeholder="请输入验证码" style="width: 170px;" name="captcha"
								id="captcha">
							</span>
							<p class="yzm">
								<img border="0" class="fl" id="codeimage" name="codeimage"
									title="" src="/api/v1/code/image_code"> <br> <a
									href="javascript:void(0);"
									onclick="javascript:document.getElementById('codeimage').src='/api/v1/code/image_code?t=' + Math.random();">看不清？换一张</a>
							</p>
							<label for="captcha" generated="true" class="error error_reg"
								style="display: none;"></label>
						</dd>
					</dl>
					<dl>
						<dt></dt>
						<dd class="ment">
							<label for=""> <input type="checkbox" checked="checked"
								value="1" id="clause" name="agree"> 阅读并同意 <a
								title="阅读并同意" href="/document/service.html">服务协议</a>
							</label> <label for="agree" generated="true" class="error"
								style="display: none;">请阅读并同意该协议</label>
						</dd>
						<dd>
							<input type="button" title="立即注册" class="btn-regist" value="立即注册"
								name="Submit" id="submitBtn">
						</dd>
					</dl>
				</form>
			</div>
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
	<div class="clear"></div>
	<div class="clear">&nbsp;</div>
	<div class="footer-info">
		<div class="footer-info-nav gr">
			<ul>
				<li class="first"><a href="/">首页</a></li>
				<li><a href="/advert.html">广告合作</a></li>
				<li><a href="/contactus.html">联系我们</a></li>
				<li><a href="/about.html">关于乐朋</a></li>
				<li><a href="/merchant/login"">商户登录</a></li>
			</ul>
			<a href="javascript:;" class="footer-info-con"> <img width="276"
				height="24" alt="本地生活" src="/resources/images/footer-img.jpg">
			</a>
		</div>
		<div class="copyright">
			<p>
				Copyright 2007-2014 乐朋 Inc.,All rights reserved. Powered by <span
					class="vol"><font class="b">乐朋</font></span>
			</p>
		</div>
	</div>
</body>
</html>