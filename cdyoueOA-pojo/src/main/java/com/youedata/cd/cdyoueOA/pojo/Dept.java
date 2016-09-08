package com.youedata.cd.cdyoueOA.pojo;

public class Dept {
	//部门Id
	private Integer deptId;
	//部门名
	private String  deptName;
    //部门电话
	private String  telNo;
	//部门传真
	private String  faxNo;
	//部门地址
	private String deptAddress;
	//部门序号
	private  String deptNo;
	//上级部门
	private Integer deptParent;
	//部门主管
	private String  manager;
	//部门助理
	private String   assistantId;
	//上级主管领导
	private String  leader1;
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	public String getDeptAddress() {
		return deptAddress;
	}
	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public Integer getDeptParent() {
		return deptParent;
	}
	public void setDeptParent(Integer deptParent) {
		this.deptParent = deptParent;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getAssistantId() {
		return assistantId;
	}
	public void setAssistantId(String assistantId) {
		this.assistantId = assistantId;
	}
	public String getLeader1() {
		return leader1;
	}
	public void setLeader1(String leader1) {
		this.leader1 = leader1;
	}
	public String getLeader2() {
		return leader2;
	}
	public void setLeader2(String leader2) {
		this.leader2 = leader2;
	}
	public String getDeptFunc() {
		return deptFunc;
	}
	public void setDeptFunc(String deptFunc) {
		this.deptFunc = deptFunc;
	}
	public String getIsOrg() {
		return isOrg;
	}
	public void setIsOrg(String isOrg) {
		this.isOrg = isOrg;
	}
	public String getOrgAdmin() {
		return orgAdmin;
	}
	public void setOrgAdmin(String orgAdmin) {
		this.orgAdmin = orgAdmin;
	}
	public String getDeptEmailAuditsIds() {
		return deptEmailAuditsIds;
	}
	public void setDeptEmailAuditsIds(String deptEmailAuditsIds) {
		this.deptEmailAuditsIds = deptEmailAuditsIds;
	}
	//上级分管领导
    private String  leader2;
    //部门职能
    private String  deptFunc;
    //是否是分支机构
    private String   isOrg;
    //机构管理员
    private String   orgAdmin;
    //保密邮件审核人
    private String   deptEmailAuditsIds;
    
    
	
	

}
