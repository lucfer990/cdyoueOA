package com.youedata.cd.cdyoueOA.service.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

import com.youedata.cd.cdyoueOA.pojo.User;


public interface UserService {
	/**
	 * 用户登录
	 * 
	 * @param userName
	 * @param password
	 * @param session
	 * @return
	 */
	public boolean checkLogin(String userName, String password, HttpSession session);
	
	/**
	 * 输入的密码是否存在
	 * @param userName
	 * @param password
	 * @return 
	 */
	public boolean isPasswordExist(String userName, String password);
	
	/**
	 * 修改密码
	 * @param userName
	 * @param pswd
	 * @return
	 */
	public ModelMap updatePasswordByFuid(String userName, String pswd);

	/**
	 * 根据用户名获取用户
	 * @param userId
	 * @return
	 */	 	
	public User getUserByuserId(String userId);

	/**
	 * 查询所有用户
	 * */
	public List<User> findAllUser();
	/**
	 * 根据用户ID字符串查找用户
	 * */
	public List<User> findUserByUid(String userId);
	

}
