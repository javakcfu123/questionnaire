package com.javakc.questionnaire.m01_user.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.javakc.questionnaire.m01_user.dao.UserDao;
import com.javakc.questionnaire.m02_type.dao.TypeDao;
import com.javakc.questionnaire.m02_type.service.TypeService;
import com.javakc.questionnaire.m10_question.dao.QuestionDao;
import com.javakc.questionnaire.util.db.MybatisUtils;
/**
 * 基础数据-用户管理 - 逻辑层
 * @author baker
 *
 */
public class UserService{
	
	public List<Map> query(Map<String, Object> map) {
		SqlSession session = MybatisUtils.openSession();
		UserDao userdao = session.getMapper(UserDao.class);
		List<Map> list = userdao.query(map);
		session.close();
		return list;
	}

	public int queryCount(Map<String, Object> map) {
		SqlSession session = MybatisUtils.openSession();
		UserDao userdao = session.getMapper(UserDao.class);
		int count = userdao.queryCount(map);
		session.close();
		return count;
	}

	public void insert(Map<String, Object> map) {
		SqlSession session = MybatisUtils.openSession(true);
		UserDao userdao = session.getMapper(UserDao.class);
		userdao.insert(map);
		session.close();
	}

	public void delete(String user_id) {
		SqlSession session = MybatisUtils.openSession(true);
		UserDao userdao = session.getMapper(UserDao.class);
		userdao.delete(user_id);
		session.close();
	}

	public void deleteAll(String a[]) {
		SqlSession session = MybatisUtils.openSession(true);
		UserDao userdao = session.getMapper(UserDao.class);
		userdao.deleteAll(a);
		session.close();

	}

	public Map load(String user_id) {
		SqlSession session = MybatisUtils.openSession(true);
		UserDao userdao = session.getMapper(UserDao.class);
		Map m = userdao.load(user_id);
		session.close();
		return m;
	}

	public void update(Map<String, Object> map) {
		SqlSession session = MybatisUtils.openSession(true);
		UserDao userdao = session.getMapper(UserDao.class);
		userdao.update(map);
		session.close();
	}

}
