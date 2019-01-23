package com.hx.pwcontrol.secretmeeting;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 15:23
 *@功能:涉密会议表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_secretmeeting")
public class TblSecretmeeting implements Serializable{
    private static final long serialVersionUID = 8035578372687066525L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "MeetingTheme")
    private String MeetingTheme;//会议主题
    @Column(name = "SubscribeDeptId")
    private String SubscribeDeptId;//预约部门
    @Column(name = "SubscribeEndTime")
    private String SubscribeEndTime;//会议结束时间
    @Column(name = "SubscribeMeetingRoomId")
    private String SubscribeMeetingRoomId;//会议室名称
    @Column(name = "SubscribeStartTime")
    private String SubscribeStartTime;//会议开始时间
    @Column(name = "SubscribeUnitId")
    private String SubscribeUnitId;//所属机构
    @Column(name = "SubscribeUserId")
    private String SubscribeUserId;//预约人
    @Column(name = "SubscribeUserNumber")
    private String SubscribeUserNumber;//参加会议的人数
    @Column(name = "PrepareState")
    private String PrepareState;//会议准备状态
    @Column(name = "Isvalid")
    private String Isvalid;//会议是否有效

}
