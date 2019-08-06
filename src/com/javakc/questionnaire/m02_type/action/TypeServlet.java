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
 * 问卷 - 表现层
 */
@WebServlet("/type.do")
public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//注入逻辑层接口
	TypeService typeService=new TypeService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String kc=request.getParameter("kc");
		request.setCharacterEncoding("utf-8");
		
		if("insert".equals(kc)) {
			Map<String,Object> map=new HashMap<String,Object>();
			//类型名称
			String type_name=request.getParameter("type_name");
			map.put("type_name", type_name);
			//判断名称是否重复
			if(this.typeService.queryName(type_name)>0) {
				//设置响应的字符集
				response.setCharacterEncoding("utf-8");
				//设置响应的内容
				response.getWriter().append("重复");	
				
			}else {
				//类型id
				String id=Tools.getUUID();
				map.put("type_id", id);
				
				//当前登录人
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
			//类型名称
			map.put("type_name", request.getParameter("type_name"));
			
			//当前登录人
			HttpSession session=request.getSession();
			Object user_name=session.getAttribute("user_name");
			map.put("update_id", user_name);
			
			typeService.update(map);
			
		}else if("delete".equals(kc)) {
			String type_id=request.getParameter("type_id");
			
	    	//删除
			typeService.delete(type_id);
			
			
		}else if("init_type".equals(kc)) {
	    	//查询类型数据
			List<Map> typeList=typeService.queryAll(null);
			this.getServletContext().setAttribute("typeList", typeList);
			
		}else {
			//得到查询条件
			//名称关键字
			String type_name=request.getParameter("type_name");
			//创建人
			String creator_id=request.getParameter("creator_id");
			//创建开始日期
			String start=request.getParameter("start");
			//创建结束日期
			String end=request.getParameter("end");
			
//			封装查询条件
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("type_name", type_name);
			map.put("creator_id", creator_id);
			map.put("start", start);
			map.put("end", end);
			
			//分页
			String  pageStr=request.getParameter("page");
			int page=1;
			if(pageStr!=null) {
				page=Integer.valueOf(pageStr);
			}
			map.put("fromNum", (page-1)*5);
			
			
			List<Map> list=typeService.query(map);
			
			int count=typeService.queryCount(map);
//			在请求中设置属性
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.setAttribute("count", count);
			//分发器跳转页面
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
