<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0055)http://www.o2olive.net/demo/index.php?act=memberaccount -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>基本资料_O2OLive系统演示站</title>
<link href="/resources/css/member.css" rel="stylesheet" type="text/css"> 
<script type="text/javascript" src="/resources/js/jquery.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/js/jquery.ui.js"></script>
<script type="text/javascript" src="/resources/js/zh-CN.js"></script>
<script type="text/javascript" src="/resources/js/common_register.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/js/zh-CN.js"></script> 

<link href="/resources/css/member_show.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
$(function(){
	$(".quick-menu li").hover(function() {
		$(this).addClass("active");
	},
	function() {
		$(this).removeClass("active");
	});
});
</script>
</head>
<body>
<div id="public_top">
  <div class="public_topnav">
    <div class="topnav_bd">
    <a href="http://www.o2olive.net/demo">
          <img src="/resources/images/1e4dc058fa0500fdf63bf97c63603c10.png">
          </a>
     <div class="quick-menu">
        <li class="drop_wrap"> <a class="item2" href="javascript:;">testtest<i></i></a>
            <ul id="sub-menu">
              <li class="sm1"><a href="http://www.o2olive.net/demo/index.php?act=membershow&mid=195">个人主页</a></li>
              <li class="sm1"><a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=account">基本资料</a></li>
              <li class="sm1"><a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=accountinfo">账号信息</a></li>
              <li class="sm1"><a href="http://www.o2olive.net/demo/index.php?act=memberorder&op=list">团购订单</a></li>
              <li class="sm1"><a href="http://www.o2olive.net/demo/index.php?act=membercoupon&op=list">优惠券管理</a></li>
              <li class="sm1"><a href="http://www.o2olive.net/demo/index.php?act=login&op=logout">退出登录</a></li>
            </ul>
          </li>
        <li><a class="item" href="">手机客户端</a></li>
          <li class="drop_wrap"> <a class="item2" href="http://www.o2olive.net/demo">本地生活网<i></i></a>
            <ul id="sub-menu">
              <li class="sm1"><a href="http://www.o2olive.net/demo/index.php?act=coupon&op=list">优惠券</a></li>
              <li class="sm1"><a href="http://www.o2olive.net/demo/index.php?act=groupbuy">团购</a></li>
              <li class="sm1"><a href="http://www.o2olive.net/demo/index.php?act=card">会员卡</a></li>
              <li class="sm1"><a href="http://www.o2olive.net/demo/index.php?act=appointment">预约</a></li>
              <li class="sm1"><a href="http://www.o2olive.net/demo/circle/" target="_blank">社区</a></li>
            </ul>
          </li>
        
      </div>
    </div>
  </div>
  <div class="public_top_shadow"><span class="b"></span></div>
</div>
<div id="container">
  <div class="layout clearfix">
    <div class="sidebar">
      <div class="side_nav">
        <div class="hd">

        <a class="sh_img" target="_blank" href="http://www.o2olive.net/demo/index.php?act=membershow&mid=195">
          <img class="avatar" alt="个人头像" src="/resources/images/avatar_photo.png">
        </a>
        <span class="username">testtest</span>
        </div>
        <div class="con">
          <ul>
            <li class="active">
              <h2><a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=account"><i class="icon01"></i><!--个人资料-->我的账户</a></h2>
              <div class="nav">
              <a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=account" class="cur">基本资料</a>
              <a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=detail" class="">详细信息</a>
              <a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=avatar" class="">个人头像</a>
              <a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=address" class="">收货地址</a>
              <a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=accountinfo" class="">帐号信息</a>
              <a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=bind" class="">帐号绑定</a>
              </div>
            </li>
             <li class="">
              <h2><a href="http://www.o2olive.net/demo/index.php?act=memberorder&op=list"><i class="icon05"></i>消费管理</a></h2>
             <div class="nav">
             <a href="http://www.o2olive.net/demo/index.php?act=memberorder&op=list" class="">团购订单</a>
             <a href="http://www.o2olive.net/demo/index.php?act=memberorder&op=grlist" class="">购物订单</a>
             <a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=comment" class="">评论管理</a>
             <a href="http://www.o2olive.net/demo/index.php?act=membercoupon&op=list" class="">优惠券管理</a>


             <a href="http://www.o2olive.net/demo/index.php?act=memberappointment&op=list" class="">预约管理</a>

             <a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=card_list" class="">我的会员卡</a>
             <a href="http://www.o2olive.net/demo/index.php?act=memberpredeposit&op=list" class="">预存款管理</a>
             <a href="http://www.o2olive.net/demo/index.php?act=memberpredeposit&op=log" class="">预存款明细</a>
			 <a href="http://www.o2olive.net/demo/index.php?act=memberorder&op=refund" class=""><i class="icon05"></i>我的退款</a>
             </div>
             </li>
              <li class="" style="border-bottom:none;">
              <h2><a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=fav_list"><i class="icon08"></i>特色功能</a></h2>
             <div class="nav">
             <a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=fav_list" class="">我的收藏</a>

             <a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=groupbuyremind" class="">团购提醒</a>

             <a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=giftorder" class="">积分兑换</a>

             <a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=scorelog" class="">我的积分</a>

             <a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=memberactivity" class="">我的活动</a>
             </div>
              </li>


          </ul>
        </div>
      </div>
    </div>
    <div class="main-box">
      <div class="mainbox setup_box">
