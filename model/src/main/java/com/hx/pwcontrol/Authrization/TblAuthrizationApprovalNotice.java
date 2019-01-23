package com.hx.pwcontrol.Authrization;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 13:27
 *@功能:权限审批通知表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_authrization_approval_notice")
public class TblAuthrizationApprovalNotice implements Serializable {
    private static final long serialVersionUID = -1523011584827232890L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="CreateTime")
    private Date CreateTime; //创建时间
    @Column(name="ApprovalId")
    private String ApprovalId;//申请id
    @Column(name="ApprovalState")
    private String ApprovalState;//审批状态
    @Column(name="state")
    private String state;//通知状态
    @Column(name="userId")
    private String userId;//权限申请人
}
