$(function(){
	var template_header = '<div class="global_head" >\
	    <div class="inner">\
	    <div class="logo" onclick="window.location.href=\'/\';"><img src="/resources/activity/images/logo.gif" width="210" height="75" alt="活动树" /></div>\
	    <div class="nav">\
	        <ul>\
	            <li id="id_li_event" ><a href="#">创建活动</a></li>\
	            <li id="id_li_myevent"  ><a href="#">我的活动</a></li>\
	            <li id="id_li_account"  ><a href="#">我的帐户</a></li>\
	        </ul>\
	    </div>\
	    <div class="login"><span id="huodongshu_welcome_span"> </span><a id="huodongshu_login" href="javascript:to_login_page();" class="font_0097e0">登录</a><span class="line">|</span><a id="huodongshu_register" href="/html/register.html" class="font_0097e0">注册</a><a href="javascript:huodongshu_user_logout();" id="huodongshu_logout" class="font_0097e0" style="display:none;">退出</a></div>\
	</div>\
	</div>';
	var flag = getQueryString('flag');
	if(  ((flag == 'field') ||(flag == 'field_admin')) && get_current_urlname() == 'login.html'){
		
	}else{
		$(".global_head").replaceWith(template_header);
		getcustheader();
	}
	
});




$(function(){
	var global_footer = '<div class="global_footer">\
	    <div class="inner">\
	<dl>\
	    <a href="/"><dt></dt></a>\
	    <dd class="font_gray"><a href="/html/fun_intro.html">功能介绍</a> | <a href="/html/service_agreement.html">服务协议</a> | <a href="/html/know.html">知识产权</a>  | <a href="/html/about_us.html">联系我们</a> | <a href="/html/feedback.html">意见反馈</a></dd>\
	    <dd class="font_gray">Copyright©2014 gapatry.com.cn 京ICP备 xxxxxxx号-1</dt>\
	</dl>\
	<div class="phone"></div>\
	<div class="clear"></div>\
	</div>\
	</div>';
	
	var fromto =  getQueryString("fromto");
	if( window.location.host == 'm.huodongshu.com' || window.location.host =='112.124.102.145'  || 'phoneapp' == fromto){
		
	}else{
		var flag = getQueryString('flag');
		if(  ((flag == 'field') ||(flag == 'field_admin')) && get_current_urlname() == 'login.html'){
		}else{
			if($("body div.global_width").length == 1){
				$("body div.global_width").append('<div class="clear"></div>');
			}
			$("body").append(global_footer);
		}
		
	}
	
});

//场地头部
$(function(){
	var template_field_header =  '<div class="global_head">\
	    <div class="headTop">\
	    <div class="headInner">\
	        <ul class="site">\
	            <li class="line"><a href="http://www.huodongshu.com/html/index.html"><span class="icon01a"></span>活动树</a></li>\
	            <li><a href="http://hotel.huodongshu.com/hotel/speciallist.html"><span class="icon02b"></span>场地</a></li>\
	        </ul>\
	        <ul class="login">\
	            <li id="host_front_welcome" style="display:none;">12345622,欢迎您！<a href="#" class="font_blue">[退出]</a></li>\
	        </ul>\
	        <div class="clear"></div>\
	    </div>\
	</div>\
	</div>';
	var flag = getQueryString('flag');
	if(  ((flag == 'field') ||(flag == 'field_admin')) && get_current_urlname() == 'login.html'){
		$("#login_link_login").attr("href","css/login02.css");
		$(".global_head").replaceWith(template_field_header);
		$("#global_link_login").attr("href","http://hotel.huodongshu.com/hotel/css/global.css");
		$(".global_head").addClass("global_head1000");
	}else{
		
	}
	
});

//场地尾部
$(function(){
	var global_field_footer = '<div class="global_footer">\
	    <div class="inner">\
    Copyright©2014 houdongshu.com 京ICP备 14023406号-1\
</div>\
</div>';
	var fromto =  getQueryString("fromto");
	if( window.location.host == 'm.huodongshu.com' || window.location.host =='112.124.102.145'  || 'phoneapp' == fromto){
		
	}else{
		var flag = getQueryString('flag');
		if(  ((flag == 'field') ||(flag == 'field_admin')) && get_current_urlname() == 'login.html'){
			if($("body div.global_width").length == 1){
				$("body div.global_width").append('<div class="clear"></div>');
			}
			$("body").append(global_field_footer);
		}else{
			
		}
		
	}
	
});



function getcustheader(){
	$.ajax({ url: js_huodongshu_domain+"/getlogininfo.do?event_id="+getQueryString("event_id"),
		type:"POST",
		async:false,
		dataType:"json",
		success:function(data){
	       var status = data.status;
	       status = $.trim(status);
	       var current_url = get_current_urlname();
	       if(status == '0'){//nologin
	    	   if(gatekeeper()){
	    		   $("body").hide();
	    		   window.location.href = '/html/login.html';
	    	   }else{
	    			   $("#huodongshu_login").show();
	  		    	   $("#huodongshu_register").show();
	  		    	   $("#huodongshu_welcome_span").html("欢迎你！"); 
	  		    	   $("#huodongshu_logout").hide();
	    		  
	    	   }
	    	  
	       }else{//login
				if(current_url == 'login.html'){
					 $("body").hide();
					window.location.href = '/html/account_base.html';
				}else{
					   var welcome_name = $.trim(data.data.name) == '' ? data.data.username:data.data.name;
					    if(hds_isEmail(welcome_name)){
//					    	welcome_name = welcome_name.length > 11 ?welcome_name.substr(0,11):welcome_name;
//					    	welcome_name += '...';
					    	var temp_email = welcome_name.split("@");
					    	welcome_name = temp_email[0];
						}else if(hds_ismobile(welcome_name)){
							
						}else{
							welcome_name = welcome_name.length > 10 ?welcome_name.substr(0,10)+'...':welcome_name;
//							welcome_name += '...';
						}
					   $("#huodongshu_login").hide();
			    	   $("#huodongshu_register").hide();
			    	   $("#huodongshu_logout").show();
			    	   $("#huodongshu_welcome_span").html(welcome_name+",欢迎你！"); 
				}
	    	   
	       }//loginend
	       var pre_url = current_url.substr(0,current_url.indexOf("_"));
	       if(current_url == 'index.html' || current_url == 'fun_intro.html' || current_url == 'service_agreement.html' || current_url == 'about_us.html' || current_url == 'know.html' || current_url == '404.html' || current_url == 'feedback.html' || current_url == 'login.html' || current_url == 'register.html' ){
	    
	       }else if(pre_url == "account" || current_url == 'login.html'){
               $("#id_li_account").attr("class","choose");
           }else if(pre_url == "contact" ){
               $("#id_li_account").attr("class","choose");
           }else if(pre_url == "event"){
	    	   $("#id_li_event").attr("class","choose");
	       }else if(current_url != 'index.html' && window.location.pathname != '/'){
	    	   $("#id_li_myevent").attr("class","choose");
	       }
	    }
	});
}

