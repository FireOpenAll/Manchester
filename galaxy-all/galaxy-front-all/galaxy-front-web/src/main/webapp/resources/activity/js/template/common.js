var js_huodongshu_domain  = "http://182.92.169.209";//domain

var hds_is_login = 0;
var need_login_page =['page_edit.html','account_mailVerifiction.html','account_phoneVerifiction.html','account_reviseEmail.html','manage_participants.html','account_revisePhone.html','account_sponsor.html','account_revisePsd.html','account_xiaofei.html','account_safe.html','account_certification.html','shoppingCart02.html','account_base.html','event_base.html','event_agenda.html','event_ticket_list.html','event_xiangce.html','event_xiangce_browse.html','event_video.html','event_wenjian.html','event_jiabin.html','event_jigou.html','event_gongzuorenyuan.html','event_register_form.html','myEvent_create.html','myEvent_join.html','myEvent_interest.html','manage_order_details.html','event_agenda.html','topic_setting.html','lottery_setting.html','vote_setting.html','myEvent_trial.html'];
var need_login_wxpage =['acount_my.html','acount_personal.html','account_person_edit.html','create_event.html','agenda_list.html','buy_invoice.html','buy_order.html','create_list.html'];

if((navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) || window.location.host == 'm.huodongshu.com'){
    wx_gatekeeper();
}
//隐藏手机浏览器地址栏
$(document).ready(function(){
    if(document.documentElement.scrollHeight <= document.documentElement.clientHeight) {
        bodyTag = document.getElementsByTagName('body')[0];  
        bodyTag.style.height = document.documentElement.clientWidth / screen.width * screen.height + 'px';  
    }  
    setTimeout(function() {  
        window.scrollTo(0, 1);  
    }, 0);  

    $("#userLoginform").keydown(function(e){
        var e = e || window.event;
        if(e.keyCode  ==  13){
                var login_name = $("#login-name").val();
                var login_pass =  $("#login-pass").val();
                login_name = $.trim(login_name);
                login_pass = $.trim(login_pass);
                if( (login_name != '') && (login_pass != '') ){
                    huodongshu_user_login();
                }    
        }
        
    });
    //
    var is_h5 = (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) || window.location.host == 'm.huodongshu.com';
    if(!is_h5){
        var name = huodongshu_getcookie('huodongshu_keepusername');
        name = $.trim(name);
        if(name != ''){
            $("#login-name").val(name);
            $("#login_checkbox").attr("checked","checked");
        }else{
            $("#login-name").val("");
        }
    }
    
    
    // 手机app隐藏header头
    var fromTo = getQueryString("fromto");
    var isFromWeixinShare = getQueryString("from");
    var userAgent = navigator.userAgent.toLowerCase();
    var host = window.location.host;
    host = $.trim(host);
    var url = document.location.href;
    //if (fromTo == 'phoneapp') {$("header").hide(function (){$(this).remove();});}
    if (fromTo == 'phoneapp'||isFromWeixinShare=='singlemessage') {
        $("header").remove();
//        wx_gatekeeper();
    }else {
        if (userAgent.indexOf('huo dong shu') != -1) { 
            $("header").remove();
//            wx_gatekeeper(); 
        }
    }
//    if (userAgent.indexOf('micromessenger') != -1) {
////            if(url.indexOf('create_list.html')==-1){
//////                $("header").remove();
////            }
////        wx_gatekeeper();
//    }
//    if (userAgent.indexOf('iphone') != -1||userAgent.indexOf('android') != -1 || host == 'm.huodongshu.com') {
////            $("header").remove();
////        wx_gatekeeper();
//    }
        
});
redirect_by_device();
function redirect_by_device(){
    var force_pc = getQueryString("force_pc");
    var userAgent = navigator.userAgent.toLowerCase();
    var host = window.location.host;
    host = $.trim(host);
    var curr_pathname = window.location.pathname;
    curr_pathname = $.trim(curr_pathname);
    if(curr_pathname=='/' || curr_pathname==''){
        if((navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) &&  host != 'test.huodongshu.net'  &&  host != '112.124.102.145' &&  host != 'app.huodongshu.com' && force_pc!=1){
            window.location.href='http://m.huodongshu.com/html/h5/index.html';
        }else if( host == 'm.huodongshu.com' ){
            window.location.href='http://m.huodongshu.com/html/h5/index.html';
        }
    }
}

