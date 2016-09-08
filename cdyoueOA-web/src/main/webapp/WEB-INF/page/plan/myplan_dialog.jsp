<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<div id="planDialog" class="hide">
    <form method="post" id="planForm" class="form-horizontal dlgForm" novalidate="novalidate">

        <div class="form-group">
            <label for="type" class="control-label col-xs-2 col-sm-2 no-padding-right">计划类型（*）：</label>
            <div class="col-xs-2 col-sm-2">
                <div class="clearfix">
                    <select name="type" id="type" class="chosen-select">
                        <option value="0">规划与方案</option>
                        <option value="1">中长期计划</option>
                        <option value="2">年工作计划</option>
                        <option value="3">阶段性计划</option>
                        <option value="4">季度工作计划</option>
                        <option value="5">月工作计划</option>
                        <option value="6">周工作计划</option>
                        <option value="7">临时计划</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label for="ProjectTitle" class="control-label col-xs-2 col-sm-2 no-padding-right">计划名称（*）：</label>
            <div class="col-xs-6 col-sm-9">
                <div class="clearfix">
                    <input type="text" class="col-xs-12 col-sm-6" id="ProjectTitle" name="title">
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-xs-2 col-sm-2 no-padding-right">计划归属（*）：</label>
            <div class="col-xs-2 col-sm-2">
                <div>
                    <label class="blue">
                        <input type="radio" class="ace" value="0" name="belongTo" onclick="$('#depts').removeClass('hide');$('#projName').addClass('hide');">
                        <span class="lbl"> 部门</span>
                    </label>
                </div>
                <div>
                    <label class="blue">
                        <input type="radio" class="ace" value="1" name="belongTo" onclick="$('#projName').removeClass('hide');$('#depts').addClass('hide');">
                        <span class="lbl"> 项目</span>
                    </label>
                </div>
            </div>
            <div class="col-xs-2 col-sm-2">
                <input type="text" class="hide depts" id="depts" name="depts" readonly="readonly" placeholder="选择部门..."/>
                <input type="text" class="hide" id="projName" name="projName" placeholder="项目名称"/>
            </div>
        </div>

        <div class="form-group">
            <label for="startTime" class="control-label col-xs-2 col-sm-2 no-padding-right">开始时间（*）：</label>
            <div class="col-xs-6 col-sm-3">
                <input class="span8 datetime-picker" name="startTime" id="startTime" type="text" readonly="readonly"/>
                <i class="icon-calendar"></i>
            </div>
        </div>

        <div class="form-group">
            <label for="endTime" class="control-label col-xs-2 col-sm-2 no-padding-right">结束时间（*）：</label>
            <div class="col-xs-6 col-sm-3">
                <input class="span8 datetime-picker" name="endTime" id="endTime" type="text" readonly="readonly"/>
                <i class="icon-calendar"></i>
            </div>
        </div>
        <!-- 文本编辑器 -->
        <script type="text/javascript">
            $(document).ready(function () {
                $('#summernote').summernote({
                    lang: 'zh-CN',//改为中文
                    width: 800,
                    height: 300,                 // set editor height
                    minHeight: null,             // set minimum height of editor
                    maxHeight: null,             // set maximum height of editor
                    focus: true
                });
            });
        </script>
        <div class="form-group">
            <label class="control-label col-xs-2 col-sm-2 no-padding-right">计划概述：</label>
            <div class="col-xs-12 col-sm-9">

                <div id="summernote"></div>

            </div>
        </div>

        <div class="form-group">
            <label for="focus" class="control-label col-xs-2 col-sm-2 no-padding-right">计划关注人:</label>

            <div class="col-xs-12 col-sm-9">
                <div class="clearfix">
                    <input type="text" class="col-xs-12 col-sm-6 focusUser" id="focus" readonly="readonly">
                    <input type="hidden" id="focusUsers" name="focusUsers">
                </div>
            </div>
        </div>

        <input id="planSaveBtn" type="submit" class="hide"/>
    </form>
</div>