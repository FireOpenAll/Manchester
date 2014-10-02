var map_point_info = '';


/**高德地图*/
var mapObj,toolBar;
var windowsArr = [];
var marker = [];
$(function(){
	mapInit();
	$("#map_div_bigdiv").hide(); 
})
function mapInit() {
	var event_id=$.trim(getQueryString('event_id'));
	if(event_id){
		$("#map_div_bigdiv").attr("style","width:562px;");
	}else{
		$("#map_div_bigdiv").attr("style","width:760px;");
	}
    mapObj = new AMap.Map("iCenter", {
        view: new AMap.View2D({
            center:new AMap.LngLat(116.397428,39.90923),//地图中心点
            zoom:15//地图显示的缩放级别
        }),
        keyboardEnable:false
    });
    mapObj.plugin(["AMap.ToolBar"],function(){		
		toolBar = new AMap.ToolBar();
		mapObj.addControl(toolBar);		
	});
    toolBar.show()
     
    mapObj.setStatus({scrollWheel:false});
   // document.getElementById("keyword").onkeyup = keydown;
}
//输入提示
function autoSearch() { 
    var keywords =$.trim($("#zxy_zxy").val());
      if(keywords==''){
    	  return false;
      }
    var auto; 
    //加载输入提示插件
        mapObj.plugin(["AMap.Autocomplete"], function() {
        var autoOptions = {
            city: "" //城市，默认全国
        };
        auto = new AMap.Autocomplete(autoOptions);
        //查询成功时返回查询结果
        if ( keywords.length > 0) { 
        	$("#address_list").html('');
        	$('#address_list_real').html('');
            AMap.event.addListener(auto,"complete",autocomplete_CallBack);
            auto.search(keywords);
        }
        else {
            //document.getElementById("result1").style.display = "none";
        }
    });
}

//输出输入提示结果的回调函数
function autocomplete_CallBack(data) { 
    var resultStr = "";
    var tipArr = data.tips;
    if (tipArr&&tipArr.length>0) {                
        for (var i = 0; i < tipArr.length; i++) {
            resultStr += "<dl id='divid" + (i + 1) + "'  onclick='selectResult(" + i + ")'  style=\"font-size: 13px;cursor:pointer;padding:5px 5px 5px 5px;\"" + "data=" + tipArr[i].adcode + ">" + tipArr[i].name + "<span style='color:#C1C1C1;'>"+ tipArr[i].district + "</span></dl>";
        }
    }
    else  {
        resultStr = " π__π 亲,人家找不到结果!<br />要不试试：<br />1.请确保所有字词拼写正确<br />2.尝试不同的关键字<br />3.尝试更宽泛的关键字";
    }
     $("#address_list").html(resultStr);
     $("#address_list").show();
}

function gaode_keydown(event){
    var key = (event||window.event).keyCode;
    if(key===40){//down
       
    }else if(key===38){//up
     
    }else if(key === 13){
       
    }else{
        autoSearch();
    }
}

//从输入提示框中选择关键字并查询
function selectResult(index) {
    if(index<0){
        return;
    }
    if (navigator.userAgent.indexOf("MSIE") > 0) {
        document.getElementById("zxy_zxy").onpropertychange = null;
    }
    //截取输入提示的关键字部分
    var text = document.getElementById("divid" + (index + 1)).innerHTML.replace(/<[^>].*?>.*<\/[^>].*?>/g,""); 
    var cityCode = document.getElementById("divid" + (index + 1)).getAttribute('data');
    document.getElementById("zxy_zxy").value = text;
    
    //根据选择的输入提示关键字查询
    mapObj.plugin(["AMap.PlaceSearch"], function() {      
        var msearch = new AMap.PlaceSearch();  //构造地点查询类
        AMap.event.addListener(msearch, "complete", placeSearch_CallBack); //查询成功时的回调函数
        msearch.setCity(cityCode);
        msearch.search(text);  //关键字查询查询
    });
}

//输出关键字查询结果的回调函数
function placeSearch_CallBack(data) {
    //清空地图上的InfoWindow和Marker
    windowsArr = [];
    marker     = [];
    mapObj.clearMap();
    var resultStr1 = "";
    var poiArr = data.poiList.pois;
   // console.dir(poiArr);return;
    var resultCount = poiArr.length;
    for (var i = 0; i < resultCount; i++) {
        resultStr1 += "<dl id='divid" + (i + 1) + "' onclick='addmarker(\""+poiArr[i].location.lng+"\",\""+poiArr[i].location.lat+"\",\""+poiArr[i].name+"\",\"1\");' onmouseout='onmouseout_MarkerStyle(" + (i + 1) + ",this)' style=\"font-size: 12px;cursor:pointer;padding:0px 0 4px 2px; border-bottom:1px solid #C1FFC1;\"><table width=560><tr>" + "<td><h3><font color=\"#00a6ac\">名称: " + poiArr[i].name + "</font></h3>";
            resultStr1 += poiArr[i].address + "</td></tr></table></dl>";
            //addmarker(i, poiArr[i]);
    }   
    mapObj.setFitView();
    $('#address_list').hide();
    $('#address_list_real').html(resultStr1);
    $('#address_list_real').show(); 
}


//输入提示框鼠标移出时的样式
function onmouseout_MarkerStyle(pointid, thiss) {  //鼠标移开后点样式恢复
  thiss.style.background = "";
}



//添加查询结果的marker&infowindow  
function addmarker( lng,lat,address,flag) {	
	var event_id=$.trim(getQueryString('event_id'));
	if(event_id){
		$("#map_div_bigdiv").attr("style","width:562px;");
	}else{
		$("#map_div_bigdiv").attr("style","width:760px;");
	}
	if(flag==1){
		$("#get_address_btn_flag").val('2');
	}
	 $("#zxy_zxy").val(address);
	 $("#address_list_real").hide();
    var lngX = lng;
    var latY = lat;
    $("#longitude").val(lng);
	$("#latitude").val(lat);   
    
	var lnglatXY = new AMap.LngLat(lngX,latY);
	 var MGeocoder;
	    //加载地理编码插件
	    mapObj.plugin(["AMap.Geocoder"], function() {        
	        MGeocoder = new AMap.Geocoder({ 
	            radius: 1000,
	            extensions: "all"
	        });
	        //返回地理编码结果 
	        AMap.event.addListener(MGeocoder, "complete", geocoder_CallBack); 
	        //逆地理编码
	        MGeocoder.getAddress(lnglatXY); 
	    });
	    //加点
	    var marker = new AMap.Marker({
	        map:mapObj,
	        icon: new AMap.Icon({
	            image: "http://api.amap.com/Public/images/js/mark.png",
	            size:new AMap.Size(58,30),
	            imageOffset: new AMap.Pixel(-32, -0)
	        }),
	        position: lnglatXY,
	        offset: new AMap.Pixel(-5,-30)
	    });
	    mapObj.setFitView();
	    mapObj.setZoom(15);
	 $("#map_div_bigdiv").show();  
}

