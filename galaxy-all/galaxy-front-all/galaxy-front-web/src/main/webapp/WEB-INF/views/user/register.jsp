<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!-- saved from url=(0059)http://www.o2olive.net/demo/index.php?act=login&op=register -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9">

<title>galaxy注册</title>
<meta name="keywords" content="O2OLive系统演示站">
<meta name="description" content="O2OLive系统演示站">
<meta name="author" content="ShopNC">
<meta name="copyright" content="ShopNC Inc. All Rights Reserved">
<link rel="stylesheet" type="text/css"
	href="/resources/css/base.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/offline.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/header.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/dialog.css">
<script type="text/javascript"
	src="/resources/js/jquery.js" charset="utf-8"></script>
<script type="text/javascript"
	src="/resources/js/common_register.js" charset="utf-8"></script>
<script type="text/javascript" src="/resource/js/hsqregister.js"></script>
<script type="text/javascript">
$(function(){
	$('#gotop').click(function(){
		$('a[href="#store_intro"]').parent().addClass("group-content-current").siblings().removeClass("group-content-current");
	});
		//首页左侧分类菜单
	$(".category ul.menu").find("li").each(
		function() {
			$(this).hover(
				function() {
				    var cat_id = $(this).attr("cat_id");
					var menu = $(this).find("div[cat_menu_id='"+cat_id+"']");
					menu.show();
					$(this).addClass("hover");
					if(menu.attr("hover")>0) return;
					menu.masonry({itemSelector: 'dl'});
					var menu_height = menu.height();
					if (menu_height < 60) menu.height(80);
					menu_height = menu.height();
					var li_top = $(this).position().top;
					if ((li_top > 60) && (menu_height >= li_top)) $(menu).css("top",-li_top+50);
					if ((li_top > 150) && (menu_height >= li_top)) $(menu).css("top",-li_top+90);
					if ((li_top > 240) && (li_top > menu_height)) $(menu).css("top",menu_height-li_top+120);
					if (li_top > 300 && (li_top > menu_height)) $(menu).css("top",60-menu_height);
					if ((li_top > 40) && (menu_height <= 120)) $(menu).css("top",-5);
					menu.attr("hover",1);
				},
				function() {
					$(this).removeClass("hover");
				    var cat_id = $(this).attr("cat_id");
					$(this).find("div[cat_menu_id='"+cat_id+"']").hide();
				}
			);
		}
	);
	$('.search_tab').live("click",function(){
		var s_url = '';
		if($(this).attr("op") == 'search_groupbuy'){
			$("input[name=act]").val('groupbuy');
			$("input[name=op]").val('list');
			$("input[name=keyword]").attr('placeholder','输入关键字查找在本地的团购');
			$('.search_tabs').html('<li class="search_tab" op="search_groupbuy">团购</li><li class="search_tab" op="search_store">商家</li><li class="search_tab" op="search_goodsreal">购物</li>');
			s_url = 'index.php?act=groupbuy&op=list&keyword=';
		}else if($(this).attr("op") == 'search_store'){
			$("input[name=act]").val('index');
			$("input[name=op]").val('list');
			$("input[name=keyword]").attr('placeholder','输入关键字查找在本地的商户');
			$('.search_tabs').html('<li class="search_tab" op="search_store">商家</li><li class="search_tab" op="search_goodsreal">购物</li><li class="search_tab" op="search_groupbuy">团购</li>');
			s_url = 'index.php?act=index&op=list&keyword=';
		}else if($(this).attr("op") == 'search_goodsreal'){
			$("input[name=act]").val('goodsreal');
			$("input[name=op]").val('list');
			$("input[name=keyword]").attr('placeholder','输入关键字查找在本地的购物');
			$('.search_tabs').html('<li class="search_tab" op="search_goodsreal">购物</li><li class="search_tab" op="search_groupbuy">团购</li><li class="search_tab" op="search_store">商家</li>');
			s_url = 'index.php?act=goodsreal&op=list&keyword=';
		}
		$('.tab').removeClass("tab_over");
		$('.hot_link').each(function(){
			$(this).attr("href",s_url+$(this).attr("data"));
		});
	});
	$('#SubmitFrom').click(function(){
		$('#search_form').submit();
	});
	$('.del_cart').click(function(){
		var cart_id = $(this).attr("cart_id");
		var cart_count = parseInt($('.cart-count').html());
		var new_count = eval(cart_count-1);
		$.getJSON("index.php?act=cart&op=cart_del&cart_id="+cart_id,function(data){
			if(data.done){
				$('#cart_li_'+cart_id).remove();
				$('.cart-count').html(new_count);
				if(new_count == 0){
					$('.dropdown-cart').append('<div class="dropdown-menu dropdown-menu-deal dropdown-menu-cart"><p class="dropdown-menu-empty">暂时没有商品</p></div>');
				}
			}else{
				alert(data.msg);
			}
		});
	});
});

