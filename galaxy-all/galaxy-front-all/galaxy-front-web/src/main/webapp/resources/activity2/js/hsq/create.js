$(function(){

	$("#start_time,#end_time").datetimepicker();
	//alert("aaaaa");
	//加载省份
	getProvince();
	//加载活动分类
	loadCategory();
	
	//提交事件
	$('input[name="Submit"]').click(function(){
        if($("#form").valid()){
        	$("#form").submit();
        } 
    });
	
	//表单验证
	$("#form").validate({
		rules:{
			name:{
				required : true,
				CheckSpecialChar:true
			},
			start_time:{
				required:true
			},
			end_time:{
				required:true,
				check_time:true,
				check_end_time:true
			},
			province:{
				required:true
			},
			city:{
				required:true
			},
			district:{
				required:true
			},
			address_detail:{
				required:true,
				CheckSpecialChar:true
			},
			haibao1:{
				required:true
			},
			haibao2:{
				required:true
			},
			haibao3:{
				required:true
			},
			sponsor:{
				required:true,
				CheckSpecialChar:true
			},
			phone:{
				required:true,
				CheckPhone:true
			},
			description:{
				required:true,
				CheckSpecialChar:true
			},
			detail:{
				required:true,
				CheckSpecialChar:true
			},
			ticket_name:{
				required:true,
				CheckSpecialChar:true
			},
			ticket_num:{
				required:true,
				digits:true,
				checkTicketNum:true
			},
			ticket_price:{
				required:true,
				number:true ,
				checkTicketPrice:true
			},
		
			category:{
				required:true,
			}
			
		},
		message:{
			name:{
				required:'请填写活动名称',
				CheckSpecialChar :'活动名称不能含有特许字符'
			},
			start_time:{
				required:'请选择活动开始时间'
			},
			end_time:{
				required:'请填写活动结束时间',
				check_time:'结束时间不能小于开始时间',
				check_end_time:'结束时间不能小于当前时间'
			},
			province:{
				required:'请选择活动所在省份'
			},
			ity:{
				required:'请选择活动所在城市'
			},
			district:{
				required:'请选择活动所在市区'
			},
			address_detail:{
				required:'请填写活动详细地址',
				CheckSpecialChar:'活动地址不能含有特殊字符'
			},
			haibao1:{
				required:'请选择海报'
			},
			haibao2:{
				required:'请选择海报'
			},
			haibao3:{
				required:'请选择海报'
			},
			sponsor:{
				required:'请填写活动主办方',
				CheckSpecialChar:'活动主办方不能含有特殊字符'
			},
			phone:{
				required:"请填写活动联系电话",
				CheckPhone:'请填写正确的联系电话'
			},
			description:{
				required:'请填写活动描述',
				CheckSpecialChar:'活动描述不能含有特殊字符'
			},
			detail:{
				required:'请填写活动详情',
				CheckSpecialChar:'活动详情不能含有特殊字符'
			},
			category:{
				required:'请选择活动分类',
			}
		}
	});


});

//加载活动分类
function loadCategory(){
	var url = '/activity/geteventcategory';
	var html = '';
	
	$.ajax({
        type: "GET",
        url: url,
        dataType:"json",
        data:{t:new Date()},
        success: function(msg) { 
        	//alert(msg.code);
        	if (msg.code == "20000") {
        		var categorylist = msg.data;
        		//alert(categorylist.length);
        		var len = categorylist.length;
		      	for(var i = 0; i < len; i++){
		      		var item = categorylist[i];
		      		var id = item.id;
		      		var name = item.name;
		      	    html += '<option class="text-center" value="'+id+ '">'+name+'</option>';
		      	}
		      	$("#category_select").html(html);
		      	//alert(html);
            }else{
            	alert("error");
            }
         }
     });
};
//加载活动分类

//设置活动分类
function setCategory(){
	var category=$("#category_select").val();
	//alert("category=="+category);
	$("#category").val(category);
	//var goal = $("#category").val();
	//alert("category=="+category);
}
//设置活动分类

