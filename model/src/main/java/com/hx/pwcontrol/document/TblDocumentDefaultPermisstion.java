package com.hx.pwcontrol.document;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 13:32
 *@功能:默认权限表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_document_default_permisstion")
public class TblDocumentDefaultPermisstion implements Serializable {
    private static final long serialVersionUID = 2745872392022612736L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "Operation")
    private String Operation;//所有的权限
    @Column(name = "OrganizationCode")
    private String OrganizationCode;//机构编码
    @Column(name = "Owner")
    private String Owner;//权限集对应的人
    @Column(name = "PermisstionType")
    private String PermisstionType;//权限集类型
    @Column(name = "Printnum")
    private String Printnum;//打印份数
    @Column(name = "SecretId")
    private String SecretId;//密级
}
