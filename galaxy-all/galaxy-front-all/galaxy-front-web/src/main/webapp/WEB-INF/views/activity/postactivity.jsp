<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>创建活动</title>

<!-- 高德地图 -->
<link rel="stylesheet" type="text/css" href="http://developer.amap.com/Public/css/demo.Default.css" />
<script language="javascript" src="http://webapi.amap.com/maps?v=1.3&key=9426c59d80ee61641d95d0407fff22e5"></script>

<link rel="shortcut icon" href="/resources/activity/images/favicon.ico" type="image/x-icon"><link rel="stylesheet" type="text/css" href="/resources/activity/css/global.css" />
<link rel="stylesheet" type="text/css" href="/resources/activity/css/info.css" />
<link rel="stylesheet" type="text/css" href="/resources/activity/css/jquery-ui.css" />
<link rel="stylesheet" href="/resources/activity/js/kindeditor/themes/default/default.css" />
<link rel="stylesheet" type="text/css" href="/resources/activity/js/jquery.datetimepicker.css"/>

<script src="/resources/activity/js/jquery-1.9.1.min.js"></script>
<script src="/resources/activity/js/template/common.js"></script>

<script src="/resources/activity/js/jquery.form.js"></script>
<script src="/resources/activity/js/template/public.js"></script>
<script src="/resources/activity/js/aaa.js"></script>
<script src="/resources/activity/js/pure.js"></script>
<script src="/resources/activity/js/jquery.validate.js"></script>
<script src="/resources/activity/js/jquery.datetimepicker.js"></script>

<script src="/resources/activity/js/manage/manage.json.js"></script>
<script src="/resources/activity/js/template/event_public.js"></script>
<script charset="utf-8" src="/resources/activity/js/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="/resources/activity/js/kindeditor/lang/zh_CN.js"></script>
<!-- add start by surn 20140702 -->


<script type="text/javascript">  

</script>

<script src="/resources/activity/js/account/account.sponsor2.js"></script>
<script src="/resources/activity/js/development/ajaxfileupload.js"></script>
<script charset="utf-8" src="/resources/activity/js/event/event.base.js"></script>
<!-- add by surn 2014/09/01 -->
<script src="/resources/activity/js/development/common.js"></script>




<!-- 2014-6-23 9:43 门票js -->
<script charset="utf-8" src="/resources/activity/js/event/event.ticket.js"></script>




<script>
<!-- 对话框自定义函数 -->
function upLogoDialog(dialog,closeDialog){
    //点击保存按钮
    dialog.find(".dialogSave a.saveBtn").unbind("click").click(function(){
   var choose=$("#tmp_list").find('.choose');
      if(choose.length<1){
          alert('请选择一个系统log'); return ;          
      }else{
          var img_src=choose.find('img').attr('src');
          $("#img_event_logo_src").attr('src',img_src);
          $("#img_event_logo_src_li").removeClass('file');
          $("#img_event_logo_src_li").addClass('form');
          $("#img_event_logo_src_li").addClass('file_ok');
          $("#event_logo_xitong_flag").val(2);
          $("#event_logo_xitong").val(img_src);
      }
        closeDialog();
    })
    
    //点击关闭按钮
    dialog.find(".dialogClose").unbind("click").click(function(){ 
        closeDialog();
    })
     dialog.find(".saveCancel").unbind("click").click(function(){ 
        closeDialog();
    })
}
$(document).ready(function(){
    //testInput();
	panduan_zyc();
})

function testInput(){
    var $div=$('<div style="display:none;"></div>');
    $div.append($("#testInput")).prependTo("form");
}
</script>  

<style>
/* keeditor */
form {margin: 0;}
textarea {display: block; height:500px;}

/* css for timepicker */
.ui-timepicker-div .ui-widget-header { margin-bottom: 8px; }
.ui-timepicker-div dl { text-align: left; }
.ui-timepicker-div dl dt { float: left; clear:left; padding: 0 0 0 5px; }
.ui-timepicker-div dl dd { margin: 0 10px 10px 45%; }
.ui-timepicker-div td { font-size: 90%; }
.ui-tpicker-grid-label { background: none; border: none; margin: 0; padding: 0; }

