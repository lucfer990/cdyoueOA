// 缓存加载完毕后执行的代码(一般用于与部门有关的模块)。注意！不能与$(function(){...})嵌套使用
$.cacheReady(function () {
    //提交保存
    var options = {
        url: basePath + '/bus/addDiscount',
        type: 'post',
        beforeSubmit: showRequest,  //提交前处理
        success: showResponse,  //处理完成
        resetForm: true,
        dataType: 'json'
    };
    $('#add_discount_from').submit(function () {
        $(this).ajaxSubmit(options);
        return false;
    });
});
var $dg = $('#table_reportlist');
// 标签绑定点击事件
$('#mycommentTab a').on('click', function () {
    var that = $(this);
    if (!that.parent().hasClass('active')) {
        $("#table_reportComment").bootstrapTable('refresh', {url: basePath + '/report/findReportComment.do?commentStatus=' + that.data('tag')});
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
//评阅状态格式化
function commentStatusFmt(value, row, index){
    value = value + '';
    var status = {
        "1": {name: '已评阅', style: 'label label-info arrowed-in-right arrowed'},
        "2": {name: '未评阅', style: 'label label-warning arrowed-in-right arrowed'}
    }
    status[value] = status[value] || {};
    return '<span class="' + status[value].style + '">' + status[value].name + '</span>';
}
//关注状态格式化
function focusStatusFmt(value, row, index){
    var hidenUserId=$("#hidenUserId").val();
    if(value){
        if(value.indexOf(hidenUserId)>-1){
            return "<span class='label thefocus label-success arrowed-in-right arrowed'>已关注</span>";
        }
    }
    return "<span class='label thefocus label-danger arrowed-in-right arrowed'>未关注</span>";
}

//百分比格式化
function percentFmt(value, row, index){
    return value+"<span style='color:red;font-weight: 600;font-size: large'>%</span>";
}
//汇报摘要
/*
function reportDigest(value, row, index){//不显示概要中的图片
     if(value){
         if(value.length>110){
             value=value.substr(0,110);
             if(value.indexOf("<img")>-1){
                 value= value.split("<img");
             }
         }
     }

      return value;
}*/
