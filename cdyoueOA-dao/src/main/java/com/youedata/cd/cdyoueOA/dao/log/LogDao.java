package com.youedata.cd.cdyoueOA.dao.log;

import java.util.List;
import java.util.Map;

import com.youedata.cd.cdyoueOA.pojo.Log;

public interface LogDao {
	// 添加
	void add(Log log);

	// 删除
	void delete(Long id);

	// 修改
	void update(Log log);

	// 根据ID查询
	Log get(Long id);

	// 查询所有
	List<Log> getAll(Log log);
	
	// 按日期查询所有（月份）
	List<Log> getDateQuery(Log log);
	
	// 按关注人查询
	List<Log> getLogFocus(Log log);

	/**
	 * 按条件动态查询 统计数据总数
	 */
	public Long findByItemCount(Map map);

	/**
	 * 按条件动态查询(分页)
	 */
	public List<Log> findByItem(Map map);
	/**
	 * 
	 * @Title:LogDao
	 * @描述:TODO 删除日志
	 * @param id 日志id
	 */
	void delLog(Long id);
}
