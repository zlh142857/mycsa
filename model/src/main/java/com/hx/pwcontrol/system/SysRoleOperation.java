package com.hx.pwcontrol.system;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 10:11
 *@功能:角色菜单关联表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="sys_role_operation")
public class SysRoleOperation implements Serializable {
    private static final long serialVersionUID = 3097167286768900885L;
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
    @Column(name = "MenuOperation")
    private String MenuOperation;//对菜单的操作
    @Column(name = "RoleId")
    private String RoleId;//角色id
}
