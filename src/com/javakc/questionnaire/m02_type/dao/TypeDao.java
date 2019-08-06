package com.javakc.questionnaire.m02_type.dao;

import java.util.List;
import java.util.Map;

/**
 * 问卷 - 数据层
 * @author baker
 *
 */
public interface TypeDao {
	/**
	 * 查询数据
	 * @param map 封装查询条件
	 * @return
	 */
	public List<Map> query(Map<String,Object> map);
	
	public int queryCount(Map<String,Object> map);
	
	public List<Map> queryAll(Map<String,Object> map);
	
	public void insert(Map<String,Object> map);
	
	public Map load(String type_id);

	public void update(Map<String,Object> map);
	
	public void delete(String type_id);
	
	public int queryName(String type_name);
}
