package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.EnterpriseDao;
import com.tensquare.recruit.pojo.entity.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * @author root
 */

@Service
@Transactional
public class EnterpriseSercice {

    @Autowired
    private EnterpriseDao enterpriseDao;

    /**
     * 热门状态企业列表
     * @return
     */
    public List<Enterprise> hotlist(){
        return enterpriseDao.findByIsHot("1");
    }


}
