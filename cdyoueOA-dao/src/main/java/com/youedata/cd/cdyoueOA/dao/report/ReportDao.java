package com.youedata.cd.cdyoueOA.dao.report;

import com.youedata.cd.cdyoueOA.pojo.Report;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/19.
 */
public interface ReportDao {
    /**
     * 添加报告
     * @param report
     * */
    public void addReport(Report report);

    /**
     * 删除报告
     * @param reportId
     * */
    public  void delReport(Long reportId);

    /**
     * 修改报告
     * @param report
     * */
    public void updateReport(Report report);

    /**
     * 根据ID查询报告
     * @param reportId
     * */
    public Report getReport(Long reportId);

    /**
     * 按条件动态查询  统计数据总数
     * @param map
     * @return
     */
    public Long findByItemCount(Map map);
    /**
     * 按条件动态查询(分页)
     * @param map
     * @return
     */
    public List<Report> findByItem(Map map);
    /**
     * 查询没有加入报告评阅表中的报告的id
     * */
    public List<Integer> getReportNotinComment();
}