//回调函数
function geocoder_CallBack(data) {
	var city=data.regeocode.addressComponent.city;
	if(city==''){
		$("#city_name").val(data.regeocode.addressComponent.province);
	}else{
		$("#city_name").val(data.regeocode.addressComponent.city);
	}
	
	//console.dir(data);
	//alert(11);
 //var	address = data.regeocode.formattedAddress;
 //alert(address);
//	console.dir(data);
 
}  
/**高德地图*/






/**zyc 异步判断*/
function  panduan_zyc(){
	var event_id = getQueryString("event_id");
	if(event_id && (!isNaN(event_id))){
		var url=js_huodongshu_domain+"/getEventName.do";
		var n={};
		n.type=1;
		n.check=1;
		n.event_id=event_id;
		$.ajax({
			type: "POST",
			url: url,
			data: n,
			async:true,
			success: function(info) {
				var info=JSON.parse(info);
				if(info.status==2){  //成功
					alert('此活动不属于你');
					window.location.href = '/html/myEvent_create.html';
					return false;
				}else{
					load_event_base_page(event_id);
				}
			}
		})

	}
}


/**活动logo图片上传*/
function  event_logo_chuan(b){
	hds_preview_pic(b,'img_event_logo_src','img_event_logo_src_li');//图片预览
	$("#event_logo_xitong_flag").val(3);
	$("#img_event_logo_src_li").removeClass('file');
	//$("#img_event_logo_src_li").addClass('file_oks');
	$("#img_event_logo_src_li").addClass('file_ok');
	$("#zyc_cancel").trigger('click');
	//alert($("#log_chuan_file").html());
	//$("#log_chuan_file").html($("#event_logo_name"));
	var file_zhi=$("#event_logo_name");
	$("#file_log_te").html(file_zhi);
}
/**活动推荐logo*/
function event_tui_logo(b){
	$("#tmp_list li").removeClass('choose');
	$(b).parent().addClass('choose');
}
/**海报删除*/
function haibao_del(num,b){
	$(b).parent().parent().remove();
	$('.zyc_file').hide();
	var   file_id="haibao"+num+'_file';
	var  file_name='eventhaibao_logo'+num;
	$("#"+file_id).remove();
	var html='<input type="file" onchange="haibao_chuan(this)" style="display:block" name="'+file_name+'" id="'+file_id+'" class="file zyc_file">';
	$('#haibao_file_list').append(html);
	$('#haibao_file_list_p').show();
	$('#haibao_file_list').show();
	$("#haibaoimg"+num+"_update").val(3);
	if($("#haibao1_img").length==0 && $("#haibao2_img").length==0 && $("#haibao3_img").length==0){
		$("#haibao_img_li").addClass('file');
		$("#haibao_img_li").removeClass('file_ok');
		$("#haibao_img_li").removeClass('file_oks');
	}
}
/**海报上传*/
function haibao_chuan(b){
	var  haibao_id=''; var num='';
	if($("#haibao1_img").length==0 && $("#haibao2_img").length==0 && $("#haibao3_img").length==0){
		num=1;	haibao_id='haibao1_img';	    $('.zyc_file').hide();	$("#haibao1_file").show();
	}else if($("#haibao1_img").length>0 && $("#haibao2_img").length==0 && $("#haibao3_img").length==0){
		num=2;	haibao_id='haibao2_img';    $('.zyc_file').hide();	$("#haibao2_file").show();
	}else if($("#haibao1_img").length==0 && $("#haibao2_img").length>0 && $("#haibao3_img").length==0){
		num=1; haibao_id='haibao1_img';    $('.zyc_file').hide();	$("#haibao1_file").show();
	}else if($("#haibao1_img").length==0 && $("#haibao2_img").length==0 && $("#haibao3_img").length>0){
		num=1; haibao_id='haibao1_img';     $('.zyc_file').hide();	$("#haibao1_file").show();
	}else if($("#haibao1_img").length>0 && $("#haibao2_img").length>0 && $("#haibao3_img").length==0){
		num=3; haibao_id='haibao3_img';     $('.zyc_file').hide();	$("#haibao3_file").show();
	}else if($("#haibao1_img").length==0 && $("#haibao2_img").length>0 && $("#haibao3_img").length>0){
		num=1; haibao_id='haibao1_img';     $('.zyc_file').hide();	$("#haibao1_file").show();
	}else if($("#haibao1_img").length>0 && $("#haibao2_img").length==0 && $("#haibao3_img").length>0){
		num=2; haibao_id='haibao2_img';     $('.zyc_file').hide();	$("#haibao2_file").show();
	}else if($("#haibao1_img").length>0 && $("#haibao2_img").length>0 && $("#haibao3_img").length>0){
		alert('最多只能上传3张海报！');  return false;
	}
	var html='<div class="fileImgOuter">\
                    <div class="icon_box">\
                         <a href="javascript:void(0)" onclick="haibao_del('+num+',this)" class="icon"></a>\
                   </div>\
		           <div class="fileImg"><span><img id="'+haibao_id+'" src="" /></span></div>\
                   </div>';
	$("#haibao_list").append(html);
	haibao_btn_show_hide();
	hds_preview_pic(b,haibao_id,'123');

	$("#haibao_img_li").removeClass('file');
	$("#haibao_img_li").addClass('file_ok');
	$("#haibao_img_li").addClass('file_oks');
}

