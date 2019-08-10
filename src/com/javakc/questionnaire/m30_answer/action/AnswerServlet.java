package com.javakc.questionnaire.m30_answer.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javakc.questionnaire.m10_question.service.QuestionService;
import com.javakc.questionnaire.m11_subject.service.QuestionQueryService;
import com.javakc.questionnaire.m30_answer.service.AnswerService;
import com.javakc.questionnaire.vo.SubjectEntity;


@WebServlet("/answer.kc")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//AnswerService answerService = new AnswerService();

	QuestionQueryService questionQueryService = new QuestionQueryService();
	
	QuestionService questionService=new QuestionService();
	
	AnswerService answerService=new AnswerService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String kc = request.getParameter("kc");
		request.setCharacterEncoding("utf-8");

		if ("insert".equals(kc)) {
			
			answerService.insert(request);

		} else if (kc.equals("answer")) {
//			String qu_id = request.getParameter("qu_id");
//			List<Map<String, Object>> List = answerService.getQuestion(qu_id);
//			Map m1 = answerService.load(qu_id);
//
//			for (int j = 0; j < List.size(); j++) {
//				List<Map<String, Object>> l = answerService
//						.getItemsBySubjectId(List.get(j).get("subject_id").toString());
//				request.setAttribute("list" + j, l);
//			}
//			request.setAttribute("Map", m1);
//			request.setAttribute("List", List);
			
			//问卷id
			String qu_id=request.getParameter("qu_id");
			//查询问卷
			Map<String,Object> questionMap=questionService.load(qu_id);
			
			//查询题目
			List<SubjectEntity> list=questionQueryService.query(qu_id);
			
			//问卷信息
			request.setAttribute("questionMap", questionMap);
			//题目列表
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/page/m30_answer/answer.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}