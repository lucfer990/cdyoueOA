package com.youedata.cd.cdyoueOA.service.task.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youedata.cd.cdyoueOA.common.date.YoueDateUtil;
import com.youedata.cd.cdyoueOA.common.util.TimeToProcessUtil;
import com.youedata.cd.cdyoueOA.common.util.YoueStringUtils;
import com.youedata.cd.cdyoueOA.dao.task.TaskDao;
import com.youedata.cd.cdyoueOA.dao.user.UserDao;
import com.youedata.cd.cdyoueOA.pojo.Task;
import com.youedata.cd.cdyoueOA.pojo.TaskInfo;
import com.youedata.cd.cdyoueOA.pojo.User;
import com.youedata.cd.cdyoueOA.service.task.TaskService;


/**
 * Created by admin on 2016/8/19.
 */
@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskDao taskdao;
    @Autowired
    private UserDao userDao;

    @Override
    public void addTask(Task task) {
    	if(YoueStringUtils.isEmpty(task.getAlert())){
    		task.setAlert("0");
    	}    	
    	task.setStatus("1");
    	String pubTime=YoueDateUtil.format(new Date());
    	task.setPubTime(pubTime);
    	if(YoueStringUtils.isEmpty(task.getStartTime())){
    		task.setStartTime(null);
    		
    	}if(YoueStringUtils.isEmpty(task.getEndTime())){
    		task.setEndTime(null);
    		
    	}
    	
        taskdao.addTask(task);
    }
    @Override
    public void addTaskInfo(TaskInfo task) {
    	if(YoueStringUtils.isEmpty(task.getAlert())){
    		task.setAlert("0");
    	}    	
    	task.setStatus("1");
    	String pubTime=YoueDateUtil.format(new Date());
    	task.setPubTime(pubTime);
    	if(YoueStringUtils.isEmpty(task.getStartTime())){
    		task.setStartTime(null);
    		
    	}if(YoueStringUtils.isEmpty(task.getEndTime())){
    		task.setEndTime(null);
    		
    	}
    	
        taskdao.addTaskInfo(task);
    }


    @Override
    public void delTask(Long taskId) {
        taskdao.delTask(taskId);
    }

    @Override
    public void updateTask(Task task) {
        taskdao.updateTask(task);

    }
    @Override
    public void updateTaskInfo(TaskInfo task) {
        taskdao.updateTaskInfo(task);

    }

    @Override
    public Task getTask(Long taskId) {
        return taskdao.getTask(taskId);
    }

    @Override
    public List<Task> getAllTask(int uid) {
        return taskdao.getAllTask(uid);
    }

    @Override
    public void updateTaskFinish() {
        taskdao.updateTaskFinish();
    }

    @Override
    public List<Task> getTaskPerson(int uid,int taskid) {
        Map map=new HashMap();
        map.put("uid",uid);
        map.put("taskid",taskid);

        return taskdao.getTaskPerson(map);
    }

    @Override
    public void updatetaskForFocus(String uid, int taskId) {
        Map map=new HashMap();
        map.put("uid",uid);
        map.put("taskId",taskId);
        taskdao.updatetaskForFocus(map);
    }

    @Override
    public int findIsFocus(String uid, int taskId) {
        Map map=new HashMap();
        map.put("uid",uid);
        map.put("taskId",taskId);
        return taskdao.findIsFocus(map);
    }

    @Override
    public int findIsOtherFocus(int taskId) {
        return taskdao.findIsOtherFocus(taskId);
    }

    @Override
    public String findotherfocus(int taskId) {
        return taskdao.findotherfocus(taskId);
    }

    @Override
    public Map findByItem(String title, String startTime, String endTime, String page, String rows,int status) {
        List<Task> list=null;
        java.sql.Date fromdate=null;
        java.sql.Date todate=null;
        Map resultMap=new HashMap();
        Map paramMap=new HashMap();
        Long currentPage=Long.parseLong(page);//当前页码
        int row=Integer.parseInt(rows);//每页显示多少条
        Long star=(currentPage-1)*row;//起始条数

        paramMap.put("star",star);
        paramMap.put("rows",row);

        try {
            if(startTime!=null&&startTime.length()!=0){
                java.util.Date fromDate = YoueDateUtil.parseDate(startTime);
                fromdate=new java.sql.Date(fromDate.getTime());
                paramMap.put("fromdate",fromdate);
            }
            if(endTime!=null&&endTime.length()!=0){
                java.util.Date toDate = YoueDateUtil.parseDate(endTime);
                todate=new java.sql.Date(toDate.getTime());
                paramMap.put("todate",todate);
            }
            paramMap.put("title",title);
            paramMap.put("status",status);
            list=taskdao.findByItem(paramMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("total",taskdao.findByItemCount(paramMap));
        resultMap.put("rows",list);
        return resultMap;
    }
    
    public Map findTaskDtoByItem(String title, String startTime, String endTime, String page, String rows,String status,String  alert ,String executorId,String assignerId,String focusId ){
       List<TaskInfo> list=null;
    	  	
    	Map resultMap=new HashMap();
    	Map paramMap=new HashMap();    	
    	Long currentPage=Long.parseLong(page);//当前页码
    	int row=Integer.parseInt(rows);//每页显示多少条
        //Long star=(currentPage-1)*row;//起始条数
        paramMap.put("star",page);
        paramMap.put("rows",row);        
        try{
        if(YoueStringUtils.isNotEmpty(startTime)){
        	paramMap.put("fromdate",startTime);        	        	
        }
        if(YoueStringUtils.isNotEmpty(endTime)){
        	paramMap.put("todate",endTime);         	
        }
        paramMap.put("title",title);
        paramMap.put("status",status); 
        paramMap.put("alert",alert); 
        if(YoueStringUtils.isNotEmpty(executorId)){
        	Map map=new HashMap();
        	map.put("USER_ID", executorId);  
        	 User user=userDao.findUserByUserTypeAndPswd(map);//查询当前登录人所在部门   
             Integer  deptId=user.getDeptId();
             //paramMap.put("deptId",deptId);
             paramMap.put("executorId",user.getUid());
        }
        if(YoueStringUtils.isNotEmpty(assignerId)){
        	Map map=new HashMap();
        	map.put("USER_ID", assignerId);  
        	 User user=userDao.findUserByUserTypeAndPswd(map);//查询当前登录人所在部门   
        	 Integer uid=user.getUid();
            // Integer  deptId=user.getDeptId();
             //paramMap.put("deptId",deptId);        	
        	paramMap.put("assignerId",uid);       	        	
        }
        if(YoueStringUtils.isNotEmpty(focusId)){	
        	paramMap.put("focusId",focusId);       	        	
        }             
        list=taskdao.findTaskDtoByItem(paramMap); 
        for(TaskInfo l:list){
        	if("1".equals(l.getStatus())){
        		l.setCompleteTime(YoueDateUtil.format(new Date()));
        	}
        	if("3".equals(l.getStatus())){
        		System.out.println(l.getPlanName());
        		System.out.println(l.getCandiTime());
        		if(null!=l.getCandiTime()){
        			l.setCompleteTime(l.getCandiTime());
        		}
        		
        		
        	}
        	String process=TimeToProcessUtil.timeAndStatusToprocess(l.getStatus(), l.getCompleteTime(), l.getStartTime(), l.getEndTime());
        	l.setProcess(process);   
        	System.out.println(process);
        }
        
        }catch (Exception e){
            e.printStackTrace();
        }         
        resultMap.put("total",taskdao.findTaskDtoByItemCount(paramMap));       
        resultMap.put("rows",list);
        return resultMap;
    }	

	@Override
	public Map findAllTaskDtoByItem(String title,
			String startTime, String endTime, String page, String rows,
			int status) {
		List<TaskInfo> list=null;    	  	
    	Map resultMap=new HashMap();
    	Map paramMap=new HashMap();    	
    	Long currentPage=Long.parseLong(page);//当前页码
    	int row=Integer.parseInt(rows);//每页显示多少条
        //Long star=(currentPage-1)*row;//起始条数
        paramMap.put("star",page);
        paramMap.put("rows",row);        
        try{
        if(YoueStringUtils.isNotEmpty(startTime)){
        	paramMap.put("fromdate",startTime);        	        	
        }
        if(YoueStringUtils.isNotEmpty(endTime)){
        	paramMap.put("todate",endTime);         	
        }
        paramMap.put("title",title);
        paramMap.put("status",status);        
        list=taskdao.findAllTaskDtoByItem(paramMap);        
        for(TaskInfo l:list){
        	if(l.getStatus()=="1"){
        		l.setCompleteTime(YoueDateUtil.format(new Date()));
        	}
        	String process=TimeToProcessUtil.timeAndStatusToprocess(l.getStatus(), l.getCompleteTime(), l.getStartTime(), l.getEndTime());
        	l.setProcess(process);   
        	System.out.println(process);
        }
        }catch (Exception e){
            e.printStackTrace();
        }         
        resultMap.put("total",taskdao.findAllTaskDtoByItemCount(paramMap));
        resultMap.put("rows",list);
        return resultMap;		
	}
}
