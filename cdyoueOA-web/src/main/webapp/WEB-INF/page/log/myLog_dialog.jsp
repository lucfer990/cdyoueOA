<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>

<div id="dialog-message" class="hide">
	<form method="post" id="newLog-form" class="form-horizontal" novalidate="novalidate">
		<div class="form-group">
			<label for="logType"
				class="control-label col-xs-1 col-sm-2 no-padding-right">日志类型：</label>
			<div class="col-xs-12 col-sm-9">
				<div class="clearfix">
					<select name="platform" id="logType" class="chosen-select">
                        <option value="日报">日报</option>
                       <!--  <option value="周报">周报</option>
                        <option value="月度报告">月度报告</option>
                        <option value="季度报告">季度报告</option>
                        <option value="年度报告">年度报告</option> -->
                    </select>
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<label for="platform" class="control-label col-xs-1 col-sm-2 no-padding-right">开始时间：</label>
			<div class="col-xs-2 col-sm-2">
			<input class="laydate-icon" readonly="readonly" placeholder="开始时间"  style="width:150px;"
			 id="startTime">
			</div>
			
			<label class="control-label col-xs-2 col-sm-offset-2 no-padding-right">结束时间：</label>
			<div class="col-xs-2 col-sm-2">
			<input class="laydate-icon" readonly="readonly" placeholder="结束时间" style="width:150px;"
					 id="endTime">
			</div>
		</div>
		
		<div class="form-group">
			<label for="ProjectTitle"
				class="control-label col-xs-1 col-sm-2 no-padding-right">日志内容：</label>

			<div class="col-xs-12 col-sm-9">
				<textarea id="logContent" style="height:150px" class="form-control" placeholder="请输入日志内容"></textarea>
			</div>
		</div>
		
		<div class="form-group">
            <label for="focusUsers" class="control-label col-xs-12 col-sm-3 no-padding-right">计划关注人:</label>

            <div class="col-xs-12 col-sm-9">
                <div class="clearfix">
                    <input type="text" class="col-xs-12 col-sm-6" id="focusAAA" readonly="readonly">
                    
                    <input type="hidden" id="focusPeople" name="focusUsers">
                </div>
            </div>
        </div>
	 <input id="saveBtn" type="submit" class="hide"/>
	</form>
<script>
var start = {
    elem: '#startTime',
    format: 'YYYY-MM-DD hh:mm:ss',
    min: laydate.now(), //设定最小日期为当前日期
    max: laydate.now(), //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas; //将结束日的初始值设定为开始日
    }
};
var end = {
    elem: '#endTime',
    format: 'YYYY-MM-DD hh:mm:ss',
    min: laydate.now(),
    max: laydate.now(),
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(start);
laydate(end);
</script>
</div>

<div id="dialog-messageShow" class="hide">
		<div class="form-group">
					<label for="logType"
						class="control-label col-xs-1 col-sm-2 no-padding-right">日志类型：</label>
					<div class="col-xs-12 col-sm-9">
						<div class="clearfix">
							<select name="platform" id="logType" class="chosen-select">
		                        <option value="日报">日报</option>
		                    </select>
						</div>
					</div>
				</div>
	<div class="form-group">
            <label for="ProjectTitle" class="control-label col-xs-12 col-sm-6 no-padding-conter">开始时间：</label>
            <div class="col-xs-6 col-sm-9">
                <div class="clearfix">
            <input  id="startTimeS" type="text" data-date-format="yyyy-mm-dd" readonly="readonly">
                </div>
            </div>
        </div>
		<div class="form-group">
            <label for="ProjectTitle" class="control-label col-xs-12 col-sm-6 no-padding-conter">结束时间：</label>
            <div class="col-xs-12 col-sm-9">
                <div class="clearfix">
            <input id="endTimeS" type="text" data-date-format="yyyy-mm-dd" readonly="readonly"/>
                </div>
            </div>
        </div>
         <div class="form-group">
            <label for="ProjectTitle" class="control-label col-xs-12 col-sm-9 no-padding-right">日志内容:</label>
            <div class="col-xs-12 col-sm-9">
                <textarea class="form-control" style="height: 214px; width: 652px;" id="contentS"></textarea>
            </div>
        </div> 
</div>