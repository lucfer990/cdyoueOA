package com.youedata.cd.cdyoueOA.dao.user;

import java.util.List;
import java.util.Map;

import com.youedata.cd.cdyoueOA.pojo.User;


/**
 * @类名: UserDao
 * @描述: TODO 
 * @创建人: Guzhendong
 * @创建时间: 2016年8月29日 上午10:18:23
 */
public interface UserDao{
	
	/**
	 * 用户查询接口
	 * @param param
	 * @return
	 */
	public User findUserByUserTypeAndPswd(Map param);
	
	/**
	 * 修改密码
	 * @param user
	 */
	public void updatePasswordByFuid(User user);

	/**
	 * 查询所有用户
	 * */
	public List<User> findAllUser();

	/**
	 * 根据用户ID字符串查找用户userName
	 * */
	public List<User> findUserByUid(String userId);
}
