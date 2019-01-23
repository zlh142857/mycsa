package com.hx.pwcontrol.apply;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 16:47
 *@功能:证书信息表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_user_certificate_info")
public class TblUserCertificateInfo implements Serializable{
    private static final long serialVersionUID = -2544488662382486543L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "createBy")
    private String createBy;//创建人
    @Column(name = "endDate")
    private String endDate;//有效截止时间
    @Column(name = "sn")
    private String sn;//序列号sn
    @Column(name = "startDate")
    private String startDate;//有效开始时间
    @Column(name = "status")
    private String status;//状态
    @Column(name = "updateBy")
    private String updateBy;//修改人
    @Column(name = "updateTime")
    private String updateTime;//修改时间
    @Column(name = "userId")
    private String userId;//用户id
}
