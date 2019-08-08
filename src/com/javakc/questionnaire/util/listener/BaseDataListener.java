package com.javakc.questionnaire.util.listener;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.javakc.questionnaire.m02_type.service.TypeService;

/**
 * Application Lifecycle Listener implementation class BaseDataListener
 * webӦ�õļ�������
 */
@WebListener
public class BaseDataListener implements ServletContextListener {
	/**
     * webӦ������ʱ��ִ�д˷���
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	//ȡ���߼���api
    	TypeService typeService=new TypeService();
    	
    	//�����߼����ѯ��������
		List<Map> typeList=typeService.queryAll(null);
		
		//����ѯ�������ݣ��洢��SevletContext��Χ������webӦ���ڹ������ݣ�
		sce.getServletContext().setAttribute("typeList", typeList);
    	
    	
    }
    
	/**
     * webӦ������ʱ��ִ�д˷���
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	
	
}
