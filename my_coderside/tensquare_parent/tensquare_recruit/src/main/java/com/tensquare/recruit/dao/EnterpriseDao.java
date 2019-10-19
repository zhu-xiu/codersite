package com.tensquare.recruit.dao;
import com.tensquare.recruit.pojo.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author root
 */
@Repository
public interface EnterpriseDao extends
        JpaRepository<Enterprise,String>,
        JpaSpecificationExecutor<Enterprise> {
    /**
     * 根据热门状态获取企业列表
      * @param ishot
     * @return
     */
    public List<Enterprise> findByIsHot(String ishot);
}