function wx_user_logout(){
	$.ajax({ url: js_huodongshu_domain+"/account/logout.do",
		type:"POST",
		dataType:"html",
		data:"channelid=3",
		success:function(msg){
			   javascript:window.location.reload();
	    }
	});
	
}


function toMoeny(num){
    if(num == 0){
        return '0';
    }
    num = num.toString().replace(/\$|\,/g,'');
    if(isNaN(num)){
        num="0";
    }
    sign=(num==(num=Math.abs(num)));
    num=Math.floor(num*100+0.50000000001);
    cents=num%100;
    num=Math.floor(num/100).toString();
    if(cents<10){
        cents="0"+cents;
    }
    for(var i=0;i<Math.floor((num.length-(1+i))/3);i++){
        num=num.substring(0,num.length-(4*i+3))+''+num.substring(num.length-(4*i+3));
    }
    var result_value =(((sign)?'':'-')+num+'.'+cents);
    if(result_value == 0){
        return '0';
    }else{
        return result_value;
    }
}


//倒计时
//var nowtime = new Date().getTime();
//consttime = setInterval("hds_counttime("+nowtime+",'register',60000);",100);
function hds_counttime(nowtime,type,timelen){
  if(timelen){
  }else{
      timelen = 60000;
  }
  var currenttime = timelen + (nowtime-new Date().getTime());
  currenttime = currenttime/1000;
  currenttime = parseInt(currenttime);
    if(currenttime > 0){
        if(type == 'register'){//h5注册页面
            $("#span_rongxinfasong").show();
            var spanstr= currenttime+"秒后重试";
            $("#span_rongxinfasong").html(spanstr);
        }
        if(type == 'findpwd'){//h5忘记密码页面
            $("#span_findpwd_sendmes").show();
            var spanstr= currenttime+"秒后重试";
            $("#span_findpwd_sendmes").html(spanstr);
        }
        if(type == 'web_findpwd'){
            $("#a_get_validate").attr("href","javascript:void(0);");
            var spanstr= currenttime+"秒后重试";
            $("#a_get_validate").html(spanstr);
        }
        if(type == 'web_register'){
            $("#register_a_getcode").attr("href","javascript:void(0);");
            var spanstr= currenttime+"秒后重试";
            $("#register_a_getcode").html(spanstr);
        }
        
        
    }else{
        if(type == 'register'){//h5注册页面
            $("#a_rongxin_huoqu").show();
            $("#span_rongxinfasong").hide();
            window.clearInterval(consttime);
        }
        if(type == 'findpwd'){//h5忘记密码页面
            $("#a_findpwd_sendmes").show();
            $("#span_findpwd_sendmes").hide();
            window.clearInterval(consttime);
        }
        if(type == 'web_findpwd'){
            $("#a_get_validate").attr("href","javascript:forgetPwd_firstStep();");
            $("#a_get_validate").html("获取校验码");
            window.clearInterval(consttime);
        }
        if(type == 'web_register'){
            $("#register_a_getcode").attr("href","javascript:getValidatefoRegister();");
            $("#register_a_getcode").html("获取校验码");
            window.clearInterval(consttime);
        }
        
    }
}

