<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<div id="dialog_repotmentDetail" style="display: none">
    <form  class="form-horizontal"  id="submitForm"  method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label class="control-label col-xs-2 col-sm-3 no-padding-right">标题:</label>
            <div class="col-md-3">
                <div class="clearfix">
                    <input type="text" class="col-md-12" id="reportCommentTitle_detail" readonly="readonly">
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2  col-md-offset-1 no-padding-right">报告评分:</label>
            <div class="col-md-6" id="reportScore">
                <div class="col-xs-2 col-sm-2 no-padding-left">
                    <label class="blue">
                        <input type="radio" class="ace" value="1" name="reportScore" id="reportScore1" disabled="disabled">
                        <span class="lbl">不满意</span>
                    </label>
                </div>

                <div class="col-xs-2 col-sm-2">
                    <label class="blue">
                        <input type="radio" class="ace" value="2"  name="reportScore" id="reportScore2" disabled="disabled">
                        <span class="lbl">一般</span>
                    </label>
                </div>

                <div class="col-xs-2 col-sm-2">
                    <label class="blue">
                        <input type="radio" class="ace" value="3"  name="reportScore" id="reportScore3" disabled="disabled">
                        <span class="lbl">满意</span>
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="content_reportDetail" class="control-label col-xs-6 col-sm-3 no-padding-right">报告内容:</label>

            <div class="col-md-7">
                <textarea id="content_reportDetail"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="conomment_reportDetail" class="control-label col-xs-6 col-sm-3 no-padding-right">报告评语:</label>

            <div class="col-md-7">
                <textarea id="conomment_reportDetail"></textarea>
            </div>
        </div>

    </form>
</div>