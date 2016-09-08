<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="resolve_dialog" class="hide">
    <form method="get" id="validation-form1" class="form-horizontal" novalidate="novalidate" >
        <div class="form-group">                            
             <input type="hidden" class="col-xs-12 col-sm-6" id="rtplanId" name="planId" > 
          <!-- 获取选中计划 id-->  
             <input type="hidden" class="col-xs-12 col-sm-6" id="taskId" name="taskId" >
             <input type="hidden" class="col-xs-12 col-sm-6" id="focusUsers" name="focusUsers" >
              
            <label for="ProjectTitle" class="control-label col-xs-6 col-sm-3 no-padding-right">任务名称:</label>            
            <div class="col-xs-6 col-sm-9">
                <div class="clearfix">
                    <input type="text" class="col-xs-12 col-sm-6" id="ProjectTitle" name="title">
                    
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="platform" class="control-label col-xs-6 col-sm-3 no-padding-right">紧急程度：</label>
            <div class="col-xs-4 col-sm-4">
                <div>
                    <label class="blue">
                        <input type="radio" class="ace" value="1" name="emergency">
                        <span class="lbl"> 紧急重要</span>
                        <input type="radio" class="ace" value="2" name="emergency">
                        <span class="lbl"> 紧急不重要</span>
                        <input type="radio" class="ace" value="3" name="emergency">
                        <span class="lbl"> 不紧急重要</span>
                        <input type="radio" class="ace" value="4" name="emergency">
                        <span class="lbl"> 不紧急不重要</span>
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="platform" class="control-label col-xs-2 col-sm-3 no-padding-right">开始时间：</label>
            <div class="col-xs-2 col-sm-2">
	        	<input class="span8 date-picker" name="startTime" id="startTime" value="" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="开通日期" title="开通日期">
                <i class="icon-calendar"></i>
            </div>

            <label class="control-label col-xs-2 col-sm-2 no-padding-right">结束时间：</label>

            <div class="col-xs-2 col-sm-2">
        		<input class="span8 date-picker" name="endTime" id="endTime" value="" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="到期日期" title="到期日期"/>
                <i class="icon-calendar"></i>
            </div>
        </div>
        <div class="form-group">
            <label for="platform" class="control-label col-xs-6 col-sm-3 no-padding-right">消息提醒：</label>
            <div class="col-xs-4 col-sm-4">
                <div>
                    <label class="blue">
                        <input type="radio" class="ace" value="1" name="alert">
                        <span class="lbl"> 需要</span>
                        <input type="radio" class="ace" value="0" name="alert">
                        <span class="lbl"> 不需要</span>                        
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="platform" class="control-label col-xs-6 col-sm-3 no-padding-right">执行人：</label>

            <div class="col-xs-2 col-sm-2">
                <div class="clearfix"> 
                 <select name="executorId" id="executorId" ></select>            
                   
                </div>
            </div>
        </div>
            <div class="form-group">
            <label for="Taskcontent" class="control-label col-xs-6 col-sm-3 no-padding-right">任务要求:</label>

            <div class="col-xs-12 col-sm-9">
                <textarea id="rtcontent" name="content"></textarea>
            </div>
        </div>      
    </form> 
    <script type="text/javascript">
     $(function(){    	  
    	   $.get(basePath+"/plan/findDeptUsers.do",function(resp){
    		   var ueInfo;    	   
        	   rtue.ready( function() {
        	            if(ueInfo){
        	                rtue.setContent(ueInfo);
        	            }
        	        } );
    		   var data=resp.data;
    		   if(data){    			 
    			   for(var i=0;i<data.length;i++){      				   
    				   $("#executorId").append("<option value='"+data[i].uId+"'>"+data[i].userName+"</option>"); 
    			   }    			       			   
    		   }else{
    			   
    			   $("#executorId").append("<option value=''>"+暂无人员+"</option>"); 
    		   }    
    	   });
    
       })
      </script> 
</div>