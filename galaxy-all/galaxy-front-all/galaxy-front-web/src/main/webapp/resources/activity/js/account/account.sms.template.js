/**
 * author:zyc
 * time:2014年7月7日 
 * 功能:短信模板
 */
get_template_list();
function  get_template_list(){	
	var n={};
	    n.page=1;
	    n.count=1000;
	var url=js_huodongshu_domain+"/event/smsTemplateList.do"; 
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
	        			  html+='<td class="more">';
	        			  html+='<span class="text">'+datas[i].name+'</span>';
	        			  html+='<a class="icon" href="javascript:void(0);"></a>';
	        			  html+='<b>'+datas[i].content+'</b>';
	        			  html+='</td>';
	        			  if(datas[i].property_type==1){
	        				  html+='<td>系统模板</td>';
	        			  }else if(datas[i].property_type==2){
	        				  html+='<td>自定义模板</td>';
	        			  }
	        			  if(datas[i].verify_status==1){
	        				  html+='<td>待审核</td>';
	        			  }else if(datas[i].verify_status==2){
	        				  html+='<td>审核通过</td>';
	        			  }else if(datas[i].verify_status==3){
	        				  html+='<td>审核拒绝</td>';
	        			  }
	        			  html+='<td class="operate">';
	        			  if(datas[i].property_type==2){
		        			  if(datas[i].verify_status!=2){  //审核通过不能修改
		        				 html+='<a title="修改" class="icon05" UIdialogNew="update_sms_tmp" href="javascript:void(0)" onclick="get_sms_template('+datas[i].id+',this);"></a>'; 
		        			  }	        			  
		        			  html+='<a title="删除" class="icon04" href="javascript:void(0)" onclick="del_sms_template('+datas[i].id+');"></a>';
	        		      }
	        			  html+='</td>';
	        			  html+='</tr>';
	        		  }
	        		  $("#contentList").html(html);
	        		  showTips();
	               }else{	            	 
	            	   $("#contentList").html('<tr><td colspan="7">暂无信息~~</td></tr>');
	            	   $("#pagestr").html('');
	                   return false;
	               }
	        }
	     })	
}
 //添加方法
function  add_sms_template(a){
	UIdialogNew($(a));
}


//关闭按钮(的弹出框)
function add_sms_tmpDialog(dialog,closeDialog){	
	dialog.find(".dialogSave a.saveBtn").unbind("click").click(function(){
		var n={};
		var name=$.trim($("#name").val());
		   if(name==''){
			   alert('标题不能为空！');return false;
		   }
		var content=$.trim($("#content").val());
		  if(content==''){
			  alert('内容不能为空！');return false;
		  }
		  n.name=name;
		  n.content=content;
		  var url=js_huodongshu_domain+"/event/createSmsTemplate.do";  
		  $("#on_submit").html('<a href="javascript:void(0);" class="btn_small btn_orange btn_80x40" >保存</a>');
		   $.ajax({
		         type: "POST",
		         url: url,
		         data: n,
		         success: function(info) { 
		         	  if(info.status == 1){
		         		  alert('创建成功！');
		         		  closeDialog();
		         		 window.location.href=js_huodongshu_domain+"/html/account_sms_template.html";
		         		 $("#on_submit").html('<a href="javascript:void(0);" class="btn_small btn_orange btn_80x40 saveBtn" >保存</a>');		         	
		               }else{	 
		            	   alert(info.msg);
		            	 $("#on_submit").html('<a href="javascript:void(0);" class="btn_small btn_orange btn_80x40 saveBtn" >保存</a>');
		                   return false;
		               }
		        }
		     })	
		//closeDialog();
	})	
	//点击关闭按钮
	dialog.find(".dialogClose,.cancel").unbind("click").click(function(){
		closeDialog();
	})
}
/*得到模板的内容*/
function get_sms_template(id,a){
	if(id==''){
		alert("模板id不能为空！");
		return false;
	}
	var n={};
	    n.id=id;
	var url=js_huodongshu_domain+"/event/getSmsTemplate.do";   
	   $.ajax({
	         type: "POST",
	         url: url,
	         data: n,
	         success: function(info) { 
	        	 //console.dir(info);
	         	  if(info.status == 1){
	         		  var datas=info.data;
	         		  $("#update_name").val(datas.name);
	         		  $("#update_content").val(datas.content);
	         		  $("#update_id").val(datas.id);
	         		  //alert(11);
	         		 UIdialogNew($(a));
	         		  return true;
	               }else{	 
	            	   alert(info.msg);		           
	                   return false;
	               }
	        }
	    })
}
/**修改*/
function update_sms_tmpDialog(dialog,closeDialog){
	dialog.find(".dialogSave a.update_saveBtn").unbind("click").click(function(){
	var id=$.trim($("#update_id").val());
	if(id==''){
		alert("模板id不能为空！");
		return false;
	}
	var n={};
	var name=$.trim($("#update_name").val());
	   if(name==''){
		   alert('标题不能为空！');return false;
	   }
	var content=$.trim($("#update_content").val());
	  if(content==''){
		  alert('内容不能为空！');return false;
	  }
	  n.id=id;
	  n.name=name;
	  n.content=content;
	  var url=js_huodongshu_domain+"/event/updateSmsTemplate.do";  
	  $("#on_update_submit").html('<a href="javascript:void(0);" class="btn_small btn_orange btn_80x40" >保存</a>');
	   $.ajax({
	         type: "POST",
	         url: url,
	         data: n,
	         success: function(info) { 
	         	  if(info.status == 1){
	         		  alert('修改成功！');
	         		  $("#zyc_"+id+" td").eq(0).find('span').html(name);
	         		 $("#zyc_"+id+" td").eq(0).find('b').html(content);	 showTips();        		
	         		  closeDialog();
	         		 $("#on_update_submit").html('<a href="javascript:void(0);" class="btn_small btn_orange btn_80x40 update_saveBtn" >保存</a>');
	               }else{	 
	            	   alert(info.msg);
	            	 $("#on_update_submit").html('<a href="javascript:void(0);" class="btn_small btn_orange btn_80x40 update_saveBtn" >保存</a>');
	                   return false;
	               }
	        }
	     })	
	})    
	   //点击关闭按钮
	dialog.find(".dialogClose,.update_cancel").unbind("click").click(function(){
		closeDialog();
	})  
	
}

/*删除*/
function del_sms_template(id){
	if(id==''){
		alert("模板id不能为空！");
		return false;
	}
	var n={};
	    n.id=id;
		var url=js_huodongshu_domain+"/event/delSmsTemplate.do";   
		   $.ajax({
		         type: "POST",
		         url: url,
		         data: n,
		         success: function(info) { 
		         	  if(info.status == 1){
		         		  alert('删除成功！');	
		         		   $('#zyc_'+id).remove();
		         		  return true;
		               }else{	 
		            	   alert(info.msg);		           
		                   return false;
		               }
		        }
		    })	
}

 