.ui-timepicker-rtl{ direction: rtl; }
.ui-timepicker-rtl dl { text-align: right; padding: 0 5px 0 0; }
.ui-timepicker-rtl dl dt{ float: right; clear: right; }
.ui-timepicker-rtl dl dd { margin: 0 45% 10px 10px; }
.ui-timepicker-div .ui-widget-header { margin-bottom: 8px; }
.ui-timepicker-div dl { text-align: left; }
.ui-timepicker-div dl dt { float: left; clear:left; padding: 0 0 0 5px; }
.ui-timepicker-div dl dd { margin: 0 10px 10px 40%; }
.ui-timepicker-div td { font-size: 90%; }
.ui-tpicker-grid-label { background: none; border: none; margin: 0; padding: 0; }

.ui-timepicker-rtl{ direction: rtl; }
.ui-timepicker-rtl dl { text-align: right; padding: 0 5px 0 0; }
.ui-timepicker-rtl dl dt{ float: right; clear: right; }
.ui-timepicker-rtl dl dd { margin: 0 40% 10px 10px; }


/* map*/
#allmap {width:100%; height:470px;overflow: hidden;margin:0;}
#l-map{height:100%;width:78%;float:left;border-right:2px solid #bcbcbc;}
#r-result{height:100%;width:20%;float:left;}
.myclass{ height:50px; width:150px; font-size:12px; line-height:22px;}
.bigdiv{ margin-top:10px; float:left; }
.info_baseW .bigdiv{width:670px; }
</style>
</head>

<body id="body_event_base" class="global_icon global_formList global_form global_table info_baseW">


<div id='jia-l-map' style="display:none"></div>
<form id="evnet_base_validateform" name="evnet_base_validateform" method="post" enctype="multipart/form-data" action="/activity/saveEventBase.do" >
<input type="hidden" name="get_address_btn_flag" id="get_address_btn_flag" value='1'>
<input type="hidden" name="editor_text_zyc" id="editor_text_zyc" value='78963'>

<input type="hidden" name="haibaoimg1_update" id='haibaoimg1_update' value='1'>
<input type="hidden" name="haibaoimg2_update" id='haibaoimg2_update' value='1'>
<input type="hidden" name="haibaoimg3_update" id='haibaoimg3_update' value='1'>

<div id="file_log_te" style="display:none">

</div>

<!-- 弹出窗口,活动图片 -->
<div class="global_dialogInfo global_dialogW800" id="upLogo" dialogTitle="选择活动图片" UIscroll="500">
    <div class="info_baseD">
        <div class="file">
            <div class="fileImg"><span><img src="http://pic.4j4j.cn/upload/pic/20130705/be35d8d3d6.jpg" alt=""></span></div>
            <a class="btn_small btn_gray btn_autox40" "href="javascript:void(0)" id="log_chuan_file">浏览上传
                <input type="file"  onchange="event_logo_chuan(this)" name="event_logo"  id="event_logo_name" class="file event_logo_zyc" />
            </a>
            <p class="font_999999">图片尺寸为：640像素x380像素，图片不得超过300K</p>
            <div class="clear"></div>
        </div>
        <!-- <div class="dTitle">为您推荐的模板</div> -->
        <ul class="dialogInfo" id="tmp_list">
            <li ><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/7.jpg"></a></li>
            <li ><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/8.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/9.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/12.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/13.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/15.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/16.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/17.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/20.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/23.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/24.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/25.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/26.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/29.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/30.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/31.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/34.jpg"></a></li>
            <li><a href="javascript:void(0)" onclick="event_tui_logo(this)"><img src="/resources/activity/h5/data/event/event_logo/36.jpg"></a></li>
        </ul>
    </div>
    <div class="dialogSave">
        <a href="javascript:void(0);" class="btn_small btn_gray btn_100x40 saveCancel" id="zyc_cancel">取消</a>
        <a href="javascript:void(0);" class="btn_small btn_green btn_100x40 saveBtn" >保存</a>
    </div>
</div>

<div class="global_head">
    
</div>

<div class="global_headSec">
    
</div>




