package com.tensquare.qa.service.impl;

import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.pojo.entity.Problem;
import com.tensquare.qa.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.awt.print.Pageable;

/**
 * @author root
 */
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemDao problemDao;

    @Override
    public Page<Problem> findNewListByLabelId(String labelId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page-1, size);
        return problemDao.findNewListByLabelId(labelId, (Pageable) pageRequest);
    }
}
