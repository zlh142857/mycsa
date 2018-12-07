package com.hx;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 14:15
 *@功能:法院字典表
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class AreaCode implements Serializable {
    private static final long serialVersionUID = 5157126164161746785L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer areaId;//导航菜单id;
    private String areaName; //法院名称
    private Integer areaType; //法院类型：0--最高人民法院 1--省级法院 2--市级法院 3--县级法院;
    private Integer parentId; //父节点id
    @Temporal( TemporalType.TIMESTAMP )
    private Date createTime;
}
