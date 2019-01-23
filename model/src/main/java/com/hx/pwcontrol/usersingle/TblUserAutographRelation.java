package com.hx.pwcontrol.usersingle;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 16:53
 *@功能:发文中人员签名关系表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_user_autograph_relation")
public class TblUserAutographRelation implements Serializable{
    private static final long serialVersionUID = 8925569603498912935L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "ExamineDraftPic")
    private String ExamineDraftPic; //拟稿人签名
    @Column(name = "deptLeaderPic")
    private String deptLeaderPic; //部门领导签名
    @Column(name = "sendDocument_id")
    private String sendDocument_id; //发文单位id
    @Column(name = "yuanLeaderPic")
    private String yuanLeaderPic; //院领导签名
    @Column(name = "ExamineDraft_id")
    private String ExamineDraft_id; //核稿人
    @Column(name = "deptLeader_id")
    private String deptLeader_id; //部门领导
    @Column(name = "yuanLeader_id")
    private String yuanLeader_id; //院领导
}
