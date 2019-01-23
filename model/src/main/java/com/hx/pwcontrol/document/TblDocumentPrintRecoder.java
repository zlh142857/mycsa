package com.hx.pwcontrol.document;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 13:34
 *@功能:文档打印记录表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_document_print_recoder")
public class TblDocumentPrintRecoder implements Serializable {
    private static final long serialVersionUID = 358825712068370644L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "DeptId")
    private String DeptId;//部门id
    @Column(name = "FileId")
    private String FileId;//文档id
    @Column(name = "UnitId")
    private String UnitId;//机构id
    @Column(name = "UserId")
    private String UserId;//用户id
}
