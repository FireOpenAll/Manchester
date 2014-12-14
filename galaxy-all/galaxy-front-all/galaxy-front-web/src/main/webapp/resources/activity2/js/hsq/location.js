//显示省
function getProvince(){
	var url = '/location/province';
	
	var defaultProvince = '<option value="0">--省--</option>';
	var defaultCity = '<option value="0">--市--</option>';
	var defaultDistrict = '<option value="0">--区--</option>';
	
	$("#province_select").html(defaultProvince);
	$("#city_select").html(defaultCity);
	$("#district_select").html(defaultDistrict);
	
	var html=defaultProvince;
	//var html = $("#province_select").html(defaultProvince);

	$.ajax({
	        type: "GET",
	        url: url,
	        dataType:"json",
	        success: function(msg) { 
	        	//alert(msg.code);
	        	if (msg.code == "20000") {
	        		var provincelist = msg.data;
	        		//alert(provincelist.length);
	        		var len = provincelist.length;
			      	for(var i = 0; i < len; i++){
			      		var item = provincelist[i];
			      		var name = item.provinceName;
			      		var code = item.provinceCode;
			      	    html += '<option class="text-center" value="'+code+ '">'+name+'</option>';
			      	}
			      	$("#province_select").html(html);
			      	//alert(html);
	            }else{
	            	alert("error");
	            }
	         }
	});
}
//显示省

//显示市
function getCity(){

	var provinceCode = $("#province_select").val();
	
	//设置provice的input值
	$("#province").val(provinceCode);
	//设置provice的input值
	var url = '/location/city';
	
	var defaultCity = '<option value="0">--市--</option>';
	var defaultDistrict = '<option value="0">--区--</option>';
	$("#city_select").html(defaultCity);
	$("#district_select").html(defaultDistrict);
	
   var html =defaultCity;
	$.ajax({
	        type: "GET",
	        url: url,
	        dataType:"json",
	        data:{provinceCode:provinceCode,t:new Date()},
	        success: function(msg) { 
	        	//alert(msg.code);
	        	if (msg.code == "20000") {
	        		var citylist = msg.data;
	        		//alert(citylist.length);
	        		var len = citylist.length;
			      	for(var i = 0; i < len; i++){
			      		var item = citylist[i];
			      		var name = item.cityName;
			      		var code = item.cityCode;
			      	    html += '<option class="text-center" value="'+code+ '">'+name+'</option>';
			      	}
			      	$("#city_select").html(html);
			      	//alert(html);
	            }else{
	            	alert("error");
	            }
	         }
	});
}
//显示市

//显示区
function getDistrict(){
	
	var cityCode = $("#city_select").val();
	//设置city的input值
	$("#city").val(cityCode);
	//设置city的input值
	
	var url = '/location/area';
	
	var defaultDistrict = '<option value="0">--区--</option>';
	$("#district_select").html(defaultDistrict);
    var html =defaultDistrict;
	$.ajax({
	        type: "GET",
	        url: url,
	        dataType:"json",
	        data:{cityCode:cityCode,t:new Date()},
	        success: function(msg) { 
	        	//alert(msg.code);
	        	if (msg.code == "20000") {
	        		var districtlist = msg.data;
	        		//alert(districtlist.length);
	        		var len = districtlist.length;
			      	for(var i = 0; i < len; i++){
			      		var item = districtlist[i];
			      		var name = item.areaName;
			      		var code = item.areaCode;
			      	    html += '<option class="text-center" value="'+code+ '">'+name+'</option>';
			      	}
			      	$("#district_select").html(html);
			      	//alert(html);
	            }else{
	            	alert("error");
	            }
	         }
	});
}
//显示区

//设置区
function setDistrict(){
	//设置district的input值
	var dis = $("#district_select").val();
	//alert('dis='+dis);
	$("#area").val(dis);
	//var district = $("#district").val();
	//alert('district='+district);
}
//设置区