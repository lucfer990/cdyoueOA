package com.youedata.cd.cdyoueOA.common.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * <p>
 * Title: UploadPathConfig.java
 * <p>
 * Description: 文件上传路径配置基础模块
 * <p>
 * Copyright: (C) 2016 youedata Tech. Co. Ltd. All Rights Reserved
 * <admin@youedata.com>
 * <p>
 * Company: www.youedata.com
 * 
 * @author dengxiaoxu admin@youedata.com
 * @date 2016年3月10日
 * @version 1.0
 */
public final class UploadPathConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(UploadPathConfig.class);

	/** 图片服务器URL */
	public static String IMAGES_SERVER_URL;
	
	/** 图片服务器公司头像URL */
	public static String COOPERATE_SERVER_URL;

	/** 图片服务器访问目录 */
	public static String IMAGES_SERVER_PATH;

	static {
		Properties prop = new Properties();
		try {
			prop.load(UploadPathConfig.class.getClassLoader().getResourceAsStream("properties/upload.setting.properties"));
			IMAGES_SERVER_URL = prop.getProperty("images.server.url");
			IMAGES_SERVER_PATH = prop.getProperty("images.server.path");
			COOPERATE_SERVER_URL = prop.getProperty("upload.images.cooperate.image");
		} catch (IOException e) {
			LOGGER.error("加载配置文件错误", e);
		}
	}
}
