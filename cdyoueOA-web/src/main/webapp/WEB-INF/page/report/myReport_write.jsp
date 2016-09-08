<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<div id="dialog-message" style="display: none">
    <form  class="form-horizontal"  id="submitForm"  method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label class="control-label col-xs-2 col-sm-3 no-padding-right">关联任务:</label>
            <div class="selectindex col-xs-2 col-sm-2">
                <div class="clearfix">
                    <select name="type" id="reportForTask" class="chosen-select">

                    </select>
                </div>
            </div>

            <label class="control-label col-xs-2 col-sm-3 no-padding-right">汇报对象:</label>
            <div class="col-xs-2 col-sm-2">
                <div class="clearfix">
                    <select name="type" id="reportObj" class="chosen-select" disabled="disabled">

                    </select>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="control-label col-xs-2 col-sm-3 no-padding-right">任务进度:</label>
            <div class="col-xs-2 col-sm-2">
                <div class="clearfix">
                    <input type="text" id="taskProgress">
                </div>
            </div>
        </div>
            <div class="form-group">
            <label for="content" class="control-label col-xs-6 col-sm-3 no-padding-right">报告内容:</label>

            <div class="col-xs-12 col-sm-9">
                <textarea id="content" style="height: 200px;width: 800px;" name="content"></textarea>
            </div>
        </div>

    </form>
</div>
<script type="text/javascript">

    //实例化编辑器
    var ue = UE.getEditor('content',{
        initialFrameWidth : 800,
        initialFrameHeight: 490,
    });

    $(document).ready(function() {
        //初始化fileinput
        initFileInput("file-Portrait", "");

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

    //加载关联任务
    $.ajax({
        url: basePath + '/task/findAllTask.do',
        type: 'post',
        success: function (resp) {
            $.each(resp,function(index,data){
                $("#reportForTask").append("<option class='taskval"+index+"' value='"+data.id+"'></option>");
                $(".taskval"+index).text(data.title);
                $('#reportForTask').trigger("chosen:updated");
            });
        },
        error: function () {
            alert('获取任务信息失败！');
        }
    });
    //选择改变关联任务时获取相应报告对象
    $("#reportForTask").change(function(){
        var taskid= $("#reportForTask option:selected").val()
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


</script>