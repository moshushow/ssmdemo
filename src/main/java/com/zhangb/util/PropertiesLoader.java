package com.zhangb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

public class PropertiesLoader {
	
	private String filePath ;
	
	public PropertiesLoader() {
		
	}

	public PropertiesLoader(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * 读取属性文件中的value，通过key
	 * @param key
	 * @return
	 */
	public String readProp(String key){
		return readProp(filePath, key) ;
	}

	/**
	 * 读取属性文件中的value通过key
	 * @param filePath 属性文件的路径
	 * @param key 属性的key
	 * @return key对应的value
	 */
	public String readProp(String filePath, String key){
		File file = new File(filePath) ;
		if(!file.exists()){
			return null ;
		}
		InputStream is = null ;
		String value = null ;
		try{
			is = new FileInputStream(file) ;
			Properties prop = new Properties() ;
			prop.load(is);
			value = prop.getProperty(key) ;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			IOUtils.closeQuietly(is);
		}
		return value ;
	}
	
	
}
