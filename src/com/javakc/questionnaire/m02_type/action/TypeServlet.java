package com.javakc.questionnaire.m02_type.action;

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

import com.javakc.questionnaire.m02_type.service.TypeService;
import com.javakc.questionnaire.util.Tools;

/**
 * �ʾ� - ���ֲ�
 */
@WebServlet("/type.do")
public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//ע���߼���ӿ�
	TypeService typeService=new TypeService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String kc=request.getParameter("kc");
		request.setCharacterEncoding("utf-8");
		
		if("insert".equals(kc)) {
			Map<String,Object> map=new HashMap<String,Object>();
			//��������
			String type_name=request.getParameter("type_name");
			map.put("type_name", type_name);
			//�ж������Ƿ��ظ�
			if(this.typeService.queryName(type_name)>0) {
				//������Ӧ���ַ���
				response.setCharacterEncoding("utf-8");
				//������Ӧ������
				response.getWriter().append("�ظ�");	
				
			}else {
				//����id
				String id=Tools.getUUID();
				map.put("type_id", id);
				
				//��ǰ��¼��
				HttpSession session=request.getSession();
				Object user_name=session.getAttribute("user_name");
				map.put("creator_id", user_name);
				
				typeService.insert(map);
			}
			
		}else if("toUpdate".equals(kc)) {
			String type_id=request.getParameter("type_id");
			
			Map<String,Object> map=typeService.load(type_id);
			
			request.setAttribute("map", map);
			
			request.getRequestDispatcher("page/m02_type/update.jsp").forward(request, response);
			
		}else if("update".equals(kc)) {
			
			Map<String,Object> map=new HashMap<String,Object>();
			
			String type_id=request.getParameter("type_id");
			map.put("type_id", type_id);
			//��������
			map.put("type_name", request.getParameter("type_name"));
			
			//��ǰ��¼��
			HttpSession session=request.getSession();
			Object user_name=session.getAttribute("user_name");
			map.put("update_id", user_name);
			
			typeService.update(map);
			
		}else if("delete".equals(kc)) {
			String type_id=request.getParameter("type_id");
			
	    	//ɾ��
			typeService.delete(type_id);
			
			
		}else if("init_type".equals(kc)) {
	    	//��ѯ��������
			List<Map> typeList=typeService.queryAll(null);
			this.getServletContext().setAttribute("typeList", typeList);
			
		}else {
			//�õ���ѯ����
			//���ƹؼ���
			String type_name=request.getParameter("type_name");
			//������
			String creator_id=request.getParameter("creator_id");
			//������ʼ����
			String start=request.getParameter("start");
			//������������
			String end=request.getParameter("end");
			
//			��װ��ѯ����
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("type_name", type_name);
			map.put("creator_id", creator_id);
			map.put("start", start);
			map.put("end", end);
			
			//��ҳ
			String  pageStr=request.getParameter("page");
			int page=1;
			if(pageStr!=null) {
				page=Integer.valueOf(pageStr);
			}
			map.put("fromNum", (page-1)*5);
			
			
			List<Map> list=typeService.query(map);
			
			int count=typeService.queryCount(map);
//			����������������
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.setAttribute("count", count);
			//�ַ�����תҳ��
			request.getRequestDispatcher("page/m02_type/list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