function toggle_input_value(type,id,value,callback){
    type = $.trim(type);
    id = $.trim(id);
    value = $.trim(value);
    var name = $("#"+id).val();
    name = $.trim(name);
    if(type == 'in'){
        if(name == value){
             $("#"+id).val('');
        }
    }else{
        if(name == ''){
             $("#"+id).val(value);
        }
    }
    if(callback){
        eval(callback);
    }
}
function processpwd(type,pid,pval){
    type = $.trim(type);
    var val = $("#"+pid).val();
    val = $.trim(val);
    if(type == 'in'){
        $("#"+pid).attr("type","password");
        if(val == '' || val == pval){
            $("#"+pid).val('');
        }else{
            $("#"+pid).val(val);
        }
    }else{
        if(val == '' || val == pval){
            $("#"+pid).attr("type","text");
            $("#"+pid).val(pval);
        }else{
            $("#"+pid).attr("type","password");
            $("#"+pid).val(val);
        }
        
    }
}
//js本地图片预览，兼容ie[6-9]、火狐、Chrome17+、Opera11+、Maxthon3  
function hds_preview_pic(fileObj,imgPreviewId,imgliid){ 
    if($("#"+imgliid)){
        $("#"+imgliid).attr("class","form file_ok");
    }
    var allowExtention=".jpg,.bmp,.gif,.png";//允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;  
    var extention=fileObj.value.substring(fileObj.value.lastIndexOf(".")+1).toLowerCase();              
    var browserVersion= window.navigator.userAgent.toUpperCase();  
    if(allowExtention.indexOf(extention)>-1){   
        if(fileObj.files){//HTML5实现预览，兼容chrome、火狐7+等  
            if(window.FileReader){  
                var reader = new FileReader();   
                reader.onload = function(e){  
                    document.getElementById(imgPreviewId).setAttribute("src",e.target.result);  
                };    
                reader.readAsDataURL(fileObj.files[0]);  
            }else if(browserVersion.indexOf("SAFARI")>-1){  
                alert("不支持Safari6.0以下浏览器的图片预览!");  
            }  
        }else if (browserVersion.indexOf("MSIE")>-1){  
            if(browserVersion.indexOf("MSIE 6")>-1){//ie6  
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);  
            }else{//ie[7-9]  
                fileObj.select();  
                if(browserVersion.indexOf("MSIE 9")>-1)  
                    fileObj.blur();//不加上document.selection.createRange().text在ie9会拒绝访问                       
            }  
        }else if(browserVersion.indexOf("FIREFOX")>-1){//firefox  
            var firefoxVersion= parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);  
            if(firefoxVersion<7){//firefox7以下版本  
                document.getElementById(imgPreviewId).setAttribute("src",fileObj.files[0].getAsDataURL());  
            }else{//firefox7.0+                      
                document.getElementById(imgPreviewId).setAttribute("src",window.URL.createObjectURL(fileObj.files[0]));  
            }  
        }else{  
            document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);  
        }           
    }else{  
        alert("仅支持"+allowExtention+"为后缀名的文件!");  
        fileObj.value="";//清空选中文件  
        if(browserVersion.indexOf("MSIE")>-1){                          
            fileObj.select();  
            document.selection.clear();  
        }                  
        fileObj.outerHTML=fileObj.outerHTML;  
    }  
}  

function get_pic_fullpath(obj,imgid,imgliid)
{
    
    var path_url = '';
    if(obj){
        // ie
        if (window.navigator.userAgent.indexOf("MSIE")>=1){
            obj.select();
            path_url =  document.selection.createRange().text;
            alert(path_url);
            $("#"+imgid).attr("src",path_url);
            $("#"+imgliid).attr("class","form file_ok");
            return;
        }
        // firefox
        else if(window.navigator.userAgent.indexOf("Firefox")>=1){
            if(obj.files){
                path_url =  obj.files.item(0).getAsDataURL();
                alert(path_url);
                $("#"+imgid).attr("src",path_url);
                $("#"+imgliid).attr("class","form file_ok");
                return;
            }
            path_url =  obj.value;
            alert(path_url);
            $("#"+imgid).attr("src",path_url);
            $("#"+imgliid).attr("class","form file_ok");
            return;
        }
        path_url =  obj.value;
        alert(path_url);
        $("#"+imgid).attr("src",path_url);
        $("#"+imgliid).attr("class","form file_ok");
        return;
    }
}

function isNull(str){
    return str == null || str == "null" || str === "" || str == "undefined" || typeof(str) == "undefined";
}

/**
 * 适用于相同结构的选择框选项
 * @param obj当前组件
 * @param str 回调函数或者代码
 * @return 无
 */
