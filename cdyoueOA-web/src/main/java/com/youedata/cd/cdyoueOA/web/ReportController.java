package com.youedata.cd.cdyoueOA.web;

import com.youedata.cd.cdyoueOA.common.date.YoueDateUtil;
import com.youedata.cd.cdyoueOA.common.util.YoueStringUtils;
import com.youedata.cd.cdyoueOA.common.util.YouedataConstanst;
import com.youedata.cd.cdyoueOA.pojo.Report;
import com.youedata.cd.cdyoueOA.pojo.ReportComment;
import com.youedata.cd.cdyoueOA.pojo.User;
import com.youedata.cd.cdyoueOA.service.report.ReportCommentService;
import com.youedata.cd.cdyoueOA.service.report.ReportService;
import com.youedata.cd.cdyoueOA.service.task.TaskService;
import com.youedata.cd.cdyoueOA.service.user.UserService;
import com.youedata.cd.cdyoueOA.utill.AsyncResultSample;
import com.youedata.cd.cdyoueOA.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/19.
 */
@Controller
@RequestMapping("report")
public class ReportController extends BaseController {
    @Autowired
    private ReportService reportService;
    @Autowired
    private ReportCommentService reportCommentService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    /**
     * 我的报告 主页
     * */
    @RequestMapping(value = "showReport",method = RequestMethod.GET)
    public String show(){
        return "report/myReport";
    }

    /**
     * 报告评阅 主页
     * */
    @RequestMapping(value = "showComment",method = RequestMethod.GET)
    public String showComment(HttpSession session){
        User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
        session.setAttribute("user", user);
        return "report/reportComment";
    }

    /*新增报告*/
    @ResponseBody
    @RequestMapping(value="addReport",method = RequestMethod.POST)
    public AsyncResultSample addReport(String reportForTask,String taskProgress,String content,String reportObj,HttpSession session){

        Report thereport=new Report();

        if(reportForTask !=null && reportForTask!=""){
            thereport.setTaskId(reportForTask);
        }
        if(taskProgress !=null && taskProgress !=""){
            thereport.setPercent(Integer.valueOf(taskProgress));
        }
        if(content!=null && content!=""){
            thereport.setReport(content);
        }
        if(YoueStringUtils.isNotEmpty(reportObj)){

            thereport.setReportObject(reportObj);
        }
        reportService.addReport(thereport);
        //如果任务进度为100% 设置任务完成
        if(Integer.valueOf(taskProgress)==100){
            taskService.updateTaskFinish();
        }

        //新增报告后新增评阅
        ReportComment reportComment=new ReportComment();
        List<Integer> reportidList= reportService.getReportNotinComment();//查询没有加入报告评阅表中的报告的id
        User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
        for (Integer i:reportidList) {
            reportComment.setReportId(i);
            reportComment.setCommentStatus(String.valueOf(2));
            reportComment.setReportUser(String.valueOf(user.getUid()));
            reportCommentService.addReportComment(reportComment);
        }
        return new AsyncResultSample();
    }


    /*更新报告评阅*/
    @ResponseBody
    @RequestMapping(value="updateReportComment",method = RequestMethod.POST)
    public AsyncResultSample updateReportComment(String id,String reportId,String reportScore,String content){

        ReportComment reportComment=new ReportComment();
        if(id!=null && id!=""){
            reportComment.setId(Long.valueOf(id));
        }
        if(reportId!=null && reportId!=""){
            reportComment.setReportId(Integer.valueOf(reportId));
        }
        if(reportScore!=null && reportScore!=""){
            reportComment.setReportScore(Integer.valueOf(reportScore));
        }

        reportComment.setReportComment(content);
        reportCommentService.updateReportComment(reportComment);
        return new AsyncResultSample();
    }

    /**
     * 删除报告
     * */
    @ResponseBody
    @RequestMapping(value="delReport")
    public AsyncResultSample delReport(Long id){
        reportService.delReport(id);
        return new AsyncResultSample();
    }

    /**
     * 修改报告
     * */
    @ResponseBody
    @RequestMapping(value="updateReport",method = RequestMethod.POST)
    public AsyncResultSample updateReport(String id,String taskId,String percent,String report,String reportTime){
        Report thereport=new Report();
        thereport.setId(Long.valueOf(id));
        thereport.setTaskId(taskId);
        thereport.setPercent(Integer.valueOf(percent));
        thereport.setReport(report);
        try {
            java.util.Date reportDate = YoueDateUtil.parseDate(reportTime);
            thereport.setReportTime(reportDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        reportService.updateReport(thereport);
        return new AsyncResultSample();
    }

    /**
     * 根据ID查询报告
     * */
    @ResponseBody
    @RequestMapping("getReportById")
    public Report getReportById(String id,HttpSession session){
        User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
        Report re=reportService.getReport(Long.valueOf(id));
        //根据关注人ID字符串查找关注人
        List<User> listUser=new ArrayList<User>();
        StringBuffer sb=new StringBuffer();
        String userId=re.getUserId();
        if(YoueStringUtils.isNotEmpty(userId)){
           listUser=userService.findUserByUid(userId);
        }
        if(listUser.size()>0){
            for (User u:listUser) {
                if(listUser.indexOf(u)==listUser.size()-1){
                    sb.append(u.getUserName());
                }else{
                    sb.append(u.getUserName()+"，");
                }
            }
        }
        re.setUserId(sb.toString());
        if(!user.equals(null)){
            String  executorId=user.getUserId().toString();
            re.setReportUser(executorId);
        }
       return re;
    }

    /**
     * 分页查询报告
     * */
    @ResponseBody
    @RequestMapping(value = "findReport")
    public Map findByItem(String startTime,String endTime,String taskId,int offset, int limit,HttpSession session){

        User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
        int uid=user.getUid();

        return reportService.findByItem(uid,startTime,endTime,taskId,offset,limit);
    }

    /**
     * 分页查询报告评阅
     * */
    @ResponseBody
    @RequestMapping(value = "findReportComment")
    public Map findReportComment(String startTime,String endTime,String reportUser,String commentStatus,int offset, int limit,HttpSession session,String focusStatus){
        User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
        int uid=user.getUid();

        return reportCommentService.findByItem(startTime,endTime,reportUser,commentStatus,offset,limit,uid);
    }

    /**
     * 关注报告所在任务
     * */
    @ResponseBody
    @RequestMapping(value="focusTask")
    public int focusTask(HttpSession session,int taskId){
        User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
        int userid=user.getUid();
        String uid=String.valueOf(userid);
        //查看此任务关注人是否为空
        int i=taskService.findIsOtherFocus(taskId);
           if(i>0){//此任务无人关注
               taskService.updatetaskForFocus(uid,taskId);
           }else{//有人关注
               //查看是否已经关注任务
               int m=taskService.findIsFocus(uid,taskId);
               if(m>0){//已经关注任务
                 return 300;
               }
               //还没关注此任务  查出关注人，拼接字符串添加进去
               String focusUser=taskService.findotherfocus(taskId);
               uid=focusUser+","+uid;
               taskService.updatetaskForFocus(uid,taskId);
           }
        return 200;
    }
}
