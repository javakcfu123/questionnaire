package com.javakc.questionnaire.vo;
/**
 * 选项实体类
 * @author baker
 *
 */
public class ItemEntity {

	private String item_id;
	private String item_content;
	
	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getItem_content() {
		return item_content;
	}

	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}


	@Override
	public String toString() {
		return "ItemEntity [item_id=" + item_id + ", item_content=" + item_content 
				+ "]";
	}

	

}