function item_h5select(obj,str){
    $(obj).children("div[class='listL']").children("span").eq(0).attr("class","unitCheck unitCheckC");
    eval(str);
    var otherobj = $(obj).siblings();
    var len = otherobj.length;
    for(var i = 0; i < len; i++){
        var tempobj = otherobj.eq(i);
        $(tempobj).children("div[class='listL']").children("span").eq(0).attr("class","unitCheck");
    }
}

//订单支付
function order_pay(order_id,type){
    if(type == 'jisidaozhang'){//支付宝即时到账
        window.location.href = js_huodongshu_domain+"/library/zfb_jsdz/alipayapi.php?hds_order_id="+order_id;
    }else if(type == 'wangyinzhifu'){//支付宝网银支付
        window.location.href = js_huodongshu_domain+"/library/zfb_wyzf/alipayapi.php?hds_order_id="+order_id;
    }else if(type == 'weixinjscall'){//微信jsapi支付
        window.location.href = js_huodongshu_domain+"/library/wx_webpay/jsapicall.php?hds_order_id="+order_id;
    }else if(type == 'weixinnative'){//微信native支付
        window.location.href = js_huodongshu_domain+"/library/wx_webpay/nativecall.php?hds_order_id="+order_id;
    }else if(type == 'zfb_mobilepay'){//支付宝手机网页支付
        window.location.href = js_huodongshu_domain+"/library/zfb_h5/alipayapi.php?hds_order_id="+order_id;
    }
    
}

function to_login_page(){
      var url =  document.location.href;
      var last_url_key = 'last_login_url';
      var current_url = get_current_urlname();
      if( (current_url != 'login.html') && (current_url != 'register.html')  && (current_url != 'findPsd.html') ){
          huodongshu_setcookie(last_url_key,url,3600*1000*200);
      }
//      var last_url_value = huodongshu_getcookie(last_url_key);
//      if(last_url_value){
         
//      }else{
//          huodongshu_addcookie(last_url_key,url,3600*1000*200);
//      }    
      window.location.href = '/html/login.html';
}
function gatekeeper(){
    var current_url = get_current_urlname();
    var url =  document.location.href;
    var last_url_key = 'last_login_url';
//    var last_url_value = huodongshu_getcookie(last_url_key);
//      if(last_url_value){
//          huodongshu_setcookie(last_url_key,url,3600*1000*200);
//      }else{
//          huodongshu_addcookie(last_url_key,url,3600*1000*200);
//          
//      }      
    var tempurl = get_current_urlname();
    if( (tempurl != 'login.html') && (tempurl != 'register.html')  && (tempurl != 'findPsd.html') ){
        huodongshu_setcookie(last_url_key,url,3600*1000*200);
    } 
    if(in_array(current_url,need_login_page)){
        return true;
    }
    return false;
}

function in_array(search,array){
    search = $.trim(search);
    for(var i in array){
        if(array[i]==search){
            return true;
        }
    }
    return false;
}


//更换验证码
function updateValidatecode(id){
    id=$.trim(id);
    var imgurl = "/account/validateCode.do?v="+Math.random();
      $("#"+id).attr("src",imgurl);
}



//获取url参数
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null){
        var tempstr = decodeURI(r[2]);
        return unescape(tempstr); 
    } 
    return null;
}

