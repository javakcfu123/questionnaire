package com.javakc.questionnaire.m10_question.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.javakc.questionnaire.m10_question.dao.QuestionDao;
import com.javakc.questionnaire.util.MybatisUtils;
/**
 * ÎÊ¾í - Âß¼­²ã - ÊµÏÖ
 * @author baker
 *
 */
public class QuestionService {
	
	//QuestionDao questionDao = MybatisUtils.openSession().getMapper(QuestionDao.class);

	
	public List<Map> query(Map<String, Object> map) {
		SqlSession session = MybatisUtils.openSession();
		QuestionDao questionDao = session.getMapper(QuestionDao.class);
		List<Map> list = questionDao.query(map);
		session.close();
		return list;
	}

	
	public void insert(Map<String,Object> map) {
		SqlSession session = MybatisUtils.openSession(true);
		QuestionDao questionDao=session.getMapper(QuestionDao.class);
		questionDao.insert(map);
		session.close();

	}
	
	public Map load(String qu_id) {
		SqlSession session = MybatisUtils.openSession(true);
		QuestionDao questionDao=session.getMapper(QuestionDao.class);
		
		Map map=questionDao.load(qu_id);
		return map;
	}
	
	
	public void update(Map<String,Object> map) {
		SqlSession session = MybatisUtils.openSession(true);
		QuestionDao questionDao=session.getMapper(QuestionDao.class);
		
		questionDao.update(map);
		session.close();
	}
	
	
	public void delete(String qu_id) {
		SqlSession session = MybatisUtils.openSession(true);
		QuestionDao questionDao = session.getMapper(QuestionDao.class);
		
		questionDao.delete(qu_id);
		session.close();

	}

	
	public int queryCount(Map<String, Object> map) {
		SqlSession session = MybatisUtils.openSession();
		QuestionDao questionDao = session.getMapper(QuestionDao.class);
		int count = questionDao.queryCount(map);
		session.close();
		return count;
	}

	
	public void deleteAll(String[] ids) {
		SqlSession session = MybatisUtils.openSession(true);
		QuestionDao questionDao = session.getMapper(QuestionDao.class);
		questionDao.deleteAll(ids);
		session.close();
		
	}

}
