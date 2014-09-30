$(function(){
    var template_header = '<div class="global_headSec">\
        <div class="global_headSecInner">\
        <div class="headName" id="event_header_name" > </div>\
            <ul  class="headTab">\
                <li id="page_info"><a id="hds_eventInfo" href="#">活动信息</a></li>\
                <li id="page_edit"><a id="hds_editTemplate" href="">页面美化</a></li>\
                <li id="page_manage"><a id="hds_manage" href="#">活动管理</a></li>\
            </ul>\
        <div class="headBtn"  >\
        	<a href="#" class="btn_small btn_orangeT btn_200x40T" id="link_apply_event" style="display:none;">发布活动</a>\
        	<span id="changeTemShow" style="display:none;" ><a href="#" class="btn_small btn_grayT btn_200x40T"  id="changeTem"  uidialog="changeTem"  >更换模板</a></span>\
            <a target="_blank" href="#" class="btn_small btn_grayT btn_200x40T" id="link_review_event">预览活动</a>\
        </div>\
    </div>\
    </div>';
    var template_leftmenu = '<div class="global_leftMenu">\
        <div class="menuTitle"><span class="icon icon01"></span>活动信息</div>\
        <div class="menuBody">\
            <dl>\
                <dt class="choose">\
                    <span class="icon menu01"></span>\
                    <a id="dt_jibenxinxi" href="javascript:void(0);" >基本信息</a>\
                    <span class="arrow"></span>\
                </dt>\
                <dt class="choose">\
                    <span class="icon menu01"></span>\
                    <a id="dd_huodongricheng" href="javascript:void(0);" >活动安排</a>\
                    <span class="arrow"></span>\
                </dt>\
                <dt class="choose">\
                    <span class="icon menu01"></span>\
                    <a id="dd_baomingbiao" href="javascript:void(0);">报名表</a>\
                    <span class="arrow"></span>\
                </dt>\
                <dt>\
                    <span class="icon menu04"></span>\
                    <a id="dd_huodongzhuban" href="#">活动主办</a>\
                    <span class="arrow"></span>\
                </dt>\
                <dd>\
                    <a id="dd_yanjiangjiabin" href="javascript:void(0);">嘉宾</a>\
                    <a id="dd_zuzhijigou" href="javascript:void(0);">合作伙伴</a>\
                    <a id="dd_gongzuorenyuan" href="javascript:void(0);">团队成员</a>\
                    <span class="arrow"></span>\
                    <div class="clear"></div>\
                </dd>\
                <dt>\
                    <span class="icon menu04"></span>\
                    <a id="dd_huodongziliao" href="#">活动资料</a>\
                    <span class="arrow"></span>\
                </dt>\
                <dd>\
                    <a id="dd_huodongwenjian" href="javascript:void(0);">活动文件</a>\
                    <a id="dd_huodongxiangce" href="javascript:void(0);">活动相册</a>\
                    <a id="dd_huodongshipin" href="javascript:void(0);">活动视频</a>\
                    <span class="arrow"></span>\
                    <div class="clear"></div>\
                </dd>\
                <dt class="last">\
                    <span class="icon menu01"></span>\
                    <a id="dd_wenzhang" href="#">文章管理</a>\
                    <span class="arrow"></span>\
                </dt>\
            </dl>\
        </div>\
    </div>';
    $(".global_headSec").replaceWith(template_header);
    // add 使用弹出框 by surn 20140917 
    UIdialog();
    $(".global_leftMenu").replaceWith(template_leftmenu);
//    var current_url = get_current_urlname();
//    $(".global_leftMenu").find("dt").removeClass("choose");
//    $(".global_leftMenu").find("a[href*='"+current_url+"']").append("<span></span>").parent().addClass("choose");
    var current_href=window.location.href;
    if(current_href.indexOf('page_edit')!=-1){
    	$("#page_edit").addClass('choose');
    }else if(current_href.indexOf('manage')!=-1){
    	$("#page_manage").addClass('choose');
    }else{
    	$("#page_info").addClass('choose');
    }
    var result_eid = getQueryString("event_id");
    var editTemplateUrl = $("#editTemplate").attr("href");
    displayleftMenu(result_eid);


    if($("#event_header_name").length == 1){
		var event_id = getQueryString("event_id");
		if(event_id && (!isNaN(event_id))){
			$.ajax({ url: js_huodongshu_domain+"/getEventName.do",
				type:"GET",
				async:true,
                dataType:"json",
				data:"check=1&type=1&event_id="+event_id,
				success:function(msg){
				   if(msg=='no exist'){
                		alert('此活动不属于你');
                		window.location.href = '/html/myEvent_create.html';
                		return false;
                   }
//				   if(msg=='2'){
//               		alert('此活动不属于你');
//               		window.location.href = '/html/myEvent_create.html';
//               		return false;
//                  }
				   var name = $.trim(msg.name);
				   if(name.length > 10){
				       name = name.substr(0,10)+'...';
		           }
				   $("#event_header_name").html(name);
				   $("#link_apply_event").show();
				   if(msg.event_status==1){
					   $("#link_apply_event").show();
				   }else if(msg.event_status==2){
					   $("#link_apply_event").remove();
					   $(".headBtn").after('<span class="audit auditing"></span>');
				   }else if(msg.event_status==3){
					   $("#link_apply_event").show();
//					   $("#link_apply_event").remove();
					   $(".headBtn").after('<span class="audit rejected"></span>');
				   }else{
					   $("#link_apply_event").remove();
					   $(".headBtn").after('<span class="audit through"></span>');
				   }
			    }
			});
		}
	}
    
});
//相册下，2014-6-26 9：38
//<a id="dd_huodongshipin" href="javascript:void(0);">活动视频</a>\
function displayleftMenu(eid){
    eid = $.trim(eid);
    if(eid == ''){
        $("#dt_jibenxinxi").attr("href","javascript:void(0);");
        $("#dd_huodongricheng").attr("href","javascript:void(0);");
        $("#dd_baomingbiao").attr("href","javascript:void(0);");
        $("#dd_yanjiangjiabin").attr("href","javascript:void(0);");
        $("#dd_zuzhijigou").attr("href","javascript:void(0);");
        $("#dd_gongzuorenyuan").attr("href","javascript:void(0);");
        $("#dd_huodongwenjian").attr("href","javascript:void(0);");
        $("#dd_huodongxiangce").attr("href","javascript:void(0);");
        $("#dd_huodongshipin").attr("href","javascript:void(0);");
        $("#dd_wenzhang").attr("href","javascript:void(0);");    
        $("#editTemplate").attr("href","javascript:void(0);");
        $("#link_review_event").attr("href","javascript:void(0);");
        
        $("#hds_manage").attr('href',"javascript:void(0);");
    }else{
        $("#hds_manage").attr('href',"/html/manage_order.html?event_id="+eid);
        $("#hds_eventInfo").attr("href","/html/event_base.html?event_id="+eid);
        $("#dt_jibenxinxi").attr("href","/html/event_base.html?event_id="+eid);
        $("#dd_huodongricheng").attr("href","/html/event_agenda.html?event_id="+eid); //??/
        $("#dd_baomingbiao").attr("href","/html/event_register_form.html?event_id="+eid);
        $("#dd_yanjiangjiabin").attr("href","/html/event_jiabin.html?event_id="+eid);
        $("#dd_zuzhijigou").attr("href","/html/event_jigou.html?event_id="+eid);
        $("#dd_gongzuorenyuan").attr("href","/html/event_gongzuorenyuan.html?event_id="+eid);
        $("#dd_huodongwenjian").attr("href","/html/event_wenjian.html?event_id="+eid);
        $("#dd_huodongxiangce").attr("href","/html/event_xiangce.html?event_id="+eid);
        $("#dd_huodongshipin").attr("href","/html/event_video.html?event_id="+eid);
        $("#dd_wenzhang").attr("href","/html/event_article.html?event_id="+eid);
       
        $("#hds_editTemplate").attr("href","/html/template/page_edit.html?page_name=index&op=edit&event_id="+eid);
        $("#link_review_event").attr("href","/minisite/preview.do?page_name=index&event_id="+eid);
        //$("#link_change_template").attr("href","/html/template/list.html?event_id="+eid);
        $("#link_apply_event").attr('href','javascript:apply_event("'+eid+'");');
    }
    
    var current_url = get_current_urlname();
	$(".global_leftMenu").find("dt").removeClass("choose");
	$(".global_leftMenu").find("a[href*='"+current_url+"']").append("<span></span>").parent().addClass("choose");
	$(".global_leftMenu").find("a[href*='"+current_url+"']").append("<span></span>").addClass("choose").addClass("font_red");
}
