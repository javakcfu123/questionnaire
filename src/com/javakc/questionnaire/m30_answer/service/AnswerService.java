package com.javakc.questionnaire.m30_answer.service;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.tribes.util.Arrays;
import org.apache.ibatis.session.SqlSession;

import com.javakc.questionnaire.m30_answer.dao.AnswerDao;
import com.javakc.questionnaire.util.db.MybatisUtils;
import com.javakc.questionnaire.util.tools.Tools;

public class AnswerService {


	public void insert(HttpServletRequest request) {
		SqlSession session = MybatisUtils.openSession();
		AnswerDao answerDao = session.getMapper(AnswerDao.class);
		try {
		
			//�ռ��ʾ�id
			String question_id = request.getParameter("qu_id");
			//�ռ���������Ϣ
			String write_name = request.getParameter("name");
			String write_phone = request.getParameter("phone");
			
			//��װ�ʾ�ʵ������
			Map<String,Object> writer =new HashMap<String,Object>();
			//�ʾ�ʵ�����
			String writer_id=Tools.getUUID();
			writer.put("writer_id", writer_id);
			//�ʾ���
			writer.put("question_id", question_id);
			//����������
			writer.put("write_name", write_name);
			//�����˵绰
			writer.put("write_phone", write_phone);
			//�������ݲ㣬�����ʾ�ʵ������
			answerDao.insertWriter(writer);
			
			//���в���������
			Enumeration<String> names=request.getParameterNames();
			
			while(names.hasMoreElements()) {
				String name=names.nextElement();
				if(name.length()==32) {
					System.out.println("��Ŀid��"+name);
					//��װ�ʾ�ʵ������Ŀ����
					Map<String,Object> answer =new HashMap<String,Object>();
					//�ʾ�ʵ������Ŀ�𰸱��
					String answer_id=Tools.getUUID();
					answer.put("answer_id", answer_id);
					//�ʾ�ʵ���ı��
					answer.put("writer_id", writer_id);
					//��Ŀ���
					answer.put("subject_id", name);
					
					String[] answers=request.getParameterValues(name);
					//�ж��Ƿ��ǡ��ʴ��⡿
					boolean flag=answers.length==1 && !answers[0].matches("[A-Za-z0-9]{32}");
					if(flag) {
						//�ʴ��⣬���д�
						answer.put("content",answers[0] );
					}
					//�����ʾ�ʵ������Ŀ��
					answerDao.insertAnswer(answer);
					
					if(!flag){
						//ѡ����
						for(String a:answers) {
							//�ʾ�ʵ����Ŀѡ��
							Map<String,Object> answer_item = new HashMap<String,Object>();
							//
							answer_item.put("answer_item_id", Tools.getUUID());
							//��Ŀ�𰸱��
							answer_item.put("answer_id", answer_id);
							//ѡ����
							answer_item.put("item_id", a);
							answerDao.insertItem(answer_item);
						}
					}
					System.out.println("ѡ��id��"+Arrays.toString(answers));
					System.out.println();
				}
			}
			session.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		
		session.close();
		
	}
	
	public void insertWriter(Map m) {
		SqlSession session = MybatisUtils.openSession(true);
		AnswerDao AnswerDao = session.getMapper(AnswerDao.class);
		AnswerDao.insertWriter(m);
		session.close();
	}

	public void insertAnswer(Map m) {
		SqlSession session = MybatisUtils.openSession(true);
		AnswerDao AnswerDao = session.getMapper(AnswerDao.class);
		AnswerDao.insertAnswer(m);
		session.close();
	}

	public void insertItem(Map m) {
		SqlSession session = MybatisUtils.openSession(true);
		AnswerDao AnswerDao = session.getMapper(AnswerDao.class);
		AnswerDao.insertItem(m);
		session.close();
	}

}
