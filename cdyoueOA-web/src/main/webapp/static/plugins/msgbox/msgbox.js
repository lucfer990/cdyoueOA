(function () {
    // 确定按钮事件
    var btnOk = function (callback) {
        $(".mb_btn_ok").click(function () {
            if (typeof (callback) == 'function') {
                callback();
            }
            $(".mb_box,.mb_con").remove();
        });
    };
    // 取消按钮事件
    var btnNo = function (callback) {
        $(".mb_btn_no,.mb_ico").click(function () {
            if (typeof (callback) == 'function') {
                callback();
            }
            $(".mb_box,.mb_con").remove();
        });
    };
    $.MsgBox = {
        Alert: function (title, msg, callback) {
            GenerateHtml("alert", title, msg);
            btnNo(callback);
        },
        Confirm: function (title, msg, callback) {
            GenerateHtml("confirm", title, msg);
            btnOk(callback);
            btnNo();
        }
    };
    // 生成Html
    var GenerateHtml = function (type, title, msg) {
        var _html = "";
        _html += '<div class="mb_box"></div><div class="mb_con"><span class="mb_tit">' +
            '<i class="icon-comment">&emsp;' + title + '</i></span>';
        _html += '<a class="mb_ico"><i class="icon-remove"></i></a><div class="mb_msg" style="text-align:center;"> '
            + msg + ' </div><div class="mb_btnbox">';
        if (type == "alert") {
            _html += '<input class="btn btn-primary mb_btn_no" type="button" value="关闭" />';
        }
        if (type == "confirm") {
            _html += '<input class="btn btn-primary mb_btn_ok" type="button" value="确定" />';
            _html += '<input class="btn mb_btn_no" type="button" value="取消" />';
        }
        _html += '</div></div>';

        // 必须先将_html添加到body，再设置Css样式
        $("body").append(_html);
        GenerateCss();
        $(".mb_con").show();
    };

    //生成Css
    var GenerateCss = function () {

        var _height = window.screen.height;
        var _widht = window.screen.width;
        //弹窗宽高
        var boxWidth = $(".mb_con").width();
        var boxHeight = $(".mb_con").height();

        //让提示框居中
        $(".mb_con").css({
            top: (_height - boxHeight) / 3 + "px",
            left: (_widht - boxWidth) / 2 + "px"
        });
    }
}());