package com.javakc.questionnaire.m30_answer.dao;

import java.util.List;
import java.util.Map;

public interface AnswerDao {
	/**
	 * �����ʾ�ʵ��
	 * @param m
	 */
	public void insertWriter(Map m);
	/**
	 * ������Ŀ�ʹ�
	 * @param m
	 */
	public void insertAnswer(Map m);
	
	/**
	 * ������Ŀѡ���
	 * @param m
	 */
	public void insertItem(Map m);
}
