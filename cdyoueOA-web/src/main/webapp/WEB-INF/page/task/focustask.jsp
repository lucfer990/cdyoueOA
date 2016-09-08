<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- 引入公共css -->
    <%@ include file="/common/base_css.jsp" %>
    <link rel="stylesheet" href="${basePath}/css/myplan.css"/>
    <title>任务关注</title>
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
                                您关注的任务
                    </h1>
                </div>

                <!-- 页面主体 -->
                <div class="row col-xs-12">

                    <!-- 分类标签 -->
                    <div class="tabbable">
                        <!-- 标签名 -->
                        <ul class="nav nav-tabs" id="myFocusTab">
                            <li class="active">
                                <a data-tag="1" data-toggle="tab" href="#tab1">
                                    <i class="green icon-calendar bigger-110"></i>
                                      进行中的任务                         
                                </a>
                            </li>                                                      
                             <li >
                                <a data-tag="0" data-toggle="tab" href="#tab1">
                                    <i class="green icon-calendar bigger-110"></i>
                                      废除的任务                         
                                </a>
                            </li>  
                                                                              
                             <li >
                                <a data-tag="2" data-toggle="tab" href="#tab1">
                                    <i class="green icon-calendar bigger-110"></i>
                                      暂停的任务                         
                                </a>
                            </li> 
                             <li >
                                <a data-tag="3" data-toggle="tab" href="#tab1">
                                    <i class="green icon-calendar bigger-110"></i>
                                      强制完成的任务                         
                                </a>
                            </li>
                            <li >
                                <a data-tag="4" data-toggle="tab" href="#tab1">
                                    <i class="green icon-calendar bigger-110"></i>
                                      已完成的任务                         
                                </a>
                            </li>      
                                  
                            <li>
                                <a data-tag="" data-toggle="tab" href="#tab1">
                                <i class="green icon-calendar bigger-110"></i>
                                    全部任务
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
                                                <div class="form-group">
                                                    <input type="hidden" id="add_discount_baseinfoId" name="baseinfoId"
                                                           value="${baseinfoId}"/>
                                                    <label class="sr-only"></label>
                                                    <input type="text" class="form-control" id="tf_title" required="required" placeholder="任务名称"/>                                                    
                                                    
                                                </div>
                                                <button id="tfsearch" class="btn btn-primary" type="button">
                                                    <i class="icon-search"></i>
                                                </button>                                                   
                                                <button type="button" id="tfdetail" class="btn btn-success right">
                                                    <i class="icon-zoom-in"></i>任务详情
                                                </button> 
                                                                                     
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div>
                                    <table id="dg_discountlist" data-toggle="table" data-toolbar="#toolbar"
                                           data-click-to-select="true" data-url="${basePath}/task/findfocusTask.do?status=1"
                                           data-pagination="true" data-side-pagination="server" data-page-list="[10,25,50]">
                                        <thead>
                                        <tr>
                                            <th data-radio="true"></th>
                                            <th data-field="id">任务编号</th>
                                            <th data-field="process" >进程状态</th>
                                            <th data-field="planName"  data-formatter="belongFmt">任务归属</th>
                                            <th data-field="title" >任务名称</th>                                            
                                            <th data-field="executorName" >执行人</th> 
                                            <th data-field="assignerName" >分配人</th>                                           
                                            <th data-field="startTime" data-formatter="dateFmt">开始时间</th>
                                            <th data-field="endTime" data-formatter="dateFmt">结束时间</th>
                                            <th data-field="emergency" data-formatter="emeFmt">紧急程度</th>
                                            
                                        </tr>
                                        </thead>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                   
                    <!-- PAGE CONTENT ENDS -->
                </div><!-- /.row -->
            </div>
            <!-- /.page-content -->
        </div>
        <!-- /.main-content -->

        <!-- 引入公共面包屑 -->
        <%@ include file="/common/breadCrumbs.jsp" %>
         <!-- 引入公共面包屑 -->
        <%@ include file="taskdetail_dialog.jsp" %>

    </div>
    <!-- /.main-container-inner -->

    <!-- 返回顶部 -->
    <%@ include file="/common/returnTop.jsp" %>
</div>
<!-- /.main-container -->

<!-- 页面特定js -->

<script type="text/javascript" src="${basePath}/static/js/focustask.js"></script>
</body>
</html>