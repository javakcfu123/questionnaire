package com.javakc.questionnaire.vo;

import java.util.List;
//题目实体类
public class SubjectEntity {
	private String subject_id;
	private String qu_id;
	private String subject_title;
	//题目类型
	private String subject_type;
	private String subject_score;
	private String subject_must;
	private String subject_desc;
	
	//一对多关系
	private List<ItemEntity> items;

	public String getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

	public String getQu_id() {
		return qu_id;
	}

	public void setQu_id(String qu_id) {
		this.qu_id = qu_id;
	}

	public String getSubject_title() {
		return subject_title;
	}

	public void setSubject_title(String subject_title) {
		this.subject_title = subject_title;
	}

	public String getSubject_type() {
		return subject_type;
	}

	public void setSubject_type(String subject_type) {
		this.subject_type = subject_type;
	}

	public String getSubject_score() {
		return subject_score;
	}

	public void setSubject_score(String subject_score) {
		this.subject_score = subject_score;
	}

	public String getSubject_must() {
		return subject_must;
	}

	public void setSubject_must(String subject_must) {
		this.subject_must = subject_must;
	}

	public List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

	public String getSubject_desc() {
		return subject_desc;
	}

	public void setSubject_desc(String subject_desc) {
		this.subject_desc = subject_desc;
	}

	@Override
	public String toString() {
		return "SubjectEntity [subject_id=" + subject_id + ", qu_id=" + qu_id + ", subject_title=" + subject_title
				+ ", subject_type=" + subject_type + ", subject_score=" + subject_score + ", subject_must="
				+ subject_must + ", subject_desc=" + subject_desc + "]";
	}
}
