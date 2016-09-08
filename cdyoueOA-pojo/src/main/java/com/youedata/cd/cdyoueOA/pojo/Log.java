package com.youedata.cd.cdyoueOA.pojo;

import java.util.Date;

/**
 * 日志模型
 */
public class Log {
	private Long id;
	// 填写人ID
	private Long fillId;
	// 日志名称
	private String title;
	// 关注人ID
	private String focusUsers;
	// 日志内容
	private String content;
	// 开始时间
	private Date startTime;
	// 结束时间
	private Date endTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFillId() {
		return fillId;
	}

	public void setFillId(Long fillId) {
		this.fillId = fillId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
