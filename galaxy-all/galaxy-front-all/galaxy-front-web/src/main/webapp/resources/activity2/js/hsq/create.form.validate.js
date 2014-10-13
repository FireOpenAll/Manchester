$(function(){
	//检查开始时间和结束时间
	  jQuery.validator.addMethod('check_time',
				function(){
					var start_time = $("#start_time").val();
					start_time = start_time.replace(/-/g,'/');
					start_time = new Date(start_time).getTime();

					var end_time = $("#end_time").val();
					end_time = end_time.replace(/-/g,'/');
					end_time = new Date(end_time).getTime();
					if(end_time <  start_time){
						return false;
					}else{
						return true;
					}
				},
				'<span class="icon"></span><font color=\'red\'>结束时间不能小于开始时间</font>'
				);
	
	  //结束时间要大于当前时间
	    jQuery.validator.addMethod('check_end_time',
	    		function(){
	    			var end_time = $("#end_time").val();
	    			end_time = end_time.replace(/-/g,'/');
	    			end_time = new Date(end_time).getTime();
	    			var nowtime =  new Date().getTime();
	    			if(end_time <  nowtime){
	    				return false;
	    			}else{
	    				return true;
	    			}
	    		},
	    		'<span class="icon"></span><font color=\'red\'>结束时间不能小于当前时间</font>'
	    		);
	    //输入不能有特殊字符
		jQuery.validator.addMethod('CheckSpecialChar',
				function(value,element){
					var str = element.val().trim();
					return isNoSpecialChar(str); 
				},
				'<span class="icon"></span><font color=\'red\'>不能含特殊字符！</font>'
				);
	    
		//必选省
		
		
		//
	  
});

/*没有特殊字符*/
function isNoSpecialChar(str){
    str = $.trim(str);
    if(str.indexOf("\"") == -1 && str.indexOf("'") == -1 && str.indexOf("<") == -1 && str.indexOf(">") == -1  && str.indexOf("*") == -1  && str.indexOf("%") == -1 && str.indexOf("&") == -1 && str.indexOf("$") == -1    && str.indexOf("!") == -1){
      return true;
    }    
    return false;
}

