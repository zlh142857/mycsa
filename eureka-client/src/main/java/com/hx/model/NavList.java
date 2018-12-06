package com.hx.model;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 14:13
 *@功能:导航菜单表
 */

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class NavList {
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer navId;//导航菜单id;
    private String navName; //导航菜单名称
    private Integer navNode; //导航的节点
    private String navUrl; //首页导航路径
    @Temporal( TemporalType.TIMESTAMP )
    private Date createTime;
}
