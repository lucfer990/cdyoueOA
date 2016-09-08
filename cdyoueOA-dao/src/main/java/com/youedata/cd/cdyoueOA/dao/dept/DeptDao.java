package com.youedata.cd.cdyoueOA.dao.dept;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.youedata.cd.base.dao.IBaseDao;
import com.youedata.cd.cdyoueOA.pojo.Dept;
import com.youedata.cd.cdyoueOA.pojo.User;
import com.youedata.cd.cdyoueOA.pojo.YoueUserDto;

public interface DeptDao extends IBaseDao<Dept> {
	//查询所有部门
	 List<Dept> selectAllDept();
	//根据部门id查询部门人员
	 List<YoueUserDto> selectAllUserByDeptid(@Param("deptId")ArrayList<String> deptId);
	

}