function AddFavorite(sURL, sTitle)
{
    try
    {
        window.external.addFavorite(sURL, sTitle);
    }
    catch (e)
    {
        try
        {
            window.sidebar.addPanel(sTitle, sURL, "");
        }
        catch (e)
        {
            alert('加入收藏失败，请使用Ctrl+D进行添加');
        }
    }
}

var SITEURL = 'http://www.o2olive.net/demo';
$(function() {
		$(".tab").hover(function() {
		$(this).addClass("tab_over");
	},
	function() {
		$(this).removeClass("tab_over");
	});
});
$(function() {
		$(".dropdown").hover(function() {
		$(this).addClass("dropdown-open dropdown-open-app");
	},
	function() {
		$(this).removeClass("dropdown-open dropdown-open-app");
	});
});
$(function() {
		$(".section-main").hover(function() {
		$(this).addClass("nav-drop");
	},
	function() {
		$(this).removeClass("nav-drop");
	});
});

</script>
</head>
<body id="pagetop">
	<!-- 导航 -->
	<div id="header">
		<div id="header-bottom">
			<div id="header-bottom-new" style="width: 990px;">
				<div id="logo">
					<a href="http://www.o2olive.net/demo"><img
						src="/resources/images/9bb0b297fef066c19a53b322d171e629.jpg"></a>
					<!--<div class="nc—city-info">
					<h2>@天津</h2>
					<a class="ncchange-city" href="http://www.o2olive.net/demo/index.php?act=city&op=city">[城市切换]</a>
					</div>-->
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="/resources/js/jquery.validation.min.js"
		charset="utf-8"></script>
	<style type="text/css">
#search,#navBar {
	display: none !important;
}

