/*
 * FileName: LogDateUtil.java
 * Copyright (C) 2016 youedata Tech. Co. Ltd. All Rights Reserved <admin@youedata.com>
 * 
 * Licensed under the youedata License, Version 1.0 (the "License");
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * author  : youedata <admin@youedata.com>
 * date     : 2016年2月24日 下午4:27:50
 * last modify author :
 * version : 1.0
 */
/**
 * <p>Title: LogDateUtil.java
 * <p>Description: 
 * <p>Copyright: (C) 2016 youedata Tech. Co. Ltd. All Rights Reserved <admin@youedata.com>
 * <p>Company: www.youedata.com
 * @author wanyz wanyongzhi@youedata.com
 * @date 2016年2月24日
 * @version 1.0
 */
package com.youedata.cd.cdyoueOA.common.date;


import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class YoueDateUtil {

	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static final DateFormat DATETIME_NOSECOND_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public static final DateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

	public static final DateFormat TIME_NOSECOND_FORMAT = new SimpleDateFormat("HH:mm");

	public static final DateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	public static final DateFormat TIMEDATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	public static Date parse(String dateString) throws ParseException {
		if ((dateString.trim().indexOf(" ") > 0) && (dateString.trim().indexOf(".") > 0))
			return new Timestamp(TIMESTAMP_FORMAT.parse(dateString).getTime());
		if (dateString.trim().indexOf(" ") > 0) {
			if (dateString.trim().indexOf(":") != dateString.trim().lastIndexOf(":")) {
				return new Timestamp(DATETIME_FORMAT.parse(dateString).getTime());
			}
			return new Timestamp(DATETIME_NOSECOND_FORMAT.parse(dateString).getTime());
		}
		if (dateString.indexOf(":") > 0) {
			if (dateString.trim().indexOf(":") != dateString.trim().lastIndexOf(":")) {
				return new Time(TIME_FORMAT.parse(dateString).getTime());
			}
			return new Time(TIME_NOSECOND_FORMAT.parse(dateString).getTime());
		}

		return new java.sql.Date(DATE_FORMAT.parse(dateString).getTime());
	}

	public static String format(Date date) {
		if ((date instanceof Timestamp))
			return TIMESTAMP_FORMAT.format(date);
		if ((date instanceof Time))
			return TIME_FORMAT.format(date);
		if ((date instanceof java.sql.Date)) {
			return DATE_FORMAT.format(date);
		}
		return DATETIME_FORMAT.format(date);
	}

	public static Date parse(String dateString, String style) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(style);
		return dateFormat.parse(dateString);
	}

	public static String format(Date date, String style) {
		DateFormat dateFormat = new SimpleDateFormat(style);
		return dateFormat.format(date);
	}

	public static Date parseDate(String dateString) throws ParseException {
		return DATE_FORMAT.parse(dateString);
	}

	public static String formatDate(Date date) {
		return DATE_FORMAT.format(date);
	}

	public static Date parseDateTime(String dateString) throws ParseException {
		return DATETIME_FORMAT.parse(dateString);
	}

	public static String formaDatetTime(Date date) {
		return DATETIME_FORMAT.format(date);
	}

	public static String formatTimeNoSecond(Date date) {
		return DATETIME_NOSECOND_FORMAT.format(date);
	}

	public static Date parseTimeNoSecond(String dateString) throws ParseException {
		return DATETIME_NOSECOND_FORMAT.parse(dateString);
	}
	public static String parseDateToSecond(Date date) throws ParseException {
		return TIMEDATE_FORMAT.format(date);
	}
	public static String getNowByString(String style) {
		if ((style == null) || ("".equals(style))) {
			style = "yyyy-MM-dd HH:mm:ss";
		}
		return format(new Date(), style);
	}
}
