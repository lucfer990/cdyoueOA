package com.youedata.cd.cdyoueOA.service.report;

import com.youedata.cd.cdyoueOA.common.date.YoueDateUtil;
import com.youedata.cd.cdyoueOA.dao.report.ReportCommentDao;
import com.youedata.cd.cdyoueOA.pojo.Report;
import com.youedata.cd.cdyoueOA.pojo.ReportComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/31.
 */
@Service
public class ReportCommentServiceImpl implements ReportCommentService{
    @Autowired
    private ReportCommentDao rcd;

    @Override
    public void addReportComment(ReportComment rc) {
          rcd.addReportComment(rc);
    }

    @Override
    public void updateReportComment(ReportComment rc) {
          rcd.updateReportComment(rc);
    }

    @Override
    public ReportComment getReportComment(Long reportCommentId) {
        return rcd.getReportComment(reportCommentId);
    }

    @Override
    public Map findByItem(String startTime, String endTime, String reportUser,String commentStatus, int offset, int limit,int uid) {
        List<ReportComment> list=null;
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
            paramMap.put("reportUser",reportUser);
            paramMap.put("uid",uid);
            paramMap.put("commentStatus",commentStatus);

            list=rcd.findByItem(paramMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("total",rcd.findByItemCount(paramMap));
        resultMap.put("rows",list);
        return resultMap;
    }
}
