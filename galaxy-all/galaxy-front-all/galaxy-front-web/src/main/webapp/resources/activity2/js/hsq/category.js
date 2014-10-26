//加载活动分类
function loadCategory(){
	var url = '/activity/category/get';
	
	
	var defaultcat1 = '<option value="0">--分类1--</option>';
	var defaultcat2 = '<option value="0">--分类2--</option>';
	
	$("#category1").html(defaultcat1);
	$("#category2").html(defaultcat2);
	
	var html=defaultcat1;
	
	
	$.ajax({
        type: "GET",
        url: url,
        dataType:"json",
        data:{
        	level:1,
        	parent_id:0,
        	t:new Date()
	},
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
		      	$("#category1").html(html);
		      	//alert(html);
            }else{
            	alert("error");
            }
         }
     });
};
//加载活动分类



//显示二级分类
function getCategory2(){

	var cat1Id = $("#category1").val();
	
	//设置provice的input值
	$("#catId1").val(cat1Id);
	//设置provice的input值
	var url = '/activity/category/get';
	
	var defaultcat2 = '<option value="0">--分类2--</option>';
	$("#category2").html(defaultcat2);
	
   var html =defaultcat2;
	$.ajax({
	        type: "GET",
	        url: url,
	        dataType:"json",
	        data:{
	        	level:2,
	        	parent_id:cat1Id,
	        	t:new Date()
	         },
	        success: function(msg) { 
	        	//alert(msg.code);
	        	if (msg.code == "20000") {
	        		var catgory2list = msg.data;
	        		var len = catgory2list.length;
			      	for(var i = 0; i < len; i++){
			      		var item = catgory2list[i];
			      		var name = item.name;
			      		var id = item.id;
			      	    html += '<option class="text-center" value="'+id+ '">'+name+'</option>';
			      	}
			      	$("#category2").html(html);
			      	//alert(html);
	            }else{
	            	alert("error");
	            }
	         }
	});
}
//显示二级分类

//设置活动分类
function setCategory2(){
	var catId2=$("#category2").val();
	//alert("category=="+category);
	$("#catId2").val(catId2);
	//var goal = $("#category").val();
	//alert("category=="+category);
}
//设置活动分类