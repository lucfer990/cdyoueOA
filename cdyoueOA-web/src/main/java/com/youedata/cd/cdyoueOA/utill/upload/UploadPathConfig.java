package com.youedata.cd.cdyoueOA.utill.upload;

import java.util.Map;

/**
 * Created by Administrator on 2016/2/19.
 */
public class UploadPathConfig {


    /**#图片服务器URL*/
    public final static String IMAGES_SERVER_URL;
    
    public final static String IMAGES_SERVER_DISK;

    /**图片服务器访问目录*/
    public final static String IMAGES_SERVER_PATH;
    


    static {
        Map<String,String> map = PropertyUtils.loadProperties("spring/upload.setting.properties");
        IMAGES_SERVER_URL = map.get("images.server.url");
        IMAGES_SERVER_DISK=map.get("images.server.disk");
        IMAGES_SERVER_PATH = map.get("images.server.path");
    }
    
    public static void main(String[] args) {
		UploadPathConfig pathConfig=new UploadPathConfig();
		System.out.println(pathConfig.IMAGES_SERVER_URL);
		
		System.out.println(pathConfig.IMAGES_SERVER_PATH);
	}
    
    
}
