/**********************************************门票新版**************************************************************/

$(document).ready(function(){
	//加载门票信息
	loadTicket();
	
	//时间插件
    $("#start_time,#end_time").datetimepicker({
    });

    //创建收费门票行
    $("#menpiao").on("click","#shoufei",function(){
    	var tr =$("#ticket_info tr").first().clone(true);
    	tr.removeAttr('style');
    	tr.attr("ticketinfo","tk");
    	$("#ticket_info").append(tr);
    	UIselect();
    });
    //创建免费门票行
    $("#menpiao").on("click","#mianfei",function(){
    	var tr =$("#ticket_info tr").first().clone(true);
    	tr.removeAttr('style');
    	tr.attr("ticketinfo","tk");
    	tr.find("input[name='price']").val("0")
    	tr.find("input[name='price']").css("display","none").siblings().removeAttr("style").text("免费");
    	$("#ticket_info").append(tr);
    	UIselect();
    });
    
    //发票提供按钮
    $("#mystatus").on('click',function(){
    	if($(this).is(":checked")){
    		$("#fapiao").show();
    	}else{
    		$("#fapiao").hide();
    	}
    });
    
    //发票控制
    $("#fapiao input").on('click',function(){
    	if($("#fapiao input:checked").length == 0){
    		 $("#mystatus").click();
    	}
    });
    
    //设置和删除    
    $("#ticket_info").on("click",".myedit",function(){
    	var tr = $(this).parent().parent();
    	if("editTr" == tr.attr("name")){
    		//隐藏表单
    		$("#start_time").val('');
    		$("#end_time").val('');
    		$("input[name='limit_min']").val('');
    		$("input[name='limit_max']").val('');
    		$("#description").val('');
    		$("input[name='if_hide_desc']").prop("checked");
    		$("input[name='special_channels']").eq(1).attr("checked",true);
    		$("input[name='need_approve']").eq(1).attr("checked",true);
    		
    		tr.next().hide();
    		tr.removeAttr("name");
    	}else{

    		var edit = tr.find("input[name='edit']").val();

    		//隐藏已经打开的下拉框
    		$("#ticket_info").find("tr[ticketinfo='tk']").each(function(){
    			if ($(this).attr('name') == 'editTr'){
    	    		$("#start_time").val('');
    	    		$("#end_time").val('');
    	    		$("input[name='limit_min']").val('');
    	    		$("input[name='limit_max']").val('');
    	    		$("#description").val('');
    	    		$("input[name='if_hide_desc']").prop("checked");
    	    		$("input[name='special_channels']").eq(1).attr("checked",true);
    	    		$("input[name='need_approve']").eq(1).attr("checked",true);
    	    		
    	    		$(this).next().hide();
    	    		$(this).removeAttr("name");
    			} 
    		});

    		//修改要打开的表信息
			if(edit){//edit有值时
	    		edit = eval('[{'+edit+'}]');
	    		$("#start_time").val(edit[0].event_start_time);
	    		$("#end_time").val(edit[0].event_end_time);
	    		$("input[name='limit_min']").val(edit[0].limit_min);
	    		$("input[name='limit_max']").val(edit[0].limit_max);
	    		$("#description").val(edit[0].description ? edit[0].description : '');
	    		if(edit[0].if_hide_desc == 1){
	    			$("input[name='if_hide_desc']").prop("checked",true);
	    		}
	    		else if(edit[0].if_hide_desc == 2){
	    			$("input[name='if_hide_desc']").removeAttr("checked");
	    		}
	    		else{
	    			$("input[name='if_hide_desc']").prop("checked",true);
	    		}
	    		$("input[name='special_channels']").eq(edit[0].special_channels-1).prop("checked",true);
	    		$("input[name='need_approve']").eq(edit[0].need_approve-1).prop("checked",true);
    		}else{
    			//没有值显示默认值
    			$("#start_time").val(myTime(new Date()));//当前时间
	    		$("#end_time").val( $("#event_end_time").val() ? myTime(new Date($("#event_end_time").val())) : '');//活动结束时间
	    		$("input[name='limit_min']").val(1);
	    		$("input[name='limit_max']").val(1);
	    		$("#description").val('');
	    		$("input[name='if_hide_desc']").prop("checked",true);
	    		$("input[name='special_channels']").eq(1).prop("checked",true);
	    		$("input[name='need_approve']").eq(1).prop("checked",true);
    		}
			//打开下拉
			tr.attr("name","editTr").after($("#ticket_info tr[name='edit']").show());
//    		}	    		
    	}
    });
    
    //门票删除
    $("#ticket_info").on("click",".mydel",function(){
    	if(confirm("确认删除吗？")){
    		if(parseInt($(this).parent().parent().find("input[name='qty']").attr("saleqty"))){
    			alert("已售票，不能删除");
    		}else{
    			var len = $("tr[ticketinfo='tk']").length;
    			if(len == 1){
    				alert("无法删除，请至少保留一种门票!");
    				return false;
    			}
    			
    			$(this).parent().parent().remove();
    			totalNum();
    		}
    		
    	}
    });
   
    //收集设置信息
    $("#ticket_info").on("click","#editSave",function(){
    	var event_start_time = $("#start_time").val();
    	var event_end_time = $("#end_time").val();
    	var limit_min =  $("input[name='limit_min']").val();
    	var limit_max =  $("input[name='limit_max']").val();
    	var description =  $(":input[name='description']").val();
    	var if_hide_desc = $("input[name='if_hide_desc']:checked").val() ? 1 : 2 ;
    	var special_channels = $("input[name='special_channels']:checked").val() ;
    	var need_approve = $("input[name='need_approve']:checked").val() ;
    	
    	event_start_time = event_start_time ? event_start_time : 0;
    	event_end_time = event_end_time ? event_end_time : 0;
    	limit_min = limit_min ? limit_min : 1;
    	limit_max = limit_max ? limit_max : 1;
    	if(limit_min > limit_max){limit_max = limit_min;}
    	description = description ? description : '';
    	
    	$("tr[name='editTr'] input[name='edit']").val('"event_start_time":"'+event_start_time+'","event_end_time":"'+event_end_time+'","limit_min":"'+limit_min+'","limit_max":"'+limit_max+'","description":"'+description+'","if_hide_desc":"'+if_hide_desc+'","special_channels":"'+special_channels+'","need_approve":"'+need_approve+'"');
    	$("tr[name='edit']").hide();
    	$("tr[name='editTr']").removeAttr("name");
    	
    	$("#start_time").val('');
    	$("#end_time").val('');
    	$("input[name='limit_min']").val('');
    	$("input[name='limit_max']").val('');
    	$(":input[name='description']").val('');
    	$("input[name='if_hide_desc']:checked").removeAttr("checked");
    	totalNum();
    	
    });
    
    $("#ticket_info").on("click","#editCancel",function(){
    	$("tr[name='edit']").hide();
    	$("tr[name='editTr']").removeAttr("name"); 	
    });
    

});

