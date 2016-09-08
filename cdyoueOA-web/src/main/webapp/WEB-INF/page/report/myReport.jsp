<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- 引入公共css -->
    <%@ include file="/common/base_css.jsp" %>
    <link rel="stylesheet" href="${basePath}/css/myReport.css"/>
    <title>工作报告</title>
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
                        工作报告
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
                                    我的报告
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
                                                <button type="button" id="delbtn" class="btn btn-danger right">
                                                    <i class="icon-trash"></i>删除报告
                                                </button>
                                                <button type="button" id="reportDetailId" class="btn btn-info right">
                                                    <i class="icon-zoom-in"></i>报告详情
                                                </button>

                                                <button type="button" id="savebtn" class="btn btn-purple right">
                                                    <i class="icon-edit"></i>写报告
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div>
                                    <table id="table_reportlist" data-toggle="table" data-toolbar="#toolbar"
                                           data-click-to-select="true" data-url="${basePath}/report/findReport.do?status=1"
                                           data-pagination="true" data-side-pagination="server" data-page-list="[10,25,50]">
                                        <thead>
                                        <tr>
                                            <th data-radio="true"></th>
                                            <th data-field="reportUser">报告人</th>
                                            <th data-field="taskId">关联任务</th>
                                            <th data-field="percent" data-formatter="percentFmt">任务进度</th>
                                            <th data-field="reportTime" data-formatter="dateFmt">汇报时间</th>
                                        </tr>
                                        </thead>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- 引入一级对话框界面 -->
                    <%@ include file="myReport_write.jsp" %>
                    <%@ include file="myReport_detail.jsp" %>
                    <!-- 引入二级对话框界面 -->
                    <%@ include file="/common/departments.jsp" %>

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

<script type="text/javascript" src="${basePath}/static/js/report.js"></script>
<script type="text/javascript">
    //实例化编辑器
    var content_reportDetail2 = UE.getEditor('content_reportDetail2',{
        initialFrameWidth : 800,
        initialFrameHeight: 600,
        readonly:true
    });
    var thereport;
    $(document).ready(function() {
        content_reportDetail2.ready( function() {
            if(thereport){
                content_reportDetail2.setContent(thereport.report);
            }
        } );
        //override dialog's title function to allow for HTML titles
        $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
            _title: function (title) {
                var $title = this.options.title || '&nbsp;'
                if (("title_html" in this.options) && this.options.title_html == true)
                    title.html($title);
                else title.text($title);
            }
        }));
        //写报告
        $("#savebtn").on('click', function (e) {
            e.preventDefault();
            var dialog = $("#dialog-message").removeClass('hide').dialog({
                modal: true,
                width: 1412,
                height: 845,
                title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>写周报</h4></div>",
                title_html: true,
                buttons: [
                    {
                        text: "取消",
                        "class": "btn btn-xs",
                        click: function () {
                            $(this).dialog("close");
                        }
                    },
                    {
                        text: "确定",
                        "class": "btn btn-primary btn-xs",
                        click: function () {
                            var reportForTask = $("#reportForTask").val();
                            var taskProgress=$("#taskProgress").val();
                            var reportObj=$("#reportObj").val();
                            var content = ue.getContent();
	                        	$.post(basePath +"/report/addReport.do",{
                                    reportForTask:reportForTask,
                                    taskProgress:taskProgress,
                                    reportObj:reportObj,
                                    content:content
	    						},function(){
	    							$.MsgBox.Alert('提示','保存成功！');
	    						});
	    						$(this).dialog("close");
                            $dg.bootstrapTable('refresh');
                        }
                    }
                ]
            });

            var taskid= $("#reportForTask option:selected").val();
            $.ajax({
                url: basePath + '/task/getTaskPerson.do',
                data:{taskid:taskid},
                type: 'post',
                success: function (resp) {
                    $.each(resp,function(index,data){
                        $("#reportObj").append("<option class='taskobjval"+index+"' value='"+data.assignerId+"'></option>");
                        $(".taskobjval"+index).text(data.assigner);

                        $('#reportObj').trigger("chosen:updated");

                    });
                },
                error: function () {
                    alert('获取汇报对象失败！');
                }
            });
        });
        //删除报告
        $("#delbtn").on('click', function (e) {
            e.preventDefault();
            var reportId = $('#table_reportlist').bootstrapTable('getSelections');
            if(reportId.length>0){
                $.MsgBox.Confirm('提示','是否删除',function(){
                    $.post(basePath +"/report/delReport.do",{
                                id:reportId[0].id
                            },
                            function(resp){
                                $.MsgBox.Alert('提示','删除成功');
                                $dg.bootstrapTable('refresh');
                            });
                });
            }else{
                $.MsgBox.Alert('提示','请先进行选择！');
            }
        });

        $("#open-dialog2").on('click', function (e) {
            e.preventDefault();

            var dialog = $("#depts-dialog").removeClass('hide').dialog({
                modal: true,
                width: 1412,
                height: 645,
                title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i> jQuery UI Dialog</h4></div>",
                title_html: true,
                buttons: [
                    {
                        text: "Cancel",
                        "class": "btn btn-xs",
                        click: function () {
                            $(this).dialog("close");
                        }
                    },
                    {
                        text: "OK",
                        "class": "btn btn-primary btn-xs",
                        click: function () {
                            $(this).dialog("close");
                        }
                    }
                ]
            });
        });
        //报告详情
$("#reportDetailId").on('click',function(e){
    e.preventDefault();
    var row = $('#table_reportlist').bootstrapTable('getSelections');
    /*id:reportId[0].id;*/
    if(row.length>0){
        $.ajax({
            url : basePath + "/report/getReportById.do",
            type : "post",
            data : "id="+row[0].id,
            dataType : "json",
            success : function(result) {
                var dialog = $("#dialog-reportDetail").removeClass('hide').dialog({
                    modal: true,
                    width: 1412,
                    height: 745,
                    title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>报告详情</h4></div>",
                    title_html: true,
                    buttons: [
                        {
                            text: "取消",
                            "class": "btn btn-xs",
                            click: function () {
                                $(this).dialog("close");
                            }
                        },
                    ]
                });
                $("#progress_detail").text(result.percent);
                $("#startTime_detail").text(new Date(result.reportTime).fmt("yyyy-MM-dd hh:mm"));
                content_reportDetail2.ready(function(){
                    content_reportDetail2.setContent(row[0].report);//赋值给UEditor
                    thereport=row[0];
                });
                $("#reportTileTime").text(new Date(result.reportTime).fmt("yyyy年MM月dd日"));
                $("#reportForTask_detail").val(result.taskId);
                if(result.reportUser){
                    $("#de1").text(result.reportUser);
                }else{
                    $("#de1").text("获取失败");
                }
                if(result.reportObject){
                    $("#de2").text(result.reportObject);
                }else{
                    $("#de2").text("暂无");
                }
                if(result.userId){
                    $("#de3").text(result.userId);
                }else{
                    $("#de3").text("暂无");
                }

            },
            error:function(){
                $.MsgBox.Alert('提示','报告详情获取失败！！');
            }
        })
    }else{
        $.MsgBox.Alert('提示','请先进行选择！');
    }

});
    });
</script>
</body>
</html>