package com.hx.pwcontrol.uintportal;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 16:09
 *@功能:本机构门户设置表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_uint_portal_setting")
public class TblUintPortalSetting implements Serializable{
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "MenuId")
    private String MenuId;//菜单id
    @Column(name = "OrganiztionId")
    private String OrganiztionId;//机构id
    @Column(name = "PortalOpen")
    private String PortalOpen;//开放标识
    @Column(name = "PortalUrl")
    private String PortalUrl;//链接
}
