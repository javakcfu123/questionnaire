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
	 * ������Ŀid��ȡ��ѡ�����Ϣ 
	 * @param subject_id ��Ŀid
	 * @return ѡ�����ϢList
	 */
	public List<Map<String,Object>> getItemsBySubjectId(String subject_id);
	
	
	public List<Map> queryItem(String subject_id);
	public List<Map> queryp(String subject_id);
	
	public void deleteAll(String[] ids);
	public List<Map> previewAll(String[] ids);
	public List<Map> previewAll2(String[] ids);
	
}
