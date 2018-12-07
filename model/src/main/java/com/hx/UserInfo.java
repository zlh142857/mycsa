package com.hx;/*
 *//*
 *@作者:张立恒
 *@时间:2018/9/30 10:24
 *@功能:用户信息实体类
 */



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 2572022766469712025L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private long uid;//用户id;

    @Column(unique=true)//主键唯一
    private String username;//账号.

    private String name;//名称（昵称或者真实姓名，不同系统不同定义）

    private String password; //密码;

    private String salt;//加密密码的盐,salt主要是用来进行密码加密的，当然也可以使用明文进行编码测试，实际开发中还是建议密码进行加密。

    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.


    @ManyToMany(fetch=FetchType.EAGER)//存在多对多关系,关闭懒加载,立即从数据库中进行加载数据;
    @JoinTable(name = "sys_user_role", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "role_id") })
    //name关联表的表名,joinColumns数据库表关联的键,inverseJoinColumns实体类关联的键
    private List<SysRole> roleList;// 一个用户具有多个角色

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    /**
     * 密码盐.getCredentialsSalt()
     *
     * 这个方法重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解了
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                '}';
    }
}
