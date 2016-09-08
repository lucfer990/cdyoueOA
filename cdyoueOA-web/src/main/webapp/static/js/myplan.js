// 缓存加载完毕后执行的代码(一般用于与部门有关的模块)。注意！不能与$(function(){...})嵌套使用
$.cacheReady(function () {
});

var $dg = $('#dg_discountlist');
var $planForm = $('#planForm');
var $category;
dlgSettings.width = 1200;
var $planDlg = $("#planDialog").dialog(dlgSettings);

/**
 * 刷新数据表格
 */
function refreshTable() {
    $dg.bootstrapTable('refresh', {url: basePath + '/plan/findPlan.do?status=' + $category.data('tag')});
}

// 右键菜单
$dg.on('load-success.bs.table', function () {
    $dg.find('tbody tr').addClass('rightClick');
});
var $menu = new BootstrapMenu('.rightClick', {
    fetchElementData: function ($rowElem) {
        $dg.bootstrapTable('check', $rowElem.data('index'));
        return $dg.bootstrapTable('getData')[$rowElem.data('index')];
    },
    actionsGroups: [
        ['dispatch']
    ],
    actions: {
        edit: {
            name: '计划详情',
            iconClass: 'icon-zoom-in',
            onClick: function (row) {
                PlanObj.edit(row);
            }
        },
        finish: {
            name: '完成计划',
            iconClass: 'icon-ok',
            onClick: function (row) {
                PlanObj.finish(row);
            },
            isEnabled: function (row) {
                return row.status == 1 || row.status == 2;
            }
        },
        publish: {
            name: '发布计划',
            iconClass: 'icon-bookmark',
            onClick: function (row) {
                PlanObj.publish(row);
            },
            isEnabled: function (row) {
                return row.status == 0;
            }
        },
        delete: {
            name: '删除计划',
            iconClass: 'icon-trash',
            onClick: function (row) {
                PlanObj.remove(row);
            },
            isEnabled: function (row) {
                return row.status != 3 && row.status != 4;
            }
        },
        dispatch: {
            name: '任务分解',
            iconClass: 'icon-cogs',
            onClick: function (row) {
                alert('删除');
            },
            isEnabled: function (row) {
                return row.status == 1;
            }
        }
    }
});

// 制定计划
$("#addbtn").on('click', function (e) {
    PlanObj.add();
});

/**
 * 所有按钮事件集合
 */
var PlanObj = {
    add: function () {
        $planForm.loadForm();
        $planForm.toggleForm();
        dlgSettings.setTitle('制定计划');
        dlgSettings.setButtons('confirm', function () {
            $('#planSaveBtn').click();
        });
        $planDlg.removeClass('hide').dialog("option", dlgSettings).dialog('open');
    },
    edit: function (row) {
        $planForm.loadForm(row);
        $planForm.toggleForm(true);
        dlgSettings.width = 1200;
        dlgSettings.setTitle('查看计划');
        dlgSettings.setButtons('alert', function () {
            $planDlg.dialog('close');
        });
        $planDlg.removeClass('hide').dialog("option", dlgSettings).dialog('open');
    },
    finish: function (row) {
        $.MsgBox.Confirm('提示', '确定“' + row.title + '”已完成？', function () {
            $.post(basePath + "/plan/finishPlan.do", {
                    id: row.id
                },
                function (resp) {
                    if (resp == 5) {
                        $.MsgBox.Alert('提示', '计划“' + row.title + '”已完成！', function () {
                            refreshTable();
                        });
                    } else {
                        $.MsgBox.Alert('提示', "参数异常");
                    }
                });
        });
    },
    publish: function (row) {
        $.MsgBox.Confirm('提示', '确定发布“' + row.title + '”？', function () {
            $.post(basePath + "/plan/releasePlanning.do", {
                    id: row.id
                },
                function (resp) {
                    if (resp == 5) {
                        $.MsgBox.Alert('提示', '计划“' + row.title + '”已发布！', function () {
                            refreshTable();
                        });
                    } else {
                        $.MsgBox.Alert('提示', "参数异常");
                    }
                });
        });
    },
    remove: function (row) {
        $.MsgBox.Confirm('提示', '确定删除“' + row.title + '”？', function () {
            $.post(basePath + "/plan/delPlan.do", {
                    id: row.id
                },
                function (resp) {
                    if (resp && resp.status == 200) {
                        $.MsgBox.Alert('提示', '删除成功！', function () {
                            refreshTable();
                        });
                    } else {
                        $.MsgBox.Alert('提示', "参数异常");
                    }
                });
        });
    },
    dispatch: function (row) {

    }
};

// 标签绑定点击事件
$('#myTab a').on('click', function () {
    var that = $(this);
    if (!that.parent().hasClass('active')) {
        $dg.bootstrapTable('refresh', {url: basePath + '/plan/findPlan.do?status=' + that.data('tag')});
        $category = that;
    }
});

