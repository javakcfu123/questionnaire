package com.javakc.questionnaire.m01_user.action;

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

import com.javakc.questionnaire.m01_user.service.UserService;

@WebServlet("/user.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String kc = request.getParameter("kc");

		if ("delete".equals(kc)) {

			String user_id = request.getParameter("user_id");
			userService.delete(user_id);
		} else if ("insert".equals(kc)) {
			Map<String, Object> map = new HashMap<String, Object>();
			// ��������
			String user_name = request.getParameter("user_name");
			String login_name = request.getParameter("login_name");
			String login_pass = request.getParameter("login_pass");
			String user_email = request.getParameter("user_email");
			String user_phone = request.getParameter("user_phone");

			map.put("user_name", user_name);
			map.put("login_name", login_name);
			map.put("login_pass", login_pass);
			map.put("user_email", user_email);
			map.put("user_phone", user_phone);
			// �ж������Ƿ��ظ�
			// if (this.userService.queryName(type_name) > 0) {
			// // ������Ӧ���ַ���
			// response.setCharacterEncoding("utf-8");
			// // ������Ӧ������
			// response.getWriter().append("�ظ�");
			//
			// } else {
			// ����id
			String id = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
			map.put("user_id", id);
			userService.insert(map);

		} else if ("deleteAll".equals(kc)) {
			String s = request.getParameter("data");
			String[] ids = s.split(",");
			if (ids.length > 0) {
				userService.deleteAll(ids);
			}
		} else if ("toUpdate".equals(kc)) {
			String user_id = request.getParameter("user_id");

			Map map = userService.load(user_id);

			request.setAttribute("map", map);

			request.getRequestDispatcher("page/m01_user/update.jsp").forward(request, response);

		} else if ("update".equals(kc)) {
			Map<String, Object> map = new HashMap<String, Object>();
			String user_id = request.getParameter("user_id");
			String user_name = request.getParameter("user_name");
			String login_name = request.getParameter("login_name");
			String login_pass = request.getParameter("login_pass");
			String user_email = request.getParameter("user_email");
			String user_phone = request.getParameter("user_phone");

			map.put("user_id", user_id);
			map.put("user_name", user_name);
			map.put("login_name", login_name);
			map.put("login_pass", login_pass);
			map.put("user_email", user_email);
			map.put("user_phone", user_phone);

			userService.update(map);

		}else{
			String user_name = request.getParameter("user_name");
			String user_phone = request.getParameter("user_phone");
			String start = request.getParameter("start");
			String end = request.getParameter("end");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user_name", user_name);
			map.put("user_phone", user_phone);
			map.put("start", start);
			map.put("end", end);
			// ��ҳ
			// String pageStr = request.getParameter("page");
			String pageStr = request.getParameter("page");
			int page = 1;
			if (pageStr != null) {
				page = Integer.valueOf(pageStr);
			}
			map.put("fromNum", (page - 1) * 5);

			List<Map> list = userService.query(map);

			int count = userService.queryCount(map);
			// ����������������
			//User����
			request.setAttribute("list", list);
			//��ǰҳ
			request.setAttribute("page", page);
			//User����
			request.setAttribute("count", count);

			request.getRequestDispatcher("page/m01_user/list.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
