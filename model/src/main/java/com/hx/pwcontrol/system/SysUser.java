package com.hx.pwcontrol.system;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 10:21
 *@功能:人员信息表
 * 该表没有外键,所以性别,密级,状态等暂时采用和字典表关联的方式,直接保存中文
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
@Table(name="sys_user")
public class SysUser implements Serializable {
    private static final long serialVersionUID = -4461107608590129510L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//内部id;
    @Column(name = "UserId")
    private String UserId;//用户id
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "OrganizationCode")
    private String OrganizationCode;//所在部门id
    @Column(name = "UserAddress")
    private String UserAddress;//通讯地址
    @Column(name = "UserBirthDate")
    private String UserBirthDate;//出生日期
    @Column(name = "UserEmail")
    private String UserEmail;//邮箱
    @Column(name = "UserEmergentContact")
    private String UserEmergentContact;//紧急联系人
    @Column(name = "UserEnterDate")
    private String UserEnterDate;//进入现单位时间
    @Column(name = "UserEverName")
    private String UserEverName;//曾用名
    @Column(name = "UserIdCard")
    private String UserIdCard;//身份证号码
    @Column(name = "UserJobNumber")
    private String UserJobNumber;//工作证号
    @Column(name = "UserLevel")
    private String UserLevel;//等级
    @Column(name = "UserMobile")
    private String UserMobile;//手机号码
    @Column(name = "UserName")
    private String UserName;//姓名
    @Column(name = "UserNation")
    private String UserNation;//民族
    @Column(name = "UserPhoto")
    private String UserPhoto;//照片
    @Column(name = "UserPoliticalBackground")
    private String UserPoliticalBackground;//政治背景
    @Column(name = "UserPosition")
    private String UserPosition;//职务
    @Column(name = "UserSecret")
    private String UserSecret;//人员密级
    @Column(name = "UserSex")
    private String UserSex;//性别
    @Column(name = "UserState")
    private String UserState;//用户状态
    @Column(name = "UserTelephone")
    private String UserTelephone;//座机号码
    @Column(name = "UserType")
    private String UserType;//人员类型
    @Column(name = "IsImportDepartment")
    private String IsImportDepartment;//是否属于要害部门工作人员
    @Column(name = "IsSecretCharge")
    private String IsSecretCharge;//是否为定密责任人
    @Column(name = "UserAdministrationRank")
    private String UserAdministrationRank;//行政级别
    @Column(name = "UserPositionType")
    private String UserPositionType;//职位情况
    @Column(name = "UserTechnicalTitle")
    private String UserTechnicalTitle;//技术职称
    @Column(name = "Isvalid")
    private String Isvalid;//用户是否有效
    @Column(name = "Education")
    private String Education;//教育程度
    @Column(name = "UserOrder")
    private Integer UserOrder;////改字段没有备注,从字面看意思是:排序


    //shiro
    @Column(name="UserKey")
    private String UserKey; //登录时插入key;
    @Column(name = "password")
    private String password; //密码;密码默认123456

    @ManyToMany(fetch=FetchType.EAGER)//存在多对多关系,关闭懒加载,立即从数据库中进行加载数据;
    @JoinTable(name = "sys_user_role", joinColumns = { @JoinColumn(name = "UserId") }, inverseJoinColumns ={@JoinColumn(name = "RoleId") })
    //name关联表的表名,joinColumns数据库表关联的键,inverseJoinColumns实体类关联的键
    private List<SysRole> roleList;// 一个用户具有多个角色

}
