package com.hx.pwcontrol.approval;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 11:11
 *@功能:审批角色表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_approval_role")
public class TblApprovalRole implements Serializable {
    private static final long serialVersionUID = -2596315946664949195L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "DeleteFlg")
    private String DeleteFlg;//删除标记
    @Column(name = "RoleCode")
    private String RoleCode;//角色编码
    @Column(name = "RoleExplain")
    private String RoleExplain;//描述
    @Column(name = "RoleName")
    private String RoleName;//角色名称
    @Column(name = "RoleOrgId")
    private String RoleOrgId;//所属机构
}
