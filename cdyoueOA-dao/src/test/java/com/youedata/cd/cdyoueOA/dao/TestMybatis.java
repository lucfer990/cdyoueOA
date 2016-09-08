package com.youedata.cd.cdyoueOA.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.youedata.cd.cdyoueOA.dao.testUser.TestUserMapper;
import com.youedata.cd.cdyoueOA.pojo.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-cdyoueOA-mybatis.xml")
public class TestMybatis {
	@Resource
	private TestUserMapper testUserMapper = null;
	
	@Test
	public void test1(){
		User u = testUserMapper.selectByUserId("wangshuangcheng");
		System.out.println(u.toString());
	}
}
