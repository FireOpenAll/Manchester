<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="editDialog" class="modal fade bs-example-modal-lg" role="dialog" tabindex="-1" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
		
		</div>
	</div>
</div>	
<script type="text/javascript">
function edit(url) {
	$.ajax({url:url,success:function(html) {
		if (html.indexOf("div")>0&&html.indexOf("modal-content")>0) {
			//成功
			$("#editDialog").find(".modal-content").eq(0).replaceWith($(html));
		} else {
			$("#editDialog").find(".modal-content").eq(0).html(html);
		}
	}});
}
</script>