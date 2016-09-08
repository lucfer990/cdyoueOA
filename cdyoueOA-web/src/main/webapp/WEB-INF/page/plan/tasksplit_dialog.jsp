<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<div id="tasksplit_dialog" class="hide" style="display: none">
    <form method="get" id="validation-form1" class="form-horizontal" novalidate="novalidate" >
        <div class="form-group">             
             <input type="hidden" class="col-xs-12 col-sm-6" id="planId" name="planId" > 
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
                        <input type="radio" class="ace" value="4" name="emergency" checked>
                        <span class="lbl"> 不紧急不重要</span>
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="platform" class="control-label col-xs-2 col-sm-3 no-padding-right">开始时间：</label>
            <div class="col-xs-2 col-sm-2">
	        	<input class="span8 date-picker" name="startTime" id="startTime1" value="" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="开通日期" title="开通日期">
                <i class="icon-calendar"></i>
            </div>

            <label class="control-label col-xs-2 col-sm-2 no-padding-right">结束时间：</label>

            <div class="col-xs-2 col-sm-2">
        		<input class="span8 date-picker" name="endTime" id="endTime1" value="" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="到期日期" title="到期日期"/>
                <i class="icon-calendar"></i>
            </div>
        </div>
        <div class="form-group">
            <label for="platform" class="control-label col-xs-6 col-sm-3 no-padding-right">消息提醒：</label>
            <div class="col-xs-4 col-sm-4">
                <div>
                    <label class="blue">
                        <input type="radio" class="ace" value="1" name="alert" checked>
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
                              
               <%--  <c:choose>
                  <c:when test="${!deptUsers}">                                                  
                    <select name="executorId" id="executorId" class="chosen-select">
	                    <c:forEach items="${deptUsers}" var="user">
	                      <option value="${user.uId }">user.userName</option>
	                    </c:forEach>                    
                    </select>
                  </c:when>
                  <c:otherwise>
                    <select name="executorId" id="executorId" class="chosen-select">                   
                        
                        <option value="">当前部门暂时无人</option>
                    </select>
                  </c:otherwise>
                
                </c:choose> --%>
                   
                </div>
            </div>
        </div>
       <!--  
         <script type="text/javascript">
       		 $(document).ready(function() {
			  $('#content1').summernote({
			   	  lang:'zh-CN',//改为中文
			  	  width:800,
			  	  height: 300,                 // set editor height
				  minHeight: null,             // set minimum height of editor
				  maxHeight: null,             // set maximum height of editor
				  focus: true
			  });
			});
   		 </script> -->
            <div class="form-group">
            <label for="TaskContent" class="control-label col-xs-6 col-sm-3 no-padding-right">任务要求:</label>
            <div class="col-xs-12 col-sm-9">
            	<textarea id="content1" style="height: 200px;width: 800px;"name="content"></textarea>
            </div>
        </div>

    </form>
    <script type="text/javascript">
       $(function(){
    	   var ue = UE.getEditor('content1',{
               initialFrameWidth : 800,
               initialFrameHeight: 600
           });

    	   $.get(basePath+"/plan/findDeptUsers.do",function(resp){
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