/**海报浏览上传按钮的显示和隐藏*/
function  haibao_btn_show_hide(){
	if($("#haibao1_img").length==0 && $("#haibao2_img").length==0 && $("#haibao3_img").length==0){
		$('.zyc_file').hide();	$("#haibao1_file").show();
	}else if($("#haibao1_img").length>0 && $("#haibao2_img").length==0 && $("#haibao3_img").length==0){
		$('.zyc_file').hide();	$("#haibao2_file").show();
	}else if($("#haibao1_img").length==0 && $("#haibao2_img").length>0 && $("#haibao3_img").length==0){
		$('.zyc_file').hide();	$("#haibao1_file").show();
	}else if($("#haibao1_img").length==0 && $("#haibao2_img").length==0 && $("#haibao3_img").length>0){
		$('.zyc_file').hide();	$("#haibao1_file").show();
	}else if($("#haibao1_img").length>0 && $("#haibao2_img").length>0 && $("#haibao3_img").length==0){
		;     $('.zyc_file').hide();	$("#haibao3_file").show();
	}else if($("#haibao1_img").length==0 && $("#haibao2_img").length>0 && $("#haibao3_img").length>0){
		$('.zyc_file').hide();	$("#haibao1_file").show();
	}else if($("#haibao1_img").length>0 && $("#haibao2_img").length==0 && $("#haibao3_img").length>0){
		$('.zyc_file').hide();	$("#haibao2_file").show();
	}else if($("#haibao1_img").length>0 && $("#haibao2_img").length>0 && $("#haibao3_img").length>0){
		$('#haibao_file_list').hide();$('#haibao_file_list_p').hide();
	}
}







/**zyc*/

$(document).ready(function(){


	//时间
	$('#event_start_time,#event_end_time').datetimepicker();

	var result = getQueryString("event_id");
	result = $.trim(result);
	if(result != ''){
		$("#body_event_base").attr("class","global_formList global_form global_icon global_table");
		$("#allmap").css("height","350px");
		//$("#map_div_bigdiv").attr("style","width:562px;height:370px;");
		$("#event_base_hidden_eid").val(result);
	}



	//活动类型
	load_event_type();
	//活动隐私
	//load_event_yinshi();

	//加载区域地址
	//changeLevel(1,'level',"event_uladdress_grade1");
	//changeLevel2(1,'level',"select_address_grade1");

	//加载活动分类
	event_category_list(1,'level',"select_category_grade1");

	//表单验证
	myformvalidate();


	//获取参数


	if(result == ''){//创建
		//地图
		//	loadmap(116.25788391122,39.976275091642);
	}else{
		//	/load_event_base_page(result);
	}
	var errormessage = getQueryString("errormessage");
	errormessage = $.trim(errormessage);
	if(errormessage != ''){
		alert(errormessage);
		var url = '/html/event_base.html';
		if(result != ''){
			url += '?event_id='+result;
		}
		document.location.href = url;
	}
	//提示



});//end document.ready

//编辑框
var editor;



KindEditor.ready(function(K) {
	editor = K.create('#textarea[name="reportContent"]', {
		cssPath : 'js/kindeditor/plugins/code/prettify.css',
		//    uploadJson : js_huodongshu_domain+'/keupload.do',
		//    fileManagerJson : 'js/kindeditor/php/file_manager_json.php',
		allowFileManager : false,
		width : '100%', //编辑器的宽度为70%
		height:"350px",
		items : [
		'undo', 'redo','|','fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
		'cut', 'copy', 'paste','plainpaste', 'wordpaste', 'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
		'insertunorderedlist','indent', 'outdent','|', 'emoticons', 'link','preview','fullscreen'],
		afterCreate : function() {
			var self = this;
			K.ctrl(document, 13, function() {

			});
			K.ctrl(self.edit.doc, 13, function() {

			});
		},
		afterBlur: function(){this.sync();}
	});
	var result = getQueryString("event_id");
	result = $.trim(result);
	if(result == ''){
		$("div[class='ke-container ke-container-default']").attr("style","width:758px;");
	}else{
		$("div[class='ke-container ke-container-default']").attr("style","width:558px;");
	}
})


//活动类型
function load_event_type(){
	var val = $("input[name='event_type']:checked").val();
	if(val == 1){
		$("#ul_event_module").hide();
		$("#ul_event_times").hide();
		$("#ul_event_address_name").hide();
		$("#ul_select_address").hide();
		$("#ul_address_map").hide();
	}else{
		$("#ul_event_module").show();
		$("#ul_event_times").show();
		$("#ul_event_address_name").show();
		$("#ul_select_address").show();
		$("#ul_address_map").show();
	}
	$("input[name='event_type']").click(function(o){
		var val = $("input[name='event_type']:checked").val();
		if(val == 1){
			$("#ul_event_module").hide();
			$("#ul_event_times").hide();
			$("#ul_event_address_name").hide();
			$("#ul_select_address").hide();
			$("#ul_address_map").hide();
		}else{
			$("#ul_event_module").show();
			$("#ul_event_times").show();
			$("#ul_event_address_name").show();
			$("#ul_select_address").show();
			$("#ul_address_map").show();
		}
	});
}
//活动隐私
function load_event_yinshi(){
	var val = $("input[name='event_yinsi']:checked").val();
	if(val == 2){
		$("#ul_event_passwd").show();
	}else{
		$("#ul_event_passwd").hide();
	}
	$("input[name='event_yinsi']").click(function(o){
		var val = $("input[name='event_yinsi']:checked").val();
		if(val == 2){
			$("#ul_event_passwd").show();
		}else{
			$("#ul_event_passwd").hide();
		}
	});
}





