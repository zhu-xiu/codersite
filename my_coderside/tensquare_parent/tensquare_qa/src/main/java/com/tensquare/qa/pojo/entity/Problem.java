package com.tensquare.qa.pojo.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 * @author root
 */
@Entity
@Table(name = "tb_problem")
@Data
public class Problem {

    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 问题标题
     */
    private String title;

    /**
     * 问题内容
     */
    private String content;

    /**
     * 发布日期
     */
    private Date createTime;

    /**
     * 更新日期
     */
    private Date updateTime;

    /**
     * 发布人ｉｄ
     */
    private String userId;

    /**
     * 发布人昵称
     */
    private String nickName;

    /**
     * 浏览量
     */
    private int visits;

    /**
     * 点赞数
     */
    private int thumbup;

    /**
     * 回复数
     */
    private int reply;

    /**
     * 是否解决
     */
    private String solve;

    /**
     * 最新回复人
     */
    private String replyName;

    /**
     * 最新回复时间
     */
    private Date replyTime;

}
