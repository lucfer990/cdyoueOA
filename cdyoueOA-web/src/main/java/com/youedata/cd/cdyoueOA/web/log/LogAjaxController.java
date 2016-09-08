package com.youedata.cd.cdyoueOA.web.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.youedata.cd.cdyoueOA.common.util.YouedataConstanst;
import com.youedata.cd.cdyoueOA.pojo.Log;
import com.youedata.cd.cdyoueOA.pojo.User;
import com.youedata.cd.cdyoueOA.service.log.LogService;
import com.youedata.cd.cdyoueOA.web.base.BaseController;

@Controller
@RequestMapping("aLog")
public class LogAjaxController extends BaseController {
	@Autowired
	private LogService logService;

	/*
	 * 添加日志
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public void add(Log log, HttpSession session) {
		 User user = (User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
		 Long uid = Long.valueOf(user.getUid());
		 log.setFillId(uid); // 填写日志的人
		 logService.add(log);
	}
	
	/*
	 * 获取个人全部日志
	 */
	@RequestMapping(value = "/gatAll", method = RequestMethod.POST)
	@ResponseBody
	public List<Log> getAll(Log log,  HttpSession session) {
		 User user = (User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
		 Long uid = Long.valueOf(user.getUid());
		 log.setFillId(uid); // 测试用，实际需要获取登录人的id
		 List<Log> all = logService.getAll(log);
		 return all;
	}
	/*
	 * 根据id获取Log对象
	 */
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public Log get(Long id){
		return logService.get(id);
	}
	
	/*
	 * 获取关注的全部日志
	 */
	@RequestMapping(value = "/gatLogFocus", method = RequestMethod.GET)
	@ResponseBody
	public Map gatLogFocus(Log log, int offset, int limit,String startTimeString , String order,HttpSession session) {
		Map map=new HashMap();
		User user = (User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
		Long uid = Long.valueOf(user.getUid());
		log.setFocusUsers(uid.toString()); // 测试用，实际需要获取登录人的id
		System.out.println(uid);
		map = logService.findByItem(log, offset, limit, order,startTimeString);
        return map;
	}
	/**
	 * @Title:LogAjaxController
	 * @描述:TODO 删除日志
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delLog",method = RequestMethod.POST)
	@ResponseBody
	public Integer delLog(Long id){
		if(id != null){
			logService.delLog(id);
			return 1;
		}
		return null;
	}

}
