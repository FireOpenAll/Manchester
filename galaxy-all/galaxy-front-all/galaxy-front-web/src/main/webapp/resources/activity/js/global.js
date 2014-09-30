function getParam(key){
	var param = key;
	var allParam = location.search;
	var idx1 = allParam.indexOf(param+"=");
	var idx2 = allParam.indexOf("&",idx1);
	var val = "";
	if(idx1!=-1){
		if(idx2!=-1){
			val = allParam.substring(idx1+param.length+1,idx2);
		}else{
			val = allParam.substring(idx1+param.length+1);
		}
	}
	return val;
}
function isNull(str){
	return str == null || str == "null" || str === "" || str == "undefined" || typeof(str) == "undefined";
}