package com.hx.pwcontrol.notice;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 15:08
 *@功能:公告类型表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_notice_category")
public class TblNoticeCategory implements Serializable{
    private static final long serialVersionUID = -8909624162798196800L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "categoryName")
    private String categoryName;//公告类型名称
    @Column(name = "categoryOrg")
    private String categoryOrg;//所属机构
    @Column(name = "userId")
    private String userId;//创建人
}
