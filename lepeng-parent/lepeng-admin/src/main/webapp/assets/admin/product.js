
$(function() {
	$('#sub').on('click', function() {
			$("#productForm").submit();
	});
	
	/**
	 * 表单验证
	 */
	$('#productForm').validate({
		errorElement: 'div',
		errorClass: 'help-block',
		focusInvalid: false,
		rules: {
			name: {
				required: true
			}
			
		},
		messages: {
			name: {
				required: "请输入名称"
			}
			
		},
		invalidHandler: function (event, validator) { //display error alert on form submit   
			$('.alert-danger', $('.login-form')).show();
		},
		highlight: function (e) {
			$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
		},
		success: function (e) {
			$(e).closest('.form-group').removeClass('has-error').addClass('has-info');
			$(e).remove();
		},
		errorPlacement: function (error, element) {
			 error.appendTo(element.parent());  
		},
		submitHandler: function (form) {
			form.submit();
		},
		invalidHandler: function (form) {
		}
	});

});	


function del(id){
	var dialog=$("#confirmDialog");
	dialog.find("#confirmDialog_title").text("删除提示信息");
	dialog.find("#confirmDialog_content").text("你确定要删除此商品吗？");
	dialog.find("#confirmDialog_ok").text("删除");
	
	dialog.find("#confirmDialog_ok").click(function(){
		location.href="delete?id="+id;
	});
}
