package com.hx.pwcontrol.system;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 10:00
 *@功能:组织机构表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="sys_organization")
public class SysOrganization implements Serializable {
    private static final long serialVersionUID = 4580715466760983339L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//内部id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "OrganizationCode")
    private String OrganizationCode;//组织机构代码
    @Column(name = "OrganizationDesc")
    private String OrganizationDesc;//描述
    @Column(name = "OrganizationIsvalid")
    private String OrganizationIsvalid;//组织机构是否有效
    @Column(name = "OrganizationLevel")
    private Integer OrganizationLevel;//组织机构等级
    @Column(name = "OrganizationName")
    private String OrganizationName;//组织机构名称
    @Column(name = "OrganizationOrder")
    private Integer OrganizationOrder;//排序
    @Column(name = "OrganizationParentCode")
    private String OrganizationParentCode;//组织机构的父级代码
    @Column(name = "OrganizationType")
    private String OrganizationType;//组织机构类型
    @Column(name = "OrganizationAddress")
    private String OrganizationAddress;//组织机构所在地
    @Column(name = "OrganizationArea")
    private String OrganizationArea;//组织机构所属地区
    @Column(name = "OrganizationCharge")
    private String OrganizationCharge;//负责人
    @Column(name = "OrganizationCity")
    private String OrganizationCity;//所属城市
    @Column(name = "OrganizationProvince")
    private String OrganizationProvince;//所属省份
    @Column(name = "OrganizationStreet")
    private String OrganizationStreet;//所属街道
    @Column(name = "OrganizationTown")
    private String OrganizationTown;//所属乡镇
    @Column(name = "CreateUserId")
    private String CreateUserId;//创建人id
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "ModifyTime")
    private Date ModifyTime;
    @Column(name = "ModifyUserId")
    private String ModifyUserId;//修改人id
    @Column(name = "OrganizationPhone")
    private String OrganizationPhone;//机构电话
    @Column(name = "SecretLevel")
    private String SecretLevel;//所属密级
}
