/**
 * author:zyc
 * time:2014年7月10日
 * 功能：消费通道
 */

/*消费首页初始化*/
function index_data(){
	   var url=js_huodongshu_domain+"/event/feeChannelIndex.do";
	    var n={};
		$.ajax({
	        type: "POST",
	        url: url,
	        data: n,
	        success: function(info) { 
	        	  if(info.status == 1){
	        		 $("#sms_no_use").html(info.data.sms_no_use);
	        		 $("#sms_use").html(info.data.sms_use);
	        		 $("#caixin_no_use").html(info.data.caixin_no_use);
	        		 $("#caixin_use").html(info.data.caixin_use);	 
	        		 $("#email_no_use").html(info.data.email_no_use);
	        		 $("#email_use").html(info.data.email_use);	        		 
	              }else{
	                  alert(info.msg);
	                  return false;
	              }
	       }
	    })
}

/*购买*/
function  on_buy(){
	var n={};
	var sms_num=$.trim($("#sms_num").val());
	var email_num=$.trim($("#email_num").val());
	var caixin_num=$.trim($("#caixin_num").val());
	var pattern_test=/^\d+$/;
    if(sms_num=='' && email_num==''  && caixin_num==''){
     alert('必须短信和邮件必须选一个'); return false;	
    }	
    if(sms_num!='' && sms_num!=0){
    	if(!pattern_test.test(sms_num)){
    		alert('短信必须填写数字'); return false; 
    	}
    	if(sms_num>0 && sms_num<=10000){
    		
    	}else{
    		alert('短信每次大于0条小于1w条'); return false; 
    	}
    	n.sms_num=sms_num;
    }
    if(email_num!='' &&  email_num!=0){
    	if(!pattern_test.test(email_num)){
    		alert('邮件必须填写数字'); return false; 
    	}
      if(email_num>0 && email_num<=10000){
    		
    	}else{
    		alert('邮件每次大于0条小于1w条'); return false; 
    	}
    	n.email_num=email_num;
    }
    if(caixin_num!='' && caixin_num!=0){
    	if(!pattern_test.test(caixin_num)){
    		alert('彩信必须填写数字'); return false; 
    	}
      if(caixin_num>0 && caixin_num<=10000){
    		
    	}else{
    		alert('彩信每次大于0条小于1w条'); return false; 
    	}
    	n.caixin_num=caixin_num;
    }
    var total_price=sms_num*(10000*0.1)/10000+caixin_num*(0.2*10000)/10000+email_num*(10000*0.05)/10000;
        n.total_price=total_price.toFixed(2);
	var url=js_huodongshu_domain+"/event/buySmsEmail.do";
	$("#on_submit").html('<a class="btn_small btn_orange btn_80x40" href="javascript:void(0)">正在购买</a>');
	$.ajax({
        type: "POST",
        url: url,
        data: n,
        success: function(info) { 
        	  if(info.status == 1){
        		//  alert(info.data);
                 order_pay(info.data,'jisidaozhang');
              }else{
                  alert(info.msg);              
                  return false;
              }
       }
    })
}
var count=3;
/*短信的简单明细*/
function sms_detail_list(page,n){
	var url=js_huodongshu_domain+"/event/eventGroupSmsList.do";
	n.page=page;
	n.count=count;
	$.ajax({
        type: "POST",
        url: url,
        data: n,
        success: function(info) { 
        	  if(info.status == 1){
        		  var datas = info.data.list;
        		  var html="";
        		  for(var i =0 ;i <datas.length ; i++){
        			  html+='<tr id="zyc_'+datas[i].id+'">';
        			  if(datas[i].content==null){datas[i].content='系统短信';}
        			  html+='<td class="text"><span>'+datas[i].content+'</span></td>';
        			  if(datas[i].remark_type==1){
        				  html+='<td>短信群发</td>';
        			  }else if(datas[i].remark_type==2){
        				  html+='<td>短信邀请</td>';
        			  }else if(datas[i].remark_type==3){
        				  html+='<td>系统</td>';
        			  }        			        			  
        			  html+='<td>'+datas[i].num+'</td>';
        			  html+='<td>'+getLocalTime(datas[i].send_time)+'</td>';
        			  html+='<td>'+datas[i].event_name+'</td>';
        			  html+='</td>';
        			  html+='<td class="operate">';
                      var detail_url="/html/account_xiaofei_sms_moreDetail.html?remark_type="+datas[i].remark_type+"&remark_id="+datas[i].remark_id;
        			  html+='<a title="查看明细" class="icon10" href="'+detail_url+'"></a>';
        			  html+='</td>';
        			  html+='</tr>';
        		  }
        		  $("#contentList").html(html);
        		  var b=n;
        		  b.pagesize=n.count;
        		  b.js='sms_detail_list';
        		  b.total=info.data.total;
        		  b.pagelen=5;
        		  var pagestr=ajaxPage(page,b);
        		  // alert(pagestr);
        		  $("#pagestr").html(pagestr);
        		  return true;
              }else{
            	  $("#contentList").html('<tr><td colspan="7"><center>暂无信息~~</center></td></tr>');
                //  alert(info.msg);
                  return false;
              }
       }
    })
}

