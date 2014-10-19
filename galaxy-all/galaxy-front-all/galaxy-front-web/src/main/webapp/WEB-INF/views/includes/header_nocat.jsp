<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9">

<title>乐朋</title>
<meta name="keywords" content="本地生活 美食 娱乐 电影 团购 优惠券 活动">
<meta name="description"
	content="乐朋">
<meta name="author" content="乐朋">
<meta name="copyright" content="LOOKPENG Inc. All Rights Reserved">
<link rel="stylesheet" type="text/css" href="/resources/css/base.css">
<link rel="stylesheet" type="text/css" href="/resources/css/offline.css">
<link rel="stylesheet" type="text/css" href="/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="/resources/css/dialog.css">
<script type="text/javascript" src="/resources/js/jquery.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/resources/js/common.js"
	charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		$('.category').show();
		//首页左侧分类菜单
		$(".category ul.menu").find("li").each(function() {
			$(this).hover(function() {
				var cat_id = $(this).attr("cat_id");
				var menu = $(this).find("div[cat_menu_id='" + cat_id + "']");
				menu.show();
				$(this).addClass("hover");
				if (menu.attr("hover") > 0)
					return;
				menu.masonry({
					itemSelector : 'dl'
				});
				var menu_height = menu.height();
				if (menu_height < 60)
					menu.height(80);
				menu_height = menu.height();
				var li_top = $(this).position().top;
				if ((li_top > 60) && (menu_height >= li_top))
					$(menu).css("top", -li_top + 50);
				if ((li_top > 150) && (menu_height >= li_top))
					$(menu).css("top", -li_top + 90);
				if ((li_top > 240) && (li_top > menu_height))
					$(menu).css("top", menu_height - li_top + 120);
				if (li_top > 300 && (li_top > menu_height))
					$(menu).css("top", 60 - menu_height);
				if ((li_top > 40) && (menu_height <= 120))
					$(menu).css("top", -5);
				menu.attr("hover", 1);
			}, function() {
				$(this).removeClass("hover");
				var cat_id = $(this).attr("cat_id");
				$(this).find("div[cat_menu_id='" + cat_id + "']").hide();
			});
		});
		$('.search_tab')
				.live(
						"click",
						function() {
							var s_url = '';
							if ($(this).attr("op") == 'search_groupbuy') {
								$("input[name=act]").val('groupbuy');
								$("input[name=op]").val('list');
								$("input[name=keyword]").attr('placeholder',
										'输入关键字查找在本地的团购');
								$('.search_tabs')
										.html(
												'<li class="search_tab" op="search_groupbuy">团购</li><li class="search_tab" op="search_store">商家</li><li class="search_tab" op="search_goodsreal">购物</li>');
								s_url = 'index.php?act=groupbuy&op=list&keyword=';
							} else if ($(this).attr("op") == 'search_store') {
								$("input[name=act]").val('index');
								$("input[name=op]").val('list');
								$("input[name=keyword]").attr('placeholder',
										'输入关键字查找在本地的商户');
								$('.search_tabs')
										.html(
												'<li class="search_tab" op="search_store">商家</li><li class="search_tab" op="search_goodsreal">购物</li><li class="search_tab" op="search_groupbuy">团购</li>');
								s_url = 'index.php?act=index&op=list&keyword=';
							} else if ($(this).attr("op") == 'search_goodsreal') {
								$("input[name=act]").val('goodsreal');
								$("input[name=op]").val('list');
								$("input[name=keyword]").attr('placeholder',
										'输入关键字查找在本地的购物');
								$('.search_tabs')
										.html(
												'<li class="search_tab" op="search_goodsreal">购物</li><li class="search_tab" op="search_groupbuy">团购</li><li class="search_tab" op="search_store">商家</li>');
								s_url = 'index.php?act=goodsreal&op=list&keyword=';
							}
							$('.tab').removeClass("tab_over");
							$('.hot_link').each(
									function() {
										$(this).attr("href",
												s_url + $(this).attr("data"));
									});
						});
		$('#SubmitFrom').click(function() {
			$('#search_form').submit();
		});
		$('.del_cart')
				.click(
						function() {
							var cart_id = $(this).attr("cart_id");
							var cart_count = parseInt($('.cart-count').html());
							var new_count = eval(cart_count - 1);
							$
									.getJSON(
											"index.php?act=cart&op=cart_del&cart_id="
													+ cart_id,
											function(data) {
												if (data.done) {
													$('#cart_li_' + cart_id)
															.remove();
													$('.cart-count').html(
															new_count);
													if (new_count == 0) {
														$('.dropdown-cart')
																.append(
																		'<div class="dropdown-menu dropdown-menu-deal dropdown-menu-cart"><p class="dropdown-menu-empty">暂时没有商品</p></div>');
													}
												} else {
													alert(data.msg);
												}
											});
						});
	});

	function AddFavorite(sURL, sTitle) {
		try {
			window.external.addFavorite(sURL, sTitle);
		} catch (e) {
			try {
				window.sidebar.addPanel(sTitle, sURL, "");
			} catch (e) {
				alert('加入收藏失败，请使用Ctrl+D进行添加');
			}
		}
	}

	var SITEURL = 'http://www.lookpeng.com';
	$(function() {
		$(".tab").hover(function() {
			$(this).addClass("tab_over");
		}, function() {
			$(this).removeClass("tab_over");
		});
	});
	$(function() {
		$(".dropdown").hover(function() {
			$(this).addClass("dropdown-open dropdown-open-app");
		}, function() {
			$(this).removeClass("dropdown-open dropdown-open-app");
		});
	});
	$(function() {
		$(".section-main").hover(function() {
			$(this).addClass("nav-drop");
		}, function() {
			$(this).removeClass("nav-drop");
		});
	});
