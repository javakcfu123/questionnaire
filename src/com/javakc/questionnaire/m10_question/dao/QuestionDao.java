package com.javakc.questionnaire.m10_question.dao;

import java.util.List;
import java.util.Map;

/**
 * �ʾ� - ���ݲ�
 * @author baker
 *
 */
public interface QuestionDao {
	/**
	 * ��ѯ����
	 * @param map ��װ��ѯ����
	 * @return
	 */
	public List<Map> query(Map<String,Object> map);
	
	public int queryCount(Map<String,Object> map);
	
	public void insert(Map<String,Object> map);
	
	public Map load(String qu_id);
	
	public void update(Map<String,Object> map);
	
	public void delete(String qu_id);
	/**
	 * ����ɾ��
	 * @param ids ���id
	 */
	public void deleteAll(String[] ids);
}
