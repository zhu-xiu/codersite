package com.tensquare.qa.service;

import com.tensquare.qa.pojo.entity.Problem;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author root
 */
@Service
public interface ProblemService {

    /**
     * 根据标签ｉｄ　查询问题列表
     * @param labelId
     * @param page
     * @param size
     * @return
     */
    public Page<Problem> findNewListByLabelId(String labelId, int page, int size);
}

