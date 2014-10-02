/**
 * 主办方相关的js
 */
var awardNum = 0;
$(document).ready(function(){
    //加载当前的主办方活动
    //loadSponsorUser();
    //二维码图片上传
	
	//huangshanqi
	/*
    $("#upload_code").on('change','#code_pic',function (){
        ajaxFileUploads('erweima','code_pic','code_pic','max',function (info){
            if(info.status==1){
                $('#img_code_img').attr('src',info.data.file_url);
                $("#img_code_img").show();
                $("input[name='codepic']").val(info.data.file_url);
                $("#img_account_code_src_li").attr("class","form file_ok");
            }else {
                alert("图片上传失败");
            }
            
        });
    });
    */
    //huangshanqi
    
  //主办方logo上传
    $("#upload").on('change','#event_pic',function (){
        ajaxFileUploads('sponsor','event_pic','event_pic','max',function (info){
        	/*
            if(info.status==1){
                $('#img_test').attr('src',info.data.thumb_url);
                $("#img_test").show();
                $("input[name='filePic']").val(info.data.thumb_url);
                $("#org_form_file").removeClass("form file").addClass("form file_ok");
                
            }else {
                alert(info.msg);
            }
            */
        	alert('info-------'+info);
        	if(info.code=='20000'){
        		$('#img_test').attr('src',info.data);
                $("#img_test").show();
                $("input[name='filePic']").val(info.data);
                $("#org_form_file").removeClass("form file").addClass("form file_ok");
                
        	}else{
        		alert(info.message);
        	}
        	//huangshanqi
        	/*
        	 $('#img_test').attr('src',"http://www.huodongshu.com/html/h5/data/event/event_logo/7.jpg");
             $("#img_test").show();
             $("input[name='filePic']").val("http://www.huodongshu.com/html/h5/data/event/event_logo/9.jpg");
             $("#org_form_file").removeClass("form file").addClass("form file_ok");
             */
           //huangshanqi
            
        });
    });
});//end document.ready

//加载当前用户信息
function loadSponsorUser(){
     var url = js_huodongshu_domain+'/event/getWebOrganizersDetail.do';
      $.ajax({
            url: url,
            dataType: "json",
            success: function(msg){
                if(msg.status == 1){
                    var info = msg.data[0];
                    //alert(info.logo_url);
                    $("#s_id").val(info.id);
                    $("#name").val(info.name);
                    $("#description").val(info.description);
                    if(info.logo_url != ''){
                        $('#img_test').attr('src',info.logo_url);
                        $("#img_account_logo_src_li").attr("class","form file_ok");
                        $("#filepic").val(info.logo_url);
                    }
                    if(info.qr_code != ''){
                        $('#img_code_img').attr('src',info.qr_code);
                        $("#img_account_code_src_li").attr("class","form file_ok");
                        $("#codepic").val(info.qr_code);
                    }
                    $("#contacts").val(info.contacts);
                    $("#telephone").val(info.telephone);
                    $("#email").val(info.email);
                    $("#http").val(info.url);
                    $("#qr_account").val(info.qr_account);
                    $("#qr_code").val(info.qr_code);
               }
            }
       });
}

var info="",orgJsonName="", delOrgIds = "",orgSponNum=0,orgJson1="",orgJson2="",orgJson3="";
//账户基本信息保存
function account_sponsor_save(){
    
   var org_name = "",type = 'create';
    var id=$("#org_id").val(); name=$("#org_name").val(); description=$("#org_description").val(); logo_url=$("#filepic").val();
    description =  huodongshu_process_forjson(description);
    description = $.trim(description);
    if (name == '') { errorLottery($("#org_name"), '主办方名称不能为空~'); return false;}
    if (fontNum(name) > 20) {errorLottery($("#org_name"), '主办方不能超出20个字~'); return false;}
    
    if (logo_url == '') { errorLottery($("#upload"), '主办方logo不能为空~'); return false;}
    
    if (description == '') {errorLottery($("#org_description"), '简介不能为空~'); return false;}
    if (fontNum(description) > 150) {errorLottery($("#org_description"), '简介不能超出150个字~'); return false;}
    var jsonNum=$("#org_id").attr('data-json-id');
    //if(id == undefined){
      //  id = "";
    //}
    var info='',orgJsonNum = '',orgname = '',tmp = '';
    if (id != "") { type = 'edit'; } else { id = 0;}
    tmp = '{"id":"'+id+'","name":"'+name+'","description":"'+description+'","logo_url":"'+logo_url+'","type":"'+type+'"},';
    
    
    //info += '{"id":"'+id+'","name":"'+name+'","description":"'+description+'","logo_url":"'+logo_url+'"},';
    
    if (type == 'edit') {
        $("#org_"+jsonNum).find("dt").html(name);
        if (jsonNum == 1) {
            orgJson1= tmp;
        } else if (jsonNum == 2) {
            orgJson2= tmp;
        } else if (jsonNum == 3) {
            orgJson3= tmp;
        } else {
            alert('参数错误');
        }
    } else if (type == 'create') {
        if(orgJson1 == ""){
            orgJsonNum = 1;
            orgJson1= tmp;
        }else if(orgJson2 ==  ""){ 
            orgJsonNum = 2;
            orgJson2=tmp;
        }else if(orgJson3 ==  ""){
            orgJsonNum = 3;
            orgJson3=tmp;
        }
        orgname += '<dl id="org_'+orgJsonNum+'">\
        <dt>'+name+'</dt>\
        <dd><a title="编辑" class="icon icon05" href="javascript:void(0);" onclick="javascript:orgEditInfo(\''+orgJsonNum+'\');" ><span></span></a>|\
        <a title="删除" class="icon icon04" href="javascript:void(0);" onclick="delSponsorHtml('+id+','+orgJsonNum+')"><span></span></a></dd>\
        </dl>';
        $("#addOrg").before(orgname);
   
        
    }
    
    
    
    
subTopicOff();
//orgNum = orgNum+1;
  //  orgJsonName = "["+info.substr(0,(info.length - 1))+"]";
    //$("#addOrgX").hide();

    if(orgJson1 != ''){
        if(orgJson2 != ''){
            if(orgJson3 != ''){
                $("#addOrgMenu").hide(); 
            }else{
                $("#addOrgMenu").show(); 
            }
        }
    }

   
}

