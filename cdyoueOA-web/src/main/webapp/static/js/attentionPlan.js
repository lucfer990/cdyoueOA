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
var $dg = $('#dg_discountlist');
// 标签绑定点击事件
$('#myTab a').on('click', function () {
    var that = $(this);
    if (!that.parent().hasClass('active')) {
        $dg.bootstrapTable('refresh', {url: basePath + '/plan/findPlanAttention.do?status=' + that.data('tag')});
    }
});
// 查询
$('#search').on('click', function () {
    var query = $('#plan_title').val();
    //var superV = $('#plan_supervisors').val();
    $dg.bootstrapTable('refresh', {
        query: {
        	title: query
        	//supervisors: superV
        		}
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
// 日期时间格式化
function dateFmtNOW(value, row, index) {
	var parsedDate = (new Date().getTime() - value)/1000;
	var day = Math.floor((parsedDate / 3600) / 24);
    var hour = Math.floor((parsedDate / 3600) % 24);
    var minute = Math.floor((parsedDate / 60) % 60);
    var second = Math.floor(parsedDate % 60);
	if (parsedDate - 1) {
		if(parsedDate>0){
			return "已滞后:"+day+"天"+hour+"时"+minute+" 分";
		}
		if(parsedDate<0){
			day1 = day.toString().substring(1);
			hour1 = hour.toString().substring(1);
			minute1 = minute.toString().substring(1);
			return "提早:"+day1+"天"+hour1+"时"+minute1+" 分";
		}
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
};

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

    //计划详情 
    $("#getPlanById").on('click', function (e) {
        e.preventDefault();
        var planId = $('#dg_discountlist').bootstrapTable('getSelections');
		$.ajax({
		url : basePath + "/plan/getPlanById.do",
		type : "post",
		data : "id="+planId[0].id,
		dataType : "json",
		success : function(result) {
				var dialog = $("#dialog-messageDetails").removeClass('hide').dialog({
                modal: true,
                width: 712,
                height: 645,
				title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>计划详情</h4></div>", 
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
           	 $("#titleD").val(result.title);
           	 if(result.type == 1){
           	 	$("#typeD").val("规划与方案");
           	 }
           	 if(result.type == 2){
           	 	$("#typeD").val("中长期计划");
           	 }
           	 if(result.type == 3){
           	 	$("#typeD").val("年工作计划");
           	 }
           	 if(result.type == 4){
           	 	$("#typeD").val("阶段性计划");
           	 }
           	 if(result.type == 6){
           	 	$("#typeD").val("月工作计划");
           	 }
           	 if(result.type == 7){
           	 	$("#typeD").val("周工作计划");
           	 }
           	 if(result.type == 8){
           	 	$("#typeD").val("临时计划");
           	 }
           	 if(result.belongTo == 0){
           	 $("#belongToD").val("部门");
           	 }
           	 if(result.belongTo == 1){
           	 $("#belongToD").val("项目");
           	 }
           	 $("#startTimeD").val(new Date(result.startTime).fmt("yyyy-MM-dd hh:mm"));
           	 $("#endTimeD").val(new Date(result.endTime).fmt("yyyy-MM-dd hh:mm"));
           	 $("#contentD").val(result.content);
			},
		});
        
    });
    //删除计划
//    $("#delbtn").on('click', function (e) {
//        e.preventDefault();
//        
//    	$.MsgBox.Confirm('提示','是否删除',function(){
//        var planId = $('#dg_discountlist').bootstrapTable('getSelections');
//                 	$.post(basePath +"/plan/delPlan.do",{
//							id:planId[0].id
//						},
//						function(resp){
//					$.MsgBox.Alert('提示','删除成功');
//						});
//    			});
//          
//    });
});
