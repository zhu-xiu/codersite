package com.tensquare.article.service;

import com.tensquare.article.dao.ArticleDao;

import com.tensquare.article.pojo.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * @author root
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 审核文章
     * @param id
     */
    @Transactional
    public void examine(String id){
        articleDao.examine(id);
    }

    public Article findById(String id){

        //从缓存中提取
        Article article = (Article) redisTemplate.opsForValue().get("atricle_"+id);

        //如果缓存没有，则在数据库中提取
        if(article == null){
            article = articleDao.findById(id).get();
            redisTemplate.opsForValue().set("article_"+id, article);
        }
        return article;
    }

}