<div class="hd">
  <h3>基本资料</h3>
  <span>(<i class="c1">*</i>必须填写项)</span></div>
<div class="con">
  <p class="con_hints">请填写您的基本资料</p>
  <div class="form_box">
	<form id="basic_info" method="post" action="http://www.o2olive.net/demo/index.php?act=memberaccount&op=account" novalidate="novalidate">
	  <ul>
	  	<li>
		  <div class="tit">
			<label>头像：</label>
		  </div>
		  <div class="pt">
			<a href="http://www.o2olive.net/demo/index.php?act=memberaccount&op=avatar"><img width="64" height="64" class="avatar" alt="个人头像" src="/resources/images/avatar_photo.png"></a>
		  </div>
		</li>
		<li>
		  <div class="tit">
			<label>用户名：</label>
		  </div>
		  <div class="pt">
			<label>testtest&nbsp;&nbsp;<font style="color:red;">(用户名用于系统登录，昵称是用户在网站的别名)</font></label>
		  </div>
		</li>
		<li>
		  <div class="tit"><i class="c1">*</i>
			<label>昵称：</label>
		  </div>
		  <div class="pt">
			<input type="text" value="testtest" id="nickname" maxlength="24" class="input_plain c2 focus" name="nickname">&nbsp;&nbsp;<span style="line-height:30px; height:30px;">(昵称不能超过24个字符)</span>
			<label for="nickname" class="error msg_invalid" style="display:none;"></label>
		  </div>
		</li>
		<li>
		  <div class="tit">
			<label>性别：</label>
		  </div>
		  <div class="pt fi">
			<select name="gender" class="city-select">
				<option value="0" selected="">保密</option>
				<option value="1">男</option>
				<option value="2">女</option>
			</select>
		  </div>
		</li>
		<!-- 
		<li>
		  <div class="tit"><i class="c1">*</i>
			<label for="">常居地：</label>
		  </div>
		  <div class="pt">
		    <select name="first_letter" class="city-select">
		    			    	<option value="A" >A</option>
		    			    	<option value="B" >B</option>
		    			    	<option value="C" >C</option>
		    			    	<option value="D" >D</option>
		    			    	<option value="E" >E</option>
		    			    	<option value="F" >F</option>
		    			    	<option value="G" >G</option>
		    			    	<option value="H" >H</option>
		    			    	<option value="I" >I</option>
		    			    	<option value="J" >J</option>
		    			    	<option value="K" >K</option>
		    			    	<option value="L" >L</option>
		    			    	<option value="M" >M</option>
		    			    	<option value="N" >N</option>
		    			    	<option value="O" >O</option>
		    			    	<option value="P" >P</option>
		    			    	<option value="Q" >Q</option>
		    			    	<option value="R" >R</option>
		    			    	<option value="S" >S</option>
		    			    	<option value="T" >T</option>
		    			    	<option value="U" >U</option>
		    			    	<option value="V" >V</option>
		    			    	<option value="W" >W</option>
		    			    	<option value="X" >X</option>
		    			    	<option value="Y" >Y</option>
		    			    	<option value="Z" >Z</option>
		    			    </select>
		  	<select name='usercity' class="city-select">
		  				  	</select>
			<label for='usercity' class='error msg_invalid' style='display:none;'></label>
		  </div>
		</li> -->
		<li>
		  <div class="tit">
			<label for="">自我介绍：</label>
		  </div>
		  <div class="pt">
			<textarea id="J_sign" class="tp c2" rows="5" cols="" name="introduce" maxlength="200" style="overflow:auto"></textarea>&nbsp;&nbsp;(自我介绍不能超过200个字符)
			<label for="introduce" class="error msg_invalid" style="display:none;"></label>
		  </div>
		</li>
	  </ul>
	  <div class="btn_box"> <span class="f_btn">
		<button type="submit" class="btn_txt J_submit">保存</button>
		</span> </div>
	</form>
  </div>
</div>
</div>
<script type="text/javascript">
	$(function(){
		$('select[name="first_letter"]').change(function(){
			var letter	=	$(this).val();
			$.getJSON('index.php?act=login&op=ajax_getcity&letter='+letter, function(result){
		        if(result.done){
			        $('select[name="usercity"]').html('');
		        	for(var i=0,l=result.data.length;i<l;i++){
		        		$('select[name="usercity"]').append('<option value="'+result.data[i]['area_id']+'">'+result.data[i]['area_name']+'</option>');
		        	}
		        }else{
		            alert('获取城市列表失败');
		        }
		    });
		});
		$('#basic_info').validate({
			errorPlacement: function(error, element){
			   var error_td = element.parent('div');
				error_td.append(error);
			},
			submitHandler:function(form){
				ajaxpost('basic_info', '', '', 'onerror');
			},
			rules:{
				nickname:{
					required:true
				}
			},
			messages:{
				nickname:{
					required:'昵称不能为空'
				}
			}
		});
	});
</script>    </div>
  </div>
</div>
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


</body></html>