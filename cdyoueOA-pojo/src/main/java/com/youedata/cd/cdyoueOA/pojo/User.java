package com.youedata.cd.cdyoueOA.pojo;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{
    /**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 5816154600118045138L;

	/**
     *   唯一自增ID
     * Column: user.UID
    @mbggenerated 2016-08-24 11:34:47
     */
    private Integer uid;

    /**
     *   用户名
     * Column: user.USER_ID
    @mbggenerated 2016-08-24 11:34:47
     */
    private String userId;

    /**
     *   用户真实姓名
     * Column: user.USER_NAME
    @mbggenerated 2016-08-24 11:34:47
     */
    private String userName;

    /**
     *   用户姓名索引
     * Column: user.USER_NAME_INDEX
    @mbggenerated 2016-08-24 11:34:47
     */
    private String userNameIndex;

    /**
     *   别名
     * Column: user.BYNAME
    @mbggenerated 2016-08-24 11:34:47
     */
    private String byname;

    /**
     *   使用USB KEY登录
     * Column: user.USEING_KEY
    @mbggenerated 2016-08-24 11:34:47
     */
    private String useingKey;

    /**
     *   使用指纹验证
     * Column: user.USING_FINGER
    @mbggenerated 2016-08-24 11:34:47
     */
    private String usingFinger;

    /**
     *   用户密码
     * Column: user.PASSWORD
    @mbggenerated 2016-08-24 11:34:47
     */
    private String password;

    /**
     *   绑定USB Key序列号
     * Column: user.KEY_SN
    @mbggenerated 2016-08-24 11:34:47
     */
    private String keySn;

    /**
     *   动态密码卡号
     * Column: user.SECURE_KEY_SN
    @mbggenerated 2016-08-24 11:34:47
     */
    private String secureKeySn;

    /**
     *   角色编号
     * Column: user.USER_PRIV
    @mbggenerated 2016-08-24 11:34:47
     */
    private Integer userPriv;

    /**
     *   角色排序号
     * Column: user.USER_PRIV_NO
    @mbggenerated 2016-08-24 11:34:47
     */
    private Short userPrivNo;

    /**
     *   角色名称
     * Column: user.USER_PRIV_NAME
    @mbggenerated 2016-08-24 11:34:47
     */
    private String userPrivName;

    /**
     *   管理范围
     * Column: user.POST_PRIV
    @mbggenerated 2016-08-24 11:34:47
     */
    private String postPriv;

    /**
     *   管理范围指定部门
     * Column: user.POST_DEPT
    @mbggenerated 2016-08-24 11:34:47
     */
    private String postDept;

    /**
     *   部门ID
     * Column: user.DEPT_ID
    @mbggenerated 2016-08-24 11:34:47
     */
    private Integer deptId;

    /**
     *   辅助部门
     * Column: user.DEPT_ID_OTHER
    @mbggenerated 2016-08-24 11:34:47
     */
    private String deptIdOther;

    /**
     *   性别
     * Column: user.SEX
    @mbggenerated 2016-08-24 11:34:47
     */
    private String sex;

    /**
     *   生日
     * Column: user.BIRTHDAY
    @mbggenerated 2016-08-24 11:34:47
     */
    private Date birthday;

    /**
     *   是否农历(1-是,0-否)
     * Column: user.IS_LUNAR
    @mbggenerated 2016-08-24 11:34:47
     */
    private String isLunar;

    /**
     *   工作电话
     * Column: user.TEL_NO_DEPT
    @mbggenerated 2016-08-24 11:34:47
     */
    private String telNoDept;

    /**
     *   工作传真
     * Column: user.FAX_NO_DEPT
    @mbggenerated 2016-08-24 11:34:47
     */
    private String faxNoDept;

    /**
     *   家庭住址
     * Column: user.ADD_HOME
    @mbggenerated 2016-08-24 11:34:47
     */
    private String addHome;

    /**
     *   家庭邮编
     * Column: user.POST_NO_HOME
    @mbggenerated 2016-08-24 11:34:47
     */
    private String postNoHome;

    /**
     *   家庭电话
     * Column: user.TEL_NO_HOME
    @mbggenerated 2016-08-24 11:34:47
     */
    private String telNoHome;

    /**
     *   手机号
     * Column: user.MOBIL_NO
    @mbggenerated 2016-08-24 11:34:47
     */
    private String mobilNo;

    /**
     *   BP机号
     * Column: user.BP_NO
    @mbggenerated 2016-08-24 11:34:47
     */
    private String bpNo;

    /**
     *   电子邮件地址
     * Column: user.EMAIL
    @mbggenerated 2016-08-24 11:34:47
     */
    private String email;

    /**
     *   QQ号码
     * Column: user.OICQ_NO
    @mbggenerated 2016-08-24 11:34:47
     */
    private String oicqNo;

    /**
     *   ICQ号码
     * Column: user.ICQ_NO
    @mbggenerated 2016-08-24 11:34:47
     */
    private String icqNo;

    /**
     *   MSN号码
     * Column: user.MSN
    @mbggenerated 2016-08-24 11:34:47
     */
    private String msn;

    /**
     *   自定义小头像
     * Column: user.AVATAR
    @mbggenerated 2016-08-24 11:34:47
     */
    private String avatar;

    /**
     *   短信提示音
     * Column: user.CALL_SOUND
    @mbggenerated 2016-08-24 11:34:47
     */
    private String callSound;

    /**
     *   上次访问系统的时间
     * Column: user.LAST_VISIT_TIME
    @mbggenerated 2016-08-24 11:34:47
     */
    private Date lastVisitTime;

    /**
     *   短信提醒窗口弹出方式(1-自动,0-手动)
     * Column: user.SMS_ON
    @mbggenerated 2016-08-24 11:34:47
     */
    private String smsOn;

    /**
     *   登录模式(1-在本窗口打开OA,2-在新窗口打开OA显示工具栏,3-在新窗口打开)
     * Column: user.MENU_TYPE
    @mbggenerated 2016-08-24 11:34:47
     */
    private String menuType;

    /**
     *   上次修改密码的时间
     * Column: user.LAST_PASS_TIME
    @mbggenerated 2016-08-24 11:34:47
     */
    private Date lastPassTime;

    /**
     *   界面主题
     * Column: user.THEME
    @mbggenerated 2016-08-24 11:34:47
     */
    private Byte theme;

    /**
     *   快捷菜单ID串
     * Column: user.SHORTCUT
    @mbggenerated 2016-08-24 11:34:47
     */
    private String shortcut;

    /**
     *   门户ID串
     * Column: user.PORTAL
    @mbggenerated 2016-08-24 11:34:47
     */
    private String portal;

    /**
     *   登录后显示的左侧面板(1-导航,2-组织,3-短信,4-搜索)
     * Column: user.PANEL
    @mbggenerated 2016-08-24 11:34:47
     */
    private String panel;

    /**
     *   在线时长
     * Column: user.ONLINE
    @mbggenerated 2016-08-24 11:34:47
     */
    private Integer online;

    /**
     *   记录在线状态(1-联机,2-忙碌,3-离开)
     * Column: user.ON_STATUS
    @mbggenerated 2016-08-24 11:34:47
     */
    private String onStatus;

    /**
     *   岗位状态(1-出差,2-请假,3-外出)
     * Column: user.ATTEND_STATUS
    @mbggenerated 2016-08-24 11:34:47
     */
    private String attendStatus;

    /**
     *   手机号码是否公开(0-公开,1-不公开)
     * Column: user.MOBIL_NO_HIDDEN
    @mbggenerated 2016-08-24 11:34:47
     */
    private String mobilNoHidden;

    /**
     *   左侧的桌面模块
     * Column: user.MYTABLE_LEFT
    @mbggenerated 2016-08-24 11:34:47
     */
    private String mytableLeft;

    /**
     *   右侧的桌面模块
     * Column: user.MYTABLE_RIGHT
    @mbggenerated 2016-08-24 11:34:47
     */
    private String mytableRight;

    /**
     *   辅助角色编码串
     * Column: user.USER_PRIV_OTHER
    @mbggenerated 2016-08-24 11:34:47
     */
    private String userPrivOther;

    /**
     *   用户排序号
     * Column: user.USER_NO
    @mbggenerated 2016-08-24 11:34:47
     */
    private Short userNo;

    /**
     *   禁止登录OA系统(1-禁止,0-不禁止)
     * Column: user.NOT_LOGIN
    @mbggenerated 2016-08-24 11:34:47
     */
    private String notLogin;

    /**
     *   禁止查看用户列表(1-禁止,0-不禁止)
     * Column: user.NOT_VIEW_USER
    @mbggenerated 2016-08-24 11:34:47
     */
    private String notViewUser;

    /**
     *   禁止显示桌面(1-禁止,0-不禁止)
     * Column: user.NOT_VIEW_TABLE
    @mbggenerated 2016-08-24 11:34:47
     */
    private String notViewTable;

    /**
     *   禁止OA搜索(1-禁止,0-不禁止)
     * Column: user.NOT_SEARCH
    @mbggenerated 2016-08-24 11:34:47
     */
    private String notSearch;

    /**
     *   桌面背景图片
     * Column: user.BKGROUND
    @mbggenerated 2016-08-24 11:34:47
     */
    private String bkground;

    /**
     *   绑定IP地址
     * Column: user.BIND_IP
    @mbggenerated 2016-08-24 11:34:47
     */
    private String bindIp;

    /**
     *   上次访问系统的IP
     * Column: user.LAST_VISIT_IP
    @mbggenerated 2016-08-24 11:34:47
     */
    private String lastVisitIp;

    /**
     *   菜单图标(0-每个菜单使用不同图标,1-不显示菜单图标)
     * Column: user.MENU_IMAGE
    @mbggenerated 2016-08-24 11:34:47
     */
    private String menuImage;

    /**
     * Column: user.WEATHER_CITY
    @mbggenerated 2016-08-24 11:34:47
     */
    private String weatherCity;

    /**
     *   是否显示今日资讯(1-显示,0-不显示)
     * Column: user.SHOW_RSS
    @mbggenerated 2016-08-24 11:34:47
     */
    private String showRss;

    /**
     *   默认展开菜单
     * Column: user.MENU_EXPAND
    @mbggenerated 2016-08-24 11:34:47
     */
    private String menuExpand;

    /**
     *   个性签名
     * Column: user.MY_STATUS
    @mbggenerated 2016-08-24 11:34:47
     */
    private String myStatus;

    /**
     *   登录次数限制
     * Column: user.LIMIT_LOGIN
    @mbggenerated 2016-08-24 11:34:47
     */
    private String limitLogin;

    /**
     *   用户名片图片
     * Column: user.PHOTO
    @mbggenerated 2016-08-24 11:34:47
     */
    private String photo;

    /**
     *   即时通讯使用权限(1-允许使用,2-禁止使用)
     * Column: user.IM_RANGE
    @mbggenerated 2016-08-24 11:34:47
     */
    private Byte imRange;

    /**
     *   早退时间
     * Column: user.LEAVE_TIME
    @mbggenerated 2016-08-24 11:34:47
     */
    private Date leaveTime;

    /**
     *   邮件密级类型(1-非涉密,2-秘密[一般],3-机密[重要],4-绝密[非常重要])
     * Column: user.SECRET_LEVEL
    @mbggenerated 2016-08-24 11:34:47
     */
    private Integer secretLevel;

    /**
     *   禁止登录OA系统手机客户端(1-禁止,0-不禁止)
     * Column: user.NOT_MOBILE_LOGIN
    @mbggenerated 2016-08-24 11:34:47
     */
    private String notMobileLogin;

	/**
	 * @return uid
	 */
	public Integer getUid() {
		return uid;
	}

	/**
	 * @param uid 要设置的 uid
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId 要设置的 userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName 要设置的 userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return userNameIndex
	 */
	public String getUserNameIndex() {
		return userNameIndex;
	}

	/**
	 * @param userNameIndex 要设置的 userNameIndex
	 */
	public void setUserNameIndex(String userNameIndex) {
		this.userNameIndex = userNameIndex;
	}

	/**
	 * @return byname
	 */
	public String getByname() {
		return byname;
	}

	/**
	 * @param byname 要设置的 byname
	 */
	public void setByname(String byname) {
		this.byname = byname;
	}

	/**
	 * @return useingKey
	 */
	public String getUseingKey() {
		return useingKey;
	}

	/**
	 * @param useingKey 要设置的 useingKey
	 */
	public void setUseingKey(String useingKey) {
		this.useingKey = useingKey;
	}

	/**
	 * @return usingFinger
	 */
	public String getUsingFinger() {
		return usingFinger;
	}

	/**
	 * @param usingFinger 要设置的 usingFinger
	 */
	public void setUsingFinger(String usingFinger) {
		this.usingFinger = usingFinger;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password 要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return keySn
	 */
	public String getKeySn() {
		return keySn;
	}

	/**
	 * @param keySn 要设置的 keySn
	 */
	public void setKeySn(String keySn) {
		this.keySn = keySn;
	}

	/**
	 * @return secureKeySn
	 */
	public String getSecureKeySn() {
		return secureKeySn;
	}

	/**
	 * @param secureKeySn 要设置的 secureKeySn
	 */
	public void setSecureKeySn(String secureKeySn) {
		this.secureKeySn = secureKeySn;
	}

	/**
	 * @return userPriv
	 */
	public Integer getUserPriv() {
		return userPriv;
	}

	/**
	 * @param userPriv 要设置的 userPriv
	 */
	public void setUserPriv(Integer userPriv) {
		this.userPriv = userPriv;
	}

	/**
	 * @return userPrivNo
	 */
	public Short getUserPrivNo() {
		return userPrivNo;
	}

	/**
	 * @param userPrivNo 要设置的 userPrivNo
	 */
	public void setUserPrivNo(Short userPrivNo) {
		this.userPrivNo = userPrivNo;
	}

	/**
	 * @return userPrivName
	 */
	public String getUserPrivName() {
		return userPrivName;
	}

	/**
	 * @param userPrivName 要设置的 userPrivName
	 */
	public void setUserPrivName(String userPrivName) {
		this.userPrivName = userPrivName;
	}

	/**
	 * @return postPriv
	 */
	public String getPostPriv() {
		return postPriv;
	}

	/**
	 * @param postPriv 要设置的 postPriv
	 */
	public void setPostPriv(String postPriv) {
		this.postPriv = postPriv;
	}

	/**
	 * @return postDept
	 */
	public String getPostDept() {
		return postDept;
	}

	/**
	 * @param postDept 要设置的 postDept
	 */
	public void setPostDept(String postDept) {
		this.postDept = postDept;
	}

	/**
	 * @return deptId
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId 要设置的 deptId
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return deptIdOther
	 */
	public String getDeptIdOther() {
		return deptIdOther;
	}

	/**
	 * @param deptIdOther 要设置的 deptIdOther
	 */
	public void setDeptIdOther(String deptIdOther) {
		this.deptIdOther = deptIdOther;
	}

	/**
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex 要设置的 sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday 要设置的 birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return isLunar
	 */
	public String getIsLunar() {
		return isLunar;
	}

	/**
	 * @param isLunar 要设置的 isLunar
	 */
	public void setIsLunar(String isLunar) {
		this.isLunar = isLunar;
	}

	/**
	 * @return telNoDept
	 */
	public String getTelNoDept() {
		return telNoDept;
	}

	/**
	 * @param telNoDept 要设置的 telNoDept
	 */
	public void setTelNoDept(String telNoDept) {
		this.telNoDept = telNoDept;
	}

	/**
	 * @return faxNoDept
	 */
	public String getFaxNoDept() {
		return faxNoDept;
	}

	/**
	 * @param faxNoDept 要设置的 faxNoDept
	 */
	public void setFaxNoDept(String faxNoDept) {
		this.faxNoDept = faxNoDept;
	}

	/**
	 * @return addHome
	 */
	public String getAddHome() {
		return addHome;
	}

	/**
	 * @param addHome 要设置的 addHome
	 */
	public void setAddHome(String addHome) {
		this.addHome = addHome;
	}

	/**
	 * @return postNoHome
	 */
	public String getPostNoHome() {
		return postNoHome;
	}

	/**
	 * @param postNoHome 要设置的 postNoHome
	 */
	public void setPostNoHome(String postNoHome) {
		this.postNoHome = postNoHome;
	}

	/**
	 * @return telNoHome
	 */
	public String getTelNoHome() {
		return telNoHome;
	}

	/**
	 * @param telNoHome 要设置的 telNoHome
	 */
	public void setTelNoHome(String telNoHome) {
		this.telNoHome = telNoHome;
	}

	/**
	 * @return mobilNo
	 */
	public String getMobilNo() {
		return mobilNo;
	}

	/**
	 * @param mobilNo 要设置的 mobilNo
	 */
	public void setMobilNo(String mobilNo) {
		this.mobilNo = mobilNo;
	}

	/**
	 * @return bpNo
	 */
	public String getBpNo() {
		return bpNo;
	}

	/**
	 * @param bpNo 要设置的 bpNo
	 */
	public void setBpNo(String bpNo) {
		this.bpNo = bpNo;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email 要设置的 email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return oicqNo
	 */
	public String getOicqNo() {
		return oicqNo;
	}

	/**
	 * @param oicqNo 要设置的 oicqNo
	 */
	public void setOicqNo(String oicqNo) {
		this.oicqNo = oicqNo;
	}

	/**
	 * @return icqNo
	 */
	public String getIcqNo() {
		return icqNo;
	}

	/**
	 * @param icqNo 要设置的 icqNo
	 */
	public void setIcqNo(String icqNo) {
		this.icqNo = icqNo;
	}

	/**
	 * @return msn
	 */
	public String getMsn() {
		return msn;
	}

	/**
	 * @param msn 要设置的 msn
	 */
	public void setMsn(String msn) {
		this.msn = msn;
	}

	/**
	 * @return avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar 要设置的 avatar
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return callSound
	 */
	public String getCallSound() {
		return callSound;
	}

	/**
	 * @param callSound 要设置的 callSound
	 */
	public void setCallSound(String callSound) {
		this.callSound = callSound;
	}

	/**
	 * @return lastVisitTime
	 */
	public Date getLastVisitTime() {
		return lastVisitTime;
	}

	/**
	 * @param lastVisitTime 要设置的 lastVisitTime
	 */
	public void setLastVisitTime(Date lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
	}

	/**
	 * @return smsOn
	 */
	public String getSmsOn() {
		return smsOn;
	}

	/**
	 * @param smsOn 要设置的 smsOn
	 */
	public void setSmsOn(String smsOn) {
		this.smsOn = smsOn;
	}

	/**
	 * @return menuType
	 */
	public String getMenuType() {
		return menuType;
	}

	/**
	 * @param menuType 要设置的 menuType
	 */
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	/**
	 * @return lastPassTime
	 */
	public Date getLastPassTime() {
		return lastPassTime;
	}

	/**
	 * @param lastPassTime 要设置的 lastPassTime
	 */
	public void setLastPassTime(Date lastPassTime) {
		this.lastPassTime = lastPassTime;
	}

	/**
	 * @return theme
	 */
	public Byte getTheme() {
		return theme;
	}

	/**
	 * @param theme 要设置的 theme
	 */
	public void setTheme(Byte theme) {
		this.theme = theme;
	}

	/**
	 * @return shortcut
	 */
	public String getShortcut() {
		return shortcut;
	}

	/**
	 * @param shortcut 要设置的 shortcut
	 */
	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	/**
	 * @return portal
	 */
	public String getPortal() {
		return portal;
	}

	/**
	 * @param portal 要设置的 portal
	 */
	public void setPortal(String portal) {
		this.portal = portal;
	}

	/**
	 * @return panel
	 */
	public String getPanel() {
		return panel;
	}

	/**
	 * @param panel 要设置的 panel
	 */
	public void setPanel(String panel) {
		this.panel = panel;
	}

	/**
	 * @return online
	 */
	public Integer getOnline() {
		return online;
	}

	/**
	 * @param online 要设置的 online
	 */
	public void setOnline(Integer online) {
		this.online = online;
	}

	/**
	 * @return onStatus
	 */
	public String getOnStatus() {
		return onStatus;
	}

	/**
	 * @param onStatus 要设置的 onStatus
	 */
	public void setOnStatus(String onStatus) {
		this.onStatus = onStatus;
	}

	/**
	 * @return attendStatus
	 */
	public String getAttendStatus() {
		return attendStatus;
	}

	/**
	 * @param attendStatus 要设置的 attendStatus
	 */
	public void setAttendStatus(String attendStatus) {
		this.attendStatus = attendStatus;
	}

	/**
	 * @return mobilNoHidden
	 */
	public String getMobilNoHidden() {
		return mobilNoHidden;
	}

	/**
	 * @param mobilNoHidden 要设置的 mobilNoHidden
	 */
	public void setMobilNoHidden(String mobilNoHidden) {
		this.mobilNoHidden = mobilNoHidden;
	}

	/**
	 * @return mytableLeft
	 */
	public String getMytableLeft() {
		return mytableLeft;
	}

	/**
	 * @param mytableLeft 要设置的 mytableLeft
	 */
	public void setMytableLeft(String mytableLeft) {
		this.mytableLeft = mytableLeft;
	}

	/**
	 * @return mytableRight
	 */
	public String getMytableRight() {
		return mytableRight;
	}

	/**
	 * @param mytableRight 要设置的 mytableRight
	 */
	public void setMytableRight(String mytableRight) {
		this.mytableRight = mytableRight;
	}

	/**
	 * @return userPrivOther
	 */
	public String getUserPrivOther() {
		return userPrivOther;
	}

	/**
	 * @param userPrivOther 要设置的 userPrivOther
	 */
	public void setUserPrivOther(String userPrivOther) {
		this.userPrivOther = userPrivOther;
	}

	/**
	 * @return userNo
	 */
	public Short getUserNo() {
		return userNo;
	}

	/**
	 * @param userNo 要设置的 userNo
	 */
	public void setUserNo(Short userNo) {
		this.userNo = userNo;
	}

	/**
	 * @return notLogin
	 */
	public String getNotLogin() {
		return notLogin;
	}

	/**
	 * @param notLogin 要设置的 notLogin
	 */
	public void setNotLogin(String notLogin) {
		this.notLogin = notLogin;
	}

	/**
	 * @return notViewUser
	 */
	public String getNotViewUser() {
		return notViewUser;
	}

	/**
	 * @param notViewUser 要设置的 notViewUser
	 */
	public void setNotViewUser(String notViewUser) {
		this.notViewUser = notViewUser;
	}

	/**
	 * @return notViewTable
	 */
	public String getNotViewTable() {
		return notViewTable;
	}

	/**
	 * @param notViewTable 要设置的 notViewTable
	 */
	public void setNotViewTable(String notViewTable) {
		this.notViewTable = notViewTable;
	}

	/**
	 * @return notSearch
	 */
	public String getNotSearch() {
		return notSearch;
	}

	/**
	 * @param notSearch 要设置的 notSearch
	 */
	public void setNotSearch(String notSearch) {
		this.notSearch = notSearch;
	}

	/**
	 * @return bkground
	 */
	public String getBkground() {
		return bkground;
	}

	/**
	 * @param bkground 要设置的 bkground
	 */
	public void setBkground(String bkground) {
		this.bkground = bkground;
	}

	/**
	 * @return bindIp
	 */
	public String getBindIp() {
		return bindIp;
	}

	/**
	 * @param bindIp 要设置的 bindIp
	 */
	public void setBindIp(String bindIp) {
		this.bindIp = bindIp;
	}

	/**
	 * @return lastVisitIp
	 */
	public String getLastVisitIp() {
		return lastVisitIp;
	}

	/**
	 * @param lastVisitIp 要设置的 lastVisitIp
	 */
	public void setLastVisitIp(String lastVisitIp) {
		this.lastVisitIp = lastVisitIp;
	}

	/**
	 * @return menuImage
	 */
	public String getMenuImage() {
		return menuImage;
	}

	/**
	 * @param menuImage 要设置的 menuImage
	 */
	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}

	/**
	 * @return weatherCity
	 */
	public String getWeatherCity() {
		return weatherCity;
	}

	/**
	 * @param weatherCity 要设置的 weatherCity
	 */
	public void setWeatherCity(String weatherCity) {
		this.weatherCity = weatherCity;
	}

	/**
	 * @return showRss
	 */
	public String getShowRss() {
		return showRss;
	}

	/**
	 * @param showRss 要设置的 showRss
	 */
	public void setShowRss(String showRss) {
		this.showRss = showRss;
	}

	/**
	 * @return menuExpand
	 */
	public String getMenuExpand() {
		return menuExpand;
	}

	/**
	 * @param menuExpand 要设置的 menuExpand
	 */
	public void setMenuExpand(String menuExpand) {
		this.menuExpand = menuExpand;
	}

	/**
	 * @return myStatus
	 */
	public String getMyStatus() {
		return myStatus;
	}

	/**
	 * @param myStatus 要设置的 myStatus
	 */
	public void setMyStatus(String myStatus) {
		this.myStatus = myStatus;
	}

	/**
	 * @return limitLogin
	 */
	public String getLimitLogin() {
		return limitLogin;
	}

	/**
	 * @param limitLogin 要设置的 limitLogin
	 */
	public void setLimitLogin(String limitLogin) {
		this.limitLogin = limitLogin;
	}

	/**
	 * @return photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo 要设置的 photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return imRange
	 */
	public Byte getImRange() {
		return imRange;
	}

	/**
	 * @param imRange 要设置的 imRange
	 */
	public void setImRange(Byte imRange) {
		this.imRange = imRange;
	}

	/**
	 * @return leaveTime
	 */
	public Date getLeaveTime() {
		return leaveTime;
	}

	/**
	 * @param leaveTime 要设置的 leaveTime
	 */
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	/**
	 * @return secretLevel
	 */
	public Integer getSecretLevel() {
		return secretLevel;
	}

	/**
	 * @param secretLevel 要设置的 secretLevel
	 */
	public void setSecretLevel(Integer secretLevel) {
		this.secretLevel = secretLevel;
	}

	/**
	 * @return notMobileLogin
	 */
	public String getNotMobileLogin() {
		return notMobileLogin;
	}

	/**
	 * @param notMobileLogin 要设置的 notMobileLogin
	 */
	public void setNotMobileLogin(String notMobileLogin) {
		this.notMobileLogin = notMobileLogin;
	}
}