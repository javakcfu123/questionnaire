package com.javakc.questionnaire.m11_subject.dao;

import java.util.List;
import java.util.Map;

public interface SubjectDao {

	
	public List<Map<String,Object>> query(Map<String,Object> map);
	
	public void insert(Map<String,Object> map);
	
	public void insertItem(Map<String,Object> map);
	
	public void delete(String subject_id);
	
	public void update(Map<String,Object> map);
	
	public void deleteItems(String subject_id);
	
	public Map<String,Object> load(String subject_id);
	
	/**
	 * 根据题目id，取得选项的信息 
	 * @param subject_id 题目id
	 * @return 选项的信息List
	 */
	public List<Map<String,Object>> getItemsBySubjectId(String subject_id);
	
	
	public List<Map> queryItem(String subject_id);
	public List<Map> queryp(String subject_id);
	
	public void deleteAll(String[] ids);
	public List<Map> previewAll(String[] ids);
	public List<Map> previewAll2(String[] ids);
	
}
