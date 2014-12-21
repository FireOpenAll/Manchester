<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1.0,  user-scalable=no" >
	<!-- Bootstrap CSS -->
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap-theme.min.css">

 <link href="/resources/bootstrap/css/jumbotron-narrow.css" rel="stylesheet">

<!-- <script src="http://cdn.bootcss.com/jquery/1.9.1/jquery.min.js"></script> -->
<script src="/resources/bootstrap/js/jquery.min.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>


<script src="/resources/bootstrap/js/unslider.min.js"></script>

<script src="/resources/bootstrap/js/jquery.event.move.js"></script>
<!--支持触摸屏-->
<script src="/resources/bootstrap/js/jquery.event.swipe.js"></script>

<script src="/resources/bootstrap/js/unslider.min.js"></script>

<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/style.css">
</head>
<body>
  <div class="banner">
		    <ul>
		        <li style="background-image: url('http://www.ququan8.com/UpLoadFile/2010-8-18/279495682816648.jpg');">
		        	<div class="inner">
						<h1>Fluid, flexible, fantastically minimal.</h1>
						<p>Use any HTML in your slides, extend with CSS. You have full control.</p>

						<a class="btn" href="#download">下载</a>
					</div>
		        </li>
		        <li style="background-image: url('http://e.hiphotos.baidu.com/image/pic/item/79f0f736afc3793186edd82ce9c4b74543a91129.jpg');">
		        		<div class="inner">
						<h1>Fluid, flexible, fantastically minimal.</h1>
						<p>Use any HTML in your slides, extend with CSS. You have full control.</p>

						<a class="btn" href="#download">下载</a>
					</div>

		        </li>
		        <li style="background-image: url('http://h.hiphotos.baidu.com/image/pic/item/c9fcc3cec3fdfc03cdf2bdbdd63f8794a4c22628.jpg');">
		        	<div class="inner">
						<h1>Fluid, flexible, fantastically minimal.</h1>
						<p>Use any HTML in your slides, extend with CSS. You have full control.</p>

						<a class="btn" href="#download">下载</a>
					</div>
		        </li>
		    </ul>
		</div>
			<br>



			<nav class="navbar navbar-default navbar-fixed-top panel-danger" role="navigation">
			    	<div class="navbar-header ">
				      <a class="navbar-brand" href="#">
				        <span class="glyphicon glyphicon-home"></span>
				      </a>
				       <a class="navbar-brand pull-right" href="#">
				        <span class="glyphicon glyphicon-share"></span>
				      </a>
				    </div>

			</nav>


		<div class="row">
			<ul class="list-group">
			  <li class="list-group-item list-group-item-default">
			  	<i class="glyphicon glyphicon-share"></i>北京朝阳区报名后告知地点
			  </li>
			  <li class="list-group-item list-group-item-default">
			  	<i class="glyphicon glyphicon-time"></i>2014-12-5 10:30 － 2014-12-10 10:30
			  </li>
			  <li class="list-group-item list-group-item-default">
			  	<i class="glyphicon glyphicon-phone"></i>	13521782226
			  	<a href="tel:13521782226"><button type="button" class="btn btn-xs btn-info">拨打</button></a>
			  </li>
			</ul>
		</div>
		<div class="row">
			<div class="panel panel-info">
			 <div ></div>
			  <div class="panel-heading">
			    <h3 class="panel-title">活动简介</h3>
			  </div>
			  <div class="panel-body">
			    活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介
			    活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介活动简介
			  </div>
			</div>
			<div class="panel panel-info">
			  <div class="panel-heading">
			    <h3 class="panel-title">活动主办方</h3>
			  </div>
			  <div class="panel-body">
			   北京市文化传媒有限公司
			  </div>
			</div>
			<div class="panel panel-info">
			  <div class="panel-heading">
			    <h3 class="panel-title">如何参加</h3>
			  </div>
			  <div class="panel-body">
			    如何参加如何参加如何参加如何参加如何参加如何参加如何参加如何参加如何参加如何参加如何参加如何参加如何参加
			    如何参加如何参加如何参加如何参加如何参加如何参加如何参加如何参加如何参加如何参加如何参加如何参加如何参加
			  </div>
			</div>
		</div>
		
		<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
		  <button type="button" class="btn btn-large btn-block btn-danger">报名</button>
		</nav>




		<script type="text/javascript">

		if(window.chrome) {
				$('.banner li').css('background-size', '100% 100%');
			}

			$(function() {
			    $('.banner').unslider({

			    	arrows: true,
					fluid: true,
					dots: true
			    });
			});
		</script>
</body>
</html>
