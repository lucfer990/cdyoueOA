package com.youedata.cd.cdyoueOA.pojo;

import java.util.Date;

/**
 * Created by admin on 2016/8/19.
 */
public class Report {
    private Long id;
    //关联任务ID
    private String taskId;
    //任务进度0-100，百分比
    private int percent;
    //汇报内容
    private String report;
    //汇报时间
    private Date reportTime;
    //关注人
    private String userId;
    //报告人
    private String reportUser;
    //报告对象
    private String reportObject;

    public Report() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReportUser() {
        return reportUser;
    }

    public void setReportUser(String reportUser) {
        this.reportUser = reportUser;
    }

    public String getReportObject() {
        return reportObject;
    }

    public void setReportObject(String reportObject) {
        this.reportObject = reportObject;
    }
}