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
		// 取得手动提交事务的session对象
		SqlSession session = MybatisUtils.openSession();
		SubjectDao subjectDao = session.getMapper(SubjectDao.class);
		// 新增题目
		subjectDao.insert(map);

		// 新增选项
		// 判断是否有选项
		if (contents != null) {
			String[] cs = corrects.split(",");
			for (int i = 0; i < contents.length; i++) {
				Map<String, Object> item = new HashMap<String, Object>();
				// 题目选项的id
				item.put("item_id", Tools.getUUID());
				// 题目的id
				item.put("subject_id", map.get("subject_id"));
				// 选项的内容
				item.put("item_content", contents[i]);
				// 此选项是否是正确答案
				item.put("correct", cs[i]);

				subjectDao.insertItem(item);
			}
		}

		// 提交事务
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
	 * 根据题目id，取得选项的信息
	 * 
	 * @param subject_id
	 *            题目id
	 * @return 选项的信息List
	 */
	public List<Map<String, Object>> getItemsBySubjectId(String subject_id) {
		SqlSession session = MybatisUtils.openSession();
		SubjectDao subjectDao = session.getMapper(SubjectDao.class);

		List<Map<String, Object>> list = subjectDao.getItemsBySubjectId(subject_id);
		session.close();
		return list;
	}

	
	public void update(Map<String, Object> map, String[] contents, String[] corrects) {
		// 取得手动提交事务的session对象
		SqlSession session = MybatisUtils.openSession();
		SubjectDao subjectDao = session.getMapper(SubjectDao.class);
		// 修改题目
		subjectDao.update(map);

		// 删除题目选项
		subjectDao.deleteItems((String)map.get("subject_id"));
		
		// 新增选项
		// 判断是否有选项
		if (contents != null) {
			for (int i = 0; i < contents.length; i++) {
				Map<String, Object> item = new HashMap<String, Object>();
				// 题目选项的id
				item.put("item_id", Tools.getUUID());
				// 题目的id
				item.put("subject_id", map.get("subject_id"));
				// 选项的内容
				item.put("item_content", contents[i]);
				// 此选项是否是正确答案
				item.put("correct", corrects[i]);

				subjectDao.insertItem(item);
			}
		}

		// 提交事务
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
