package com.javakc.questionnaire.m10_question.action;

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

import com.javakc.questionnaire.m10_question.service.QuestionService;

/**
 * 问卷 - 表现层
 */
@WebServlet("/question.do")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//注入问卷管理的逻辑层接口
	QuestionService questionService=new QuestionService();
	//注入问卷类型的逻辑层
	//TypeService typeService=new TypeServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String kc=request.getParameter("kc");
		request.setCharacterEncoding("utf-8");
		
		if("insert".equals(kc)) {
			Map<String,Object> map=new HashMap<String,Object>();

			map.put("qu_title", request.getParameter("qu_title"));
			map.put("type_id", request.getParameter("type_id"));
			map.put("begin_date", request.getParameter("begin_date"));
			map.put("end_date", request.getParameter("end_date"));
			map.put("pub_scope", request.getParameter("pub_scope"));
			map.put("qu_style", request.getParameter("qu_style"));
			map.put("memo", request.getParameter("memo"));			

			//id
			String id=UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
			map.put("qu_id", id);
			//创建人
			HttpSession session=request.getSession();
			Object user_name=session.getAttribute("user_name");
			map.put("creator_id", user_name);
			
			questionService.insert(map);
			
//			response.sendRedirect("question.do");
			
		}else if("toUpdate".equals(kc)){
			
			String qu_id=request.getParameter("qu_id");
			Map map=questionService.load(qu_id);
			request.setAttribute("map", map);
			request.getRequestDispatcher("/page/m10_question/update.jsp").forward(request, response);
			
		}else if("update".equals(kc)) {
			
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("qu_id", request.getParameter("qu_id"));
			map.put("qu_title", request.getParameter("qu_title"));
			map.put("type_id", request.getParameter("type_id"));
			map.put("begin_date", request.getParameter("begin_date"));
			map.put("end_date", request.getParameter("end_date"));
			map.put("pub_scope", request.getParameter("pub_scope"));
			map.put("qu_style", request.getParameter("qu_style"));
			map.put("memo", request.getParameter("memo"));
			
			questionService.update(map);
			response.sendRedirect("question.do");
		}else if("toDelete".equals(kc)) {
			questionService.delete(request.getParameter("qu_id"));
			
		}else if("deleteAll".equals(kc)) {
			String data=request.getParameter("data");
			String[] ids=data.split(",");
			if(ids.length>0) {
				questionService.deleteAll(ids);
			}
			
		}else {
			//得到查询条件
			String  qu_title=request.getParameter("qu_title");
			String  type_id=request.getParameter("type_id");
			String  state=request.getParameter("state");
			String  pub_scope=request.getParameter("pub_scope");
			String  qu_style=request.getParameter("qu_style");
			String  begin_date=request.getParameter("begin_date");
			String  end_date=request.getParameter("end_date");
			
			
//			封装查询条件
			Map map=new HashMap();
			map.put("qu_title",qu_title );
			map.put("type_id",type_id );
			map.put("state",state );
			map.put("pub_scope",pub_scope );
			map.put("qu_style",qu_style );
			map.put("begin_date",begin_date );
			map.put("end_date", end_date);
			
			//分页
			String  pageStr=request.getParameter("page");
			int page=1;
			if(pageStr!=null) {
				page=Integer.valueOf(pageStr);
			}
			map.put("fromNum", (page-1)*5);
			
			List<Map> list=questionService.query(map);
			
			int count=questionService.queryCount(map);
			
			
//			在请求中设置属性
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.setAttribute("count", count);
			//分发器跳转页面
			request.getRequestDispatcher("page/m10_question/list.jsp").forward(request, response);
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