/*屏蔽头部搜索及导航菜单*/
</style>
	<div id="main-wrap">
		<div class="left_pic">
			<img src="/resources/images/1.jpg">
		</div>
		<div class="register_page">
			<div class="page_hd">
				<h2>
					注册<span>&nbsp;Register</span>
				</h2>
				<p style="color:ff0000"><%="${message}" %></p>
			</div>
			<div class="register_bd">
				<form id="register_form" method="post" action="http://localhost:8080/user/register">
					<dl>
						<dt></dt>
						<dd>
							<span class="ipt03 in_b"> 
								<input type="text" placeholder="用户名" name="username" id="username">
							</span>
						    <label for="username" generated="true" class="error error_reg" style="display: none;"></label>
						</dd>
					</dl>
					<dl>
						<dt></dt>
						<dd>
							<span class="ipt06 in_b"> 
								<input type="text" title="" placeholder="邮箱" name="email" id="email">
							</span> 
							<label id="email_error" class="error error_reg" for="email" generated="true" style="display: none;"></label>
						</dd>
					</dl>
					<dl>
						<dt></dt>
						<dd>
							<span class="ipt04 in_b"> 
								<input type="password" title="" placeholder="密码" name="password" id="password">
							</span> 
							<label class="error error_reg" for="password" generated="true" style="display: none;"></label>
						</dd>
					</dl>
					<dl>
						<dt></dt>
						<dd>
							<span class="ipt05 in_b"> 
								<input type="password" title="" placeholder="确认密码" name="password_confirm" id="password_confirm">
							</span> 
							<label class="error error_reg" for="password_confirm" generated="true" style="display: none;"></label>
						</dd>
					</dl>
					<!-- 
					<dl>
						<dt></dt>
						<dd>
							<span class="ipt08 in_b"> <input type="text" title=""
								placeholder="手机" name="mobile" id="mobile">
							</span> <label class="error error_reg" for="mobile" generated="true"
								style="display: none;"></label>
						</dd>
					</dl>
					 -->
					<!--
        <dl>
          <dt></dt>
          <dd> <span class="ipt08 in_b">
            <input type="text" placeholder="手机号码" name="mobile" id="mobile">
            </span>
            <label class="error error_reg" for="mobile" generated="true"  style="display:none;"></label>
          </dd>
        </dl>-->
					<!--
        <dl style="position:relative;">
          <dt></dt>
          <dd>
          	<div class="ipt10 mr9" id="cityletter_container"><span class='cityletter'>A</span><i class="city_down" data="c_city_letter"></i></div>
            <div class="ipt10" id="cityname_container"><span class='cityname'>阿里</span><i class="city_down" data="c_city"></i></div>
            <input type="hidden" name="city_id" id="city_id" value="84">
            <label class="error error_reg" for="city_id" generated="true"  style="display:none;"></label>
          </dd>
          <div id="c_city_letter" style="top:50px; left:0;display: none;" class="slt_wrap slt_box slt_body">
            <div class="slt_list">
              <ul class="u_city_letter">
                <li data-id="A">A</li>
                <li data-id="B">B</li>
                <li data-id="C">C</li>
                <li data-id="D">D</li>
                <li data-id="E">E</li>
                <li data-id="F">F</li>
                <li data-id="G">G</li>
                <li data-id="H">H</li>
                <li data-id="I">I</li>
                <li data-id="J">J</li>
                <li data-id="K">K</li>
                <li data-id="L">L</li>
                <li data-id="M">M</li>
                <li data-id="N">N</li>
                <li data-id="O">O</li>
                <li data-id="P">P</li>
                <li data-id="Q">Q</li>
                <li data-id="R">R</li>
                <li data-id="S">S</li>
                <li data-id="T">T</li>
                <li data-id="U">U</li>
                <li data-id="V">V</li>
                <li data-id="W">W</li>
                <li data-id="X">X</li>
                <li data-id="Y">Y</li>
                <li data-id="Z">Z</li>
              </ul>
            </div>
          </div>
          <div id="c_city" style="top:50px; left:187px;display: none;" class="slt_wrap slt_box slt_body">
            <div class="slt_list">
              <ul class="u_city">
                                                <li data-id="84">阿里</li>
                                <li data-id="7">鞍山</li>
                                <li data-id="8">安顺</li>
                                <li data-id="9">阿坝</li>
                                <li data-id="10">阿拉善</li>
                                <li data-id="85">安康</li>
                                <li data-id="24">大同</li>
                                <li data-id="86">阿克苏</li>
                                <li data-id="87">安庆</li>
                                <li data-id="88">阿勒泰</li>
                                <li data-id="89">安阳</li>
                                <li data-id="90">澳门</li>
                                <li data-id="257">乌兰察布</li>
                                              </ul>
            </div>
          </div>
        </dl>
		-->
					<dl>
						<dt></dt>
						<dd>
							<span class="ipt07 in_b" style="padding-left: 10px;">
							 <input
								type="text" title="" size="10" maxlength="4"
								placeholder="请输入验证码" style="width: 170px;" name="captcha"
								id="captcha">
							</span>
							<p class="yzm">
								<img border="0" class="fl" id="codeimage" name="codeimage" title="" src="http://localhost:8080/api/v1/code/image_code">
								<br>
								<a href="javascript:void(0);"
									onclick="javascript:document.getElementById('codeimage').src='http://localhost:8080/api/v1/code/image_code?t=' + Math.random();">看不清？换一张</a>
							</p>
							<label for="captcha" generated="true" class="error error_reg" style="display: none;"></label>
						</dd>
					</dl>
					<dl>
						<dt></dt>
						<dd class="ment">
							<label for=""> 
								<input type="checkbox" checked="checked"value="1" id="clause" name="agree"> 阅读并同意 
								<a title="阅读并同意" href="http://www.o2olive.net/demo/index.php?act=document&code=agreement">服务协议</a>
							</label> 
							<label for="agree" generated="true" class="error" style="display: none;">请阅读并同意该协议</label>
						</dd>
						<dd>
							<input type="button" title="立即注册" class="btn-regist" value="立即注册" name="Submit">
						</dd>
					</dl>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