//保存活动基本信息
function event_base_save(obj){
	/*zyc用于logo图片验证*/
	var img_event_logo_src_te = $.trim($("#img_event_logo_src").attr('src'));
	
	
	alert('img_event_logo_src_te'+img_event_logo_src_te);
	
	// alert(img_event_logo_src_te);
	$("#img_event_log_form_zyc").val(img_event_logo_src_te);

	var event_ticket_hidden_info = getTicketInfo() ;
	
	alert('event_ticket_hidden_info'+event_ticket_hidden_info);


	$("input[name='event_ticket_hidden_info']").val(event_ticket_hidden_info);

	//add by surn 20140827
	var event_org_hidden_info = "";
	if (orgJson1 != "" ) {
		event_org_hidden_info +=orgJson1;
	}
	if (orgJson2 != "" ) {
		event_org_hidden_info +=orgJson2;
	}
	if (orgJson3 != "" ) {
		event_org_hidden_info +=orgJson3;
	}
	event_org_hidden_info = "["+event_org_hidden_info.substr(0,(event_org_hidden_info.length - 1))+"]";

	$("input[name='event_org_hidden_info']").val(event_org_hidden_info);
	$("input[name='event_org_hidden_info_delorgids']").val(delOrgIds);
	$("input[name='event_org_hidden_info_y']").val(event_org_hidden_info);
	//if(event_org_hidden_info == '[]'){ showError($("#orgImportId"), '请输入主办方'); return false;}
	//	type = $.trim(type);
	//	if(type == 'prepare'){
	//		$("#evnet_base_validateform").submit();
	//
	//	}else{
	$(obj).attr("disabled","disabled");
	//		var event_theme_xilie = $("#event_theme_xilie").val();
	var event_name = $("#event_name").val();
	
	//alert('活动名称：'+event_name);

	var event_type = $("input[name='event_type']:checked").val();
	//	    var event_module_type  = $("input[name='event_module_type']:checked").val();

	var event_start_time = $("#event_start_time").val();
	var event_end_time = $("#event_end_time").val();
	
	//alert('开始时间：'+event_start_time+',结束时间：'+event_end_time);

	var event_address_name = $("#event_address_name").val();
	//	    var event_address_grade1 = $("#event_address_grade1").html();
	//	    var event_address_grade2 =  $("#event_address_grade2").html();
	//	    var event_address_grade3 =  $("#event_address_grade3").html();
	var select_address_grade1 =  $("#select_address_grade1").val();
	var select_address_grade2 =  $("#select_address_grade2").val();
	var select_address_grade3 =  $("#select_address_grade3").val();
	var event_address_info = $("#zxy_zxy").val();  //详细地址,zyc 修改
	var event_longitude = $("#longitude").val();
	var event_latitude = $("#latitude").val();



	var event_yinsi = $("input[name='event_yinsi']:checked").val();
	var event_passwd = $("#event_passwd").val();

	var event_category1 = $("#select_category_grade1").val();//$("#event_category1").html();
	var event_category2 =  $("#select_category_grade2").val();//$("#event_category2").html();

	//	    var event_support_share = $("input[name='event_support_share']:checked").val();
	var event_keyword = $("#event_keyword").val();

	//  var editor_text = editor.text();
	//  editor_text = huodongshu_process_forjson(editor_text);
	var description = $("textarea[name='huodongjianjie']").val();
	description =  huodongshu_process_forjson(description);
	description = $.trim(description);
	var event_id = $("#event_base_hidden_eid").val();
	event_id = $.trim(event_id);

	var event_refer_telephone = $("input[name='event_refer_telephone']").val();
	event_refer_telephone = $.trim(event_refer_telephone);

	//	    var event_limit_num = $("#event_limit_num").val();

	var template_id = getQueryString("template_id");
	template_id = template_id?template_id:1;

	var category_type = $("#category_type").val();

	/**zyc*/
	var city_name=$("#city_name").val();
	var  address_flg=$("#get_address_btn_flag").val();
	var  zyx_address_comprare_name=$("#zyx_address_comprare_name").val();
	//alert(zyx_address_comprare_name); alert(event_address_info);alert(address_flg);
	if(address_flg=='1' && zyx_address_comprare_name!=event_address_info){
		city_name=''; 
		event_longitude='-1';
		event_latitude='-1';
	}
	//alert(event_longitude);alert(event_latitude);return;
	/**zyc*/

	var eventbaseinfo =  '{'+
	//	       '"event_theme_xilie":"'+event_theme_xilie +'",'+
	'"event_name":"'+event_name+'",'+
	'"event_type":"'+event_type+'",'+
	'"city_name":"'+city_name+'",'+                 //zyc临时修改
	//	       '"event_module_type":"'+event_module_type+'",'+
	'"event_start_time":"'+event_start_time+'",'+
	'"event_end_time":"'+event_end_time+'",'+
	'"event_address_name":"'+event_address_name+'",'+
	'"select_address_grade1":"'+select_address_grade1+'",'+
	'"select_address_grade2":"'+select_address_grade2+'",'+
	'"select_address_grade3":"'+select_address_grade3+'",'+
	'"event_longitude":"'+event_longitude+'",'+
	'"event_latitude":"'+event_latitude+'",'+
	'"event_id":"'+event_id+'",'+
	'"event_address_info":"'+event_address_info+'",'+
	'"refer_telephone":"'+event_refer_telephone+'",'+
	'"event_yinsi":"'+event_yinsi+'",'+
	'"event_passwd":"'+event_passwd+'",'+
	'"event_category1":"'+category_type+'",'+
	'"event_category2":"'+event_category2+'",'+
	'"map":"'+map_point_info+'",'+
	//	       '"event_support_share":"'+event_support_share+'",'+
	'"event_keyword":"'+event_keyword+'",'+
	//	       '"limit_num":"'+event_limit_num+'",'+
	'"template_id":"'+template_id+'",'+
	'"description":"'+description+'"'+
	// '"editor_text":"'+editor_text+'"'+
	'}';
   // alert(eventbaseinfo);return;
	alert('eventbaseinfo:'+eventbaseinfo);
	
	$("input[name='event_base_hidden_info']").val(eventbaseinfo);
	var editor_text = editor.html();
	$("#editor_text_zyc").val(editor_text);
	alert('editor_text:'+editor_text);
	
	$(obj).attr("disabled",false);
	$("#evnet_base_validateform").submit();
	
}

