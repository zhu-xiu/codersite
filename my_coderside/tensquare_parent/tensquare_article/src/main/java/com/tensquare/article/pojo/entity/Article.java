package com.tensquare.article.pojo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * @author root
 */
@Entity
@Table(name = "tb_article")
@Data
public class Article {

    /**
     * 主键ｉｄ
     */
    @Id
    private String id;

    /**
     * 专栏ｉｄ
     */
    private String columnId;

    /**
     * 用户ｉｄ
     */
    private String userId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章封面
     */
    private String image;

    /**
     * 发表日期
     */
    private Date createTime;

    /**
     * 修改日期
     */
    private Date updateTime;

    /**
     * 是否公开   0 ：不公开　１：　公开
     */
    private String isPublic;

    /**
     * 是否置顶　　０：不置顶　　１：置顶
     */
    private String isTop;

    /**
     * 浏览量
     */
    private int visits;

    /**
     *　点赞数
     */
    private int thumbup;

    /**
     * 评论数
     */
    private int comment;

    /**
     * 审核状态　　０：未审核　　１：已审核
     */
    private String state;

    /**
     * 所属频道　　关联频道表ＩＤ
     */
    private int channelId;

    /**
     * ＵＲＬ地址
     */
    private String url;

    /**
     * 文章类型　　０：分享　　１：专栏
     */
    private String type;

}
