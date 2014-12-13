<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp"%>

<!-- content -->
<div class="main-content">
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li>
				<i class="icon-home home-icon"></i>
				<a href="#">管理</a>
			</li>
			<li>
				<a href="#">商品管理</a>
			</li>
		</ul><!-- .breadcrumb -->
	</div>
	<div class="page-content">
		<div class="page-header position-relative">
			<h1>
				<small> <i class="icon-user"></i> 商品管理</small>
			</h1>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<!--PAGE CONTENT BEGINS-->
				<form class="form-inline" method="post" action="${ctx}/list" id="searchForm">
					<input type="hidden" name="pageNo" id="pageNo">
					&nbsp;&nbsp;名称：<input type="text" name="name"  value="${queryCondition.name }" placeholder="网站名称" class="input-medium search-query">&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="submit" class="btn btn-xs btn-small btn-info" title="查找">
						查找 <i class="icon-search icon-on-right bigger-110"></i>
					</button>
					<button type="button" class="btn btn-xs btn-small btn-info" data-toggle="modal" href="#editDialog"title="新增"  onclick="edit('${ctx}/load')">
						新增 <i class="icon-plus-sign icon-on-right bigger-110"></i>
					</button>
				</form>
				<table id="sample-table-1"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th width="5%">序号</th>
							<th width="10%">网站名称</th>
							<th width="20%">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.resultList}"  var="o" varStatus="s" >
							<tr>
								<td>${(s.index+1)+((page.pageNo-1)*page.pageSize) }</td>
								<td>${o.name}</td>
								<td>
									<button type="button" class="btn btn-xs btn-small btn-info" data-toggle="modal" href="#editDialog"title="编辑"  onclick="edit('${ctx}/load?id=${o.id }')">
										<i class="icon-edit bigger-120" ></i>
									</button>
									<button class="btn btn-xs btn-danger" href="#confirmDialog" data-toggle="modal" title="删除" onclick="del('${o.id}');">
										<i class="icon-trash bigger-120"></i>
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- 分页 -->
				<ui:pageNavigator pageBean="${page}"  functionName="pageJump" modal="true"/>
				<!-- 分页 -->
				<!--PAGE CONTENT ENDS-->
			</div>
		</div>
	</div>
</div>


<!-- 删除——模态窗口 -->
<%@include file="/WEB-INF/views/common/confirm.jsp" %>
<!-- 编辑——模态窗口 -->
<%@include file="/WEB-INF/views/common/editDialog.jsp" %>

<%@include file="/WEB-INF/views/common/footer.jsp"%>
<script type="text/javascript" src="${ctx}/assets/admin/product.js"></script>