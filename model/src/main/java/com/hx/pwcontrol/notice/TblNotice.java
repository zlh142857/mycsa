package com.hx.pwcontrol.notice;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 15:01
 *@功能:公告表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_notice")
public class TblNotice implements Serializable{
    private static final long serialVersionUID = 265223677763585938L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="CreateTime")
    private Date CreateTime; //创建时间
    @Column(name="MainTitle")
    private String MainTitle;//主标题
    @Column(name="SubTitle")
    private String SubTitle;//副标题
    @Column(name="description")
    private String description;//描述
    @Column(name="publishUserId")
    private String publishUserId;//发布者
    @Column(name="publishTime")
    private String publishTime;//发布时间
    @Column(name="modifyUserId")
    private String modifyUserId;//修改者
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="modifyTime")
    private Date modifyTime;//修改时间
    @Temporal( TemporalType.DATE )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="startTime")
    private Date startTime;//开始时间
    @Temporal( TemporalType.DATE )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="endTime")
    private Date endTime;//结束时间
    @Column(name="overdue")
    private String overdue;//是否用不过期
    @Column(name="noticeStatus")
    private String noticeStatus;//公告状态
    @Column(name="accessNum")
    private String accessNum;//浏览次数
    @Column(name="accessRight")
    private String accessRight;//浏览权限
    @Column(name="noticeCategory")
    private String noticeCategory;//公告类型
    @Column(name="noticeOrg")
    private String noticeOrg;//公告所属机构
}
