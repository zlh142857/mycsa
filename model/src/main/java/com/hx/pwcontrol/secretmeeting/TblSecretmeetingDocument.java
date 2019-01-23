package com.hx.pwcontrol.secretmeeting;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 15:21
 *@功能:涉密会议文件表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_secretmeeting_document")
public class TblSecretmeetingDocument implements Serializable{
    private static final long serialVersionUID = 5661120813819351207L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "DocumentId")
    private String DocumentId;//文档id
    @Column(name = "SubscribeMeetingId")
    private String SubscribeMeetingId;//关联id
    @Column(name = "UserId")
    private String UserId;//上传人
}
