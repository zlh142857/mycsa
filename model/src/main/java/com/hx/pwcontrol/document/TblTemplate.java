package com.hx.pwcontrol.document;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 15:48
 *@功能:模板信息表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_template")
public class TblTemplate implements Serializable{
    private static final long serialVersionUID = 2384068728722955236L;
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
    private String Def;//是否为默认模板
    @Column(name = "DocumentId")
    private String DocumentId;//文档id
    @Column(name = "OrganizationCode")
    private String OrganizationCode;//所属机构
    @Column(name = "Templatetype")
    private String Templatetype;//模板类型
    @Column(name = "modifyTime")
    private String modifyTime;//修改时间
}
