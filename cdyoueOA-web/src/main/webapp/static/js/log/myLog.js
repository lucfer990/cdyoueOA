$(document).ready(function() {
	jQuery(function($) {
		// 初始化日历
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		
		var calendar = $('#calendar').fullCalendar({
			 buttonText: {
				prev: '<i class="icon-chevron-left"></i>',
				next: '<i class="icon-chevron-right"></i>',
			},
			header: {
				left: 'prevYear,prev,next,nextYear today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			
		    events: function(start, end, callback) {
		    	// 显示数据
            	$.post(basePath +"/aLog/gatAll.do",function(docs){
					var events = [];
					for (var doc in docs) {
						  var st = new Date(docs[doc].startTime);
						  var et = new Date(docs[doc].endTime);
						  
						  var tsty = y-st.getFullYear();
						  var tstm = m-st.getMonth();
						  var tstd = d-st.getDate();
						  var tsth = st.getHours();
						  var tstmi = st.getMinutes();
						  
						  var tety = y-et.getFullYear();
						  var tetm = m-et.getMonth();
						  var tetd = d-et.getDate();
						  var teth = et.getHours();
						  var tetmi = et.getMinutes();
						  
						  if(docs[doc].title=="日报"){
							  events.push({
								  	id:docs[doc].id,
			                    	title: docs[doc].content,
			        				start: new Date(y-tsty, m-tstm, d-tstd,tsth,tstmi),
			        				end: new Date(y-tety, m-tetm, d-tetd,teth,tetmi),
		        					allDay: false
							  });
						  }else if(docs[doc].title=="周报"){
							  events.push({
								  title: docs[doc].content,
								  start: new Date(y-tsty, m-tstm, d-tstd,tsth,tstmi),
								  end: new Date(y-tety, m-tetm, d-tetd,teth,tetmi),
								  className: 'label-important',
							  });
						  }else{
							  events.push({
								  title: docs[doc].content,
								  start: new Date(y-tsty, m-tstm, d-tstd,tsth,tstmi),
								  end: new Date(y-tety, m-tetm, d-tetd,teth,tetmi),
								  className: 'label-success',
							  });
						  }
					}
	                callback(events);
				});
		    },
			
			aspectRatio : 2, // 宽高比例
			editable: true,
			selectable: true,
			selectHelper: true,
			select: function(start, end, allDay) {
				// 允许使用HTML标题
				$.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
		            _title: function (title) {
		                var $title = this.options.title || '&nbsp;'
		                if (("title_html" in this.options) && this.options.title_html == true)
		                    title.html($title);
		                else title.text($title);
		            }
		        }));
				
				var startTime = start.getFullYear()+"-"+(start.getMonth()+1)+"-"+start.getDate()/*+" "+start.getHours()+":"+start.getMinutes()+":"+start.getSeconds()*/;
				var endTime = end.getFullYear()+"-"+(end.getMonth()+1)+"-"+end.getDate()/*+" "+end.getHours()+":"+end.getMinutes()+":"+end.getSeconds()*/;
				// 回显日期
				$("#startTime").val(startTime);
            	$("#endTime").val(endTime);
				
				// 保存弹窗
	            var dialog = $("#dialog-message").removeClass('hide').dialog({
	                modal: true,
	                width: 747,
	                height: 450,
	                title: "<div class='widget-header widget-header-small'><h4 class='smaller'>添加日志</h4></div>",
	                title_html: true,
	                buttons: [{
	                        text: "取消",
	                        "class": "btn btn-xs",
	                        click: function () {
	                            $(this).dialog("close");
	                        }
	                    },
	                    {
	                        text: "保存",
	                        "class": "btn btn-primary btn-xs",
	                        click: function () {
	                        	startTime = $("#startTime").val();
	                        	endTime = $("#endTime").val();
	                        	var logType = $("#logType").val();
	                        	var logContent = $("#logContent").val();
	                        	var focusPeople = $("#focusPeople").val();
	                        	// 保存数据
	                        	$.post(basePath +"/aLog/add.do",{
	    							startTime:new Date(startTime),
	    							endTime:new Date(endTime),
	    							title:logType,
	    							content:logContent,
	    							focusUsers:focusPeople
	    						},function(){
	    							$.MsgBox.Alert('提示','保存成功！');
	    							$('#calendar').fullCalendar('refetchEvents'); // 刷新事件
	    							$("#logContent").val("");
	    							$("#focusPeople").val("");
	    						});
	                        	$(this).dialog("close");
	                        }
	                    }
	                ]
	            });
			},
			
			
			eventClick: function(calEvent, jsEvent, view) {
				// 查看弹窗
				//alert(calEvent.id);
				$.ajax({
					url : basePath + "/aLog/get.do",
					type : "post",
					data : "id="+calEvent.id,
					dataType : "json",
					success : function(result) {
						console.log(result);
							var dialog = $("#dialog-messageShow").removeClass('hide').dialog({
			                modal: true,
			                width: 712,
			                height: 545,
							title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>日志详情</h4></div>", 
			                title_html: true,
			                buttons: [
			                    {
			                        text: "取消",
			                        "class": "btn btn-info",
			                        click: function () {
			                            $(this).dialog("close");
			                        }
			                    },{
			                    	text:"删除",
			                    	"class":"btn btn-danger",
			                    	click: function(){
			                    		$.ajax({
			                    			url:basePath+"/aLog/delLog.do",
			                    			type : "post",
			            					data : "id="+calEvent.id,
			            					dataType : "json",
			            					success : function(result) {
			            						if(result == 1){
			            							$.MsgBox.Alert('提示','删除成功！');
			            							window.location.assign(basePath+"/log/myLog.do");
			            						}else{
			            							$.MsgBox.Alert('提示','删除失败！');
			            						}
			            					}
			                    		});
			                    		$(this).dialog("close");
			                    	}
			                    }
			                ]
			             }); 
			           	 $("#startTimeS").val(new Date(result.startTime).fmt("yyyy-MM-dd hh:mm"));
			           	 $("#endTimeS").val(new Date(result.endTime).fmt("yyyy-MM-dd hh:mm"));
			           	 $("#contentS").val(result.content);
			           	 $("#focusAAAS").val("");
						},
					});
			},
			
			
		});
	});
	
				
				
				
