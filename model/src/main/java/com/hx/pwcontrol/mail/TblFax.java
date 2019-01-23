package com.hx.pwcontrol.mail;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 14:06
 *@功能:传真信息表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_fax")
public class TblFax implements Serializable {
    private static final long serialVersionUID = 3410377628286095295L;
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
    @Column(name = "faxContent")
    private String faxContent;//传真内容
    @Column(name = "sendStatus")
    private String sendStatus;//发送状态
    @Column(name = "faxTitle")
    private String faxTitle;//传真标题
    @Column(name = "fileName")
    private String fileName;//文件名称
    @Column(name = "receiveOrgCode")
    private String receiveOrgCode;//接收部门
    @Column(name = "receiveTime")
    private String receiveTime;//接收时间
    @Column(name = "receiveUserId")
    private String receiveUserId;//接收人id
    @Column(name = "sendOrgCode")
    private String sendOrgCode;//发送人部门
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "sendTime")
    private Date sendTime;//发送时间
    @Column(name = "sendUserId")
    private String sendUserId;//发送人
    @Column(name = "secretId")
    private String secretId;//密级
    @Column(name = "receiveStatus")
    private String receiveStatus;//接收状态
}
