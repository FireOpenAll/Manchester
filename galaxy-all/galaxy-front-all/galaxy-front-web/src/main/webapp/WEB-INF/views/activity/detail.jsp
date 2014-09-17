<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>维依恋2013夏装新款波西米亚印花雪纺半身裙抹胸连衣裙两穿长裙子 - Powered By SHOP++</title>
<meta name="author" content="SHOP++ Team" />
<meta name="copyright" content="SHOP++" />
<meta name="keywords" content="维依恋2013夏装新款波西米亚印花雪纺半身裙抹胸连衣裙两穿长裙子" />
<meta name="description" content="维依恋2013夏装新款波西米亚印花雪纺半身裙抹胸连衣裙两穿长裙子" />
<link href="/resources/css/common.css" rel="stylesheet" type="text/css" />
<link href="/resources/css/product.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/resources/js/jquery.js"></script>
<script type="text/javascript" src="/resources/js/jquery.tools.js"></script>
<script type="text/javascript" src="/resources/js/jquery.jqzoom.js"></script>
<script type="text/javascript" src="/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
<script type="text/javascript">
	$()
			.ready(
					function() {

						var $historyProduct = $("#historyProduct ul");
						var $clearHistoryProduct = $("#clearHistoryProduct");
						var $zoom = $("#zoom");
						var $scrollable = $("#scrollable");
						var $thumbnail = $("#scrollable a");
						var $specification = $("#specification dl");
						var $specificationTitle = $("#specification div");
						var $specificationValue = $("#specification a");
						var $productNotifyForm = $("#productNotifyForm");
						var $productNotify = $("#productNotify");
						var $productNotifyEmail = $("#productNotify input");
						var $addProductNotify = $("#addProductNotify");
						var $quantity = $("#quantity");
						var $increase = $("#increase");
						var $decrease = $("#decrease");
						var $addCart = $("#addCart");
						var $addFavorite = $("#addFavorite");
						var $window = $(window);
						var $bar = $("#bar ul");
						var $introductionTab = $("#introductionTab");
						var $parameterTab = $("#parameterTab");
						var $reviewTab = $("#reviewTab");
						var $consultationTab = $("#consultationTab");
						var $introduction = $("#introduction");
						var $parameter = $("#parameter");
						var $review = $("#review");
						var $addReview = $("#addReview");
						var $consultation = $("#consultation");
						var $addConsultation = $("#addConsultation");
						var barTop = $bar.offset().top;
						var productMap = {};
						productMap[246] = {
							path : null,
							specificationValues : [ "10", "44" ]
						};
						productMap[243] = {
							path : "/product/content/201306/243.html",
							specificationValues : [ "10", "47" ]
						};
						productMap[245] = {
							path : "/product/content/201306/245.html",
							specificationValues : [ "10", "45" ]
						};
						productMap[244] = {
							path : "/product/content/201306/244.html",
							specificationValues : [ "10", "46" ]
						};
						// 锁定规格值
						lockSpecificationValue();

						// 商品图片放大镜
						$zoom.jqzoom({
							zoomWidth : 368,
							zoomHeight : 368,
							title : false,
							showPreload : false,
							preloadImages : false
						});

						// 商品缩略图滚动
						$scrollable.scrollable();

						$thumbnail.hover(function() {
							var $this = $(this);
							if ($this.hasClass("current")) {
								return false;
							} else {
								$thumbnail.removeClass("current");
								$this.addClass("current").click();
							}
						});

						// 规格值选择
						$specificationValue
								.click(function() {
									var $this = $(this);
									if ($this.hasClass("locked")) {
										return false;
									}
									$this.toggleClass("selected").parent()
											.siblings().children("a")
											.removeClass("selected");
									var selectedIds = new Array();
									$specificationValue
											.filter(".selected")
											.each(
													function(i) {
														selectedIds[i] = $(this)
																.attr("val");
													});
									var locked = true;
									$
											.each(
													productMap,
													function(i, product) {
														if (product.specificationValues.length == selectedIds.length
																&& contains(
																		product.specificationValues,
																		selectedIds)) {
															if (product.path != null) {
																location.href = ""
																		+ product.path;
																locked = false;
															}
															return false;
														}
													});
									if (locked) {
										lockSpecificationValue();
									}
									$specificationTitle.hide();
									return false;
								});

						// 锁定规格值
						function lockSpecificationValue() {
							var selectedIds = new Array();
							$specificationValue.filter(".selected").each(
									function(i) {
										selectedIds[i] = $(this).attr("val");
									});
							$specification
									.each(function() {
										var $this = $(this);
										var selectedId = $this.find(
												"a.selected").attr("val");
										var otherIds = $.grep(selectedIds,
												function(n, i) {
													return n != selectedId;
												});
										$this
												.find("a")
												.each(
														function() {
															var $this = $(this);
															otherIds
																	.push($this
																			.attr("val"));
															var locked = true;
															$
																	.each(
																			productMap,
																			function(
																					i,
																					product) {
																				if (contains(
																						product.specificationValues,
																						otherIds)) {
																					locked = false;
																					return false;
																				}
																			});
															if (locked) {
																$this
																		.addClass("locked");
															} else {
																$this
																		.removeClass("locked");
															}
															otherIds.pop();
														});
									});
						}

						// 判断是否包含
						function contains(array, values) {
							var contains = true;
							for (i in values) {
								if ($.inArray(values[i], array) < 0) {
									contains = false;
									break;
								}
							}
							return contains;
						}

						// 到货通知
						$addProductNotify
								.click(function() {
									var specificationValueIds = new Array();
									$specificationValue
											.filter(".selected")
											.each(
													function(i) {
														specificationValueIds[i] = $(
																this).attr(
																"val");
													});
									if (specificationValueIds.length != 2) {
										$specificationTitle.show();
										return false;
									}
									if ($addProductNotify.val() == "到货通知我") {
										$addProductNotify.val("确定登记");
										$productNotify.show();
										$productNotifyEmail.focus();
										if ($.trim($productNotifyEmail.val()) == "") {
											$
													.ajax({
														url : "/product_notify/email.jhtml",
														type : "GET",
														dataType : "json",
														cache : false,
														success : function(data) {
															$productNotifyEmail
																	.val(data.email);
														}
													});
										}
									} else {
										$productNotifyForm.submit();
									}
									return false;
								});

						// 到货通知表单验证
						$productNotifyForm.validate({
							rules : {
								email : {
									required : true,
									email : true
								}
							},
							submitHandler : function(form) {
								$.ajax({
									url : "/product_notify/save.jhtml",
									type : "POST",
									data : {
										productId : 246,
										email : $productNotifyEmail.val()
									},
									dataType : "json",
									cache : false,
									beforeSend : function() {
										$addProductNotify
												.prop("disabled", true);
									},
									success : function(data) {
										if (data.message.type == "success") {
											$addProductNotify.val("到货通知我");
											$productNotify.hide();
										}
										$.message(data.message);
									},
									complete : function() {
										$addProductNotify.prop("disabled",
												false);
									}
								});
							}
						});

						// 购买数量
						$quantity.keypress(function(event) {
							var key = event.keyCode ? event.keyCode
									: event.which;
							if ((key >= 48 && key <= 57) || key == 8) {
								return true;
							} else {
								return false;
							}
						});

						// 增加购买数量
						$increase.click(function() {
							var quantity = $quantity.val();
							if (/^\d*[1-9]\d*$/.test(quantity)) {
								$quantity.val(parseInt(quantity) + 1);
							} else {
								$quantity.val(1);
							}
						});

						// 减少购买数量
						$decrease.click(function() {
							var quantity = $quantity.val();
							if (/^\d*[1-9]\d*$/.test(quantity)
									&& parseInt(quantity) > 1) {
								$quantity.val(parseInt(quantity) - 1);
							} else {
								$quantity.val(1);
							}
						});

						// 加入购物车
						$addCart.click(function() {
							var specificationValueIds = new Array();
							$specificationValue.filter(".selected").each(
									function(i) {
										specificationValueIds[i] = $(this)
												.attr("val");
									});
							if (specificationValueIds.length != 2) {
								$specificationTitle.show();
								return false;
							}
							var quantity = $quantity.val();
							if (/^\d*[1-9]\d*$/.test(quantity)
									&& parseInt(quantity) > 0) {
								$.ajax({
									url : "/cart/add.jhtml",
									type : "POST",
									data : {
										id : 246,
										quantity : quantity
									},
									dataType : "json",
									cache : false,
									success : function(message) {
										$.message(message);
									}
								});
							} else {
								$.message("warn", "购买数量必须为正整数");
							}
						});

						// 添加商品收藏
						$addFavorite.click(function() {
							$.ajax({
								url : "/member/favorite/add.jhtml?id=246",
								type : "POST",
								dataType : "json",
								cache : false,
								success : function(message) {
									$.message(message);
								}
							});
							return false;
						});

						$window
								.scroll(function() {
									var scrollTop = $(this).scrollTop();
									if (scrollTop > barTop) {
										if (window.XMLHttpRequest) {
											$bar.css({
												position : "fixed",
												top : 0
											});
										} else {
											$bar.css({
												top : scrollTop
											});
										}
										var introductionTop = $introduction
												.size() > 0 ? $introduction
												.offset().top - 36 : null;
										var parameterTop = $parameter.size() > 0 ? $parameter
												.offset().top - 36
												: null;
										var reviewTop = $review.size() > 0 ? $review
												.offset().top - 36
												: null;
										var consultationTop = $consultation
												.size() > 0 ? $consultation
												.offset().top - 36 : null;
										if (consultationTop != null
												&& scrollTop >= consultationTop) {
											$bar.find("li").removeClass(
													"current");
											$consultationTab
													.addClass("current");
										} else if (reviewTop != null
												&& scrollTop >= reviewTop) {
											$bar.find("li").removeClass(
													"current");
											$reviewTab.addClass("current");
										} else if (parameterTop != null
												&& scrollTop >= parameterTop) {
											$bar.find("li").removeClass(
													"current");
											$parameterTab.addClass("current");
										} else if (introductionTop != null
												&& scrollTop >= introductionTop) {
											$bar.find("li").removeClass(
													"current");
											$introductionTab
													.addClass("current");
										}
									} else {
										$bar.find("li").removeClass("current");
										$bar.css({
											position : "absolute",
											top : barTop
										});
									}
								});

						// 发表商品评论
						$addReview.click(function() {
							if ($.checkLogin()) {
								return true;
							} else {
								$.redirectLogin("/review/add/246.jhtml",
										"必须登录后才能发表商品评论");
								return false;
							}
						});

						// 发表商品咨询
						$addConsultation.click(function() {
							if ($.checkLogin()) {
								return true;
							} else {
								$.redirectLogin("/consultation/add/246.jhtml",
										"必须登录后才能发表商品咨询");
								return false;
							}
						});

						// 浏览记录
						var historyProduct = getCookie("historyProduct");
						var historyProductIds = historyProduct != null ? historyProduct
								.split(",")
								: new Array();
						for (var i = 0; i < historyProductIds.length; i++) {
							if (historyProductIds[i] == "246") {
								historyProductIds.splice(i, 1);
								break;
							}
						}
						historyProductIds.unshift("246");
						if (historyProductIds.length > 6) {
							historyProductIds.pop();
						}
						addCookie("historyProduct",
								historyProductIds.join(","), {
									path : "/"
								});
						$
								.ajax({
									url : "/product/history.jhtml",
									type : "GET",
									data : {
										ids : historyProductIds
									},
									dataType : "json",
									traditional : true,
									cache : false,
									success : function(data) {
										$
												.each(
														data,
														function(index, product) {
															var thumbnail = product.thumbnail != null ? product.thumbnail
																	: "/upload/image/default_thumbnail.jpg";
															$historyProduct
																	.append('<li><img src="' + thumbnail + '" \/><a href="' + product.path + '">'
																			+ product.name
																			+ '<\/a><span>'
																			+ currency(
																					product.price,
																					true)
																			+ '<\/span><\/li>');
														});
									}
								});

						// 清空浏览记录
						$clearHistoryProduct.click(function() {
							$historyProduct.empty();
							$(this).text("暂无记录");
							removeCookie("historyProduct", {
								path : "/"
							});
						});

						// 点击数
						$.ajax({
							url : "/product/hits/246.jhtml",
							type : "GET"
						});

					});
