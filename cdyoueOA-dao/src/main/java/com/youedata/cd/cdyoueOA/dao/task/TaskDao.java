package com.youedata.cd.cdyoueOA.dao.task;
import com.youedata.cd.cdyoueOA.pojo.Task;
import com.youedata.cd.cdyoueOA.pojo.TaskInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/19.
 */
public interface TaskDao {
    //添加任务
     void addTask(Task task);
     //添加任务
     public void addTaskInfo(TaskInfo task);
    //删除任务
     void delTask(Long taskId);
    //修改任务
     void updateTask(Task task);
   //修改任务
     void updateTaskInfo(TaskInfo task);
     
    //根据ID查询任务
     Task getTask(Long taskId);
    //根据计划ID查询任务
     List<Task> getTaskByPlan(Long planId);
    //查询所有任务
     List<Task> getAllTask(int uid);
    //设置报告进度为100%的任务的status=4(完成)
    void updateTaskFinish();
    //关注指定任务
    void updatetaskForFocus(Map map);
    //查看是否已关注某任务
    int findIsFocus(Map map);
    //查看此任务里是否已经有其他关注人
    int findIsOtherFocus(int taskId);
    //如果已经有其他关注人  查出关注人
    String findotherfocus(int taskId);

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
    public List<Task> findByItem(Map map);
    
    /**
     * 按条件动态查询  统计数据总数
     * @param map
     * @return
     */
    public Long findTaskDtoByItemCount(Map map);
    /**
     * 按条件动态查询(分页)
     * @param map
     * @return
     */
    public List<TaskInfo> findTaskDtoByItem(Map map);
    /**
     * 按条件动态查询  统计所有可关注任务数据总数
     * @param map
     * @return
     */
    public Long findAllTaskDtoByItemCount(Map map);
    /**
     * 按条件动态查询所有可关注任务(分页)
     * @param map
     * @return
     */
    public List<TaskInfo> findAllTaskDtoByItem(Map map);
    /**
     * 查询所有任务 汇报对象
     * */
    public List<Task> getTaskPerson(Map map);
}