// 查询
$('#search').on('click', function () {
    var query = $('#plan_title').val();
    $dg.bootstrapTable('refresh', {
        query: {title: query}
    });
});

/**
 * 归属格式化
 */
function belongFmt(value, row, index) {
    if (value == 1) {
        return row.projName;
    } else if (value == 0) {
        var depts = $.getDepts(row.depts);
        return depts ? depts : '获取部门信息失败';
    } else {
        return null;
    }
}

/**
 * 日期时间格式化
 */
function dateFmt(value, row, index) {
    var parsedDate = new Date(value);
    if (parsedDate != 'Invalid Date' && (value - 1)) {
        return parsedDate.fmt('yyyy-MM-dd hh:mm');
    }
    return value;
}

/**
 * 状态格式化
 */
function statusFmt(value, row, index) {
    value = value + '';
    var status = {
        "0": {name: '未发布', style: 'label arrowed-in-right arrowed'},
        "1": {name: '发布进行中', style: 'label label-info arrowed-in-right arrowed'},
        "2": {name: '暂停', style: 'label label-warning arrowed-in-right arrowed'},
        "3": {name: '已完成', style: 'label label-success arrowed-in-right arrowed'},
        "4": {name: '废除', style: 'label label-inverse arrowed-in-right arrowed'},
    };
    status[value] = status[value] || {};
    return '<span class="' + status[value].style + '">' + status[value].name + '</span>';
}

//计划关注对话框
$('#focus').on('click', function (e) {
    var that = $(this);
    if (that.attr('disabled')) return;
    $.deptsDialog('mems', function (depts, mems) {
        that.val(mems.map(function (ele) {
            return ele.userName;
        }).join(","));
        $('#focusUsersPlan').val(mems.map(function (ele) {
            return ele.uId;
        }).join(","));
    });
});

// 计划归属对话框
$('#depts').on('click', function (e) {
    var that = $(this);
    if (that.attr('disabled')) return;
    $.deptsDialog(function (depts, mems) {
        that.val(depts.map(function (ele) {
            return ele.name;
        }).join(","));
        $('#focusUsersDepts').val(depts.map(function (ele) {
            return ele.id;
        }).join(","));
    });
});

// 日期框
$('#startTime').datetimepicker({language: 'zh-CN'}).on('change', function (ev) {
    $('#endTime').datetimepicker('setStartDate', $('#startTime').val());
});
$('#endTime').datetimepicker({language: 'zh-CN'}).on('change', function (ev) {
    $('#startTime').datetimepicker('setEndDate', $('#endTime').val());
});

//表单验证
$planForm.validate({
    errorElement: 'div',
    errorClass: 'help-block',
    focusInvalid: false,
    rules: {
        title: 'required',
        type: 'required',
        belongTo: 'required',
        startTime: 'required',
        endTime: 'required'
    },
    messages: {
        title: '请输入计划名称',
        type: '请指定计划类型',
        belongTo: '请指定计划归属',
        startTime: '请指定计划开始时间',
        endTime: '请指定计划终止时间'
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
        $.post(basePath + "/plan/addPlan.do", $planForm.serializeObject(), function () {
            $.MsgBox.Alert('提示', '保存成功！', function () {
                refreshTable();
            });
        });
        $planDlg.dialog("close");
    },
    invalidHandler: function (form) {
    }
});

//任务拆分
$("#splitTaskBtn").on('click', function (e) {
    e.preventDefault();
    var tObj = $('#dg_discountlist').bootstrapTable('getSelections');
    if (tObj.length > 0) {
        if (tObj[0].status == "1") {
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
                        text: "分解任务",
                        "class": "btn btn-primary btn-xs",
                        click: function () {
                            var pObj = $('#dg_discountlist').bootstrapTable('getSelections');
                            if (pObj.length > 0) {
                                var pId = pObj[0].id;
                                var focusUser = pObj[0].focusUsers;
                                document.getElementById("planId").value = pId;
                                document.getElementById("focusUsers").value = focusUser;
                                $.ajax({
                                    url: basePath + "/task/addTask.do",
                                    data: $("#validation-form1").serialize(),
                                    type: "post",
                                    dataType: "json",
                                    success: function (data) {//ajax返回的数据
                                        $.MsgBox.Alert('提示', '分解成功');
                                        $("#tasksplit_dialog").dialog("close");
                                    },
                                    error: function () {
                                        $.MsgBox.Alert('提示', '系统异常！');
                                    }
                                });

                            } else {
                                $.MsgBox.Alert('提示', '请选中计划！');
                            }
                        }
                    }
                ]
            });

        } else {
            $.MsgBox.Alert('提示', '该计划不是已发布的计划！');
        }

    } else {
        $.MsgBox.Alert('提示', '请选中计划！');
    }
});