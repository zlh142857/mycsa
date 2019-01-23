package com.hx.pwcontrol.system;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/16 9:33
 *@功能:人员亲属表,自建表,和数据所数据库表不一致,因为数据所暂时没有提供这张表的结构
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="sys_user_family")
public class SysUserFamily implements Serializable {
    private static final long serialVersionUID = 4415764962284123221L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Column(name = "UserId")
    private String UserId;//用户id
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "Creator")
    private String Creator;//创建人
    @Column(name = "familyName")
    private String familyName;//亲属名称
    @Column(name = "relation")
    private String relation; //关系
    @Column(name = "numberPhone")
    private String numberPhone; //手机号
}