$(function(){
	$('#cityletter_container').click(function(){
		$('#c_city_letter').show();
	});
	$('#cityname_container').click(function(){
		$('#c_city').show();
	});
	$('.u_city li').live("click",function(){
		var area 		=	$(this).attr('data-id');
		var area_name	=	$(this).html();
		$('input[name=city_id]').val(area);
		$('.cityname').html(area_name);
		$('#c_city').hide();
	});
	$('.u_city_letter li').click(function(){
		var letter	=	$(this).html();
		$.getJSON('index.php?act=login&op=ajax_getcity&letter='+letter, function(result){
	        if(result.done){
		        $('.u_city').html('');
		        $('.cityname').html(result.data[0]['area_name']);
		        $('input[name=city_id]').val(result.data[0]['area_id']);
	        	for(var i=0,l=result.data.length;i<l;i++){
	        		$('.u_city').append('<li data-id="'+result.data[i]['area_id']+'">'+result.data[i]['area_name']+'</li>');
	        	}
	        }else{
	            alert('暂无该字母开头的城市');
	        }
	    });
		$('.cityletter').html(letter);
		$('#c_city_letter').hide();
	});
	
	jQuery.validator.addMethod("passwordLimit", function(value, element) {
		return this.optional(element) || /^[a-zA-Z0-9_]{6,20}$/i.test(value);
	},"密码须由字母、数字和下划线组成，6-20字符");
	jQuery.validator.addMethod("lettersonly", function(value, element) {
		return this.optional(element) || /^[a-zA-Z][a-zA-Z0-9_]{5,19}$/i.test(value);
	},"用户名须由字母、数字和下划线组成，以字母开头，6-20字符");
	jQuery.validator.addMethod("lettersmin", function(value, element) {
		return this.optional(element) || ($.trim(value).length>=6);
	}, "Letters min please"); 
	jQuery.validator.addMethod("lettersmax", function(value, element) {
		return this.optional(element) || ($.trim(value).length<=20);
	}, "Letters max please");

	jQuery.validator.addMethod("phones", function(value, element) {
		return this.optional(element) || /^[1][3-8]+\d{9}/i.test(value);
	}, "phone number please"); 
	$('input[name="Submit"]').click(function(){
        if($("#register_form").valid()){
        	$("#register_form").submit();
        } else{
        	document.getElementById('codeimage').src='http://localhost:8080/api/v1/code/image_code?t=' + Math.random();
        }
    });
    $("#register_form").validate({
        rules : {
            username : {
                required : true,
                lettersmin : true,
                lettersmax : true,
                lettersonly : true,
                remote   : {
                    url :'http://localhost:8080/user/check/username',
                    type:'get',
                    data:{
                        username : function(){
                            return $('#username').val();
                        }
                    }
                }
            },
            password : {
                required : true,
                minlength: 6,
				maxlength: 20,
				passwordLimit:"密码须由字母、数字和下划线组成，6-20字符!"
            },
            password_confirm : {
                required : true,
                equalTo  : '#password'
            },
            email : {
                required : true,
                email    : true,
                remote   : {
                    url : 'http://localhost:8080/user/check/email',
                    type: 'get',
                    data:{
                        email : function(){ return $('#email').val();
                        }
                    }
                }
            },
            captcha : {
                required : true,
                remote   : {
                    url : 'http://localhost:8080/api/v1/code/check_image',
                    type: 'get',
                    data:{
                        captcha : function(){
                            return $('#captcha').val();
                        }
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
				lettersonly: '用户名必须是字母、数字和下划线组成，以字母开头，6-20字符',
				remote	 : '该用户名已经存在'
            },
            password  : {
                required : '密码不能为空!',
                minlength: '密码长度应在6-20个字符之间',
				maxlength: '两次输入的密码不一致'
            },
            password_confirm : {
                required : '密码不能为空!',
                equalTo  : '两次输入的密码不一致'
            },
            email : {
                required : '电子邮箱不能为空',
                email    : '这不是一个有效的电子邮箱',
				remote	 : '电子邮箱已经存在'
            },
            captcha : {
                required : '请输入验证码',
		   		remote	 : '验证码不正确'
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
				<li class="first"><a href="http://www.o2olive.net/demo">首页</a></li>
				<li><a target="_blank"
					href="http://www.o2olive.net/demo/index.php?act=article&article_id=17">招聘英才</a></li>
				<li><a
					href="http://www.o2olive.net/demo/index.php?act=article&article_id=18">广告合作</a></li>
				<li><a
					href="http://www.o2olive.net/demo/index.php?act=article&article_id=16">联系我们</a></li>
				<li><a
					href="http://www.o2olive.net/demo/index.php?act=article&article_id=15">关于O2OLive</a></li>
				<li><a href="http://www.o2olive.net/demo/index.php?act=slogin">商户登录</a></li>
			</ul>
			<a href="javascript:;" class="footer-info-con"> <img width="276"
				height="24" alt="本地生活"
				src="/resources/images/footer-img.jpg">
			</a>
		</div>
		<div class="copyright">
			<p>
				Copyright 2007-2014 O2OLive Inc.,All rights reserved.Powered by <span
					class="vol"><font class="b">O2OLive</font></span>
			</p>
		</div>
	</div>
</body>
</html>