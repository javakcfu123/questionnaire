package com.javakc.questionnaire.util.listener;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.javakc.questionnaire.m02_type.service.TypeService;

/**
 * Application Lifecycle Listener implementation class BaseDataListener
 *
 */
@WebListener
public class BaseDataListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public BaseDataListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	TypeService typeService=new TypeService();
    	//查询类型数据
		List<Map> typeList=typeService.queryAll(null);
		
		sce.getServletContext().setAttribute("typeList", typeList);
    	
    	
    }
	
}
