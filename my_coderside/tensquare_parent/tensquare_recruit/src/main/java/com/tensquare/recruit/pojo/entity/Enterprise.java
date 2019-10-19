package com.tensquare.recruit.pojo.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 数据表实体类
 * @author root
 */
@Entity
@Table(name = "tb_enterprise")
@Data

public class Enterprise {

    /**
     * ID
     */
    @Id
    private String id;

    /**
     *  企业名称
     */
    private String name;

    /**
     * 企业简介
     */
    private String summary;

    /**
     * 企业地址
     */
    private String address;

    /**
     * 标签列表，用逗号分割
     */
    private String labels;

    /**
     * 企业坐标位置，经度纬度
     */
    private String coordinate;

    /**
     * 是否热门，０：非热门　　１：热门
     */
    private String isHot;

    /**
     * LOGO
     */
    private String logo;

    /**
     * 职位数
     */
    private String jobCount;

    /**
     * URL
     */
    private String url;
}
