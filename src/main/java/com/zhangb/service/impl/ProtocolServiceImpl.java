package com.zhangb.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangb.dao.ProtocolDao;
import com.zhangb.entity.Protocol;
import com.zhangb.service.ProtocolService;

@Service("protocolService")
public class ProtocolServiceImpl implements ProtocolService{
	//注入协议dao
	@Autowired
	ProtocolDao protocolDao;

	@Override
	public List<Protocol> selectAll() {
		
		return protocolDao.selectAll();
	}

	@Override
	public List<Protocol> selectCommonProtocol() {
		
		return protocolDao.selectCommonProtocol();
	}

	@Override
	public List<Protocol> selectByIdMap(HashMap<String, Object> map) {
		
		return protocolDao.selectByIdMap(map);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		
		return protocolDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Protocol record) {
		
		return protocolDao.insert(record);
	}

	@Override
	public int insertSelective(Protocol record) {
		
		return protocolDao.insertSelective(record);
	}

	@Override
	public Protocol selectByPrimaryKey(String id) {
		
		return protocolDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Protocol record) {
		
		return protocolDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Protocol record) {
		
		return protocolDao.updateByPrimaryKey(record);
	}

}
