package com.youedata.cd.cdyoueOA.common.deptToZtree;

import java.util.ArrayList;
import java.util.List;

import com.youedata.cd.cdyoueOA.pojo.Dept;
import com.youedata.cd.cdyoueOA.pojo.DeptTree;

public class DeptToZtreeUtil {
	// 把部门列表转换为Ztree列表
	public static List<DeptTree> deptToTreeList(List<Dept> list) {
		if (list != null) {
			List<DeptTree> list0 = new ArrayList<>();
			for (Dept d : list) {
				DeptTree dt = new DeptTree(d.getDeptId(), d.getDeptName(),
						d.getDeptParent(), false);
				list0.add(dt);

			}
			return list0;
		}
		return null;
	}

}
