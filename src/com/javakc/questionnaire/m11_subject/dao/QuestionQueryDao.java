package com.javakc.questionnaire.m11_subject.dao;

import java.util.List;

import com.javakc.questionnaire.vo.SubjectEntity;

public interface QuestionQueryDao {

	
	public List<SubjectEntity> query(String qu_id);
	
	
	
}
