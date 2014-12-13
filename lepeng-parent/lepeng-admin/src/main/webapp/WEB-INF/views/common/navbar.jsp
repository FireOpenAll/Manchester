<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="navbar navbar-default">
	<div class="navbar-container">
		<div class="navbar-header pull-left">
			<a href="#" class="navbar-brand">
				<small>
					<i class="icon-briefcase"></i> 商家管理系统
				</small>
			</a>
		</div>
		<div class="navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="light-blue">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle">
						<img class="nav-user-photo" src="${ctx}/assets/avatars/user.jpg" alt="Admin's Photo" />
						<span class="user-info">
							<small>欢迎您,</small>
						</span>
						<i class="icon-caret-down"></i>
					</a>

					<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li>
							<a href="#">
								<i class="icon-cog"></i>
								Settings
							</a>
						</li>
						<li>
							<a href="#">
								<i class="icon-user"></i>
								Profile
							</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="${ctx}/logout">
								<i class="icon-off"></i>
								Logout
							</a>
						</li>
					</ul>
				</li>
			</ul><!-- /.ace-nav -->
		</div><!-- /.navbar-header -->
	</div>
</div>