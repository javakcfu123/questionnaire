package com.javakc.questionnaire.m11_subject.action;

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
import com.javakc.questionnaire.vo.SubjectEntity;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/questionQuery.do")
public class QuestionQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	QuestionQueryService questionQueryService = new QuestionQueryService();

	QuestionService questionService=new QuestionService();
			 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String kc = request.getParameter("kc");

		if ("viewQuestion".equals(kc)) {
			//�ʾ�id
			String qu_id=request.getParameter("qu_id");
			//��ѯ�ʾ�
			Map<String,Object> questionMap=questionService.load(qu_id);
			
			//��ѯ��Ŀ
			List<SubjectEntity> list=questionQueryService.query(qu_id);
			
			//�ʾ���Ϣ
			request.setAttribute("questionMap", questionMap);
			//��Ŀ�б�
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("page/m11_subject/previewAll.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
