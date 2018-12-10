package com.hx.Activiti;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/10 14:46
 *@功能:离境表
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class ActMsg implements Serializable {
    private static final long serialVersionUID = 1616155896819763487L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer id;
    private Integer uid; //关联的用户id
    //离境
    private String name; //姓名
    private String post; //职位,离岗职位,上岗职位
    private String reason;  //离境原因,离岗原因
    @Temporal( TemporalType.TIMESTAMP )
    private Date lcTime;  //出国时间
    @Temporal( TemporalType.TIMESTAMP )
    private Date backTime; //回国时间
    private String goWhere; //去往地点
    private String dept; //所在部门
    private String phone; //联系电话
    //上岗
    private String workContent;
    @Temporal( TemporalType.TIMESTAMP )
    private Date toWorkTime;
    @Temporal( TemporalType.TIMESTAMP )
    private Date birTime;
    private String deptLeader;
    private Integer isMiCode;
    //离职
    private Date lPostTime;


}