//加载活动信息页面
function load_event_base_page(event_id){
	var eventbaseinfo = '{"event_id":"'+event_id+'"}';
	var url = js_huodongshu_domain+"/event/loadevent.do";
	$.ajax({ url: url,
	type:"POST",
	dataType:"json",
	data:'event_id='+event_id,
	success:function(msg){
		if(msg.status == 0){
			alert(msg.msg);
		}else{
			$("#city_name").val(msg.data.city_name);
			$("#zxy_zxy").val(msg.data.address);
			$("#zyx_address_comprare_name").val(msg.data.address);
			$("#city_id").val(msg.data.cityid);
			//	        	  $("#event_theme_xilie").val(msg.data.topic);
			$("#event_name").val(msg.data.name);
			//	              $("#event_limit_num").val(msg.data.limit_num);


			//	              $("input[name='event_type']:checked").val(msg.data.type);
			//	              $("input[name='event_type'][value='"+msg.data.type+"']").attr("checked","checked");
			//	              $("input[name='event_type']").val(msg.data.type);
			//	              $("input[name='event_type'][value='"+msg.data.type+"']").attr("checked","checked");
			//	              load_event_type();
			if(msg.data.type == 1){
				$("#event_type_1").attr("checked","checked");
			}else if(msg.data.type == 2){
				$("#event_type_2").attr("checked","checked");
			}
			var val = $("input[name='event_type']:checked").val();
			if(val == 1){
				$("#ul_event_module").hide();
				$("#ul_event_times").hide();
				$("#ul_event_address_name").hide();
				$("#ul_select_address").hide();
				$("#ul_address_map").hide();
			}else{
				$("#event_start_time").val(msg.data.start_time);
				$("#event_end_time").val(msg.data.end_time);
				$("#event_address_name").val(msg.data.place);

				$("#select_address_grade1").val(msg.data.country);
				//whenproviceselect2("select_address_grade1");
				$("#select_address_grade2").val(msg.data.province);
				//  whenproviceselect2("select_address_grade2");
				$("#select_address_grade3").val(msg.data.city);
				$("#event_address_info").val(msg.data.address);
				$("#ul_event_module").show();
				$("#ul_event_times").show();
				$("#ul_event_address_name").show();
				$("#ul_select_address").show();
				$("#ul_address_map").show();
			}

			//	              $("input[name='event_module_type']:checked").val(msg.data.mode);
			//	        	  if(msg.data.mode == 1){
			//	        		  $("#event_module_type_1").attr("checked","checked");
			//	        	  }else if(msg.data.mode == 2){
			//	        		  $("#event_module_type_2").attr("checked","checked");
			//	        	  }

			//logo
			var imglogourl =  msg.data.logo;
			imglogourl = $.trim(imglogourl);
			if(imglogourl != ''){
				$("#img_event_logo_src").attr("src",imglogourl);
				$("#img_event_logo_src_li").attr("class","form file_ok");
			}
			//海报(zyc)
			var haibaourl1 =  msg.data.haibao;
			haibaourl1 = $.trim(haibaourl1);
			if(haibaourl1 != ''){
				var html='<div class="fileImgOuter">\
		                    <div class="icon_box">\
		                         <a href="javascript:void(0)" onclick="haibao_del(1,this)" class="icon icon04"></a>\
		                   </div>\
				           <div class="fileImg"><span><img id="haibao1_img" src="'+haibaourl1+'" /></span></div>\
		                   </div>';
				$("#haibao_list").append(html);
				$('#haibaoimg1_update').val(2);  //用于海报的修改
			}

			var haibaourl2 =  msg.data.haibao2;
			haibaourl2 = $.trim(haibaourl2);
			if(haibaourl2 != ''){
				var html='<div class="fileImgOuter">\
		                    <div class="icon_box">\
		                         <a href="javascript:void(0)" onclick="haibao_del(2,this)" class="icon icon04"></a>\
		                   </div>\
				           <div class="fileImg"><span><img id="haibao2_img" src="'+haibaourl2+'" /></span></div>\
		                   </div>';
				$("#haibao_list").append(html);
				$('#haibaoimg2_update').val(2);  //用于海报的修改
			}
			var haibaourl3 =  msg.data.haibao3;
			haibaourl3 = $.trim(haibaourl3);
			if(haibaourl3 != ''){
				var html='<div class="fileImgOuter">\
		                    <div class="icon_box">\
		                         <a href="javascript:void(0)" onclick="haibao_del(3,this)" class="icon icon04"></a>\
		                   </div>\
				           <div class="fileImg"><span><img id="haibao3_img" src="'+haibaourl3+'" /></span></div>\
		                   </div>';
				$("#haibao_list").append(html);
				$('#haibaoimg3_update').val(2);  //用于海报的修改
			}
			if(haibaourl1=='' && haibaourl2=='' && haibaourl3==''){

			}else{
				$("#haibao_img_li").removeClass('file');
				$("#haibao_img_li").addClass('file_ok');
				$("#haibao_img_li").addClass('file_oks');
			}
			haibao_btn_show_hide();
			//活动隐私
			//	              $("input[name='event_yinsi']:checked").val(msg.data.privacy);
			//	              $("input[name='event_yinsi'][value='"+msg.data.privacy+"']").attr("checked","checked");
			if(msg.data.privacy == 1 ){
				var event_yinsi_1  = '<input  id="event_yinsi_1" name="event_yinsi" value="1" type="radio" class="radio" checked="checked" />';
				var event_yinsi_2 = '<input  id="event_yinsi_2" name="event_yinsi"   value="2"  type="radio" class="radio"/>';

				//	        		  $("#event_yinsi_1").attr("checked","checked");
				//	        		  $("input[name='event_yinsi'][value='1']").attr("checked","checked");

			}else if(msg.data.privacy == 2){
				var event_yinsi_1  = '<input  id="event_yinsi_1" name="event_yinsi" value="1" type="radio" class="radio" />';
				var event_yinsi_2 = '<input  id="event_yinsi_2" name="event_yinsi"   value="2"  type="radio" class="radio"  checked="checked" />';

				//	        		  $("#event_yinsi_2").attr("checked","checked");
				//	        		  $("input[name='event_yinsi'][value='2']").attr("checked","checked");
			}
			$("#event_yinsi_1").replaceWith(event_yinsi_1);
			$("#event_yinsi_2").replaceWith(event_yinsi_2);
			//	        	  var val = $("input[name='event_yinsi']:checked").val();
			if(msg.data.privacy == 2){
				$("input[name='event_passwd']").val(msg.data.passwd);
			}


			//分类
			var category = msg.data.category;
			var categorys = category.split(";");
			category_first = categorys[0];
			//	        	  var categorys = category.split(";");
			//	        	  $("#select_category_grade1").val(categorys[0]);
			//	        	  whenselectcategory();
			//	        	  $("#select_category_grade2").val(categorys[1]);
			$("#category_type").val(category_first);
			$("#category_select_required").val(category_first);
			var getOptionIdvalue = $("#event_category_grade1 li[category_select_type='"+category_first+"']").html();
			$("#category_getOptionId").html(getOptionIdvalue);


			//咨询电话
			$("input[name='event_refer_telephone']").val(msg.data.refer_telephone);

			//	              $("input[name='event_support_share']").val(msg.data.if_share);
			$("#event_keyword").val(msg.data.key_word);
			editor.html(msg.data.fuza_description);
			$("textarea[name='huodongjianjie']").val(msg.data.description);
			//活动连接
			$("#event_short_url").html(msg.data.short_url);
			$("#event_long_url").html(msg.data.long_url);
			$("#event_qr_code").attr("src","/getqrcode.do?str="+msg.data.long_url);
			//	              $("#event_link_title").show();
			$("#event_link_content").show();
			//头部活动链接
			//	              $("#event_top_url").html(msg.data.long_url);
			//	              $("#event_top_url").attr("href",msg.data.long_url);
			//活动码
			$("#li_invite_code").html(msg.data.invite_code);
			//地图zyc 2014年9月14日修改
			if(msg.data.longitude!='' && msg.data.latitude!='' && msg.data.longitude!='-1' && msg.data.latitude!='-1'){
				$("#longitude").val(msg.data.longitude);
				$("#latitude").val(msg.data.latitude);
				addmarker(msg.data.longitude,msg.data.latitude,msg.data.address,0);
			}
			
			//左侧导航条
			//	          	  displayleftMenu(event_id);
			//发布按钮,预览按钮
			if(msg.data.status == 1 || msg.data.status == 3){
				$("#link_apply_event").show();
				$("#link_apply_event").attr('href','javascript:apply_event("'+event_id+'");');
			}
			$("#link_review_event").show();

			//活动名称
			var event_name = msg.data.name;
			if(event_name.length > 10){
				event_name = event_name.substr(0,10)+'...';
			}
			$("#event_header_name").html(event_name);

			//主办方信息 add by surn 20140828
			change_org(msg.data.organizer_list);
		}
		eventStatusTip();
	}
	});
}

