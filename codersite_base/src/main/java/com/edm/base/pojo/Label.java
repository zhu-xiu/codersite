package com.edm.base.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author ChinHeng-Chu
 * @Description
 * @create 2019-10-10 14:21
 */
@Entity
@Table(name = "cs_label")
@Data
public class Label {

	/**
	 * 主键
	 */
	@Id
	private String id;
	/**
	 * 标签名称
	 */
	private String labelname;
	/**
	 * 状态
	 */
	private String state;
	/**
	 * 使用数量
	 */
	private Long count;
	/**
	 * 关注数
	 */
	private Long fans;
	/**
	 * 是否推荐
	 */
	private String recommend;


}

