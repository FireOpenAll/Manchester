<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>登录</title>
	<meta name="description" content="User login page" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<%@include file="common/css.jsp" %>
</head>
<body class="login-layout">
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i>
								<span class="red">乐朋</span>
								<span class="white">Admin</span>
							</h1>
							<h4 class="blue">&copy; 乐朋股份</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box" class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i>
											Please Enter Your Information
										</h4>

										<div class="space-6"></div>

										<form action="${ctx}/list" method="post">
											<fieldset>
												<label class="block clearfix">
													<span class="block input-icon input-icon-right">
														<input type="text" name="userName" class="form-control" placeholder="用户名" value="admin"/>
														<i class="icon-user"></i>
													</span>
												</label>

												<label class="block clearfix">
													<span class="block input-icon input-icon-right">
														<input type="password" name="password" class="form-control" placeholder="密码" value="123"/>
														<i class="icon-lock"></i>
													</span>
												</label>

												<div class="space"></div>

												<div class="clearfix">
													<label class="inline">
														<input type="checkbox" class="ace" />
														<span class="lbl"> 记住我</span>
													</label>

													<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i>
														登  录
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>
									</div><!-- /widget-main -->
								</div><!-- /widget-body -->
							</div><!-- /login-box -->
						</div><!-- /position-relative -->
					</div>
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div>
	</div><!-- /.main-container -->
</body>
</html>
<%@include file="common/js.jsp" %>