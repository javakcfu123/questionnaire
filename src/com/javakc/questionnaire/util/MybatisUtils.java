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
			// 读取核心配置文件mybatis-config.xml
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			// 解析xml配置文件产生SqlSessionFactory对象
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession openSession() {
		// 通过SqlSessionFactory来创建一个SqlSession 实例
		return factory.openSession();
	}
	public static SqlSession openSession(boolean flag) {
		// 通过SqlSessionFactory来创建一个SqlSession 实例
		return factory.openSession(flag);
	}
}
