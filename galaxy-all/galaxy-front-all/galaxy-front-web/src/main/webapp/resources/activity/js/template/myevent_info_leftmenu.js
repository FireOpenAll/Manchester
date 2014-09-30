$(document).ready(function(){
	var myevent_leftmenu = '<div class="global_leftMenu">\
    	<div class="menuTitle"><span class="icon icon01"></span>我的活动</div>\
    	<div class="menuBody">\
            <dl>\
                <dt class="choose">\
                    <span class="icon menu01"></span>\
                    <a  href="myEvent_create.html" >我创建的活动</a>\
                    <span class="arrow"></span>\
                </dt>\
				<dt class="choose">\
			        <span class="icon menu01"></span>\
					<a href="myEvent_join.html" >我参加的活动</a>\
			        <span class="arrow"></span>\
			    </dt>\
				<dt class="choose last">\
			        <span class="icon menu01"></span>\
					<a  href="myEvent_interest.html">感兴趣的活动</a>\
			        <span class="arrow"></span>\
			    </dt>\
            </dl>\
        </div>\
    </div>';
        

	$(".global_leftMenu").replaceWith(myevent_leftmenu);
//	$(".global_headSec").replaceWith(account_top_menu);
	var current_url = get_current_urlname();
	$(".global_leftMenu").find("dt").removeClass("choose");
	$(".global_leftMenu").find("a[href*='"+current_url+"']").append("<span></span>").parent().addClass("choose");
});