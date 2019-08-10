package com.javakc.questionnaire.m30_answer.dao;

import java.util.List;
import java.util.Map;

public interface AnswerDao {
	/**
	 * 插入问卷实例
	 * @param m
	 */
	public void insertWriter(Map m);
	/**
	 * 插入题目和答案
	 * @param m
	 */
	public void insertAnswer(Map m);
	
	/**
	 * 插入题目选项答案
	 * @param m
	 */
	public void insertItem(Map m);
}
