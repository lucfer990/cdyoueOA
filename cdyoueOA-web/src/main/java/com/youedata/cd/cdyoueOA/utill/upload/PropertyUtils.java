package com.youedata.cd.cdyoueOA.utill.upload;

import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2016/2/16.
 */
public class PropertyUtils {

    private static String settingProperties = "upload.setting.properties";
    private static String rootPath;

    static {
        URL uri = PropertyUtils.class.getResource("/");
        rootPath = uri.getPath();
    }

    public static void writeProperties(Map<String,String> map) {
        writeProperties(map, null);
    }

    public static void writeProperties(Map<String, String> map, String customProperties) {
        String sProperties = PropertyUtils.settingProperties;
        if(!StringUtils.isEmpty(customProperties)){
            sProperties = customProperties;
        }
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(rootPath + sProperties));
            for (String key : map.keySet()) {
                properties.setProperty(key, map.get(key));
            }
            properties.store(new FileOutputStream(rootPath + sProperties), "描述信息");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setProperty(String key, String value){
        setProperty(key, value, null);
    }

    public static void setProperty(String key, String value,String customProperties){
        String sProperties = PropertyUtils.settingProperties;
        if(!StringUtils.isEmpty(customProperties)){
            sProperties = customProperties;
        }
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(rootPath + sProperties));
            properties.setProperty(key, value);
            properties.store(new FileOutputStream(rootPath+sProperties),"描述信息");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return getProperty(key, null);
    }

    public static String getProperty(String key,String customProperties){
        String sProperties = PropertyUtils.settingProperties;
        if(!StringUtils.isEmpty(customProperties)){
            sProperties = customProperties;
        }
        Properties properties = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(rootPath+sProperties);//加载Java项目根路径下的配置文件
            properties.load(input);// 加载属性文件
            return properties.getProperty(key);
        } catch (IOException io) {
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static Map<String,String> loadProperties() {
        return loadProperties(null);
    }

    public static Map<String,String> loadProperties(String customProperties) {
        String sProperties = PropertyUtils.settingProperties;
        if(!StringUtils.isEmpty(customProperties)){
            sProperties = customProperties;
        }

        Properties properties = new Properties();
        Map<String,String> stringStringMap = new HashMap<String,String>();
        InputStream input = null;
        try {
            input = new FileInputStream(rootPath+sProperties);//加载Java项目根路径下的配置文件
            properties.load(input);// 加载属性文件
            for (Object key : properties.keySet()) {
                stringStringMap.put((String) key, properties.getProperty((String) key));
            }
        } catch (IOException io) {
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringStringMap;
    }
}
