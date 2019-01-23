package com.hx.pwcontrol.uintportal;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 16:08
 *@功能:门户接入表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_uint_portal_in")
public class TblUintPortalIn implements Serializable{
    private static final long serialVersionUID = 5442795683006985213L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "DisplayOrder")
    private Integer DisplayOrder; //排序
    @Column(name = "InOrganiztionId")
    private String InOrganiztionId; //被接入机构id
    @Column(name = "OrganiztionId")
    private String OrganiztionId; //机构id
}
