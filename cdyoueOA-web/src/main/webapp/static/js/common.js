/**
 * 全局变量：对话框设置
 */
var dlgSettings = {
    modal: true,
    autoOpen: false,
    width: 1400,
    height: 800,
    title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>标题</h4></div>",
    title_html: true,
    setTitle: function (t) {
        this.title = "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>" + t + "</h4></div>";
    },
    buttons: [],
    setButtons: function (type, callback) {
        if (type == 'confirm') {
            this.buttons = [
                {
                    text: "确定",
                    "class": "btn btn-primary btn-xs",
                    click: callback
                },
                {
                    text: "取消",
                    "class": "btn btn-xs",
                    click: function () {
                        $(this).dialog("close");
                    }
                }
            ];
        } else if (type == 'alert') {
            this.buttons = [
                {
                    text: "确定",
                    "class": "btn btn-primary btn-xs",
                    click: callback
                }
            ];
        }
    }
};
(function () {
    try {
        ace.settings.check('main-container', 'fixed');
        ace.settings.check('breadcrumbs', 'fixed');
    } catch (e) {
    }
    // 缓存加载完毕，所有回调的集合
    var CacheReadyCallbacks = {
        callbacks: [],
        execute: function () {
            var cbs = this.callbacks;
            if (cbs.length) {
                $.each(cbs, function (i, e) {
                    // flag为true表示该回调可以执行了
                    if (e[1]) {
                        try {
                            e[0]();
                        } catch (e) {
                            console.log(e);
                        }
                        // 执行完后禁用
                        e[1] = false;
                    }
                });
            }
        },
        setFlag: function (name, flag) {
            if (typeof flag == 'undefined') {
                flag = true;
            }
            var cbs = this.callbacks;
            if (cbs.length) {
                $.each(cbs, function (i, e) {
                    if (e[2] == name) {
                        e[1] = flag;
                    }
                });
            }
        }
    }
    // 从后台获取部门信息，存入LocalStorage
    function deptAjax() {
        $.ajax({
            url: basePath + '/plan/departments.do',
            type: 'get',
            success: function (resp) {
                try {
                    iLocalStorage.setItem('depts', JSON.stringify(resp));
                } catch (e) {
                    alert('获取部门信息失败！');
                }
                // 失败后仍执行回调
                CacheReadyCallbacks.setFlag('depts');
                CacheReadyCallbacks.execute();
            },
            error: function () {
                alert('获取部门信息失败！');
            }
        });
    }

    $.extend({
        /**
         * 全局函数：传入部门id串，获取对应的部门
         * @param ids 部门id串，以逗号隔开
         * @param type 默认为'string'。传入'string'返回string，传入'json'返回json
         */
        getDepts: function (ids, type) {
            var deptIds, depts = [];
            var deptsJSON = iLocalStorage.getItem('depts');
            try {
                deptsJSON = $.parseJSON(deptsJSON);
            } catch (e) {
                deptAjax();
                return null;
            }
            if (((ids || 'all') != 'all') && typeof ids == 'string') {
                deptIds = ids.split(',');
            }
            deptIds = deptIds || [];
            var deptString = ',';
            if (deptsJSON && deptsJSON.length) {
                $.each(deptsJSON, function (i, e) {
                    if (ids == 'all' || deptIds.indexOf(e.id + '') != -1) {
                        deptString = deptString + ',' + e.name;
                        depts.push(e);
                    }
                });
                if ((type || 'string') == 'string') {
                    return deptString.substring(2, deptString.length);
                } else if (type == 'json') {
                    return depts;
                }
            }
        },
        /**
         * 全局函数：待缓存准备好后，再执行回调。注意！不能与$(function(){...})嵌套使用
         * @param callback 回调函数
         * @param name 缓存名称，默认为'depts'，名称可以重复
         */
        cacheReady: function (callback, name) {
            name = name || 'depts';
            if (typeof callback == 'function') {
                CacheReadyCallbacks.callbacks.push([callback, false, name]);
            }
        }
    });

    $.fn.extend({
        /**
         * 自动填充表单
         * @param obj
         */
        loadForm: function (obj) {
            var that = $(this);
            obj = obj || {};
            var allInputs = that.find('input[name]');
            var allSelects = that.find('select[name]');
            $.each(allInputs, function (i, e) {
                var objVal = obj[$(e).attr('name')];
                var type = $(e).attr('type');
                if (type == 'radio' || type == 'checkbox') {
                    if ($(e).val() == objVal) {
                        $(e).prop('checked', true);
                    } else {
                        $(e).removeAttr('checked');
                    }
                } else {
                    $(e).val(objVal);
                    if ($(e).hasClass('date-picker')) {
                        var parsedDate = new Date(objVal);
                        if (parsedDate != 'Invalid Date' && (objVal - 1)) {
                            $(e).val(parsedDate.fmt('yyyy-MM-dd hh:mm'));
                        }
                    }
                }
            });
            $.each(allSelects, function (i, e) {
                var objVal = obj[$(e).attr('name')];
                $(e).val(objVal);
                var $span = $(e).parent().find('span');
                $.each($(e).find('option'), function (i1, e1) {
                    if ($(e1).val() == objVal) {
                        $span.text($(e1).text());
                        return false;
                    } else {
                        $span.text('');
                    }
                })
            });
        },
        /**
         * 使表单只读/读写
         * @param readonly
         */
        toggleForm: function (readonly) {
            readonly = readonly ? true : false;
            var that = $(this);
            var allInputs = that.find('input[name]');
            var allSelects = that.find('select[name]');
            $.each(allInputs, function (i, e) {
                var _e = $(e);
                var type = _e.attr('type');
                if (type == 'radio' || type == 'checkbox' || _e.hasClass('depts')) {
                    _e.attr('disabled', readonly);
                } else if (_e.hasClass('date-picker')) {
                    _e.datepicker(readonly ? 'destroy' : undefined);
                } else {
                    _e.attr('readonly', readonly);
                }
            });
            $.each(allSelects, function (i, e) {
                $(e).attr('readonly', readonly);
                $(e).trigger('chosen:updated');
            });
            $('.focusUser').attr('disabled', readonly);
        },
        /**
         * 非multipart表单序列化
         * @returns {{}}
         */
        serializeObject: function () {
            var o = {};
            var a = this.serializeArray();
            $.each(a, function () {
                if (o[this.name] !== undefined) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        }
    });

    $(function () {
        // 检查部门信息缓存
        if (!iLocalStorage.getItem('depts')) {
            deptAjax();
        } else {
            CacheReadyCallbacks.setFlag('depts');
            CacheReadyCallbacks.execute();
        }

        // 展开模块菜单
        var url = window.location.href;
        var $deepest = $('[href="' + url + '"]');
        var $breadcrumbs = $('#breadcrumbs ul');
        $.each($.makeArray($deepest.parents('li')).reverse(), function (i, e) {
            $(e).addClass('active open');
            $breadcrumbs.append('<li class="active">' + $(e).children('a').text().trim() + '</li>');
        });

        // 下拉框
        $(".chosen-select").chosen();
        $('.chosen-container').css('width', '200px');

        // 日期框
        $('.date-picker').datepicker();

        // 小型滚动条
        $('.slim-scroll').each(function () {
            var that = $(this);
            that.slimScroll({
                height: that.data('height') || 100,
                railVisible: true
            });
        });
    });

    /**
     * 对Date的扩展，将 Date 转化为指定格式的String。
     * 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
     * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)。
     * 例子：
     * (new Date()).fmt("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
     * (new Date()).fmt("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
     */
    Date.prototype.fmt = function (fmt) {
        var o = {
            "M+": this.getMonth() + 1,
            "d+": this.getDate(),
            "h+": this.getHours(),
            "m+": this.getMinutes(),
            "s+": this.getSeconds(),
            "q+": Math.floor((this.getMonth() + 3) / 3),
            "S": this.getMilliseconds()
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }

    // 日期插件汉化
    $.datepicker.regional["zh-CN"] = {
        closeText: "关闭",
        prevText: "&#x3c;上月",
        nextText: "下月&#x3e;",
        currentText: "今天",
        monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
        monthNamesShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],
        dayNames: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"],
        dayNamesShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],
        dayNamesMin: ["日", "一", "二", "三", "四", "五", "六"],
        weekHeader: "周",
        dateFormat: "yy-mm-dd",
        firstDay: 1,
        isRTL: !1,
        showMonthAfterYear: !0,
        yearSuffix: "年"
    }
    $.datepicker.setDefaults($.datepicker.regional["zh-CN"]);

    // 添加手机号码正则
    jQuery.validator.addMethod("phone", function (value, element) {
        return this.optional(element) || /^\(\d{3}\) \d{3}\-\d{4}( x\d{1,6})?$/.test(value);
    }, "请输入有效的手机号码");

    // jQuery UI Dialog改动
    $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
        _title: function (title) {
            var $title = this.options.title || '&nbsp;'
            if (("title_html" in this.options) && this.options.title_html == true)
                title.html($title);
            else title.text($title);
        }
    }));
}());