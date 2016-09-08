<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<div id="dialog-reportDetail" style="display: none">
    <div class="col-md-12">
        <div class="col-md-5 col-md-offset-5">
            <h2><span id="reportTileTime"></span>工作报告</h2>
        </div>

        <div class="col-md-9 col-md-offset-3" id="title2">
            <ul>
                <li>报告人:<span id="de1"></span></li>
                <li>汇报对象:<span id="de2"></span></li>
                <li>关注人:<span id="de3"></span></li>
                <li>汇报时间:
                    <span id="startTime_detail"></span>
                </li>
            </ul>
        </div>
    </div>

    <div class="col-md-12">
        <hr />
    </div>
    <div class="col-md-8 col-md-offset-2">
        <form  class="form-horizontal"  id="submitForm"  method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label class="control-label col-xs-2 col-sm-3 no-padding-right">关联任务:</label>
                <div class="col-xs-2 col-sm-2">
                    <div class="clearfix">
                        <input type="text" id="reportForTask_detail" readonly="readonly">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-xs-2 col-sm-3 no-padding-right">任务进度:</label>
                <div class="col-xs-2 col-sm-2">
                    <div class="clearfix">
                        <span id="progress_detail"></span><span style="font-weight: 600;font-size: large;color: red">%</span>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="content_reportDetail2" class="control-label col-xs-6 col-sm-3 no-padding-right">报告内容:</label>

                <div class="col-xs-12 col-sm-9">
                    <textarea id="content_reportDetail2"></textarea>
                </div>
            </div>
        </form>
    </div>
</div>