//信息收集函数
function getTicketInfo(){
	var info = [];
	var name = '';
	var tid = 0;
	var qty = 0;
	var saleqty = 0;
	var price = '0.0';
	var status = 1;
	var edit = '';
	var type = 1;
	var channel_type = '';
	var event_id = getQueryString("event_id");
	var is_invoice = $("#mystatus:checked").val() ? 1 : 2;
	var invoice = 0;
	if(is_invoice == 1){
//		is_invoice = 1;
		$("input[name='status']:checked").each(function(){invoice = parseInt(invoice) + parseInt($(this).val());});
//		invoice
	}else{
		is_invoice = 2;
	}
	
	$("#ticket_info").find("tr[ticketinfo='tk']").each(function(){
		name = $(this).find("input[name='name']").val();
		tid = $(this).find("input[name='name']").attr("tid");
		qty = $(this).find("input[name='qty']").val();
		saleqty = $(this).find("input[name='qty']").attr("saleqty");
		price = $(this).find("input[name='price']").val();
		if($(this).find(".ticstatus").html() == '正常售票'){
			status = 1;
		}else{
			status = 2;
		}
//		status = $(this).find(".ticstatus").attr("ticstatus");
		edit = $(this).find("input[name='edit']").val();
		type = (price == 0) ? 2 : 1;
		
		if(edit){
			info.push('"id":"'+tid+'","name":"'+name+'","qty":"'+qty+'","saleqty":"'+saleqty+'","price":"'+price+'","status":"'+status+'","type":"'+type+'",'+edit);
		}else{
			info.push('"id":"'+tid+'","name":"'+name+'","qty":"'+qty+'","saleqty":"'+saleqty+'","price":"'+price+'","status":"'+status+'","type":"'+type+'"');
		}

	});
	var json = '{';
	json += '"is_invoice":"'+is_invoice+'","invoice":"'+invoice+'","event_id":"'+event_id+'","list":[' ;
	
	for(var i=0; i <　info.length ; ++i){
		json = json+'{'+info[i]+'}';
		if((info.length-1) == i){
			break;
		}else{
			json += ',';
		}
	}
	json += ']}';
	
	
	return json;
}

//门票总数量
function totalNum(){
	var totalnum = 0;
	$("#ticket_info input[name='qty']").each(function(){
		if(!isNaN(parseInt($(this).val()))){
			totalnum += parseInt($(this).val());
		}
//		totalnum += $(this).val()　? parseInt($(this).val()) : 0 ;
	});
	
	$("#totalnum").text('总数量：'+totalnum);
}

