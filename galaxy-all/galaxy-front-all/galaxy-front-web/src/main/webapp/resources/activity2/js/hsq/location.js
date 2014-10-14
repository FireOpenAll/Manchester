//显示省
function getProvince(){
	var url = '/api/v1/location/province';
	
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
			      		var name = item.province_name;
			      		var code = item.province_code;
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

	var province_code = $("#province_select").val();
	
	//设置provice的input值
	$("#province").val(province_code);
	//设置provice的input值
	var url = '/api/v1/location/city';
	
	var defaultCity = '<option value="0">--市--</option>';
	var defaultDistrict = '<option value="0">--区--</option>';
	$("#city_select").html(defaultCity);
	$("#district_select").html(defaultDistrict);
	
   var html =defaultCity;
	$.ajax({
	        type: "GET",
	        url: url,
	        dataType:"json",
	        data:{province_code:province_code,t:new Date()},
	        success: function(msg) { 
	        	//alert(msg.code);
	        	if (msg.code == "20000") {
	        		var citylist = msg.data;
	        		//alert(citylist.length);
	        		var len = citylist.length;
			      	for(var i = 0; i < len; i++){
			      		var item = citylist[i];
			      		var name = item.city_name;
			      		var code = item.city_code;
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
	
	var city_code = $("#city_select").val();
	//设置city的input值
	$("#city").val(city_code);
	//设置city的input值
	
	var url = '/api/v1/location/district';
	
	var defaultDistrict = '<option value="0">--区--</option>';
	$("#district_select").html(defaultDistrict);
    var html =defaultDistrict;
	$.ajax({
	        type: "GET",
	        url: url,
	        dataType:"json",
	        data:{city_code:city_code,t:new Date()},
	        success: function(msg) { 
	        	//alert(msg.code);
	        	if (msg.code == "20000") {
	        		var districtlist = msg.data;
	        		//alert(districtlist.length);
	        		var len = districtlist.length;
			      	for(var i = 0; i < len; i++){
			      		var item = districtlist[i];
			      		var name = item.district_name;
			      		var code = item.district_code;
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
	$("#district").val(dis);
	//var district = $("#district").val();
	//alert('district='+district);
}
//设置区