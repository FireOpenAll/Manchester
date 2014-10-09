<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<!-- saved from url=(0072)http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22 -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><script src="/resources/js/shares.php" charset="utf-8"></script>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9">

<title>[俏江南] 仅售468元！最高价值1436元的俏江南北京17店468元6人自选套餐，提供免费WiFi。_O2OLive团购</title>
<meta name="keywords" content="本地生活 美食 娱乐 电影 团购 优惠券 活动">
<meta name="description" content="O2OLive专注于研发符合时代发展需要的电子商务商城系统，以专业化的服务水平为企业级用户提供B(2B)2C【B2B2C】电子商务平台解决方案，全力打造电商平台专项ERP(CRM)系统、ERP(RFID)系统等，引领中国电子商务行业企业级需求的发展方向。咨询电话：400-611-5098">
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
<link rel="stylesheet" type="text/css" href="/resources/css/bmap.css"></head>
<body id="pagetop"><link href="/resources/css/jiathis_counter.css" rel="stylesheet" type="text/css"><script src="/resources/js/jiathis.php" charset="utf-8"></script><link href="/resources/css/jiathis_share.css" rel="stylesheet" type="text/css"><iframe frameborder="0" style="position: absolute; display: none; opacity: 0;"></iframe><div class="jiathis_style" style="position: absolute; z-index: 1000000000; display: none; top: 50%; left: 50%; overflow: auto;"></div><div class="jiathis_style" style="position: absolute; z-index: 1000000000; display: none; overflow: auto;"></div><iframe frameborder="0" src="./活动detail_files/jiathis_utility.html" style="display: none;"></iframe>
<div id="topNav" style="z-index:999;position:relative;">
  <div id="topNav-inner-new" style="width:990px;">
    <ul class="topNav-left">
            <li class="user_info"> <span>您好，欢迎来到O2OLive系统演示站</span> <a class="user-info-login" href="http://www.o2olive.net/demo/index.php?act=login">[登录]</a><a class="user-info-signup" href="http://www.o2olive.net/demo/index.php?act=login&op=register">[注册]</a> </li>
                  <li class="line">|</li>
      <li class="mobile-info-item dropdown"> <a href="javascript:void(0);" class="dropdown-tog"><i class="icon-mobile"></i>手机本地生活<i class="tri tri-dropdown"></i></a>
        <div class="dropdown-menu dropdown-menu-app"> <a target="_blank" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22#" class="app-block"> <span class="app-block-title">免费下载O2OLive手机版</span> <span class="app-block-content"> <img src="/resources/images/6f4416f017cad0a0a46fee4c7624425d.png" width="89px"> </span> <i class="app-block-arrow"></i> </a> </div>
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
          <li><a href="#" class="dropdown-menu-item">绑定手机号</a></li>
          <li><a href="#" class="dropdown-menu-item">常见问题</a></li>
        </ul>
      </li>
      -->
      <li class="line">|</li>
      <li class="dropdown dropdown-account"> <a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22#" class="dropdown-tog"> <span>我是商家</span> <i class="tri tri-dropdown"></i> </a>
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
    <div id="header-bottom-new" style="width:990px;">
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
					<li op="search_store" class="">本地商户</li>
                    <li>|</li>
                    <li op="search_groupbuy" class="current">本地团购</li>
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
  <div id="main-nav-wrap">
    <div class="section-main sub-nav"> <a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22#" target="_blank"><span class="nc-cates">全部分类<i class="arrow"></i></span></a>
      <div class="category">
        <ul class="menu">
                                                  <li class="odd" cat_id="1">
            <div class="class">
              <h4><a href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1">餐饮美食</a></h4>
              <span class="recommend-class">
                                          <a title="自助餐" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1&class_id_1=2">自助餐</a>
                            <a title="火锅" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1&class_id_1=3">火锅</a>
                            <a title="蛋糕" href="http://www.o2olive.net/demo/index.php?act=index&op=list&class_id=1&class_id_1=4">蛋糕</a>
                            </span><span class="arrow"></span></div>
            <div cat_menu_id="1" class="sub-class">
              <dl>
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
                            </span><span class="arrow"></span></div>
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
                            </span><span class="arrow"></span></div>
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
                            </span><span class="arrow"></span></div>
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
                            </span><span class="arrow"></span></div>
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
                            </span><span class="arrow"></span></div>
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
                            </span><span class="arrow"></span></div>
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
<link rel="stylesheet" type="text/css" href="/resources/css/jquery.ui.css">
<script type="text/javascript" src="/resources/js/jquery.ui.js"></script>
<script type="text/javascript" src="/resources/js/zh-CN.js"></script>
<script type="text/javascript">
$(function(){
	var mid = '';
	$('.gpbuy').click(function(){
		if(parseInt(mid) > 0){
			var now_time = '1412236367';
			var end_time = '1663171200';
			if(parseInt(now_time) >= parseInt(end_time)){
				return false;
			}
			var num = parseInt($('.group-cart').val());
			window.location.href = 'index.php?act=groupbuy&op=groupbuyorder&group_id=22&buy_num='+num;
		}else{
			ajax_form('login', '登录', '/user/login','500px');
		}
	});
	$('#apt_date').datepicker({dateFormat: 'yy-mm-dd',minDate:'0'});
	$.event.add(window, "scroll", function(){
		var p = $(window).scrollTop();
		var barpos = $('.group-detail-box').offset().top;
		var storepos = $('#store_position').offset().top;
		var accountpos = $('#buy_must_know').offset().top;
		var detailpos = $('#group_detail').offset().top;
		var storeintropos = $('#store_intro').offset().top;
		if(p >= barpos){
			$('.group-content-nav').addClass("common-fixed");
			$('.buy-group').show();
		}else{
			$('.group-content-nav').removeClass("common-fixed");
			$('.buy-group').hide();
		}
		if(p >= accountpos){
			$('#rightfix').addClass("right_fix");
		}else{
			$('#rightfix').removeClass("right_fix");
		}
		if(p>=storeintropos && p<storepos){
			$('a[href="#store_intro"]').parent().addClass("group-content-current").siblings().removeClass("group-content-current");
		}
		if(p>=storepos && p<accountpos){
			$('a[href="#store_position"]').parent().addClass("group-content-current").siblings().removeClass("group-content-current");
		}
		if(p>=accountpos && p<detailpos){
			$('a[href="#buy_must_know"]').parent().addClass("group-content-current").siblings().removeClass("group-content-current");
		}
		if(p>=detailpos){
			$('a[href="#group_detail"]').parent().addClass("group-content-current").siblings().removeClass("group-content-current");
		}
	});
})
</script>
<style type="text/css">
.flex-active {
	background-color: #E64D5E;
}
.dialo-select {
	border: 1px solid #cccccc;
	margin-right: 5px;
	padding: 5px 6px 4px;
}
</style>
<link rel="stylesheet" type="text/css" href="/resources/css/offlinestore.css">
<div class="life_body">
<div id="main-wrap"> 
  <div class="sitenav">    
      <a href="http://www.o2olive.net/demo/index.php?act=index">首页</a>&nbsp;»&nbsp;<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=1">餐饮美食</a>&nbsp;»&nbsp;<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=1&class_id_1=2">自助餐</a>&nbsp;»&nbsp;俏江南  </div>
 
  <div class="group-detail-con">
    <div class="gd-title">
      <h1>俏江南</h1>
      <p class="gd-des">仅售468元！最高价值1436元的俏江南北京17店468元6人自选套餐，提供免费WiFi。</p>
    </div>
    <div class="gd-con">
      <div class="group-pic"><img src="/resources/images/0eb1ccc3dbae8d94ea32a73986979f08.jpg">
      <p class="comp-deal" style=" float:right;"><span class="tit">服务承诺：</span><span class="tit02"> 支持团购退款 </span></p>
     
            <!-- JiaThis Button BEGIN -->
          <div class="jiathis_style" style="width:200px; float:left;"> <span class="jiathis_txt">分享到：</span> <a class="jiathis_button_icons_1" title="分享到QQ空间"><span class="jiathis_txt jtico jtico_qzone"></span></a> <a class="jiathis_button_icons_2" title="分享到新浪微博"><span class="jiathis_txt jtico jtico_tsina"></span></a> <a class="jiathis_button_icons_3" title="分享到腾讯微博"><span class="jiathis_txt jtico jtico_tqq"></span></a> <a class="jiathis_button_icons_4" title="分享到微信"><span class="jiathis_txt jtico jtico_weixin"></span></a> <a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a> <a class="jiathis_counter_style"><span class="jiathis_button_expanded jiathis_counter jiathis_bubble_style" id="jiathis_counter_110" title="累计分享0次">0</span></a> </div>
          <script "text="" javascript"=""> 