/*详细的明细*/
function  more_sms_detial_list(page,n){
	var url=js_huodongshu_domain+"/event/eventGroupMoreSmsList.do";
	n.page=page;
	n.count=count;
	n.remark_id=getQueryString("remark_id");
	n.remark_type=getQueryString("remark_type");
	$.ajax({
        type: "POST",
        url: url,
        data: n,
        success: function(info) { 
        	  if(info.status == 1){ 
        		  var datas = info.data.list;
        		  var html="";
        		  for(var i =0 ;i <datas.length ; i++){
        			  html+='<tr id="zyc_'+datas[i].log_id+'">';
        			  html+='<td>'+(i+1)+'</td>';
        			  html+='<td>'+datas[i].mobile_str+'</td>';  
        			  if(datas[i].send_status==1){
        				  html+='<td>发送成功</td>';  
        			  }else if(datas[i].send_status==2){
        				  html+='<td>正常发送</td>';  
        			  }else if(datas[i].send_status==3){
        				  html+='<td>已提交待发送</td>';  
        			  }else if(datas[i].send_status==4){
        				  html+='<td>未提交短信</td>';  
        			  }        			 
        			  html+='</tr>';
        		  }
        		  $("#totol_num").html(info.data.total);
        		  $("#contentList").html(html);
        		  var b=n;
        		  b.pagesize=n.count;
        		  b.js='more_sms_detial_list';
        		  b.total=info.data.total;
        		  b.pagelen=5;
        		  var pagestr=ajaxPage(page,b);
        		  // alert(pagestr);
        		  $("#pagestr").html(pagestr);
        		  return true;
              }else{ 
            	  $("#contentList").html('<tr><td colspan="7"><center>暂无信息~~</center></td></tr>');
                 // alert(info.msg);
                  return false;
              }
       }
    })
}
/*短信的搜索*/
function detail_search(){
	$search=$("#search_name").val();
	var n={};
	if($search!=''){		
	    n.search=$search;
	    more_sms_detial_list(1,n); return;
	}	
	more_sms_detial_list(1,n);
}

/**邮件搜索*/
function email_detail_search(){
		$search=$("#search_name").val();
	var n={};
	if($search!=''){		
	    n.search=$search;
	    more_email_detial_list(1,n); return;
	}	
	more_email_detial_list(1,n);
}

