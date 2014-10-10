<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<!-- saved from url=(0028)http://www.o2olive.net/demo/ -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9">

<title>O2OLive系统演示站</title>
<meta name="keywords" content="本地生活 美食 娱乐 电影 团购 优惠券 活动">
<meta name="description" content="O2OLive专注于研发符合时代发展需要的电子商务商城系统，以专业化的服务水平为企业级用户提供B(2B)2C【B2B2C】电子商务平台解决方案，全力打造电商平台专项ERP(CRM)系统、ERP(RFID)系统等，引领中国电子商务行业企业级需求的发展方向。咨询电话：400-611-5098">
<meta name="author" content="ShopNC">
<meta name="copyright" content="ShopNC Inc. All Rights Reserved">
<link rel="stylesheet" type="text/css" href="/resources/css/base.css">
<link rel="stylesheet" type="text/css" href="/resources/css/offline.css">
<link rel="stylesheet" type="text/css" href="/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="/resources/css/dialog.css">
<script type="text/javascript" src="/resources/js/jquery.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/js/common.js" charset="utf-8"></script>
<script type="text/javascript">
$(function(){
		$('.category').show();
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
<div id="topNav" style="z-index:999;position:relative;">
  <div id="topNav-inner-new" style="width:1025px;">
    <ul class="topNav-left">
            <li class="user_info"> <span>您好，欢迎来到 O2OLive系统演示站</span> <a class="user-info-login" href="/user/login">[登录]</a><a class="user-info-signup" href="/user/register">[注册]</a> </li>
                  <li class="line">|</li>
      <li class="mobile-info-item dropdown"> <a href="javascript:void(0);" class="dropdown-tog"><i class="icon-mobile"></i>手机本地生活<i class="tri tri-dropdown"></i></a>
        <div class="dropdown-menu dropdown-menu-app"> <a target="_blank" href="http://www.o2olive.net/demo/#" class="app-block"> <span class="app-block-title">免费下载O2OLive手机版</span> <span class="app-block-content"> <img src="/resources/images/6f4416f017cad0a0a46fee4c7624425d.png" width="89px"> </span> <i class="app-block-arrow"></i> </a> </div>
      </li>
            <!--<li class="topnav-phone"><a href="">手机客户端</a><em>|</em></li>-->
      <!--    <li class="topnav-add"><a href="index.php?act=memberaccount&op=fav_list" >我的收藏</a><em>|</em></li>-->
            <li class="dcode-box">
        <div class="code-img"></div>
        <div class="login-dcode">
          <h2>扫码下载</h2>
          <div class="lifecode-img"> <img src="/resources/images/6f4416f017cad0a0a46fee4c7624425d.png" width="153px"> </div>
          <span>（扫码下载O2OLive手机版）</span> </div>
      </li>
            <!-- <li class="seller-login">
                <a href="index.php?act=slogin">商户登录</a>
              </li>-->
    </ul>
    <ul class="topNav-right">
      <li class="user-orders"><a target="_blank" href="http://www.o2olive.net/demo/index.php?act=memberorder&op=list">我的订单</a></li>
      <li class="line">|</li>
      <li class="dropdown dropdown-account"> <a href="http://www.o2olive.net/demo/index.php?act=memberaccount" class="dropdown-tog"> <span>我的本地生活</span> <i class="tri tri-dropdown"></i> </a>
        <ul class="dropdown-menu dropdown-menu-text dropdown-menu-account account-menu">
          <li><a href="http://www.o2olive.net/demo/index.php?act=memberorder&op=list" class="dropdown-menu-item first">我的订单</a></li>
          <li><a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=comment" class="dropdown-menu-item">我的评价</a></li>
          <li><a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=fav_list" class="dropdown-menu-item">我的收藏</a></li>
          <li><a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=scorelog" class="dropdown-menu-item">我的积分</a></li>
          <li><a href="http://www.o2olive.net/demo/index.php?act=membercoupon&op=list" class="dropdown-menu-item">优惠券</a></li>
          <li><a href="http://www.o2olive.net/demo/index.php?act=memberpredeposit&op=list" class="dropdown-menu-item">预存款</a></li>
        </ul>
      </li>
      <li class="line">|</li>
      <li class="dropdown dropdown-cart"> <a href="http://www.o2olive.net/demo/index.php?act=cart" class="dropdown-tog"> <i class="icon icon-cart"></i> <span>购物车<em class="badge"><strong class="cart-count">0</strong>件</em></span> <i class="tri tri-dropdown"></i> <i class="vertical-bar"></i> </a>
                <div class="dropdown-menu dropdown-menu-deal dropdown-menu-cart" style="padding:10px 0;">
          <p class="dropdown-menu-empty">暂时没有商品</p>
        </div>
              </li>
      <!--
      <li class="line">|</li>
      <li class="dropdown dropdown-account"> <a  href="#" class="dropdown-tog"> <span>联系客服</span> <i class="tri tri-dropdown"></i> </a>
        <ul class="dropdown-menu dropdown-menu-text dropdown-menu-account account-help">
          <li><a href="#" class="dropdown-menu-item first">申请退款</a></li>
          <li><a href="#" class="dropdown-menu-item">申请退换货</a></li>
          <li><a href="#" class="dropdown-menu-item">查看团购券</a></li>
          <li><a href="#" class="dropdown-menu-item">帮顶手机号</a></li>
          <li><a href="#" class="dropdown-menu-item">常见问题</a></li>
        </ul>
      </li>
      -->
      <li class="line">|</li>
      <li class="dropdown dropdown-account"> <a href="http://www.o2olive.net/demo/#" class="dropdown-tog"> <span>我是商家</span> <i class="tri tri-dropdown"></i> </a>
        <ul class="dropdown-menu dropdown-menu-text dropdown-menu-account account-s">
          <li><a target="" class="dropdown-menu-item first" href="http://www.o2olive.net/demo/index.php?act=storesetting&op=dashboard">商家登录</a></li>
          <li><a href="http://www.o2olive.net/demo/index.php?act=login&op=sregister" class="dropdown-menu-item">申请合作</a></li>
        </ul>
      </li>
    </ul>
  </div>
</div>
<!-- 导航 -->
<div id="header">
  <div id="header-bottom">
    <div id="header-bottom-new" style="width:1025px;">
      <div id="logo"> <a href="http://www.o2olive.net/demo"><img src="/resources/images/9bb0b297fef066c19a53b322d171e629.jpg"></a>
                <!--<div class="nc—city-info">
					<h2>@天津</h2>
					<a class="ncchange-city" href="http://www.o2olive.net/demo/index.php?act=city&op=city">[城市切换]</a>
					</div>-->
              </div>
            <div id="search-box" style="width:490px;">
        <form id="search_form" target="_top" method="get" action="http://www.o2olive.net/demo/index.php">
          <input type="hidden" value="groupbuy" name="act">
          <input type="hidden" value="list" name="op">
          <div class="tab"> <span class="tri"></span>
            <ul class="search_tabs">
                            <li class="search_tab" op="search_groupbuy">活动</li>
              <li class="search_tab" op="search_store">约会</li>
               <li class="search_tab" op="search_goodsreal">名师</li>
               <li class="search_tab" op="search_goodsreal">问答</li>
               <li class="search_tab" op="search_goodsreal">项目</li>
              <li class="search_tab" op="search_goodsreal">文章</li>
              
                          </ul>
          </div>
          <input type="text" placeholder="输入关键字查找在本地的团购" x-webkit-speech="" value="" class="search-box-from" style="width:310px;" data-smartbox="/search/smartboxv2/" autocomplete="off" name="keyword" tabindex="1" id="">
          <input type="submit" data-mod="sr" value="搜  索" hidefocus="true" class="search_button">
        </form>
        <div class="search_hot">
          <div class="search_hot_list">
                                                <a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword=KTV" class="hot_link" data="KTV">KTV</a>
                        <a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword=%E7%81%AB%E9%94%85" class="hot_link" data="火锅">火锅</a>
                        <a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword=%E7%82%B8%E9%B8%A1%E5%95%A4%E9%85%92" class="hot_link" data="炸鸡啤酒">炸鸡啤酒</a>
                        <a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword=%E8%87%AA%E5%8A%A9%E9%A4%90" class="hot_link" data="自助餐">自助餐</a>
                        <a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword=%E5%B7%9D%E8%8F%9C" class="hot_link" data="川菜">川菜</a>
                        <a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword=%E6%9D%80%E6%88%AE%E5%9C%B0%E5%B8%A6" class="hot_link" data="杀戮地带">杀戮地带</a>
                      </div>
        </div>

        <!--<ul class="tab f13">
					<li op="search_store" class="current">本地商户</li>
                    <li>|</li>
                    <li op="search_groupbuy" class="">本地团购</li>
				   </ul>-->
        <!--<div class="search-box-from">

							<input type="hidden" name="act" value='index'>
							<input type="hidden" name="op" value='list'>
							<div style="display:inline-block;zoom:1;" class="placeholder">
								<input type='text' name='keyword' class='nc-search-input J_KeyWord gray' id='keyword' value='' placeholder='输入关键字查找在本地的团购'>
							</div>
							<a href="javascript:void(0);" id="SubmitFrom"></a>

				   </div>-->
      </div>
      <div class="site-commitment"> 
      	<a href="javascript:void(0);" class="commitment-item commitment-item--retire"></a> 
      	<a href="javascript:void(0);" class="commitment-item commitment-item--free"></a>
      	<a href="javascript:void(0);" class="commitment-item commitment-item--expire"></a> </div>
          </div>
  </div>
</div>
<div id="main-nav" style="background:#e64d5e;">
  <div id="main-nav-wrap" style="width:1025px;">
    <div class="section-main sub-nav"> <a href="http://www.o2olive.net/demo/#" target="_blank"><span class="nc-cates">全部分类</span></a>
      <div class="category" style="display: block;">
        <ul class="menu">
                                                  <li class="odd" cat_id="1">
            <div class="class">
              <h4><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1">餐饮美食</a></h4>
              <span class="recommend-class">
                                          <a title="自助餐" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1&class_id_1=2">自助餐</a>
                            <a title="火锅" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1&class_id_1=3">火锅</a>
                            <a title="蛋糕" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1&class_id_1=4">蛋糕</a>
                            </span><span class="arrow"></span> </div>
            <div cat_menu_id="1" class="sub-class masonry" hover="1" style="display: none; position: relative; height: 68px;">
              <dl class="masonry-brick" style="position: absolute; top: 0px; left: 7px;">
                <dt>
                  <h3><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1">餐饮美食</a></h3>
                </dt>
                <dd class="goods-class">
                                                      <a title="自助餐" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1&class_id_1=2">自助餐</a>
                                    <a title="火锅" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1&class_id_1=3">火锅</a>
                                    <a title="蛋糕" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1&class_id_1=4">蛋糕</a>
                                  </dd>
              </dl>
            </div>
          </li>
                                        <li class="even" cat_id="5">
            <div class="class">
              <h4><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=5">酒店</a></h4>
              <span class="recommend-class">
                                          <a title="经济型酒店" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=5&class_id_1=6">经济型酒店</a>
                            <a title="主题酒店" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=5&class_id_1=7">主题酒店</a>
                            <a title="豪华酒店" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=5&class_id_1=8">豪华酒店</a>
                            </span><span class="arrow"></span> </div>
            <div cat_menu_id="5" class="sub-class">
              <dl>
                <dt>
                  <h3><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=5">酒店</a></h3>
                </dt>
                <dd class="goods-class">
                                                      <a title="经济型酒店" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=5&class_id_1=6">经济型酒店</a>
                                    <a title="主题酒店" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=5&class_id_1=7">主题酒店</a>
                                    <a title="豪华酒店" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=5&class_id_1=8">豪华酒店</a>
                                  </dd>
              </dl>
            </div>
          </li>
                                        <li class="odd" cat_id="9">
            <div class="class">
              <h4><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=9">休闲娱乐</a></h4>
              <span class="recommend-class">
                                          <a title="KTV" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=9&class_id_1=10">KTV</a>
                            <a title="足疗按摩" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=9&class_id_1=11">足疗按摩</a>
                            <a title="水上娱乐" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=9&class_id_1=12">水上娱乐</a>
                            </span><span class="arrow"></span> </div>
            <div cat_menu_id="9" class="sub-class">
              <dl>
                <dt>
                  <h3><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=9">休闲娱乐</a></h3>
                </dt>
                <dd class="goods-class">
                                                      <a title="KTV" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=9&class_id_1=10">KTV</a>
                                    <a title="足疗按摩" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=9&class_id_1=11">足疗按摩</a>
                                    <a title="水上娱乐" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=9&class_id_1=12">水上娱乐</a>
                                  </dd>
              </dl>
            </div>
          </li>
                                        <li class="even" cat_id="13">
            <div class="class">
              <h4><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=13">旅游</a></h4>
              <span class="recommend-class">
                                          <a title="景点门票" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=13&class_id_1=14">景点门票</a>
                            <a title="周边游" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=13&class_id_1=15">周边游</a>
                            <a title="国内游" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=13&class_id_1=16">国内游</a>
                            </span><span class="arrow"></span> </div>
            <div cat_menu_id="13" class="sub-class">
              <dl>
                <dt>
                  <h3><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=13">旅游</a></h3>
                </dt>
                <dd class="goods-class">
                                                      <a title="景点门票" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=13&class_id_1=14">景点门票</a>
                                    <a title="周边游" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=13&class_id_1=15">周边游</a>
                                    <a title="国内游" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=13&class_id_1=16">国内游</a>
                                  </dd>
              </dl>
            </div>
          </li>
                                        <li class="odd" cat_id="17">
            <div class="class">
              <h4><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=17">生活服务</a></h4>
              <span class="recommend-class">
                                          <a title="婚纱摄影" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=17&class_id_1=18">婚纱摄影</a>
                            <a title="儿童摄影" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=17&class_id_1=19">儿童摄影</a>
                            <a title="汽车服务" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=17&class_id_1=20">汽车服务</a>
                            </span><span class="arrow"></span> </div>
            <div cat_menu_id="17" class="sub-class">
              <dl>
                <dt>
                  <h3><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=17">生活服务</a></h3>
                </dt>
                <dd class="goods-class">
                                                      <a title="婚纱摄影" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=17&class_id_1=18">婚纱摄影</a>
                                    <a title="儿童摄影" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=17&class_id_1=19">儿童摄影</a>
                                    <a title="汽车服务" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=17&class_id_1=20">汽车服务</a>
                                  </dd>
              </dl>
            </div>
          </li>
                                        <li class="even" cat_id="21">
            <div class="class">
              <h4><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=21">丽人</a></h4>
              <span class="recommend-class">
                                          <a title="美发" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=21&class_id_1=22">美发</a>
                            <a title="美容美体" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=21&class_id_1=23">美容美体</a>
                            <a title="美甲" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=21&class_id_1=24">美甲</a>
                            </span><span class="arrow"></span> </div>
            <div cat_menu_id="21" class="sub-class">
              <dl>
                <dt>
                  <h3><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=21">丽人</a></h3>
                </dt>
                <dd class="goods-class">
                                                      <a title="美发" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=21&class_id_1=22">美发</a>
                                    <a title="美容美体" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=21&class_id_1=23">美容美体</a>
                                    <a title="美甲" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=21&class_id_1=24">美甲</a>
                                  </dd>
              </dl>
            </div>
          </li>
                                        <li class="odd" cat_id="25">
            <div class="class">
              <h4><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=25">家装</a></h4>
              <span class="recommend-class">
                                          <a title="装修设计" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=25&class_id_1=26">装修设计</a>
                            <a title="家居家具" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=25&class_id_1=27">家居家具</a>
                            <a title="家具卖场" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=25&class_id_1=28">家具卖场</a>
                            </span><span class="arrow"></span> </div>
            <div cat_menu_id="25" class="sub-class">
              <dl>
                <dt>
                  <h3><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=25">家装</a></h3>
                </dt>
                <dd class="goods-class">
                                                      <a title="装修设计" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=25&class_id_1=26">装修设计</a>
                                    <a title="家居家具" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=25&class_id_1=27">家居家具</a>
                                    <a title="家具卖场" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=25&class_id_1=28">家具卖场</a>
                                  </dd>
              </dl>
            </div>
          </li>
                                                  <li class="odd" cat_id="gr_class">
            <div class="class">
              <h4><a href="http://www.o2olive.net/demo/index.php?act=goodsreal">购物</a></h4>
              <span class="recommend-class">
                            <a title="生活家居" href="http://www.o2olive.net/demo/index.php?act=goodsreal&class_id=1">生活家居</a>
                            <a title="服饰鞋包" href="http://www.o2olive.net/demo/index.php?act=goodsreal&class_id=2">服饰鞋包</a>
                            <a title="食品饮料" href="http://www.o2olive.net/demo/index.php?act=goodsreal&class_id=3">食品饮料</a>
                            </span><span class="arrow"></span> </div>
            <div cat_menu_id="gr_class" class="sub-class">
              <dl>
                <dt>
                  <h3><a href="http://www.o2olive.net/demo/index.php?act=goodsreal">购物</a></h3>
                </dt>
                <dd class="goods-class">
                                    <a title="生活家居" href="http://www.o2olive.net/demo/index.php?act=goodsreal&class_id=1">生活家居</a>
                                    <a title="服饰鞋包" href="http://www.o2olive.net/demo/index.php?act=goodsreal&class_id=2">服饰鞋包</a>
                                    <a title="食品饮料" href="http://www.o2olive.net/demo/index.php?act=goodsreal&class_id=3">食品饮料</a>
                                    <a title="珠宝饰品" href="http://www.o2olive.net/demo/index.php?act=goodsreal&class_id=4">珠宝饰品</a>
                                    <a title="数码家电" href="http://www.o2olive.net/demo/index.php?act=goodsreal&class_id=5">数码家电</a>
                                  </dd>
              </dl>
            </div>
          </li>
                  </ul>
      </div>
    </div>
    <ul class="navbar">
      <li><span class="split-line"><a href="/" class="">首页</a></span></li>
                        <li><span class="split-line"> <a class="current" href="＃">活动</a></span></li> 
                        <li><span class="split-line"> <a class="" href="＃">约会</a></span></li>
                        <li><span class="split-line"> <a class="" href="#">圈子</a></span></li>
                        <li><span class="split-line"> <a class="" href="＃">讲师</a></span></li>
                        <li><span class="split-line"> <a class="" href="＃">找场地</a></span></li>
                        <li><span class="split-line"> <a class="" href="＃">问答</a></span></li>
                        <li><span class="split-line"> <a class="" href="＃">纸上谈兵</a></span></li>
                        <li><span class="split-line"> <a class="" href="＃">最佳实践</a></span></li>
                        <li><span class="split-line"> <a class="" href="＃">文章</a></span></li>
                        
                        <li><span class="split-line"> <a class="" target="_blank" href="＃">社区</a></span></li>
                                                                      </ul>
  </div>
</div>
<script type="text/javascript" src="/resources/js/jquery.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/js/jquery.flexslider-min.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/js/jquery.masonry.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/jquery.ui.css">
<script type="text/javascript" src="/resources/js/jquery.ui.js"></script>
<script type="text/javascript" src="/resources/js/zh-CN.js"></script>
<script type="text/javascript" src="/resources/js/jquery.SuperSlide.2.1.1.js" charset="utf-8"></script>
<style type="text/css">
.flex-active {
	background-color: #E64D5E;
}
.dialo-select {
	border: 1px solid #cccccc;
	margin-right: 5px;
	padding: 8px 10px 6px;
}
.cnum {
	color:#999;
	font-size:12px;
}
</style>
<script type="text/javascript">
$(window).load(function() {
	$(function() {
		$('.category').show();
	$('#apt_date').datepicker({dateFormat: 'yy-mm-dd',minDate:'0'});	
    $(".login-target").click(function() {
        var target = $(this).hasClass("login-target-normal") ? true : false;
        $(this).toggleClass("login-target-normal");
        if (target){
            $(".login-dcode").addClass("hide");
            $(".login-nomal").removeClass("hide")
        }else{
            $(".login-dcode").removeClass("hide");
            $(".login-nomal").addClass("hide")
        }
    });
    $('#new_group').mouseover(function(){
        $(this).parent().addClass("on");
    	$('#new_store').parent().removeClass("on");
    	$('#new_group_show').removeClass("Hide");
    	$('#new_store_show').addClass("Hide");
    });
	$('#new_store').mouseover(function(){
		$(this).parent().addClass("on");
    	$('#new_group').parent().removeClass("on");
    	$('#new_store_show').removeClass("Hide");
    	$('#new_group_show').addClass("Hide");
    });
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
	//$('.flexslider').flexslider();
	
	$('#all-category li').each(function(){
		$(this).hover(
			function(){
				var nctype = $(this).attr('nc');
				$(this).addClass('list-hover');
				$("div[nc="+nctype+"]").show();
			},
			function(){
				var nctype = $(this).attr('nc');
				$(this).removeClass('list-hover');
				$("div[nc="+nctype+"]").hide();
			}
		);
	});
	
	$(".cat-menu").each(function(){
		$(this).hover(
			function(){
				$(this).show();
			},
			function(){
				$(this).hide();
			}
		);
	});

	var morli = $(".areaall li:gt(0)");
	$(morli).hide();
	$(".more_area").click(function(){
		$(this).hide();
		$(".close_area").show();
		$(morli).slideToggle("slow",function(){ });
	});
	$(".close_area").click(function(){
		$(this).hide();
		$(".more_area").show();
		$(morli).slideToggle("slow",function(){ });
	});
	
});
</script>

<div class="warp-index">
<div class="warp-left">
<div class="block-line mb10">
<div class="block-title"><span>知名讲师</span></div>
<ul class="vip-list">
<li>
<a href="http://www.o2olive.net/demo/index.php?act=membershow&mid=117" target="_blank" title="">
<div class="vip-pic"> <img alt="chomyoeng" src="/resources/images/member.png"> </div>
<div class="vip-txt">
<h4>chomyoeng</h4>
<p><span class="level-icon-5 sp-growth-icons level-icon" title=""></span><span class="cnum">(点评数：8)</span></p>
</div>
</a>
<p class="cp-line"></p>
</li>
<li>
<a href="http://www.o2olive.net/demo/index.php?act=membershow&mid=17" target="_blank" title="">
<div class="vip-pic"> <img alt="如鱼得水" src="/resources/images/avatar_17.jpg"> </div>
<div class="vip-txt">
<h4>如鱼得水</h4>
<p><span class="level-icon-6 sp-growth-icons level-icon" title=""></span><span class="cnum">(点评数：6)</span></p>
</div>
</a>
<p class="cp-line"></p>
</li>
<li>
<a href="http://www.o2olive.net/demo/index.php?act=membershow&mid=13" target="_blank" title="">
<div class="vip-pic"> <img alt="lzpsnake" src="/resources/images/avatar_13.jpg"> </div>
<div class="vip-txt">
<h4>lzpsnake</h4>
<p><span class="level-icon-6 sp-growth-icons level-icon" title=""></span><span class="cnum">(点评数：6)</span></p>
</div>
</a>
<p class="cp-line"></p>
</li>
<li>
<a href="http://www.o2olive.net/demo/index.php?act=membershow&mid=15" target="_blank" title="">
<div class="vip-pic"> <img alt="神医华佗" src="/resources/images/avatar_15.jpg"> </div>
<div class="vip-txt">
<h4>神医华佗</h4>
<p><span class="level-icon-4 sp-growth-icons level-icon" title=""></span><span class="cnum">(点评数：4)</span></p>
</div>
</a>
<p class="cp-line"></p>
</li>
<li>
<a href="http://www.o2olive.net/demo/index.php?act=membershow&mid=18" target="_blank" title="">
<div class="vip-pic"> <img alt="颖颖_众木成林" src="/resources/images/avatar_18.jpg"> </div>
<div class="vip-txt">
<h4>颖颖_众木成林</h4>
<p><span class="level-icon-6 sp-growth-icons level-icon" title=""></span><span class="cnum">(点评数：4)</span></p>
</div>
</a>
<p class="cp-line"></p>
</li>
<li>
<a href="http://www.o2olive.net/demo/index.php?act=membershow&mid=14" target="_blank" title="">
<div class="vip-pic"> <img alt="森林使者" src="/resources/images/avatar_14.jpg"> </div>
<div class="vip-txt">
<h4>森林使者</h4>
<p><span class="level-icon-5 sp-growth-icons level-icon" title=""></span><span class="cnum">(点评数：4)</span></p>
</div>
</a>
<p class="cp-line"></p>
</li>
</ul>
</div>
<h4 class="wi-ad"><a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/db2bed5a09f266f22fe47e68fc832c38.jpg" width="215" height="270"></a></h4>
</div>
<div class="warp-leftside-index">
  <div class="layer-top-index">
    <div class="mainslid" id="mainslid">
      <ol><li class="">1</li><li class="">2</li><li class="">3</li><li class="">4</li><li class="on">5</li></ol>
     <div class="tempWrap" style="overflow:hidden; position:relative; height:100px"><ul style="top: -400px; position: relative; padding: 0px; margin: 0px;">
        <li style="height: 100px;"><a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/6a87632bf6ded77a9019a48e4ea88112.jpg" width="550" height="100"></a></li>
        <li style="height: 100px;"><a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/f57d1bda24763be474767200a2d54b06.jpg" width="550" height="100"></a></li>
        <li style="height: 100px;"><a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/e091b0b2915fd5352472616fbb77daf9.jpg" width="550" height="100"></a></li>
        <li style="height: 100px;"><a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/dd94aeaf09d0a7dd019d9a902eb5822b.jpg" width="550" height="100"></a></li>
        <li style="height: 100px;"><a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/6c4941db5f8bb7c6d871a1453dfaa142.jpg" width="550" height="100"></a></li>
      </ul></div>
    </div>
    <div class="popular-nav">
      <div class="block-title"> <strong>热门导航</strong> <a track="dp_home_all_hotdaohang_more_tianjin|module#5_home_hot_more,action#click,title#更多" class="more" href="http://www.o2olive.net/demo/index.php?act=index&op=list" target="_blank">更多</a> </div>
      <ul class="term-list block-inner gr">
        <li class="term-list-item"> <strong class="term">分类:</strong>
          <ul class="desc Fix">
          	          	            <li><a title="餐饮美食" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1" target="_blank">餐饮美食</a></li>
                        <li><a style="color:#dc2c40;" title="自助餐" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1&class_id_1=2" target="_blank">自助餐</a></li>
                        <li><a style="color:#dc2c40;" title="火锅" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1&class_id_1=3" target="_blank">火锅</a></li>
                        <li><a style="color:#dc2c40;" title="蛋糕" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1&class_id_1=4" target="_blank">蛋糕</a></li>
                        <li><a title="休闲娱乐" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=9" target="_blank">休闲娱乐</a></li>
                        <li><a style="color:#dc2c40;" title="旅游" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=13" target="_blank">旅游</a></li>
                        <li><a style="color:#dc2c40;" title="景点门票" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=13&class_id_1=14" target="_blank">景点门票</a></li>
                        <li><a style="color:#dc2c40;" title="周边游" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=13&class_id_1=15" target="_blank">周边游</a></li>
                        <li><a style="color:#dc2c40;" title="国内游" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=13&class_id_1=16" target="_blank">国内游</a></li>
                        <li><a style="color:#dc2c40;" title="生活服务" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=17" target="_blank">生活服务</a></li>
                        <li><a style="color:#dc2c40;" title="丽人" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=21" target="_blank">丽人</a></li>
                        <li><a title="美发" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=21&class_id_1=22" target="_blank">美发</a></li>
                        <li><a title="美甲" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=21&class_id_1=24" target="_blank">美甲</a></li>
                        <li><a style="color:#dc2c40;" title="装修设计" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=25&class_id_1=26" target="_blank">装修设计</a></li>
                        <li><a class="more" href="http://www.o2olive.net/demo/index.php?act=index&op=list" target="_blank">全部分类</a></li>
          </ul>
        </li>
        <li class="term-list-item"> <strong class="term">商区:</strong>
          <ul id="hotregion" class="desc Fix">
          	          	            <li><a style="color:#dc2c40;" title="滨江道" href="http://www.o2olive.net/demo/index.php?act=index&op=list&city_id=1&area_id=5&mall_id=333" target="_blank">滨江道</a></li>
                        <li><a title="小白楼" href="http://www.o2olive.net/demo/index.php?act=index&op=list&city_id=1&area_id=5&mall_id=335" target="_blank">小白楼</a></li>
                        <li><a title="天津站后广场" href="http://www.o2olive.net/demo/index.php?act=index&op=list&city_id=1&area_id=315&mall_id=354" target="_blank">天津站后广场</a></li>
                        <li><a style="color:#dc2c40;" title="水游城" href="http://www.o2olive.net/demo/index.php?act=index&op=list&city_id=1&area_id=3&mall_id=316" target="_blank">水游城</a></li>
                        <li><a title="汉沽城区" href="http://www.o2olive.net/demo/index.php?act=index&op=list&city_id=1&area_id=319&mall_id=369" target="_blank">汉沽城区</a></li>
                        <li><a title="王顶堤/华苑" href="http://www.o2olive.net/demo/index.php?act=index&op=list&city_id=1&area_id=3&mall_id=322" target="_blank">王顶堤/华苑</a></li>
                        <li><a title="南开大学/八里台" href="http://www.o2olive.net/demo/index.php?act=index&op=list&city_id=1&area_id=3&mall_id=327" target="_blank">南开大学/八里</a></li>
                        <li><a title="芥园道/水游城" href="http://www.o2olive.net/demo/index.php?act=index&op=list&city_id=1&area_id=318&mall_id=379" target="_blank">芥园道/水游城</a></li>
                        <li><a style="color:#dc2c40;" title="西湖道" href="http://www.o2olive.net/demo/index.php?act=index&op=list&city_id=1&area_id=3&mall_id=382" target="_blank">西湖道</a></li>
                        <li><a title="大悦城" href="http://www.o2olive.net/demo/index.php?act=index&op=list&city_id=1&area_id=3&mall_id=6" target="_blank">大悦城</a></li>
                        <li><a class="more" href="http://www.o2olive.net/demo/index.php?act=index&op=list" target="_blank">全部商区</a></li>
          </ul>
        </li>
      </ul>
    </div>
    <script type="text/javascript">
		$(function(){
			$('#bk-place-span-id').toggle(function(){//区域选择
				$('#c_area').show();
			},function(){
				$('#c_area').hide();
			});
			$('.u_area li').click(function(){
				var data_id = $(this).attr('data-id');
				var nc_html = $(this).html();

				$("input[name=apt_area]").val(data_id);
				$('#c_area').hide();			
				$('#bk-place-span-id').html(nc_html);			
			});
			
			
			$('#bk-hour-span-id').toggle(function(){//时间选择
				$('#c_hour').show();
			},function(){
				$('#c_hour').hide();
			});
			$('.u_hour li').click(function(){
				var data_id = $(this).attr('data-id');
				var nc_html = $(this).html();

				$("input[name=apt_time]").val(data_id);
				$('#c_hour').hide();			
				$('#bk-hour-span-id').html(nc_html);						
			});	
			

			$('#bk-person-span-id').toggle(function(){
				$('#c_person').show();
			},function(){
				$('#c_person').hide();
			});
			$('.u_person li').click(function(){
				var data_id = $(this).attr('data-id');
				var nc_html = $(this).html();

				$("input[name=apt_pnum]").val(data_id);
				$('#c_person').hide();			
				$('#bk-person-span-id').html(nc_html);						
			});	
			
		});
    </script>
    <div class="clear"></div>
    <div class="book-category">
      <div class="booking-catetit">
        <h4>快速订座</h4>
        <p>提前预订座位，不用排队哦！</p>
      </div>
      <div class="book-select-index">
        <div class="book-select">    
          <ul>
            <li class="ap-list"> <a class="bk-slet bk-place" href="http://www.o2olive.net/demo/#"><span id="bk-place-span-id">所有地区</span></a>
              <div id="c_area" class="slt_wrap slt_box slt_area" style="display:none;">
                <div class="slt_list">
                  <ul class="u_area">
                    <li data-id="0">全市范围</li>
                       					                    <li data-id="3">南开区</li>
                                        <li data-id="5">和平区</li>
                                        <li data-id="314">河西区</li>
                                        <li data-id="315">河东区</li>
                                        <li data-id="317">河北区</li>
                                        <li data-id="318">红桥区</li>
                                        <li data-id="319">滨海新区</li>
                                                          </ul>
                  <input type="hidden" name="apt_area">
                </div>
              </div>
            </li>
            <li class="ap-list">
              <input type="text" readonly="readonly" value="2014-10-07" id="apt_date" name="apt_date" class="bk-date hasDatepicker">
              <!-- <input type="text" readonly="readonly" value="2013-08-16星期四" id="bk-date-input-id" name="" class="bk-date"> -->
            </li>
            <li class="ap-list"> <a class="bk-slet bk-hour" href="javascript:;"><span id="bk-hour-span-id">18:00</span></a>
              <div id="c_hour" class="slt_wrap slt_box slt_time" style="display:none;">
                <div class="slt_list">
                  <ul class="u_hour">
                                        <li data-id="0:00">0:00</li>
                    <li data-id="0:30">0:30</li>
				                        <li data-id="1:00">1:00</li>
                    <li data-id="1:30">1:30</li>
				                        <li data-id="2:00">2:00</li>
                    <li data-id="2:30">2:30</li>
				                        <li data-id="3:00">3:00</li>
                    <li data-id="3:30">3:30</li>
				                        <li data-id="4:00">4:00</li>
                    <li data-id="4:30">4:30</li>
				                        <li data-id="5:00">5:00</li>
                    <li data-id="5:30">5:30</li>
				                        <li data-id="6:00">6:00</li>
                    <li data-id="6:30">6:30</li>
				                        <li data-id="7:00">7:00</li>
                    <li data-id="7:30">7:30</li>
				                        <li data-id="8:00">8:00</li>
                    <li data-id="8:30">8:30</li>
				                        <li data-id="9:00">9:00</li>
                    <li data-id="9:30">9:30</li>
				                        <li data-id="10:00">10:00</li>
                    <li data-id="10:30">10:30</li>
				                        <li data-id="11:00">11:00</li>
                    <li data-id="11:30">11:30</li>
				                        <li data-id="12:00">12:00</li>
                    <li data-id="12:30">12:30</li>
				                        <li data-id="13:00">13:00</li>
                    <li data-id="13:30">13:30</li>
				                        <li data-id="14:00">14:00</li>
                    <li data-id="14:30">14:30</li>
				                        <li data-id="15:00">15:00</li>
                    <li data-id="15:30">15:30</li>
				                        <li data-id="16:00">16:00</li>
                    <li data-id="16:30">16:30</li>
				                        <li data-id="17:00">17:00</li>
                    <li data-id="17:30">17:30</li>
				                        <li data-id="18:00">18:00</li>
                    <li data-id="18:30">18:30</li>
				                        <li data-id="19:00">19:00</li>
                    <li data-id="19:30">19:30</li>
				                        <li data-id="20:00">20:00</li>
                    <li data-id="20:30">20:30</li>
				                        <li data-id="21:00">21:00</li>
                    <li data-id="21:30">21:30</li>
				                        <li data-id="22:00">22:00</li>
                    <li data-id="22:30">22:30</li>
				                        <li data-id="23:00">23:00</li>
                    <li data-id="23:30">23:30</li>
				                      </ul>
                  <input type="hidden" name="apt_pnum">
                </div>
              </div>
            </li>
            <li class="ap-list"><a class="bk-slet bk-menb" href="javascript:;"> <span id="bk-person-span-id">4人</span> </a>
              <div id="c_person" class="slt_wrap slt_box slt_num" style="display:none;">
                <div class="slt_list">
                  <ul class="u_person">
                  	                  	<li data-id="1">1人</li>       
                  	                  	<li data-id="2">2人</li>       
                  	                  	<li data-id="3">3人</li>       
                  	                  	<li data-id="4">4人</li>       
                  	                  	<li data-id="5">5人</li>       
                  	                  	<li data-id="6">6人</li>       
                  	                  	<li data-id="7">7人</li>       
                  	                  	<li data-id="8">8人</li>       
                  	                  	<li data-id="9">9人</li>       
                  	                  	<li data-id="10">10人</li>       
                  	                  	<li data-id="11">11人</li>       
                  	                  	<li data-id="12">12人</li>       
                  	                  	<li data-id="13">13人</li>       
                  	                  	<li data-id="14">14人</li>       
                  	                  	<li data-id="15">15人</li>       
                  	                  	<li data-id="16">16人</li>       
                  	                  	<li data-id="17">17人</li>       
                  	                  	<li data-id="18">18人</li>       
                  	                  	<li data-id="19">19人</li>       
                  	          
                  </ul>
                  <input type="hidden" name="apt_time">
                </div>
              </div>             
            </li>
            <li class="ap-list"> <span class="medi-btn"><a href="javascript:quick_appointment();" title="提前订座，不用排队哦！" class="btn-txt">我要订座</a></span> </li>
          </ul>
        </div>
    </div>
    </div>
    <script type="text/javascript">
    function quick_appointment(){
		var apt_area = $('input[name="apt_area"]').val();
		var apt_date = $('#apt_date').val();
		var apt_time = $('input[name="apt_time"]').val();
		var apt_pnum = $('input[name="apt_pnum"]').val();
		if(parseInt(apt_area) == 0){
			window.location.href = 'index.php?act=appointment&apt_date='+apt_date+'&apt_time='+apt_time+'&apt_pnum='+apt_pnum;
		}else{
			window.location.href = 'index.php?act=appointment&area_id='+apt_area+'&apt_date='+apt_date+'&apt_time='+apt_time+'&apt_pnum='+apt_pnum;
		}
	}
   </script>
  <div class="clear"></div>
    <div class="block-inner features-list features-list-a gr">
      <div class="block-title"><strong>热门活动</strong> <a track="" class="more" target="_blank" href="http://www.o2olive.net/demo/circle">更多</a></div>
      <div class="b-dpkan">
        <div class="mainjx" id="mainjx">
          <ol><li class="">1</li><li class="">2</li><li class="">3</li><li class="">4</li><li class="on">5</li></ol>
          <div class="tempWrap" style="overflow:hidden; position:relative; height:160px"><ul style="top: -640px; position: relative; padding: 0px; margin: 0px;">
            <li style="height: 160px;"><a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/8163dff0935e0bc04e236e50c3b7aa2e.jpg" width="250" height="160"></a></li>
            <li style="height: 160px;"><a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/dd76131d28313b8bca06ba70da29449b.jpg" width="250" height="160"></a></li>
            <li style="height: 160px;"><a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/40976e76c771ea3a344ad3f66d577242.jpg" width="250" height="160"></a></li>
            <li style="height: 160px;"><a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/33e9e93f7bd396f67a24bfdebf132ea8.jpg" width="250" height="160"></a></li>
            <li style="height: 160px;"><a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/28ac5e24203dcbaeb5ed8d367f7e5c5d.jpg" width="250" height="160"></a></li>
          </ul></div>
        </div>
      </div>
      <ul class="b-content">
 		  
 		 
 		  
 		  
        <li class="leading">
          <h2 class="title"><a target="_blank" href="http://www.o2olive.net/demo/circle/index.php?act=theme&op=theme_detail&c_id=1&t_id=3"><!--<span>[吃喝玩乐]</span>-->暑期正酣 约小伙伴出来聚餐</a></h2>
          <p>【Room北京】这间料理店的主厨是“世界十大名厨”之一的马克南——分子料理带入中...          
          <a target="_blank" href="http://www.o2olive.net/demo/circle/index.php?act=theme&op=theme_detail&c_id=1&t_id=3">全文</a>
          
          </p>
        </li>
                          
 		        <li>
          <h3><a target="_blank" href="http://www.o2olive.net/demo/circle/index.php?act=theme&op=theme_detail&c_id=1&t_id=1"><span>[ 吃喝玩乐 ]</span>12道锋味 谢霆锋带你吃遍世界</a></h3>
        </li>      
                          
 		        <li>
          <h3><a target="_blank" href="http://www.o2olive.net/demo/circle/index.php?act=theme&op=theme_detail&c_id=1&t_id=6"><span>[ 吃喝玩乐 ]</span>潮太疯潮汕砂锅粥双人套餐</a></h3>
        </li>      
                          
 		        <li>
          <h3><a target="_blank" href="http://www.o2olive.net/demo/circle/index.php?act=theme&op=theme_detail&c_id=5&t_id=10"><span>[ 话唠大本营 ]</span>发个文章这么费劲</a></h3>
        </li>      
                          
 		        <li>
          <h3><a target="_blank" href="http://www.o2olive.net/demo/circle/index.php?act=theme&op=theme_detail&c_id=2&t_id=11"><span>[ 小吃零食 ]</span>这圈子啥意思</a></h3>
        </li>      
                        		      </ul>
    </div>
    
    <div class="info-free">
      <div class="block-title"><strong>推荐话题</strong><a class="more" href="http://www.o2olive.net/demo/circle" target="_blank">更多 </a></div>
      <div class="block-inner gr">
        <div class="wf-list">
          <ul>
          	          	          	
            <li>
            	<a title="ArtsStudio韩国品像摄影" href="http://www.o2olive.net/demo/circle/index.php?act=theme&op=theme_detail&c_id=1&t_id=7" target="_blank">
            		<img alt="ArtsStudio韩国品像摄影" src="/resources/images/8501c0aa9f4e1b714fbcdacb268aa940.jpg_160x160.jpg">
            	</a>
              	<p class="name"><a class="col-whit-link" title="ArtsStudio韩国品像摄影" href="http://www.o2olive.net/demo/circle/index.php?act=theme&op=theme_detail&c_id=1&t_id=7" target="_blank">ArtsStudio韩国品像摄影</a> </p>
            </li>
                      	
            <li>
            	<a title="潮太疯潮汕砂锅粥双人套餐" href="http://www.o2olive.net/demo/circle/index.php?act=theme&op=theme_detail&c_id=1&t_id=6" target="_blank">
            		<img alt="潮太疯潮汕砂锅粥双人套餐" src="/resources/images/6762fdb0e19de52fb96c22be9472a0e1.jpg_160x160.jpg">
            	</a>
              	<p class="name"><a class="col-whit-link" title="潮太疯潮汕砂锅粥双人套餐" href="http://www.o2olive.net/demo/circle/index.php?act=theme&op=theme_detail&c_id=1&t_id=6" target="_blank">潮太疯潮汕砂锅粥双人套餐</a> </p>
            </li>
                      	
            <li>
            	<a title="暑期正酣 约小伙伴出来聚餐" href="http://www.o2olive.net/demo/circle/index.php?act=theme&op=theme_detail&c_id=1&t_id=3" target="_blank">
            		<img alt="暑期正酣 约小伙伴出来聚餐" src="/resources/images/5ceb940fd03258dc85c82635e14bcad1.jpg_160x160.jpg">
            	</a>
              	<p class="name"><a class="col-whit-link" title="暑期正酣 约小伙伴出来聚餐" href="http://www.o2olive.net/demo/circle/index.php?act=theme&op=theme_detail&c_id=1&t_id=3" target="_blank">暑期正酣 约小伙伴出来聚餐</a> </p>
            </li>
                                  </ul>
        </div>
      </div>
    </div>
    <div class="coupon-block">
      <div class="block-title"><strong>最新热门优惠</strong><a target="_blank" class="more" href="http://www.o2olive.net/demo/index.php?act=coupon&op=list">更多</a></div>
      <div class="block-inner features-list features-list-b gr">
        <ul class="b-content cs-second">
                              <li> <a title="麦田量贩KTV包间费用8折优惠券" href="http://www.o2olive.net/demo/index.php?act=coupon&op=detail&coupon_id=4" target="_blank"><span>[麦田量贩式KTV]</span>麦田量贩KTV包间费用8折优惠券</a> </li>
                    <li> <a title="麻辣诱惑全场8折优惠券" href="http://www.o2olive.net/demo/index.php?act=coupon&op=detail&coupon_id=3" target="_blank"><span>[麻辣诱惑]</span>麻辣诱惑全场8折优惠券</a> </li>
                    <li> <a title="哈根达斯冰淇淋夏日特惠香醇好滋味" href="http://www.o2olive.net/demo/index.php?act=coupon&op=detail&coupon_id=2" target="_blank"><span>[PANKOO釜山料理（大悦城店）]</span>哈根达斯冰淇淋夏日特惠香醇好滋味</a> </li>
                    <li> <a title="[津汇广场优惠]多款团购商品享特惠" href="http://www.o2olive.net/demo/index.php?act=coupon&op=detail&coupon_id=1" target="_blank"><span>[俏江南]</span>[津汇广场优惠]多款团购商品享特惠</a> </li>
                  </ul>
        <ul class="b-content cs-second">
                  </ul>
      </div>
    </div>
    <div class="clear"></div>
    <div class="info-free">
      <div class="block-title "> <strong>最新同城活动</strong> <a onclick="" class="more " href="http://www.o2olive.net/demo/#" target="_blank"></a> </div>
      <div class="block-inner gr ">
        <div class="wf-list">
          <ul>
          	      		            <li><a title="麻辣诱惑“Lady In Red 看你有多红”" href="http://www.o2olive.net/demo/index.php?act=store&op=activity&id=4" target="_blank"> <img alt="麻辣诱惑“Lady In Red 看你有多红”" src="/resources/images/e431b1fbc646a161ccbe6e7f60cbd726.jpg"> </a>
              <p class="name" style="font-weight:bolder;"><a class="col-whit-link " title="麻辣诱惑“Lady In Red 看你有多红”" href="http://www.o2olive.net/demo/index.php?act=store&op=activity&id=4" target="_blank">麻辣诱惑“Lady In Red 看你有多红”</a> </p>
            </li>
                        <li><a title="[大熊十月摄影优惠]店长推荐套系特惠698元" href="http://www.o2olive.net/demo/index.php?act=store&op=activity&id=1" target="_blank"> <img alt="[大熊十月摄影优惠]店长推荐套系特惠698元" src="/resources/images/9eae1829c84e4eaee9ab0e24c857382e.jpg"> </a>
              <p class="name" style="font-weight:bolder;"><a class="col-whit-link " title="[大熊十月摄影优惠]店长推荐套系特惠698元" href="http://www.o2olive.net/demo/index.php?act=store&op=activity&id=1" target="_blank">[大熊十月摄影优惠]店长推荐套系特惠698元</a> </p>
            </li>
                        <li><a title="PANKOO釜山料理釜山料理尚品厨房多套餐组合免费试吃活动" href="http://www.o2olive.net/demo/index.php?act=store&op=activity&id=3" target="_blank"> <img alt="PANKOO釜山料理釜山料理尚品厨房多套餐组合免费试吃活动" src="/resources/images/b899f16d34f76fd55b7745419084175f.jpg_small.jpg"> </a>
              <p class="name" style="font-weight:bolder;"><a class="col-whit-link " title="PANKOO釜山料理釜山料理尚品厨房多套餐组合免费试吃活动" href="http://www.o2olive.net/demo/index.php?act=store&op=activity&id=3" target="_blank">PANKOO釜山料理釜山料理尚品厨房多套餐组合免费试吃活动</a> </p>
            </li>
                      </ul>
        </div>
      </div>
    </div>
    <div class="dp-block">
      <div class="block-title"><strong>最新点评</strong><a track="" class="more" href="http://www.o2olive.net/demo/#" target="_blank"></a></div>
      <ul class="block-inner comment-list comment-list-a gr">
      	      	        <li class="comment-list-item"> <a track="#" class="avatar" rel="nofollow" href="http://www.o2olive.net/demo/index.php?act=membershow&mid=15" target="_blank"><img width="48" height="48" class=" J_lazy-img" title="神医华佗" alt="神医华佗" src="/resources/images/avatar_15.jpg"></a>
          <div class="dp-content">
            <h3> <a track="" rel="nofollow" href="http://www.o2olive.net/demo/index.php?act=membershow&mid=15" target="_blank">神医华佗</a>@<a class="shop-name" href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=1" target="_blank">俏江南</a> <span class="time"><span class="time">2014-08-15 16:13</span> </span> </h3>
            <div class="comment-rst"> <span class="item-rank-rst irr-star5" title=""></span>
              <dl>
                <dt>人均:</dt>
                <dd><span class="Price">¥</span>80</dd>
              </dl>
            </div>
            <div class="comment-entry">
              <blockquote>和小伙伴一起团购来的这家，哇，真是没有虚度此行啊，菜品很好吃，每一道都好吃，无法挑出缺点，唯一的纠结点恐怕就是价格了。没...</blockquote>          
              <span class="more"><a href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=1" target="_blank">全文</a></span> </div>
          </div>
        </li>
                <li class="comment-list-item"> <a track="#" class="avatar" rel="nofollow" href="http://www.o2olive.net/demo/index.php?act=membershow&mid=13" target="_blank"><img width="48" height="48" class=" J_lazy-img" title="lzp" alt="lzp" src="/resources/images/avatar_13.jpg"></a>
          <div class="dp-content">
            <h3> <a track="" rel="nofollow" href="http://www.o2olive.net/demo/index.php?act=membershow&mid=13" target="_blank">lzp</a>@<a class="shop-name" href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=4" target="_blank">麻辣诱惑</a> <span class="time"><span class="time">2014-08-12 14:17</span> </span> </h3>
            <div class="comment-rst"> <span class="item-rank-rst irr-star5" title=""></span>
              <dl>
                <dt>人均:</dt>
                <dd><span class="Price">¥</span>60</dd>
              </dl>
            </div>
            <div class="comment-entry">
              <blockquote>蟹黄豆腐每次都点，但是冷了之后就有点腻了。干锅土豆片小辣。水煮鱼也是每次都点的。这次还拿DB换了50元优惠券，非常值！</blockquote>          
              <span class="more"><a href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=4" target="_blank">全文</a></span> </div>
          </div>
        </li>
                <li class="comment-list-item"> <a track="#" class="avatar" rel="nofollow" href="http://www.o2olive.net/demo/index.php?act=membershow&mid=18" target="_blank"><img width="48" height="48" class=" J_lazy-img" title="颖颖_众木成林" alt="颖颖_众木成林" src="/resources/images/avatar_18.jpg"></a>
          <div class="dp-content">
            <h3> <a track="" rel="nofollow" href="http://www.o2olive.net/demo/index.php?act=membershow&mid=18" target="_blank">颖颖_众木成林</a>@<a class="shop-name" href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=3" target="_blank">PANKOO釜山料理（大悦城店）</a> <span class="time"><span class="time">2014-08-11 11:36</span> </span> </h3>
            <div class="comment-rst"> <span class="item-rank-rst irr-star2" title=""></span>
              <dl>
                <dt>人均:</dt>
                <dd><span class="Price">¥</span>50</dd>
              </dl>
            </div>
            <div class="comment-entry">
              <blockquote>我团购错了，原团了二张75元抵100元的，后改了175元抵200的，原来的没有用，可没想到原来的75元抵100元的被服务...</blockquote>          
              <span class="more"><a href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=3" target="_blank">全文</a></span> </div>
          </div>
        </li>
              </ul>
    </div>
    <div class="hot-q">
      <div class="block-title"> <strong>热门圈子strong> <a track="" class="more" href="http://www.o2olive.net/demo/circle" target="_blank">更多</a> </div>
      <ul class="block-inner thumb-list gr">
      	      	        <li> <a href="http://www.o2olive.net/demo/circle/index.php?act=group&c_id=1" target="_blank"><img alt="吃喝玩乐" src="/resources/images/1.jpg"></a>
          <div class="title"> <a href="http://www.o2olive.net/demo/circle/index.php?act=group&c_id=1" target="_blank">吃喝玩乐</a> </div>
        </li>
                <li> <a href="http://www.o2olive.net/demo/circle/index.php?act=group&c_id=2" target="_blank"><img alt="小吃零食" src="/resources/images/2.jpg"></a>
          <div class="title"> <a href="http://www.o2olive.net/demo/circle/index.php?act=group&c_id=2" target="_blank">小吃零食</a> </div>
        </li>
                <li> <a href="http://www.o2olive.net/demo/circle/index.php?act=group&c_id=3" target="_blank"><img alt="美食厨房DIY" src="/resources/images/3.jpg"></a>
          <div class="title"> <a href="http://www.o2olive.net/demo/circle/index.php?act=group&c_id=3" target="_blank">美食厨房DIY</a> </div>
        </li>
                <li> <a href="http://www.o2olive.net/demo/circle/index.php?act=group&c_id=4" target="_blank"><img alt="个人部落" src="/resources/images/4.jpg"></a>
          <div class="title"> <a href="http://www.o2olive.net/demo/circle/index.php?act=group&c_id=4" target="_blank">个人部落</a> </div>
        </li>
                <li> <a href="http://www.o2olive.net/demo/circle/index.php?act=group&c_id=5" target="_blank"><img alt="话唠大本营" src="/resources/images/5.jpg"></a>
          <div class="title"> <a href="http://www.o2olive.net/demo/circle/index.php?act=group&c_id=5" target="_blank">话唠大本营</a> </div>
        </li>
              </ul>
    </div>
    <script type="text/javascript">
$(".mainslid").slide({titCell:"ol",mainCell:"ul",autoPage:true,effect:"top",autoPlay:true});  
</script> 
    <script type="text/javascript">
$(".mainjx").slide({titCell:"ol",mainCell:"ul",autoPage:true,effect:"top",autoPlay:true});  
</script> 
    <script>
  /*鼠标移过，左右按钮显示*/
  $(".weekcollect_show_box").hover(function(){
  	$(this).find(".prev,.next").fadeTo("show",0.8);
  },function(){
  	$(this).find(".prev,.next").hide();
  })
  $(".weekcollect_show_box").slide({ titCell:".wc_num ul" , mainCell:".weekcollect_show" , effect:"left", autoPlay:true, delayTime:700 , autoPage:true });
  </script> 
  </div>
  <script>
  /*鼠标移过，左右按钮显示*/
  $(".promo-list-item").hover(function(){
  	$(this).find(".prev,.next").fadeTo("show",0.8);
  },function(){
  	$(this).find(".prev,.next").hide();
  })
  $(".promo-list-item").slide({ titCell:".panel-ctrl ul" , mainCell:"#new_store_show" , effect:"left", autoPlay:false, delayTime:700 , autoPage:true });
  $(".promo-list-item").slide({ titCell:".panel-ctrl ul" , mainCell:"#new_group_show" , effect:"left", autoPlay:false, delayTime:700 , autoPage:true });
  </script> 
</div>
<div class="aside warp-rightside mt10"> 
  <!-- 登录 -->
  	<div class="block-line not-login">
		<div class="hd">
		  <p>快速登录</p>
		</div>
		<div class="login-box">
        <div class="login-qs"> 
		  <a href="http://www.o2olive.net/demo/shop/api.php?act=toqq" class="btn-qq J-trigger"><i class="icon-qq"></i>QQ登录</a>
		  <a href="http://www.o2olive.net/demo/shop/api.php?act=tosina" class="btn-sina J-trigger"><i class="icon-sina"></i>新浪微博登录</a>
        </div>
		  <div class="login-other"> （本地生活帐号）<a href="http://www.o2olive.net/demo/index.php?act=login" class="ml5">登录</a><i class="split">|</i><a href="http://www.o2olive.net/demo/index.php?act=login&op=register">注册</a> </div>
		</div>
	</div>
  <div class="block-line  hot-tuan">
    <div class="block-title mr10"><span>热门活动</span><a href="http://www.o2olive.net/demo/index.php?act=groupbuy" target="_blank" class="more">更多</a></div>
    <ul class="block-list" style="height:392px;">
                  <li><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=5">
        <div class="image"> <img width="117" height="73" src="/resources/images/b04e08f62b8a9afc6a8f6979da8300d6.jpg" alt="仅售199元！最高价值281元的3-4人分享餐3选1，限时限量抢购，节假日通用，可累计，15店通用！"> </div>
        <div class="text">
          <h4>仅售199元！最高价值281元的3-4人分享餐3选1，限时限量抢购，节假日通用，可累计，15店通用！</h4>
          <p>PANKOO釜山料理（大悦城店）</p>
          <span class="price"> <em>¥199.00</em> <del>¥281.00</del> </span> </div>
        </a></li>
            <li><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=20">
        <div class="image"> <img width="117" height="73" src="/resources/images/4923a8db49e624dba0230e5a1c654021.jpg" alt="仅售165元！价值198元的天津欢乐谷直通车单人通票1张（门票+车费）。天津欢乐谷震撼登陆！"> </div>
        <div class="text">
          <h4>仅售165元！价值198元的天津欢乐谷直通车单人通票1张（门票+车费）。天津欢乐谷震撼登陆！</h4>
          <p>天津欢乐谷</p>
          <span class="price"> <em>¥165.00</em> <del>¥198.00</del> </span> </div>
        </a></li>
            <li><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=4">
        <div class="image"> <img width="117" height="73" src="/resources/images/79f8c8474e7fa5657bc8f21f2cab3fa6.jpg" alt="仅售80元！价值100元的代金券1张，除酒水饮料外全场通用，可叠加使用。"> </div>
        <div class="text">
          <h4>仅售80元！价值100元的代金券1张，除酒水饮料外全场通用，可叠加使用。</h4>
          <p>麻辣诱惑</p>
          <span class="price"> <em>¥80.00</em> <del>¥100.00</del> </span> </div>
        </a></li>
            <li><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=19">
        <div class="image"> <img width="117" height="73" src="/resources/images/887ab39299b77eb6c0dbab1e4cfd9b52.jpg" alt="仅售1999元！价值8588元的台北摄影套系，赠送中国国旅港澳4天3夜双人游贵宾券，记录"> </div>
        <div class="text">
          <h4>仅售1999元！价值8588元的台北摄影套系，赠送中国国旅港澳4天3夜双人游贵宾券，记录</h4>
          <p>伊莎诺曼婚纱摄影</p>
          <span class="price"> <em>¥1999.00</em> <del>¥8588.00</del> </span> </div>
        </a></li>
            <li><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=9">
        <div class="image"> <img width="117" height="73" src="/resources/images/71da7974cc2844e0310db6682be76d2f.jpg" alt="【意大利风情区/火车站】 如家快捷酒店"> </div>
        <div class="text">
          <h4>【意大利风情区/火车站】 如家快捷酒店</h4>
          <p>如家快捷酒店</p>
          <span class="price"> <em>¥129.00</em> <del>¥199.00</del> </span> </div>
        </a></li>
            <li><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=3">
        <div class="image"> <img width="117" height="73" src="/resources/images/b7913acdd14f22ea735b5fcebbade460.jpg" alt="【滨江道】 韩古风韩式自助烧烤"> </div>
        <div class="text">
          <h4>【滨江道】 韩古风韩式自助烧烤</h4>
          <p>韩古风</p>
          <span class="price"> <em>¥40.00</em> <del>¥50.00</del> </span> </div>
        </a></li>
          </ul>
  </div>
  <div class="block-line hot-info" style="padding-bottom:5px;">
    <div class="block-title mb10"><span>活跃圈子</span><a href="http://www.o2olive.net/demo/index.php?act=index&op=list" target="_blank" class="more">更多</a></div>
    <div class="block-con hot-shop">
      <div class="pic-txt">
        <ul>
                              <li>
            <div class="pic"> <a href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=3" target="_blank"> <img src="/resources/images/a2d85485c2e12987f96428c3ee102a56.png" alt="PANKOO釜山料理（大悦城店）"> </a> </div>
            <div class="txt">
              <h4> <a title="PANKOO釜山料理（大悦城店）" href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=3" target="_blank">PANKOO釜山料理（大悦城店）</a> </h4>
              <p><span title="" class="item-rank-rst irr-star4"></span></p>
            </div>
          </li>
                    <li>
            <div class="pic"> <a href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=4" target="_blank"> <img src="/resources/images/138eb3af43631d9183b5e536323fd85e.jpg" alt="麻辣诱惑"> </a> </div>
            <div class="txt">
              <h4> <a title="麻辣诱惑" href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=4" target="_blank">麻辣诱惑</a> </h4>
              <p><span title="" class="item-rank-rst irr-star5"></span></p>
            </div>
          </li>
                    <li>
            <div class="pic"> <a href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=1" target="_blank"> <img src="/resources/images/5c94ed5f267aa54977706cadb12be8b6.jpg" alt="俏江南"> </a> </div>
            <div class="txt">
              <h4> <a title="俏江南" href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=1" target="_blank">俏江南</a> </h4>
              <p><span title="" class="item-rank-rst irr-star5"></span></p>
            </div>
          </li>
                    <li>
            <div class="pic"> <a href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=2" target="_blank"> <img src="/resources/images/225f955726361c84a257963f35ebbf58.jpg" alt="韩古风"> </a> </div>
            <div class="txt">
              <h4> <a title="韩古风" href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=2" target="_blank">韩古风</a> </h4>
              <p><span title="" class="item-rank-rst irr-star3"></span></p>
            </div>
          </li>
                    <li>
            <div class="pic"> <a href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=7" target="_blank"> <img src="/resources/images/4845cf92233e3b4bcecd24538e3b3402.jpg" alt="如家快捷酒店"> </a> </div>
            <div class="txt">
              <h4> <a title="如家快捷酒店" href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=7" target="_blank">如家快捷酒店</a> </h4>
              <p><span title="" class="item-rank-rst irr-star5"></span></p>
            </div>
          </li>
                    <li>
            <div class="pic"> <a href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=6" target="_blank"> <img src="/resources/images/a15b1f636316ca13e9f7b01cf0f7b4ed.jpg" alt="麦田量贩式KTV"> </a> </div>
            <div class="txt">
              <h4> <a title="麦田量贩式KTV" href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=6" target="_blank">麦田量贩式KTV</a> </h4>
              <p><span title="" class="item-rank-rst irr-star5"></span></p>
            </div>
          </li>
                  </ul>
      </div>
    </div>
  </div>
  <div class="weekly-image">
    <ul class="wi-wrap">
      <a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/cce6e6bce929813ac1812cc3dad1cefa.jpg" width="240" height="100"></a>    </ul>
  </div>
</div>
<div id="tbox"> <a style="display: block;" title="返回顶部" href="http://www.o2olive.net/demo/#pagetop" id="gotop">&nbsp;</a> </div>
<script type="text/javascript">
	$(function(){
		var time = parseInt("1412694497");
		$('.process').each(function(){
			var lag = parseInt($(this).attr('endtime')) - time;
			if(lag>0){
			   var second = Math.floor(lag % 60);    
			   var minite = Math.floor((lag / 60) % 60);
			   var hour = Math.floor((lag / 3600) % 24);
			   var day = Math.floor((lag / 3600) / 24);
			   $(this).html('<span>'+day+'</span>'+'天'+'<span>'+hour+'</span>'+'小时'+'<span>'+minite+"</span>"+'分'+'<span>'+second+'</span>'+'秒');
			}
		});
		function updateEndTime(){
			time++;		
			$(".process").each(function(){
				var lag = parseInt($(this).attr('endTime')) - time;
				if(lag>0){
				    var second = Math.floor(lag % 60);    
				    var minite = Math.floor((lag / 60) % 60);
				    var hour = Math.floor((lag / 3600) % 24);
				    var day = Math.floor((lag / 3600) / 24);
					$(this).html('<span>'+day+'</span>'+'天'+'<span>'+hour+'</span>'+'小时'+'<span>'+minite+"</span>"+'分'+'<span>'+second+'</span>'+'秒');
				}else{
				}
			});
			setTimeout(updateEndTime,1000);
		}
		setTimeout(updateEndTime,1000);
	});
</script><div id="footer">
	<div class="footer-box">
	    <p><a href="http://www.o2olive.net/demo">首页</a>
	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    | <a target="_blank" href="http://www.o2olive.net/demo/index.php?act=article&article_id=17">招聘英才</a>
	    	    	    	    | <a href="http://www.o2olive.net/demo/index.php?act=article&article_id=18">广告合作</a>
	    	    	    	    | <a href="http://www.o2olive.net/demo/index.php?act=article&article_id=16">联系我们</a>
	    	    	    	    | <a href="http://www.o2olive.net/demo/index.php?act=article&article_id=15">关于O2OLive</a>
	    	    	    	    |&nbsp;<a href="http://www.o2olive.net/demo/index.php?act=slogin">商户登录</a>
	  </p>

	  Copyright 2007-2014 O2OLive Inc.,All rights reserved.<br>
	  Powered by <span class="vol"><font class="b">O2OLive</font></span>
	  <br>
	  <br>
	</div>
</div>
</div><div id="ui-datepicker-div" class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div></body></html>