var jiathis_config = { 
	pic:"http://www.o2olive.net/demo/data/upload/shop/groupbuy/0eb1ccc3dbae8d94ea32a73986979f08.jpg" 
} 
</script> 
          <script type="text/javascript" src="/resources/js/jia.js" charset="utf-8"></script> 
          <!-- JiaThis Button END --> 
      </div>
      
      
      
      
      
      <div class="group-info">
        <div class="prices-box gr">
          <h2 class="price-cur red">¥<strong>468.00</strong></h2>
          <span class="price-tag red">3.3 折 </span> <del class="item">¥<!--节省968-->1436</del> </div>
        <div class="group-rating gr"> <span class="item">已售&nbsp;&nbsp;<strong>4</strong></span> <span class="item">浏览&nbsp;&nbsp;<strong>56</strong>&nbsp;&nbsp;次</span> <span class="item">
          <p class="process" endtime="1663171200"><span>2904</span>天<span>8</span>小时<span>6</span>分<span>36</span>秒</p>
          <p style="float:right;">仅剩</p>
          </span> </div>
        <div class="group-dealer gr"> <span class="group-detail-title">商家</span> <span class="item vertical-divider"><a title="俏江南" href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=1">俏江南</a></span> <span class="item vertical-divider group-content-current"><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22#store_position">查看地址/电话</a></span> </div>
        <div class="group-dealer gr"> <span class="group-detail-title">有效期</span> <span>截止到2022-09-15</span>&nbsp;&nbsp; <span class="red">周末、法定节假日通用</span> </div>
        <div class="group-dealer gr"> <span class="group-detail-title">使用时间</span> <span>10:00至22:00</span> </div>
        <div class="divider"></div>
        <div class="group-dealer gr mt15 mb20"> <span class="group-detail-title02">数量</span>
          <button id="reduce" type="button" gaevent="top/minus" data-action="-" for="J-cart-minus">−</button>
          <input type="text" maxlength="9" value="1" name="q" class="group-cart">
          <input type="hidden" name="still_num" value="196">
          <input type="hidden" name="limit_num" value="3">
          <button id="add" type="button" gaevent="top/plus" data-action="+" class="item" for="J-cart-add">+</button>
          <span class="item">剩余&nbsp;196&nbsp;份</span> </div>
        <div class="group-button"> <a class="cart-buy basic-deal gpbuy" href="javascript:void(0);">
                    </a> <a class="cart-button cart-add addtocart btn-bar-txt" group_id="22">加入购物车</a> <a class="sc-btn" href="javascript:add_fav(22,'groupbuy');"> 收藏 </a> </div>
        
        <!--<div class="prices-box gr">
            <dl>
              <dt>市场价</dt>
              <dd class="prices">￥1436</dd>
            </dl>
            <dl>
              <dt>折扣</dt>
              <dd>3.3 折 </dd>
            </dl>
            <dl>
              <dt>节省</dt>
              <dd>￥968</dd>
            </dl>
          </div>--> 
        <!--<div class="buy-now"><strong>¥&nbsp;468.00</strong><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=groupbuyorder&group_id=22">
                        </a></div>--> 
        <!--<div class="require">
            <h2> 本商品已被团购<em>4</em>件 剩余196件</h2>
            <div class="btn-bar ">
			<a class="btn-bar-txt" group_id="22">&nbsp;&nbsp;加入购物车&nbsp;&nbsp;</a>
			</div>
          </div>--> 
        <!--<div class="time">

            <h3>距离本期结束</h3>
            <p class="process" endtime="1663171200"></p>
			<p class="comp-deal"><span class="tit">服务承诺</span><span class="tit02">支持团购退款</span></p>
          </div>--> 
        
      </div>
    </div>
  </div>
  <div class="mainbox">
    <div class="layout_left02 clearfix">
      <div class="group-detail-box">
        <div class="group-content-nav">
          <ul class="gr">
            <li class="group-content-current"><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22#store_intro" class="tab-item">商家介绍</a></li>
            <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22#store_position" class="tab-item">商家位置</a></li>
            <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22#buy_must_know" class="tab-item">购买须知</a></li>
            <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22#group_detail" class="tab-item">商品详情</a></li>
          </ul>
          <div class="buy-group" style="display: none;"> <a href="javascript:void(0);" class="buy gpbuy" rel="nofollow">抢购</a> <a group_id="22" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22#" hidefocus="true" data-quantity="1" data-cityid="40" data-dealid="25564115" class="cart addtocart" rel="nofollow">加入购物车</a></div>
        </div>
        <div class="group-detail-main gr">
          <h2 class="standard-bar" id="store_intro">商家介绍</h2>
          <div class="standard-con" id="store_position">俏江南创始于2000年，自成立以来，俏江南遵循着创新、发展、品位与健康的企业核心精神，不断追求品牌的创新和突破，从国贸第一家餐厅到北京、上海、天津、武汉、成都、深圳、苏州、青岛、沈阳、南京、合肥等50多家店，从服务商业精英、政界要员到2008北京奥运会场、2010上海世博会，历经十年的健康成长，俏江南已经成为了中国最具发展潜力的国际餐饮服务管理公司之一。</div>
          <h2 class="standard-bar" id="store_position">商家位置</h2>
          <div class="map-business">
            <div class="map-box mr30">
              <div class="shop_map" id="container" style="width: 310px; height: 200px; margin: 0px auto; overflow: hidden; position: relative; z-index: 0; color: rgb(0, 0, 0); text-align: left; background-color: rgb(243, 241, 236);"><div style="overflow: visible; position: absolute; z-index: 0; left: 0px; top: 51px; cursor: url(http://api.map.baidu.com/images/openhand.cur) 8 8, default;"><div class="BMap_mask" style="position: absolute; left: 0px; top: -51px; z-index: 9; overflow: hidden; -webkit-user-select: none; width: 310px; height: 200px;"></div><div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 200;"><div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 800;"><div class="BMap_pop" style="position: absolute; cursor: default; left: 46px; top: -41px;"><div style="overflow: hidden; z-index: 1; position: absolute; left: 0px; top: 0px; width: 25px; height: 25px;"><img style="border:none;margin:0px;padding:0px;position:absolute;left:0px;top:0px;width:690px;height:786px;" src="/resources/images/iw3.png"></div><div class="BMap_top" style="overflow: hidden; z-index: 1; position: absolute; left: 25px; top: 0px; width: 202px; height: 25px;"><img src="/resources/images/iw3.png" style="position:absolute; left: -65px; top: -60px;"></div><div style="overflow: hidden; z-index: 1; position: absolute; left: 227px; top: 0px; width: 25px; height: 25px;"><img style="border:none;margin:0px;padding:0px;position:absolute;left:-665px;top:0px;width:690px;height:786px;" src="/resources/images/iw3.png"></div><div class="BMap_center" style="overflow: hidden; z-index: 1; position: absolute; left: 0px; top: 25px; width: 250px; height: 42px;"><img src="/resources/images/iw3.png" style="position:absolute;left:-65px;top:-60px;"></div><div style="overflow: hidden; z-index: 1; position: absolute; left: 0px; top: 67px; width: 25px; height: 25px;"><img style="border:none;margin:0px;padding:0px;position:absolute;left:0px;top:-665px;width:690px;height:786px;" src="/resources/images/iw3.png"></div><div class="BMap_bottom" style="overflow: hidden; z-index: 1; position: absolute; left: 25px; top: 67px; width: 202px; height: 24px;"><img src="/resources/images/iw3.png" style="position:absolute;left:-65px;top:-146px;"></div><div style="overflow: hidden; z-index: 1; position: absolute; left: 227px; top: 67px; width: 25px; height: 25px;"><img style="border:none;margin:0px;padding:0px;position:absolute;left:-665px;top:-665px;width:690px;height:786px;" src="/resources/images/iw3.png"></div><div style="overflow: hidden; z-index: 1; position: absolute; left: 109px; top: 67px; width: 34px; height: 50px;"><img style="border:none;margin:0px;padding:0px;position:absolute;left:-186px;top:-691px;width:690px;height:786px;" src="/resources/images/iw3.png"></div><div style="width: 220px; height: 60px; position: absolute; left: 16px; top: 16px; z-index: 10; overflow: auto;"><div class="BMap_bubble_title" style="overflow: hidden; height: auto; line-height: 24px; white-space: nowrap; width: auto;">商铺名称:俏江南</div><div class="BMap_bubble_content" style="width: auto; height: auto;">商铺地址:南门外大街2-6号中粮大悦城内北区4楼27号(南马路口)</div><div class="BMap_bubble_max_content" style="display: none; position: relative;"></div></div><img style="position: absolute; top: 12px; width: 12px; height: 12px; cursor: pointer; z-index: 10000; left: 227px;" src="/resources/images/iw_close.gif"><img style="position: absolute; top: 12px; width: 12px; height: 12px; cursor: pointer; z-index: 10000; display: none; left: 207px;" src="/resources/images/iw_plus.gif"></div></div><div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 700;"><span class="BMap_Marker BMap_noprint" unselectable="on" "="" style="position: absolute; padding: 0px; margin: 0px; border: 0px; cursor: pointer; width: 19px; height: 25px; left: 145px; top: 75px; z-index: -4599710; background: url(http://api.map.baidu.com/images/blank.gif);" title=""></span></div><div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 600;"><div class="BMap_shadow" style="position: absolute; left: 24px; top: 6px;" type="infowindow_shadow"><div style="overflow: hidden; z-index: 1; position: absolute; left: 38px; top: 0px; width: 70px; height: 30px;"><img onmousedown="return false" style="left: -323px; top: 0px;" src="/resources/images/iws3.png"></div><div style="overflow: hidden; z-index: 1; position: absolute; left: 108px; top: 0px; width: 163px; height: 30px;"><img onmousedown="return false" style="left: -393px; top: 0px;" src="/resources/images/iws3.png"></div><div style="overflow: hidden; z-index: 1; position: absolute; left: 271px; top: 0px; width: 70px; height: 30px;"><img onmousedown="return false" style="left: -1033px; top: 0px;" src="/resources/images/iws3.png"></div><div style="overflow: hidden; z-index: 1; position: absolute; left: 29px; top: 30px; width: 79px; height: 9px;"><img onmousedown="return false" style="top: -30px; left: -314px;" src="/resources/images/iws3.png"></div><div style="overflow: hidden; z-index: 1; position: absolute; left: 108px; top: 30px; width: 183px; height: 9px;"><img onmousedown="return false" style="left: -360px; top: -30px;" src="/resources/images/iws3.png"></div><div style="overflow: hidden; z-index: 1; position: absolute; left: 291px; top: 30px; width: 79px; height: 9px;"><img onmousedown="return false" style="top: -30px; left: -1054px;" src="/resources/images/iws3.png"></div><div style="overflow: hidden; z-index: 1; position: absolute; left: 0px; top: 39px; width: 50px; height: 60px;"><img onmousedown="return false" style="left: -14px; top: -310px;" src="/resources/images/iws3.png"></div><div style="overflow: hidden; z-index: 1; position: absolute; left: 50px; top: 39px; width: 11px; height: 60px;"><img onmousedown="return false" style="left: -255px; top: -310px;" src="/resources/images/iws3.png"></div><div style="overflow: hidden; z-index: 1; position: absolute; left: 61px; top: 39px; width: 140px; height: 60px;"><img onmousedown="return false" style="left: -440px; top: -310px;" src="/resources/images/iws3.png"></div><div style="overflow: hidden; z-index: 1; position: absolute; left: 201px; top: 39px; width: 61px; height: 60px;"><img onmousedown="return false" style="left: -255px; top: -310px;" src="/resources/images/iws3.png"></div><div style="overflow: hidden; z-index: 1; position: absolute; left: 262px; top: 39px; width: 70px; height: 60px;"><img onmousedown="return false" style="left: -754px; top: -310px;" src="/resources/images/iws3.png"></div></div></div><div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 500;"></div><div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 400;"><span class="BMap_Marker" unselectable="on" style="position: absolute; padding: 0px; margin: 0px; border: 0px; width: 0px; height: 0px; left: 145px; top: 75px; z-index: -4599710;"><div style="position: absolute; margin: 0px; padding: 0px; width: 19px; height: 25px; overflow: hidden;"><img src="/resources/images/marker_red_sprite.png" style="border:none;left:0px; top:0px; position:absolute;"></div></span></div><div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 300;"><span unselectable="on" style="position: absolute; padding: 0px; margin: 0px; border: 0px; width: 20px; height: 11px; left: 149px; top: 89px;"><div style="position: absolute; margin: 0px; padding: 0px; width: 20px; height: 11px; overflow: hidden;"><img src="/resources/images/marker_red_sprite.png" style="border:none;left:-19px; top:-13px; position:absolute;"></div></span></div><div style="position: absolute; height: 0px; width: 0px; left: 0px; top: 0px; z-index: 200;"></div></div><div style="position: absolute; top: 0px; left: 0px; z-index: 1;"><div style="position: absolute; z-index: -100; left: 155px; top: 49px;"><img src="/resources/images/saved_resource" style="position: absolute; border: none; width: 256px; height: 256px; left: -189px; top: 14px; opacity: 1;"><img src="/resources/images/saved_resource(1)" style="position: absolute; border: none; width: 256px; height: 256px; left: 67px; top: 14px; opacity: 1;"><img src="/resources/images/saved_resource(2)" style="position: absolute; border: none; width: 256px; height: 256px; left: -189px; top: -242px; opacity: 1;"><img src="/resources/images/saved_resource(3)" style="position: absolute; border: none; width: 256px; height: 256px; left: 67px; top: -242px; opacity: 1;"></div></div><div style="position: absolute; top: 0px; left: 0px; z-index: 2;"></div></div><div id="zoomer" style="position:absolute;z-index:0;top:0px;left:0px;overflow:hidden;visibility:hidden;cursor:url(http://api.map.baidu.com/images/openhand.cur) 8 8,default"><div class="BMap_zoomer" style="top:0;left:0;"></div><div class="BMap_zoomer" style="top:0;right:0;"></div><div class="BMap_zoomer" style="bottom:0;left:0;"></div><div class="BMap_zoomer" style="bottom:0;right:0;"></div></div><div class=" anchorBL" style="height: 32px; position: absolute; z-index: 10; bottom: 0px; right: auto; top: auto; left: 1px;"><a title="到百度地图查看此区域" target="_blank" href="http://map.baidu.com/?sr=1" style="outline: none;"><img style="border:none;width:77px;height:32px" src="/resources/images/copyright_logo.png"></a></div><div unselectable="on" class=" BMap_cpyCtrl anchorBL" style="cursor: default; white-space: nowrap; color: black; font-style: normal; font-variant: normal; font-weight: normal; font-size: 11px; line-height: 15px; font-family: arial, sans-serif; bottom: 2px; right: auto; top: auto; left: 81px; position: absolute; z-index: 10; background: none;"><span _cid="1" style="display: inline;"><span style="font-size:11px">© 2014 Baidu</span></span></div></div>
            </div>
            <div class="map-box-info">
              <div class="store_name_info">
                <h1 class="store_title" onclick="javascript:window.open(&#39;index.php?act=store&amp;op=detail&amp;id=1&#39;);" style="cursor:pointer">俏江南</h1>
              </div>
              <div class="remark_box"> <span class="remark-item star"></span>
                <div class="remark_taste"> <a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22#" class="col-num"></a> <em class="sep">|</em><span>人均<strong class="stress"> ¥59.00 </strong></span></div>
              </div>
              <ul>
                <li><em>地址：</em><span>南门外大街2-6号中粮大悦城内北区4楼27号(南马路口)</span></li>
                <li><em>电话：</em><span class="call">022-87288577</span></li>
                <li><em>靠近：</em><span class="call">大悦城</span></li>
                <li><em>营业时间：</em><span class="call">11点-24点</span></li>
              </ul>
            </div>
          </div>
          <div class="clear"></div>
          <h2 class="standard-bar" id="buy_must_know">购买须知</h2>
          <div style="padding-top:10px"><p>
	1.周六日节假日不参与门店(烟台振华店、济南银座店、青岛心海店、青岛中心店、天津银河店、天津大悦城店、天津MSD店、成都乐天百货店)。
