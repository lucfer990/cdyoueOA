<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="taskdetail_dialog" class="hide">
    <form method="get" id="taskDetailForm" class="form-horizontal" novalidate="novalidate" >
        <div class="form-group">                                         
            <label for="taskTitle" class="control-label col-xs-6 col-sm-3 no-padding-right">任务名称:</label>            
            <div class="col-xs-6 col-sm-9">
                <div class="clearfix">
                    <input type="text" class="col-xs-12 col-sm-6" id="tdTitle" name="title" readonly="readonly">
                    
                </div>
            </div>
        </div>
        <div class="form-group">                                         
            <label for="ProjectTitle" class="control-label col-xs-6 col-sm-3 no-padding-right">分配人:</label>            
            <div class="col-xs-6 col-sm-9">
                <div class="clearfix">
                    <input type="text" class="col-xs-12 col-sm-6" id="tdAssignerName" name="assignerName" readonly="readonly">
                    
                </div>
            </div>
        </div> 
        <div class="form-group">                                         
            <label for="ProjectTitle" class="control-label col-xs-6 col-sm-3 no-padding-right">执行人:</label>            
            <div class="col-xs-6 col-sm-9">
                <div class="clearfix">
                    <input type="text" class="col-xs-12 col-sm-6" id="tdExecutorName" name="executorName" readonly="readonly">
                    
                </div>
            </div>
        </div>            
        <div class="form-group">
            <label for="platform" class="control-label col-xs-6 col-sm-3 no-padding-right">紧急程度：</label>
            <div class="col-xs-4 col-sm-4">
                <div>
                    <label class="blue">
                        <input type="radio" class="ace" value="1" name="emergency" readonly="readonly">
                        <span class="lbl"> 紧急重要</span>
                        <input type="radio" class="ace" value="2" name="emergency" readonly="readonly">
                        <span class="lbl"> 紧急不重要</span>
                        <input type="radio" class="ace" value="3" name="emergency" readonly="readonly">
                        <span class="lbl"> 不紧急重要</span>
                        <input type="radio" class="ace" value="4" name="emergency" readonly="readonly">
                        <span class="lbl"> 不紧急不重要</span>
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="platform" class="control-label col-xs-2 col-sm-3 no-padding-right">开始时间：</label>
            <div class="col-xs-2 col-sm-2">
	        	<input class="span8 date-picker" name="startTime" id="tdStartTime" value="" type="text" data-date-format="yyyy-MM-dd HH:mm:ss" readonly="readonly" placeholder="开通日期" title="开通日期">
                <i class="icon-calendar"></i>
            </div>

            <label class="control-label col-xs-2 col-sm-2 no-padding-right">结束时间：</label>

            <div class="col-xs-2 col-sm-2">
        		<input class="span8 date-picker" name="endTime" id="tdEndTime" value="" type="text" data-date-format="yyyy-MM-dd HH:mm:ss" readonly="readonly" placeholder="到期日期" title="到期日期"/>
                <i class="icon-calendar"></i>
            </div>
        </div>     
   		 </script>
            <div class="form-group">
            <label for="ProjectTitle" class="control-label col-xs-6 col-sm-3 no-padding-right">任务要求:</label>

            <div class="col-xs-12 col-sm-9">
               <textarea id="tdcontent" name="content" readonly="readonly"></textarea>
            </div>
        </div>  
        
    </form> 
</div>