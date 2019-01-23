package com.hx.pwcontrol.word;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 15:46
 *@功能:敏感词表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_sensitiveword")
public class TblSensitiveword implements Serializable{
    private static final long serialVersionUID = -9220054781533052546L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "SensitivewordContent")
    private String SensitivewordContent;//内容
    @Column(name = "SensitivewordCreator")
    private String SensitivewordCreator;//创建人
    @Column(name = "SensitivewordOrg")
    private String SensitivewordOrg;//创建机构
    @Column(name = "SensitivewordState")
    private String SensitivewordState;//状态
}
