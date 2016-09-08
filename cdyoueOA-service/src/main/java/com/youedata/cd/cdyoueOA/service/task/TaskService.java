package com.youedata.cd.cdyoueOA.service.task;
import com.youedata.cd.cdyoueOA.pojo.Task;
import com.youedata.cd.cdyoueOA.pojo.TaskInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/19.
 */
public interface TaskService {
    //添加任务
    public void addTask(Task task);
    //添加任务
    public void addTaskInfo(TaskInfo task);    
    //删除任务
    public void delTask(Long taskId);
    //修改任务
    public void updateTask(Task task);
    //修改任务
    public void updateTaskInfo(TaskInfo task);
    //根据ID查询任务
    public Task getTask(Long taskId);
    //查询所有任务
    public List<Task> getAllTask(int uid);
    //设置报告进度为100%的任务的status=4(完成)
    public void updateTaskFinish();
    //查询所有任务 汇报对象
    public List<Task> getTaskPerson(int uid,int taskid);
    //关注指定任务
    public void updatetaskForFocus(String uid,int taskId);
    //查看是否已关注某任务
    public int findIsFocus(String uid,int taskId);
    //查看此任务里是否已经有其他关注人
    public int findIsOtherFocus(int taskId);
    //如果已经有其他关注人  查出关注人
    public String findotherfocus(int taskId);

    /**
     * 按条件动态查询
     * @return
     */
    public Map findByItem(String title, String startTime, String endTime, String page, String rows,int status);
    /**
     * 按条件动态查询
     * @param title
     * @param startTime
     * @param endTime
     * @param page
     * @param rows
     * @param status
     * @param executorId
     * @return
     */
    
    public Map findTaskDtoByItem(String title, String startTime, String endTime, String page, String rows,String status,String alert,String executorId,String assignerId,String focusId);   
    /**
     * 按条件动态查询所有可关注任务(分页)
     * @param map
     * @return
     */
    public Map findAllTaskDtoByItem(String title,
			String startTime, String endTime, String page, String rows,
			int status);

}
