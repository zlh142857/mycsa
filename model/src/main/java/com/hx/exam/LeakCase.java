package com.hx.exam;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/6 16:58
 *@功能:泄密案例表
 */

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class LeakCase {
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer id;//id;
    private String caseTitle;
    private String caseContent;
    @Temporal( TemporalType.TIMESTAMP )
    private Date caseTime;
    @Temporal( TemporalType.TIMESTAMP )
    private Date createTime;
    @Temporal( TemporalType.TIMESTAMP )
    private Date updateTime;
}
