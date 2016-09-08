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
                                                    <input type="text" class="form-control" id="plan_title" required="required" placeholder="计划名称"/>
                                                </div>
                                                <button id="search" class="btn btn-primary" type="button">
                                                    <i class="icon-search"></i>
                                                </button>
                                                <button type="button" id="delbtn" class="btn btn-danger right">
                                                    <i class="icon-trash"></i>删除计划
                                                </button>
                                                <button type="button" id="" class="btn btn-info right">
                                                    <i class="icon-zoom-in"></i>计划详情
                                                </button>
                                                <button type="button" id="" class="btn btn-success right">
                                                    <i class="icon-bookmark"></i>发布计划
                                                </button>
                                                <button type="button" id="" class="btn btn-warning right">
                                                    <i class="icon-cogs"></i>任务分解
                                                </button>
                                                <button type="button" id="savebtn" class="btn btn-purple right">
                                                    <i class="icon-edit"></i>制定计划
                                                </button>
                                            </div>
                                        </div>
                                    </form>
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

<script type="text/javascript" src="${basePath}/static/js/myplan.js"></script>
<script type="text/javascript">
    $(function () {
        //override dialog's title function to allow for HTML titles
        $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
            _title: function (title) {
                var $title = this.options.title || '&nbsp;'
                if (("title_html" in this.options) && this.options.title_html == true)
                    title.html($title);
                else title.text($title);
            }
        }));
        //制定计划
        $("#savebtn").on('click', function (e) {
            e.preventDefault();

            var dialog = $("#dialog-message").removeClass('hide').dialog({
                modal: true,
                width: 1412,
                height: 845,
                title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>制定计划</h4></div>",
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
                        text: "制定",
                        "class": "btn btn-primary btn-xs",
                        click: function () {
							var title = $("#title").val();
							ype = $("#type").val();
							var belongTo =$("input[name='belongTo']:checked").val();
							var startTime = $("#startTime").val();
							var endTime = $("#endTime").val();
							var content = $("#content").val();
							var attachments = $("#attachments").val();
							var focusUsers = $("#focusUsers").val();
							var isTemplate = $("#isTemplate").val();
	                        	$.post(basePath +"/plan/addPlan.do",{
	    							startTime:new Date(startTime),
	    							endTime:new Date(endTime),
	    							title:title,
	    							content:content,
	    							focusUsers:focusUsers,
	    							type:type,
	    							belongTo:belongTo,
	    							attachments:attachments,
	    							isTemplate:isTemplate
	    						},function(){
	    							$.MsgBox.Alert('提示','保存成功！');
	    						});
	    						$(this).dialog("close");
                        	  /* $.ajax({
								url : basePath + "/plan/addPlan.do",
								type : "post",
								data : "title=" + title+"&type="+type+"&belongTo="+belongTo+
										"&startTime="+new Date(startTime)+"&endTime="+new Date(endTime)+"&content="+content+"&attachments="+
										attachments+"&focusUsers="+focusUsers+"&isTemplate="+isTemplate,
								dataType : "json",
								 success : function(result) {
									if(result.flag == 1000) {
										//成功跳转到主页
										window.location.href = basePath + "/mainPage.do"; 
									} else {
										//失败提交密码错误
										$("#message").text(result.msg);
									}
								},
						        error:function(XmlHttpRequest, textStatus, errorThrown)
						        {
						            alert("登录异常:" + XmlHttpRequest.responseText);
						        } 
							}) 
										$.MsgBox.Alert('提示','添加成功'); */ 
                            
                        }
                    }
                ]
            });
        });
        //删除计划
        $("#delbtn").on('click', function (e) {
            e.preventDefault();

            var dialog = $("#dialog-messageDel").removeClass('hide').dialog({
                modal: true,
                width: 412,
                height: 245,
                title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>删除计划</h4></div>",
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
                        text: "删除",
                        "class": "btn btn-primary btn-xs",
                        click: function () {
							var planId = $('#dg_discountlist').bootstrapTable('getSelections');
							console.debug(planId[0].id);
	                        	$.post(basePath +"/plan/delPlan.do",{
	    							id:planId[0].id
	    						},function(){
	    							$.MsgBox.Alert('提示','删除成功！');
	    						});
	    						$(this).dialog("close");
                        }
                    }
                ]
            });
        });
        //任务拆分
        $("#splitTaskBtn").on('click', function (e) {
            e.preventDefault();

            var dialog = $("#tasksplit_dialog").removeClass('hide').dialog({
                modal: true,
                width: 1412,
                height: 845,
                title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>任务分解</h4></div>",
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
                        text: "分配任务",
                        "class": "btn btn-primary btn-xs",
                        click: function () {                           	
                        	$.ajax({
                                url:basePath+"/task/addTask.do",
                                data:$("#validation-form1").serialize(),
                                type:"post",
                                dataType:"json",
                                success:function(data){//ajax返回的数据
                                	$.MsgBox.Alert('提示','分配成功！');
                                }
                           });     
                            
                        }
                    }
                ]
            });
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


        //表单验证
        /*$('#validation-form').validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                ProjectTitle: {
                    required: true
                },
                platform: {
                    required: true
                },
                password: {
                    required: true,
                    minlength: 5
                },
                password2: {
                    required: true,
                    minlength: 5,
                    equalTo: "#password"
                },
                name: {
                    required: true
                },
                phone: {
                    required: true,
                    phone: 'required'
                },
                url: {
                    required: true,
                    url: true
                },
                comment: {
                    required: true
                },
                state: {
                    required: true
                },
                subscription: {
                    required: true
                },
                gender: 'required',
                agree: 'required'
            },

            messages: {
                ProjectTitle: {},
                password: {
                    required: "Please specify a password.",
                    minlength: "Please specify a secure password."
                },
                subscription: "Please choose at least one option",
                gender: "Please choose gender",
                agree: "Please accept our policy"
            },

            invalidHandler: function (event, validator) { //display error alert on form submit
                $('.alert-danger', $('.login-form')).show();
            },

            highlight: function (e) {
                $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
            },

            success: function (e) {
                $(e).closest('.form-group').removeClass('has-error').addClass('has-info');
                $(e).remove();
            },

            errorPlacement: function (error, element) {
                if (element.is(':checkbox') || element.is(':radio')) {
                    var controls = element.closest('div[class*="col-"]');
                    if (controls.find(':checkbox,:radio').length > 1) controls.append(error);
                    else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
                }
                else if (element.is('.select2')) {
                    error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
                }
                else if (element.is('.chosen-select')) {
                    error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
                }
                else error.insertAfter(element.parent());
            },

            submitHandler: function (form) {
            },
            invalidHandler: function (form) {
            }
        });*/
    });



</script>

</body>
</html>