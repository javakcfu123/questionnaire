package com.javakc.questionnaire.m11_subject.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.javakc.questionnaire.m11_subject.dao.QuestionQueryDao;
import com.javakc.questionnaire.util.db.MybatisUtils;
import com.javakc.questionnaire.vo.SubjectEntity;

public class QuestionQueryService {

	
	public List<SubjectEntity> query(String qu_id) {
		SqlSession session = MybatisUtils.openSession();
		QuestionQueryDao questionQueryDao = session.getMapper(QuestionQueryDao.class);
		List<SubjectEntity> list = questionQueryDao.query(qu_id);
		session.close();
		return list;
	}

	

}
