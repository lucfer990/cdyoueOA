package com.youedata.cd.cdyoueOA.service.report;
import com.youedata.cd.cdyoueOA.pojo.Report;
import com.youedata.cd.cdyoueOA.pojo.ReportComment;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/19.
 */
public interface ReportCommentService {
    /**
     * 添加报告评阅
     * */
    public void addReportComment(ReportComment rc);
    /**
     * 更新报告评阅
     * */
    public void updateReportComment(ReportComment rc);
    /**
     * 根据ID查询报告评阅
     * */
    public ReportComment getReportComment(Long reportCommentId);
    /**
     * 按条件动态查询
     * @return
     */
    public Map findByItem(String startTime, String endTime, String reportUser,String commentStatus, int offset, int limit,int uid);

}
