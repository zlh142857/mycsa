package com.hx.pwcontrol.approval;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 11:15
 *@功能:审批角色人员关联表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_approval_role_relation")
public class TblApprovalRoleRelation implements Serializable {
    private static final long serialVersionUID = -7118204110468889385L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="")
    private Date CreateTime; //创建时间
    @Column(name="RoleId")
    private String RoleId;//审批角色id
    @Column(name="UserId")
    private String UserId;//人员id
}
