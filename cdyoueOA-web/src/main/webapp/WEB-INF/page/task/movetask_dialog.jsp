<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="movetask_dialog" class="hide">
    <form method="get" id="moveTaskForm" class="form-horizontal" novalidate="novalidate" >
         <input type="hidden" class="col-xs-12 col-sm-6" id="planId" name="planId" > 
          <!-- 获取选中计划 id-->  
             <input type="hidden" class="col-xs-12 col-sm-6" id="mtTaskId" name="taskId" >
        <div class="form-group">
        <input type="hidden" class="col-xs-12 col-sm-6" id="mtPlanId" name="planId" >                                          
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
	        	<input class="span8 date-picker" name="startTime" id="mtStartTime" value="" type="text" data-date-format="yyyy-mm-dd"  placeholder="开通日期" title="开通日期">
                <i class="icon-calendar"></i>
            </div>

            <label class="control-label col-xs-2 col-sm-2 no-padding-right">结束时间：</label>

            <div class="col-xs-2 col-sm-2">
        		<input class="span8 date-picker" name="endTime" id="mtEndTime" value="" type="text" data-date-format="yyyy-mm-dd"  placeholder="到期日期" title="到期日期"/>
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
            <label for="platform" class="control-label col-xs-6 col-sm-3 no-padding-right">移交对象：</label>

            <div class="col-xs-2 col-sm-2">
                <div class="clearfix"> 
                 <select name="executorId" id="mtexecutorId" ></select>            
                   
                </div>
            </div>
        </div>   
            <div class="form-group">
            <label for="mtcontentInfo" class="control-label col-xs-6 col-sm-3 no-padding-right">任务要求:</label>

            <div class="col-xs-12 col-sm-9">
            
               <textarea id="mtcontent"  readonly="readonly" name="content"></textarea>
            </div>
        </div> 
        <div class="form-group">
            <label for="ProjectTitle" class="control-label col-xs-6 col-sm-3 no-padding-right">移交说明:</label>
            <div class="col-xs-12 col-sm-9">
               <textarea id="mtcandicontent"  name="candiComment"></textarea>
            </div>
        </div>           
    </form> 
    <script type="text/javascript">
     $(function(){     	    	    	     	 
    	   $.get(basePath+"/plan/findDeptUsers.do",function(resp){
    		   var data=resp.data;
    		   if(data){    			 
    			   for(var i=0;i<data.length;i++){      				   
    				   $("#mtexecutorId").append("<option value='"+data[i].uId+"'>"+data[i].userName+"</option>"); 
    			   }    			       			   
    		   }else{
    			   
    			   $("#mtexecutorId").append("<option value=''>"+暂无人员+"</option>"); 
    		   }    
    	   });
    
       })
      </script> 
</div>