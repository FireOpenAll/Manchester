<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!-- saved from url=(0067)http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword= -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9">

<title>乐朋</title>
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
</head>
<body id="pagetop">
<div id="topNav" style="z-index:999;position:relative;">
  <div id="topNav-inner-new" style="width:990px;">
    <ul class="topNav-left">
            <li class="user_info"> <span>您好，欢迎来到O2OLive系统演示站</span> <a class="user-info-login" href="http://www.o2olive.net/demo/index.php?act=login">[登录]</a><a class="user-info-signup" href="http://www.o2olive.net/demo/index.php?act=login&op=register">[注册]</a> </li>
                  <li class="line">|</li>
      <li class="mobile-info-item dropdown"> <a href="javascript:void(0);" class="dropdown-tog"><i class="icon-mobile"></i>手机本地生活<i class="tri tri-dropdown"></i></a>
        <div class="dropdown-menu dropdown-menu-app"> <a target="_blank" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword=#" class="app-block"> <span class="app-block-title">免费下载O2OLive手机版</span> <span class="app-block-content"> <img src="/resources/images/6f4416f017cad0a0a46fee4c7624425d.png" width="89px"> </span> <i class="app-block-arrow"></i> </a> </div>
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
      <li class="dropdown dropdown-account"> <a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword=#" class="dropdown-tog"> <span>我是商家</span> <i class="tri tri-dropdown"></i> </a>
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
                            <li class="search_tab" op="search_groupbuy">团购</li>
              <li class="search_tab" op="search_store">商家</li>
              <li class="search_tab" op="search_goodsreal">购物</li>
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
    <div class="section-main sub-nav"> <a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword=#" target="_blank"><span class="nc-cates">全部分类<i class="arrow"></i></span></a>
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
      <li><span class="split-line"><a href="http://www.o2olive.net/demo" class="">首页</a></span></li>
                        <li><span class="split-line"> <a class="current" href="http://www.o2olive.net/demo/index.php?act=groupbuy">团购</a></span></li>
                        <li><span class="split-line"> <a class="" href="http://www.o2olive.net/demo/index.php?act=coupon&op=list">找优惠</a></span></li>
                        <li><span class="split-line"> <a class="" href="http://www.o2olive.net/demo/index.php?act=card">会员卡</a></span></li>
                        <li><span class="split-line"> <a class="" href="http://www.o2olive.net/demo/index.php?act=appointment">订座</a></span></li>
                        <li><span class="split-line"> <a class="" href="http://www.o2olive.net/demo/index.php?act=gift">积分商城</a></span></li>
                        <li><span class="split-line"> <a class="" href="http://www.o2olive.net/demo/index.php?act=goodsreal&op=grindex">购物</a></span></li>
                        <li><span class="split-line"> <a class="" target="_blank" href="http://www.o2olive.net/demo/circle">社区</a></span></li>
                                                                      </ul>
  </div>
