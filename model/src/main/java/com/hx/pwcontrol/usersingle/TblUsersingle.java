package com.hx.pwcontrol.usersingle;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 16:50
 *@功能:用户签名表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_usersingle")
public class TblUsersingle implements Serializable{
    private static final long serialVersionUID = 6739523249717775165L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "Def")
    private String Def; //是否为默认签名
    @Column(name = "DocumentId")
    private String DocumentId; //文档id
    @Column(name = "UserId")
    private String UserId; //用户id
}
