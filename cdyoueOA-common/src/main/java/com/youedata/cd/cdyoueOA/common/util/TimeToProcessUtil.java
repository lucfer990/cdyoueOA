package com.youedata.cd.cdyoueOA.common.util;

import java.text.ParseException;
import java.util.Date;

import com.youedata.cd.cdyoueOA.common.date.YoueDateUtil;

public class TimeToProcessUtil {
	//根据任务进行状态和完成时间计算工作进程
	/**
	 * 
	 * @param status 任务状态
	 * @param completeTime 完成时间
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 * @throws ParseException 
	 */
	public static String timeAndStatusToprocess(String status,String completeTime,String startTime,String endTime) throws ParseException{
		
		if(YoueStringUtils.isNotEmpty(status)&&YoueStringUtils.isNotEmpty(completeTime)&&YoueStringUtils.isNotEmpty(startTime)&&YoueStringUtils.isNotEmpty(endTime)){
			Date from= YoueDateUtil.parseDateTime(startTime);
			System.out.println(from);
			Date to= YoueDateUtil.parseDateTime(endTime);
			System.out.println(to);
			
			Date complete= YoueDateUtil.parseDateTime(completeTime);
			System.out.println(complete);
			if("1".equals(status)){
				Long parsedDate = (complete.getTime() - to.getTime())/1000;//获取毫秒数
				Long day = parsedDate / 3600/ 24;
				Long hour = parsedDate / 3600 % 24;
			   // Long minute = parsedDate / 60 % 60;
			   // Long second = parsedDate % 60;
				System.out.println(parsedDate);
					if(parsedDate>0){
						return "超期"+day+"天"+hour+"小时"+"(进行中)";
					}
					if(parsedDate<=0){
						String day1 = day<0?day.toString().substring(1):"0";
						String hour1 = hour<0?hour.toString().substring(1):"0";
						//String minute1 = minute.toString().substring(1);
						return "离结束还有"+day1+"天"+hour1+"小时"+"(进行中)";
					}
				}
			else if("0".equals(status)){								
				Long parsedDate = (complete.getTime() - from.getTime())/1000;//获取毫秒数
				Long day = parsedDate / 3600/ 24;
				Long hour = parsedDate / 3600 % 24;
				if(parsedDate<0){
					return "无效的进程";
				}
						return "历时"+day+"天"+hour+"小时"+"(已废除)";									
				
			}
			else if("2".equals(status)){
				Long parsedDate = (complete.getTime() - from.getTime())/1000;//获取毫秒数
				Long day = parsedDate / 3600/ 24;
				Long hour = parsedDate / 3600 % 24;	
				if(parsedDate<0){
					return "无效的进程";
				}
						return "历时"+day+"天"+hour+"小时"+"(已暂停)";									
				
				
			}
			else if("3".equals(status)){
				Long parsedDate = (complete.getTime() - from.getTime())/1000;//获取毫秒数
				Long day = parsedDate / 3600/ 24;
				Long hour = parsedDate / 3600 % 24;
				if(parsedDate<0){
					return "无效的进程";
				}
					return "历时"+day+"天"+hour+"小时"+"(强制完成)";									
				
				
			}
			
			else if("4".equals(status)){
				Long parsedDate = (complete.getTime() - from.getTime())/1000;//获取毫秒数
				Long day = parsedDate / 3600/ 24;
				Long hour = parsedDate / 3600 % 24;
				Long parsedDate1 = (complete.getTime() - to.getTime())/1000;//获取毫秒数
				Long day1 = parsedDate1 / 3600/ 24;
				Long hour1 = parsedDate1 / 3600 % 24;
				if(parsedDate1>0){
					return "历时"+day+"天"+hour+"小时"+"超期"+day1+"天"+hour1+"小时"+"(已完成)" ;
					
				}else{
					return "历时"+day+"天"+hour+"小时"+"提前"+(day1<0?day1.toString().substring(1):"0")+"天"+(hour1<0?hour1.toString().substring(1):"0")+"小时"+"(已完成)";
					
				}																		
				
			}	
			}
		return "无效的进程";
	}
	public static void main(String[] args) throws ParseException {
		for(int i=0;i<8;i++){
			System.out.println(timeAndStatusToprocess("1","2016-09-07 10:11:19.0","2016-08-11 00:00:00.0","2016-08-20 00:00:00.0"));
			
		}
		
		
	}

}
