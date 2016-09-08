package com.youedata.cd.cdyoueOA.pojo;

public class YoueUserDto {
	//用户自增id
		private Integer uId;
		//英文用户名
		private String userId;
		//用户真实姓名
		private String userName;
		//用户部门名
		private String deptName;
		public Integer getuId() {
			return uId;
		}
		public void setuId(Integer uId) {
			this.uId = uId;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getDeptName() {
			return deptName;
		}
		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}
		

}
