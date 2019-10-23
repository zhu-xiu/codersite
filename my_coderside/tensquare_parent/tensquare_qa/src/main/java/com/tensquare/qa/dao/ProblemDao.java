package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.entity.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

/**
 * @author root
 */
@Repository
public interface ProblemDao extends
        JpaRepository<Problem,String>, JpaSpecificationExecutor<Problem> {

    /**
     * 根据标签ｉｄ　查询最新问题列表
     * @param labelId
     * @param pageable
     * @return
     */
    public Page<Problem> findNewListByLabelId(String labelId, Pageable pageable);

    /**
     * 根据ｉｄ查询热门问题列表
     * @param labelId
     * @param pageable
     * @return
     */
    public Page<Problem> findHotListByLabelId(String labelId, Pageable pageable);
}
