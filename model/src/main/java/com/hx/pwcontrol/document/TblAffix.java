package com.hx.pwcontrol.document;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 11:08
 *@功能:系统附件表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_affix")
public class TblAffix implements Serializable {
    private static final long serialVersionUID = -5672300560195234272L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "attachmentId")
    private String attachmentId;//文档库关联id
    @Column(name = "fileName")
    private String fileName;//文件名称
    @Column(name = "relationId")
    private String relationId;//邮件id
    @Column(name = "status")
    private String status;//文件状态
}
