package com.javakc.questionnaire.m02_type.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.javakc.questionnaire.m02_type.dao.TypeDao;
import com.javakc.questionnaire.m02_type.service.TypeService;
import com.javakc.questionnaire.util.MybatisUtils;
/**
 * 基础数据-问卷类型 - 逻辑层
 * @author baker
 *
 */
public class TypeService{

	public List<Map> query(Map<String, Object> map) {
		SqlSession session = MybatisUtils.openSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		List<Map> list = typeDao.query(map);
		session.close();
		return list;
	}

	public int queryCount(Map<String, Object> map) {
		SqlSession session = MybatisUtils.openSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		int count= typeDao.queryCount(map);
		session.close();
		return count;
	}

	
	public void insert(Map<String, Object> map) {
		SqlSession session = MybatisUtils.openSession(true);
		TypeDao typeDao = session.getMapper(TypeDao.class);
		typeDao.insert(map);
		session.close();
		
	}

	
	public Map load(String type_id) {
		SqlSession session = MybatisUtils.openSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		Map map= typeDao.load(type_id);
		return map;
	}

	
	public void update(Map<String, Object> map) {
		SqlSession session = MybatisUtils.openSession(true);
		TypeDao typeDao = session.getMapper(TypeDao.class);
		typeDao.update(map);
		session.close();
		
	}

	
	public List<Map> queryAll(Map<String, Object> map) {
		SqlSession session = MybatisUtils.openSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		List<Map> list = typeDao.queryAll(map);
		session.close();
		return list;
	}
	
	public void delete(String type_id) {
		SqlSession session = MybatisUtils.openSession(true);
		TypeDao typeDao = session.getMapper(TypeDao.class);
		typeDao.delete(type_id);
		session.close();
		
	}
	
	public int queryName(String type_name) {
		SqlSession session = MybatisUtils.openSession();
		TypeDao typeDao = session.getMapper(TypeDao.class);
		int count= typeDao.queryName(type_name);
		session.close();
		return count;
	}

}