</div>
<link rel="stylesheet" type="text/css" href="/resources/css/jquery.ui.css">
<script type="text/javascript" src="/resources/js/jquery.ui.js"></script>
<script type="text/javascript" src="/resources/js/zh-CN.js"></script>
<script type="text/javascript">
$(function(){
	$('#apt_date').datepicker({dateFormat: 'yy-mm-dd',minDate:'0'});
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
<div class="life_body">
  <div id="main-wrap">
    <!--面包屑<div class="sitenav">
      <h2>当前位置：</h2>
      <a href="http://www.o2olive.net/demo">首页</a>&nbsp;&gt;&nbsp;团购 </div>-->
    <!-- query -->
    <div class="main-local">
      <div class="list_nav"> <i class="hot-tit"></i> <span class="tit">热门：</span>
        <ul class="list" id="J_list">
          <li class="current"><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=&class_id_1=&city_id=1&area_id=&mall_id=&price_min=&price_max=">全部</a></li>
                                        <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword=%E6%9D%80%E6%88%AE%E5%9C%B0%E5%B8%A6&class_id=&class_id_1=&city_id=1&area_id=&mall_id=&price_min=&price_max=">杀戮地带</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword=%E6%B8%A9%E6%B3%89&class_id=&class_id_1=&city_id=1&area_id=&mall_id=&price_min=&price_max=">温泉</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword=%E7%83%A7%E7%83%A4&class_id=&class_id_1=&city_id=1&area_id=&mall_id=&price_min=&price_max=">烧烤</a></li>
                  </ul>
      </div>
      <div class="dotted-line"></div>
      <div class="list_nav"> <i class="class-tit"></i> <span class="tit">分类：</span>
                <ul id="J_list" class="list">
          <li class="current"><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&city_id=1&area_id=&mall_id=&keyword=&price_min=&price_max=">全部</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=1&city_id=1&area_id=&mall_id=&keyword=&price_min=&price_max=">餐饮美食</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=5&city_id=1&area_id=&mall_id=&keyword=&price_min=&price_max=">酒店</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=9&city_id=1&area_id=&mall_id=&keyword=&price_min=&price_max=">休闲娱乐</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=13&city_id=1&area_id=&mall_id=&keyword=&price_min=&price_max=">旅游</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=17&city_id=1&area_id=&mall_id=&keyword=&price_min=&price_max=">生活服务</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=21&city_id=1&area_id=&mall_id=&keyword=&price_min=&price_max=">丽人</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=25&city_id=1&area_id=&mall_id=&keyword=&price_min=&price_max=">家装</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=33&city_id=1&area_id=&mall_id=&keyword=&price_min=&price_max=">抽奖</a></li>
                  </ul>
                      </div>
      <div class="dotted-line"></div>
      <div class="list_nav"> <i class="go-tit"></i> <span class="tit">商圈：</span>
                <ul id="J_list" class="list">
          <li class="current"><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=&class_id_1=&keyword=&price_min=&price_max=">全部</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&city_id=1&area_id=3&class_id=&class_id_1=&keyword=&price_min=&price_max=">南开区</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&city_id=1&area_id=5&class_id=&class_id_1=&keyword=&price_min=&price_max=">和平区</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&city_id=1&area_id=314&class_id=&class_id_1=&keyword=&price_min=&price_max=">河西区</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&city_id=1&area_id=315&class_id=&class_id_1=&keyword=&price_min=&price_max=">河东区</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&city_id=1&area_id=317&class_id=&class_id_1=&keyword=&price_min=&price_max=">河北区</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&city_id=1&area_id=318&class_id=&class_id_1=&keyword=&price_min=&price_max=">红桥区</a></li>
                    <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&city_id=1&area_id=319&class_id=&class_id_1=&keyword=&price_min=&price_max=">滨海新区</a></li>
                  </ul>
                      </div>
      <div class="dotted-line"></div>
      <div class="list_nav"> <i class="price-tit"></i> <span class="tit">价格：</span>
        <ul class="list" id="J_list">
          <li class="current"><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=&class_id_1=&city_id=1&area_id=&mall_id=&keyword=">全部</a></li>
                                                            <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=&class_id_1=&city_id=1&area_id=&mall_id=&keyword=&price_min=&price_max=50">50元以下</a></li>
                                                  <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=&class_id_1=&city_id=1&area_id=&mall_id=&keyword=&price_min=100&price_max=300">100元-300元</a></li>
                                                            <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&class_id=&class_id_1=&city_id=1&area_id=&mall_id=&keyword=&price_min=400&price_max=500">400元-500元</a></li>
                                                                                <li class=""><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&class_id=&class_id_1=&city_id=1&area_id=&mall_id=&keyword=&price_min=1000&price_max=">1000元以上</a></li>
                            </ul>
      </div>
    </div>
    <div class="sort_box">
      <div class="button_box"> 
	      <a class="sort2" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&city_id=1&area_id=&mall_id=&class_id=&class_id_1=&keyword=&price_min=&price_max=" title="默认排序">默认排序</a>
	      <a class="sort1" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&city_id=1&area_id=&mall_id=&class_id=&class_id_1=&orderby=buyer_num&sort=asc&keyword=&price_min=&price_max=" title="销售量">销售量<i class="bottom_img"></i></a> 
	      <a class="sort1" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&city_id=1&area_id=&mall_id=&class_id=&class_id_1=&orderby=end_time&sort=asc&keyword=&price_min=&price_max=" title="有效期">有效期<i class="bottom_img"></i></a> 
	      <a class="sort1" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&city_id=1&area_id=&mall_id=&class_id=&class_id_1=&orderby=group_price&sort=asc&keyword=&price_min=&price_max=" title="价格">价格<i class="top_img"></i></a> 
      </div>
    </div>
    <div class="mainbox">
      <div class="layout_left02 clearfix">

        <!-- query end -->
        <div class="group-bd">
                    <ul>
                        <li class="mb20 ml12"> <a class="gif-pic" href="/activity/detail/1231.html"> <img src="/resources/images/81b840a6906bd6e28d2563a9f84456fd.jpg"> </a>
            <h3><a href="/activity/detail/1231.html"><span class="group-tit">俏江南</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=23">仅售198元！最高价值726元的俏江南2人自选套餐，提供免费WiFi。</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">198.00</span> <span>门店价<del class="snum">￥726</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=23">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">3</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1694620800"></p>
                <p class="num fr"><span>3</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22"> <img src="/resources/images/0eb1ccc3dbae8d94ea32a73986979f08.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22"><span class="group-tit">俏江南</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22">仅售468元！最高价值1436元的俏江南北京17店468元6人自选套餐，提供免费WiFi。</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">468.00</span> <span>门店价<del class="snum">￥1436</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=22">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">4</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1663171200"></p>
                <p class="num fr"><span>4</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=21"> <img src="/resources/images/014c72c2919337bd265b9afcc7435c60.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=21"><span class="group-tit">天津欢乐谷</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=21">仅售396元！价值550元的天津欢乐谷年卡兑换卡1张。畅玩四季欢乐主题公园，让欢乐陪伴您每一天。</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">170.00</span> <span>门店价<del class="snum">￥230</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=21">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">0</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1451491200"></p>
                <p class="num fr"><span>0</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=20"> <img src="/resources/images/4923a8db49e624dba0230e5a1c654021.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=20"><span class="group-tit">天津欢乐谷</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=20">仅售165元！价值198元的天津欢乐谷直通车单人通票1张（门票+车费）。天津欢乐谷震撼登陆！</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">165.00</span> <span>门店价<del class="snum">￥198</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=20">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">21</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1441382400"></p>
                <p class="num fr"><span>21</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=19"> <img src="/resources/images/887ab39299b77eb6c0dbab1e4cfd9b52.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=19"><span class="group-tit">伊莎诺曼婚纱摄影</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=19">仅售1999元！价值8588元的台北摄影套系，赠送中国国旅港澳4天3夜双人游贵宾券，记录</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">1999.00</span> <span>门店价<del class="snum">￥8588</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=19">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">4</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1629820800"></p>
                <p class="num fr"><span>4</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=18"> <img src="/resources/images/0b7e1fe7d9b024b443f09e9a7878c7be.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=18"><span class="group-tit">天津海昌极地海洋世界</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=18">仅售70元！价值120元的天津海昌极地海洋世界大学生票1张。</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">70.00</span> <span>门店价<del class="snum">￥120</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=18">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">5</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1535126400"></p>
                <p class="num fr"><span>5</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=17"> <img src="/resources/images/d0fb19c8c8205831e8671ddd6f1875bb.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=17"><span class="group-tit">伊莎诺曼婚纱摄影</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=17">仅售198元！价值899元的宝宝写真套系，提供免费WiFi。</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">198.00</span> <span>门店价<del class="snum">￥899</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=17">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">0</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1692892800"></p>
                <p class="num fr"><span>0</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=16"> <img src="/resources/images/53444106de6e8cbecc3125e05432cec1.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=16"><span class="group-tit">伊莎诺曼婚纱摄影</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=16">仅售299元！价值899元的个性写真套系1套。</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">299.00</span> <span>门店价<del class="snum">￥899</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=16">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">1</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1692979200"></p>
                <p class="num fr"><span>1</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=15"> <img src="/resources/images/59b21289d5f768f730834f27ace40714.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=15"><span class="group-tit">天津海昌极地海洋世界</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=15">仅售140元！价值160元的津海昌极海洋世界成人票1个。天津海昌极地海洋世界——浓缩极地世界，尽展海</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">140.00</span> <span>门店价<del class="snum">￥160</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=15">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">7</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1483027200"></p>
                <p class="num fr"><span>7</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=14"> <img src="/resources/images/6db5dfd2fdb0065f144541fbeb585d9d.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=14"><span class="group-tit">巴古造型</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=14">仅售328元！价值1744元的烫发大礼包一套，男女不限，发长不限。巴古造型强势来袭！</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">328.00</span> <span>门店价<del class="snum">￥1744</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=14">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">1</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1661356800"></p>
                <p class="num fr"><span>1</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=13"> <img src="/resources/images/a1d3f65702d02aaa67337c484fedf1dc.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=13"><span class="group-tit">巴古造型</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=13">仅售59元！最高价值260元的巴古造型美甲店精致美甲1次，男女不限，提供免费WiFi。</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">59.00</span> <span>门店价<del class="snum">￥260</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=13">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">0</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1691510400"></p>
                <p class="num fr"><span>0</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=12"> <img src="/resources/images/bdf87393d93084880a81c0823d4f9ee1.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=12"><span class="group-tit">如家快捷酒店</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=12">仅售158元！价值358元的如家快捷酒店入住1晚（单人间/双人间2选1），美可叠加使用，免费赠送双</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">150.00</span> <span>门店价<del class="snum">￥358</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=12">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">2</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1504281600"></p>
                <p class="num fr"><span>2</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=11"> <img src="/resources/images/e96aca9657dbd71d4245a47be0214698.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=11"><span class="group-tit">麦田量贩式KTV</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=11">大家爱K歌！仅售78元！价值311元的麦田量贩式KTV黄金档欢唱套餐，欢迎光临。</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">78.00</span> <span>门店价<del class="snum">￥311</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=11">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">4</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1692806400"></p>
                <p class="num fr"><span>4</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=10"> <img src="/resources/images/50b8c54a40a71b2c91680fabdd1b29c3.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=10"><span class="group-tit">麦田量贩式KTV</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=10">大家爱K歌！仅售58元！价值248元的麦田量贩式KTV夜猫档套餐，欢迎光临。</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">58.00</span> <span>门店价<del class="snum">￥248</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=10">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">0</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1628697600"></p>
                <p class="num fr"><span>0</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=9"> <img src="/resources/images/71da7974cc2844e0310db6682be76d2f.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=9"><span class="group-tit">如家快捷酒店</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=9">【意大利风情区/火车站】 如家快捷酒店</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">129.00</span> <span>门店价<del class="snum">￥199</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=9">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">5</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1535731200"></p>
                <p class="num fr"><span>5</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=8"> <img src="/resources/images/bcfbaca2dfa1b728b9b4469f770b6a23.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=8"><span class="group-tit">如家快捷酒店</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=8">【40店通用】 如家快捷酒店/莫泰连锁酒店</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">129.00</span> <span>门店价<del class="snum">￥229</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=8">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">4</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1504195200"></p>
                <p class="num fr"><span>4</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=7"> <img src="/resources/images/e6e1c2eb8e51d393f449cb1b5b8e7cd3.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=7"><span class="group-tit">麦田量贩式KTV</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=7">大家爱K歌！仅售35元，最高价值204元的麦田量贩式KTV周一至周五13:00-19:00任选3小时</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">35.00</span> <span>门店价<del class="snum">￥204</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=7">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">3</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1692720000"></p>
                <p class="num fr"><span>3</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=6"> <img src="/resources/images/2f926eaba7fb3f012be260abb39b6c6f.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=6"><span class="group-tit">巴古造型</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=6">仅售199元！最高价值1050元的洗剪吹+烫染二选一</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">199.00</span> <span>门店价<del class="snum">￥1050</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=6">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">1</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1660752000"></p>
                <p class="num fr"><span>1</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=5"> <img src="/resources/images/b04e08f62b8a9afc6a8f6979da8300d6.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=5"><span class="group-tit">PANKOO釜山料理（大悦城店）</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=5">仅售199元！最高价值281元的3-4人分享餐3选1，限时限量抢购，节假日通用，可累计，15店通用！</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">199.00</span> <span>门店价<del class="snum">￥281</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=5">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">31</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1446134400"></p>
                <p class="num fr"><span>31</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=4"> <img src="/resources/images/79f8c8474e7fa5657bc8f21f2cab3fa6.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=4"><span class="group-tit">麻辣诱惑</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=4">仅售80元！价值100元的代金券1张，除酒水饮料外全场通用，可叠加使用。</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">80.00</span> <span>门店价<del class="snum">￥100</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=4">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">2</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1535644800"></p>
                <p class="num fr"><span>2</span>人已团购</p>
              </div>-->
            </li>
                        <li class="mb20 ml12"> <a class="gif-pic" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=3"> <img src="/resources/images/b7913acdd14f22ea735b5fcebbade460.jpg"> </a>
            <h3><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=3"><span class="group-tit">韩古风</span></a></h3>


            <h4><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=3">【滨江道】 韩古风韩式自助烧烤</a></h4>

              <div class="price">
                <div class="pr-f"><em>￥</em><span class="dnum fs1">40.00</span> <span>门店价<del class="snum">￥50</del></span> </div>
                <!--团购按钮<a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=3">
               <div class="btn"></div>
                </a>-->
              </div>
              <div class="deal-tile">
              <p class="extra-inner"><span class="sales">已售<strong class="num">6</strong></span></p>
              </div>
              <!--<div class="group-ft">
                <p class="time fl process" endtime="1440691200"></p>
                <p class="num fr"><span>6</span>人已团购</p>
              </div>-->
            </li>
                      </ul>
                  </div>
        <div class="page_box"><ul><li><span>首页</span></li><li><span>上一页</span></li><li><span class="currentpage">1</span></li><li><span>下一页</span></li><li><span>末页</span></li></ul></div>
      </div>

      <!--侧栏<div class="hot-group clearfix mb10">
          <div class="hot-group-hd">
            <h2>热门团购</h2>
            <a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list">更多团购&gt;&gt;</a> </div>
                    <ul class="recom-ul">
                        <li> <a class="thumb" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=20"> <img width="220" height="125" src="http://www.o2olive.net/demo/data/upload/shop/groupbuy/4923a8db49e624dba0230e5a1c654021.jpg"> </a>
              <h6> <a title="" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=20">仅售165元！价值198元的天津欢乐谷直通车单人通票1张（门票+车费）。天津欢乐谷震撼登陆！</a> </h6>
              <div class="recom-worth"> <span class="Price-font price">¥165.00</span>市场价&nbsp;<del>¥198.00</del> </div> </li>
                        <li> <a class="thumb" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=19"> <img width="220" height="125" src="http://www.o2olive.net/demo/data/upload/shop/groupbuy/887ab39299b77eb6c0dbab1e4cfd9b52.jpg"> </a>
              <h6> <a title="" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=19">仅售1999元！价值8588元的台北摄影套系，赠送中国国旅港澳4天3夜双人游贵宾券，记录</a> </h6>
              <div class="recom-worth"> <span class="Price-font price">¥1999.00</span>市场价&nbsp;<del>¥8588.00</del> </div> </li>
                        <li> <a class="thumb" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=18"> <img width="220" height="125" src="http://www.o2olive.net/demo/data/upload/shop/groupbuy/0b7e1fe7d9b024b443f09e9a7878c7be.jpg"> </a>
              <h6> <a title="" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=18">仅售70元！价值120元的天津海昌极地海洋世界大学生票1张。</a> </h6>
              <div class="recom-worth"> <span class="Price-font price">¥70.00</span>市场价&nbsp;<del>¥120.00</del> </div> </li>
                        <li> <a class="thumb" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=17"> <img width="220" height="125" src="http://www.o2olive.net/demo/data/upload/shop/groupbuy/d0fb19c8c8205831e8671ddd6f1875bb.jpg"> </a>
              <h6> <a title="" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=17">仅售198元！价值899元的宝宝写真套系，提供免费WiFi。</a> </h6>
              <div class="recom-worth"> <span class="Price-font price">¥198.00</span>市场价&nbsp;<del>¥899.00</del> </div> </li>
                      </ul>
                  </div>-->
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
        <a class="bk-slet bk-place" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword=#"><span id="bk-place-span-id">所有地区</span></a>
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
        <div class="block-line  hot-tuan">
    <div class="block-title mr10"><span>热门团购</span><a href="http://www.o2olive.net/demo/index.php?act=groupbuy" target="_blank" class="more">更多</a></div>
    <ul class="block-list">
                  <li><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=5">
        <div class="image"> <img width="117" height="73" src="/resources/images/b04e08f62b8a9afc6a8f6979da8300d6.jpg" alt="仅售199元！最高价值281元的3-4人分享餐3选1，限时限量抢购，节假日通用，可累计，15店通用！"> </div>
        <div class="text">
          <h4>仅售199元！最高价值281元的3-4人分享餐3选1，限时限量抢购，节假日通用，可累计，15店通用！</h4>
          <p>PANKOO釜山料理（大悦城店）</p>
          <span class="price"> <em>¥199</em> <del>¥281</del> </span> </div>
        </a></li>
             <li><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=20">
        <div class="image"> <img width="117" height="73" src="/resources/images/4923a8db49e624dba0230e5a1c654021.jpg" alt="仅售165元！价值198元的天津欢乐谷直通车单人通票1张（门票+车费）。天津欢乐谷震撼登陆！"> </div>
        <div class="text">
          <h4>仅售165元！价值198元的天津欢乐谷直通车单人通票1张（门票+车费）。天津欢乐谷震撼登陆！</h4>
          <p>天津欢乐谷</p>
          <span class="price"> <em>¥165</em> <del>¥198</del> </span> </div>
        </a></li>
             <li><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=4">
        <div class="image"> <img width="117" height="73" src="/resources/images/79f8c8474e7fa5657bc8f21f2cab3fa6.jpg" alt="仅售80元！价值100元的代金券1张，除酒水饮料外全场通用，可叠加使用。"> </div>
        <div class="text">
          <h4>仅售80元！价值100元的代金券1张，除酒水饮料外全场通用，可叠加使用。</h4>
          <p>麻辣诱惑</p>
          <span class="price"> <em>¥80</em> <del>¥100</del> </span> </div>
        </a></li>
             <li><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=19">
        <div class="image"> <img width="117" height="73" src="/resources/images/887ab39299b77eb6c0dbab1e4cfd9b52.jpg" alt="仅售1999元！价值8588元的台北摄影套系，赠送中国国旅港澳4天3夜双人游贵宾券，记录"> </div>
        <div class="text">
          <h4>仅售1999元！价值8588元的台北摄影套系，赠送中国国旅港澳4天3夜双人游贵宾券，记录</h4>
          <p>伊莎诺曼婚纱摄影</p>
          <span class="price"> <em>¥1999</em> <del>¥8588</del> </span> </div>
        </a></li>
             <li><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=9">
        <div class="image"> <img width="117" height="73" src="/resources/images/71da7974cc2844e0310db6682be76d2f.jpg" alt="【意大利风情区/火车站】 如家快捷酒店"> </div>
        <div class="text">
          <h4>【意大利风情区/火车站】 如家快捷酒店</h4>
          <p>如家快捷酒店</p>
          <span class="price"> <em>¥129</em> <del>¥199</del> </span> </div>
        </a></li>
             <li><a href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=detail&group_id=3">
        <div class="image"> <img width="117" height="73" src="/resources/images/b7913acdd14f22ea735b5fcebbade460.jpg" alt="【滨江道】 韩古风韩式自助烧烤"> </div>
        <div class="text">
          <h4>【滨江道】 韩古风韩式自助烧烤</h4>
          <p>韩古风</p>
          <span class="price"> <em>¥40</em> <del>¥50</del> </span> </div>
        </a></li>
           </ul>
  </div>
        <div class="block-line hot-info" style="padding-bottom:15px;">
    <div class="block-title mb10"><span>热门店铺</span><a href="http://www.o2olive.net/demo/index.php?act=index&op=list" target="_blank" class="more">更多</a></div>
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
            <div class="pic"> <a href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=7" target="_blank"> <img src="/resources/images/4845cf92233e3b4bcecd24538e3b3402.jpg" alt="如家快捷酒店"> </a> </div>
            <div class="txt">
              <h4> <a title="如家快捷酒店" href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=7" target="_blank">如家快捷酒店</a> </h4>
              <p><span title="" class="item-rank-rst irr-star5"></span></p>
            </div>
          </li>
                    <li>
            <div class="pic"> <a href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=2" target="_blank"> <img src="/resources/images/225f955726361c84a257963f35ebbf58.jpg" alt="韩古风"> </a> </div>
            <div class="txt">
              <h4> <a title="韩古风" href="http://www.o2olive.net/demo/index.php?act=store&op=detail&id=2" target="_blank">韩古风</a> </h4>
              <p><span title="" class="item-rank-rst irr-star4"></span></p>
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
            <a href="http://www.shopnc.net/" target="_blank" style="cursor:pointer"><img src="/resources/images/678a6bd252b591f87c171e2df0c4ca14.jpg" width="240" height="100"></a>          </ul>
        </div>
      </div>
      <!-- 广告位<div class="cp_ad mb10"><a href='http://www.shopnc.net' target='_blank' style='cursor:pointer'><img src='http://www.o2olive.net/demo/data/upload/shop/adv/0b955b753a28e7cfef10c880bf5e5de0.png' width='738' height='300'></a></div>-->

    </div>
  </div>
</div>
<div id="tbox">
        <a style="display:block;" title="返回顶部" href="http://www.o2olive.net/demo/index.php?act=groupbuy&op=list&keyword=#pagetop" id="gotop">&nbsp;</a>
</div>
<script type="text/javascript">
	$(function(){
		var time = parseInt("1412233728");
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
</script>
<div class="clear"></div>
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
<div id="ui-datepicker-div" class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div></body></html>