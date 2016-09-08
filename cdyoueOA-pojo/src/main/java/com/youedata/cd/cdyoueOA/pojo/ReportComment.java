package com.youedata.cd.cdyoueOA.pojo;

import java.util.Date;

/**
 * 报告评阅
 */
public class ReportComment {
    private Long id;

    //报告ID
    private int reportId;

    //报告评分  1、不满意 2、一般3、满意
    private int reportScore;

    //报告评语
    private String reportComment;

    //评阅状态 1、已评阅 2、未评阅
    private String commentStatus;

    //报告人
    private String reportUser;

    //汇报时间
    private Date reportTime;

    //报告内容
    private String reportContent;

    //关注人
    private String focusUsers;

    //任务ID
    private String taskCommentId;

    public String getTaskCommentId() {
        return taskCommentId;
    }

    public void setTaskCommentId(String taskCommentId) {
        this.taskCommentId = taskCommentId;
    }

    public String getFocusUsers() {
        return focusUsers;
    }

    public void setFocusUsers(String focusUsers) {
        this.focusUsers = focusUsers;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getReportScore() {
        return reportScore;
    }

    public void setReportScore(int reportScore) {
        this.reportScore = reportScore;
    }

    public String getReportComment() {
        return reportComment;
    }

    public void setReportComment(String reportComment) {
        this.reportComment = reportComment;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getReportUser() {
        return reportUser;
    }

    public void setReportUser(String reportUser) {
        this.reportUser = reportUser;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }
}
