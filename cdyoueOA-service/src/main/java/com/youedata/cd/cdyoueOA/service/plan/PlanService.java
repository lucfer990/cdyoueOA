package com.youedata.cd.cdyoueOA.service.plan;

import com.youedata.cd.cdyoueOA.pojo.Plan;

import java.util.List;
import java.util.Map;

/**
 * @类名: PlanService
 * @描述: TODO 计划实现
 * @创建人: Guzhendong
 * @创建时间: 2016年9月7日 下午8:39:36
 */
public interface PlanService{

	/**
	 * @Title:
	 * @描述: 发布计划
	 * @param 
	 */
	public void releasePlanning(Long id);
    //添加计划
    public void addPlan(Plan plan);
    //删除计划
    public void delPlan(Long planId);
    //修改计划
    public void updatePlan(Plan plan);
    //根据ID查询计划
    public Plan getPlan(Long planId);
    //查询所有计划
    public List<Plan> getAllPlanByScan();
    public void updateTaskSatus(Long planId);
    /**
     * 按条件动态查询
     * @return
     */
    public Map findByItem(Integer createBy,String title,String projName,String status, String startTime, String endTime, int offset, int limit, String order);
    
    public Map findByItemAttention(String title,String projName,String status,Integer createBy,String supervisors,String startTime, String endTime, int offset, int limit, String order);
	/**
	 * 完成计划
	 * @param id 
	 * @Title:PlanService
	 * @描述:TODO
	 */
    public void finishPlan(Long id);
}