/**
 * 加载门票信息
 */
function loadTicket(){
	var event_id = getQueryString("event_id");
	var url = js_huodongshu_domain +"/event/lsticket.do";
	
	$.ajax({url: url,
		type:"POST",		
		data:"event_id="+event_id,	
		success:function(msg){
			if(parseInt(msg.status)){
				var temp = eval(msg.data);
				var len = temp.length;
				var tr = '';
				var edit = '';
				
				//发票设置
				if(temp[0].is_invoice == 1){//需要发票时
					$("input[name='mystatus']").prop("checked",true);
					$("#fapiao").show();//显示发票类型
					if(temp[0].invoice == 2 || temp[0].invoice == 1){//提供一种
						$("input[name='status']").eq(temp[0].invoice-1).prop("checked",true);
					}else if(temp[0].invoice == 0){//为0时不提供
						$("input[name='status']").each(function(){$(this).removeAttr("checked")});
					}else if(temp[0].invoice == 3){//为3时都提供
						$("input[name='status']").each(function(){$(this).prop("checked",true)});
					}
				}else{//不要发票
					$("input[name='mystatus']").removeAttr("checked");
				}
				
				
				for(var i=0;i<len;++i){
					tr = $("#ticket_info tr").first().clone(true);
					tr.removeAttr("style");
					tr.attr("ticketinfo","tk");
					
					if(temp[i].saleqty > 0){
//						tr.removeAttr("ticketinfo");
						//已销售门票
						tr.find("input[name='name']").css("display","none").siblings().removeAttr("style").text(temp[i].name);
						tr.find("input[name='qty']").css("display","none").siblings().removeAttr("style").text(temp[i].qty);
						tr.find("input[name='name']").val(temp[i].name);
						tr.find("input[name='name']").attr("tid",temp[i].id);
						tr.find("input[name='qty']").val(temp[i].qty);
						tr.find("input[name='qty']").attr("saleqty",temp[i].saleqty);
					}else{
						//未销售过的门票
						tr.find("input[name='name']").val(temp[i].name);
						tr.find("input[name='name']").attr("tid",temp[i].id);
						tr.find("input[name='qty']").val(temp[i].qty);
						tr.find("input[name='qty']").attr("saleqty",temp[i].saleqty);
					}
					
					//免费门票和收费门票区分处理
					if(temp[i].type == 1){
						if(temp[i].saleqty > 0){
							tr.find("input[name='price']").hide().siblings().show().text(temp[i].price);
						}else{
							tr.find("input[name='price']").val(temp[i].price);
						}
					}else{
						tr.find("input[name='price']").val(0);
						tr.find("input[name='price']").hide().siblings().show().text("免费");
					}
					
					temp[i].description = temp[i].description ? temp[i].description : '';//解决默认值为null
					edit = '"event_start_time":"'+myTime(temp[i].start_time*1000)+'","event_end_time":"'+myTime(temp[i].end_time*1000)+'","limit_min":"'+temp[i].limit_min+'","limit_max":"'+temp[i].limit_max+'","description":"'+temp[i].description+'","if_hide_desc":"'+temp[i].if_hide_desc+'","special_channels":"'+temp[i].special_channels+'","need_approve":"'+temp[i].need_approve+'"';
					tr.find("input[name='edit']").val(edit);
					
//					tr.find("#event_address_grade1").attr("ticstatus",temp[i].status);
					if(temp[i].status == 1){
						tr.find(".ticstatus").text("正常售票");
					}else{
						tr.find(".ticstatus").text("暂停售票");
					}
			    	$("#ticket_info").append(tr);
			    	totalNum();
			    	UIselect();
				}
			}
			else{
				tr = $("#ticket_info tr").first().clone(true);
				tr.removeAttr("style");
				tr.attr("ticketinfo","tk");
				tr.find("input[name='name']").val('入场票');
				tr.find("input[name='qty']").val('70');
				tr.find("input[name='qty']").attr("saleqty",'0');
				tr.find("input[name='price']").val(0);
				tr.find("input[name='price']").hide().siblings().show().text("免费");
				
//				edit = '"if_hide_desc":"1"';
//				tr.find("input[name='edit']").val(edit);
				
				$("#ticket_info").append(tr);
				totalNum();
		    	UIselect();
			}
		}
	});	
}


/**
 * 时间转换
 * @param 2014/8/15 10:26
 * @returns {String}
 */
function myTime(timestamp){
	if(!timestamp){
		return '';
	}
	var d = new Date(timestamp);
	if(d.getHours() == 0){
		return  d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+" 00:"+d.getMinutes();
	}
	if(d.getMinutes() == 0){
		return  d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "+d.getHours()+":00";
	}
	return  d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "+d.getHours()+":"+d.getMinutes();
}
