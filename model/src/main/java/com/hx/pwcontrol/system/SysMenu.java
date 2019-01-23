package com.hx.pwcontrol.system;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 9:56
 *@功能:系统菜单表,其实就是权限表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="sys_menu")
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 8945022412853407716L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "MenuImage")
    private String MenuImage;//菜单图标
    @Column(name = "MenuLevel")
    private String MenuLevel;//菜单等级
    @Column(name = "MenuName")
    private String MenuName;//菜单名称
    @Column(name = "MenuVisitLink")
    private String MenuVisitLink;//访问链接
    @Column(name = "MenuGroup")
    private String MenuGroup;//菜单分组
    @Column(name = "MenuOrder")
    private Integer MenuOrder;//排序
    @Column(name = "MenuHaveChild")
    private String MenuHaveChild;//是否有子节点
    @Column(name = "IsDisplay")
    private String IsDisplay;//是否有效
    @Column(name = "MenuType")
    private String MenuType;//菜单类型
    @Column(name = "MenuImageLarge")
    private String MenuImageLarge;//菜单大图标

    //shiro
    /*权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
    起一个权限说明作用
    前端表单权限申请时,可以用户输入拥有权限范围:增删改查 格式为:菜单名:add/update/select/view,该字符串可以作为permission的值
    使用注解@RequiresPermissions("")
    权限中拥有该值得用户才能访问,避免用户知道访问路径直接访问的情况,这样就算知道路径也不能访问

    @RequiresPermissions({"file:read", "write:aFile.txt"} )
    void someMethod();
    要求subject中必须同时含有file:read和write:aFile.txt的权限才能执行方法someMethod()。
    * */
    @Column(name = "permission")
    private String permission;
}
