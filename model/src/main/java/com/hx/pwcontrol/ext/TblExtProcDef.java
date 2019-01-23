package com.hx.pwcontrol.ext;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 13:43
 *@功能:流程定义表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_ext_proc_def")
public class TblExtProcDef implements Serializable {
    private static final long serialVersionUID = 4730660451695558254L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "ProcBpmn")
    private String ProcBpmn;//流程文件
    @Column(name = "ProcBpmnPath")
    private String ProcBpmnPath;//流程文件路径
    @Column(name = "ProcCode")
    private String ProcCode;//流程编号
    @Column(name = "ProcDefId")
    private String ProcDefId;//流程定义id
    @Column(name = "ProcName")
    private String ProcName;//流程名称
    @Column(name = "SystemId")
    private String SystemId;//系统ID（外部接入预留）
    @Column(name = "SystemName")
    private String SystemName;//系统名称（外部接入预留）
    @Column(name = "SystemUrl")
    private String SystemUrl;//系统URL（外部接入预留）
    @Column(name = "ApplicationCode")
    private String ApplicationCode;//应用编号
    @Column(name = "ProcInstanceId")
    private String ProcInstanceId;//流程实例ID
    @Column(name = "DeleteFlg")
    private String DeleteFlg;//有效标识
    @Column(name = "OrgId")
    private String OrgId;//所属机构ID
}
