package com.javakc.questionnaire.m01_user.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.javakc.questionnaire.m01_user.dao.LoginDao;
import com.javakc.questionnaire.util.db.MybatisUtils;
/**
 * 基础数据-登录管理 - 逻辑层
 * @author baker
 *
 */
public class LoginService{

	public Map login(Map<String, Object> map) {
		SqlSession session = MybatisUtils.openSession();
		LoginDao loginDao = session.getMapper(LoginDao.class);
		Map retMap = loginDao.login(map);
		session.close();
		return retMap;
	}
	
}
