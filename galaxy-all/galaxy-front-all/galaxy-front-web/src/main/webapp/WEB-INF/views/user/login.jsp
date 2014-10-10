<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<!-- saved from url=(0047)http://www.o2olive.net/demo/index.php?act=login -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9">

<title>登陆活动平台</title>
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
    <div id="header-bottom-new" style="width:990px;">
      <div id="logo"> <a href="http://www.o2olive.net/demo"><img src="/resources/images/9bb0b297fef066c19a53b322d171e629.jpg"></a>
                <!--<div class="nc—city-info">
					<h2>@天津</h2>
					<a class="ncchange-city" href="http://www.o2olive.net/demo/index.php?act=city&op=city">[城市切换]</a>
					</div>-->
              </div>
          </div>
  </div>
</div>
<script type="text/javascript" src="/resources/js/jquery.validation.min.js" charset="utf-8"></script>
<div id="main-wrap">
  <div class="left_pic"><img src="/resources/images/1.jpg"></div>
  <div class="login_page">
    <div class="page_hd">
      <h2>登录<span>&nbsp;Galaxy</span></h2>
    </div>
    <form id="login_form" method="post" novalidate="novalidate" action="/user/login">
    	<input type="hidden" name ="type" value=""/>
      <dl class="login_bd">

        <dt>用户名</dt>

        <dd>
        	<span class="ipt01 in_b">
            	<input type="text" placeholder="输入用户名/验证邮箱/验证手机号" name="logintext" id="logintext">
          </span> 
        </dd>
        <dd>
        	<span class="ipt02 in_b">
          		<input type="password" id="password" autocomplete="off" name="password" placeholder="密码">
            </span>
        </dd>

        <dd class="clearfix" style=" margin:10px 0;">
        	<span class="ipt07 in_b" style="padding-left:10px;">
            	<input type="text" title="" size="10" maxlength="4" placeholder="请输入验证码" style="width:170px;" name="captcha" id="captcha">
            </span>
            <p class="yzm"> 
            	<img border="0" class="fl" id="codeimage" name="codeimage" title="" src="/api/v1/code/image_code"><br>
            	<a href="javascript:void(0);" onclick="javascript:document.getElementById('codeimage').src='/api/v1/code/image_code?t=' + Math.random();">看不清？换一张</a>
             </p>

        </dd>
          <dd class="box_err  clearfix">
         <!-- <label for="" generated="true" class="error_login"></label>-->
         <label for="logintext" generated="true" class="error error_reg" style="display:none;"></label>
         <label for="password" generated="true" class="error error_reg" style="display:none;"></label>
         <label for="captcha" generated="true" class="error error_reg" style="display:none;"></label>
        </dd>
        <dd class="submit clearfix">
		  <input type="hidden" value="" name="ref_url">
          <input type="button" class="btn-regist" id="loginSubmit" name="Submit" value="登  录">
        </dd>
      </dl>
    </form>
    <div class="btn_r">
		<span>还没有注册账号？</span>
		<a class="btn_com" href="/user/egister"></a>

		<a class="fw" style="font-size:12px" target="_blank" href="http://www.o2olive.net/demo/index.php?act=login&op=forget_password">忘记密码？</a>
	</div>


    <div class="nc-login-other">
    	<p>您可以用合作伙伴账号登录：</p>
    	        <a class="qq" title="QQ" href="http://www.o2olive.net/demo/shop/api.php?act=toqq">&nbsp;</a>
                        <a class="sina" title="新浪微博" href="http://www.o2olive.net/demo/shop/api.php?act=tosina">&nbsp;</a>
            </div>
  </div>
</div>

<script>
$(document).ready(function(){
	$('input[name="Submit"]').click(function(){
        if($("#login_form").valid()){
        	/*
        	var logintext = $("#logintext").val();
        	alert('logintext:' + logintext)
        	if(/^([a-z0-9A-Z_]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$/i.test(logintext)){
        		$("#type").val("email");
        	}else if(/^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$/i.test(logintext)){
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
			logintext: "required",
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
			logintext: "登录用户名不能为空!",
			password: "登录密码不能为空!",
		    captcha : {
                required : '请输入验证码',
		   		remote	 : '验证码不正确'
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
	    	    		    		    		    		    		    		    		    		    		    		    		    		    		    		    		    		    		<li><a target="_blank" href="http://www.o2olive.net/demo/index.php?act=article&article_id=17">招聘英才</a></li>
    		    		    		    		<li><a href="http://www.o2olive.net/demo/index.php?act=article&article_id=18">广告合作</a></li>
    		    		    		    		<li><a href="http://www.o2olive.net/demo/index.php?act=article&article_id=16">联系我们</a></li>
    		    		    		    		<li><a href="http://www.o2olive.net/demo/index.php?act=article&article_id=15">关于O2OLive</a></li>
    		    		    			        <li><a href="http://www.o2olive.net/demo/index.php?act=slogin">商户登录</a></li>
	    </ul>
	    <a href="javascript:;" class="footer-info-con">
	    	<img width="276" height="24" alt="本地生活" src="/resources/images/footer-img.jpg">
	    </a>
	</div>
	<div class="copyright">
    	<p>Copyright 2007-2014 O2OLive Inc.,All rights reserved.Powered by <span class="vol"><font class="b">O2OLive</font></span>
    	  </p>
    </div>
</div>
</body></html>