function orgEditInfo(orgJsonId)
{
    var orgJsonInfo = "",josnNum = 0;
    if (orgJsonId == 1) {
        //eval('orgJsonInfo='+orgJson1);
        //orgJsonInfo = orgJson1.parseJSON();
        josnNum = 1;
        orgJson1 = orgJson1.replace(/\n/g,"<br/>");
        orgJsonInfo = eval('(' + orgJson1.substr(0,orgJson1.length - 1) + ')');
    } else if (orgJsonId == 2) {
        //eval('orgJsonInfo='+orgJson2);
        //orgJsonInfo = orgJson2.parseJSON();
        josnNum = 2;
        orgJson2 = orgJson2.replace(/\n/g,"<br/>");
        orgJsonInfo = eval('(' + orgJson2.substr(0,orgJson2.length - 1) + ')');
    } else if (orgJsonId == 3) {
        //eval('orgJsonInfo='+orgJson3);
        //orgJsonInfo = orgJson3.parseJSON();
        josnNum = 3;
        orgJson3 = orgJson3.replace(/\n/g,"<br/>");
        orgJsonInfo = eval('(' + orgJson3.substr(0,orgJson3.length - 1) + ')');
    } else {
        alert('数据错误');return false;
    }
    
    $("#org_id").val(orgJsonInfo.id).attr('data-json-id',josnNum);
    $("#org_name").val(orgJsonInfo.name);
    $("#filepic").val(orgJsonInfo.logo_url);
    
 var  description =  huodongshu_process_foredit(orgJsonInfo.description);
    
    $("#org_description").val(description);
    
    $("#img_test").attr('src',orgJsonInfo.logo_url);
    $("#org_form_file").removeClass("file").addClass("file_ok");
    $("#addOrg").slideDown();
   
    
  
}

//删除主办方
function delSponsorHtml(org_id,orgNumId){
    if (org_id != 0) {
        delOrgIds += org_id+',';
    }
    if (orgNumId == 1) {
        orgJson1 = "";
        $("#orgImportId").show();
    } else if (orgNumId == 2) {
        orgJson2 = ""
    } else if (orgNumId == 3){
        orgJson3 = ""
    } else {
        alert('删除失败~');
        return false;
    }
    $("#org_"+orgNumId).remove();
    $("#addOrgMenu").show(); 
    
}

awardNum = 0;
//添加主办方

function spliceAwardHtml (data)
{
    $("#img_event_org_src_li").parent('ul').removeClass('error').addClass('organizers');
    var html = '',status = false;
    if (orgJson1 == '' || orgJson2 == '' || orgJson3 == '') {
        status = true;
    }
    if (!status){ 
        $("#addOrgMenu").hide(); 
        return false; 
   }
        $("#addOrg").slideDown();
        $("#orgImportId").hide();
        $("#addOrgMenu").hide();
    

   
    //return html;
}

//取消添加主办方的按钮
/*function subOrgOff(){
    if(orgJson1 != "" && orgJson2 != "" && orgJson3 != "" ){
        $("#addOrgMenu").hide();
    }else{
        $("#addOrgMenu").show();
    }
}*/
//取消
function subTopicOff(){
    
    //$("#addOrgX").remove();
    $("#addOrg").slideUp();
    $("#org_id,#org_name,#filepic,#org_description").val("");
    $("#img_test").attr('src','');
    $("#org_form_file").removeClass("file_ok").addClass("file");
    $("#addOrgMenu").show();
    $("ul").removeClass("error");
    //setTimeout(function () {$("#addOrgX").slideUp();}, 300);
    
    
}

//清楚错误信息
function clareError ()
{
    var pareUl = $(this).parents("ul");
    pareUl.removeClass('error');
    pareUl.children("li").last().html(errorHint);
    return true;
}

// 添加错误提示
function errorLottery (that,msg) 
{
    $("#jsSub").attr("disable","");
    var ulObj = that.parent().parent("ul"),topSpice=that.offset().top;
    var cueMsg = '<span class="icon"></span>' + msg;
    //ulObj.attr('oldClass',oldClass).addClass(oldClass + ' error');
    ulObj.addClass(' error');
    errorHint = ulObj.children("li").last().html();
    ulObj.children("li").last().html(cueMsg);
    //that.focus().one('focusout', clareError);
    
    
    var tagN = that.get(0).tagName;
    if (tagN == 'INPUT' || tagN == 'TEXTAREA') {
        that.one('focus', clareError);
    } else {
        that.one('click', clareError);
    }
    
    $("body").animate({ scrollTop:(topSpice - 80) },800); 
    return true;
}

