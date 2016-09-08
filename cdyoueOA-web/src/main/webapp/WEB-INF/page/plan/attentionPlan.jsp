<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- 引入公共css -->
    <%@ include file="/common/base_css.jsp" %>
    <link rel="stylesheet" href="${basePath}/css/myplan.css"/>
    <title>计划关注</title>
    <!-- 引入公共js -->
    <%@include file="/common/base_js.jsp" %>
</head>
<body>
<!-- 引入公共头部 -->
<%@include file="/common/head.jsp" %>

<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#"> <span
                class="menu-text"></span>
        </a>

        <!-- 引入公共菜单栏 -->
        <%@include file="/common/menu.jsp" %>

        <div class="main-content">

            <!-- 导航栏 -->
            <div class="breadcrumbs" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li><i class="icon-home home-icon"></i> <a href="${basePath}/main/index.do">首页</a></li>
                </ul>
            </div>

            <!-- 页面内容 -->
            <div class="page-content">

                <!-- 页面概述 -->
                <div class="page-header">
                    <h1>
                        <i class="icon-tasks"></i>&nbsp;
                        计划关注
                    </h1>
                </div>

                <!-- 页面主体 -->
                <div class="row col-xs-12">

                    <!-- 分类标签 -->
                    <div class="tabbable">
                        <!-- 标签名 -->
                        <ul class="nav nav-tabs" id="myTab">
                            <li class="active">
                                <a data-tag="1" data-toggle="tab" href="#tab1">
                                    <i class="green icon-calendar bigger-110"></i>
                                    当前计划
                                </a>
                            </li>
                            <li>
                                <a data-tag="3" data-toggle="tab" href="#tab1">
                                    <i class="green icon-calendar-empty bigger-110"></i>
                                    已完成计划
                                </a>
                            </li>
                        </ul>
                        <!-- 标签内容 -->
                        <div class="tab-content">

                            <div id="tab1" class="tab-pane in active">

                                <div class="col-sm-12 te" style="float: none;">
                                    <form class="form-inline"
                                          action="${pageContext.request.contextPath}/bus/addDiscount"
                                          id="add_discount_from" method="post">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <%--工具栏--%>
                                                <div class="col-sm-1" float="left" style="width:150px">
                                                    <input type="text" style="width:135px;" float="left" class="form-control" id="plan_title" required="required" placeholder="计划名称"/>
                                                </div>
                                                <div style="width:50px;float:left">
                                                <button float="left" id="search" class="btn btn-primary" type="button">
                                                    <i class="icon-search"></i>
                                                </button>
                                                </div>
                                                <button type="button" id="getPlanById" class="btn btn-info right">
                                                    <i class="icon-zoom-in"></i>计划详情
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div>
                                    <table id="dg_discountlist" data-toggle="table" data-toolbar="#toolbar"
                                           data-click-to-select="true" data-url="${basePath}/plan/findPlanAttention.do?status=1"
                                           data-pagination="true" data-side-pagination="server" data-page-list="[10,25,50]">
                                        <thead>
                                        <tr>
                                            <th data-radio="true"></th>
                                            <th data-field="id">编号</th>
                                            <th data-field="title">计划名称</th>
                                            <th data-field="endTime" data-formatter="dateFmtNOW">进程状态</th>
                                            <th data-field="belongTo" data-formatter="belongFmt">计划归属</th>
                                            <th data-field="startTime" data-formatter="dateFmt">开始时间</th>
                                            <th data-field="endTime" data-formatter="dateFmt">终止时间</th>
                                            <th data-field="status" data-formatter="statusFmt">状态</th>
                                        </tr>
                                        </thead>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- 引入一级对话框界面 -->
                    <%@ include file="myplan_dialog.jsp" %>
                    <!-- 引入二级对话框界面 -->
                    <%@ include file="/common/departments.jsp" %>
                    <!-- 引入任务分配二级对话框界面 -->
                    <%@ include file="tasksplit_dialog.jsp" %>

                    <!-- PAGE CONTENT ENDS -->
                </div><!-- /.row -->
            </div>
            <!-- /.page-content -->
        </div>
        <!-- /.main-content -->

        <!-- 引入公共面包屑 -->
        <%@ include file="/common/breadCrumbs.jsp" %>

    </div>
    <!-- /.main-container-inner -->

    <!-- 返回顶部 -->
    <%@ include file="/common/returnTop.jsp" %>
</div>
<!-- /.main-container -->

<!-- 页面特定js -->

<script type="text/javascript" src="${basePath}/static/js/attentionPlan.js"></script>
</body>
</html>