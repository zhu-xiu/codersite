package com.tensquare.recruit.dao;


import com.tensquare.recruit.pojo.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author root
 */

@Repository
public interface RecruitDao extends
        JpaRepository<Recruit,String>,
        JpaSpecificationExecutor<Recruit> {

    /**
     * 查询最新职位列表（按照创建日期将序排序）
     * @param state
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreateTimeDesc(String state);

    public List<Recruit> findTop12ByStateNotOrderByCreateTimeDesc(String state);
}