function get_current_urlname(){
    var current_url = window.location.href;
    var searchurl = window.location.search;
    current_url = current_url.replace(searchurl,'');
    current_url = current_url.substr(current_url.lastIndexOf("/")+1);
    current_url = current_url.replace(/#.*$/, "");
    current_url = $.trim(current_url);
    return current_url;
}

function huodongshu_process_forjson(str){
    str = $.trim(str);
    str = str.replaceAll('"','#0989471400#');
    str = str.replaceAll(':','#0989471401#');
    str = str.replaceAll('：','#0989471402#');
    str = str.replaceAll("\n",'#0989471403#');
    str = str.replaceAll("\t",'#0989471404#');
    str = str.replaceAll("\r",'#0989471405#');
    str = str.replaceAll("\\\\",'#0989471406#');
    return str;
    
}

//add by surn 2014年9月16日10:10:42 
function huodongshu_process_foredit(str){
    str = $.trim(str);
    str = str.replaceAll('#0989471400#','"');
    str = str.replaceAll('#0989471401#',':');
    str = str.replaceAll('#0989471402#','：');
    str = str.replaceAll('#0989471403#',"\n");
    str = str.replaceAll('#0989471404#',"\t");
    str = str.replaceAll('#0989471405#',"\r");
    str = str.replaceAll('#0989471406#',"\\\\");
    str = str.replaceAll('<br/>',"\n");
    return str;
    
}
/**
 * 加载三级区域菜单
 * 
**/
function changeLevel2(code,type,posid) {
    posid = $.trim(posid);
      var info = '{"code":"'+code+'","type":"'+type+'"}';
     var url = js_huodongshu_domain+'/getaddressinfo.do';
      $.ajax({
            url: url,
            async:false,
            dataType: "json",
            data:"info="+info,
            success: function(msg){
                       var data = {addres:msg.data};
                       var dataDir = {
                        'option':{
                               'addre<-addres':{
                                '.':'addre.name',
                                   '@value':'addre.code'//,
//                                   '@onclick':function(a){
//                                    return 'javascript:whenproviceselect2("'+posid+'","'+(a.item.code)+'");';
//                                }//end onclick
                               }
                           
                           }
                          };//end dataDir
                       $("#"+posid).render(data, dataDir);
                     
                   
            }
       });
}
/**
 * 
 */
function whenproviceselect2(id){

    var code = $("#"+id).val();
    if(id == 'select_address_grade1'){
        $("#select_address_grade2").html('<option value="-1" >--请选择--</option>');
        $("#select_address_grade3").html('<option  value="-1" >--请选择--</option>');
        changeLevel2(code,'list',"select_address_grade2");
    }else if(id == 'select_address_grade2'){
        $("#select_address_grade3").html('<option  value="-1" >--请选择--</option>');
        changeLevel2(code,'list',"select_address_grade3");
    }else if(id == 'select_address_grade3'){
        return;
    }
    
    
}

/**
 * 加载三级区域菜单
 * 
**/
function changeLevel(code,type,posid) {
    posid = $.trim(posid);
      var info = '{"code":"'+code+'","type":"'+type+'"}';
     var url = js_huodongshu_domain+'/getaddressinfo.do';
      $.ajax({
            url: url,
            async:false,
            dataType: "json",
            data:"info="+info,
            success: function(msg){
                 var html = '';
                 var datas = msg.data;
                 if(msg.data){
                     var len = msg.data.length;
                 }else{
                     var len = 0;
                 }    
                 for(var i = 0; i < len; i++){
                     var item = datas[i];
                     html += '<li type="'+(item.code)+'">'+(item.name)+'</li>';
                 }
                 $("#"+posid).html(html); 
                 UIselect();
            }
       });
}
/**
 * 
 */
function whenproviceselect(id,code){
    if(id == 'select_address_grade1'){
        $("#select_address_grade2").html('<li type="0"></li>');
        $("#select_address_grade3").html('<li type="0"></li>');
        changeLevel2(code,'list',"select_address_grade2");
    }else if(id == 'select_address_grade2'){
        $("#select_address_grade3").html('<li type="0"></li>');
        changeLevel2(code,'list',"select_address_grade3");
    }else if(id == 'select_address_grade3'){
        return;
    }
    
    
}
function addressGrade1Select(e){
    $("#address_display1").attr("type",e.attr("type"));
    $("input[name='select_address_grade1']").val(e.attr("type"));
    whenproviceselect2('select_address_grade1',e.attr("type"));
}
function addressGrade2Select(e){
    $("#address_display2").attr("type",e.attr("type"));
    $("input[name='select_address_grade2']").val(e.attr("type"));
    whenproviceselect2('select_address_grade2',e.attr("type"));
}
function addressGrade3Select(e){
    $("#address_display3").attr("type",e.attr("type"));
    $("input[name='select_address_grade3']").val(e.attr("type"));
    whenproviceselect2('select_address_grade3',e.attr("type"));
}


//用户登录
function huodongshu_user_login(){
    var username = $("#login-name").val();
    username = $.trim(username);
    if( username == '' ){
//        $("#login_error_commondiv").attr("style","top:70px;");
        $("#login_error_commondiv p").html('<span class="icon"></span>请输入手机号或者邮箱！');
        $("#warnBox_username").html($("#login_error_commondiv").html());
        $("#warnBox_username").show();
        return;
    }
    if(!huodongshu_word_check(username)){
//        $("#login_error_commondiv").attr("style","top:70px;");
        $("#login_error_commondiv p").html('<span class="icon"></span>用户名不能含特殊字符！');
        $("#warnBox_username").html($("#login_error_commondiv").html());
        $("#warnBox_username").show();
        return;
    }
    if(hds_isEmail(username)){
        
    }else if(hds_ismobile(username)){
        
    }else{
//        $("#login_error_commondiv").attr("style","top:70px;");
        $("#login_error_commondiv p").html('<span class="icon"></span>用户名只能是手机或者邮箱！');
        $("#warnBox_username").html($("#login_error_commondiv").html());
        $("#warnBox_username").show();
        return;
    }
    var pwd = $("#login-pass").val();
    pwd = $.trim(pwd);
    if(pwd == ''){
//        $("#login_error_commondiv").attr("style","top:130px;");
        $("#login_error_commondiv p").html('<span class="icon"></span>请输入密码！');
        $("#warnBox_pwd").html($("#login_error_commondiv").html());
        $("#warnBox_pwd").show();
        return;
    }
    
    
    

//    var logininfo = '{"name":"'+username+'","pwd":"'+pwd+'"}';
    $.ajax({ url: js_huodongshu_domain+"/account/login.do",
        type:"POST",
        dataType:"json",
        data:{username:username,password:pwd},
        success:function(msg){
          if(msg.status == 1){
               if($("#login_checkbox")){
                    var c_len = $("#login_checkbox:checked").length;
                    if(c_len == 0){//
                        huodongshu_setcookie('huodongshu_keepusername',"",3600*24*30*1000);
                    }else if(c_len == 1){//
                        huodongshu_setcookie('huodongshu_keepusername',username,3600*24*30*1000);
                    }
                }
               
               
              var flag = getQueryString('flag');
              flag = $.trim(flag);
              if(flag == 'field'){
            	   window.location.href = 'http://hotel.huodongshu.com/hotel/speciallist.html';
              }else if(flag == 'field_admin'){
            	   window.location.href = 'http://hotel.huodongshu.com/hotel_admin/hotel_base.html';
              }else{
            	  var last_url_key = 'last_login_url';
                  var url = huodongshu_getcookie(last_url_key);
                  if(url){
                      window.location.href = url;
                  }else{
                      window.location.href = '/html/index.html';
                  }

                  if(msg.data.username == 'hds_admin@huodongshu.com'){
                      window.location.href = '/html/admin/myEvent_trial.html';
                  }
              }
              
             
          }else{
               var mes = msg.msg;
               mes = $.trim(mes);
               if(mes == '不存在此账号！'){
//                   $("#login_error_commondiv").attr("style","top:70px;");
                    $("#login_error_commondiv p").html('<span class="icon"></span>不存在此账号！');
                    $("#warnBox_username").html($("#login_error_commondiv").html());
                    $("#warnBox_username").show();
               }else if(mes == '用户名或者密码有误！'){
//                   $("#login_error_commondiv").attr("style","top:130px;");
                    $("#login_error_commondiv p").html('<span class="icon"></span>密码有误！');
                    $("#warnBox_pwd").html($("#login_error_commondiv").html());
                    $("#warnBox_pwd").show();
               }else if(mes == ''){
               }else if(mes == ''){
               }else{
                   alert(mes);
               }
               
              
          }
        }
    });
    
}

//用户退出
function huodongshu_user_logout(){
    $.ajax({ url: js_huodongshu_domain+"/account/logout.do",
        type:"POST",
        dataType:"html",
        success:function(msg){
           if(gatekeeper()){
               window.location.href = '/html/login.html';
           }else{
               javascript:window.location.reload();
           }
        }
    });
    
}


function huodongshu_word_check(str){
    str = $.trim(str);
    if(str.indexOf("\"") == -1 && str.indexOf("'") == -1 && str.indexOf("<") == -1 && str.indexOf(">") == -1  && str.indexOf("*") == -1  && str.indexOf("%") == -1 && str.indexOf("&") == -1 && str.indexOf("$") == -1    && str.indexOf("!") == -1){
      return true;
    }    
    return false;
}

function huodongshu_addcookie(objName,objValue,ms){ 
    var str = objName + "=" + escape(objValue);
    if(ms > 0){
        var date = new Date();
        date.setTime(date.getTime() + ms);
        str += ";path=/; expires=" + date.toGMTString();
   }
   document.cookie = str;
}

function huodongshu_setcookie(name,value,ms){//ms= Days*24*60*60*1000
    name = $.trim(name);
    var tempval = huodongshu_getcookie(name);
    if(tempval){
        var exp = new Date();    //new Date("December 31, 9998");
        exp.setTime(exp.getTime() + ms);
        document.cookie = name + "="+ escape (value) + ";path=/;expires=" + exp.toGMTString();
    }else{
        huodongshu_addcookie(name,value,ms);
    }
    
}
 
function huodongshu_getcookie(name){
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
    if(arr != null) return unescape(arr[2]); return null;
}
 
function huodongshu_delcookie(name){
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}
//邮箱验证
function hds_isEmail(email){
    var reg=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
  return reg.test($.trim(email));
}
//手机验证
function hds_ismobile(mobile){
     var reg=/^(0|86|17951)?(13|15|18|14)\d{9}$/;
     return  reg.test($.trim(mobile));
}
function wx_gatekeeper(){
    
    var event_id = getQueryString("event_id");
    if(event_id && (!isNaN(event_id))){
        $.ajax({ url: js_huodongshu_domain+"/getEventName.do",
            type:"POST",
            async:true,
            dataType:"html",
            data:"event_id="+event_id,
            success:function(msg){
               msg = $.trim(msg);
               $("title").html(msg);
            }
        });
    }else{
        $("title").html("活动树");
    }
//    $("body").hide();
    var tempurl = get_current_urlname();
    tempurl = $.trim(tempurl);
    var url = '';
    if( (tempurl != 'login.html') && (tempurl != 'register.html')  && (tempurl != 'find_password.html') ){
         url =  document.location.href;
        huodongshu_setcookie('wx_last_url',url,3600*1000*200);
    } 
    $.ajax({ url: js_huodongshu_domain+"/getlogininfo.do",
        type:"POST",
        async:false,
        dataType:"json",
        success:function(data){
           var status = data.status;
           status = $.trim(status);
           var current_url = get_current_urlname();
           if(status == '0'){//nologin               
                if(in_array(tempurl,need_login_wxpage)){
                    if(is_weixin ()){
//                        window.location.href = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx075a91b6a93d7c6f&redirect_uri=http://m.huodongshu.com/account/wxbangding.do&response_type=code&scope=snsapi_userinfo&state=abc#wechat_redirect';//有授权页面
                        if( (tempurl != 'login.html') && (tempurl != 'register.html')  && (tempurl != 'find_password.html') ){
                            var h5url = url;
                        }else{
                            var h5url = '/';
                        }
                        window.location.href = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx075a91b6a93d7c6f&redirect_uri=http://m.huodongshu.com/account/wxbangding.do&response_type=code&scope=snsapi_base&state='+h5url+'#wechat_redirect';//无授权页面
                        
                    }else{
                        window.location.href = '/html/h5/login.html';
                    }

                    
                }else{
//                    $("body").show();
                }
           }else{
               //微信测试
               test_global_name = data.data.username;
               hds_is_login = 1;
               if(tempurl == 'login.html'){
                   window.location.href = '/html/h5/index.html';
               }
               
//               $("body").show();
           }
        }
    });
    
    
    
}


String.prototype.replaceAll = function(s1,s2) { 
    return this.replace(new RegExp(s1,"gm"),s2); 
};

Date.prototype.format = function(format){  
    var o = {  
    "M+" : this.getMonth()+1, //month  
    "d+" : this.getDate(), //day  
    "h+" : this.getHours(), //hour  
    "m+" : this.getMinutes(), //minute  
    "s+" : this.getSeconds(), //second  
    "q+" : Math.floor((this.getMonth()+3)/3), //quarter  
    "S" : this.getMilliseconds() //millisecond  
    };  
      
    if(/(y+)/.test(format)) {  
    format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));  
    }  
      
    for(var k in o) {  
    if(new RegExp("("+ k +")").test(format)) {  
    format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));  
    }  
    }  
    return format;  
    }; 

