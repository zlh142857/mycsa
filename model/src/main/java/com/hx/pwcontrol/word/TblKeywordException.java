package com.hx.pwcontrol.word;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 14:20
 *@功能:关键词异常表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_keyword_exception")
public class TblKeywordException {
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "BusinessId")
    private String BusinessId;//业务id
    @Column(name = "IsRead")
    private String IsRead;//是否已读
    @Column(name = "KeywordContent")
    private String KeywordContent;//关键词内容
    @Column(name = "ReadUser")
    private String ReadUser;//已读用户
    @Column(name = "ReadUserOrg")
    private String ReadUserOrg;//已读用户部门
    @Column(name = "Creator")
    private String Creator;//业务操作人
    @Column(name = "DeptId")
    private String DeptId;//业务操作人所属部门
    @Column(name = "MenuId")
    private String MenuId;//业务类型
    @Column(name = "SecretId")
    private String SecretId;//业务密级
    @Column(name = "SecretLevel")
    private String SecretLevel;//关键词密级
    @Column(name = "UnitId")
    private String UnitId;//业务操作人所属机构
    @Column(name = "documentId")
    private String documentId;//该字段没有备注,字面意思是:关联文档id
    @Column(name = "documentName")
    private String documentName;//该字段没有备注,字面意思是:关联文档名称
}
