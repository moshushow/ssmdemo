package com.zhangb.util;

import java.util.ArrayList;
import java.util.List;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * json工具
 * @author zhangbin
 * @date 2018-3-14
 * @copyright 北京锐安科技有限公司2016-2018
 */
public class JsonUtil {
	
	private static Gson gson = null; //json操作对象
	
	/**
	 * 单例模式
	 * @return
	 */
	public static Gson getGson(){
		if(null==gson){
			gson = new GsonBuilder().setDateFormat(DateUtil.ymdhms).create(); //日期默认为yyyy-MM-dd HH:mm:ss
		}
		return gson;
	}
	
	/**
	 * 将List数据json转换为对象
	 * @param list
	 * @param claz
	 * @return
	 */
	public static <T> List<T> fromListJson(List<String> list, Class<T> claz){
		if(null==list || list.size()<1 || null==claz){
			return null;
		}
		List<T> result = new ArrayList<T>();
		for(String json : list){
			if(Strings.isNullOrEmpty(json)){
				continue;
			}
			T t = getGson().fromJson(json, claz);
			result.add(t);
		}
		return result;
	}
	
	/**
	 * 将list转换为json
	 * @param <T>
	 * @param list
	 * @return
	 */
	public static <T> List<String> toListJson(List<T> list){
		List<String> rel = new ArrayList<String>();
		for(Object obj : list){
			rel.add(toJson(obj));
		}
		
		return rel;
	}
	
	/**
	 * 将对象转换为json
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj){
		return getGson().toJson(obj);
	}
	
	/**
	 * 将json字符串转换为对象
	 * @param json
	 * @param claz
	 * @return
	 */
	public static <T> T fromJson(String json,  Class<T> claz){
		return getGson().fromJson(json, claz);
	}
}
