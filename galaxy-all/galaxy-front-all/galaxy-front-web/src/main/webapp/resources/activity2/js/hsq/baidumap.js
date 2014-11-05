//获取经纬度
function getPoint(str){
	var baseurl = 'http://api.map.baidu.com/geocoder/v2/?ak=CAmOf78i9fRk5nT89tt8c7Er&output=json';
	var url = baseurl + str;
	$.ajax({
        type: "GET",
        url: url,
        dataType:"jsonp",
        success: function(msg) { 
        	//alert(msg.code);
        	if (msg.status == '0') {
        		var point = msg.result.location;
        		
        		$('#longtitude').val(point.lng);
        		$('#latitude').val(point.lat);
        		//alert('long='+$('#longtitude').val()+';lat=' + $('#latitude').val());
            }
         }
      });
}

//通过isEqual工具方法判断数值是否相等
function isEqual(number1, number2, digits){
digits = digits == undefined? 10: digits; // 默认精度为10
return number1.toFixed(digits) === number2.toFixed(digits);
}


