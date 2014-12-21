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
							<li class="active">Error </li>
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
												<i class="icon-random"></i>
												参数错误
											</span>
										</h1>
										<hr />
										<div class="space"></div>
										<div>
											<h3 class="lighter smaller">参数错误:</h3>
											<ul class="list-unstyled spaced inline bigger-110 margin-15">
												<li>
													<i class="icon-hand-right blue"></i>
												  错误异常类:	${simpleName}
												</li>
												<li>
													<i class="icon-hand-right blue"></i>
												描述:	${description}
												</li>
												<li>
													<i class="icon-hand-right blue"></i>
												错误信息:	${message}
												</li>
											</ul>
										</div>
										<hr />
										<div class="space"></div>
										<div class="center">
											<a href="javascript:history.back()" class="btn btn-grey">
												<i class="icon-arrow-left"></i>
												Go Back
											</a>
											<a href="#" class="btn btn-primary">
												<i class="icon-dashboard"></i>
												Dashboard
											</a>
										</div>
									</div>
								</div>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->
<!-- 页脚 -->
<%@include file="/WEB-INF/views/common/footer.jsp"%>