<input type="hidden" name="event_logo_xitong" id="event_logo_xitong">
<input type="hidden" name="event_logo_xitong_flag" id="event_logo_xitong_flag" value='1'>
<div class="global_width">
    <div class="global_leftMenu">
        
    </div>
  
    <div class="global_right">
            <div class="rightTitle font_green01"><em class="line"></em>基本信息</div>
        <div class="rightBody">
            <div class="info_main info_base" UIselect="click">
                <div class="fList_narrow fListN_80_580">
             
                  <!--活动名称 -->
                <ul>
                    <li class="title">活动名称</li>
                    <li class="form"><input   type="text" class="input_big input_560x40" id="event_name"  name="event_name" /></li>
                    <li class="required">*</li>
                    <li class="tips" id="error_event_name" > </li>
                </ul>
                  <!--活动类型 -->
                 <ul style="display:none;">
                    <li class="title"><span>*</span>活动类型</li>
                    <li class="form">
                        <input id="event_type_2" name="event_type" type="radio" class="radio" value="2" checked="checked" />线下活动　　
                        <input id="event_type_1" name="event_type" type="radio" class="radio" value="1"   />线上活动
                    </li>
                    <li class="tips" id="error_event_type" > </li>
                    <div class="clear"></div>
                </ul>

                <!--时间 -->
                <ul id="ul_event_times" class="eventTimeUl">
                    <li class="title">时间</li>
                    <li class="form">
                        <input id="event_start_time" name="event_start_time" type="text" class="input_big input_263x40" readonly="readonly" />
                        <div class="text">--</div>
                        <input id="event_end_time" name="event_end_time"  type="text" class="input_big input_263x40"  readonly="readonly" />
                    </li>
                    <li class="required">*</li>
                    <li class="tips" id="error_event_times" > </li>
                </ul>
                  


                 <!--活动地点 -->
                <ul id="ul_event_address_name" >
                    <li class="title">地点名称</li>
                    <li class="form"><input   type="text" class="input_big input_560x40" id="event_address_name"  name="event_address_name"/></li>
                    <li class="tips" id="error_event_address_name"></li>
                      <li class="required">*</li>
                </ul>
                <!-- 详细地址 2 -->
                <ul id="ul_select_address">
                    <input type="hidden" id="city_name" name="city_name">
                    <input type="hidden" id="city_id" name="city_id">
                    <input type="hidden" id="district_name" name="district_name">
                    <input type="hidden" id="longitude" value=""  />
                    <input type="hidden" id="latitude" value="" />
                    <li class="title">详细地址</li>
                    <li class="form" id="ul_address_map">
                       <input type="hidden" name="zyx_address_comprare_name" id="zyx_address_comprare_name" value="">
                        <input type="text" id="zxy_zxy" autocomplete="off" onkeydown="gaode_keydown(event)" name="zxy_zxy" class="input_big input_560x40" >
                        <div class="areaDL" style="display:none;z-index:300" id="address_list">

                        </div>
                        <div class="areaDL" style="display:none;z-index:300" id="address_list_real">

                        </div>
                        <div class="bigdiv" id="map_div_bigdiv"  style="width:762px;display:none;">
                             <div id="iCenter" ></div>
                        </div>
                    </li>
                      <li class="required">*</li>
                    <li class="tips" id="error_event_address_info" > </li>
                    <div class="clear"></div>
                </ul>
                <!-- 活动logo  --> 
                 <ul >
                    <li class="title">活动图片</li>
                      <input type='text' name="img_event_log_form_zyc" id="img_event_log_form_zyc" style="position:absolute;left:-200px" value=''/>
                    <li class="form file" id="img_event_logo_src_li">
                         <div class="fileImg">
                               <span> 
                                   <img id="img_event_logo_src" src ="" />
                               </span>
                               </div>
                           <a href="javascript:void(0)"   class="btn_small btn_gray btn_110x30" UIdialog="upLogo">选择图片</a> 
                            <p class="font_999999">图片尺寸为：640像素x380像素，图片不得超过300K</p>
                            <div class="clear"></div>
                         
                         <input type="hidden" name="event_ticket_hidden_info" value=""/>
                         <input type="hidden" name="event_base_hidden_info" value=""/>
                         <input type="hidden" id="event_base_hidden_eid" value=""/>
                         
                    </li>
                    <li class="required">*</li>
                    <li class="tips" id="error_event_logo" > </li>
                    <div class="clear"></div>
                </ul>  
                
                <!-- 主办方 -->
                    <ul class="organizers" id="organizers_id">
                        <li class="title">主办方<input type="hidden" id="event_org_hidden_info" name="event_org_hidden_info" value=""/>
                         <input type="hidden" name="event_org_hidden_info_delorgids" value=""/>
                         <input type='text' name="event_org_hidden_info_y" id="event_org_hidden_info_y" style="position:absolute;left:-820px;border-style:none" value='' />
                        </li>
                        <li class="form" id="img_event_org_src_li">
                            <div class="edit" id="addOrg" style="display:none;">
                                 <input type="hidden" class="input_big input_440x40" id="org_id" name="org_id" value="">
                                 <ul class="">
                                    <li class="form"><input type="text" class="input_big input_440x40" id="org_name" name="org_name" placeholder="主办方名称"></li>
                                    <li class="required">*</li>
                                    <li class="tips"><span class="icon"></span></li>
                                </ul>
                                <ul class="">
                                    
                                    <li class="form file" id="org_form_file">
                                        <div class="fileImg" id="orgFileImg">
                                           <span><img src="" alt="" id="img_test"/></span>
                                        </div>
                                         <a class="btn_small btn_gray btn_110x30" href="javascript:void(0)" id="upload" >主办方logo
                                              <input type="file" class="file" id="event_pic" name="event_pic">
                                         </a>
                                        <input type="hidden" name="filePic" id="filepic" value="">
                                        <p class="font_999999">图片尺寸为：300像素x180像素，图片不得超过150K</p>
                                        <div class="clear"></div>
                                    </li>
                                    
                                    <li class="required">*</li>
                                    <li class="tips"><span class="icon"></span></li>
                                </ul>
                                <ul class="">
                                    <li class="form"> <textarea name="org_description" id="org_description" cols="" rows="" class="textarea_440x150" placeholder="主办方简介"></textarea ></li>
                                    <li class="required">*</li>
                                    <li class="tips"><span class="icon"></span></li>
                                </ul>
                                <ul>
                                     <li class="form">
                                     <a href="javascript:void(0);" onclick="javascript:account_sponsor_save();" class="btn_small btn_green btn_autox40" id="jsSub" >保存</a>
                                     <a href="javascript:void(0);" class="btn_small btn_gray btn_autox40 " id="subTopicOff" onclick="javascript:subTopicOff();">取消</a>
                                    </li>
                                </ul>
                            
                            
                            
                            </div>
                            <div class="clear"></div>
                             <div class="btnBox" id="addOrgMenu"><a href="javascript:void(0);"  onclick ="javascript:spliceAwardHtml();" class="btn_small btn_gray btn_110x30">添加主办方</a></div>
                           
                        </li>
                        <li class="required"  id="orgImportId">*</li>
                        <li class="tips" id="error_organizers"></li>
                    </ul>
                
                <!--咨询电话 -->
                <ul id="ul_event_refer_telephone" >
                    <li class="title">咨询电话</li>
                    <li class="form"><input   type="text" placeholder="咨询电话最多两个,支持手机、400电话及座机如18900000000;400-600-0000" maxlength='50' class="input_big input_560x40" id="event_refer_telephone"  name="event_refer_telephone"/></li>
                    <li class="required">*</li>
                    <li class="tips" id="error_event_refer_telephone"></li>
                </ul>
                
                 <!-- 活动简介-->
                <ul> 
                   <li class="title">活动简介</li>
                   <li class="form"><textarea  name="huodongjianjie"  placeholder="活动简介" class="textarea_548x150"> </textarea></li>
                    <li class="required">*</li>
                     <li class="tips" id="error_event_jianjie"></li>
                    <div class="clear"></div>
                </ul>
               
               
                
                 <!-- 活动详情 -->
                <ul id="edtior_ul"> 
                  <span style="position:absolute;left:-200px;"><input type="text" name='editor_content_hidden' id="editor_content_hidden" value=''/></span>
                   <li class="title">活动详情</li>
                   <li class="form form_zyc"  id="textarea_cont"><textarea id="reportContent" placeholder="活动详情" name="reportContent" class="textarea_430x150"> </textarea></li>
                   <!-- <li class="required">*</li> -->
                    <li class="tips" id="error_event_reportContent" > </li>
                    <div class="clear"></div>
                </ul>
                
                   <!-- 邀请海报  --> 
                     <ul class="error">
                        <li class="title">邀请海报</li>
                        <li class="form file" id="haibao_img_li">
                              <div id="haibao_list">
                               
                              </div>
                          
                            <a class="btn_small btn_gray btn_110x30" href="javascript:void(0)"  id="haibao_file_list">上传海报
                             <input type="file" onchange="haibao_chuan(this)" name="eventhaibao_logo1" id="haibao1_file" class="file zyc_file">
                             <input type="file" onchange="haibao_chuan(this)" name="eventhaibao_logo2" style="display:none" id="haibao2_file" class="file zyc_file ">
                             <input type="file" onchange="haibao_chuan(this)" name="eventhaibao_logo3" style="display:none" id="haibao3_file" class="file zyc_file">
                             </a>
                            <p class="font_999999" id="haibao_file_list_p">最多3张海报,尺寸为：900x1200像素  ,图片不得超过500K</p>
                            <div class="clear"></div>
                        </li>
                        <div class="clear"></div>
                    </ul> 
                    <!-- 活动海报  --> 
                
                
                
                 </div>
             
                <div class="clear"></div>
            </div>
            
            
            
            
          <!-- 门票信息开始 -->
           <div class="info_title font_green01"><em class="line"></em>门票创建</div>
            <div class="info_main info_base" uiselect="click">
                <!-- 门票表格 -->
                <table style="width:100%" class="mt20">
                    <thead>
                        <tr>
                            <th width="50">移动</th>
                            <th width="">门票名称</th>
                            <th width="50">数量</th>
                            <th width="100">价格</th>
                            <th width="150">售票状态</th>
                            <th width="50">操作</th>
                        </tr>
                    </thead>
                    <tbody id="ticket_info">
                        <tr width="100%" style="display:none">
                            <td width="50" class="movebar input"><span class="icon25"><b></b></span></td>
                            <td width="" class="input"><div class="inputDiv"><input name="name" type="text" tid='0'  class="input" value=""><span style="display:none">门票</span></div></td>
                            <td width="50" class="input"><div class="inputDiv"><input name="qty" saleqty="0" type="text" onblur="totalNum()" class="input" value=""><span style="display:none">10</span></div></td>
                            <td width="100" class="input"><div class="inputDiv"><input name="price" type="text" class="input" value=""><span style="display:none">免费</span></div></td>
                            <td width="150" class="dl input">
                             <div class="select">
                                <span class="arrow"></span>
                                <div class="bar ticstatus">正常售票</div>
                                <div class="downlist" style=""><input name="edit" value="" type="hidden" />
                                    <ul uiscroll="200">
                                        <li >正常售票</li>
                                        <li >暂停售票</li>
                                    </ul>
                                </div>
                            </div>
                            </td>
                            <td width="50" class="operate">
                                <a title="设置" class="icon14 myedit" href="javascript:void(0)"><span class="icon14"></span></a><a title="删除" class="icon04 mydel" href="javascript:void(0)"><span class="icon04"></span></a>
                            </td>
                        </tr>
                      
                        <tr name="edit" style="display:none">
                            <td colspan="6" class="ticketSet">
                                <div class="fList_narrow fListN_100_460">
                                    <ul class="eventTimeUl">
                                    <li class="title">销售时间</li>
                                    <li class="form">
                                        <input type="text" id="start_time" name="event_start_time" value="" class="input_big input_200x40 input_inline">
                                        <div class="text">--</div>
                                        <input type="text" id="end_time" name="event_end_time" value="" class="input_big input_200x40 input_inline">
                                    </li>
                                    <div class="clear"></div>
                                </ul>
                                <ul class="limit">
                                    <li class="title">每单限购</li>
                                    <li class="form">
                                        <span>每单最少<input name="limit_min" type="text" class="input_big input_60x40" value="">张</span>
                                        <span>每单最多<input name="limit_max" type="text" class="input_big input_60x40" value="">张</span>
                                    </li>
                                    <div class="clear"></div>
                                </ul>
                                <ul class="">
                                    <li class="title">门票描述</li>
                                    <li class="form">
                                        <textarea class="textarea_400x150" rows="" cols="" id="description" name="description"></textarea>
                                        <p class="font_999999" style="height:16px;line-height:16px;padding-top:10px;"><input name="if_hide_desc" type="checkbox" value="1"  />在活动页面隐藏此文字</p>
                                    </li>
                                    <div class="clear"></div>
                                </ul>
                                 <ul class="text">
                                    <li class="title">门票需要审批</li>
                                    <li class="form radioBox">
                                        <span>
                                            <input name="need_approve" type="radio" class="radio" value="1" />是
                                        </span>
                                        <span>
                                            <input name="need_approve" checked="checked"  type="radio" class="radio" value="2" />否
                                        </span>
                                    </li>
                                    <div class="clear"></div>
                                </ul>
                                </div>
                                
                                <div class="btnBox">
                                    <a id="editSave" class="btn_big btn_orange btn_autox40" href="javascript:void(0)">保存</a>
                                    <a id="editCancel" class="btn_big btn_gray btn_autox40" href="javascript:void(0)">取消</a>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                    <tfoot>
                        <tr id="menpiao">
                            <td colspan="6"  class="baseTfoot">
                                <div class="leftTotal"> <span>添加：</span>
                                    <a id="shoufei" class="btn_small btn_orange btn_autox40 btn_icon" href="javascript:void(0)"><span class="icon31" > 
                                    </span>收费门票
                                </a>
                                <a id="mianfei" class="btn_small btn_green btn_autox40 btn_icon" href="javascript:void(0)"><span class="icon31" >
                                    </span>免费门票
                                </a></div>
                                <div class="rightOppr"  id="totalnum">
                                               总数量：0
                                </div>
                            </td>  
                        </tr>
                    </tfoot>
                </table>
                <div class="billSet" style="display: none;">
                    <dl>
                        <dt><input id="mystatus" name="mystatus" type="checkbox" value="10" />为参会者提供发票</dt>
                        <dd id="fapiao" style="display:none;">
                            <span><input name="status" type="checkbox" checked="ch" value="1" />普通发票</span>
                            <span><input name="status" type="checkbox" value="2" />增值税发票</span>
                        </dd>
                    </dl>
                </div>
                <div class="clear"></div>
            </div>
           
           <!-- 门票信息结束 -->


            
            <div class="info_title font_green01"><span class="line"></span>推广设置</div>
            <div class="info_main"> 
                 <div class="fList_wide fListW_80_440_170">
                
                  <!--活动隐私2 -->
                <ul>
                    <li class="title">活动隐私</li>
                    <li class="form yinSi">
                        <div class="">
                            <input  id="event_yinsi_1" name="event_yinsi" value="1" type="radio" class="radio" />公开<span class="font_999999">（发布到活动树平台）</span>
                        </div>
                        <div class="">
                            <div class="left">
                                <input  id="event_yinsi_2" name="event_yinsi"   value="2"  type="radio" class="radio" checked="checked"/>不公开<span class="font_999999">（只有知道网址才能访问）</span>
                            </div>
                            <div class="sheZhi" style="display:none;">
                                <span class="label">设置密码</span>
                                <input type="text" class="input_big input_200x40"  value="" id="event_passwd"  name="event_passwd" style="width:100px;">
                            </div>
                            <div class="clear"></div>
                        </div>
                    </li>
                </ul>
                
                    <!-- 活动分类 新版-->
                    <ul id="ul_category_type" class="error">
                        <li class="title">活动分类</li>
                        <li class="form"  UIselect="click">
                            <div class="select select_big select_w150" selectcallback="categoryMethod">
                               <span class="arrow"></span>
                                <div class="bar" id="category_getOptionId" category_select_type="0">--请选择--</div>
                                <input name="category_type" value="0" type="hidden" id="category_type" />
                                <div class="downlist" style="">
                                    <ul id="event_category_grade1" uiscroll="120">

                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li class="tips" id="ul_category_type_error"></li>
                        <input name="category_select_required" type="text" style="position:absolute;left:-520px;border-style:none" value="0" id="category_select_required">
                    </ul>
                    
                 <!--推广关键字-->
                <ul style="display:none;">
                    <li class="title">活动标签</li>
                    <li class="form"><input type="text" class="input_big input_400x40" id="event_keyword" name="event_keyword" /></li>
                    <li class="tips" id="error_event_keyword" > </li>
                    <div class="clear"></div>
                </ul>
                </div>
                <div class="clear"></div>
            </div>
            
             <div class="global_form"> 
                <div class="info_save"><a  class="btn_big btn_orange btn_autox60" href="javascript:void(0)"  onclick="event_base_save(this);" >保存</a></div>
             </div>
           
        </div>
        
    </div>
    <div class="clear"></div>
</div>
</form>
    
</body>
</html>
