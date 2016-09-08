<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<ul class="pagination">
	<li><a val="${last_list}cPg=1" id="homepage"> 首页</a></li>
	<li><a val="${last_list}cPg=" id="lastpage"> 上一页</a></li>
	<li><a val="${last_list}cPg=" id="nextpage"> 下一页</a></li>
	<li><a val="${last_list}cPg=" id="endpage"> 尾页</a></li>
	<li>共有 <strong id="totalRows"></strong> 条记录，</li>
	<li>当前第 <strong id="currentPage"></strong> 页，共 <strong id="totalPages"></strong> 页</li>
</ul>