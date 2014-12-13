<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp" %>
		<div class="modal-content">
			<div class="modal-header">
			    <button type="button" class="close" data-dismiss="modal">x</button>
			    <!-- TODO：根据是否有id来判断是 编辑 还是 新增 -->
			    <c:if test="${product.id != null}">
			    	  编辑商品
			    </c:if>
			    <c:if test="${product.id == null}">
			    	  添加商品
			    </c:if>
			  
			</div>
			<div class="modal-body">
				<form action="add" id=productForm method="post" class="form-horizontal" >
					<div class="form-group">
						<input type="hidden" name="id" id="id" value="${product.id }">
						<label class="col-sm-3 control-label no-padding-right" for="name">商品名称:</label>
						<div class="col-sm-9">
							<input type="text" name="name" id="name" value="${product.name }" >
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
					<button class="btn btn-sm btn-primary" id="sub">提  交</button>
					<button class="btn btn-sm" data-dismiss="modal">关  闭</button>
			</div>
		</div>		
	<!-- js --> 
<script type="text/javascript" src="${ctx}/assets/admin/product.js"></script> 