<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<style type="text/css" rel="stylesheet">
    #deptUsersInput:after {
        content: "\f002";
        display: inline-block;
        color: #888;
        font-family: FontAwesome;
        font-size: 14px;
        position: absolute;
        right: 15px;
    }
</style>
<div id="depts-dialog" class="hide">
    <div class="row">
        <div id="deptsTreeDiv" class="col-sm-4">
            <div class="widget-box">
                <div class="widget-header widget-header-flat">
                    <h4 class="smaller">
                        <i class="icon-sitemap"></i>
                        组织机构
                    </h4>
                </div>

                <div class="widget-body">
                    <div class="widget-main slim-scroll" data-height="400">
                        <div class="left">
                            <ul id="deptsTree" class="ztree"></ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="memsTreeDiv" class="col-sm-8">
            <div class="widget-box">
                <div class="widget-header widget-header-flat">
                    <h4 class="smaller">
                        <i class="icon-user"></i>
                        人员列表
                    </h4>
                    <div class="widget-toolbar" id="deptUsersInput">
                        <input type="text" placeholder="搜索人员..."/>
                    </div>
                </div>

                <div class="widget-body">
                    <div class="widget-main slim-scroll" data-height="400" style="padding-top: 0;padding-left: 0;">
                        <div>
                            <table id="deptUsersTable" data-toggle="table" data-click-to-select="true"
                                   data-url="${basePath}/plan/findDeptUsers.do">
                                <thead>
                                <tr>
                                    <th data-checkbox="true"></th>
                                    <th data-field="userName">姓名</th>
                                    <th data-field="deptName">部门</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${basePath}/static/js/departments.js"></script>