</p>
<p>
	<br>
</p>
<p>
	2.武汉国际广场店、长沙方悦店、合肥1912店、合肥银泰店、上海港汇店、石家庄店，仅是周一至周五中午可使用。
</p>
<p>
	<br>
</p>
<p>
	3.苏州李公堤店仅是午市使用。
</p>
<p>
	<br>
</p>
<p>
	4、套餐内单品菜价仅供参考 ，由于参与分店较多，地区不同菜品价位不同，请以各分店内当时实际菜价为准。
团购用户不可同时享受商家其他优惠
方案内人数免费提供餐具，超出人数详询商家
酒水饮料等问题，请致电商家咨询，以商家反馈为准
如部分菜品因时令或其他不可抗因素导致无法提供，店内会用等价菜品替换，具体事宜请与店内协商。
</p>
<div id="xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd">
</div></div>
          <h2 class="standard-bar" id="group_detail">商品详情</h2>
          <div style="padding-top:10px"><div class="standard-content-title">
	<strong>鲜青椒水煮巴沙鱼</strong> 
</div>
<img src="/resources/images/__48323597__4287268.jpg" alt="美团图" height="1139"> <img src="/resources/images/__38673888__5221540.jpg" alt="美团图" height="468"> 
<div class="standard-content-title">
	<strong>宫保水晶虾球</strong> 
