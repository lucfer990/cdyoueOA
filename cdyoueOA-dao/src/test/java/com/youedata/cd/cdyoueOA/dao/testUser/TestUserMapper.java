package com.youedata.cd.cdyoueOA.dao.testUser;

import com.youedata.cd.base.dao.IBaseDao;
import com.youedata.cd.cdyoueOA.pojo.User;

public interface TestUserMapper extends IBaseDao<User> {
	public User selectByUserId(String userId);
}