/** add lidong 2014年07月 start  */


/**
 * 获取字符串的中文长度
 * @param {String} content 字符串
 */
    
$(function () {
    var userAgent = navigator.userAgent.toLowerCase();
    if (userAgent.indexOf('huo dong shu') != -1){$("header").remove();}
});

function fontNum(content)
{
    if (typeof content == "undefined") {
        return 0;
      }
      var a = content.match(/[^\x00-\x80]/g);
      return Math.ceil((content.length + (!a ? 0 : a.length)) / 2);
}
function convertToChinese(num){  
    var N = [  
             "零", "一", "二", "三", "四", "五", "六", "七", "八", "九"  
     ]; 
var str = num.toString();  
var len = num.toString().length;  
var C_Num = [];  
for(var i = 0; i < len; i++){  
    C_Num.push(N[str.charAt(i)]);  
}  
return C_Num.join('');  
}

function is_app () {
    var userAgent = navigator.userAgent.toLowerCase();
    if (userAgent.indexOf('huo dong shu') != -1){return true;}
    return false;
}

function is_weixin () {
    var userAgent = navigator.userAgent.toLowerCase();
    if (userAgent.indexOf('micromessenger') != -1) {
        return true;
    }
    return false;
}


function isPC() {
    var userAgentInfo = navigator.userAgent;
    var Agents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");
    var flag = true;  
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) { flag = false; break; }
    }  
    return flag;
 }

