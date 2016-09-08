package com.youedata.cd.cdyoueOA.service.report;
import com.youedata.cd.cdyoueOA.pojo.Report;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/19.
 */
public interface ReportService {
    //添加报告
    public void addReport(Report report);
    //删除报告
    public void delReport(Long reportId);
    //修改报告
    public void updateReport(Report report);
    //根据ID查询报告
    public Report getReport(Long reportId);

    /**
     * 按条件动态查询
     * @return
     */
    public Map findByItem(int uid,String startTime,String endTime,String taskId,int offset, int limit);
    /**
     * 查询没有加入报告评阅表中的报告的id
     * */
    public List<Integer> getReportNotinComment();
}
