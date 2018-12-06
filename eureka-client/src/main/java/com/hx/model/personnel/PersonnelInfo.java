package com.hx.model.personnel;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 11:02
 *@功能:人员信息表
 */

import lombok.Data;

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
    @Temporal( TemporalType.TIMESTAMP )
    private Date birTime;  //出生日期
    private Integer sexCode; //性别
    private Integer miTypeCode;  //涉密类型0绝密 1机密 2秘密
    private String miJob; //涉密岗位
    private Integer workStatusCode; //任职状态 0在职 1离职
    private String phone;  //联系电话
    private String poliStatus;  //政治面貌
    @Temporal( TemporalType.TIMESTAMP )
    private Date createTime;  //创建时间
    private String unempPer; //待岗人
    private Integer deptCode; //所在部门编码
    private String job; //职务
    private String location; //所在地
    private String deptLeader; //部门领导人
    private Integer ifJiyaoCode;  //是否机要人员 0是 1不是
    private Integer ifMiCode;  //是否涉密 0不涉密 1涉密
    private String familyName; //亲属名称
    private String familyType; //亲属关系
    private String familyPhone; //亲属电话
    private String nowLive; //现居住地址
    @Temporal( TemporalType.TIMESTAMP )
    private Date  updateTime;  //修改时间
    @Transient
    private String sex;
    @Transient
    private String miType;
    @Transient
    private String workStatus;
    @Transient
    private String dept;
    @Transient
    private String ifJiyao;
    @Transient
    private String ifMi;

}
