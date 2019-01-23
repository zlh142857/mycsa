package com.hx.pwcontrol.uintportal;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 16:05
 *@功能:栏目表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_uint_portal_function")
public class TblUintPortalFunction implements Serializable{
    private static final long serialVersionUID = 1895026289295382940L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "FunctionName")
    private String FunctionName; //栏目名称
}
