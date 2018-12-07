package com.hx;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 14:27
 *@功能:数据字典父字典表
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class SysDictType implements Serializable {
    private static final long serialVersionUID = -5850051129799202190L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer dictId;//字典主键;
    private String dictName; //字典名称
    private Integer status; //状态（0正常 1停用）
    @Temporal( TemporalType.TIMESTAMP )
    private Date createTime; //创建时间
    private String remark; //备注
}
