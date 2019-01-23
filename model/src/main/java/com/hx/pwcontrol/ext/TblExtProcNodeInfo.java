package com.hx.pwcontrol.ext;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 14:01
 *@功能:流程节点信息表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_ext_proc_node_info")
public class TblExtProcNodeInfo implements Serializable {
    private static final long serialVersionUID = 6188247140364882565L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "EventType")
    private String EventType;//响应事件类型
    @Column(name = "EventUrl")
    private String EventUrl;//事件处理url
    @Column(name = "IsComplete")
    private String IsComplete;//是否可以完成
    @Column(name = "IsEdit")
    private String IsEdit;//是否可以编辑
    @Column(name = "IsIgnore")
    private String IsIgnore;//是否可以忽略
    @Column(name = "IsResponseEvent")
    private String IsResponseEvent;//是否响应事件
    @Column(name = "IsSeal")
    private String IsSeal;//是否可以盖章
    @Column(name = "IsSign")
    private String IsSign;//是否可以会签
    @Column(name = "IsStop")
    private String IsStop;//是否可以终止
    @Column(name = "IsTransit")
    private String IsTransit;//是否可以中转
    @Column(name = "NodeCode")
    private String NodeCode;//节点编号
    @Column(name = "NodeIndex")
    private String NodeIndex;//节点序号
    @Column(name = "NodeName")
    private String NodeName;//节点名称
    @Column(name = "NodeRole")
    private String NodeRole;//参与角色
    @Column(name = "NodeType")
    private String NodeType;//节点类型
    @Column(name = "ProcCode")
    private String ProcCode;//流程编号
    @Column(name = "ProcDefId")
    private String ProcDefId;//流程定义id
    @Column(name = "ProcId")
    private String ProcId;//流程id
    @Column(name = "NodeFlag")
    private String NodeFlag;//节点标记
    @Column(name = "NodeLevel")
    private String NodeLevel;//节点级别
}
