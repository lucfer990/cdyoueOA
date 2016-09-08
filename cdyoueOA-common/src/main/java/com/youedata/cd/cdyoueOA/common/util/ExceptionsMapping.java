package com.youedata.cd.cdyoueOA.common.util;

import com.youedata.cd.cdyoueOA.common.constant.FlagDict;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统一异常信息处理类
 * @author zhuyiqiang
 *
 */
@Component
public class ExceptionsMapping {

	private static final String[] EXCLUDED_EXCEPTIONS = {
		"com.youedata.cd.cdyoueOA.web.base.UnknownAccountException",
		"com.youedata.cd.cdyoueOA.web.base.IncorrectCredentialsException",
		"com.youedata.cd.cdyoueOA.web.base.AuthenticationException"
	};
	/** 异常与FlagDict的映射 */
	public static final Map<String, FlagDict> MAPPED_EXCEPTIONS = new HashMap<String, FlagDict>();
	/** 不需要打印的异常名称 */
	public static final List<String> PRINTLESS_EXCEPTIONS = Arrays.asList(EXCLUDED_EXCEPTIONS);
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionsMapping.class);

	static {
		// 基本
		MAPPED_EXCEPTIONS.put("java.lang.NullPointerException", FlagDict.BASIC_SYS_ERROR);
		MAPPED_EXCEPTIONS.put("java.net.ConnectException", FlagDict.BASIC_CONNECT_ERROR);
		MAPPED_EXCEPTIONS.put("java.lang.IllegalArgumentException", FlagDict.BASIC_ILLEGAL_ARGUMENT);
		MAPPED_EXCEPTIONS.put("java.io.IOException", FlagDict.BASIC_SYS_ERROR);
		// 认证
		MAPPED_EXCEPTIONS.put("com.youedata.cd.cdyoueOA.web.base.UnknownAccountException", FlagDict.AUTHC_UNKNOWN_ACCOUNT);
		MAPPED_EXCEPTIONS.put("com.youedata.cd.cdyoueOA.web.base.IncorrectCredentialsException", FlagDict.AUTHC_INCORRECT_CREDENTIALS);
		MAPPED_EXCEPTIONS.put("com.youedata.cd.cdyoueOA.web.base.AuthenticationException", FlagDict.AUTHC_FAIL);
		// 授权
	}

	/**检索异常对应的FlagDict*/
	public static FlagDict retrieve(Exception e) {
		FlagDict dict = MAPPED_EXCEPTIONS.get(e.getClass().getName());
		return dict != null ? dict : FlagDict.BASIC_UNKNOWN_ERROR;
	}

	/**检索异常对应的FlagDict并根据情况打印日志*/
	public static FlagDict retrieveAndPrint(Exception e) {
		Assert.notNull(e, "传入的Class<?>参数为空！");
		if (!PRINTLESS_EXCEPTIONS.contains(e.getClass().getName())) {
			LOGGER.error("======================异常开始=======================");
			LOGGER.error(e.getMessage(), e);
			LOGGER.error("======================异常结束=======================");
		} else {
			LOGGER.error("======================业务异常" + e.getClass().getSimpleName() + "=======================");
		}
		return retrieve(e);
	}
}