</script>
</head>
<body>
	<script type="text/javascript">
		$().ready(
				function() {

					var $headerLogin = $("#headerLogin");
					var $headerRegister = $("#headerRegister");
					var $headerUsername = $("#headerUsername");
					var $headerLogout = $("#headerLogout");
					var $productSearchForm = $("#productSearchForm");
					var $keyword = $("#productSearchForm input");
					var defaultKeyword = "商品搜索";

					var username = getCookie("username");
					if (username != null) {
						$headerUsername.text("您好, " + username).show();
						$headerLogout.show();
					} else {
						$headerLogin.show();
						$headerRegister.show();
					}

					$keyword.focus(function() {
						if ($keyword.val() == defaultKeyword) {
							$keyword.val("");
						}
					});

					$keyword.blur(function() {
						if ($keyword.val() == "") {
							$keyword.val(defaultKeyword);
						}
					});

					$productSearchForm.submit(function() {
						if ($.trim($keyword.val()) == ""
								|| $keyword.val() == defaultKeyword) {
							return false;
						}
					});

				});
	</script>
	<div class="container header">
		<div class="span5">
			<div class="logo">
				<a href="/"> <img src="/upload/image/logo.gif" alt="SHOP++商城" />
				</a>
			</div>
		</div>
		<div class="span9">
			<div class="headerAd">
				<img src="http://storage.shopxx.net/demo-image/3.0/ad/header.jpg"
					width="320" height="50" alt="正品保障" title="正品保障" />
			</div>
		</div>
		<div class="span10 last">
			<div class="topNav clearfix">
				<ul>
					<li id="headerLogin" class="headerLogin"><a
						href="/login.jhtml">登录</a>|</li>
					<li id="headerRegister" class="headerRegister"><a
						href="/register.jhtml">注册</a>|</li>
					<li id="headerUsername" class="headerUsername"></li>
					<li id="headerLogout" class="headerLogout"><a
						href="/logout.jhtml">[退出]</a>|</li>
					<li><a href="/admin">管理后台</a> |</li>
					<li><a href="/member/index.jhtml">会员中心</a> |</li>
					<li><a href="/article/list/7.jhtml">关于我们</a></li>
				</ul>
			</div>
			<div class="cart">
				<a href="/cart/list.jhtml">购物车</a>
			</div>
			<div class="phone">
				客服热线: <strong>400-8888888</strong>
			</div>
		</div>
		<div class="search">
			<form id="productSearchForm" action="/product/search.jhtml"
				method="get">
				<input name="keyword" class="keyword" value="商品搜索" maxlength="30">
				<button type="submit">搜索</button>
			</form>
		</div>
		<div class="span24">
			<ul class="mainNav">
				<li><a href="/">首页</a> |</li>
				<li><a href="/product/list/1.jhtml">时尚女装</a> |</li>
				<li><a href="/product/list/2.jhtml">精品男装</a> |</li>
				<li><a href="/product/list/3.jhtml">精致内衣</a> |</li>
				<li><a href="/product/list/4.jhtml">服饰配件</a> |</li>
				<li><a href="/product/list/5.jhtml">时尚女鞋</a> |</li>
				<li><a href="/product/list/6.jhtml">流行男鞋</a> |</li>
				<li><a href="/product/list/9.jhtml">童装童鞋</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="tagWrap">
				<ul class="tag">
					<li class="icon"
						style="background: url(http://storage.shopxx.net/demo-image/3.0/tag/hot.gif) right no-repeat;">
						<a href="/product/list.jhtml?tagIds=1">热销</a>
					</li>
					<li class="icon"
						style="background: url(http://storage.shopxx.net/demo-image/3.0/tag/new.gif) right no-repeat;">
						<a href="/product/list.jhtml?tagIds=2">最新</a>
					</li>
				</ul>
				<div class="hotSearch">
					热门搜索: <a href="/product/search.jhtml?keyword=T%E6%81%A4">T恤</a> <a
						href="/product/search.jhtml?keyword=%E8%A1%AC%E8%A1%AB">衬衫</a> <a
						href="/product/search.jhtml?keyword=%E8%A5%BF%E6%9C%8D">西服</a> <a
						href="/product/search.jhtml?keyword=%E8%A5%BF%E8%A3%A4">西裤</a> <a
						href="/product/search.jhtml?keyword=%E6%A3%AE%E9%A9%AC">森马</a> <a
						href="/product/search.jhtml?keyword=%E4%B8%83%E5%8C%B9%E7%8B%BC">七匹狼</a>
					<a href="/product/search.jhtml?keyword=%E6%A2%B5%E5%B8%8C%E8%94%93">梵希蔓</a>
					<a
						href="/product/search.jhtml?keyword=%E6%98%A5%E5%A4%8F%E6%96%B0%E6%AC%BE">春夏新款</a>
					<a href="/product/search.jhtml?keyword=%E7%89%9B%E4%BB%94%E8%A3%A4">牛仔裤</a>
				</div>
				<div class="search">
					<form id="productSearchForm" action="/product/search.jhtml"
						method="get">
						<input name="keyword" class="keyword" value="商品搜索" maxlength="30" />
						<button type="submit">搜索</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="container productContent">
		<div class="span6">
			<div class="hotProductCategory">
				<dl>
					<dt>
						<a href="/product/list/1.jhtml">时尚女装</a>
					</dt>
					<dd>
						<a href="/product/list/11.jhtml">连衣裙</a>
					</dd>
					<dd>
						<a href="/product/list/12.jhtml">针织衫</a>
					</dd>
					<dd>
						<a href="/product/list/13.jhtml">短外套</a>
					</dd>
					<dd>
						<a href="/product/list/14.jhtml">小西装</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/2.jhtml">精品男装</a>
					</dt>
					<dd>
						<a href="/product/list/21.jhtml">针织衫</a>
					</dd>
					<dd>
						<a href="/product/list/22.jhtml">POLO衫</a>
					</dd>
					<dd>
						<a href="/product/list/23.jhtml">休闲裤</a>
					</dd>
					<dd>
						<a href="/product/list/24.jhtml">牛仔裤</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/3.jhtml">精致内衣</a>
					</dt>
					<dd>
						<a href="/product/list/31.jhtml">女式内裤</a>
					</dd>
					<dd>
						<a href="/product/list/32.jhtml">男式内裤</a>
					</dd>
					<dd>
						<a href="/product/list/33.jhtml">保暖内衣</a>
					</dd>
					<dd>
						<a href="/product/list/34.jhtml">塑身衣</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/4.jhtml">服饰配件</a>
					</dt>
					<dd>
						<a href="/product/list/41.jhtml">女士腰带</a>
					</dd>
					<dd>
						<a href="/product/list/42.jhtml">男士皮带</a>
					</dd>
					<dd>
						<a href="/product/list/43.jhtml">女士围巾</a>
					</dd>
					<dd>
						<a href="/product/list/44.jhtml">男士围巾</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/5.jhtml">时尚女鞋</a>
					</dt>
					<dd>
						<a href="/product/list/51.jhtml">高帮鞋</a>
					</dd>
					<dd>
						<a href="/product/list/52.jhtml">雪地靴</a>
					</dd>
					<dd>
						<a href="/product/list/53.jhtml">中筒靴</a>
					</dd>
					<dd>
						<a href="/product/list/54.jhtml">单鞋</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/6.jhtml">流行男鞋</a>
					</dt>
					<dd>
						<a href="/product/list/59.jhtml">低帮鞋</a>
					</dd>
					<dd>
						<a href="/product/list/60.jhtml">高帮鞋</a>
					</dd>
					<dd>
						<a href="/product/list/61.jhtml">休闲鞋</a>
					</dd>
					<dd>
						<a href="/product/list/62.jhtml">正装鞋</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/7.jhtml">潮流女包</a>
					</dt>
					<dd>
						<a href="/product/list/63.jhtml">单肩包</a>
					</dd>
					<dd>
						<a href="/product/list/64.jhtml">双肩包</a>
					</dd>
					<dd>
						<a href="/product/list/65.jhtml">手提包</a>
					</dd>
					<dd>
						<a href="/product/list/66.jhtml">手拿包</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/8.jhtml">精品男包</a>
					</dt>
					<dd>
						<a href="/product/list/67.jhtml">单肩男</a>
					</dd>
					<dd>
						<a href="/product/list/68.jhtml">双肩包</a>
					</dd>
					<dd>
						<a href="/product/list/69.jhtml">手提包</a>
					</dd>
					<dd>
						<a href="/product/list/70.jhtml">手拿包</a>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="/product/list/9.jhtml">童装童鞋</a>
					</dt>
					<dd>
						<a href="/product/list/71.jhtml">运动鞋</a>
					</dd>
					<dd>
						<a href="/product/list/72.jhtml">牛仔裤</a>
					</dd>
					<dd>
						<a href="/product/list/73.jhtml">套装</a>
					</dd>
					<dd>
						<a href="/product/list/74.jhtml">裤子</a>
					</dd>
				</dl>
				<dl class="last">
					<dt>
						<a href="/product/list/10.jhtml">时尚饰品</a>
					</dt>
					<dd>
						<a href="/product/list/75.jhtml">项链</a>
					</dd>
					<dd>
						<a href="/product/list/76.jhtml">手链</a>
					</dd>
					<dd>
						<a href="/product/list/77.jhtml">戒指</a>
					</dd>
					<dd>
						<a href="/product/list/78.jhtml">耳饰</a>
					</dd>
				</dl>
			</div>
			<div class="hotProduct">
				<div class="title">热销商品</div>
				<ul>
					<li><a href="/product/content/201306/271.html"
						title="唯维欣怡2013春夏季新款波西米亚女装中长款百褶蕾丝雪纺连衣裙子">唯维欣怡2013春夏季新款波西米亚</a>
						<div>
							<div>评分:</div>
							<div class="score10"></div>
							<div>5.0</div>
						</div>
						<div>
							销售价: <strong>￥268.99元</strong>
						</div>
						<div>
							月销量: <em>0</em>
						</div></li>
					<li><a href="/product/content/201306/30.html"
						title="梵希蔓 2013夏装新款女装女裙子长款雪纺百褶连衣裙韩版修身裙子">梵希蔓 2013夏装新款女装女裙子长</a>
						<div>
							<div>评分:</div>
							<div class="score10"></div>
							<div>5.0</div>
						</div>
						<div>
							销售价: <strong>￥308.00元</strong>
						</div>
						<div>
							月销量: <em>0</em>
						</div></li>
					<li><a href="/product/content/201306/246.html"
						title="维依恋2013夏装新款波西米亚印花雪纺半身裙抹胸连衣裙两穿长裙子">维依恋2013夏装新款波西米亚印花</a>
						<div>
							<div>评分:</div>
							<div class="score10"></div>
							<div>5.0</div>
						</div>
						<div>
							销售价: <strong>￥199.00元</strong>
						</div>
						<div>
							月销量: <em>0</em>
						</div></li>
					<li><a href="/product/content/201306/1.html"
						title="尚都比拉2013春夏装新款女装 春款淑女两件套 蕾丝雪纺短袖连衣裙">尚都比拉2013春夏装新款女装 春款</a>
						<div>
							<div>评分:</div>
							<div class="score10"></div>
							<div>5.0</div>
						</div>
						<div>
							销售价: <strong>￥388.00元</strong>
						</div>
						<div>
							月销量: <em>0</em>
						</div></li>
					<li><a href="/product/content/201306/300.html"
						title="尚都比拉女装2013夏装新款蕾丝连衣裙 韩版修身雪纺打底裙子 春款">尚都比拉女装2013夏装新款蕾丝连</a>
						<div>
							销售价: <strong>￥298.00元</strong>
						</div>
						<div>
							月销量: <em>0</em>
						</div></li>
					<li class="last"><a href="/product/content/201306/293.html"
						title="尚都比拉2013夏装新款女装 韩版淑女装 蕾丝雪纺连衣裙 春款短袖">尚都比拉2013夏装新款女装 韩版淑</a>
						<div>
							<div>评分:</div>
							<div class="score10"></div>
							<div>5.0</div>
						</div>
						<div>
							销售价: <strong>￥259.00元</strong>
						</div>
						<div>
							月销量: <em>0</em>
						</div></li>
				</ul>
			</div>
			<div id="historyProduct" class="historyProduct">
				<div class="title">最近浏览过的</div>
				<ul></ul>
				<a href="javascript:;" id="clearHistoryProduct"
					class="clearHistoryProduct">清除历史记录</a>
			</div>
		</div>
		<div class="span18 last">
			<div class="path">
				<ul>
					<li><a href="/">首页</a></li>
					<li><a href="/product/list/1.jhtml">时尚女装</a></li>
					<li><a href="/product/list/11.jhtml">连衣裙</a></li>
				</ul>
			</div>
			<div class="productImage">
				<a id="zoom"
					href="http://storage.shopxx.net/demo-image/3.0/201301/698a395e-ac95-4f76-a3c9-aa4e5fbc9217-large.jpg"
					rel="gallery"> <img class="medium"
					src="http://storage.shopxx.net/demo-image/3.0/201301/698a395e-ac95-4f76-a3c9-aa4e5fbc9217-medium.jpg" />
				</a> <a href="javascript:;" class="prev"></a>
				<div id="scrollable" class="scrollable">
					<div class="items">
						<a class="current" href="javascript:;"
							rel="{gallery: 'gallery', smallimage: 'http://storage.shopxx.net/demo-image/3.0/201301/698a395e-ac95-4f76-a3c9-aa4e5fbc9217-medium.jpg', largeimage: 'http://storage.shopxx.net/demo-image/3.0/201301/698a395e-ac95-4f76-a3c9-aa4e5fbc9217-large.jpg'}"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/698a395e-ac95-4f76-a3c9-aa4e5fbc9217-thumbnail.jpg"
							title="" /></a> <a href="javascript:;"
							rel="{gallery: 'gallery', smallimage: 'http://storage.shopxx.net/demo-image/3.0/201301/8cec40f0-2005-46cf-8d07-6aa32e909e58-medium.jpg', largeimage: 'http://storage.shopxx.net/demo-image/3.0/201301/8cec40f0-2005-46cf-8d07-6aa32e909e58-large.jpg'}"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/8cec40f0-2005-46cf-8d07-6aa32e909e58-thumbnail.jpg"
							title="" /></a> <a href="javascript:;"
							rel="{gallery: 'gallery', smallimage: 'http://storage.shopxx.net/demo-image/3.0/201301/59e5f31b-f940-4256-9bc0-5cd9e7c52fa9-medium.jpg', largeimage: 'http://storage.shopxx.net/demo-image/3.0/201301/59e5f31b-f940-4256-9bc0-5cd9e7c52fa9-large.jpg'}"><img
							src="http://storage.shopxx.net/demo-image/3.0/201301/59e5f31b-f940-4256-9bc0-5cd9e7c52fa9-thumbnail.jpg"
							title="" /></a>
					</div>
				</div>
				<a href="javascript:;" class="next"></a>
			</div>
			<div class="name">维依恋2013夏装新款波西米亚印花雪纺半身裙抹胸连衣裙两穿长裙子</div>
			<div class="sn">
				<div>编号: 201304343</div>
				<div>评分:</div>
				<div class="score10"></div>
				<div>5.0 (评分数: 2)</div>
			</div>

			<div class="info">
				<dl>
					<dt>销售价:</dt>
					<dd>
						<strong>￥199.00</strong> 市场价:
						<del>￥238.80</del>
					</dd>
				</dl>
				<dl>
					<dt>活动组织者:</dt>
					<dd>
						&nbsp;小华 开始时间: <span>￥238.80</span>
					</dd>
				</dl>
				<dl>
					<dt>开始时间:</dt>
					<dd>
						&nbsp;2012-07-08 结束时间: <span>&nbsp;2012-09-08</span>
					</dd>
				</dl>
				<dl>
					<dt>促销:</dt>
					<dd>
						<a href="/promotion/content/1.jhtml" target="_blank"
							title="2013-06-13 ~ 2015-01-01">限时抢购</a>
					</dd>
				</dl>
				<dl>
					<dt>赠送积分:</dt>
					<dd>
						<span>199</span>
					</dd>
				</dl>
			</div>
			<div class="action">
				<div id="specification" class="specification clearfix">
					<div class="title">请选择商品规格</div>
					<dl>
						<dt>
							<span title="颜色">颜色:</span>
						</dt>
						<dd>
							<a href="javascript:;" class="image selected" val="10"><img
								src="http://storage.shopxx.net/demo-image/3.0/specification/10.gif"
								alt="混色" title="混色" /><span title="点击取消选择">&nbsp;</span></a>
						</dd>
					</dl>
					<dl>
						<dt>
							<span title="尺码">尺码:</span>
						</dt>
						<dd>
							<a href="javascript:;" class="text selected" val="44">S<span
								title="点击取消选择">&nbsp;</span></a>
						</dd>
						<dd>
							<a href="javascript:;" class="text" val="45">M<span
								title="点击取消选择">&nbsp;</span></a>
						</dd>
						<dd>
							<a href="javascript:;" class="text" val="46">L<span
								title="点击取消选择">&nbsp;</span></a>
						</dd>
						<dd>
							<a href="javascript:;" class="text" val="47">XL<span
								title="点击取消选择">&nbsp;</span></a>
						</dd>
					</dl>
				</div>
				<dl class="quantity">
					<dt>购买数量:</dt>
					<dd>
						<input type="text" id="quantity" name="quantity" value="1"
							maxlength="4" onpaste="return false;" />
						<div>
							<span id="increase" class="increase">&nbsp;</span> <span
								id="decrease" class="decrease">&nbsp;</span>
						</div>
					</dd>
					<dd>件</dd>
				</dl>
				<div class="buy">
					<input type="button" id="addCart" class="addCart" value="加入购物车" />
					<a href="javascript:;" id="addFavorite">收藏商品</a>
				</div>
			</div>
			<div id="bar" class="bar">
				<ul>
					<li id="introductionTab"><a href="#introduction">活动介绍</a></li>
					<li id="parameterTab"><a href="#parameter">活动地址</a></li>
					<li id="reviewTab"><a href="#review">活动评论</a></li>
					<li id="consultationTab"><a href="#consultation">联系信息</a></li>
				</ul>
			</div>
			<table class="brief">
				<tr>
					<th>裙型</th>
					<td><span title="百褶裙">百褶裙</span></td>
					<th>风格</th>
					<td><span title="通勤">通勤</span></td>
					<th>裙长</th>
					<td><span title="长裙">长裙</span></td>
				</tr>
				<tr>
					<th>主材质</th>
					<td><span title="聚酯纤维">聚酯纤维</span></td>
					<th>袖长</th>
					<td><span title="无袖">无袖</span></td>
					<th>款式</th>
					<td><span title="长款">长款</span></td>
				</tr>
			</table>
			<div id="introduction" name="introduction" class="introduction">
				<div class="title">
					<strong>商品介绍</strong>
				</div>
				<div>
					<img
						src="http://storage.shopxx.net/demo-image/3.0/201301/a8f9e986-cfba-4fb9-8f3f-f4f08c4f163b.jpg" />
				</div>
			</div>
			<div id="parameter" name="parameter" class="parameter">
				<div class="title">
					<strong>商品参数</strong>
				</div>
				<table>
					<tr>
						<th class="group" colspan="2">基本参数</th>
					</tr>
					<tr>
						<th>风格</th>
						<td>通勤</td>
					</tr>
					<tr>
						<th>通勤</th>
						<td>韩版</td>
					</tr>
					<tr>
						<th>裙长</th>
						<td>长裙</td>
					</tr>
					<tr>
						<th>款式</th>
						<td>长款</td>
					</tr>
					<tr>
						<th>袖长</th>
						<td>无袖</td>
					</tr>
					<tr>
						<th>裙型</th>
						<td>百褶裙</td>
					</tr>
					<tr>
						<th>图案</th>
						<td>花色</td>
					</tr>
					<tr>
						<th>流行元素/工艺</th>
						<td>流苏 荷叶边 褶皱</td>
					</tr>
					<tr>
						<th>材质</th>
						<td>雪纺</td>
					</tr>
					<tr>
						<th>主成份含量</th>
						<td>81%-90%</td>
					</tr>
					<tr>
						<th>主材质</th>
						<td>聚酯纤维</td>
					</tr>
				</table>
			</div>
			<div id="review" name="review" class="review">
				<div class="title">商品评论</div>
				<div class="content clearfix">
					<div class="score">
						<strong>5.0</strong>
						<div>
							<div class="score10"></div>
							<div>评分数: 2</div>
						</div>
					</div>
					<div class="graph">
						<span style="width: 100.0%"> <em>5.0</em>
						</span>
						<div>&nbsp;</div>
						<ul>
							<li>非常不满</li>
							<li>不满意</li>
							<li>一般</li>
							<li>满意</li>
							<li>非常满意</li>
						</ul>
					</div>
					<div class="handle">
						<a href="/review/add/246.jhtml" id="addReview">发表商品评论</a>
					</div>
					<table>
						<tr>
							<th>面料材质很清爽，穿着挺舒服的，大小尺寸跟描述中的也一样，好评！
								<div class="score10"></div>
							</th>
							<td>test <span title="2013-06-13 01:52:41">2013-06-13</span>
							</td>
						</tr>
						<tr>
							<th>质量不错，真的很棒。发货&amp;快递速度都很ok。 买得开心，用得舒心，下次还来哦！
								<div class="score10"></div>
							</th>
							<td>test <span title="2013-06-13 01:52:40">2013-06-13</span>
							</td>
						</tr>
					</table>
					<p>
						<a href="/review/content/246.jhtml">[查看所有评论]</a>
					</p>
				</div>
			</div>
			<div id="consultation" name="consultation" class="consultation">
				<div class="title">商品咨询</div>
				<div class="content">
					<p>
						暂无商品咨询信息 <a href="/consultation/add/246.jhtml"
							id="addConsultation">[发表商品咨询]</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="http://storage.shopxx.net/demo-image/3.0/ad/footer.jpg"
					width="950" height="52" alt="我们的优势" title="我们的优势" />
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a href="#">关于我们</a> |</li>
				<li><a href="#">联系我们</a> |</li>
				<li><a href="#">诚聘英才</a> |</li>
				<li><a href="#">法律声明</a> |</li>
				<li><a href="/friend_link.jhtml">友情链接</a> |</li>
				<li><a href="/article/list/4.jhtml" target="_blank">支付方式</a> |
				</li>
				<li><a href="/article/list/5.jhtml" target="_blank">配送方式</a> |
				</li>
				<li><a href="http://www.shopxx.net">SHOP++官网</a> |</li>
				<li><a href="http://bbs.shopxx.net">SHOP++论坛</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright © 2005-2013 SHOP++商城 版权所有</div>
		</div>
		<script charset="utf-8" type="text/javascript"
			src="http://wpa.b.qq.com/cgi/wpa.php?key=XzkzODAzMTQyM180MzkzMV80MDAwMDA3NDc3Xw"></script>
	</div>
</body>
</html>