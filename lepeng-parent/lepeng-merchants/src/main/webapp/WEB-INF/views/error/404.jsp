<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp"%>
			<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li>
								<a href="#">Other Pages</a>
							</li>
							<li class="active">Error 404</li>
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<div class="error-container">
									<div class="well">
										<h1 class="grey lighter smaller">
											<span class="blue bigger-125">
												<i class="icon-sitemap"></i>
												404
											</span>
											页面未找到
										</h1>
										<hr />
										<h3 class="lighter smaller">我已经把家底翻遍了，但是还是没找到您要找的页面...</h3>
										<div>
											<div class="space"></div>
											<h4 class="smaller"></h4>
											<ul class="list-unstyled spaced inline bigger-110 margin-15">
												<li></li>
												<li></li>
												<li></li>
											</ul>
										</div>
										<hr />
										<div class="space"></div>

										<div class="center">
											<a href="javascript:history.back()" class="btn btn-grey">
												<i class="icon-arrow-left"></i>
												Go Back
											</a>
										</div>
									</div>
								</div><!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->
<!-- 页脚 -->
<%@include file="/WEB-INF/views/common/footer.jsp"%>

