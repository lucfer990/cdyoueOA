package com.youedata.cd.cdyoueOA.web.log;

import com.youedata.cd.cdyoueOA.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("log")
public class LogController extends BaseController {
	/*
	 * 我的日志
	 */
	@RequestMapping("myLog")
	public String myLog() {
		return "log/myLog";
	}
	
	/*
	 * 待评日志
	 */
	@RequestMapping("commentLog")
	public String commentLog() {
		return "log/commentLog";
	}
	
	/*
	 * 日志关注
	 */
	@RequestMapping("logFocus")
	public String logFocus() {
		return "log/logFocus";
	}
}
