package com.hx.pwcontrol.mail;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 14:24
 *@功能:邮件信息表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_mail")
public class TblMail implements Serializable {
    private static final long serialVersionUID = 3321136373715156897L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "mailContent")
    private String mailContent;//邮件内容
    @Column(name = "mailStatus")
    private String mailStatus;//邮件状态
    @Column(name = "mailTitle")
    private String mailTitle;//邮件标题
    @Column(name = "sendUserId")
    private String sendUserId;//发送者
    @Column(name = "secretId")
    private String secretId;//邮件密级
}
