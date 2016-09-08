package com.youedata.cd.cdyoueOA.service.report;

import com.youedata.cd.cdyoueOA.common.date.YoueDateUtil;
import com.youedata.cd.cdyoueOA.dao.report.ReportDao;
import com.youedata.cd.cdyoueOA.pojo.Plan;
import com.youedata.cd.cdyoueOA.pojo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/19.
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportDao reportdao;

    @Override
    public void addReport(Report report) {
        reportdao.addReport(report);
    }

    @Override
    public void delReport(Long reportId) {
        reportdao.delReport(reportId);
    }

    @Override
    public void updateReport(Report report) {
        reportdao.updateReport(report);
    }

    @Override
    public Report getReport(Long reportId) {
        return reportdao.getReport(reportId);
    }

    /**
     * 按条件动态查询
     * @return
     */
    @Override
    public Map findByItem(int uid,String startTime,String endTime,String taskId,int offset, int limit) {
        List<Report> list=null;
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
                paramMap.put("taskId",taskId);
                paramMap.put("uid",uid);
            list=reportdao.findByItem(paramMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("total",reportdao.findByItemCount(paramMap));
        resultMap.put("rows",list);
        return resultMap;
    }

    @Override
    public List<Integer> getReportNotinComment() {

        return reportdao.getReportNotinComment();
    }

}