package com.hx.personnel;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 11:02
 *@功能:人员信息表
 */

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="personnel_info")
@Data
public class PersonnelInfo implements Serializable {
    private static final long serialVersionUID = 7308514336049983718L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer perId;//人员id;
    private String perName;  //人员姓名
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal( TemporalType.DATE )
    private Date birTime;  //出生日期
    private Integer sexCode; //性别
    private Integer miJiCode; //密级编码
    private String perCode;//人员编号
    private String nation; //民族
    private String poliStatus; //政治面貌
    private Integer deptCode; //部门
    private String deptLeader; //部门领导
    private String job; //职务
    private String workPhone;//办公电话
    private String phone;//手机
    private String nativePlace; //籍贯
    private String nowLive; //通讯地址
    private String contactPerson; //紧急联系人
    private String photoUrl; //头像地址
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;  //创建时间
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;  //修改时间
    @Transient
    private String sex;
    @Transient
    private String miJi;
    @Transient
    private String dept; //部门
    /*@Transient
    private MultipartFile  file; */ //头像文件
}