/*
* 主办方信息
*/
function change_org(orgData){
	var orgname = "",orgNum = 0;
	for(var i =0 ;i < orgData.length ; ++i){
	   
		if(orgJson1 == ""){
			orgJson1='{"id":"'+orgData[i].id+'","name":"'+orgData[i].name+'","description":"'+orgData[i].description+'","logo_url":"'+orgData[i].logo_url+'","type":"old"},';
			orgNum = 1;
		}else if(orgJson2 ==  ""){
			orgJson2='{"id":"'+orgData[i].id+'","name":"'+orgData[i].name+'","description":"'+orgData[i].description+'","logo_url":"'+orgData[i].logo_url+'","type":"old"},';;
			orgNum = 2;
		}else if(orgJson3 ==  ""){
			orgJson3='{"id":"'+orgData[i].id+'","name":"'+orgData[i].name+'","description":"'+orgData[i].description+'","logo_url":"'+orgData[i].logo_url+'","type":"old"},';
			orgNum = 3;
		}
		
		orgname += '<dl id="org_'+orgNum+'">\
                      <dt>'+orgData[i].name+'</dt>\
                      <dd><a title="编辑" class="icon icon05" href="javascript:orgEditInfo(\''+orgNum+'\');"><span></span></a>\
                      |<a title="删除" class="icon icon04" href="javascript:void(0);" onclick="delSponsorHtml(\''+orgData[i].id+'\',\''+orgNum+'\')"><span></span></a></dd>\
                 </dl>';

	}
	
	$("#addOrg").before(orgname);
	if(orgname == ""){
		$("#orgImportId").show();
	}else{
		$("#orgImportId").hide();
	}
	
	if(orgJson1 != ''){
        if(orgJson2 != ''){
            if(orgJson3 != ''){
                $("#addOrgMenu").hide(); 
            }else{
                $("#addOrgMenu").show(); 
            }
        }
    }

	//subOrgOff();
}


/**
* 加载活动分类信息
*
**/
function event_category_list(code,type,posid) { 
	posid = $.trim(posid);
	var info = '{"code":"'+code+'","type":"'+type+'"}';
	//var url = js_huodongshu_domain+'/geteventcategory.do';
	//var url = "http://182.92.169.209/activity/geteventcategory.do";
	var url = "http://localhost:8080/activity/geteventcategory.do";
	$.ajax({
		url: url,
		async: false,
		dataType: "json",
		data:"info="+info,
		success: function(msg){
			//原分类数据
			//		        	   var data = {categorylist:msg.data};
			//					   var dataDir = {
			//				    	'option':{
			//			   				'category<-categorylist':{
			//						        '.':'category.name',
			//			   					'@value':'category.id'
			//			   				}
			//		   			    }
			//		   		       };//end dataDir
			//					   $("#"+posid).render(data, dataDir);
			//新分类数据
			var html = '';
			var categorylist = msg.data;
			var len = categorylist.length;
			for(var i = 0; i < len; i++){
				var category = categorylist[i];
				var name = category.name;
				var id = category.id;
				html += '<li category_select_type="'+id+'">'+name+'</li>';
			}
			$("#event_category_grade1").html(html);
			UIselect();

		}
	});
}

/* 暂时无用**/
//function whenselectcategory(){
//	$("#select_category_grade2").html('<option  value="-1" >--请选择--</option>');
//	var code = $("#select_category_grade1").val();
//	event_category_list(code,'list',"select_category_grade2");
//}


