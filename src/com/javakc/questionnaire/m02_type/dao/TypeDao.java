package com.javakc.questionnaire.m02_type.dao;

import java.util.List;
import java.util.Map;

/**
 * �ʾ� - ���ݲ�
 * @author baker
 *
 */
public interface TypeDao {
	/**
	 * ��ѯ����
	 * @param map ��װ��ѯ����
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
