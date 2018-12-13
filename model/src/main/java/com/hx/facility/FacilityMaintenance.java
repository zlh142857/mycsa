package com.hx.facility;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 13:26
 *@功能:设备维修表
 */

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class FacilityMaintenance implements Serializable {
    private static final long serialVersionUID = -2021639892392026755L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer id;//id;

    private String facilityId; //设备编号

    private String maintenanceCause; //维修原因

    private String createUser;

    private String updateUser;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maintenanceTime; //维修时间
    @Temporal( TemporalType.TIMESTAMP )
    private Date createTime; //创建时间
    @Temporal( TemporalType.TIMESTAMP )
    private Date updateTime; //修改时间
}
