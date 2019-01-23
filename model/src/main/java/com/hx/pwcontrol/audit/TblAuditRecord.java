package com.hx.pwcontrol.audit;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 11:20
 *@功能:审计记录表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_audit_record")
public class TblAuditRecord implements Serializable {
    private static final long serialVersionUID = -6083436618274522271L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "Application")
    private String Application;//应用名称
    @Column(name = "AuditDescription")
    private String AuditDescription;//审计描述
    @Column(name = "BusinessId")
    private String BusinessId;//模块编号
    @Column(name = "DocumentId")
    private String DocumentId;//文档编号
    @Column(name = "DocumentType")
    private String DocumentType;//文档类型
    @Column(name = "ProcessId")
    private String ProcessId;//程序编号
    @Column(name = "QueryStr")
    private String QueryStr;//查询语句
    @Column(name = "TaskId")
    private String TaskId;//任务编号
    @Column(name = "TaskName")
    private String TaskName;//任务名称
    @Column(name = "Uri")
    private String Uri;//url地址
    @Column(name = "VistorIp")
    private String VistorIp;//访问者ip地址
    @Column(name = "AuditOperateCode")
    private String AuditOperateCode;//审计操作代码
    @Column(name = "AuditTypeCode")
    private String AuditTypeCode;//审计类型代码
    @Column(name = "OrganizationDeptCode")
    private String OrganizationDeptCode;//组织机构部门代码
    @Column(name = "OrganizationUnitCode")
    private String OrganizationUnitCode;//组织机构单位代码
    @Column(name = "UserId")
    private String UserId;//用户id
    @Column(name = "FunctionCode")
    private String FunctionCode;//功能代码
}
