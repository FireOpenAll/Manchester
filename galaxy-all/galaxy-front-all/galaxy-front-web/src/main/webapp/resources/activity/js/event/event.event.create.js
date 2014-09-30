$(document).ready(function(){
    
    $("#published_num").trigger("click");
    
    getPubCreateList();
    getCreateList();
    getCloCreateList();
    
    var but = "";
    
    $("#unpublished_num").on("click", function(){
        but ='<button class="searchBtn" onclick="getCreateList();"></button>';
        $("#search_id").find("input").after(but);
    });
    
    $("#published_num").on("click", function(){
        but ='<button class="searchBtn" onclick="getPubCreateList();"></button>';
        $("#search_id").find("input").after(but);
    });
    
    $("#close_num").on("click", function(){
        but ='<button class="searchBtn" onclick="getCloCreateList();"></button>';
        $("#search_id").find("input").after(but);
    });
});

/**
 * 一、未发布的活动
 */
//count为一页显示多少条数据
//var count=2;
function  getCreateList(){
    var sname = $("#search_name").val();
    
    if(/[\'"\'*?`!$%&\\\/\<\>]/.test(sname)){  
            alert('输入的关键字中不能含有特殊字符');
            return false;
    }
    
    var condition =  '{"keyword":"'+sname +'"}';
  //  n.count=count;
    var url = js_huodongshu_domain+"/event/getWebEventListByCond.do?type=2&flg=1";
    $.ajax({
       type: "post",
       url: url,
       dataType:"json",
       data:'condition='+condition,
       success: function(msg){
           //文件信息获取成功
           if(parseInt(msg.status)){
               
                var data = eval(msg.data);
                var html = "";
                if(data.total == 0){
                    
                    $("#unpublished_num").html("未发布("+data.total+")"); 
                    if(sname == ""){
                        
                        $("#unpublished_id").html('<div class="noData">您还没有未发布的活动～</div>');
                    }else{
                       
                        $("#unpublished_id").html('<div class="noData">没有与"'+sname+'"相关的活动</div>');
                    }
                    $("#pagestr").html('');
                }else{
                    for(var i = 0 ;i < data['list'].length ; ++i){
                        html += '<div class="timeNode" id="time_'+data['list'][i].id+'">\
                                        <div class="nodeL">\
                                            <div class="logo"><span><img src="'+data['list'][i].logo+'" /></span></div>\
                                            <div class="state font_999999">（'+data['list'][i].event_status+'）</div>\
                                        </div>\
                                        <div class="nodeR">\
                                        <div class="info title"><a href="'+data['list'][i].long_url+'" class="font_0097e0">'+data['list'][i].name+'</a></div>\
                                        <div class="info area"><span class="icon"></span>'+data['list'][i].address+'</div>\
                                        <div class="info time"><span class="icon"></span>'+data['list'][i].start_time+' ~ '+data['list'][i].end_time+'</div>\
                                        <div class="info btn">';
                                           
                                            
                                            
                                            if(data['list'][i].channel_id  ==  1){
                                                html += '<a href="event_base.html?event_id='+data['list'][i].id+'" class="btn_small btn_gray btn_autox30">编辑</a>';
                                            }
                                        
                                            html += '<a href="/html/manage_order.html?event_id='+data['list'][i].id+'" class="btn_small btn_gray btn_autox30">管理</a>';
                                            if(data['list'][i].channel_id  ==  1){
                                                html += '<a href="myEvent_copy.html?event_id='+data['list'][i].id+'&name='+data['list'][i].name+'" class="btn_small btn_gray btn_autox30"  >复制</a>';
                                            }       
                                     html += '<a href="javascript:void(0);" class="btn_small btn_gray btn_autox30" onclick="delPubCreateList('+data['list'][i].id +',\'unpublish\');">删除</a>\
                                        </div>\
                                        </div>\
                                    </div>';
                        
                        
                        if(i==0){
                            $(".timeNode").addClass("timeNodeFirst");
                        }
                    }
                    
                    html += '<div class="clear"></div>';
                    $("#unpublished_num").html("未发布(<span id='eventTotal'>"+data.total+"</span>)"); 
                        
                    $("#unpublished_id").html(html);
                    $("#unpublished_id").children().first("div").addClass("timeNodeFirst");
                    
                  //  var pagestr=ajaxPage(page,b);
                   // $("#pagestr").html(pagestr);
                    $(".timeLine").each(function(){
                        $(this).find(".timeNode:odd").css({"backgroundColor":"#fcfcfc"});
                        $(this).find(".timeNode:even").css({"backgroundColor":"#ffffff"});
                    })
                    pie($(".timeNode .bit,.search"));
                }
                return true;
                
           }
        }
    });
}



//删除活动
function  delPubCreateList(id,type){
    var url = js_huodongshu_domain+"/event/deleteevent.do";
    if( confirm('活动删除后无法撤回，是否确认删除此活动？') ){ 
            $.ajax({
               type: "GET",
               url: url,
               data: 'event_id='+id,
               dataType: 'json',
               success: function(msg){
                   if(parseInt(msg.status)){ 
                       $('#time_'+id).slideUp("normal",function () {
                           $(this).remove();
                       });
                       if(type == 'unpublish'){
                           getCreateList();
                       }else if(type == 'publish'){
                           getPubCreateList();
                       }else if(type == 'published'){
                           getCloCreateList();
                       }
                   }else{
                       alert(msg.msg);
                       return false;
                   }
               }
            });
    }
}
/**
 * 一、已发布的活动
 */
//count为一页显示多少条数据
//var count=2;
function  getPubCreateList(){
    var search_name2 = $("#search_name").val();
    
    if(/[\'"\'*?`!$%&\\\/\<\>]/.test(search_name2)) 
    {  
            alert('输入的关键字中不能含有特殊字符');
            return false;
    }
    
    var condition =  '{"keyword":"'+search_name2 +'"}';
    var url = js_huodongshu_domain+"/event/getWebEventListByCond.do?type=2&flg=2";
    $.ajax({
       type: "post",
       url: url,
       dataType:"json",
       data:'condition='+condition,
       success: function(msg){
           //文件信息获取成功
           if(parseInt(msg.status)){
              // $("#published_num").trigger('click');
                var data = eval(msg.data);
                var html = "";
                if(data.total != 0){
                for(var i = 0 ;i < data['list'].length ; ++i){
                    html += '<div class="timeNode" id="time_'+data['list'][i].id+'">\
                    <div class="nodeL">\
                        <div class="logo"><span><img src="'+data['list'][i].logo+'" /></span></div>\
                        <div class="state font_999999">（'+data['list'][i].event_status+'）</div>\
                    </div>\
                    <div class="nodeR">';
                    if(data['list'][i].channel_id  ==  1){
                    html +='<div class="info title"><a href="'+data['list'][i].long_url+'" class="font_0097e0">'+data['list'][i].name+'</a></div>';
                    }else{
                        html +='<div class="info title"><a href="javascript:void(0)" class="font_0097e0">'+data['list'][i].name+'</a></div>';
                    }
                    html +='<div class="info area"><span class="icon"></span>'+data['list'][i].address+'</div>\
                    <div class="info time"><span class="icon"></span>'+data['list'][i].start_time+' ~ '+data['list'][i].end_time+'</div>\
                    <div class="info btn">';
                    if(data['list'][i].channel_id  ==  1){
                        html += '<a href="event_base.html?event_id='+data['list'][i].id+'" class="btn_small btn_gray btn_autox30">编辑</a>';
                    }
                
                    html += '<a href="/html/manage_order.html?event_id='+data['list'][i].id+'" class="btn_small btn_gray btn_autox30">管理</a>';
                    if(data['list'][i].channel_id  ==  1){
                        html += '<a href="myEvent_copy.html?event_id='+data['list'][i].id+'&name='+data['list'][i].name+'" class="btn_small btn_gray btn_autox30"  >复制</a>';
                    }
                    //当订单为0的时候，可以删除
                    if(data['list'][i].ordernum == 0 ){
                        html += ' <a href="javascript:void(0);" class="btn_small btn_gray btn_autox30" onclick="delPubCreateList('+data['list'][i].id +',\'publish\');">删除</a>';
                    }
                    html +='</div>\
                    </div>\
                </div>';
                }
                $("#published_num").html("已发布("+data.total+")"); 
                    
                $("#published_id").html(html);
                //$(".timeNode:eq(0)").addClass("timeNodeFirst");
                $("#published_id").children().first("div").addClass("timeNodeFirst");
               
                //var pagestr=ajaxPage(page,b);
                //$("#pagestr_2").html(pagestr);
                $(".timeLine").each(function(){
                    $(this).find(".timeNode:odd").css({"backgroundColor":"#fcfcfc"});
                    $(this).find(".timeNode:even").css({"backgroundColor":"#ffffff"});
                })
                pie($(".timeNode .bit,.search"));
                }else{
                    $("#published_num").html("已发布("+data.total+")"); 
                    if(search_name2 == ""){
                        $("#published_id").html('<div class="noData">您还没有已发布的活动～</div>');
                    }else{
                        $("#published_id").html('<div class="noData">没有与"'+search_name2+'"相关的活动</div>');
                    }
                    $("#pagestr_2").html('');
                }
                return true;
                
           }
        }
    });
}



/**
 * 一、已结束的活动
 */
//count为一页显示多少条数据
//var count=2;
function  getCloCreateList(){
    var search_name3 = $("#search_name").val();

    if(/[\'"\'*?`!$%&\\\/\<\>]/.test(search_name3)) 
    {  
            alert('输入的关键字中不能含有特殊字符');
            return false;
    }
    var condition =  '{"keyword":"'+search_name3 +'"}';
    var url = js_huodongshu_domain+"/event/getWebEventListByCond.do?type=2&flg=3";
    $.ajax({
       type: "post",
       url: url,
       dataType:"json",
       data:'condition='+condition,
       success: function(msg){
           //文件信息获取成功
           if(parseInt(msg.status)){
               
                var data = eval(msg.data);
                var html = "";
                if(data.total != 0){
                    for(var i = 0 ;i < data['list'].length ; ++i){
                        html += '<div class="timeNode" id="time_'+data['list'][i].id+'">\
                        <div class="nodeL">\
                            <div class="logo"><span><img src="'+data['list'][i].logo+'" /></span></div>\
                            <div class="state font_999999">（'+data['list'][i].event_status+'）</div>\
                        </div>\
                        <div class="nodeR">';
                        
                        if(data['list'][i].channel_id  ==  1){
                            html +='<div class="info title"><a href="'+data['list'][i].long_url+'" class="font_0097e0">'+data['list'][i].name+'</a></div>';
                            }else{
                                html +='<div class="info title"><a href="javascript:void(0)" class="font_0097e0">'+data['list'][i].name+'</a></div>';
                            }
                        html +='<div class="info area"><span class="icon"></span>'+data['list'][i].address+'</div>\
                        <div class="info time"><span class="icon"></span>'+data['list'][i].start_time+' ~ '+data['list'][i].end_time+'</div>\
                        <div class="info btn">';
                        if(data['list'][i].channel_id  ==  1){
                            html +='<a href="event_base.html?event_id='+data['list'][i].id+'" class="btn_small btn_gray btn_autox30">编辑</a>';
                        }
                        html += '<a href="/html/manage_order.html?event_id='+data['list'][i].id+'" class="btn_small btn_gray btn_autox30">管理</a>';
                        if(data['list'][i].channel_id  ==  1){
                            html += '<a href="myEvent_copy.html?event_id='+data['list'][i].id+'&name='+data['list'][i].name+'" class="btn_small btn_gray btn_autox30"  >复制</a>';
                        }
                      //当订单为0的时候，可以删除
                        if(data['list'][i].ordernum == 0 ){
                            html += ' <a href="javascript:void(0);" class="btn_small btn_gray btn_autox30" onclick="delPubCreateList('+data['list'][i].id +',\'published\');">删除</a>';
                        }
                        html += '</div>\
                        </div>\
                    </div>';
                    }
                    $("#close_num").html("已结束("+data.total+")"); 
                        
                    $("#close_id").html(html);     $("#close_id").children().first("div").addClass("timeNodeFirst");
                   
                    //var pagestr=ajaxPage(page,b);
                    //$("#pagestr_3").html(pagestr);
                    $(".timeLine").each(function(){
                        $(this).find(".timeNode:odd").css({"backgroundColor":"#fcfcfc"});
                        $(this).find(".timeNode:even").css({"backgroundColor":"#ffffff"});
                    })
                    pie($(".timeNode .bit,.search"));
                }else{
                    $("#close_num").html("已结束("+data.total+")"); 
                    if(search_name3 == ""){
                        $("#close_id").html('<div class="noData">您还没有已结束的活动～</div>');
                    }else{
                        $("#close_id").html('<div class="noData">没有与"'+search_name3+'"相关的活动</div>');
                    }
                    
                    $("#pagestr_3").html('');
                }
                return true;
                
           }
        }
    });
}




//复制活动
function copyEvent(id ,flg){
    var  c={};
    var page=1; 
    var url = js_huodongshu_domain+"/event/copyActivity.do";
    $.ajax({
        type:"GET",
        dataType:"json",
        data:'id='+id,
        url:url,
       success: function(msg){
           //文件信息获取成功
           if(parseInt(msg.status)){
               
                var data = eval(msg.data);
                var html = "";
                if( flg == 2 ){
                    getPubCreateList(page,c);
                }else if(flg == 3){
                    getCloCreateList(page,c);
                }else if(flg == 1){
                    getCreateList(page,c);
                }
                
                return true;
                
           }
        }
    });
}
