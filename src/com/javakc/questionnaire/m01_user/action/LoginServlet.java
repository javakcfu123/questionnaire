package com.javakc.questionnaire.m01_user.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javakc.questionnaire.m01_user.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.kc")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	LoginService loginService=new LoginService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// �ռ���¼����
		String login_name = request.getParameter("login_name");//��¼��
		String login_pass = request.getParameter("login_pass");//��¼����
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("login_name", login_name);
		map.put("login_pass", login_pass);
		
		Map<String, Object> user=loginService.login(map);
		
		if (user!=null) {
			HttpSession session=request.getSession();
			//��¼�ɹ�
			//���û����Ʒ���session��
			session.setAttribute("user_name", user.get("user_name"));
			//���û���ųƷ���session��
			session.setAttribute("user_id", user.get("user_id"));
			
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
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
