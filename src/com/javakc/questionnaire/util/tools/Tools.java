package com.javakc.questionnaire.util.tools;

import java.util.UUID;

public class Tools {
	/**
	 * 生成32位16进制的主键ID
	 * @return 主键字符串
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
}
