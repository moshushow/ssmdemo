package com.zhangb.service;

import java.util.HashMap;
import java.util.List;

import com.zhangb.entity.Protocol;



public interface ProtocolService {
	
	/**
	 * 查询全部
	 * @return
	 */
	List<Protocol> selectAll();
	/**
	 * 查询协议
	 * @return
	 */
	List<Protocol> selectCommonProtocol();
	/**
	 * 查询
	 * @param map
	 * @return
	 */
	List<Protocol> selectByIdMap(HashMap<String,Object> map);
	
    /**
     * 主键删除
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入
     */
    int insert(Protocol record);

    /**
     * 任意插入
     */
    int insertSelective(Protocol record);

    /**
     * 主键查询
     */
    Protocol selectByPrimaryKey(String id);

    /**
     * 任意修改
     * 
     */
    int updateByPrimaryKeySelective(Protocol record);

    /**
     * 主键修改
     */
    int updateByPrimaryKey(Protocol record);
}