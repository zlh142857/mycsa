package com.hx.pwcontrol.system;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 9:49
 *@功能:系统日志表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="sys_log")
public class SysLog implements Serializable {
    private static final long serialVersionUID = -2772131990059646215L;
    @Id
    @Column(unique=true,name = "id")
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "Application")
    private String Application;//所属应用
    @Column(name = "AuditLevel")
    private String AuditLevel;//审计等级
    @Column(name = "AuditType")
    private String AuditType;//审计类型
    @Column(name = "BusinessId")
    private String BusinessId;//业务id
    @Column(name = "DeptId")
    private String DeptId;//操作人所在部门id
    @Column(name = "Description")
    private String Description;//描述
    @Column(name = "DocId")
    private String DocId;//文档 id
    @Column(name = "MenuId")
    private String MenuId;//操作菜单id
    @Column(name = "ProcessId")
    private String ProcessId;//流程实例id
    @Column(name = "QueryStr")
    private String QueryStr;//请求参数
    @Column(name = "TaskId")
    private String TaskId;//任务id
    @Column(name = "TaskName")
    private String TaskName;//任务名称
    @Column(name = "UnitId")
    private String UnitId;//操作人所在机构id
    @Column(name = "Uri")
    private String Uri;//访问路径
    @Column(name = "UserId")
    private String UserId;//操作人id
    @Column(name = "VistorIp")
    private String VistorIp;//ip地址

}
