package com.tensquare.recruit.dao;


import com.tensquare.recruit.pojo.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author root
 */

@Repository
public interface RecruitDao extends
        JpaRepository<Recruit,String>,
        JpaSpecificationExecutor<Recruit> {

}
