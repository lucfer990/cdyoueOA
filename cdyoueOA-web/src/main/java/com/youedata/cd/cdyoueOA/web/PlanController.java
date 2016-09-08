package com.youedata.cd.cdyoueOA.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.youedata.cd.base.common.date.DateTimeUtil;
import com.youedata.cd.cdyoueOA.common.date.YoueDateUtil;
import com.youedata.cd.cdyoueOA.common.deptToZtree.DeptToZtreeUtil;
import com.youedata.cd.cdyoueOA.common.util.YouedataConstanst;
import com.youedata.cd.cdyoueOA.pojo.Dept;
import com.youedata.cd.cdyoueOA.pojo.DeptTree;
import com.youedata.cd.cdyoueOA.pojo.Plan;
import com.youedata.cd.cdyoueOA.pojo.User;
import com.youedata.cd.cdyoueOA.pojo.YoueUserDto;
import com.youedata.cd.cdyoueOA.service.dept.DeptService;
import com.youedata.cd.cdyoueOA.service.plan.PlanService;
import com.youedata.cd.cdyoueOA.utill.AsyncResultSample;
import com.youedata.cd.cdyoueOA.web.base.BaseController;

/**
 * Created by admin on 2016/8/19.
 */
@Controller
@RequestMapping("plan")
public class PlanController extends BaseController {
    @Autowired
    private PlanService planService;
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "myPlan",method = RequestMethod.GET)
    public String show(){
        return "plan/myplan";
    }
    /*关注计划页面*/
    @RequestMapping(value = "attentionPlan",method = RequestMethod.GET)
    public String showAttentionPlan(){
        return "plan/attentionPlan";
    }

    /*新增计划*/
    @ResponseBody
    @RequestMapping(value="addPlan",method = RequestMethod.POST)
    public AsyncResultSample addPlan(
            String title,int isTemplate,int belongTo,String content,int type,
            String focusUsers,String startTime,String endTime,String projName,String depts,HttpSession session

    	) throws ParseException{	
        Plan plan=new Plan();
        User u = (User) session.getAttribute(YouedataConstanst.SESSION_USERKEY);
    	String createBy = u.getUid().toString();
    	//ArrayList<String> dept = new ArrayList<String>();
    	//dept.add(u.getDeptId().toString());
    	//List<YoueUserDto> selectAllUserByDeptid = deptService.selectAllUserByDeptid(dept);
    	plan.setCreateBy(createBy);
    	if(belongTo == 1){
    			plan.setProjName(projName);
    	}
    	if(belongTo == 0){
    			plan.setDepts(depts);
    	}
        plan.setBelongTo(belongTo);
        plan.setContent(content);
        plan.setTitle(title);
        plan.setFocusUsers(focusUsers);
        plan.setIsTemplate(isTemplate);
        plan.setType(type);
        plan.setStartTime(DateTimeUtil.getDateyMdHm(startTime));
        plan.setEndTime(DateTimeUtil.getDateyMdHm(endTime));

        planService.addPlan(plan);
        return new AsyncResultSample();
    }

    /**
     * 删除计划
     * */
    @ResponseBody
    @RequestMapping(value="delPlan")
    public AsyncResultSample delPlan(Long id){
        planService.delPlan(id);
        planService.updateTaskSatus(id);
        return new AsyncResultSample();
    }

    /**
     * 发布计划
     * */
    @ResponseBody
    @RequestMapping("releasePlanning")
    public Integer releasePlanning(Long id){
    	Plan plan = planService.getPlan(id);
    	if(plan.getStatus() == 4){
    		return 4;
    	}if(plan.getStatus() == 1){
    		return 1;
    	}
	    if(plan.getStatus() == 3){
	    	return 3;
	    }
    	planService.releasePlanning(id);
		return 5;
    	
    }
    /**
     * 修改计划
     * */
    @ResponseBody
    @RequestMapping("updatePlan")
    public AsyncResultSample updateReport(
            Long id,String title,int isTemplate,int belongTo,String projName,String depts,String content,String attachments,int type,
            String supervisors,String createBy,String tasks,String focusUsers,int status,String pubTime,String startTime,String endTime,int loops
    ){
        Plan plan=new Plan();
        plan.setTitle(title);
        plan.setIsTemplate(isTemplate);
        plan.setBelongTo(belongTo);
        plan.setProjName(projName);
        plan.setDepts(depts);
        plan.setContent(content);
        plan.setAttachments(attachments);
        plan.setType(type);
        plan.setSupervisors(supervisors);
        plan.setCreateBy(createBy);
        plan.setTasks(tasks);
        plan.setFocusUsers(focusUsers);
        plan.setStatus(status);
        plan.setLoops(loops);
        plan.setId(id);
        try {
            java.util.Date pubDate = YoueDateUtil.parseDate(pubTime);
            java.util.Date startDate = YoueDateUtil.parseDate(startTime);
            java.util.Date endDate = YoueDateUtil.parseDate(endTime);
            plan.setPubTime(pubDate);
            plan.setStartTime(startDate);
            plan.setEndTime(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        planService.updatePlan(plan);
        return new AsyncResultSample();
    }

    /**
     * 根据ID查询计划
     * */
    @RequestMapping("getPlanById")
    @ResponseBody
    public Plan getPlanById(String id){
        return planService.getPlan(Long.valueOf(id));
    }

    /**
     * 分页查询计划
     * */
    @ResponseBody
    @RequestMapping(value = "findPlan")
    public Map findByItem(String title,String projName,String status, 
    		String startTime, String endTime, int offset, int limit, String order,HttpSession session){    	
        Map map=new HashMap();        
        //模拟当前登录人查询所属部门
        User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
        Integer createBy = user.getUid();
        map=planService.findByItem(createBy,title,projName,status,startTime,endTime,offset,limit,order);
        return map;
    }
    /**
     * 分页查询计划 关注
     * */
    @ResponseBody
    @RequestMapping(value = "findPlanAttention")
    public Map findByItemAttention(String title,String projName,String status, String startTime,String supervisors,
    		String endTime, int offset, int limit, String order,HttpSession session){    	
    	Map map=new HashMap();
    	User u = getCurrentUser(session);
    	Integer createBy = u.getUid();
    	map=planService.findByItemAttention(title,projName,status,createBy,supervisors,startTime,endTime,offset,limit,order);
    	//模拟当前登录人查询所属部门
    	User user=(User)session.getAttribute(YouedataConstanst.SESSION_USERKEY);
    	ArrayList<String> arryList=new ArrayList<String>();
    	arryList.add(user.getDeptId().toString());
    	//根据当前登录人查询该部门成员
    	List<YoueUserDto> userList =deptService.selectAllUserByDeptid(arryList);
    	map.put("deptUsers", userList); 
    	return map;
    }
    /**
     * 树状计划关注列表
     * */
    @ResponseBody
    @RequestMapping(value="departments",method=RequestMethod.GET)
    public List departments(){    	
    	List<DeptTree> list=new ArrayList<DeptTree>();
    	List<Dept> list0=deptService.selectAllDept();
    	list=DeptToZtreeUtil.deptToTreeList(list0);
    	return list;

    }
    @ResponseBody
    @RequestMapping(value = "findDeptUsers")
    public  Map findDeptUsers(HttpSession session){
    	 Map map=new HashMap();
    	//模拟当前登录人查询所属部门
        User user=getCurrentUser(session);
        ArrayList<String> arryList=new ArrayList<String>();
        arryList.add(user.getDeptId().toString());
        //根据当前登录人查询该部门成员
        List<YoueUserDto> list=deptService.selectAllUserByDeptid(arryList);
        map.put("data", list);
        
        return map;
    }
    /**
     * @Title:PlanController
     * @描述:TODO 完成计划
     * @param id
     */
    @ResponseBody
    @RequestMapping(value = "finishPlan")
    public Integer finishPlan(Long id){
    	Plan plan = planService.getPlan(id);
    	if(plan.getStatus() == 4){
    		return 4;
    	}if(plan.getStatus() == 0){
    		return 0;
    	}
	    if(plan.getStatus() == 3){
	    	return 3;
	    }
    	planService.finishPlan(id);
		return 5;
    }
    
}
