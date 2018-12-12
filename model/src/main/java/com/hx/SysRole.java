package com.hx;/*
 *//*
 *@作者:张立恒
 *@时间:2018/9/30 10:38
 *@功能:系统角色实体类
 */


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = -778206460086488219L;
    @Id
    @GeneratedValue
    private Long id; // 编号

    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:

    private String description; // 角色描述,UI界面显示使用

    private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户

    //角色 -- 权限关系：多对多关系;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="sys_role_permission",joinColumns={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="permission_id")})
    private List<SysPermission> permissions;

    // 用户 - 角色关系定义;
    /*@ManyToMany
    @JoinTable(name="sys_user_role",joinColumns={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="uid")})
    private List<UserInfo> userInfos;// 一个角色对应多个用户*/
}
