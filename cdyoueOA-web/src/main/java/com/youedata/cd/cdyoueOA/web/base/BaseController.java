package com.youedata.cd.cdyoueOA.web.base;

import com.youedata.cd.cdyoueOA.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * 基础控制器
 *
 * @author xiaqi
 * @create 2016/8/31
 */
public class BaseController {
    protected User getCurrentUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new AuthenticationException("登录失败，请重新登录");
        }
        return user;
    }
}
