package com.edm.base.service.impl;

import com.edm.base.dao.LabelDao;
import com.edm.base.pojo.Label;
import com.edm.base.service.LabelService;
import com.edm.common.util.SnowflakeIdWorker;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChinHeng-Chu
 * @Description
 * @create 2019-10-10 14:33
 */
@Service
public class LabelServiceImpl implements LabelService {

	@Autowired
	private LabelDao labelDao;

	@Autowired
	private SnowflakeIdWorker snowflakeIdWorker;

	/**
	 * 查询全部标签
	 */
	@Override
	public List<Label> findAll() {
		return labelDao.findAll();
	}

	/**
	 * 根据ID查询标签
	 */
	@Override
	public Label findById(String id) {
		return labelDao.findById(id).get();
	}

	/**
	 * 增加标签
	 */
	@Override
	public void add(Label label) {
		label.setId(snowflakeIdWorker.nextId()+"");
	}

	/**
	 * 修改标签
	 */
	@Override
	public void update(Label label) {
		labelDao.save(label);
	}

	/**
	 * 删除标签
	 */
	@Override
	public void deleteById(String id) {
		labelDao.deleteById(id);
	}
}

