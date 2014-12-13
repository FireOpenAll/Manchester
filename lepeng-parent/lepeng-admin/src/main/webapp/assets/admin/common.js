/**
 * 分页
 * @param v 跳转的页码
 */
function pageJump(v){
	$("#pageNo").val(v);
	$("#searchForm").submit();
}	

function cleanFun(url) {
	//alert(url);
	$('#searchForm input').val('');
	window.location.href=url;
}


/**
 * 选中菜单
 */
$(function(){
	var local=location.href;
	local=local.substr(7);
	local=local.substr(local.indexOf("/"));
	if (local.indexOf("?")>=0) {
		local=local.substr(0,local.indexOf("?"));	
	}
	$("#sidebar").find(".active").removeClass("active");
	var obj=null;
	do{
		obj=$("#sidebar").find("a[href*='"+local+"']");
		if (obj.size()==0) {
			local=local.substr(0,local.lastIndexOf("/"));
		}
	} while (obj.size()==0&&local!="");
	if (obj.size()==1) {
		obj.parent().parent().show();
		obj.parent().addClass("active");
	} else if (obj.size()>1){
		obj.eq(0).parent().parent().show();
	}
});