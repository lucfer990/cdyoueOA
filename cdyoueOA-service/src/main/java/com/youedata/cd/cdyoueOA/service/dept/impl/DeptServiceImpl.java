package com.youedata.cd.cdyoueOA.service.dept.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youedata.cd.cdyoueOA.dao.dept.DeptDao;
import com.youedata.cd.cdyoueOA.pojo.Dept;
import com.youedata.cd.cdyoueOA.pojo.YoueUserDto;
import com.youedata.cd.cdyoueOA.service.dept.DeptService;
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;
	@Override
	public List<Dept> selectAllDept() {
				
		return deptDao.selectAllDept();
		
	}
	@Override
	public List<YoueUserDto> selectAllUserByDeptid(ArrayList<String> deptId) {		
		return deptDao.selectAllUserByDeptid(deptId);
	}
	

}