</div>
<img src="/resources/images/__38673884__9469089.jpg" alt="美团图" height="468"> 
<div class="standard-content-title">
	<strong>招牌砂窝红烧肉</strong> 
</div>
<img src="/resources/images/__38673888__3486366.jpg" alt="美团图" height="467"> 
<div class="standard-content-title">
	<strong>招牌脆皮鸡</strong> 
</div>
<img src="/resources/images/__38673888__6954676.jpg" alt="美团图" height="821"> 
<div class="standard-content-title">
	<strong>宫保鸡丁</strong> 
</div>
<img src="/resources/images/__38673888__4334649.jpg" alt="美团图" height="604"> 
<div class="standard-content-title">
	<strong>双椒石烤虾</strong> 
</div>
<img src="/resources/images/__38673887__2196272.jpg" alt="美团图" height="467"> 
<div class="standard-content-title">
	<strong>蜜汁火方</strong> 
</div>
<img src="/resources/images/__38673885__8645744.jpg" alt="美团图" height="953"> 
<div class="standard-content-title">
	<strong>锅巴海三鲜</strong> 
</div>
<img src="/resources/images/__38673884__9432996.jpg" alt="美团图" height="467"> 
<div class="standard-content-title">
	<strong>山城毛血旺</strong> 
</div>
<img src="/resources/images/__38673887__1155996.jpg" alt="美团图" height="1055"> 
<div class="standard-content-title">
	<strong>山药杂粮炖排骨</strong> 
