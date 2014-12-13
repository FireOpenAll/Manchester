<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="sidebar" id="sidebar">
	<ul class="nav nav-list">
			<li >
				<a href="#" class="dropdown-toggle">
					<i class="icon-user"></i>
					<span class="menu-text">管理</span>
					<b class="arrow icon-angle-down"></b>
				</a>
				<ul class="submenu">
						<li>
							<a href="${ctx}/list">
								<i class="icon-double-angle-right"></i>
								商品管理
							</a>
						</li>
						<li>
							<a href="${ctx}/list">
								<i class="icon-double-angle-right"></i>
								订单管理
							</a>
						</li>
						<li>
							<a href="${ctx}/list">
								<i class="icon-double-angle-right"></i>
								统计
							</a>
						</li>
				</ul>
			</li>
		
	</ul><!--/.nav-list-->
	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
	</div>
</div>