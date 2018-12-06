package com.hx.model;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 14:21
 *@功能:数据字典子字典
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class SysDictData implements Serializable {
    private static final long serialVersionUID = -4785213674837938478L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer dictCode;//字典编码;
    private Integer dictSort; //字典排序
    private String dictLabel; //字典标签 男女
    private Integer dictId; //父字典类型编码
    @Temporal( TemporalType.TIMESTAMP )
    private Date createTime;
    private String remark; //备注
}