</div>
<img src="/resources/images/__38673898__2987731.jpg" alt="美团图" height="1053"> 
<div class="standard-content-title">
	<strong>歌乐山辣子鸡</strong> 
</div>
<img src="/resources/images/__38673884__9553895.jpg" alt="美团图" height="467">
<div id="xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd">
</div></div>
          
          <!--<div class="side-left">
         <div class="side-left-intro">
            <div class="side-left-hd">
              <h2>该商家的其他团购</h2>
            </div>
            <div class="store-group-list">
	          <ul>
	          	          	            <li><a class="sg" target="_blank" href="index.php?act=groupbuy&op=detail&group_id=23"><i class="igcon"></i><strong class="price">￥198</strong>价值726元！ 仅售198元！最高价值726元的俏江南2人自选套餐，提供免费WiFi<span class="col-num">3人已购买 &nbsp;</span></a></li>
	          	          </ul>
	        </div>
          </div>
          <div class="side-left-intro">
            <div class="side-left-hd">
              <h2>团购说明</h2>
            </div>
            <div> <p>
	1.周六日节假日不参与门店(烟台振华店、济南银座店、青岛心海店、青岛中心店、天津银河店、天津大悦城店、天津MSD店、成都乐天百货店)。
</p>
<p>
	<br />
</p>
<p>
	2.武汉国际广场店、长沙方悦店、合肥1912店、合肥银泰店、上海港汇店、石家庄店，仅是周一至周五中午可使用。
