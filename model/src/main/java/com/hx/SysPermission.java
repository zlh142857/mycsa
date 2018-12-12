package com.hx;/*
 *//*
 *@作者:张立恒
 *@时间:2018/9/30 10:47
 *@功能:权限实体类
 */



import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -3888124148318399177L;
    @Id
    @GeneratedValue
    private long id;//主键.
    private String name;//名称.

    @Column(columnDefinition="enum('menu','button')") //columnDefinition设置默认值
    private String resourceType;//资源类型，[menu|button]

    private String url;//资源接口路径.

    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view

    private Long parentId; //导航父id

    private String index;//页面路径

    private Boolean available = Boolean.FALSE;

    /*@ManyToMany
    @JoinTable(name="sys_role_permission",joinColumns={@JoinColumn(name="id")},inverseJoinColumns={@JoinColumn(name="permission_id")})
    private List<SysRole> roles;*/


}
