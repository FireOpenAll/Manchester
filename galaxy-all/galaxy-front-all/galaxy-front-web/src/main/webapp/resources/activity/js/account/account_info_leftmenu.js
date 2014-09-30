$(document).ready(function(){
    var account_leftmenu = '<div class="global_leftMenu">\
        <div class="menuTitle"><span class="icon icon01"></span>我的账户</div>\
        <div class="menuBody">\
            <dl>\
                <dt class="choose">\
                    <span class="icon menu04"></span>\
                    <span  class="text" href="javascript:void(0);" >账户信息</span>\
                </dt>\
                <dd class="choose">\
                    <a  href="account_base.html" >账户基本信息</a>\
                    <a  href="account_safe.html" >账户安全</a>\
                    <a  href="account_certification.html">发布方认证</a>\
                    <a  href="account_xiaofei.html">消费通道</a>\
    				<a  href="account_number.html">结算账号</a>\
                    <span class="arrow"></span>\
                </dd>\
                <dt>\
                    <span class="icon menu04"></span>\
                    <span class="text" id="" href="javascript:void(0)">我的联系人</span>\
               </dt>\
               <dd class="choose">\
                <a  href="'+js_huodongshu_domain+'/html/contact_group_list.html">联系人组</a>\
                <a  href="'+js_huodongshu_domain+'/html/contact_list.html">联系人</a>\
              </dd>\
              <dt class="choose">\
              <span class="icon menu01"></span>\
              <!--<a href="account_sponsor.html">常用主办方</a>-->\
              <span class="arrow"></span>\
              </dt>\
              <dt class="choose last">\
              <span class="icon menu01"></span>\
              <a  href="'+js_huodongshu_domain+'/html/account_sms_template.html">短信模板</a>\
              <span class="arrow"></span>\
              </dt>\
            </dl>\
        </div>\
    </div>';
        
var account_top_menu = '<div class="global_headSec">\
    <div class="global_headSecInner">\
    <div class="headName"></div>\
    <ul  class="headTab">\
        <li  class="choose"><a href="#">账户信息</a></li>\
        <li><a href="#">我的活动</a></li>\
        <li><a href="#">主办方</a></li>\
        <li><a href="#">我的联系人</a></li>\
    </ul>\
   </div>\
</div>';
    $(".global_leftMenu").replaceWith(account_leftmenu);
//    $(".global_headSec").replaceWith(account_top_menu);
    var current_url = get_current_urlname();
    $(".global_leftMenu").find("dt").removeClass("choose");
    $(".global_leftMenu").find("a[href*='"+current_url+"']").append("<span></span>").parent().addClass("choose");
});