</p>
<p>
	<br />
</p>
<p>
	3.苏州李公堤店仅是午市使用。
</p>
<p>
	<br />
</p>
<p>
	4、套餐内单品菜价仅供参考 ，由于参与分店较多，地区不同菜品价位不同，请以各分店内当时实际菜价为准。
团购用户不可同时享受商家其他优惠
方案内人数免费提供餐具，超出人数详询商家
酒水饮料等问题，请致电商家咨询，以商家反馈为准
如部分菜品因时令或其他不可抗因素导致无法提供，店内会用等价菜品替换，具体事宜请与店内协商。
</p>
<div id="xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd">
</div> </div>
          </div>
          <div class="side-left-intro">
            <div class="side-left-hd">
              <h2>团购介绍</h2>
            </div>
            <div> <div class="standard-content-title">
	<strong>鲜青椒水煮巴沙鱼</strong> 
</div>
<img src="http://p1.meituan.net/deal/__48323597__4287268.jpg" alt="美团图" height="1139" /> <img src="http://p0.meituan.net/deal/__38673888__5221540.jpg" alt="美团图" height="468" /> 
<div class="standard-content-title">
	<strong>宫保水晶虾球</strong> 
</div>
<img src="http://p1.meituan.net/deal/__38673884__9469089.jpg" alt="美团图" height="468" /> 
<div class="standard-content-title">
	<strong>招牌砂窝红烧肉</strong> 
</div>
<img src="http://p0.meituan.net/deal/__38673888__3486366.jpg" alt="美团图" height="467" /> 
<div class="standard-content-title">
	<strong>招牌脆皮鸡</strong> 
</div>
<img src="http://p0.meituan.net/deal/__38673888__6954676.jpg" alt="美团图" height="821" /> 
<div class="standard-content-title">
	<strong>宫保鸡丁</strong> 
</div>
<img src="http://p1.meituan.net/deal/__38673888__4334649.jpg" alt="美团图" height="604" /> 
<div class="standard-content-title">
	<strong>双椒石烤虾</strong> 
</div>
<img src="http://p0.meituan.net/deal/__38673887__2196272.jpg" alt="美团图" height="467" /> 
<div class="standard-content-title">
	<strong>蜜汁火方</strong> 
</div>
<img src="http://p1.meituan.net/deal/__38673885__8645744.jpg" alt="美团图" height="953" /> 
<div class="standard-content-title">
	<strong>锅巴海三鲜</strong> 
</div>
<img src="http://p1.meituan.net/deal/__38673884__9432996.jpg" alt="美团图" height="467" /> 
<div class="standard-content-title">
	<strong>山城毛血旺</strong> 
</div>
<img src="http://p0.meituan.net/deal/__38673887__1155996.jpg" alt="美团图" height="1055" /> 
<div class="standard-content-title">
	<strong>山药杂粮炖排骨</strong> 
</div>
<img src="http://p0.meituan.net/deal/__38673898__2987731.jpg" alt="美团图" height="1053" /> 
<div class="standard-content-title">
	<strong>歌乐山辣子鸡</strong> 
