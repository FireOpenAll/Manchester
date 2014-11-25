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
li {
      list-style:none;
}
.li_title_a {
 height: 10px;padding-left: 20px;
}
.a_selected {background: #e64d5e;}
.my_a{
height: 15px;
}
.cp-line {
	width: 100%;
	height: 0.5px;
	border-bottom: 0.5px dotted #e6e6e6;
}
.timeNode{float:left; display:inline; position:relative; width:707px; padding:25px; }
.nodeL{float:left; display:inline; width:100px; margin-right:27px; }
.logo{float:left; position:relative; display:inline; width:100px; height:100px; margin-right:27px; overflow:hidden; }
.nodeR{float:left; display:inline; width:580px; }
.info{float:left; display:inline; position:relative; height:20px; line-height:20px; font-size:14px; color:#666; }
.title{height:40px; margin-bottom:15px; font-size:18px; line-height:20px; overflow:hidden; margin-left: 20px}
.area{padding-left:20px; width:560px; margin-bottom:5px; }
.time{padding-left:20px; width:560px; margin:0px 0px 10px 0px; }
.logo span{float:left; display:inline; position:relative; margin-left:50%; height:100px; }
.logo img{float:left; position:relative; left:-50%; height:100px; }
.info span.icon{position:absolute; left:0px; top:2px; width:16px; height:16px; background-image:url("http://www.huodongshu.com/html/images/icon03.png"); }
.state{float:left; width:100%; height:32px; margin-top:10px; text-align:center; line-height:32px; font-size:14px; }
</style>


</head>
<body id="pagetop">
	 <jsp:include page="../../includes/my_header.jsp" />
   
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
                                    <li ><a href="/user/act/published" style="height: 7px;padding-left: 30px;">已发布活动 </a></li>
                                    <li class="a_selected"><a href="/user/act/joinjing" style="height: 7px;padding-left:30px;">进行中活动</a></li>
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
                                    <li><a href="/account/settings" style="height: 7px;padding-left:30px;">账户设置</a></li>
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
		    
		    <c:choose>
		    	<c:when test="${not empty list}">
		    		
		    		<c:forEach var="item" items="${list}">
		    			<div class="timeNode">
							<div class="nodeL">                                            
				     			<div class="logo">
				         			<span><img src="http://www.huodongshu.com/html/h5/data/event/event_logo/7.jpg"></span>
				     			</div>                                            
		         			</div>
		         			<div class="nodeR">                                       
		             			<div class="info title">
		                  			<a href="http://www.huodongshu.com/event/10001357/?is_easy=2" class="font_0097e0" style="color: #000000"><strong><c:out value="${item['title']}"></c:out></strong></a>
		             			</div>                                      
                     			<div class="info area">
                          			<span class="icon"></span> <c:out value="${item['address']}"></c:out>
                     			</div>                                       
                     			<div class="info time">
                          			<span class="icon"></span>
                          			<fmt:formatDate value="${item['start']}" type="both" pattern="yyyy年MM月dd日 HH:mm:ss"/> ~ <fmt:formatDate value="${item['end']}" type="both" pattern="yyyy年MM月dd日 HH:mm:ss"/>
                     			</div>                                        
                  			</div>
						</div>
						<p class="cp-line"></p>
						<hr>
		    		</c:forEach>
		    	</c:when>
		    	<c:otherwise>
		    		<h1 style="align: center;">你没有正在参加的活动</h1>
		    	</c:otherwise>
		    </c:choose>

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