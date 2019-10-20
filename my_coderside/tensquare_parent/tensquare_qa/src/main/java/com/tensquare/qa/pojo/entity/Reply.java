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
@Table(name = "tb_reply")
@Data
public class Reply {

    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 问题ｉｄ
     */
    private String problemId;

    /**
     * 回单内容
     */
    private String content;

    /**
     * 回答日期
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 回答人ｉｄ
     */
    private String userId;

    /**
     * 回答人昵称
     */
    private String nickName;

}

