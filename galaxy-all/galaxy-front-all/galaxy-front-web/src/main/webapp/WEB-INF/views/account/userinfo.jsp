<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9">

<title>乐朋</title>
<meta name="keywords" content="交友 社交">
<meta name="description" content="乐朋网">
<meta name="author" content="乐朋"> 
<style type="text/css">
.a_selected {background: #e64d5e;}
a {
color:#666;
text-decoration:none;
}

#content .mainbox {
padding: 20px;
border-color: #e8e8e8;
border-left-color: #e8e8e8;
min-height: 687px;
width:707px;
}
.mine {
position: relative;
z-index: 1;
zoom: 1;
}
.cf {
zoom: 1;
}
.mine .filter {
margin-bottom: 10px;
padding: 5px 0 10px;
border-bottom: 1px solid #DCDCDC;
z-index: 5;
}
.mine .filter li {
float: left;
margin: 0 5px 0 0;
font-size: 12px;
list-style: none;
}
.mine .filter a {
display: block;
padding: 1px 3px;
}
.mine .filter .current a {
padding: 1px 7px;
background: #e64d5e;
color: #fff;
border-radius: 3px;
}
.cf:after {
content: '';
display: block;
clear: both;
height: 0;
overflow: hidden;
visibility: hidden;
}
.info-content {
border: 1px solid #eae9e9;
}
.cf {
zoom: 1;
}
.avatar-container {
text-align: center;
padding: 30px 10px 30px 40px;
float: left;
color: #333;
background: #fcfcfc;
}
.avatar-container h3 {
padding-bottom: 10px;
color: #333;
font-size: 12px;
}
.avatar-container img {
vertical-align: top;
border-radius: 3px;
}
.upload-avatar-w {
width: 180px;
margin: 15px auto 0;
overflow: hidden;
}
.btn-normal {
padding-top: 6px;
color: #333;
background-color: #dedede;
border: 1px solid #e3e3e3;
border-bottom: 1px solid #aaa;
filter: progid:DXImageTransform.Microsoft.gradient(gradientType=0, startColorstr='#FFF7F7F7', endColorstr='#FFDEDEDE');
background-size: 100%;
background-image: -moz-linear-gradient(top,#f7f7f7,#dedede);
background-image: -webkit-linear-gradient(top,#f7f7f7,#dedede);
background-image: linear-gradient(to bottom,#f7f7f7,#dedede);
}
.avatar-container .tips {
margin-top: 15px;
text-align: center;
font-size: 12px;
color: #999;
line-height: 18px;
}

.userexinfo-form {
float: left;
width: 410px;
padding-top: 14px;
padding-bottom: 20px;
border: 1px;
}
.userexinfo-form span {
margin-right: 5px;
display: inline-block;
}
 .userexinfo-form__section {
position: relative;
margin: 16px 0;
padding-left: 90px;
color: #555;
height: 24px;
line-height: 24px;
font-size: 12px;
}
.userexinfo-form p {
position: absolute;
top: 0;
left: 0;
width: 90px;
text-align: right;
color: #333;
}
.userexinfo-form label {
margin-left: 5px;
}
.userexinfo-form .btn {
margin-left: 90px;
margin-top: 50px;
_margin-top: 0;
}
.upload-avatar-w .btn-normal {
width: auto!important;
height: auto!important;
}
.btn-fixed {
width: 100px;
letter-spacing: .2em;
overflow: hidden;
text-overflow: ellipsis;
}
.avatar-content-w{position:relative;height:350px}
</style>
<style>
.div1{
padding-left:30px;
float: left;
height: 100%;
width: 100%;
position:relative;
}
.div2{
height: 100%;
width: 100%;
text-align:center;
padding-top:12px;
font-size:16px;
font-weight:800;
border: 1px solid #e3e3e3;
border-bottom: 1px solid #aaa;
}
.inputstyle{
    width: 100%;
    height: 100%;
    cursor: pointer;
    font-size: 30px;
    outline: medium none;
    position: absolute;
    filter:alpha(opacity=0);
    -moz-opacity:0;
    opacity:0; 
    left:0px;
    top: 0px;
}
</style>
</head>
<body id="pagetop">
	 <jsp:include page="../includes/my_header.jsp" />
   
	<div class="warp-index">
		<div class="warp-left" style="border: 10px">
			<div class="mb10">
				<ul class="vip-list" style="border:1px #e64d5e solid; width: 150px" >
					<li>
						<ul>
                            <li class="button " >
                                <a href="#" style="height: 10px;padding-left: 20px;"><strong>我的活动</strong><span></span></a>
                            </li>
                            <li class="left_menu">
                                <ul >
                                    <li><a href="/user/act/published" style="height: 7px;padding-left: 30px;">已发布活动</a></li>
                                    <li><a href="/user/act/joining" style="height: 7px;padding-left:30px;">进行中活动</a></li>
                                    <li><a href="/user/act/joined" style="height: 7px;padding-left: 30px;">已参加活动</a></li>
                                </ul>
                            </li>
                         </ul>
                         <p class="cp-line"></p>
					</li>
					
					<li>
						<ul>
                            <li class="button">
                                <a href="#" style="height: 10px;padding-left: 20px;" ><strong>我的评价</strong><span></span></a>
                            </li>
                            <li class="left_menu">
                                <ul >
                                    <li><a href="/user/act/uncomment" style="height: 7px;padding-left:30px;">待评价</a></li>
                                    <li><a href="/user/act/commented" style="height: 7px;padding-left:30px;">已评价</a></li>
                                </ul>
                            </li>
                         </ul>
                         <p class="cp-line"></p>
					</li>
					
					
					<li>
						<ul>
                            <li class="button">
                                <a href="#" style="height: 10px;padding-left: 20px;" ><strong>我的收藏</strong><span></span></a>
                            </li>
                            <li class="left_menu">
                                <ul>
                                    <li><a href="/user/act/like" style="height: 7px;padding-left:30px;">我的点赞</a></li>
                                    
                                </ul>
                            </li>
                         </ul>
                         <p class="cp-line"></p>
					</li>
					<li>
						<ul>
                            <li class="button">
                                <a href="#" style="height: 10px;padding-left: 20px;" ><strong>抽奖</strong><span></span></a>
                            </li>
                            <li class="left_menu">
                                <ul>
                                    <li><a href="/user/lottery" style="height: 7px;padding-left:30px;">我的抽奖</a></li>
                                    
                                </ul>
                            </li>
                         </ul>
                         <p class="cp-line"></p>
					</li>
					
					<li>
						<ul>
                            <li class="button">
                                <a href="#" style="height: 10px;padding-left: 20px;" ><strong>我的账户</strong><span></span></a>
                            </li>
                            <li class="left_menu">
                                <ul >
                                    <li><a href="/user/card" style="height: 7px;padding-left:30px;">我的名片</a></li>
                                    <li><a href="/user/cardbook" style="height: 7px;padding-left:30px;">我的名片夹</a></li>
                                    <li><a href="/account/credit" style="height: 7px;padding-left:30px;">我的积分</a></li>
                                    <li><a href="/account/coupons" style="height: 7px;padding-left:30px;">抵用券</a></li>
                                     <li><a href="/account/balance" style="height: 7px;padding-left:30px;">账户余额</a></li>
                                    <li class="a_selected"><a href="#" style="height: 7px;padding-left:30px;">账户设置</a></li>
                                    <li><a href="/account/security" style="height: 7px;padding-left:30px;">安全中心</a></li>
                                    
                                </ul>
                            </li>
                         </ul>
                         <p class="cp-line"></p>
					</li>
					
					
				</ul>	
					
			</div>
			
		</div>
		<div class="warp-leftside-index" style="width: auto">
		    
			<div id="content" class="settings-box settings-form-wrapper">
    			<div class="mainbox mine">

      				<ul class="filter cf">
        				<li>
          					<a href="/account/settings">基本信息</a>
        				</li>
        				<li>
          					<!--a href="/account/security" >安全中心</a-->
          					<a href="#" >安全中心</a>
        				</li>
        				<li class="current">
          					<a href="/account/userinfo">个人资料</a>
        				</li>
        				<li>
          					<!--a href="/account/subscription">邮件订阅</a-->
          					<a href="#">邮件订阅</a>
        				</li>
        				<li>
          					<!--a href="/account/setaddress">收货地址</a-->
          					<a href="#">收货地址</a>
        				</li>
      				</ul>
      				<div class="info-content cf" id="yui_3_16_0_1_1416302421614_674">
            			<div class="avatar-container">
                        	<h3>亲爱的zhumengxiaoqi，来上传一张头像吧</h3>
                            <div class="avatar-content">
                    			<img class="J-setted-avatar" src="http://s0.meituan.net/www/img/user-avatar.v9bfc4a71.png" width="180" height="180">
                			</div>
                			<div class="J-upload-avatar-w upload-avatar-w" id="yui_3_16_0_1_1416302421614_275">
                    
                				<div style="width: 110px;height: 35px">
                					<div class="div1">
                							<input type="button" class="div2" value="上传头像" tabindex="0" >
                							<input type="file"  class="inputstyle" accept="image/*">
                					</div>
                				</div>
                			</div>
                			<div class="tips">
                				支持JPG，JPEG，GIF，PNG，BMP，<br>且小于5M
                			</div>
            			</div>
            			<form id="J-userexinfo-form" class="userexinfo-form" method="post" action="/account/userexinfo"><span style="display:none"><input type="hidden" name="csrf" value="X0usUNJi2OcPnzO4mjpX9pSXJP6hsrcCQ-ljIYop3JnSE-lq3aUKdcUzTE6j82rB"></span>
                			<div class="userexinfo-form__section">
                    			<p>性别：</p><span>
                    			<input type="radio" name="gender" id="userexinfo-form-gender-1" value="1" checked="" class="select-radio">
                    			<label for="userexinfo-form-gender-1">男</label></span><span>
                    			<input type="radio" name="gender" id="userexinfo-form-gender-2" value="2" class="select-radio">
                    			<label for="userexinfo-form-gender-2">女</label></span>               
                    	    </div>
                			<div class="userexinfo-form__section">
                    			<p>生日：</p><span>
                    			<select name="year" id="J-userexinfo-birthday-year" class="dropdown--small">
                    				<option>--</option>
                        			<option>2014</option>
                        			<option>2013</option>
                        			<option>2012</option>
                        			<option>2011</option>
                        			<option>2010</option>
                        			<option>2009</option>
                        			<option>2008</option>
                        			<option>2007</option>
                        			<option>2006</option>
                        			<option>2005</option>
                        			<option>2004</option>
                        			<option>2003</option>
                        			<option>2002</option>
                        			<option>2001</option>
                        			<option>2000</option>
                        			<option>1999</option>
                        			<option>1998</option>
                        			<option>1997</option>
                        			<option>1996</option>
                        			<option>1995</option>
                        			<option>1994</option>
                        			<option>1993</option>
                        			<option>1992</option>
                        			<option>1991</option>
                        			<option>1990</option>
                        			<option>1989</option>
                        			<option>1988</option>
                        			<option>1987</option>
                        			<option>1986</option>
                        			<option>1985</option>
                        			<option>1984</option>
                        			<option>1983</option>
                        			<option>1982</option>
                        			<option>1981</option>
                        			<option>1980</option>
                        			<option>1979</option>
                        			<option>1978</option>
                        			<option>1977</option>
                        			<option>1976</option>
                        			<option>1975</option>
                        			<option>1974</option>
                        			<option>1973</option>
                        			<option>1972</option>
                        			<option>1971</option>
                        			<option>1970</option>
                        			<option>1969</option>
                        			<option>1968</option>
                        			<option>1967</option>
                        			<option>1966</option>
                        			<option>1965</option>
                        			<option>1964</option>
                        			<option>1963</option>
                        			<option>1962</option>
                        			<option>1961</option>
                        			<option>1960</option>
                        			<option>1959</option>
                        			<option>1958</option>
                        			<option>1957</option>
                        			<option>1956</option>
                        			<option>1955</option>
                        			<option>1954</option>
                        			<option>1953</option>
                        			<option>1952</option>
                        			<option>1951</option>
                        			<option>1950</option>
                        			<option>1949</option>
                        			<option>1948</option>
                        			<option>1947</option>
                        			<option>1946</option>
                        			<option>1945</option>
                        			<option>1944</option>
                        			<option>1943</option>
                        			<option>1942</option>
                        			<option>1941</option>
                        			<option>1940</option>
                        			<option>1939</option>
                        			<option>1938</option>
                        			<option>1937</option>
                        			<option>1936</option>
                        			<option>1935</option>
                        			<option>1934</option>                    
                        		</select>年</span>
                                <span>
                                <select name="month" id="J-userexinfo-birthday-month" class="dropdown--small">
                                	<option>--</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                    <option>11</option>
                                    <option>12</option>                    
                                 </select>月
                                 </span>
                                 <span>
                                 <select name="day" id="J-userexinfo-birthday-day" data-day="" class="dropdown--small">
                                 	<option>--</option>
                                 </select>日
                                 </span>
                			</div>
                			<div class="userexinfo-form__section">
                    			<p>身份：</p><span>
                    			<input type="radio" name="identity" id="userexinfo-form-identity-1" value="1" class="select-radio">
                    				<label for="userexinfo-form-identity-1">学生</label></span><span>
                    			<input type="radio" name="identity" id="userexinfo-form-identity-2" value="2" class="select-radio">
                    				<label for="userexinfo-form-identity-2">在职</label></span><span>
                    			<input type="radio" name="identity" id="userexinfo-form-identity-3" value="3" class="select-radio">
                    				<label for="userexinfo-form-identity-3">自由职业</label></span><span>
                    			<input type="radio" name="identity" id="userexinfo-form-identity-4" value="4" class="select-radio">
                    				<label for="userexinfo-form-identity-4">其它</label></span>               
                    		</div>
                			<div class="userexinfo-form__section">
                    			<p>个人情况：</p><span>
                    			<input type="radio" name="merriage" id="userexinfo-form-merriage-1" value="1" class="select-radio">
                    			<label for="userexinfo-form-merriage-1">单身</label></span><span>
                    			<input type="radio" name="merriage" id="userexinfo-form-merriage-2" value="2" class="select-radio"><label for="userexinfo-form-merriage-2">恋爱中</label></span><span>
                    			<input type="radio" name="merriage" id="userexinfo-form-merriage-3" value="3" class="select-radio"><label for="userexinfo-form-merriage-3">已婚</label></span><span>
                    			<input type="radio" name="merriage" id="userexinfo-form-merriage-4" value="4" class="select-radio"><label for="userexinfo-form-merriage-4">保密</label></span>                
                    		</div>
                			<div class="userexinfo-form__section">
                    			<p>兴趣：</p><span>
                    			<input type="checkbox" name="interest[]" id="userexinfo-form-interest-1" value="1" class="select-checkbox">
                    			<label for="userexinfo-form-interest-1">美食</label></span><span>
                    			<input type="checkbox" name="interest[]" id="userexinfo-form-interest-6" value="6" class="select-checkbox"><label for="userexinfo-form-interest-6">电影</label></span><span>
                    			<input type="checkbox" name="interest[]" id="userexinfo-form-interest-5" value="5" class="select-checkbox"><label for="userexinfo-form-interest-5">酒店</label></span><span>
                    			<input type="checkbox" name="interest[]" id="userexinfo-form-interest-2" value="2" class="select-checkbox"><label for="userexinfo-form-interest-2">休闲娱乐</label></span><span>
                    			<input type="checkbox" name="interest[]" id="userexinfo-form-interest-4" value="4" class="select-checkbox"><label for="userexinfo-form-interest-4">丽人</label></span><span>
                    			<input type="checkbox" name="interest[]" id="userexinfo-form-interest-9" value="9" class="select-checkbox"><label for="userexinfo-form-interest-9">旅游</label></span><span>
                    			<input type="checkbox" name="interest[]" id="userexinfo-form-interest-7" value="7" class="select-checkbox"><label for="userexinfo-form-interest-7">购物</label></span>                    
                    			<span class="tip">选择你的兴趣使你获得个性化的团购推荐哦</span>
                			</div>
                			<input type="submit" class="btn" value="保存" style="background-color: #e64d5e;">
            			</form>
            		</div>
    			</div>
  		  </div>

		</div>
		
		<div id="tbox">
			<a style="display: block;" title="返回顶部" href="#pagetop" id="gotop">&nbsp;</a>
		</div>

		<div id="footer">
			<div class="footer-box">
				<p>
					<a href="http://www.o2olive.net/demo">首页</a> | <a target="_blank"
						href="http://www.o2olive.net/demo/index.php?act=article&article_id=17">招聘英才</a>
					| <a
						href="http://www.o2olive.net/demo/index.php?act=article&article_id=18">广告合作</a>
					| <a
						href="http://www.o2olive.net/demo/index.php?act=article&article_id=16">联系我们</a>
					| <a
						href="http://www.o2olive.net/demo/index.php?act=article&article_id=15">关于O2OLive</a>
					|&nbsp;<a href="http://www.o2olive.net/demo/index.php?act=slogin">商户登录</a>
				</p>

				Copyright 2007-2014 O2OLive Inc.,All rights reserved.<br>
				Powered by <span class="vol"><font class="b">O2OLive</font></span> <br>
				<br>
			</div>
		</div>
	</div>
	<div id="ui-datepicker-div"
		class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all">
	</div>
	  <script type="text/javascript">
         $(document).ready(function () {
             $('li.button a').click(function (e) {
              var dropDown = $(this).parent().next();
                // $('.left_menu').not(dropDown).slideUp('slow');
                 dropDown.slideToggle('slow');
                 e.preventDefault();
             })
 
         });
</script>
</body>
</html>