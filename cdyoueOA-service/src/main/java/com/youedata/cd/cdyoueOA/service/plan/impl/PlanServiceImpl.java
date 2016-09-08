package com.youedata.cd.cdyoueOA.service.plan.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youedata.cd.cdyoueOA.common.date.YoueDateUtil;
import com.youedata.cd.cdyoueOA.dao.plan.PlanDao;
import com.youedata.cd.cdyoueOA.pojo.Plan;
import com.youedata.cd.cdyoueOA.service.plan.PlanService;


/**
 * @类名: PlanServiceImpl
 * @描述: TODO 计划实现
 * @创建人: Guzhendong
 * @创建时间: 2016年9月7日 下午8:39:09
 */
@Service
public class PlanServiceImpl implements PlanService{
    @Autowired
    private PlanDao plandao;

    @Override
    public void addPlan(Plan plan) {
        plandao.addPlan(plan);
    }

    @Override
    public void delPlan(Long planId) {
        plandao.delPlan(planId);
    }

    @Override
    public void updatePlan(Plan plan) {
        plandao.updatePlan(plan);

    }

    @Override
    public Plan getPlan(Long planId) {
        return plandao.getPlan(planId);
    }

    @Override
    public List<Plan> getAllPlanByScan() {
        return plandao.getAllPlanByScan();
    }

    @Override
    public Map findByItem(Integer createBy,String title,String projName,String status, String startTime, String endTime, int offset, int limit, String order) {
        List<Plan> list=null;
        java.sql.Date fromdate=null;
        java.sql.Date todate=null;
        Map resultMap=new HashMap();
        Map paramMap=new HashMap();

        paramMap.put("star",offset);
        paramMap.put("rows",limit);

        try {
            if(startTime!=null&&startTime.length()!=0){
                java.util.Date fromDate = YoueDateUtil.parseDate(startTime);
                fromdate=new java.sql.Date(fromDate.getTime());
                paramMap.put("fromdate",fromdate);
            }else{
                paramMap.put("fromdate","");
            }
            if(endTime!=null&&endTime.length()!=0){
                java.util.Date toDate = YoueDateUtil.parseDate(endTime);
                todate=new java.sql.Date(toDate.getTime());
                paramMap.put("todate",todate);
            }else{
                paramMap.put("todate","");
            }
            paramMap.put("projName",projName);
            paramMap.put("title",title);
            paramMap.put("status",status);
            paramMap.put("createBy",createBy);
            list=plandao.findByItem(paramMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("total",plandao.findByItemCount(paramMap));
        resultMap.put("rows",list);
        return resultMap;
    }

	@Override
	public void releasePlanning(Long id) {
		plandao.releasePlanning(id);
	}

	@Override
	public Map findByItemAttention(String title,String projName,String status,Integer createBy,String supervisors,String startTime, String endTime, int offset, int limit, String order) {
		List<Plan> list=null;
        java.sql.Date fromdate=null; 
        java.sql.Date todate=null;
        Map resultMap=new HashMap();
        Map paramMap=new HashMap();

        paramMap.put("star",offset);
        paramMap.put("rows",limit);

        try {
            if(startTime!=null&&startTime.length()!=0){
                java.util.Date fromDate = YoueDateUtil.parseDate(startTime);
                fromdate=new java.sql.Date(fromDate.getTime());
                paramMap.put("fromdate",fromdate);
            }else{
                paramMap.put("fromdate","");
            }
            if(endTime!=null&&endTime.length()!=0){
                java.util.Date toDate = YoueDateUtil.parseDate(endTime);
                todate=new java.sql.Date(toDate.getTime());
                paramMap.put("todate",todate);
            }else{
                paramMap.put("todate","");
            }
            paramMap.put("projName",projName);
            paramMap.put("title",title);
            paramMap.put("status",status);
            paramMap.put("createBy",createBy);
            paramMap.put("supervisors",supervisors);
            
            list=plandao.findByItemAttention(paramMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("total",plandao.findByItemCount(paramMap));
        resultMap.put("rows",list);
        return resultMap;
	}

	@Override
	public void updateTaskSatus(Long planId) {
		plandao.updateTaskSatus(planId);
		
	}

	@Override
	public void finishPlan(Long id) {
		plandao.finishPlan(id);
		
	}
}