</div>
<img src="http://p1.meituan.net/deal/__38673884__9553895.jpg" alt="美团图" height="467" />
<div id="xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd">
</div> </div>
          </div>
        </div>--> 
        </div>
        <div class="buy-bottom"> <span class="price">¥<strong>468.00</strong></span>
          <ul class="serif buy-bottom-text gr">
            <li>门店价<br>
              <del class="num"><span>¥</span>1436.00</del></li>
            <li>折扣<br>
              <span class="num">3.3折</span></li>
            <li>已售<br>
              <span class="num">4</span></li>
          </ul>
          <div class="btn-wrapper"><a href="javascript:void(0);" class="J-buy buy gpbuy" rel="nofollow"></a><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22#" class="J-add-cart cart addtocart" rel="nofollow" group_id="22"></a></div>
        </div>
        <div class="ad-detail-l mb10"><a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/3b8d10750bfa7e9b6e5a944df0edbbca.gif" width="735" height="100"></a></div>
      </div>
      <!--<div class="sidebar">
      <div class="hot-group clearfix mb10">
      	<div class="hot-group-hd" style="margin-bottom:5px">
      		<h2>店铺地图</h2>
      	</div>
      	<div class="shop_map" id="container" style=" width:220px;height:200px; margin: 0 auto;"></div>
      </div>
      <div class="hot-group clearfix mb10">
        <div class="hot-group-hd">
          <h2>热门团购</h2>
          <a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list">更多团购&gt;&gt;</a> </div>
                <ul class="recom-ul">
                    <li> <a class="thumb" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=20"> <img width="220" height="125" src="http://www.o2olive.net/demo/data/upload/shop/groupbuy/4923a8db49e624dba0230e5a1c654021.jpg"> </a>
            <h6> <a title="" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=20">仅售165元！价值198元的天津欢乐谷直通车单人通票1张（门票+车费）。天津欢乐谷震撼登陆！</a> </h6>
            <a class="recom-worth" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=20"> <span class="Price-font price">165.00</span> <del class="o-price">¥198.00</del> </a> </li>
                    <li> <a class="thumb" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=19"> <img width="220" height="125" src="http://www.o2olive.net/demo/data/upload/shop/groupbuy/887ab39299b77eb6c0dbab1e4cfd9b52.jpg"> </a>
            <h6> <a title="" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=19">仅售1999元！价值8588元的台北摄影套系，赠送中国国旅港澳4天3夜双人游贵宾券，记录</a> </h6>
            <a class="recom-worth" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=19"> <span class="Price-font price">1999.00</span> <del class="o-price">¥8588.00</del> </a> </li>
                    <li> <a class="thumb" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=18"> <img width="220" height="125" src="http://www.o2olive.net/demo/data/upload/shop/groupbuy/0b7e1fe7d9b024b443f09e9a7878c7be.jpg"> </a>
            <h6> <a title="" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=18">仅售70元！价值120元的天津海昌极地海洋世界大学生票1张。</a> </h6>
            <a class="recom-worth" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=18"> <span class="Price-font price">70.00</span> <del class="o-price">¥120.00</del> </a> </li>
                    <li> <a class="thumb" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=17"> <img width="220" height="125" src="http://www.o2olive.net/demo/data/upload/shop/groupbuy/d0fb19c8c8205831e8671ddd6f1875bb.jpg"> </a>
            <h6> <a title="" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=17">仅售198元！价值899元的宝宝写真套系，提供免费WiFi。</a> </h6>
            <a class="recom-worth" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=17"> <span class="Price-font price">198.00</span> <del class="o-price">¥899.00</del> </a> </li>
                  </ul>
              </div>
      <div class="cp_ad mb10"><a href='http://www.shopnc.net' target='_blank' style='cursor:pointer'><img src='http://www.o2olive.net/demo/data/upload/shop/adv/e46690eb8e644a16e3ce16896c50d9e8.png' width='738' height='300'></a></div>
    </div>--> 
      
    </div>
    <div class="aside warp-rightside"> 
      
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
	  <!-- 预约预订 -->
      
<div class="block-line ap-block">
  <div class="booking-catetit02">
    <h4>快速订座</h4>
    <p>提前预订座位，不用排队哦！</p>
  </div>
  <div class="book-select">
    <ul>
      <li class="ap-list" style="z-index:5;">
        <label class="tit03">地点</label>
        <a class="bk-slet bk-place" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22#"><span id="bk-place-span-id">所有地区</span></a>
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
      <li class="ap-list" style="z-index:4;">
        <input type="text" readonly="readonly" value="2014-10-02" id="apt_date" name="apt_date" class="bk-date hasDatepicker">
        <label class="tit03">日期</label>
      </li>
      <li class="ap-list" style="z-index:3;">
        <label class="tit03">时间</label>
        <a class="bk-slet bk-hour" href="javascript:;"><span id="bk-hour-span-id">18:00</span></a>
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
      <li class="ap-list" style="z-index:2;">
        <label class="tit03">人数</label>
        <a class="bk-slet bk-menb" href="javascript:;"> <span id="bk-person-span-id">4人</span> </a>
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
      <li class="ap-list" style="z-index:1;"> <span class="medi-btn"><a href="javascript:quick_appointment();" title="提前订座，不用排队哦！" class="btn-txt">我要订座</a></span> </li>
    </ul>
  </div>
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
      <div id="rightfix" class="">
        <div class="block-line  hot-tuan">
          <div class="block-title mr10"><span>热门团购</span><a href="http://www.o2olive.net/demo/index.php?act=groupbuy" target="_blank" class="more">更多</a></div>
          <ul class="block-list">
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
        <div class="weekly-image">
          <ul class="wi-wrap">
            <a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/8976b37f3e87f0046e1f39ae618d9677.jpg" width="240" height="100"></a>          </ul>
        </div>
      </div>
    </div>
  </div>
</div>
<div id="tbox"> <a style="display:block;" title="返回顶部" href="#pagetop" id="gotop">&nbsp;</a> </div>
<style>
.right_fix {
	position: fixed;
	_position: absolute;
	top: 43px;
	z-index: 2
}
</style>
<script type="text/javascript">
	var RESOURCE_SITE_URL = 'http://www.o2olive.net/demo/data/resource';
