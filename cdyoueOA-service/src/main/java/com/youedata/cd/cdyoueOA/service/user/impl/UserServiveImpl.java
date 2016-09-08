package com.youedata.cd.cdyoueOA.service.user.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.youedata.cd.base.common.constant.FlagDict;
import com.youedata.cd.cdyoueOA.common.date.ApacheCommonsCodecEncryptionUtil;
import com.youedata.cd.cdyoueOA.common.util.YoueStringUtils;
import com.youedata.cd.cdyoueOA.dao.user.UserDao;
import com.youedata.cd.cdyoueOA.pojo.User;
import com.youedata.cd.cdyoueOA.service.user.UserService;


@Service
public class UserServiveImpl implements UserService {
	
	@Autowired
    private UserDao userDao;

	/**
	 * 登陆
	 */
	@Override
	public boolean checkLogin(String userName, String password,
			HttpSession session) {

		Map param = new HashMap();
		param.put("USER_ID", userName);
		//1、在本地数据库查看用户是否存在
		User userInfo = userDao.findUserByUserTypeAndPswd(param);
		if(userInfo != null){
			try {
				if(userInfo.getPassword().equals(ApacheCommonsCodecEncryptionUtil.md5Crypt(password.getBytes("utf8"),userInfo.getPassword()))){
					session.setAttribute("user", userInfo);
					return true;
				}
			} catch (UnsupportedEncodingException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return false;
		
	}

	@Override
	public boolean isPasswordExist(String userName, String password) {
		Map param = new HashMap();
		param.put("USER_ID", userName);
		
		User userInfo = (User)userDao.findUserByUserTypeAndPswd(param);
		if(userInfo != null) {
			String pswd = userInfo.getPassword();
			try {
				if (pswd.equals(ApacheCommonsCodecEncryptionUtil.md5Crypt(password.getBytes("utf-8")))) {
					return true;
				}
			} catch (UnsupportedEncodingException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public ModelMap updatePasswordByFuid(String userName, String pswd) {
		ModelMap maps = new ModelMap();
		try {
			//1.修改本地密码
			User userInfo = new User();
			userInfo.setUserId(userName);
			userInfo.setPassword(ApacheCommonsCodecEncryptionUtil.md5Crypt(pswd.getBytes("utf-8")));
			userDao.updatePasswordByFuid(userInfo);
			
		} catch (Exception e) {
			maps = YoueStringUtils.setFlagAndMsg(maps, FlagDict.FAIL);
			return maps;
		}
		maps = YoueStringUtils.setFlagAndMsg(maps, FlagDict.SUCCESS);
		return maps;
	}


	@Override
	public User getUserByuserId(String userId) {
		Map map=new HashMap<>();
		map.put("USER_ID", userId);
		return userDao.findUserByUserTypeAndPswd(map);
	}
	


	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public List<User> findUserByUid(String userId) {
		return userDao.findUserByUid(userId);
	}

}