</script>
</head>
<body id="pagetop">
	<div id="topNav" style="z-index: 999; position: relative;">
		<div id="topNav-inner-new" style="width: 1025px;">
			<ul class="topNav-left">
				<shiro:authenticated>
			    <li class="user_info"><span>您好，<shiro:principal property="loginName"/>,欢迎来到乐朋</span> <a
					class="user-info-login" href="/user/logout">[退出]</a></li>
			    </shiro:authenticated>
				<shiro:notAuthenticated>
                <li class="user_info"><span>您好，欢迎来到乐朋</span> <a
					class="user-info-login" href="/user/login">[登录]</a><a
					class="user-info-signup" href="/user/register">[注册]</a></li>
                </shiro:notAuthenticated>
				<li class="line">|</li>
				<li class="mobile-info-item dropdown"><a
					href="javascript:void(0);" class="dropdown-tog"><i
						class="icon-mobile"></i>手机本地生活<i class="tri tri-dropdown"></i></a>
					<div class="dropdown-menu dropdown-menu-app">
						<a target="_blank" href="http://www.o2olive.net/demo/#"
							class="app-block"> <span class="app-block-title">免费下载乐朋手机版</span>
							<span class="app-block-content"> <img
								src="/resources/images/6f4416f017cad0a0a46fee4c7624425d.png"
								width="89px">
						</span> <i class="app-block-arrow"></i>
						</a>
					</div></li>
				<!--<li class="topnav-phone"><a href="">手机客户端</a><em>|</em></li>-->
				<!--    <li class="topnav-add"><a href="index.php?act=memberaccount&op=fav_list" >我的收藏</a><em>|</em></li>-->
				<li class="dcode-box">
					<div class="code-img"></div>
					<div class="login-dcode">
						<h2>扫码下载</h2>
						<div class="lifecode-img">
							<img src="/resources/images/6f4416f017cad0a0a46fee4c7624425d.png"
								width="153px">
						</div>
						<span>（扫码下载乐朋手机版）</span>
					</div>
				</li>
				<!-- <li class="seller-login">
                <a href="index.php?act=slogin">商户登录</a>
              </li>-->
			</ul>
			<ul class="topNav-right">
				<li class="user-orders"><a target="_blank"
					href="/user/myactivity">我的活动</a></li>
				<li class="line">|</li>
				<li class="dropdown dropdown-account"><a
					href="/user/myactivity" class="dropdown-tog"> <span>我的乐朋</span>
						<i class="tri tri-dropdown"></i>
				</a>
					<ul
						class="dropdown-menu dropdown-menu-text dropdown-menu-account account-menu">
						<li><a href="/user/myactivity"
							class="dropdown-menu-item first">我的活动</a></li>
						<li><a href="/user/mydating" class="dropdown-menu-item first">我的约会</a></li>
						<li><a href="/user/mycomments" class="dropdown-menu-item">我的评价</a></li>
						<li><a href="/user/favorites" class="dropdown-menu-item">我的收藏</a></li>
						<li><a href="/user/points" class="dropdown-menu-item">我的积分</a></li>
						<li><a href="/user/lottery" class="dropdown-menu-item">我的抽奖</a></li>
						<li><a href="/user/coupon" class="dropdown-menu-item">优惠券</a></li>
						<li><a href="/account/charge" class="dropdown-menu-item">账户充值</a></li>
						<li><a href="/account/settings" class="dropdown-menu-item">账户设置</a></li>
					</ul></li>
				<li class="line">|</li>
				<li class="dropdown dropdown-cart"><a href="/cart"
					class="dropdown-tog"> <i class="icon icon-cart"></i> <span>购物车<em
							class="badge"><strong class="cart-count">0</strong>件</em></span> <i
						class="tri tri-dropdown"></i> <i class="vertical-bar"></i>
				</a>
					<div class="dropdown-menu dropdown-menu-deal dropdown-menu-cart"
						style="padding: 10px 0;">
						<p class="dropdown-menu-empty">暂时没有商品</p>
					</div></li>
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
				<li class="dropdown dropdown-account"><a href="/organizer"
					class="dropdown-tog"> <span>我是商家</span> <i
						class="tri tri-dropdown"></i>
				</a>
					<ul
						class="dropdown-menu dropdown-menu-text dropdown-menu-account account-s">
						<li><a target="" class="dropdown-menu-item first"
							href="/merchant/login">商家登录</a></li>
						<li><a href="/cooperation" class="dropdown-menu-item">申请合作</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- 导航 -->
	<div id="header">
		<div id="header-bottom">
			<div id="header-bottom-new" style="width: 1025px;">
				<div id="logo">
					<a href="http://www.lookpeng.com"><img
						src="/resources/images/lookpeng3.png"></a>
					<!-- <div class="nc—city-info">
						<h2>@天津</h2>
						<a class="ncchange-city"
							href="http://www.lookpeng.com/city">[城市切换]</a>
					</div> -->
				</div>
				<div id="search-box" style="width: 490px;">
					<form id="search_form" target="_top" method="get"
						action="http://www.o2olive.net/demo/index.php">
						<input type="hidden" value="groupbuy" name="act"> <input
							type="hidden" value="list" name="op">
						<div class="tab">
							<span class="tri"></span>
							<ul class="search_tabs">
								<li class="search_tab" op="search_groupbuy">活动</li>
								<li class="search_tab" op="search_store">约会</li>
								<li class="search_tab" op="search_goodsreal">名人名师</li>
								<li class="search_tab" op="search_goodsreal">问答</li>
								<li class="search_tab" op="search_goodsreal">项目</li>
								<li class="search_tab" op="search_goodsreal">文章</li>

							</ul>
						</div>
						<input type="text" placeholder="输入关键字查找在本地的团购" x-webkit-speech=""
							value="" class="search-box-from" style="width: 310px;"
							data-smartbox="/search/smartboxv2/" autocomplete="off"
							name="keyword" tabindex="1" id=""> <input type="submit"
							data-mod="sr" value="搜  索" hidefocus="true" class="search_button">
					</form>
					<div class="search_hot">
						<div class="search_hot_list">
							<a
								href="http://www.lookpeng.com/search/KTV"
								class="hot_link" data="KTV">KTV</a> <a
								href="http://www.lookpeng.com/search/火锅"
								class="hot_link" data="火锅">火锅</a> <a
								href="http://www.lookpeng.com/search/炸鸡啤酒"
								class="hot_link" data="炸鸡啤酒">炸鸡啤酒</a> <a
								href="http://www.lookpeng.com/search/自助餐"
								class="hot_link" data="自助餐">自助餐</a> <a
								href="http://www.lookpeng.com/search/川菜"
								class="hot_link" data="川菜">川菜</a> <a
								href="http://www.lookpeng.com/search/杀戮地带"
								class="hot_link" data="杀戮地带">杀戮地带</a>
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
					<a href="javascript:void(0);"
						class="commitment-item commitment-item--retire"></a> <a
						href="javascript:void(0);"
						class="commitment-item commitment-item--free"></a> <a
						href="javascript:void(0);"
						class="commitment-item commitment-item--expire"></a>
				</div>
			</div>
		</div>
	</div>
	<div id="main-nav" style="background: #e64d5e;">
		<div id="main-nav-wrap" style="width: 1025px;">
			<div class="section-main sub-nav">
				<a href="http://www.lookpeng.com/#" target="_blank"><span
					class="nc-cates">全部分类</span></a>
				
			</div>
			<ul class="navbar">
				<li><span class="split-line"><a href="/" class="">首页</a></span></li>
				<li><span class="split-line"> <a class="current"
						href="＃">活动</a></span></li>
				<li><span class="split-line"> <a class="" href="＃">约会</a></span></li>
				<li><span class="split-line"> <a class="" href="#">圈子</a></span></li>
				<li><span class="split-line"> <a class="" href="＃">名人名师</a></span></li>
				<li><span class="split-line"> <a class="" href="＃">找场地</a></span></li>
				<li><span class="split-line"> <a class="" href="＃">问答</a></span></li>
				<li><span class="split-line"> <a class="" href="＃">纸上谈兵</a></span></li>
				<li><span class="split-line"> <a class="" href="＃">最佳实践</a></span></li>
				<li><span class="split-line"> <a class="" href="＃">文章</a></span></li>

				<li><span class="split-line"> <a class=""
						target="_blank" href="＃">社区</a></span></li>
			</ul>
		</div>
	</div>
	<script type="text/javascript" src="/resources/js/jquery.js"
		charset="utf-8"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.flexslider-min.js" charset="utf-8"></script>
	<script type="text/javascript" src="/resources/js/jquery.masonry.js"
		charset="utf-8"></script>
	<link rel="stylesheet" type="text/css"
		href="/resources/css/jquery.ui.css">
	<script type="text/javascript" src="/resources/js/jquery.ui.js"></script>
	<script type="text/javascript" src="/resources/js/zh-CN.js"></script>
	<script type="text/javascript"
		src="/resources/js/jquery.SuperSlide.2.1.1.js" charset="utf-8"></script>
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
	color: #999;
	font-size: 12px;
}
</style>
	<script type="text/javascript">
		$(window)
				.load(
						function() {
							$(function() {
								$('.category').show();
								$('#apt_date').datepicker({
									dateFormat : 'yy-mm-dd',
									minDate : '0'
								});
								$(".login-target")
										.click(
												function() {
													var target = $(this)
															.hasClass(
																	"login-target-normal") ? true
															: false;
													$(this)
															.toggleClass(
																	"login-target-normal");
													if (target) {
														$(".login-dcode")
																.addClass(
																		"hide");
														$(".login-nomal")
																.removeClass(
																		"hide")
													} else {
														$(".login-dcode")
																.removeClass(
																		"hide");
														$(".login-nomal")
																.addClass(
																		"hide")
													}
												});
								$('#new_group').mouseover(function() {
									$(this).parent().addClass("on");
									$('#new_store').parent().removeClass("on");
									$('#new_group_show').removeClass("Hide");
									$('#new_store_show').addClass("Hide");
								});
								$('#new_store').mouseover(function() {
									$(this).parent().addClass("on");
									$('#new_group').parent().removeClass("on");
									$('#new_store_show').removeClass("Hide");
									$('#new_group_show').addClass("Hide");
								});
							});
							//首页左侧分类菜单
							$(".category ul.menu")
									.find("li")
									.each(
											function() {
												$(this)
														.hover(
																function() {
																	var cat_id = $(
																			this)
																			.attr(
																					"cat_id");
																	var menu = $(
																			this)
																			.find(
																					"div[cat_menu_id='"
																							+ cat_id
																							+ "']");
																	menu.show();
																	$(this)
																			.addClass(
																					"hover");
																	if (menu
																			.attr("hover") > 0)
																		return;
																	menu
																			.masonry({
																				itemSelector : 'dl'
																			});
																	var menu_height = menu
																			.height();
																	if (menu_height < 60)
																		menu
																				.height(80);
																	menu_height = menu
																			.height();
																	var li_top = $(
																			this)
																			.position().top;
																	if ((li_top > 60)
																			&& (menu_height >= li_top))
																		$(menu)
																				.css(
																						"top",
																						-li_top + 50);
																	if ((li_top > 150)
																			&& (menu_height >= li_top))
																		$(menu)
																				.css(
																						"top",
																						-li_top + 90);
																	if ((li_top > 240)
																			&& (li_top > menu_height))
																		$(menu)
																				.css(
																						"top",
																						menu_height
																								- li_top
																								+ 120);
																	if (li_top > 300
																			&& (li_top > menu_height))
																		$(menu)
																				.css(
																						"top",
																						60 - menu_height);
																	if ((li_top > 40)
																			&& (menu_height <= 120))
																		$(menu)
																				.css(
																						"top",
																						-5);
																	menu
																			.attr(
																					"hover",
																					1);
																},
																function() {
																	$(this)
																			.removeClass(
																					"hover");
																	var cat_id = $(
																			this)
																			.attr(
																					"cat_id");
																	$(this)
																			.find(
																					"div[cat_menu_id='"
																							+ cat_id
																							+ "']")
																			.hide();
																});
											});
							//$('.flexslider').flexslider();

							$('#all-category li').each(function() {
								$(this).hover(function() {
									var nctype = $(this).attr('nc');
									$(this).addClass('list-hover');
									$("div[nc=" + nctype + "]").show();
								}, function() {
									var nctype = $(this).attr('nc');
									$(this).removeClass('list-hover');
									$("div[nc=" + nctype + "]").hide();
								});
							});

							$(".cat-menu").each(function() {
								$(this).hover(function() {
									$(this).show();
								}, function() {
									$(this).hide();
								});
							});

							var morli = $(".areaall li:gt(0)");
							$(morli).hide();
							$(".more_area").click(function() {
								$(this).hide();
								$(".close_area").show();
								$(morli).slideToggle("slow", function() {
								});
							});
							$(".close_area").click(function() {
								$(this).hide();
								$(".more_area").show();
								$(morli).slideToggle("slow", function() {
								});
							});

						});
	</script>
 
		<div id="footer">
			<div class="footer-box">
				<p>
					<a href="http://www.lookpeng.com">首页</a> | <a target="_blank"
						href="http://www.lookpeng.com/hr.html">招聘英才</a>
					| <a
						href="http://www.lookpeng.com/advert.html">广告合作</a>
					| <a
						href="http://www.lookpeng.com/contactus.html">联系我们</a>
					| <a
						href="http://www.lookpeng.com/about.html">关于乐朋</a>
					|&nbsp;<a href="http://www.lookpeng.com/merchant/login">商户登录</a>
				</p>

				Copyright 2007-2014 乐朋 Inc.,All rights reserved.<br>
				Powered by <span class="vol"><font class="b">乐朋</font></span> <br>
				<br>
			</div>
		</div>
	</div>
	<div id="ui-datepicker-div"
		class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>
</body>
</html>