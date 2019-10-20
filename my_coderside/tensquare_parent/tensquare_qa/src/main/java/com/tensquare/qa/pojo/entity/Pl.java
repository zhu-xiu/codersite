package com.tensquare.qa.pojo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author root
 * 问答标签中间表
 */
@Entity
@Table(name = "tb_pl")
@Data
public class Pl {

    /**
     * 问题ｉｄ
     */
    @Id
    private String problemId;

    /**
     * 标签ｉｄ
     */

    private String labelId;
}
