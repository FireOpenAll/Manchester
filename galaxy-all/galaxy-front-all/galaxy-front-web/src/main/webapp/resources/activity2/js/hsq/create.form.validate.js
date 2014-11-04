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
					var str = value.replace(/(^\s*)|(\s*$)/g,"");
					return isNoSpecialChar(str); 
				},
				'<span class="icon"></span><font color=\'red\'>不能含特殊字符！</font>'
				);
	    
		//手机号检验		
		jQuery.validator.addMethod('CheckPhone',
				function(value,element){
			    //var regex = '^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$';
			    return this.optional(element) || /^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$/i.test(value);
				},
				'<span class="icon"></span><font color=\'red\'>手机号格式不正确！</font>'
				);
		
		//门票数量设置
		jQuery.validator.addMethod('checkTicketNum',
				function(value,element){
			    return this.optional(element) || value>0;
				},
				'<span class="icon"></span><font color=\'red\'>请输入正确的数值！</font>'
				);
		
		//门价格设置
		jQuery.validator.addMethod('checkTicketPrice',
				function(value,element){
			    return this.optional(element) || value>=0;
				},
				'<span class="icon"></span><font color=\'red\'>请输入正确的数值！</font>'
				);
		
		//tags
		//门价格设置
		jQuery.validator.addMethod('checkTags',
				function(value,element){
			    return this.optional(element) || value.length<200;
				},
				'<span class="icon"></span><font color=\'red\'>关键词最多200 个字符</font>'
				);
	  
});

/*没有特殊字符*/
function isNoSpecialChar(str){
    str = str.replace(/(^\s*)|(\s*$)/g,"");
    if(str.indexOf("\"") == -1 && str.indexOf("'") == -1 && str.indexOf("<") == -1 && str.indexOf(">") == -1  && str.indexOf("*") == -1  && str.indexOf("%") == -1 && str.indexOf("&") == -1 && str.indexOf("$") == -1    && str.indexOf("!") == -1){
      return true;
    }    
    return false;
}

