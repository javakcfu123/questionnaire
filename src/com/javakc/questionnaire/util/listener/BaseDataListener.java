package com.javakc.questionnaire.util.listener;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.javakc.questionnaire.m02_type.service.TypeService;

/**
 * Application Lifecycle Listener implementation class BaseDataListener
 * web应用的监听器，
 */
@WebListener
public class BaseDataListener implements ServletContextListener {
	/**
     * web应用启动时，执行此方法
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	//取得逻辑层api
    	TypeService typeService=new TypeService();
    	
    	//调用逻辑层查询类型数据
		List<Map> typeList=typeService.queryAll(null);
		
		//将查询到的数据，存储在SevletContext范围（整个web应用内共享数据）
		sce.getServletContext().setAttribute("typeList", typeList);
    	
    	
    }
    
	/**
     * web应用销毁时，执行此方法
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	
	
}
