package com.hx.model.facility;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 13:33
 *@功能:设备清退表
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class FacilityClear implements Serializable {
    private static final long serialVersionUID = 1399473844500875614L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer id;//id;

    private String facilityId; //设备编号

    private String clearCause; //维修原因

    private String createUser;

    private String updateUser;

    private Date clearTime; //维修时间

    private Date createTime; //创建时间

    private Date updateTime; //修改时间
}
