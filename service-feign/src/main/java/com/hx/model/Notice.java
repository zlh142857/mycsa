package com.hx.model;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 14:10
 *@功能:公告表
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Notice implements Serializable {
    private static final long serialVersionUID = 7450682633220939784L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer noticeId;//id;
    private String noticeName;//公告内容名称
    private Integer noticeType; //公告重要程度 0 一般,1重要,2很重要
    private String noticeAuth;//公告发布人
    private Date createTime;
}