function is_iphone() {
    var userAgentInfo = navigator.userAgent;
    var Agents = new Array( "iPhone", "iPad", "iPod");
    var flag = false;  
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) { flag = true; break; }
    }  
    return flag;
}

function is_android () {
    var userAgentInfo = navigator.userAgent;
    var Agents = new Array("Android");
    var flag = false;  
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) { flag = true; break; }
    }  
    return flag;
}

var userAgent = navigator.userAgent.toLowerCase();
if (userAgent.indexOf('iphone') != -1||userAgent.indexOf('android') != -1) {
    window.onload=function(){  
        setTimeout(function() {  
            window.scrollTo(0, 1); 
        }, 0);  
    }; 
}
/**
 * 追加js
 * @param url
 * @param callback
 * @param charset
 */
function loadJS(url,callback,charset)
{
  var script = document.createElement('script');
  script.onload = script.onreadystatechange = function ()
  {
    if (script && script.readyState && /^(?!(?:loaded|complete)$)/.test(script.readyState)) {
      return;
    }
    script.onload = script.onreadystatechange = null;
    script.src = '';
    script.parentNode.removeChild(script);
    script = null;
    if(callback){ callback(); }
  };
  script.charset=charset || document.charset || document.characterSet;
  script.src = url;
  //console.log(script);
  try {document.getElementsByTagName("head")[0].appendChild(script);} catch (e) {}
}
/** add lidong 2014年07月 end  */
//发布活动
function apply_event(event_id){
	 var url = js_huodongshu_domain+'/event/applyevent.do';
	  $.ajax({
			url: url,
			async: false,
			dataType: "json",
			data:{event_id:event_id},
			success: function(msg){
				if(msg.status == 0){
					alert(msg.msg);
				}else{
					 $("#link_apply_event").hide();
					 if(msg.data.is_privacy == 1){
//					 	alert('您的活动发布成功！');
						 alert('您的活动已成功提交，我们将在2个工作日内对活动进行审核！');
					 }else{
					 	alert('您的活动发布成功！');
					 }
					 window.location.reload();
				}
		           
			}
	   });
}