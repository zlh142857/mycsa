package com.hx.pwcontrol.mail;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 14:37
 *@功能:邮件接收表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_mail_receiver")
public class TblMailReceiver implements Serializable{
    private static final long serialVersionUID = 1594393408826513378L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "mailId")
    private String mailId;//邮件id
    @Column(name = "receiveStatus")
    private String receiveStatus;//接收状态
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "receiveTime")
    private Date receiveTime;//接收时间
    @Column(name = "receiveUserId")
    private String receiveUserId;//接收人id

}
