package com.tensquare.recruit.pojo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 数据表实体类
 * @author root
 * @create 2019.10.15
 */
@Entity
@Table(name = "tb_recruit")
@Data

public class Recruit {

    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 职位名称
     */
    private String jobName;

    /**
     * 薪资范围
     */
    private String salary;

    /**
     * 经验要求
     */
    private String experience;

    /**
     * 学历要求
     */
    private String education;

    /**
     * 任职方式
     */
    private String type;

    /**
     * 办公地址
     */
    private String address;

    /**
     * 企业ＩＤ
     */
    private String eid;

    /**
     * 发布时间
     */
    private Date createTime;

    /**
     * 状态 0关闭1开启2推荐
     */
    private String state;

    /**
     * 原网址
     */
    private String url;

    /**
     * 标签
     */
    private String label;

    /**
     * 职位描述
     */
    private String content1;

    /**
     * 职位要求
     */
    private String content2;
}
