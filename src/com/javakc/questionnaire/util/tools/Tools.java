package com.javakc.questionnaire.util.tools;

import java.util.UUID;

public class Tools {
	/**
	 * ����32λ16���Ƶ�����ID
	 * @return �����ַ���
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
}
