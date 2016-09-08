var $dg = $('#dg_discountlist');
// 查询
$('#search').on('click', function () {
    var logType = $('#logType').val();
    var startTime = $('#startTime').val();
    $dg.bootstrapTable('refresh', {
        query: {
        	title: logType,
        	startTimeString:startTime,
        	}
    });
});

// 日期时间格式化
function dateFmt(value, row, index) {
    var parsedDate = new Date(value);
    if (parsedDate != 'Invalid Date' && (value - 1)) {
        return parsedDate.fmt('yyyy-MM-dd hh:mm');
    }
    return value;
}
//日志详情 
$("#getLogById").on('click', function (e) {
    e.preventDefault();
    var planId = $('#dg_discountlist').bootstrapTable('getSelections');
	$.ajax({
	url : basePath + "/aLog/get.do",
	type : "post",
	data : "id="+planId[0].id,
	dataType : "json",
	success : function(result) {
		console.log(result);
			var dialog = $("#dialog-messageShow").removeClass('hide').dialog({
            modal: true,
            width: 712,
            height: 645,
			title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>日志详情</h4></div>", 
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
       	 $("#logType").val(result.title);
       	 $("#startTimeS").val(new Date(result.startTime).fmt("yyyy-MM-dd hh:mm"));
       	 $("#endTimeS").val(new Date(result.endTime).fmt("yyyy-MM-dd hh:mm"));
       	 $("#contentS").val(result.content);
		},
	});
    
});
