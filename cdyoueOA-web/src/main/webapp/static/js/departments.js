$.cacheReady(function () {
    var setting = {
        check: {
            enable: true,
            chkboxType: {"Y": "ps", "N": "ps"}
        },
        data: {
            simpleData: {enable: true}
        },
        view: {txtSelectedEnable: true},
        callback: {
            onClick: function (e, treeId, treeNode, clickFlag) {
                zTree.checkNode(treeNode, !treeNode.checked, true);
                var filter = {};
                if (treeNode.id != 50 && treeNode.id != 51) {
                    filter = {dept_id: treeNode.id};
                }
                $('#deptUsersTable').bootstrapTable('filterBy', filter);
            }
        }
    };
    var zTree = $.fn.zTree.init($("#deptsTree"), setting, $.getDepts('all', 'json'));
    zTree.expandAll(true);
});

(function () {
    $.extend({
        /**
         * 全局函数：打开部门或人员选择对话框
         * @param type 可选，'depts'表示部门对话框，'mems'表示人员对话框，默认为'depts'
         * @param callback 可选，对话框"确定"按钮的回调事件。回调函数参数1：已选择部门；参数2：已选择人员
         */
        deptsDialog: function (type, callback) {
            var modalTitle, modalWidth;
            if (typeof type == 'function') {
                callback = type;
                type = 'depts';
            }
            if (type == 'depts') {
                $('#deptsTreeDiv').attr('class', 'col-sm-12');
                $('#memsTreeDiv').addClass('hide');
                modalTitle = '选择部门';
                modalWidth = 400;
            } else if (type == 'mems') {
                $('#deptsTreeDiv').attr('class', 'col-sm-4');
                $('#memsTreeDiv').removeClass('hide');
                modalTitle = '选择人员';
                modalWidth = 800;
            } else {
                return;
            }
            $("#depts-dialog").removeClass('hide').dialog({
                modal: true,
                width: modalWidth,
                title: '<div class="widget-header widget-header-small"><h4 class="smaller"> ' + modalTitle + ' </h4></div>',
                title_html: true,
                buttons: [
                    {
                        text: "取消",
                        "class": "btn btn-xs",
                        click: function () {
                            $(this).dialog("close");
                        }
                    },
                    {
                        text: "确定",
                        "class": "btn btn-primary btn-xs",
                        click: function () {
                            if (typeof callback == 'function') {
                                var enumedDepts = [];
                                var zTree = $.fn.zTree.getZTreeObj("deptsTree");
                                var array = zTree.getCheckedNodes(true);
                                //去除所有父节点
                                for (var i = 0; i < array.length; i++) {
                                    if (!array[i].isParent) {
                                        enumedDepts.push(array[i]);
                                    }
                                }
                                var enumedMems = $('#deptUsersTable').bootstrapTable('getAllSelections');
                                callback(enumedDepts, enumedMems);
                                $(this).dialog("close");
                            }
                        }
                    }
                ]
            });
            // 对话框置于顶层
            var dialog = $("#depts-dialog").closest('.ui-front');
            dialog.prev().attr('style', 'z-index:1060 !important;');
            var style = dialog.attr('style') + ';z-index:1070 !important;';
            dialog.attr('style', style);
        }
    });
}());

$('#deptUsersInput input').on('keyup', function () {
    var that = $(this);
    $('#deptUsersTable').bootstrapTable('filterBy', {userName: that.val().trim()});
});