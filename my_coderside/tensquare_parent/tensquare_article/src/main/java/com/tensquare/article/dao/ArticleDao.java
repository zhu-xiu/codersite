package com.tensquare.article.dao;

import com.tensquare.article.pojo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author root
 */
@Repository
public interface ArticleDao extends
        JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {


    /**
     * 审核
     * @param id
     */
    @Modifying
    @Query("update Article set state='1' where id = ?1 ")
    public void examine(String id);

}
