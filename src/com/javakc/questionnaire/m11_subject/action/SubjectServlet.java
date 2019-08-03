package com.javakc.questionnaire.m11_subject.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javakc.questionnaire.m11_subject.service.SubjectService;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/subject.do")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SubjectService subjectService = new SubjectService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String kc = request.getParameter("kc");
		HttpSession session = request.getSession();

		if ("insert".equals(kc)) {

			// ��װ����������
			Map<String, Object> map = new HashMap<String, Object>();

			String subject_id = UUID.randomUUID().toString().replaceAll("-", "");
			map.put("subject_id", subject_id);

			map.put("creator_id", session.getAttribute("user_name"));

			map.put("qu_id", request.getParameter("qu_id"));
			map.put("subject_title", request.getParameter("subject_title"));
			map.put("subject_type", request.getParameter("subject_type"));
			map.put("subject_must", Integer.valueOf(request.getParameter("subject_must")));

			try {
				map.put("subject_score", Integer.valueOf(request.getParameter("subject_score")));
			} catch (Exception e) {

			}
			map.put("subject_desc", request.getParameter("subject_desc"));

			String contents[] = request.getParameterValues("item_content");

			String corrects = request.getParameter("corrects");// 1,0

			subjectService.insert(map, contents, corrects);

		} else if ("delete".equals(kc)) {
			subjectService.delete(request.getParameter("subject_id"));

		} else if ("toUpdate".equals(kc)) {
			// �ռ���������Ŀid
			String subject_id = request.getParameter("subject_id");
			// ������Ŀid��ȡ����Ŀ����Ϣ
			Map<String, Object> map = subjectService.load(subject_id);
			request.setAttribute("map", map);

			// ������Ŀid��ȡ��ѡ�����Ϣ
			List<Map<String, Object>> items = subjectService.getItemsBySubjectId(subject_id);
			request.setAttribute("items", items);

			// �ַ�����תҳ�棬������һ������Ĳ���(parameter)������(attribute)ת��update.jsp��
			request.getRequestDispatcher("page/m11_subject/update.jsp").forward(request, response);

		} else if ("update".equals(kc)) {
			// �ռ�������Ϣ
			// ��װ����������
			Map<String, Object> map = new HashMap<String, Object>();

			String subject_id = request.getParameter("subject_id");
			map.put("subject_id", subject_id);

			map.put("creator_id", session.getAttribute("user_name"));

			map.put("qu_id", request.getParameter("qu_id"));
			map.put("subject_title", request.getParameter("subject_title"));
			map.put("subject_type", request.getParameter("subject_type"));
			map.put("subject_must", Integer.valueOf(request.getParameter("subject_must")));

			try {
				map.put("subject_score", Integer.valueOf(request.getParameter("subject_score")));
			} catch (Exception e) {

			}
			map.put("subject_desc", request.getParameter("subject_desc"));

			// �ռ�ѡ����Ϣ
			String[] contents = request.getParameterValues("item_content");

			String[] corrects = request.getParameterValues("correct");
			// �����߼���api
			subjectService.update(map, contents, corrects);
		} else if("deleteAll".equals(kc)) {
			String data=request.getParameter("data");
			String[] ids=data.split(",");
			if(ids.length>0) {
				subjectService.deleteAll(ids);
			}
		}else if ("preview".equals(kc)) {
			//����Ԥ��
			//�ռ���������Ŀid
			String subject_id = request.getParameter("subject_id");
			//
			
			// ������Ŀid��ȡ����Ŀ����Ϣ
			Map<String, Object> map = subjectService.load(subject_id);
			request.setAttribute("map", map);

			// ������Ŀid��ȡ��ѡ�����Ϣ
			List<Map<String, Object>> items = subjectService.getItemsBySubjectId(subject_id);
			request.setAttribute("items", items);
			
			//�ַ�����תҳ��
			request.getRequestDispatcher("page/m11_subject/preview.jsp").forward(request, response);
			
			
		}else if("previewAll".equals(kc)) {
			String data=request.getParameter("data");
			String[] ids=data.split(",");
			List<Map> query = subjectService.previewAll(ids);
			List<Map> queryItem = subjectService.previewAll2(ids);
			request.setAttribute("query", query);
			request.setAttribute("queryItem", queryItem);
			request.getRequestDispatcher("page/m11_subject/preview.jsp").forward(request, response);	
			}else {

			int page = 1;
			int fromNum = (page - 1) * 5;
			int endNum = page * 5;

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("qu_id", request.getParameter("qu_id"));
			map.put("subject_title", request.getParameter("subject_title"));
			map.put("subject_type", request.getParameter("subject_type"));
			map.put("subject_score", request.getParameter("subject_score"));
			map.put("subject_must", request.getParameter("subject_must"));
			map.put("create_date", request.getParameter("create_date"));
			map.put("create_id", request.getParameter("create_id"));
			map.put("state", request.getParameter("state"));

			

			map.put("fromNum", fromNum);
			map.put("endNum", endNum);
			List<Map<String, Object>> list = subjectService.query(map);
			int count = list.size();
			
			request.setAttribute("qu_id", request.getParameter("qu_id"));
			request.setAttribute("count", count);
			request.setAttribute("list", list);
			request.getRequestDispatcher("page/m11_subject/list.jsp").forward(request, response);

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
