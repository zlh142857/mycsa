package com.hx.pwcontrol.apply;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 16:15
 *@功能:接入申请审批历史表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_user_access_history")
public class TblUserAccessHistory implements Serializable{
    private static final long serialVersionUID = -3430152312140521716L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "approveDepartment")
    private String approveDepartment;//审批部门
    @Column(name = "approveOrganization")
    private String approveOrganization;//审批机构
    @Column(name = "approveResult")
    private String approveResult;//审批结果
    @Column(name = "approveTime")
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date approveTime;//审批时间
    @Column(name = "approver")
    private String approver;//审批人
    @Column(name = "createBy")
    private String createBy;//创建人
    @Column(name = "opinion")
    private String opinion;//审批意见
    @Column(name = "updateBy")
    private String updateBy;//修改人
    @Column(name = "updateTime")
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;//修改时间
    @Column(name = "userId")
    private String userId;//用户id
}
