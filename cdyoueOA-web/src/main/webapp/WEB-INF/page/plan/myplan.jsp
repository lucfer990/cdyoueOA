<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- 引入公共css -->
    <%@ include file="/common/base_css.jsp" %>
    <link rel="stylesheet" href="${basePath}/css/myplan.css"/>
    <title>制定的计划</title>
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
                    <li><i class="icon-home home-icon"></i> <a href="${basePath}/index.do">首页</a></li>
                </ul>
            </div>

            <!-- 页面内容 -->
            <div class="page-content">

                <!-- 页面概述 -->
                <div class="page-header">
                    <h1>
                        <i class="icon-tasks"></i>&nbsp;
                        您制定的计划
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
                                    已发布计划
                                </a>
                            </li>
                            <li>
                                <a data-tag="0" data-toggle="tab" href="#tab1">
                                    <i class="green icon-calendar-empty bigger-110"></i>
                                    未发布计划
                                </a>
                            </li>
                            <li>
                                <a data-tag="3" data-toggle="tab" href="#tab1">
                                    <i class="green icon-check bigger-110"></i>
                                    已完成计划
                                </a>
                            </li>
                            <li>
                                <a data-tag="" data-toggle="tab" href="#tab1">
                                    全部计划
                                </a>
                            </li>
                        </ul>
                        <!-- 标签内容 -->
                        <div class="tab-content">

                            <div id="tab1" class="tab-pane in active">

                                <div class="col-sm-12 te">
                                    <div class="form-inline">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <%--工具栏--%>
                                                <div class="form-group">
                                                    <input type="hidden" id="add_discount_baseinfoId" name="baseinfoId"
                                                           value="${baseinfoId}"/>
                                                    <label class="sr-only"></label>
                                                    <input type="text" class="form-control" id="plan_title" required="required" placeholder="计划名称"/>
                                                </div>
                                                <button id="search" class="btn btn-info" type="button">
                                                    <i class="icon-search"></i>
                                                </button>
                                                <button type="button" id="addbtn" class="btn btn-info right">
                                                    <i class="icon-edit"></i>制定计划
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <table id="dg_discountlist" data-toggle="table" data-toolbar="#toolbar"
                                           data-click-to-select="true" data-url="${basePath}/plan/findPlan.do?status=1"
                                           data-pagination="true" data-side-pagination="server" data-page-list="[10,25,50]">
                                        <thead>
                                        <tr>
                                            <th data-radio="true"></th>
                                            <th data-field="id">编号</th>
                                            <th data-field="title">计划名称</th>
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

</div>
<!-- /.main-container -->

<!-- 页面特定js -->

<script type="text/javascript" src="${basePath}/static/js/myplan.js"></script>
</body>
</html>