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
		
			//收集问卷id
			String question_id = request.getParameter("qu_id");
			//收集答题人信息
			String write_name = request.getParameter("name");
			String write_phone = request.getParameter("phone");
			
			//封装问卷实例数据
			Map<String,Object> writer =new HashMap<String,Object>();
			//问卷实例编号
			String writer_id=Tools.getUUID();
			writer.put("writer_id", writer_id);
			//问卷编号
			writer.put("question_id", question_id);
			//答题人姓名
			writer.put("write_name", write_name);
			//答题人电话
			writer.put("write_phone", write_phone);
			//调用数据层，插入问卷实例数据
			answerDao.insertWriter(writer);
			
			//所有参数的名字
			Enumeration<String> names=request.getParameterNames();
			
			while(names.hasMoreElements()) {
				String name=names.nextElement();
				if(name.length()==32) {
					System.out.println("题目id："+name);
					//封装问卷实例的题目数据
					Map<String,Object> answer =new HashMap<String,Object>();
					//问卷实例的题目答案编号
					String answer_id=Tools.getUUID();
					answer.put("answer_id", answer_id);
					//问卷实例的编号
					answer.put("writer_id", writer_id);
					//题目编号
					answer.put("subject_id", name);
					
					String[] answers=request.getParameterValues(name);
					//判断是否是【问答题】
					boolean flag=answers.length==1 && !answers[0].matches("[A-Za-z0-9]{32}");
					if(flag) {
						//问答题，才有答案
						answer.put("content",answers[0] );
					}
					//插入问卷实例的题目答案
					answerDao.insertAnswer(answer);
					
					if(!flag){
						//选择题
						for(String a:answers) {
							//问卷实例题目选项
							Map<String,Object> answer_item = new HashMap<String,Object>();
							//
							answer_item.put("answer_item_id", Tools.getUUID());
							//题目答案编号
							answer_item.put("answer_id", answer_id);
							//选项编号
							answer_item.put("item_id", a);
							answerDao.insertItem(answer_item);
						}
					}
					System.out.println("选项id："+Arrays.toString(answers));
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