//	            var dialog = $("#dialog-message").removeClass('hide').dialog({
//	                modal: true,
//	                width: 747,
//	                height: 450,
//	                title: "<div class='widget-header widget-header-small'><h4 class='smaller'>我的日志</h4></div>",
//	                title_html: true,
//	                buttons: [{
//	                        text: "取消",
//	                        "class": "btn btn-xs",
//	                        click: function () {
//	                            $(this).dialog("close");
//	                        }
//	                    },
//	                    /*{
//	                        text: "保存",
//	                        "class": "btn btn-primary btn-xs",
//	                        click: function () {
//	                        	
//	                        	startTime = $("#startTime").val();
//	                        	endTime = $("#endTime").val();
//	                        	var logType = $("#logType").val();
//	                        	var logContent = $("#logContent").val();
//	                        	var focusPeople = $("#focusPeople").val();
//	                        	// 保存数据
//	                        	$.post(basePath +"/aLog/add.do",{
//	    							startTime:new Date(startTime),
//	    							endTime:new Date(endTime),
//	    							title:logType,
//	    							content:logContent,
//	    							focusUsers:focusPeople
//	    						},function(){
//	    							$.MsgBox.Alert('提示','保存成功！');
//	    							$("#logContent").val("");
//	    							$("#focusPeople").val("");
//	    						});
//	                        	$(this).dialog("close");
//	                        }
//	                    }*/
//	                ]
//	            });
		
//计划关注对话框
	$('#focusAAA').on('click', function (e) {
		var that = $(this);
		console.log(that);
		$.deptsDialog('mems', function (depts, mems) {
			that.val(mems.map(function (ele) {
				return ele.userName;
			}).join(","));
			$('#focusPeople').val(mems.map(function (ele) {
				return ele.uId;
			}).join(","));
		});
	});
});

