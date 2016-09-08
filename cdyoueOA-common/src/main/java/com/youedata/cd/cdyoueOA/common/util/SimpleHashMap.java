package com.youedata.cd.cdyoueOA.common.util;

import com.youedata.cd.cdyoueOA.common.constant.FlagDict;

import java.util.HashMap;
import java.util.Map;

/**
 * 工具类：构造时，一行代码将所有键值对放入HashMap<String, Object>
 * @author zhuyiqiang
 *
 */
public class SimpleHashMap extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	/**构造基本的HashMap*/
	public SimpleHashMap(String key, Object value) {
		this.put(key, value);
	}

	/**构造一个HashMap包含指定的FlagDict*/
	public SimpleHashMap(FlagDict dict) {
		this.put("msg", dict.getMsg());
		this.put("flag", dict.getFlag());
	}

	/**以FlagDict格式构造一个HashMap，msg和flag自定义*/
	public SimpleHashMap(String msg, Integer flag) {
		this.put("msg", msg);
		this.put("flag", flag);
	}

	/**添加键值对*/
	public SimpleHashMap addMap(String key, Object value) {
		this.put(key, value);
		return this;
	}

	/**添加Map*/
	public SimpleHashMap addMap(Map<String, ?> map) {
		this.putAll(map);
		return this;
	}

	/**设置FlagDict信息*/
	public SimpleHashMap setFlagDict(FlagDict dict) {
		this.put("msg", dict.getMsg());
		this.put("flag", dict.getFlag());
		return this;
	}
}
