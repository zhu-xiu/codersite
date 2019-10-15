package com.tensquare.recruit.dao;
import com.tensquare.recruit.pojo.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author root
 */
@Repository
public interface EnterpriseDao extends
        JpaRepository<Enterprise,String>,
        JpaSpecificationExecutor<Enterprise> {
}
