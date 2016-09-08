<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>

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
            <input  id="startTimeS" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" disabled>
                </div>
            </div>
        </div>
		<div class="form-group">
            <label for="ProjectTitle" class="control-label col-xs-12 col-sm-6 no-padding-conter">结束时间：</label>

            <div class="col-xs-12 col-sm-9">
                <div class="clearfix">
            <input id="endTimeS" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" disabled/>
                </div>
            </div>
        </div>
         <div class="form-group">
            <label for="ProjectTitle" class="control-label col-xs-12 col-sm-9 no-padding-right">日志内容:</label>

            <div class="col-xs-12 col-sm-9">
                <textarea id="contentS" style="height: 295px; width: 595px;" class="form-control"></textarea>
            </div>
        </div> 
</div>