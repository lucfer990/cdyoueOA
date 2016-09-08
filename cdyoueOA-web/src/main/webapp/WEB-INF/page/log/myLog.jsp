<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- 引入公共css -->
<%@ include file="/common/base_css.jsp"%>
<title>成都优易OA-我的日志</title>
<!-- 引入公共js -->
<%@include file="/common/base_js.jsp"%>
<link rel="stylesheet" href="${basePath}/css/ace/fullcalendar.css" />
<link rel="stylesheet" href="${basePath}/css/ace/datepicker.css" />
<link rel="stylesheet" href="${basePath}/css/ace/bootstrap-timepicker.css" />
<link rel="stylesheet" href="${basePath}/css/ace/daterangepicker.css" />
<!-- 页面特定js -->
<link rel="stylesheet" href="${basePath}/static/js/laydate/skins/molv/laydate.css" />
<script src="${basePath}/static/plugins/ace/jquery-ui-1.10.3.custom.min.js"></script>
<script src="${basePath}/static/plugins/ace/jquery.ui.touch-punch.min.js"></script>
<script src="${basePath}/static/plugins/ace/fullcalendar.min.js"></script>
<script src="${basePath}/static/plugins/ace/bootbox.min.js"></script>
<script src="${basePath}/static/plugins/ace/date-time/bootstrap-datepicker.min.js"></script>
<script src="${basePath}/static/plugins/ace/date-time/bootstrap-timepicker.min.js"></script>
<script src="${basePath}/static/plugins/ace/date-time/moment.min.js"></script>
<script src="${basePath}/static/plugins/ace/date-time/daterangepicker.min.js"></script>
<script src="${basePath}/static/plugins/ace/bootstrap-colorpicker.min.js"></script>
<script src="${basePath}/static/js/log/myLog.js"></script>
<script src="${basePath}/static/js/laydate/laydate.js"></script>
</head>
<body>
	<!-- 引入公共头部 -->
	<%@include file="/common/head.jsp"%>

	<div class="main-container" id="main-container">
		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<!-- 引入公共菜单栏 -->
			<%@include file="/common/menu.jsp"%>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a
							href="${basePath}/index.do">首页</a></li>
					</ul>
				</div>
				<div class="page-content">
					<div class="page-header">
						<h1>
							工作日志 <small> <i class="icon-double-angle-right"></i> 我的日志
							</small>
						</h1>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->

							<div class="row">
								<div class="col-sm-12">
									<div class="space"></div>
									<div id="calendar"></div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- 引入一级对话框界面 -->
                <%@ include file="myLog_dialog.jsp" %>
			 <!-- 引入二级对话框界面 -->
            <%@ include file="/common/departments.jsp" %>
			</div>
			<!-- 引入公共面包屑 -->
			<%@ include file="/common/breadCrumbs.jsp"%>
		</div>
		<!-- 返回顶部 -->
		<%@ include file="/common/returnTop.jsp"%>
	</div>
	<!-- /.main-container -->

</body>
</html>