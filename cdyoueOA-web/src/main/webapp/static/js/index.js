// 缓存加载完毕后执行的代码(一般用于与部门有关的模块)。注意！不能与$(function(){...})嵌套使用
$.cacheReady(function () {

});
var $dg = $('#dg_discountlist');
// 添加计划对话框
$("#addBtn").on('click', function (e) {
    $('#validation-form').loadForm();
    dlgSettings.width = 1200;
    dlgSettings.buttons[1].click = function () {
        $('#saveBtn').click();
    };
    $("#dialog-message").removeClass('hide').dialog(dlgSettings);
});
// 查看计划对话框
$("#detailBtn").on('click', function (e) {
    var data = $dg.bootstrapTable('getSelections')[0];
    if (data) {
        $('#validation-form').loadForm(data);
        dlgSettings.width = 1200;
        dlgSettings.setTitle('查看计划');
        dlgSettings.buttons[1].click = function () {
            $('#saveBtn').click();
        };
        $("#dialog-message").removeClass('hide').dialog(dlgSettings);
    }
});
// 计划关注对话框
$('#focus').on('click', function (e) {
    var that = $(this);
    $.deptsDialog('mems', function (depts, mems) {
        that.val(mems.map(function (ele) {
            return ele.userName;
        }).join(","));
        $('#focusUsers').val(mems.map(function (ele) {
            return ele.uId;
        }).join(","));
    });
});
// 计划归属对话框
$('#depts').on('click', function (e) {
    var that = $(this);
    $.deptsDialog(function (depts, mems) {
        that.val(depts.map(function (ele) {
            return ele.name;
        }).join(","));
        $('#focusUsers').val(depts.map(function (ele) {
            return ele.id;
        }).join(","));
    });
});
// 标签绑定点击事件
$('#myTab a').on('click', function () {
    var that = $(this);
    if (!that.parent().hasClass('active')) {
        $dg.bootstrapTable('refresh', {url: basePath + '/plan/findPlan.do?status=' + that.data('tag')});
    }
});
// 查询
$('#search').on('click', function () {
    var query = $('#plan_title').val();
    $dg.bootstrapTable('refresh', {
        query: {title: query}
    });
});
// 归属格式化
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
// 日期时间格式化
function dateFmt(value, row, index) {
    var parsedDate = new Date(value);
    if (parsedDate != 'Invalid Date' && (value - 1)) {
        return parsedDate.fmt('yyyy-MM-dd hh:mm');
    }
    return value;
}
// 状态格式化
function statusFmt(value, row, index) {
    value = value + '';
    var status = {
        "0": {name: '未发布', style: 'label arrowed-in-right arrowed'},
        "1": {name: '发布进行中', style: 'label label-info arrowed-in-right arrowed'},
        "2": {name: '暂停', style: 'label label-warning arrowed-in-right arrowed'},
        "3": {name: '已完成', style: 'label label-success arrowed-in-right arrowed'},
        "4": {name: '废除', style: 'label label-inverse arrowed-in-right arrowed'},
    }
    status[value] = status[value] || {};
    return '<span class="' + status[value].style + '">' + status[value].name + '</span>';
}
//表单验证
$('#validation-form').validate({
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
        $.MsgBox.Alert('提示','这个时候发Ajax请求');
        $('#dialog-message').dialog("close");
    },
    invalidHandler: function (form) {
    }
});