package com.zhangb.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 描述：日期处理工具 
 * @author zhangbin
 */
public class DateUtil {
	public static String ymd="yyyy-MM-dd";
	public static String ymdhms="yyyy-MM-dd HH:mm:ss";
	public static String ymdhm="yyyy-MM-dd HH:mm";
	
	/**
	 * 将字串转成日期和时间，
	 * @param date
	 * @param format
	 * @return Date
	 * @throws ParseException 
	 */
	public static Date parseToDate(String date, String format) throws ParseException {
		if (StringUtils.isNotBlank(date)) {
			DateFormat formatter = null;
			formatter = new SimpleDateFormat(format);
			return (Date) formatter.parse(date);
		}
		return null;
	}
	
	/**
	 * 日期转换为字符串，默认格式yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date)
    {
        return dateToString(date, ymd);
    }

	/**
	 * 日期转换为字符串
	 * @param date
	 * @param format 格式
	 * @return
	 */
    public static String dateToString(Date date, String format)
    {
    	if(null==date){
    		return null;
    	}
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
	
	/**
	 * 生成10位的秒字符串
	 * @return
	 */
	public static String getSeconds(){
		Calendar c = Calendar.getInstance();
		Long allSecond = c.getTimeInMillis()/1000;
		String tenSecondString = "" + allSecond;
		while(tenSecondString.length()<10)
		{
			tenSecondString = "0" + tenSecondString;
		}
		return tenSecondString;
	}

	/**
	 * 检查绝对秒数与当前时间的间隔是否属于天数范围内
	 * 例如传入的时间是2015-1-1，days是7，而当前时间是2015-1-2，则合法
	 * 例如传入的时间是2015-1-1，days是7，而当前时间是2015-1-9，则非法
	 * @param time 格林威治时间到当前时间秒数
	 * @return
	 */
	public static boolean checkSeconds(String time, int days){
		Date dt = new Date(Long.valueOf(time)*1000);
		Calendar ca = Calendar.getInstance();
		ca.setTime(dt);
		Calendar now = Calendar.getInstance();
		if(ca.after(now)){ //如果时间在当前之间之后，错误
			return false;
		}
        
		long millis = days*24*60*60*1000; //天数转换为毫秒数
		if((now.getTimeInMillis()-ca.getTimeInMillis())>millis){ //超出限定范围
			return false;
		}
		
		return true;
	}
	
	/**
	 * 获取在当前时间加减的天数
	 * @param format 日期格式
	 * @param add 正数为加的天数,负数为减的天数
	 * @return
	 */
	public static String getDate(String format, int add){
		String formatNew = format;
		if(StringUtils.isBlank(formatNew)){
			formatNew = ymd; //默认为年月日
		}
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, add);
		
		DateFormat formatter= new SimpleDateFormat(formatNew);
		Date date = now.getTime();
		return formatter.format(date);
	}
	
}
