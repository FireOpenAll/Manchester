$(document).ready(function(){
	changeLevel2(1,'level',"select_address_grade1");
	//加载当前用户信息
	loadcurrentUser();
	//表单验证
	account_validate();
	var result = getQueryString("errormessage");
	if(result){
		alert(result);
	}
});//end document.ready

//加载当前用户信息
function loadcurrentUser(){
	 var url = js_huodongshu_domain+'/account/getcustbaseinfo.do';
	  $.ajax({
			url: url,
			dataType: "json",
			success: function(msg){
               var custinfo = msg.data;
               var username = $.trim(custinfo.username);
               $("#account_username").html(username);
               var name = $.trim(custinfo.name);
               $("#account_realname").val(name);
               //性别
               if(custinfo.gender == 1){
	            	  $("#account_gender_type_1").attr("checked","checked");
	           }else if(custinfo.gender == 0){
	            	  $("#account_gender_type_2").attr("checked","checked");
	           }
               
               var company = $.trim(custinfo.company);
               $("#account_company").val(company);
               
               var account_job =  $.trim(custinfo.job_title);
               $("#account_job").val(account_job);
               
               var account_mobile = $.trim(custinfo.mobile);
               $("#account_mobile").html(account_mobile);
               
               var account_email = $.trim(custinfo.email);
               $("#account_email").html(account_email);
               
               
               //三级地址
               $("#select_address_grade1").val(msg.data.province);
	           whenproviceselect2("select_address_grade1");
	           $("#select_address_grade2").val(msg.data.city);
	           whenproviceselect2("select_address_grade2");
	           $("#select_address_grade3").val(msg.data.district);
               
               //详细地址
               var account_address =  $.trim(custinfo.address);
               $("#account_address").val(account_address);
               
               var userdescription =  $.trim(custinfo.description);
               $("#userdescription").val(userdescription);

               //logo
               var logoimg = $.trim(custinfo.headimg);
               if(logoimg != ''){
            	   $("#img_account_logo_src").attr("src",logoimg);
            	   $("#img_account_logo_src_li").attr("class","form file_ok");
               }
              
               
			}
	   });
}
//表单验证
function account_validate(){
	
	jQuery.validator.addMethod('account_logo_judge',   
	function(){
		 var str = document.getElementById("account_logo_id").value;
		 var imgsrc = $("#img_account_logo_src").attr("src");
		 imgsrc = $.trim(imgsrc);
		 str = $.trim(str);
		 if(imgsrc != ''){
			 return true;
		 }
		 if(str == ''){
			 return false;
		 }
		return true;
	});
	
	jQuery.validator.addMethod('checke_realname',   
			function(){
				var name = $("input[name='account_realname']").val();
				name = $.trim(name);
				return huodongshu_word_check(name);
			},'<font color=\'red\'>真实姓名不能含特殊字符!<font>');
	
	$("#account_base_validateform").validate({
        rules: {
			'account_realname':{
		        required:true,
		        checke_realname:true,
		        maxlength:10,
		        minlength:2
			},
			'account_logo':{
				account_logo_judge:true
			},
			'account_company':{
				maxlength:30,
			    minlength:2
			},
			'account_job':{
				maxlength:20,
			    minlength:2
			},
//			'account_mobile':{
//				required:true
//			},
//			'account_email':{
//				email:true
//			},
			'select_address_grade3':{
				required:true
			},
			'account_address':{
				maxlength:30,
			    minlength:2
			},
			'userdescription':{
				maxlength:200
			}
        },
        messages: {
			'account_realname': {
        	    required:"<font color='red'>真实姓名必填!<font>",
        	    maxlength:"<font color='red'>真实姓名名最长10位!<font>",
		        minlength:"<font color='red'>真实姓名最短2位!<font>"
			},
			'account_logo': {
				account_logo_judge: "<font color='red'>请上传logo!<font>"
			},
			'account_company': {
				 maxlength:"<font color='red'>公司名最长30位!<font>",
			     minlength:"<font color='red'>公司名最短2位!<font>"
			},
			'account_job': {
				 maxlength:"<font color='red'>职位名最长20位!<font>",
			     minlength:"<font color='red'>职位名最短2位!<font>"
			},
//			'account_mobile': {
//        	    required: "<font color='red'>xxx<font>"
//			},
//			'account_email': {
//				email: "<font color='red'>邮箱格式有误！<font>"
//			},
			'select_address_grade3': {
        	    required: "<font color='red'>请选择地址！<font>"
			},
			'account_address': {
        	    maxlength:"<font color='red'>详细地址最长30位!<font>",
			    minlength:"<font color='red'>详细地址最短2位!<font>"
			},
			'userdescription': {
        	    maxlength:"<font color='red'>个人介绍200字以内!<font>"
			}
			
       },
       errorPlacement:function(error, element){
    	   if(element.is("input[name='account_realname']")){
    		   $("#error_account_realname").html(error);
    	   }else if(element.is("input[name='account_logo']")){
    		   $("#error_account_logo").html(error);
    	   }else if(element.is("input[name='account_company']")){
    		   $("#error_account_company").html(error);
    	   }else if(element.is("input[name='account_job']")){
    		   $("#error_account_job").html(error);
    	   }
//    	   else if(element.is("input[name='account_mobile']")){
//    		   $("#error_account_mobile").html(error);
//    	   }else if(element.is("input[name='account_email']")){
//    		   $("#error_account_email").html(error);
//    	   }
    	   else if(element.is("input[name='select_address_grade3']")){
    		   $("#error_select_address").html(error);
    	   }else if(element.is("input[name='account_address']")){
    		   $("#error_account_address").html(error);
    	   }else if(element.is("textarea[name='userdescription']")){
    		   $("#error_account_userdescription").html(error);
    	   }
    	  
       }//,
//        submitHandler: function(){
//    	   account_base_save();
//        }
	});
	
}
//账户基本信息保存
function account_base_save(obj){
	    $(obj).attr("disabled","disabled");
		var account_realname = $("#account_realname").val(); account_realname = $.trim(account_realname);
		//图像，
		var account_gender_type = $("input[name='account_gender_type']:checked").val();
		var account_company = $("#account_company").val(); account_company = $.trim(account_company);
		var account_job = $("#account_job").val(); account_job = $.trim(account_job);
//		var account_mobile = $("#account_mobile").val(); account_mobile = $.trim(account_mobile);
//		var account_email = $("#account_email").val(); account_email = $.trim(account_email);
		//三级地址
	    var select_address_grade1 =  $("#select_address_grade1").val();
	    var select_address_grade2 =  $("#select_address_grade2").val();
	    var select_address_grade3 =  $("#select_address_grade3").val();
	    
		var account_address = $("#account_address").val(); account_address = $.trim(account_address);
		var userdescription = $("#userdescription").val(); userdescription = $.trim(userdescription);

		var custinfo =  '{"account_realname":"'+account_realname +'",'+
	    '"account_gender_type":"'+account_gender_type+'",'+
	    '"account_company":"'+account_company+'",'+
	    '"account_job":"'+account_job+'",'+
//	    '"account_mobile":"'+account_mobile+'",'+
//	    '"account_email":"'+account_email+'",'+
	    '"select_address_grade1":"'+select_address_grade1+'",'+
	    '"select_address_grade2":"'+select_address_grade2+'",'+
	    '"select_address_grade3":"'+select_address_grade3+'",'+
	    '"account_address":"'+account_address+'",'+
	    '"userdescription":"'+userdescription+'"'+
		   '}';
		$("input[name='cust_hidden_info']").val(custinfo);
		$(obj).attr("disabled",false);
		$("#account_base_validateform").submit();
	
	
}