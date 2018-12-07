package com.hx.facility;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 13:16
 *@功能:设备信息表
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class FacilityInformation implements Serializable {
    private static final long serialVersionUID = -5795691493352346765L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer id;//id;

    private String facilityId; //设备编号

    private String companyName; //单位名称

    private String facilityName; //设备名称

    private String facilityType;  //设备类型

    private Integer miLevelCode; //设备密级

    private String facilitySubjection; //设备隶属

    private String facilityDept; //所属部门

    private String facilityLocation; //所在地,省市

    private String facilityHeader; //设备负责人

    private String headerPhone; //设备负责人联系电话

    private String facilityPlace; //设备位置

    private String createUser;  //创建人

    private String facilityDeptHeader; //设备部门领导

    private Integer facilityStatusCode; //设备状态 设备状态 0 正常使用 1登记中 2维修中 3清退中 4暂无使用
    @Temporal( TemporalType.TIMESTAMP )
    private Date firstRegisterTime; //设备初次登记时间

    private Integer isMiCode; //是否涉密 0不涉密 1涉密
    @Temporal( TemporalType.TIMESTAMP )
    private Date create_time; //创建时间
    @Temporal( TemporalType.TIMESTAMP )
    private Date update_time; //修改时间
    @Transient
    private String miLevel;
    @Transient
    private String facilityStatus;
    @Transient
    private String isMi;
}
