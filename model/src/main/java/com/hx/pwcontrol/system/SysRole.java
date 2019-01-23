package com.hx.pwcontrol.system;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 10:08
 *@功能:系统角色表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="sys_role")
public class SysRole implements Serializable {
    private static final long serialVersionUID = 2710637029295357601L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "OrganizationCode")
    private String OrganizationCode;//角色所属机构
    @Column(name = "RoleDescription")
    private String RoleDescription;//角色描述
    @Column(name = "RoleIsDelete")
    private String RoleIsDelete;//角色状态(删除标记)
    @Column(name = "RoleName")
    private String RoleName;//角色名称
    @Column(name = "RoleType")
    private String RoleType;//角色类型
    @Column(name = "RoleCode")
    private String RoleCode;//角色代码

    //shiro
    //角色 -- 权限关系：多对多关系;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="sys_menu",joinColumns={@JoinColumn(name="RoleId")},inverseJoinColumns={@JoinColumn(name="MenuId")})
    private List<SysMenu> menuList;
}
