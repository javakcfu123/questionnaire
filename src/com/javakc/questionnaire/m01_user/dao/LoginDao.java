package com.javakc.questionnaire.m01_user.dao;

import java.util.List;
import java.util.Map;

/**
 * 登录 - 数据层
 * @author baker
 *
 */
public interface LoginDao {
	/**
	 * 登录
	 * @param map 封装查询条件
	 * @return
	 */
	public Map login(Map<String,Object> map);
	
}
