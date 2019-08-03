package com.javakc.questionnaire.m11_subject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.javakc.questionnaire.m11_subject.dao.SubjectDao;
import com.javakc.questionnaire.util.MybatisUtils;
import com.javakc.questionnaire.util.Tools;

public class SubjectService {

	
	public List<Map<String, Object>> query(Map<String, Object> map) {
		SqlSession session = MybatisUtils.openSession();
		SubjectDao subjectDao = session.getMapper(SubjectDao.class);
		List<Map<String, Object>> list = subjectDao.query(map);
		session.close();
		return list;
	}

	
	public void insert(Map<String, Object> map, String[] contents, String corrects) {
		// ȡ���ֶ��ύ�����session����
		SqlSession session = MybatisUtils.openSession();
		SubjectDao subjectDao = session.getMapper(SubjectDao.class);
		// ������Ŀ
		subjectDao.insert(map);

		// ����ѡ��
		// �ж��Ƿ���ѡ��
		if (contents != null) {
			String[] cs = corrects.split(",");
			for (int i = 0; i < contents.length; i++) {
				Map<String, Object> item = new HashMap<String, Object>();
				// ��Ŀѡ���id
				item.put("item_id", Tools.getUUID());
				// ��Ŀ��id
				item.put("subject_id", map.get("subject_id"));
				// ѡ�������
				item.put("item_content", contents[i]);
				// ��ѡ���Ƿ�����ȷ��
				item.put("correct", cs[i]);

				subjectDao.insertItem(item);
			}
		}

		// �ύ����
		session.commit();
		session.close();
	}

	
	public void delete(String subject_id) {
		SqlSession session = MybatisUtils.openSession(true);
		SubjectDao subjectDao = session.getMapper(SubjectDao.class);
		subjectDao.delete(subject_id);
		session.close();
	}

	
	public Map<String, Object> load(String subject_id) {
		SqlSession session = MybatisUtils.openSession();
		SubjectDao subjectDao = session.getMapper(SubjectDao.class);
		Map<String, Object> map = subjectDao.load(subject_id);
		session.close();
		return map;
	}

	/**
	 * ������Ŀid��ȡ��ѡ�����Ϣ
	 * 
	 * @param subject_id
	 *            ��Ŀid
	 * @return ѡ�����ϢList
	 */
	public List<Map<String, Object>> getItemsBySubjectId(String subject_id) {
		SqlSession session = MybatisUtils.openSession();
		SubjectDao subjectDao = session.getMapper(SubjectDao.class);

		List<Map<String, Object>> list = subjectDao.getItemsBySubjectId(subject_id);
		session.close();
		return list;
	}

	
	public void update(Map<String, Object> map, String[] contents, String[] corrects) {
		// ȡ���ֶ��ύ�����session����
		SqlSession session = MybatisUtils.openSession();
		SubjectDao subjectDao = session.getMapper(SubjectDao.class);
		// �޸���Ŀ
		subjectDao.update(map);

		// ɾ����Ŀѡ��
		subjectDao.deleteItems((String)map.get("subject_id"));
		
		// ����ѡ��
		// �ж��Ƿ���ѡ��
		if (contents != null) {
			for (int i = 0; i < contents.length; i++) {
				Map<String, Object> item = new HashMap<String, Object>();
				// ��Ŀѡ���id
				item.put("item_id", Tools.getUUID());
				// ��Ŀ��id
				item.put("subject_id", map.get("subject_id"));
				// ѡ�������
				item.put("item_content", contents[i]);
				// ��ѡ���Ƿ�����ȷ��
				item.put("correct", corrects[i]);

				subjectDao.insertItem(item);
			}
		}

		// �ύ����
		session.commit();
		session.close();

	}


	
	

	
	public void deleteAll(String[] ids) {
		SqlSession session = MybatisUtils.openSession(true);
		SubjectDao subjectDao=session.getMapper(SubjectDao.class);
		subjectDao.deleteAll(ids);
		session.close();
		
	}

	
	public List<Map> previewAll(String[] ids) {
		SqlSession session = MybatisUtils.openSession();
		SubjectDao subjectDao=session.getMapper(SubjectDao.class);
		List<Map> list = subjectDao.previewAll(ids);
		session.close();
		return list;
	}

	
	public List<Map> previewAll2(String[] ids) {
		SqlSession session = MybatisUtils.openSession();
		SubjectDao subjectDao=session.getMapper(SubjectDao.class);
		List<Map> list = subjectDao.previewAll2(ids);
		session.close();
		return list;
	}

}