</script> 
<script type="text/javascript" src="/resources/js/jquery.edit.js" charset="utf-8"></script> 
<script type="text/javascript" src="/resources/js/common.js" charset="utf-8"></script> 
<script type="text/javascript" src="/resources/js/dialog.js" id="dialog_js" charset="utf-8"></script> 
<script type="text/javascript" src="/resources/js/jquery.ui.js"></script> 
<script type="text/javascript">
	$(function(){
		var time = parseInt("1412236367");
		var lag = parseInt($('.process').attr('endtime')) - time;
		if(lag>0){
		   var second = Math.floor(lag % 60);    
		   var minite = Math.floor((lag / 60) % 60);
		   var hour = Math.floor((lag / 3600) % 24);
		   var day = Math.floor((lag / 3600) / 24);
		   $('.process').html('<span>'+day+'</span>'+'天'+'<span>'+hour+'</span>'+'小时'+'<span>'+minite+"</span>"+'分'+'<span>'+second+'</span>'+'秒');
		}
		function updateEndTime(){
			time++;		
			var lag = parseInt($(".process").attr('endTime')) - time;
			if(lag>0){
			    var second = Math.floor(lag % 60);    
			    var minite = Math.floor((lag / 60) % 60);
			    var hour = Math.floor((lag / 3600) % 24);
			    var day = Math.floor((lag / 3600) / 24);
				$(".process").html('<span>'+day+'</span>'+'天'+'<span>'+hour+'</span>'+'小时'+'<span>'+minite+"</span>"+'分'+'<span>'+second+'</span>'+'秒');
			}else{
			}
			setTimeout(updateEndTime,1000);
		}
		setTimeout(updateEndTime,1000);
		$('#add').click(function(){
			var num = parseInt($('.group-cart').val());
			if(isNaN(num)){
				alert('请填写数字');
				return false;
			}
			var total_num = eval(num+1);
			var limit_num = parseInt($('input[name="limit_num"]').val());
			if(total_num > limit_num){
				alert('请不要超过团购购买上限');
				return false;
			}
			if(total_num > parseInt($('input[name="still_num"]').val())){
				alert('请不要超过团购券库存上限');
				$('.group-cart').val(parseInt($('input[name="still_num"]').val()));
				return false;
			}
			$('.group-cart').val(total_num);
		});
		$('#reduce').click(function(){
			var num	= parseInt($('.group-cart').val());
			if(isNaN(num)){
				alert('请填写数字');
				return false;			
			}
			var total_num = eval(num-1);
			if(total_num<1){
				alert('团购数量不能小于1');
				return false;				
			}
			$('.group-cart').val(total_num);
		});
		$('.addtocart').click(function(){
			var mid = '';
			if(parseInt(mid) > 0){
				var group_id = parseInt($(this).attr("group_id"));
				var num = parseInt($('.group-cart').val());
				$.getJSON("index.php?act=groupbuy&op=put_cart&group_id="+group_id+"&buy_num="+num,function(result){
					if(result.done){
						alert('成功加入购物车！');
						window.location.href = 'index.php?act=groupbuy&op=detail&group_id=22';
					}else{
						alert(result.msg);
					}
				});
			}else{
				ajax_form('login', '登录', 'http://www.o2olive.net/demo/index.php?act=login&op=login_popup','500px');
			}
		});
	});
</script> 
<script type="text/javascript">
var cityName = '';
var address = '南门外大街2-6号中粮大悦城内北区4楼27号(南马路口)';
var store_name = '俏江南';  
var map = "";
var localCity = "";
var opts = {width : 150,height: 50,title : "商铺名称:"+store_name}
function initialize() {
	map = new BMap.Map("container");
	localCity = new BMap.LocalCity();
	
	map.enableScrollWheelZoom(); 
	//map.addControl(new BMap.NavigationControl());  
	//map.addControl(new BMap.ScaleControl());  
	//map.addControl(new BMap.OverviewMapControl()); 
	localCity.get(function(cityResult){
	  if (cityResult) {
	  	var level = cityResult.level;
	  	if (level < 13) level = 13;
	    map.centerAndZoom(cityResult.center, level);
	    cityResultName = cityResult.name;
	    if (cityResultName.indexOf(cityName) >= 0) cityName = cityResult.name;
	    	    	getPoint();
	    	  }
	});
}
 
function loadScript() {
	var script = document.createElement("script");
	script.src = "http://api.map.baidu.com/api?v=1.2&callback=initialize";
	document.body.appendChild(script);
}
function getPoint(){
	var myGeo = new BMap.Geocoder();
	myGeo.getPoint(address, function(point){
	  if (point) {
	    setPoint(point);
	  }
	}, cityName);
}
function setPoint(point){
	  if (point) {
	    map.centerAndZoom(point, 15);
	    var marker = new BMap.Marker(point);
	    var infoWindow = new BMap.InfoWindow("商铺地址:"+address, opts);  
			marker.addEventListener("click", function(){          
			   this.openInfoWindow(infoWindow);  
			});
	    map.addOverlay(marker);
			marker.openInfoWindow(infoWindow);
	  }
}
function add_fav(fav_id,fav_type){
	var mid = '';
	if(parseInt(mid) > 0){
		$.getJSON('index.php?act=store&op=ajax_collect&fav_type='+fav_type+'&fav_id='+fav_id, function(result){
	        if(result.done){
	        	alert('收藏成功！');
	        }else{
	            alert(result.msg);
	        }
	    });
	}else{
		ajax_form('login', '登录', 'http://www.o2olive.net/demo/index.php?act=login&op=login_popup','500px');
	}
}
loadScript();
</script> <div class="clear"></div>
<div id="footer">
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
</div><script src="/resources/js/api"></script><div id="ui-datepicker-div" class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div><script src="/resources/js/getscript"></script></body></html>