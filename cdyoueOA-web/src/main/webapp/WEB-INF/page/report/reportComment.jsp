<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- 引入公共css -->
    <%@ include file="/common/base_css.jsp" %>
    <link rel="stylesheet" href="${basePath}/css/myReport.css"/>
    <title>报告评阅</title>
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
                        报告评阅
                    </h1>
                </div>

                <!-- 页面主体 -->
                <div class="row col-xs-12">

                    <!-- 分类标签 -->
                    <div class="tabbable">
                        <!-- 标签名 -->
                        <ul class="nav nav-tabs" id="mycommentTab">
                            <li class="active">
                                <a data-tag="" data-toggle="tab" href="#tab1">
                                    <i class="green icon-calendar-empty bigger-110"></i>
                                    全部评阅
                                </a>
                            </li>
                            <li>
                                <a data-tag="1" data-toggle="tab" href="#tab1">
                                    <i class="green icon-calendar bigger-110"></i>
                                    已评阅报告
                                </a>
                            </li>
                            <li>
                                <a data-tag="2" data-toggle="tab" href="#tab1">
                                    <i class="green icon-calendar-empty bigger-110"></i>
                                    待评阅报告
                                </a>
                            </li>
                            <li>
                                <a data-tag="3" data-toggle="tab" href="#tab1">
                                    <i class="green icon-calendar-empty bigger-110"></i>
                                    已关注报告
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
                                                    <button type="button" id="focusId" class="btn btn-info right">
                                                        <i class="icon-ok"></i>关注
                                                        <input type="text" hidden="hidden" id="hidenUserId">
                                                    </button>
                                                <button type="button" id="reportDetailId" class="btn btn-info right">
                                                    <i class="icon-zoom-in"></i>查看
                                                </button>
                                                <button type="button" id="savebtn" class="btn btn-purple right">
                                                    <i class="icon-edit"></i>写评阅
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div>
                                    <table id="table_reportComment" data-toggle="table" data-toolbar="#toolbar"
                                           data-click-to-select="true" data-url="${basePath}/report/findReportComment.do"
                                           data-pagination="true" data-side-pagination="server" data-page-list="[10,25,50]">
                                        <thead>
                                        <tr>
                                            <th data-radio="true"></th>
                                            <th data-field="id">编号</th>
                                            <th data-field="reportUser">报告人</th>
                                            <th data-field="commentStatus" data-formatter="commentStatusFmt">评阅状态</th>
                                            <th data-field="focusUsers" data-formatter="focusStatusFmt">关注状态</th>
                                            <th data-field="reportTime" data-formatter="dateFmt">汇报时间</th>
                                        </tr>
                                        </thead>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- 引入一级对话框界面 -->
                    <%@ include file="reportComment_write.jsp" %>
                    <%@ include file="reportComment_detail.jsp" %>
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
      //写报告评阅
    var reportComment_write = UE.getEditor('reportComment_write',{
        initialFrameWidth : 800,
        initialFrameHeight: 600
    });
    var content_report_write=UE.getEditor('content_report_write',{
        initialFrameWidth : 800,
        initialFrameHeight: 600,
        readonly:true
    });
     //查看报告评阅
    var content_reportDetail=UE.getEditor('content_reportDetail',{
        initialFrameWidth : 800,
        initialFrameHeight: 600,
        readonly:true
    });
    var conomment_reportDetail=UE.getEditor('conomment_reportDetail',{
        initialFrameWidth : 800,
        initialFrameHeight: 600,
        readonly:true
    });


    var therow;
    var row2;
    $(document).ready(function() {
        initFileInput("file-Portrait", "");
        content_report_write.ready( function() {
            if(therow){
                content_report_write.setContent(therow[0].reportContent);
            }
        } );

                content_reportDetail.ready( function() {
                    if(row2){
                        content_reportDetail.setContent(row2[0].reportContent);
                    }
                } );
                conomment_reportDetail.ready( function() {
                    if(row2){
                        conomment_reportDetail.setContent(row2[0].reportComment);
                    }
                } );

        $("#hidenUserId").val(${user.uid});
        //override dialog's title function to allow for HTML titles
        $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
            _title: function (title) {
                var $title = this.options.title || '&nbsp;'
                if (("title_html" in this.options) && this.options.title_html == true)
                    title.html($title);
                else title.text($title);
            }
        }));
    });

    //写报告评阅
    $("#savebtn").on('click', function (e) {
        e.preventDefault();
        var row = $('#table_reportComment').bootstrapTable('getSelections');
        therow=row;
        if(row.length>0){
            if(row[0].commentStatus==2){
                var dialog = $("#dialog-message").removeClass('hide').dialog({
                    modal: true,
                    width: 1412,
                    height: 845,
                    title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>写评阅</h4></div>",
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
                                var reportScore = $("input[name='reportScore']:checked").val();
                                if(reportComment_write){
                                    var reportComment_writ=reportComment_write.getContent();
                                }
                                $.post(basePath +"/report/updateReportComment.do",{
                                    id:row[0].id,
                                    reportId:row[0].reportId,
                                    reportScore:reportScore,
                                    content:reportComment_writ
                                },function(){
                                    $.MsgBox.Alert('提示','保存成功！');
                                });
                                $(this).dialog("close");
                                $("#table_reportComment").bootstrapTable('refresh');
                            }
                        }
                    ]
                });
                $("#reportCommentTitle").val(row[0].reportUser+new Date(row[0].reportTime).fmt("yyyy年MM月dd日")+"的报告");
                content_report_write.ready( function() {
                   content_report_write.setContent(row[0].reportContent);
                } );


            }else {
                $.MsgBox.Alert('提示','此报告已评阅！');
            }

        }else{
            $.MsgBox.Alert('提示','请选择要评阅的报告！');
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
    //报告评阅详情
    $("#reportDetailId").on('click',function(e){
        e.preventDefault();
        var row = $('#table_reportComment').bootstrapTable('getSelections');
        /*id:reportId[0].id;*/
        if(row.length>0){
            row2=row;
            if(row[0].commentStatus==1){
                var dialog = $("#dialog_repotmentDetail").removeClass('hide').dialog({
                    modal: true,
                    width: 1412,
                    height: 845,
                    title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>评阅详情</h4></div>",
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
                $("#reportCommentTitle_detail").val(row[0].reportUser+new Date(row[0].reportTime).fmt("yyyy年MM月dd日")+"的报告");
                if(row[0].reportScore==1){
                    $("#reportScore1").attr("checked","checked");
                }else if(row[0].reportScore==2){
                    $("#reportScore2").attr("checked","checked");
                }else if(row[0].reportScore==3){
                    $("#reportScore3").attr("checked","checked");
                }else{
                    alert("评分获取失败");
                }

                if(content_reportDetail){
                    content_reportDetail.ready( function() {
                        content_reportDetail.setContent(row[0].reportContent);
                    } );
                }
                if(conomment_reportDetail){
                    conomment_reportDetail.ready( function() {
                        conomment_reportDetail.setContent(row[0].reportComment);
                    } );
                }
            }else {
                $.MsgBox.Alert('提示','请选择已评阅报告查看！');
            }
        }else{
            $.MsgBox.Alert('提示','请先进行选择！');
        }
    });
    //关注报告的任务
    $("#focusId").on('click', function (e) {
        e.preventDefault();
        var row = $('#table_reportComment').bootstrapTable('getSelections');
        if(row.length>0){
            console.log(row[0])
            $.MsgBox.Confirm('提示','是否关注?',function(){
                $.post(basePath +"/report/focusTask.do",{
                            taskId:row[0].taskCommentId
                        },
                        function(resp){
                            if(resp==300){
                                $.MsgBox.Alert('提示','已是关注状态!');
                            }else if(resp==200){
                                $.MsgBox.Alert('提示','关注成功!');
                                $('#table_reportComment').bootstrapTable('refresh');
                            }
                        });
            });
        }else{
            $.MsgBox.Alert('提示','请先进行选择！');
        }
    });
    //初始化fileinput控件（第一次初始化）
    function initFileInput(ctrlName, uploadUrl) {
        var control = $('#' + ctrlName);

        control.fileinput({
            language: 'zh', //设置语言
            //uploadUrl: uploadUrl, //上传的地址
            allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
            showUpload: false, //是否显示上传按钮
            showCaption: false,//是否显示标题
            maxFileCount: 2, //表示允许同时上传的最大文件个数
            fileType: "any",
            enctype: 'multipart/form-data',
            browseClass: "btn btn-primary", //按钮样式
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        });
    }
</script>
</body>
</html>