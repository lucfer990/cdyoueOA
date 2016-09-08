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
//任务详情
var tdue = UE.getEditor('tdcontent',{
    initialFrameWidth : 800,
    initialFrameHeight: 600
});
$(function(){
	var ueInfo;    	   
	tdue.ready( function() {
	         if(ueInfo){
	         	tdue.setContent(ueInfo);
	         }
	     } );
	
})
// 标签绑定点击事件
$('#myFocusTab a').on('click', function () {
    var that = $(this);
    if (!that.parent().hasClass('active')) {    	
        $dg.bootstrapTable('refresh', {url: basePath + '/task/findfocusTask.do?status=' + that.data('tag')});
    }
});
// 查询
$('#tfsearch').on('click', function () {
    var query = $('#tf_title').val();
    $dg.bootstrapTable('refresh', {
        query: {title: query}
    });
});
// 日期时间格式化
function dateFmt(value, row, index) {
	var data=value;
	
	if(value && value.lastIndexOf(".")!=-1){
		data=value.substring(0,value.lastIndexOf("."));		
	}	
    var parsedDate = new Date(value);  
    if (parsedDate != 'Invalid Date' && (value - 1)) {
        return parsedDate.fmt('yyyy-MM-dd hh:mm');
    }
    return data;
}
//进展状态格式化
function processFmt(value, row, index) {
	var data=new Date(value);	
	var parsedDate = (new Date().getTime() - data)/1000;
	var day = Math.floor((parsedDate / 3600) / 24);
    var hour = Math.floor((parsedDate / 3600) % 24);
    var minute = Math.floor((parsedDate / 60) % 60);
    var second = Math.floor(parsedDate % 60);
	if (parsedDate - 1) {
		if(parsedDate>0){
			return "超期:"+day+"天"+hour+"时"+minute+" 分";
		}value
		if(parsedDate<0){
			day1 = day.toString().substring(1);
			hour1 = hour.toString().substring(1);
			minute1 = minute.toString().substring(1);
			return "离结束还有:"+day1+"天"+hour1+"时"+minute1+" 分";
		}
	}
	return data;
}
//状态格式化
function statusFmt(value, row, index) {
    value = value + '';
    var status = {
        "0": {name: '已废除', style: 'label arrowed-in-right arrowed'},
        "1": {name: '进行中', style: 'label label-info arrowed-in-right arrowed'},
        "2": {name: '暂停', style: 'label label-warning arrowed-in-right arrowed'},
        "3": {name: '强制完成', style: 'label label-success arrowed-in-right arrowed'},
        "4": {name: '已完成', style: 'label label-inverse arrowed-in-right arrowed'},
    }
    status[value] = status[value] || {};
    return '<span class="' + status[value].style + '">' + status[value].name + '</span>';
}
//消息提醒格式化
function alertFmt(value, row, index) {
    value = value + '';
    var alerts = {
        "0": {name: '已查看', style: 'label arrowed-in-right arrowed'},
        "1": {name: '未查看', style: 'label label-info arrowed-in-right arrowed'},
        
    }
    alerts[value] = alerts[value] || {};
    return '<span class="' + alerts[value].style + '">' + alerts[value].name + '</span>';
}
//归属格式化
function belongFmt(value, row, index) {
	 return value ? value : '获取计划信息失败';
}
//消息提醒格式化
function emeFmt(value, row, index) {
    value = value + '';
    var emes = {
        "1": {name: '紧急重要', style: 'label arrowed-in-right arrowed'},
        "2": {name: '紧急不重要', style: 'label arrowed-in-right arrowed'},
        "3": {name: '不紧急重要', style: 'label arrowed-in-right arrowed'},
        "4": {name: '不紧急不重要', style: 'label arrowed-in-right arrowed'},
    }
    emes[value] = emes[value] || {};
    return '<span class="' + emes[value].style + '">' + emes[value].name + '</span>';
}
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
  //任务详情
    $("#tfdetail").on('click', function (e) {
        e.preventDefault();
        var tObj= $('#dg_discountlist').bootstrapTable('getSelections');
        if(tObj.length>0){            	
        	var data=tObj[0];
        	$("#taskDetailForm").loadForm(data); 
    		tdue.ready(function(){
    			tdue.setContent(tObj[0].content);//赋值给UEditor                   
            });
        	 var dialog = $("#taskdetail_dialog").removeClass('hide').dialog({
                 modal: true,
                 width: 1412,
                 height: 845,
                 title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>任务详情</h4></div>",
                 title_html: true,
                 close:function(){
                 	$("#dg_discountlist").bootstrapTable('refresh');
                 },
                 buttons: [
                           {
                               text: "关闭",
                               "class": "btn btn-xs",
                               click: function () {
                                   $(this).dialog("close");
                                   $("#dg_discountlist").bootstrapTable('refresh');
                               }
                           },
               ]  
             });           
    		
        }else{
        	$.MsgBox.Alert('提示','请选择要查看的任务！');
        	
    		
        	
        }
       
       
        
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




