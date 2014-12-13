<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal small fade" id="confirmDialog" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<span id="confirmDialog_title"></span>
			</div>
			<div class="modal-body">
				<i class="icon-info-sign"></i><span id="confirmDialog_content"></span>
			</div>
			<div class="modal-footer">
				<button class="btn btn-xs btn-danger" data-dismiss="modal" id="confirmDialog_ok"></button>
				<button class="btn btn-xs" data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
</div>