package com.hx.pwcontrol.document;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 15:41
 *@功能:催办表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_send_urgeinfo")
public class TblSendUrgeinfo implements Serializable{
    private static final long serialVersionUID = 7672495822605783979L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "acknowledgeTime")
    private String acknowledgeTime;//阅知催办信息时间
    @Column(name = "currentTaskId")
    private String currentTaskId;//当前节点
    @Column(name = "reason")
    private String reason;//催办事由
    @Column(name = "target")
    private String target;//催办目标
    @Column(name = "urgeStatus")
    private String urgeStatus;//阅知状态
    @Column(name = "urgeTime")
    private String urgeTime;//催办时间
    @Column(name = "assignee_id")
    private String assignee_id;//被催办人
    @Column(name = "urger_id")
    private String urger_id;//催办人
    @Column(name = "menuId")
    private String menuId;//菜单编号
    @Column(name = "parentId")
    private String parentId;//父菜单编号
    @Column(name = "procDefId")
    private String procDefId;//程序描述编号
    @Column(name = "processInstanceId")
    private String processInstanceId;//程序运行编号
    @Column(name = "sendDocumentId")
    private String sendDocumentId;//发送文件编号
    @Column(name = "taskDefKey")
    private String taskDefKey;//任务编号
}