/*邮件的列表*/
function email_detail_list(page,n){
	var url=js_huodongshu_domain+"/event/eventGroupEmailList.do";
	n.page=page;
	n.count=count;
	$.ajax({
        type: "POST",
        url: url,
        data: n,
        success: function(info) { 
        	  if(info.status == 1){
        		  var datas = info.data.list;
        		  var html="";
        		  for(var i =0 ;i <datas.length ; i++){
        			  html+='<tr id="zyc_'+datas[i].id+'">';
        			  html+='<td>'+datas[i].title+'</td>';
        			  if(datas[i].remark_type==1){
        			  	 html+='<td>邮件群发</td>';
        			  }else if(datas[i].remark_type==2){
        			  	 html+='<td>邮件邀请</td>';
        			  }else if(datas[i].remark_type==3){
        			  	 html+='<td>系统邮件</td>';
        			  }       			 
        			  html+='<td>'+datas[i].num+'</td>';
        			  html+='<td>'+getLocalTime(datas[i].send_time)+'</td>';
        			  if(datas[i].event_name==null){datas[i].event_name='';}
        			  html+='<td>'+datas[i].event_name+'</td>';
        			  html+='</td>';
        			  html+='<td class="operate">';
                      var detail_url="/html/account_xiaofei_email_moreDetail.html?remark_type="+datas[i].remark_type+"&remark_id="+datas[i].remark_id;
        			  html+='<a title="查看明细" class="icon10" href="'+detail_url+'"></a>';
        			  html+='</td>';
        			  html+='</tr>';
        		  }
        		  $("#contentList_email").html(html);
        		  var b=n;
        		  b.pagesize=n.count;
        		  b.js='email_detail_list';
        		  b.total=info.data.total;
        		  b.pagelen=5;
        		  var pagestr=ajaxPage(page,b);
        		  // alert(pagestr);
        		  $("#pagestr_email").html(pagestr);
        		  return true;
              }else{
            	  $("#contentList_email").html('<tr><td colspan="7"><center>暂无信息~~</center></td></tr>');
                //  alert(info.msg);
                  return false;
              }
       }
    })
}

/*邮件详细的明细*/
function  more_email_detial_list(page,n){
	var url=js_huodongshu_domain+"/event/eventGroupMoreEmailList.do";
	n.page=page;
	n.count=count;
	n.remark_id=getQueryString("remark_id");
	n.remark_type=getQueryString("remark_type");
	$.ajax({
        type: "POST",
        url: url,
        data: n,
        success: function(info) { 
        	  if(info.status == 1){ 
        		  var datas = info.data.list;
        		  var html="";
        		  for(var i =0 ;i <datas.length ; i++){
        			  html+='<tr id="zyc_'+datas[i].id+'">';
        			  html+='<td>'+(i+1)+'</td>';
        			  html+='<td>'+datas[i].email+'</td>';   
        			  if(datas[i].send_status==1){
        				  html+='<td>发送成功</td>';  
        			  }else if(datas[i].send_status==2){
        				  html+='<td>正常发送</td>';  
        			  }else if(datas[i].send_status==3){
        				  html+='<td>已提交待发送</td>';  
        			  }else if(datas[i].send_status==4){
        				  html+='<td>未提交邮件</td>';  
        			  } 
        			  html+='</tr>';
        		  }
        		  $("#totol_num").html(info.data.total);
        		  $("#contentList").html(html);
        		  var b=n;
        		  b.pagesize=n.count;
        		  b.js='more_email_detial_list';
        		  b.total=info.data.total;
        		  b.pagelen=5;
        		  var pagestr=ajaxPage(page,b);
        		  // alert(pagestr);
        		  $("#pagestr").html(pagestr);
        		  return true;
              }else{ 
            	  $("#contentList").html('<tr><td colspan="7"><center>暂无信息~~</center></td></tr>');
                 // alert(info.msg);
                  return false;
              }
       }
    })
}

//时间戳转换成日期
function getLocalTime(tm) {     
	var tt=new Date(parseInt(tm)*1000);
	var year=tt.getFullYear();
	var yue=tt.getMonth();
	yue=yue+1;
	if(yue<10){
	  yue='0'+yue;
	 }
	var ri=tt.getDate();
	 if(ri<10){
	  ri='0'+ri;
	 }
	 var hour=tt.getHours();
	 if(hour<10){
	   hour='0'+hour;
	 }
	 var minutes=tt.getMinutes();
	 if(minutes<10){
	   minutes="0"+minutes;
	 }
	 var pin=year+'-'+yue+'-'+ri+' '+hour+':'+minutes;
    return pin;
 } 
