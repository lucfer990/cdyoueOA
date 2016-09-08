<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="sidebar" id="sidebar">

	<div class="sidebar-shortcuts" id="sidebar-shortcuts">

		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span>

			<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>
	</div>
	<!-- #sidebar-shortcuts -->

	<ul class="nav nav-list">
		<li><a href="${basePath}/main/index.do"> <i
				class="icon-home"></i> <span class="menu-text"> 首页 </span>
		</a></li>

		<!-- 协同工作开始 -->
		<li><a href="#" class="dropdown-toggle"> <i
				class="icon-user"></i> <span class="menu-text"> 协同工作 </span> <b
				class="arrow icon-angle-down"></b></a>

			<ul class="submenu">
				<li><a href="#" class="dropdown-toggle"> <i
						class="icon-double-angle-right"></i> 工作计划 <b
						class="arrow icon-angle-down"></b>
				</a>
					<ul class="submenu">
						<li><a href="${basePath}/plan/myPlan.do"> <i class="icon-leaf"></i> 制定的计划
						</a></li>
						<li><a href="${basePath}/plan/attentionPlan.do"> <i class="icon-leaf"></i> 关注的计划
						</a></li>
						<li><a href="#"> <i class="icon-leaf"></i> 计划模板<code>（二期开发）</code>
						</a></li>
					</ul></li>
					
				<li><a href="#" class="dropdown-toggle"> <i
						class="icon-double-angle-right"></i> 工作任务 <b
						class="arrow icon-angle-down"></b>
				</a>
					<ul class="submenu">
						<li><a href="${basePath}/task/myTask.do"> <i class="icon-leaf"></i> 任务办理
						</a></li>						
						<li><a href="${basePath}/task/checkTask.do"> <i class="icon-leaf"></i> 任务监控
						</a></li>
						<li><a href="${basePath}/task/focusTask.do"> <i class="icon-leaf"></i> 任务关注
						</a></li>
						<li><a href="#"> <i class="icon-leaf"></i> 任务模板<code>（二期开发）</code>
						</a></li>
						<li><a href="#"> <i class="icon-leaf"></i> 完成情况
						</a></li>
					</ul></li>
					
				<li><a href="#" class="dropdown-toggle"> <i
						class="icon-double-angle-right"></i> 工作日志 <b
						class="arrow icon-angle-down"></b>
				</a>
					<ul class="submenu">
						<li><a href="${basePath}/log/myLog.do"> <i class="icon-leaf"></i> 我的日志
						</a></li>
						<%-- <li><a href="${basePath}/log/commentLog.do"> <i class="icon-leaf"></i> 待评日志
						</a></li> --%>
						<li><a href="${basePath}/log/logFocus.do"> <i class="icon-leaf"></i> 日志关注
						</a></li>
					</ul></li>
				
				<li><a href="#" class="dropdown-toggle"> <i
						class="icon-double-angle-right"></i> 工作报告 <b
						class="arrow icon-angle-down"></b>
				</a>
					<ul class="submenu">
						<li><a href="${basePath}/report/showReport.do"> <i class="icon-leaf"></i> 我的报告
						</a></li>
						<li><a href="${basePath}/report/showComment.do"> <i class="icon-leaf"></i> 报告评阅
						</a></li>
					</ul></li>
			</ul>
			</li>
		<!-- 协同工作结束 -->
	</ul>
	<!-- /.nav-list -->

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
			data-icon2="icon-double-angle-right"></i>
	</div>

</div>