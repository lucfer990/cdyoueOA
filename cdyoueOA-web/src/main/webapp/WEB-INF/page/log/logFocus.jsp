<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- 引入公共css -->
<%@ include file="/common/base_css.jsp"%>
<title>日志关注</title>
<!-- 引入公共js -->
<%@include file="/common/base_js.jsp"%>
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

				<!-- 导航栏 -->
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a
							href="${basePath}/index.do">首页</a></li>
					</ul>
				</div>

				<!-- 页面内容 -->
				<div class="page-content">

					<!-- 页面概述 -->
					<div class="page-header">
						<h1>
							<i class="icon-tasks"></i>&nbsp;日志关注
						</h1>
					</div>

					<!-- 页面主体 -->
					<div class="row col-xs-12">

						<div id="tab1" class="tab-pane in active">

							<div class="col-sm-12 te" style="float: none;">
								<form class="form-inline"
									id="add_discount_from" method="post">
									<div class="row">
										<div class="col-sm-12">
											<%--工具栏--%>
											<select name="platform" id="logType" class="chosen-select">
												<option value="">请选择日志类型</option>
												<option value="日报">日报</option>
												<!-- <option value="周报">周报</option>
												<option value="月度报告">月度报告</option>
												<option value="季度报告">季度报告</option>
												<option value="年度报告">年度报告</option> -->
											</select> 
											
											开始时间：<input class="span8 date-picker" name="START_TIME"
												id="startTime" value="" type="text"
												data-date-format="yyyy-mm-dd hh:ii" readonly="readonly"
												placeholder="开始时间" title="开始时间">

											<button id="search" class="btn btn-primary" type="button">
												<i class="icon-search"></i>搜索
											</button>
											<DIV style="float:right">
											<button type="button" id="getLogById" class="btn btn-info right">
                                                    <i class="icon-zoom-in"></i>日志详情
                                            </button>
											</DIV>
										</div>
									</div>
								</form>
							</div>
							<div>
								<table id="dg_discountlist" data-toggle="table"
									data-toolbar="#toolbar" data-click-to-select="true"
									data-url="${basePath}/aLog/gatLogFocus.do"
									data-pagination="true" data-side-pagination="server"
									data-page-list="[10,25,50]">
									<thead>
										<tr>
											<th data-radio="true"></th>
											<th data-field="id">编号</th>
											<th data-field="title">日志类型</th>
											<th data-field="content">内容</th>
											<th data-field="startTime" data-formatter="dateFmt">开始时间</th>
											<th data-field="endTime" data-formatter="dateFmt">终止时间</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 引入公共面包屑 -->
			<%@ include file="/common/breadCrumbs.jsp"%>
			<!-- 引入一级对话框界面 -->
                <%@ include file="myFocus_dialog.jsp" %>
		</div>
		<!-- 返回顶部 -->
		<%@ include file="/common/returnTop.jsp"%>
	</div>

	<!-- 页面特定js -->
	<script type="text/javascript"
		src="${basePath}/static/js/log/logFocus.js"></script>
</body>
</html>