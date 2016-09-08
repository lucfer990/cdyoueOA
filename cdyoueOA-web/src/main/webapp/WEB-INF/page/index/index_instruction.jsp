<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<div class="hr hr-12 hr-double"></div>
<a href="#" onclick="alert1()">$.getDepts说明</a>&emsp;&emsp;
<a href="#" onclick="alert2()">$.deptsDialog说明</a>&emsp;&emsp;
<a href="#" onclick="alert3()">$.cacheReady说明</a>&emsp;&emsp;
<a href="#" onclick="alert4()">$(选择器).fill说明</a>&emsp;&emsp;
<a href="#" onclick="alert5()">$.MsgBox说明</a>&emsp;&emsp;
<script type="text/javascript">
    function alert1(){
        $.MsgBox.Alert('$.getDepts说明','<h3>$.getDepts (ids, type)</h3><br/>' +
                '传入部门id串，获取对应的部门<br/>' +
                '<br/>ids - 部门id串，以逗号隔开<br/>' +
                '<br/>type - 默认为"string"。传入"string"返回string，传入"json"返回json');
    }
    function alert2(){
        $.MsgBox.Alert('$.deptsDialog说明','<h3>$.deptsDialog (type, callback)</h3><br/>' +
                '打开部门或人员选择对话框。<font color="red">注意必须引入common/departments.jsp文件！</font><br/>' +
                '<br/>type - 可选，传入"depts"表示部门对话框，"mems"表示人员对话框，默认为"depts"<br/>' +
                '<br/>callback - 可选，对话框"确定"按钮的回调事件。回调函数参数1：已选择部门；参数2：已选择人员');
    }
    function alert3(){
        $.MsgBox.Alert('$.cacheReady说明','<h3>$.cacheReady (callback, name)</h3><br/>' +
                '待缓存准备好后，再执行回调。<font color="red">注意！不能与$(function(){...})嵌套使用！</font><br/>' +
                '<br/>callback - 回调函数<br/>' +
                '<br/>name - 可选，缓存名称，默认为"depts"，名称可以重复');
    }
    function alert4(){
        $.MsgBox.Alert('$(选择器).fill说明','<h3>$("选择器").fill(json)</h3><br/>' +
                '将指定json自动填充到form。<br/>' +
                '不带参数为清空表单');
    }
    function alert5(){
        $.MsgBox.Alert('$.MsgBox说明','小型弹框函数，代替浏览器默认的alert()和confirm()<br/>' +
                '$.MsgBox.Alert(标题,内容,回调)<br/>' +
                '$.MsgBox.Confirm(标题,内容,回调)');
    }
</script>