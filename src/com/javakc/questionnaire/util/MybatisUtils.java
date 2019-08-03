package com.javakc.questionnaire.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {

	static SqlSessionFactory factory = null;

	static {
		try {
			// ��ȡ���������ļ�mybatis-config.xml
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			// ����xml�����ļ�����SqlSessionFactory����
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession openSession() {
		// ͨ��SqlSessionFactory������һ��SqlSession ʵ��
		return factory.openSession();
	}
	public static SqlSession openSession(boolean flag) {
		// ͨ��SqlSessionFactory������һ��SqlSession ʵ��
		return factory.openSession(flag);
	}
}
