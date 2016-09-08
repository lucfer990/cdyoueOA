package com.youedata.cd.cdyoueOA.service.dept;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.youedata.cd.cdyoueOA.pojo.Dept;
import com.youedata.cd.cdyoueOA.pojo.YoueUserDto;


public interface DeptService {
	//查询所有部门
	List<Dept> selectAllDept();
	//根据部门id查询部门人员
	List<YoueUserDto> selectAllUserByDeptid(ArrayList<String> deptId);
	

}
