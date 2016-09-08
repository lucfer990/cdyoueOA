package com.youedata.cd.cdyoueOA.utill;

import com.youedata.cd.cdyoueOA.dao.plan.PlanDao;
import com.youedata.cd.cdyoueOA.dao.task.TaskDao;
import com.youedata.cd.cdyoueOA.pojo.Plan;
import com.youedata.cd.cdyoueOA.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2016/8/26.
 * 定时任务管理工具类
 */
@Component("youejob")
public class QuartzUtills {
        @Autowired
        private TaskDao taskdao;
        @Autowired
        private PlanDao planDao;

       /**
        * 为每人定时添加固定任务
        * */
        public AsyncResultSample addTask(Task task) {
            /*Task t=new Task();
            t.setPlanId(13L);
            t.setTitle("每日必做");
            t.setExecutorId(64L);
            t.setAssignerId(1L);
            t.setContent("奖励丰厚");
            t.setAttachments("001,34");
            t.setEmergency(3);
            t.setStatus(0);
            t.setAlert(0);
            t.setStartTime(new Date());
            t.setPubTime(new Date());*/
/*            task.setStartTime(new Date());
            task.setPubTime(new Date());*/
            taskdao.addTask(task);
            return new AsyncResultSample();
        }

        /**
         * 定时扫描计划表 loop_值非0或null的计划，并在开始结束时间段执行
         * */
        public AsyncResultSample scanPlan(){
           List<Plan> listPlan= planDao.getAllPlanByScan();
           //执行相应计划下的任务
            if(listPlan.size()>0){
                for (Plan plan:listPlan) {
                    /*if(listPlan.lastIndexOf(plan)+1==listPlan.size()){
                        sb.append(plan.getId());
                    }else {
                        sb.append(plan.getId()+",");
                    }*/
                    System.out.println("loop:"+plan.getLoops()+"====="+plan.getTitle());
                    if(plan.getLoops()==1){//日计划
                        List<Task> taskList=taskdao.getTaskByPlan(plan.getId());
                        for (Task task:taskList) {
                            System.out.println("扫描到的符合条件的日计划："+plan.getTitle()+"====任务："+task.getTitle());
                            everyDayPlan();
                        }
                    }else if(plan.getLoops()==2){//周计划
                        List<Task> taskList=taskdao.getTaskByPlan(plan.getId());
                        for (Task task:taskList) {
                            System.out.println("扫描到的符合条件的周计划："+plan.getTitle()+"====任务："+task.getTitle());
                            everyWeekPlan();
                        }
                    }else if(plan.getLoops()==3){//月计划
                        List<Task> taskList=taskdao.getTaskByPlan(plan.getId());
                        for (Task task:taskList) {
                            System.out.println("扫描到的符合条件的月计划："+plan.getTitle()+"====任务："+task.getTitle());
                            everyMonthPlan();
                        }
                    }else if(plan.getLoops()==4){//季度计划
                        List<Task> taskList=taskdao.getTaskByPlan(plan.getId());
                        for (Task task:taskList) {
                            System.out.println("扫描到的符合条件的季度计划："+plan.getTitle()+"====任务："+task.getTitle());
                            every3MonthPlan();
                        }
                    }


                }

            }

            return new AsyncResultSample();
        }

    /**
         * 日计划(每日执行的任务)
         * */
   public AsyncResultSample everyDayPlan(){


       System.out.println("日计划已执行。。。。。");
       return new AsyncResultSample();
    }
    /**
     * 周计划(每周执行的任务)
     * */
    public AsyncResultSample everyWeekPlan(){


        System.out.println("周计划已执行。。。。。");
        return new AsyncResultSample();
    }
    /**
     * 月计划(每月执行的任务)
     * */
    public AsyncResultSample everyMonthPlan(){


        System.out.println("月计划已执行。。。。。");
        return new AsyncResultSample();
    }
    /**
     * 季度计划(每季度执行的任务)
     * */
    public AsyncResultSample every3MonthPlan(){


        System.out.println("季度计划已执行。。。。。");
        return new AsyncResultSample();
    }


}
