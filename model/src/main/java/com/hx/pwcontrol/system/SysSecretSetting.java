package com.hx.pwcontrol.system;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 10:15
 *@功能:人员密级改变规则表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="sys_secret_setting")
public class SysSecretSetting implements Serializable {
    private static final long serialVersionUID = 9029260969266164306L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "Checkcycle")
    private String Checkcycle;//监测周期
    @Column(name = "Createuser")
    private String Createuser;//创建人
    @Column(name = "Readnum")
    private Integer Readnum;//阅读份数
    @Column(name = "SecretId")
    private String SecretId;//人员密级
    @Column(name = "UnitId")
    private String UnitId;//机构id
}
