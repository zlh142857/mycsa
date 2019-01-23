package com.hx.pwcontrol.word;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 14:17
 *@功能:关键词表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_keyword")
public class TblKeyword implements Serializable {
    private static final long serialVersionUID = 171775928004027085L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "KeywordApplyRange")
    private String KeywordApplyRange;//适用范围
    @Column(name = "KeywordContent")
    private String KeywordContent;//关键词内容
    @Column(name = "KeywordStatus")
    private String KeywordStatus;//关键词状态
    @Column(name = "Creator")
    private String Creator;//创建人
    @Column(name = "OrganizationCode")
    private String OrganizationCode;//所属机构
    @Column(name = "SecretLevel")
    private String SecretLevel;//密级
}
