package com.hx;/*
 *//*
 *@作者:张立恒
 *@时间:2018/9/30 10:24
 *@功能:用户信息实体类
 */



import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Data
@Entity
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 2572022766469712025L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer uid;//用户id;

    @Column(unique=true)//主键唯一
    private String username;//账号.  key

    private String personnelName;//用户真实姓名

    private String password; //密码;

    private String salt;//加密密码的盐,salt主要是用来进行密码加密的，当然也可以使用明文进行编码测试，实际开发中还是建议密码进行加密。

    private Integer deptCode; //部门编号

    private String deptLeader;  //部门领导姓名

    private Integer personnelId; //关联的人员信息库id
    @Transient
    private String dept;  //所在部门


    @ManyToMany(fetch=FetchType.EAGER)//存在多对多关系,关闭懒加载,立即从数据库中进行加载数据;
    @JoinTable(name = "sys_user_role", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "role_id") })
    //name关联表的表名,joinColumns数据库表关联的键,inverseJoinColumns实体类关联的键
    private List<SysRole> roleList;// 一个用户具有多个角色


    /**
     * 密码盐.getCredentialsSalt()
     *
     * 这个方法重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解了
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
}
