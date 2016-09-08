package com.youedata.cd.cdyoueOA.common.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 
 * <p>Title: FlagDict.java
 * <p>Description: 响应结果标识
 * <p>Copyright: (C) 2016 youedata Tech. Co. Ltd. All Rights Reserved <piaomiaoxingz@126.com>
 * <p>Company: www.youedata.com
 * @author piaomiao piaomiaoxingz@126.com
 * @date 2016年4月1日
 * @version 1.0
 */
public enum FlagDict {

	// 基本
	/**操作成功*/
	BASIC_SUCCESS(1000),
	/**操作失败*/
	BASIC_FAIL(1001),
	/**系统异常*/
	BASIC_SYS_ERROR(1002),
	/**连接异常*/
	BASIC_CONNECT_ERROR(1003),
	/**参数非法*/
	BASIC_ILLEGAL_ARGUMENT(1004),
	/**未知错误*/
	BASIC_UNKNOWN_ERROR(1010),
	// 认证
	/**登录成功*/
	AUTHC_SUCCESS(1100),
	/**账户不存在*/
	AUTHC_UNKNOWN_ACCOUNT(1101),
	/**密码错误*/
	AUTHC_INCORRECT_CREDENTIALS(1102),
	/**账户已登录*/
	AUTHC_DUPLICATE_LOGIN(1103),
	/**认证失败*/
	AUTHC_FAIL(1104),
	// 授权
	/***/
	AUTHZ_SUCCESS(1200),
	/**无权限*/
	AUTHZ_FAIL(1201);

	private static final Logger LOGGER = LoggerFactory.getLogger(FlagDict.class);
	private String msg;
	private int flag;

	static {
		Properties prop = new Properties();
		try {
			prop.load(new InputStreamReader(FlagDict.class.getClassLoader().getResourceAsStream("properties/flagdict.properties"), "UTF-8"));
			for (FlagDict dict : FlagDict.values()) {
				dict.setMsg(prop.getProperty(dict.getFlag()+""));
			}
		} catch (IOException e) {
			LOGGER.error("加载配置文件错误", e);
		}
	}

	private FlagDict(String msg , int flag) {
		this.msg = msg;
		this.flag = flag;
	}

	private FlagDict(int flag) {
		this.flag = flag;
	}

	public String getMsg() {
		return msg;
	}

	private void setMsg(String msg) {
		this.msg = msg;
	}

	public int getFlag() {
		return flag;
	}
	
}
