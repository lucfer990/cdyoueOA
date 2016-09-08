package com.youedata.cd.cdyoueOA.web;

import com.youedata.cd.cdyoueOA.common.date.YoueDateUtil;
import com.youedata.cd.cdyoueOA.common.util.YoueStringUtils;
import com.youedata.cd.cdyoueOA.common.util.YouedataConstanst;
import com.youedata.cd.cdyoueOA.pojo.Task;
import com.youedata.cd.cdyoueOA.pojo.TaskInfo;
import com.youedata.cd.cdyoueOA.pojo.User;
import com.youedata.cd.cdyoueOA.service.task.TaskService;
import com.youedata.cd.cdyoueOA.utill.AsyncResultSample;
import com.youedata.cd.cdyoueOA.web.base.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/19.
 */
@Controller
@RequestMapping("task")
public class TaskController extends BaseController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "showTask",method = RequestMethod.GET)
    public String show(){
        return "*.jsp";
    }

  
    @ResponseBody
    @RequestMapping(value="addTask",method = RequestMethod.POST)
    public Map addTask(Task td,HttpSession session){
    	User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
        	Map map =new HashMap<String, Object>();
        	td.setAssignerId(user.getUid().toString());
        	try{
        		taskService.addTask(td);
        		map.put("msg", "分配成功！");
        	}catch(Exception e){
        		e.printStackTrace(); 
        		map.put("msg", "系统错误！");
        	}
                        
            return map;
        }

    /**
     * 删除任务
     * */
    @ResponseBody
    @RequestMapping(value="delTask")
    public AsyncResultSample delTask(Long id){
        taskService.delTask(id);
        return new AsyncResultSample();
    }

    /**
     * 修改任务
     * */
    @ResponseBody
    @RequestMapping("updateTask")
    public AsyncResultSample updateTask(
           Task task
    ){
       
        
        taskService.updateTask(task);
        return new AsyncResultSample();
    }

    /**
     * 根据ID查询任务
     * */
    @RequestMapping("getTaskById")
    public Task getReportById(String id){
        return taskService.getTask(Long.valueOf(id));
    }
    /**
     * 个人任务
     * @return
     */
    @RequestMapping(value = "myTask",method = RequestMethod.GET)
    public String myTask(){
        return "task/mytask";
    }    
   
    /**
     * 所有可关注任务
     * @return
     */
    @RequestMapping(value = "focusTask",method = RequestMethod.GET)
    public String focusTask(){
        return "task/focustask";
    }
    /**
     * 任务监督
     * @return
     */
    @RequestMapping(value = "checkTask",method = RequestMethod.GET)
    public String checkTask(){
        return "task/checktask";
    }
    /**
     * 当前登录人任务
     * */
    @ResponseBody
    @RequestMapping(value = "findTask")
    public Map findByItem(String title, String startTime, String endTime, String offset ,String alert, String limit,String status,HttpSession session){
    	User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
    	String  executorId=user.getUserId().toString();   
    	System.out.println(alert);
        return taskService.findTaskDtoByItem(title, startTime, endTime, offset, limit, status,alert, executorId,null,null);
    }
    /**
     * 分页查询所有可关注任务
     * */
    @ResponseBody
    @RequestMapping(value = "findfocusTask")
    public Map findfocusTaskByItem(String title, String startTime, String endTime, String offset , String limit,String status,String alert,HttpSession session){
    	User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
    	System.out.println(status);
    	String  focusId=user.getUid().toString();
        return taskService.findTaskDtoByItem(title, startTime, endTime, offset, limit, status,alert, null, null,focusId);
    }
    /**
     * 任务分配人可监督任务
     * */
    @ResponseBody
    @RequestMapping(value = "findCheckTask")
    public Map findCheckTask(String title, String startTime, String endTime, String offset , String limit,String status,String alert,HttpSession session){
    	User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
    	String  assignerId=user.getUserId().toString();
        return taskService.findTaskDtoByItem(title, startTime, endTime, offset, limit, status,alert, null,assignerId,null);
    }
    /**
     * 任务拆分
     * */
    @ResponseBody
    @RequestMapping(value = "resolveTask")
    public Map resolveTask(TaskInfo task,HttpSession session,Long taskId){
    	Task task0=  taskService.getTask(taskId);
    	Map map =new HashMap<String, Object>();    	
    	task.setAssignerId(task0.getExecutorId());
    	try{
    		taskService.addTaskInfo(task);
    		map.put("msg", "分配成功！");
    	}catch(Exception e){
    		e.printStackTrace(); 
    		map.put("msg", "系统错误！");
    	}
                    
        return map;
    }
    /**
     * 任务移交
     * */
    @ResponseBody
    @RequestMapping(value = "moveTask")
    public Map moveTask(TaskInfo task,HttpSession session,Long taskId){    	
    	Task task0=taskService.getTask(taskId);  //查詢移交任務人的任務
    	Map map =new HashMap<String, Object>();    	
    	task.setAssignerId(task0.getAssignerId());    	  	 
    	try{
    		task0.setStatus("3");
    		task0.setCandiComment(task.getCandiComment());
    		task0.setCandiTime(YoueDateUtil.format(new Date()));    		
    		task.setCandiTime(YoueDateUtil.format(new Date()));
    		task.setCandidateId(task0.getExecutorId());
    		taskService.addTaskInfo(task);    		
    		task0.setCandidateId(task.getId());
    		taskService.updateTask(task0);
    		
    		
    		map.put("msg", "移交成功！");
    	}catch(Exception e){
    		e.printStackTrace(); 
    		map.put("msg", "系统错误！");
    	}
                    
        return map;
    }
    /**
     * 更新提醒状态
     * */
    @ResponseBody
    @RequestMapping(value = "updateTaskIsCheck",method = RequestMethod.GET)
    public Map updateTaskIsCheck(Long id){    	
    	Map map =new HashMap<String, Object>();  
    	try{
    		Task task0=taskService.getTask(id);  //查询任务id;
    		task0.setAlert("0");
        	taskService.updateTask(task0);
        	map.put("msg", "sucess");
    	}catch(Exception e){
    		map.put("msg", "系统异常！");
    		
    	}
                 
        return map;
    }
    

    /**
     * 获取所有任务
     * */
    @ResponseBody
    @RequestMapping(value="findAllTask")
    public List<Task> findAllTask(HttpSession session){
        User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
        return taskService.getAllTask(user.getUid());
    }
    /**
     * 获取所有任务的分配人(报告对象)
     * */
    @ResponseBody
    @RequestMapping(value="getTaskPerson")
    public List<Task> getTaskPerson(HttpSession session,int taskid){
        User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
        List<Task> list=taskService.getTaskPerson(user.getUid(),taskid);

        return list;
    }

}
