package com.hx.pwcontrol.audit;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 11:24
 *@功能:审计类型表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_audit_type")
public class TblAuditType implements Serializable {
    private static final long serialVersionUID = -8118945222150462998L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="CreateTime")
    private Date CreateTime; //创建时间
    @Column(name="AuditCode")
    private String AuditCode;//审计类型代码
    @Column(name="AuditName")
    private String AuditName;//审计类型名称
    @Column(name="AuditParentCode")
    private String AuditParentCode;//父代码
}
