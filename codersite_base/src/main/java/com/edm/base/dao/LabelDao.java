package com.edm.base.dao;

import com.edm.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author ChinHeng-Chu
 * @Description
 * @create 2019-10-10 14:26
 */
@Repository
public interface LabelDao extends
		JpaRepository<Label,String>,
		JpaSpecificationExecutor<Label> {

}

