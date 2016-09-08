package com.youedata.cd.cdyoueOA.web;

import com.youedata.cd.cdyoueOA.common.util.YouedataConstanst;
import com.youedata.cd.cdyoueOA.pojo.User;
import com.youedata.cd.cdyoueOA.web.base.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("main")
public class IndexController extends BaseController {
	/*
	 * 首页
	 */
	@RequestMapping("index")
	public String index(HttpSession session) {
		User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
		session.setAttribute("user", user);
		return "index/index";
	}

	/*
	 * 登录页面
	 */
	@RequestMapping("login")
	public String login() {
		System.out.println();
		return "login";
	}

	/*
	 * 登出（注销）
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_key");// KEY值待修改
		return "login";
	}
}