function myformvalidate(){

	jQuery.validator.addMethod('start_end_time',
	function(){
		var event_start_time = $("#event_start_time").val();
		event_start_time = event_start_time.replace(/-/g,'/');
		event_start_time = new Date(event_start_time).getTime();

		var event_end_time = $("#event_end_time").val();
		event_end_time = event_end_time.replace(/-/g,'/');
		event_end_time = new Date(event_end_time).getTime();
		if(event_end_time <  event_start_time){
			return false;
		}else{
			return true;
		}
	},'<span class="icon"></span><font color=\'red\'>结束时间不能大于开始时间</font>');

	jQuery.validator.addMethod('end_time_validate',
	function(){
		var event_end_time = $("#event_end_time").val();
		event_end_time = event_end_time.replace(/-/g,'/');
		event_end_time = new Date(event_end_time).getTime();
		var nowtime =  new Date().getTime();
		if(event_end_time <  nowtime){
			return false;
		}else{
			return true;
		}
	},'<span class="icon"></span><font color=\'red\'>结束时间不能小于当前时间</font>');


	jQuery.validator.addMethod('eventnamecheck',
	function(){
		var event_name = $("input[name='event_name']").val();
		var result = huodongshu_word_check(event_name);
		if(result){
			return true;
		}else{
			return false;
		}

	},'<span class="icon"></span><font color=\'red\'>活动名称不能含特殊字符！</font>');


	jQuery.validator.addMethod('address_namecheck',
	function(){
		var event_address_name = $("input[name='event_address_name']").val();
		return huodongshu_word_check(event_address_name);

	},'<span class="icon"></span><font color=\'red\'>地点不能含特殊字符！</font>');

	jQuery.validator.addMethod('address_info_check',
	function(){
		var event_address_info = $("input[name='event_address_info']").val();
		return huodongshu_word_check(event_address_info);

	},'<span class="icon"></span><font color=\'red\'>详细地址不能含特殊字符！</font>');

	jQuery.validator.addMethod('huodongjianjie_check',
	function(){
		var huodongjianjie = $("textarea[name='huodongjianjie']").val();
		return huodongshu_word_check(huodongjianjie);
	},'<span class="icon"></span><font color=\'red\'>活动简介不能含特殊字符！</font>');

	jQuery.validator.addMethod('refer_telephone_format',
	function(){
		var event_refer_telephone = $("input[name='event_refer_telephone']").val();
		event_refer_telephone = $.trim(event_refer_telephone);
		// var reg=/^(0|86|17951)?(13|15|18|14)\d{9}((;|；)(0|86|17951)?(13|15|18|14)\d{9})?$/;
		var reg=/^\d{1}([0-9-]){1,20}[;]?([0-9-]){1,20}$/;
		//				 if(!pattern_test.test(event_refer_telephone)){
		//			           alert('有错误');
		//			        }else{
		//			        	alert('没事');
		//			        }
		//				 return false;
		return  reg.test(event_refer_telephone);
	},'<span class="icon"></span><font color=\'red\'>咨询电话格式有误！</font>');


	jQuery.validator.addMethod('logo_required',
	function(){
		var str = document.getElementById("event_logo_name").value;
		str = $.trim(str);
		var eventid = $("#event_base_hidden_eid").val();
		if(!isNaN(eventid)){
			return true;
		}
		if(str == ''){
			return false;
		}
		return true;
	},'<span class="icon"></span><font color=\'red\'>请上传logo！</font>');

	//主办方 by surn

	jQuery.validator.addMethod('organizers_required',
	function(){
		var event_org_hidden_info_y =  $("input[name='event_org_hidden_info_y']").val();
		event_org_hidden_info_y = $.trim(event_org_hidden_info_y);
		if(event_org_hidden_info_y == '[]' || event_org_hidden_info_y == ''){
		    $("#addOrg").slideUp();
		    $("#addOrgMenu").show();
			return false;
		}else{
			return true;
		}
	},'<span class="icon"></span><font color=\'red\'>主办方不能为空！</font>');

	//活动分类sl
	jQuery.validator.addMethod('category_select_required',
			function(){
				var category_select_type =  $("#category_select_required").val();
				if(category_select_type > 0 ){
					return true;
				}else{
					return false;
				}
			},'<span class="icon"></span>请选择活动分类！');



	//
	//
	//	jQuery.validator.addMethod('event_end_time_required',
	//	function(){
	//		var selectedval = $("input[name='event_type']:checked").val();
	//		if(selectedval == 1){return true;}
	//		var end_time = $("input[name='event_end_time']").val();
	//		end_time = $.trim(end_time);
	//		if(end_time == ''){
	//			return false;
	//		}
	//	});
	//

	$("#evnet_base_validateform").validate({
		rules: {
			//			'event_theme_xilie': {
			//		        required:true
			//			},
			'event_name':{
				required:true,
				eventnamecheck:true,
				maxlength:35
			},
			//			'event_limit_num':{
			//				required:true,
			//				digits:true
			//			},
			'event_type':{
				required:true
			},
			//			'event_module_type':{
			//				evenet_module_type_require:true
			//			},
			'event_start_time':{
				required:true
			},
			'event_end_time':{
				required:true,
				start_end_time:true,
				end_time_validate:true
			},
			'event_address_name':{
				required:true,
				maxlength:30,
				address_namecheck:true

			},
			'select_address_grade1':{
				required:true
			},
			'select_address_grade2':{
				required:true
			},
			'select_address_grade3':{
				required:true
			},
			'zxy_zxy':{
				required:true,
				maxlength:30,
				address_info_check:true
			},
			'event_refer_telephone':{
				required:true,
				refer_telephone_format:true
			},
			'huodongjianjie':{
				required:true,
				maxlength:200,
				huodongjianjie_check:true
			},
			//			'editor_content_hidden':{
			//				required:true
			//			},
			'img_event_log_form_zyc':{
				required:true
			},
			'event_logo':{
				logo_required:true
			},
			'event_org_hidden_info_y':{
				organizers_required:true
			},
			'category_select_required':{
				category_select_required:true
			}
			//			'event_yinsi':{
			//				required:true
			//			},
			//			'event_passwd':{
			//				required:true
			//			},
			//			'event_category1':{
			//				required:true
			//			},
			//			'event_category2':{
			//				required:true
			//			},
			//			'event_support_share':{
			//				required:true
			//			},
			//			'event_keyword':{
			//				required:true
			//			}
		},
		messages: {
			//			'event_theme_xilie': {
			//        	    required: "<font color='red'>必填项<font>"
			//			},
			'event_name': {
				required: "<span class='icon'></span><font color='red'>请填写活动名称！<font>",
				maxlength:"<span class='icon'></span><font color='red'>活动名称不能超过35个汉字！<font>"
			},
			//			'event_limit_num': {
			//				required: "<font color='red'>请填写活动限制人数<font>",
			//				digits:"<font color='red'>活动限制人数应该是正整数<font>"
			//			},
			'event_type': {
				required: "<span class='icon'></span><font color='red'>请选择活动类型！<font>"
			},
			//			'event_module_type': {
			//				evenet_module_type_require: "<font color='red'>必填项<font>"
			//			},
			'event_start_time': {
				required: "<span class='icon'></span><font color='red'>请选择活动开始时间！<font>"
			},
			'event_end_time': {
				required: "<span class='icon'></span><font color='red'>请选择活动结束时间！<font>"
			},
			'event_address_name': {
				required: "<span class='icon'></span><font color='red'>请填写地点名称！<font>",
				maxlength: "<span class='icon'></span><font color='red'>活动地点不能超过20个汉字！<font>"
			},
			'select_address_grade1': {
				required: "<span class='icon'></span><font color='red'>必填项<font>"
			},
			'select_address_grade2': {
				required: "<span class='icon'></span><font color='red'>必填项<font>"
			},
			'select_address_grade3': {
				required: "<span class='icon'></span><font color='red'>必填项<font>"
			},
			'zxy_zxy': {
				required: "<span class='icon'></span><font color='red'>请填写具体地址！<font>",
				maxlength: "<span class='icon'></span><font color='red'>详细地址不能超过30个汉字！<font>"
			},
			'event_refer_telephone':{
				required: "<span class='icon'></span><font color='red'>请填写咨询电话！<font>"
			},
			'huodongjianjie':{
				required: "<span class='icon'></span><font color='red'>请填写活动简介！<font>",
				maxlength:"<span class='icon'></span><font color='red'>活动简介不能超过200汉字！<font>"
			},
			'editor_content_hidden':{
				required: "<span class='icon'></span><font color='red'>请填写活动详情！<font>"
			},
			'img_event_log_form_zyc':{
				required: "<span class='icon'></span><font color='red'>活动图片必须上传！<font>"
			},
			'event_org_hidden_info_y':{
				required: "<span class='icon'></span><font color='red'>请填写主办方！<font>"
			},
			'category_select_required':{
				required: "<span class='icon'></span><font color='red'>请选择活动类型！<font>"
			},
			//			'event_yinsi': {
			//        	    required: "<font color='red'>必填项<font>"
			//			},
			//			'event_passwd': {
			//        	    required: "<font color='red'>必填项<font>"
			//			},
			//			'event_category1': {
			//        	    required: "<font color='red'>必填项<font>"
			//			},
			//			'event_category2': {
			//        	    required: "<font color='red'>必填项<font>"
			//			},
			//			'event_support_share': {
			//        	    required: "<font color='red'>必填项<font>"
			//			},
			//			'event_keyword': {
			//        	    required: "<font color='red'>关键字不能为空<font>"
			//			}

		},
		errorPlacement:function(error, element){
			//    		var editor_text = $.trim(editor.text());
			//    		 if(editor_text==''){
			//    			 $("#edtior_ul").addClass('error');
			//    			 $("#error_event_reportContent").html('<span class="icon"></span><font color=\'red\'>活动详情不能为空！</font>');
			//    		 }else{
			//    			 $("#edtior_ul").removeClass('error');
			//    		 }
			$(element).parents("ul").addClass("error");
			//    	   if(element.is("input[name='event_theme_xilie']")){
			//    		   $("#error_event_theme_xilie").html(error);
			//    	   }
			if(element.is("input[name='event_name']")){

				$("#error_event_name").html(error);
			}
			//    	   else if(element.is("input[name='event_limit_num']")){
			//    		   $("#error_event_limit_num").html(error);
			//    	   }
			else if(element.is("input[name='event_type']")){
				$("#error_event_type").html(error);
			}
			//    	   else if(element.is("input[name='event_module_type']")){
			//    		   $("#error_event_module_type").html(error);
			//    	   }
			else if(element.is("input[name='event_start_time']")){
				$("#error_event_times").html(error);
			}else if(element.is("input[name='event_end_time']")){
				$("#error_event_times").html(error);
			}else if(element.is("input[name='event_address_name']")){
				$("#error_event_address_name").html(error);
			}else if(element.is("input[name='select_address_grade1']")){
				$("#error_select_address").html(error);
			}else if(element.is("input[name='select_address_grade2']")){
				$("#error_select_address").html(error);
			}else if(element.is("input[name='select_address_grade3']")){
				$("#error_select_address").html(error);
			}else if(element.is("input[name='zxy_zxy']")){
				$("#error_event_address_info").html(error);
			}else if(element.is("input[name='event_refer_telephone']")){
				$("#error_event_refer_telephone").html(error);
			}else if(element.is("input[name='event_logo']")){
				$("#error_event_logo").html(error);
			}else if(element.is("textarea[name='huodongjianjie']")){
				$("#error_event_jianjie").html(error);
			}
			else if(element.is("input[name='img_event_log_form_zyc']")){
				$("#error_event_logo").html(error);
			}
			else if(element.is("input[name='event_org_hidden_info_y']")){
				$("#organizers_id").removeClass("organizers").addClass("error");
				$("#error_organizers").html(error);
			}
			//    	   else if(element.is("input[name='editor_content_hidden']")){
			//    		   $("#edtior_ul").addClass('error');
			//    		   $("#error_event_reportContent").html(error);
			//    	   }
			//    	   else if(element.is("input[name='event_passwd']")){
			//    		   $("#error_event_passwd").html(error);
			//    	   }
			//    	   else if(element.is("input[name='event_yinsi']")){
			//    		   $("#error_event_yinsi").html(error);
			//    	   }
			//    	   else if(element.is("input[name='']")){
			//    		   $("#error_event_category").html(error);
			//    	   }else if(element.is("input[name='']")){
			//    		   $("#error_event_category").html(error);
			//    	   }
			//    	   else if(element.is("input[name='event_support_share']")){
			//    		   $("#error_event_support_share").html(error);
			//    	   }
			else if(element.is("input[name='event_keyword']")){
				$("#error_event_keyword").html(error);
			}
			else if(element.is("input[name='category_select_required']")){
				$("#ul_category_type_error").html(error);
			}

		}//,
		//        submitHandler: function(){
		//    	   event_base_save('submit');
		//        }
	});


}



function categoryMethodSelect(e){
	$("#category_getOptionId").attr("category_select_type",e.attr("category_select_type"));
	var val = e.attr("category_select_type");
	$("#category_type").val(val);
	$("#category_select_required").val(val);
	//活动类型  sl
	if(val > 0){
		$("#ul_category_type_error").empty();
	}
}

/**
* 活动状态修改提示
*/
function eventStatusTip(){
	var tips = getQueryString("tips");
	var eid = getQueryString("event_id");
	var url ='/html/event_base.html?event_id='+eid;
	tips = $.trim(tips);

	if(tips != ''){
		alert(tips);
		document.location.href = url;
	}
}




