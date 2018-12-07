package com.hx;/*
 *//*
 *@作者:张立恒
 *@时间:2018/9/30 10:47
 *@功能:权限实体类
 */



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
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

    @ManyToMany
    @JoinTable(name="sys_role_permission",joinColumns={@JoinColumn(name="id")},inverseJoinColumns={@JoinColumn(name="permission_id")})
    private List<SysRole> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", parentId=" + parentId +
                ", index='" + index + '\'' +
                ", available=" + available +
                ", roles=" + roles +
                '}';
    }
}
