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
        		alert('long='+$('#longtitude').val()+';lat=' + $('#latitude').val());
            }else{
            	$('#longtitude').val(0.00);
        		$('#latitude').val(0.00);
        		alert('long='+$('#longtitude').val()+';lat=' + $('#latitude').val());
            }
         }
      });
}



