package com.hx.Activiti;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/10 14:46
 *@功能:离境表
 */

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="act_msg_personnel")
public class ActMsgPersonnel implements Serializable {
    private static final long serialVersionUID = 1616155896819763487L;
    @Id
    @Column(unique=true,name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer id;
    @Column(name = "uid")
    private Integer uid; //关联的用户id
    @Column(name = "pro_id")
    private String proId;//流程实例id
    //离境
    @Column(name = "name")
    private String name; //姓名
    @Column(name = "post")
    private String post; //职位,离岗职位,上岗职位
    @Column(name = "reason")
    private String reason;  //离境原因,离岗原因
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "lc_time")
    private Date lcTime;  //出国时间
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "back_time")
    private Date backTime; //回国时间
    @Column(name = "go_where")
    private String goWhere; //去往地点
    @Column(name = "dept")
    private String dept; //所在部门
    @Column(name = "phone")
    private String phone; //联系电话
    //上岗
    @Column(name = "work_content")
    private String workContent; //工作内容
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "to_work_time")
    private Date toWorkTime; //上岗时间
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "bir_time")
    private Date birTime;  //出生日期
    @Column(name = "dept_leader")
    private String deptLeader;  //部门领导
    @Column(name = "is_mi_code")
    private Integer isMiCode;  //是否涉密编号
    //离职
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "l_post_time")
    private Date lPostTime;  //离职时间
    @Column(name = "task_id")
    private String taskId;  //任务id
    @Column(name = "task_name")
    private String taskName;  //任务名称
    @Column(name="apply_user_name")
    private String applyUserName; //申请人
    @Temporal( TemporalType.TIMESTAMP )
    @Column(name = "create_time")
    private Date createTime; //任务创建时间
    @Column(name = "status")
    private Integer status;  //审批状态 0为正在审批中,1为审批已结束
    @Temporal( TemporalType.TIMESTAMP )
    @Column(name = "over_time")
    private Date overTime; //任务结束时间
}
