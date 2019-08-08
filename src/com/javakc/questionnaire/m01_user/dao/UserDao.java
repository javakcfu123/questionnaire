package com.javakc.questionnaire.m01_user.dao;

import java.util.List;
import java.util.Map;

/**
 * 用户 - 数据层
 * @author baker
 *
 */
public interface UserDao {
	
	
	public List<Map> query(Map<String, Object> map);

	public int queryCount(Map<String, Object> map);

	public void delete(String user_id);

	public void insert(Map<String, Object> map);

	public void deleteAll(String a[]);

	public Map load(String user_id);

	public void update(Map<String, Object> map);
}
