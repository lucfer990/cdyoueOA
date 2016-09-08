package com.youedata.cd.cdyoueOA.dao.report;

import com.youedata.cd.cdyoueOA.pojo.Report;
import com.youedata.cd.cdyoueOA.pojo.ReportComment;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/31.
 */
public interface ReportCommentDao {
    /**
     *
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
    public List<ReportComment> findByItem(Map map);

}
