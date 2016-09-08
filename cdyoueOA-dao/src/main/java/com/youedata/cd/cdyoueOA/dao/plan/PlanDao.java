package com.youedata.cd.cdyoueOA.dao.plan;

import com.youedata.cd.base.dao.IBaseDao;
import com.youedata.cd.cdyoueOA.pojo.Plan;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/19.
 */
public interface PlanDao extends IBaseDao<Plan> {

	/**
	 * @Title:UserDao
	 * @描述: 发布计划
	 * @param status 计划状态 0：未发布。1：发布进行中。2：暂停。3：已完成。4：废除
	 */
	public void releasePlanning(Long id);
    //添加计划
     void addPlan(Plan plan);
    //删除计划
     void delPlan(Long planId);
    //修改计划
     void updatePlan(Plan plan);
    //根据ID查询计划
     Plan getPlan(Long planId);
    //查询所有符合条件计划的ID
     List<Plan> getAllPlanByScan();
     /**
      * 当计划为废除时将ue_task表相关联的数据废除状态为‘0’
     * @Title:PlanDao
     * @描述:TODO
     * @param planId	
     */
    public void updateTaskSatus(Long planId);
    /**
     * 按条件动态查询  统计数据总数
     * @param map
     * @return
     */
    public Long findByItemCount(Map map);
    /**
     * 按条件动态查询(分页)
     * @param map
     * @return
     */
    public List<Plan> findByItem(Map map);
    
    /**
     * @Title:PlanDao 分页查询 按照登陆人session与条件来分页
     * @描述:TODO
     * @param map
     * @return
     */
    public List<Plan> findByItemAttention(Map map);
    /**
     * 完成计划
     * @param id 
     * @Title:PlanDao
     * @描述:TODO
     */
	public void finishPlan(Long id);
    
}
