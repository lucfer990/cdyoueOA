package com.youedata.cd.cdyoueOA.service.log;

import java.util.List;
import java.util.Map;

import com.youedata.cd.cdyoueOA.pojo.Log;

public interface LogService {
	// 添加
	public void add(Log log);

	// 删除
	public void delete(Long id);

	// 修改
	public void update(Log log);

	// 根据ID查询
	public Log get(Long id);

	// 查询所有
	public List<Log> getAll(Log log);

	// 按日期查询所有（月份）
	public List<Log> getDateQuery(Log log);

	// 按关注人查询
	public List<Log> getLogFocus(Log log);

	 /**
	 * 按条件动态查询
	 */
	 public Map findByItem(Log log, int offset, int limit, String order,String startTimeString);

	public void delLog(Long id);
}
