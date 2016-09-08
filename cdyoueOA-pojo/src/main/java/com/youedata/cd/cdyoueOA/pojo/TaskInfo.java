package com.youedata.cd.cdyoueOA.pojo;

import java.math.BigInteger;

public class TaskInfo {
	private String id;
    //对应计划ID
    private Long planId;
    //任务名称
    private String title;
    //执行人ID
    private String executorId;
    //分配人ID（一般为执行人的上级领导）
    private String assignerId;
    //关注人ID，多个以逗号隔开
    private String focusUsers;
    //任务要求
    private String content;
    //附件ID，多个附件以逗号隔开
    private String attachments;
    //紧急程度？1：紧急重要。2：紧急不重要。3：不紧急重要。4：不紧急不重要
    private String emergency;
  //发布时间
    private String pubTime;
    //任务开始时间
    private String startTime;
    //任务结束时间
    private String endTime;
    //任务移交到某人ID
    private String candidateId;
    //任务移交时间
    private String candiTime;
    //任务移交说明
    private String candiComment;
    //0：未发布。1：发布进行中。2：暂停。3：强制完成。4：废除
    private String status;
    //需要提醒？0：不需要。1：需要
    private String alert;
    //部门名称
    private String deptName;
    //计划名
    private String planName;
    //进程状态
    private String process;
    
    public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(String completeTime) {
		if(completeTime.lastIndexOf(".")!=-1){
			this.completeTime=completeTime.substring(0, completeTime.lastIndexOf("."));
			}else{
				this.completeTime = completeTime;
			}
			
		
	}
	//任务完结时间
    private String completeTime;
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	//分配人
    private  String assignerName;
    //执行人
    private  String executorName;
    
	public String getExecutorName() {
		return executorName;
	}
	public void setExecutorName(String executorName) {
		this.executorName = executorName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getExecutorId() {
		return executorId;
	}
	public void setExecutorId(String executorId) {
		this.executorId = executorId;
	}
	public String getAssignerId() {
		return assignerId;
	}
	public void setAssignerId(String assignerId) {
		this.assignerId = assignerId;
	}
	public String getFocusUsers() {
		return focusUsers;
	}
	public void setFocusUsers(String focusUsers) {
		this.focusUsers = focusUsers;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAttachments() {
		return attachments;
	}
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	public String getEmergency() {
		return emergency;
	}
	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}
	public String getPubTime() {
		return pubTime;
	}
	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		if(startTime.lastIndexOf(".")!=-1){
		this.startTime=startTime.substring(0, startTime.lastIndexOf("."));
		}else{
			this.startTime = startTime;
		}
		
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		if(endTime.lastIndexOf(".")!=-1){
			this.endTime=endTime.substring(0, endTime.lastIndexOf("."));
			}else{
				this.endTime = endTime;
				
			}
			
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getCandiTime() {
		return candiTime;
	}
	public void setCandiTime(String candiTime) {
		this.candiTime = candiTime;
	}
	public String getCandiComment() {
		return candiComment;
	}
	public void setCandiComment(String candiComment) {
		this.candiComment = candiComment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getAssignerName() {
		return assignerName;
	}
	public void setAssignerName(String assignerName) {
		this.assignerName = assignerName;
	}

}
