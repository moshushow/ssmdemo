package com.zhangb.util;

import java.util.UUID;

/**
 * UUID生成工具
 * @author zhangbin
 * @date 2018-3-14
 * @copyright 北京锐安科技有限公司2016-2018
 */
public class UuidUtil {

	/**
	 * 生成32位的uuid
	 * @return
	 */
	 synchronized public static String uuid32(){
		try {
			Thread.sleep(8); //睡眠8毫秒，免得重复
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 生成36位的uuid
	 * @return
	 */
	 synchronized public static String uuid36(){
		return UUID.randomUUID().toString();
	}
}
