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
public class ActMsgPersonnel implements Serializable {
    private static final long serialVersionUID = 1616155896819763487L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer id;
    private Integer uid; //关联的用户id
    private String proId;//流程实例id
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
    private String workContent; //工作内容
    @Temporal( TemporalType.TIMESTAMP )
    private Date toWorkTime; //上岗时间
    @Temporal( TemporalType.TIMESTAMP )
    private Date birTime;  //出生日期
    private String deptLeader;  //部门领导
    private Integer isMiCode;  //是否涉密编号
    //离职
    private Date lPostTime;  //离职时间

    private String taskId;  //任务id
    private String taskName;  //任务名称
    private String applyUserName; //申请人
    @Temporal( TemporalType.TIMESTAMP )
    private Date createTime; //任务创建时间

    private Integer status;  //审批状态 0为正在审批中,1为审批已结束
    @Temporal( TemporalType.TIMESTAMP )
    private Date overTime; //任务结束时间
}
