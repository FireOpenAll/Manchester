<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
<script type="text/javascript" src="/resources/js/jquery.js"
	charset="utf-8"></script>
<script type="text/javascript"> 
$(function(){
	var url="http://localhost:8080/api/v1/chat/send"; 
	$("#btn").click(function(){ 
		var json=$("#content").val(); 
		 $.ajax({
		       url : url,
		       type : "POST", 
		       dataType:"json",
		       contentType:'application/json;charset=UTF-8',
		       data:json,
		       success:function(data) {
		        alert(data.userName);
		        },
		       error:function(e){
		    	   alert("err");
		    	   }
		 });
	});
	
   
});
</script>
</head>
<body>
	<textarea id="content" name="content" rows="20" cols="100"></textarea>
	<button id="btn">提交</button>
</body>
</html>