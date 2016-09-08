package com.youedata.cd.cdyoueOA.web;

import com.youedata.cd.base.common.constant.FlagDict;
import com.youedata.cd.cdyoueOA.common.util.YoueStringUtils;
import com.youedata.cd.cdyoueOA.common.util.YouedataConstanst;
import com.youedata.cd.cdyoueOA.pojo.User;
import com.youedata.cd.cdyoueOA.service.user.UserService;
import com.youedata.cd.cdyoueOA.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



@Controller
@RequestMapping("/")
public class UserController extends BaseController {
    
    @Resource
    private UserService userService;
	
	@RequestMapping(value = "loginPage")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "mainPage")
	public String indexPage() {
		return "redirect:/main/index.do";
	}	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap login(String USER_ID, String pswd, HttpSession session) {
		ModelMap maps = new ModelMap();
		//检查用户名和密码是否为空
		if (YoueStringUtils.isEmpty(USER_ID) || YoueStringUtils.isEmpty(pswd)) {
			maps = YoueStringUtils.setFlagAndMsg(maps, FlagDict.ILLEGAL_PARAM);
			return maps;
		}
		
		boolean judge = userService.checkLogin(USER_ID, pswd, session);
		if (!judge) {
			maps.put("msg", "用户名,或密码错误");
			return maps;
		}
		User user=userService.getUserByuserId(USER_ID);
		session.setAttribute(YouedataConstanst.SESSION_USERKEY, user);
		maps = YoueStringUtils.setFlagAndMsg(maps, FlagDict.SUCCESS);
		return maps;
	}
	
    /**
     * 登出
     * 
     * @return
     */
    @RequestMapping(value = "doLogout")
    public String doLogout(HttpSession session, HttpServletRequest request){
        session.setAttribute("user", null);
        session.invalidate();
        return "login";
    }
    
    /**
     * 修改密码
     * 
     * @return
     */
    @RequestMapping(value = "updatePassword")
    @ResponseBody
    public String updatePassword(String newPassword, HttpSession session){
    	User userInfo = (User)session.getAttribute("user");
    	userService.updatePasswordByFuid(userInfo.getUserId(), newPassword);
        return "success";
    }
    
    /**
     * 判断原始密码是否存在
     * 
     * @return
     */
    @RequestMapping(value = "isOldPasswordExist")
    @ResponseBody
    public ModelMap isOldPasswordExist(String oldPassword, HttpSession session){
    	User userInfo = (User)session.getAttribute("user");
    	
    	ModelMap maps = new ModelMap();
    	boolean flag = userService.isPasswordExist(userInfo.getUserId(), oldPassword);
    	if(!flag) {
    		maps = YoueStringUtils.setFlagAndMsg(maps, FlagDict.FAIL);
    		return maps;
    	}
    	maps = YoueStringUtils.setFlagAndMsg(maps, FlagDict.SUCCESS);
		return maps;
    }
  }
