package com.hx.facility;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 13:30
 *@功能:设备使用登记表
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class FacilityUseInformation implements Serializable {
    private static final long serialVersionUID = -5415680114854152418L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer id;//id;

    private String facilityId; //设备编号

    private String createUser;

    private String updateUser;
    @Temporal( TemporalType.TIMESTAMP )
    private Date firstUseTime; //设备初次使用时间
    @Temporal( TemporalType.TIMESTAMP )
    private Date createTime;
    @Temporal( TemporalType.TIMESTAMP )
    private Date updateTime;
}
