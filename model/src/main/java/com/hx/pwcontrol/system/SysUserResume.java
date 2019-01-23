package com.hx.pwcontrol.system;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 10:31
 *@功能:工作履历表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="sys_user_resume")
public class SysUserResume implements Serializable {
    private static final long serialVersionUID = -6998012867240038863L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Column(name = "UserId")
    private String UserId;//用户id
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "Creator")
    private String Creator;//创建人
    @Column(name = "DepartName")
    private String DepartName;//部门名称
    @Temporal( TemporalType.DATE )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "EndDate")
    private Date EndDate;//工作截止时间
    @Column(name = "Position")
    private String Position;//职务
    @Column(name = "Punishment")
    private String Punishment;//惩罚情况
    @Column(name = "Reward")
    private String Reward;//奖励情况
    @Temporal( TemporalType.DATE )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "StartDate")
    private Date StartDate;//工作开始时间
    @Column(name = "UnitName")
    private String UnitName;//单位名称
    @Column(name = "updateBy")
    private String updateBy;//修改人
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updateTime")
    private Date updateTime;//修改时间
    @Column(name = "endFlg")
    private String endFlg;//标识位
}
