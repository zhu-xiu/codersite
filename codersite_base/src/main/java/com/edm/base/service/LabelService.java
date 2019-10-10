package com.edm.base.service;

import com.edm.base.pojo.Label;
import java.util.List;

/**
 * @author ChinHeng-Chu
 * @Description
 * @create 2019-10-10 14:28
 */
public interface LabelService {

	/**
	 * 查询全部标签
	 * @return
	 */
	List<Label> findAll();

	/**
	 * 根据ID查询标签
	 * @param id
	 * @return
	 */
	Label findById(String id);

	/**
	 * 增加标签
	 * @param label
	 */
	void add(Label label);

	/**
	 * 修改标签
	 * @param label
	 */
	void update(Label label);

	/**
	 * 删除标签
	 * @param id
	 */
	void deleteById(String id);

}

