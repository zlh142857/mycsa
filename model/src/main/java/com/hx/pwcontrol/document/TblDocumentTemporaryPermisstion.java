package com.hx.pwcontrol.document;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 13:39
 *@功能:临时权限集表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_document_temporary_permisstion")
public class TblDocumentTemporaryPermisstion implements Serializable {
    private static final long serialVersionUID = 1711532674608184425L;
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
    @Column(name = "EndDate")
    private String EndDate;//权限拥有期限
    @Column(name = "Printnum")
    private String Printnum;//打印份数
    @Column(name = "SecretId")
    private String SecretId;//密级
    @Column(name = "FileId")
    private String FileId;//文档id
    @Column(name = "UserId")
    private String UserId;//用户id
}
