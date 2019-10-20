package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.pojo.entity.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author root
 */
@Service
@Transactional

public class RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    /**
     * 按照状态查询
     * @param state
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state){
        return recruitDao.findTop4ByStateOrderByCreateTimeDesc(state);
    }

    /**
     * 最新职位列表
     * @return
     */
    public List<Recruit> newList(){
        return recruitDao.findTop12ByStateNotOrderByCreateTimeDesc("0");
    }
}
