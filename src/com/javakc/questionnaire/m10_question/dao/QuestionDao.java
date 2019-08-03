package com.javakc.questionnaire.m10_question.dao;

import java.util.List;
import java.util.Map;

/**
 * 问卷 - 数据层
 * @author baker
 *
 */
public interface QuestionDao {
	/**
	 * 查询数据
	 * @param map 封装查询条件
	 * @return
	 */
	public List<Map> query(Map<String,Object> map);
	
	public int queryCount(Map<String,Object> map);
	
	public void insert(Map<String,Object> map);
	
	public Map load(String qu_id);
	
	public void update(Map<String,Object> map);
	
	public void delete(String qu_id);
	/**
	 * 批量删除
	 * @param ids 多个id
	 */
	public void deleteAll(String[] ids);
}
