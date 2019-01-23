package com.hx.pwcontrol.Authrization;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 13:18
 *@功能:权限申请表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_authrization_approval")
public class TblAuthrizationApproval implements Serializable {
    private static final long serialVersionUID = 5295479179747049350L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "Applicant")
    private String Applicant;//申请人
    @Column(name = "ApplyDays")
    private String ApplyDays;//申请天数
    @Column(name = "ApplyPermissions")
    private String ApplyPermissions;//要申请的权限
    @Column(name = "ApplyReason")
    private String ApplyReason;//申请原因
    @Column(name = "ApprovalPeopleOpinion")
    private String ApprovalPeopleOpinion;//审批人意见
    @Column(name = "Document")
    private String Document;//文档id
    @Column(name = "DocumentSecret")
    private String DocumentSecret;//文档密级
    @Column(name = "OwnePrintnum")
    private String OwnePrintnum;//已经有的打印份数
    @Column(name = "OwnedPermissions")
    private String OwnedPermissions;//已经拥有的权限
    @Column(name = "Printnum")
    private String Printnum;//打印份数
    @Column(name = "Remark")
    private String Remark;//备注
    @Column(name = "UrgentDegree")
    private String UrgentDegree;//紧急程度
    @Column(name = "fileType")
    private String fileType;//文件种类
    @Column(name = "processInstanceId")
    private String processInstanceId;//流程实例id
}
