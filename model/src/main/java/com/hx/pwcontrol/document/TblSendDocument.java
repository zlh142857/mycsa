package com.hx.pwcontrol.document;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 15:27
 *@功能:公文信息表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_send_document")
public class TblSendDocument implements Serializable{
    private static final long serialVersionUID = -8917380468008191555L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "QRCode")
    private String QRCode;//二维码路径
    @Column(name = "creator")
    private String creator;//创建人
    @Column(name = "draftDate")
    private String draftDate;//拟稿日期
    @Column(name = "fileTitle")
    private String fileTitle;//文件标题
    @Column(name = "keywords")
    private String keywords;//主题词
    @Column(name = "processInstanceId")
    private String processInstanceId;//流程实例id
    @Column(name = "reason")
    private String reason;//事由
    @Column(name = "remark")
    private String remark;//备注
    @Column(name = "sendNumber")
    private String sendNumber;//发文编号
    @Column(name = "shareNumber")
    private String shareNumber;//份数
    @Column(name = "telephone")
    private String telephone;//电话
    @Column(name = "writtenTime")
    private String writtenTime;//成文时间
    @Column(name = "drafter_id")
    private String drafter_id;//拟稿人
    @Column(name = "fileType_id")
    private String fileType_id;//文种
    @Column(name = "readScope_id")
    private String readScope_id;//阅文范围
    @Column(name = "retentPeriod_id")
    private String retentPeriod_id;//保管期限
    @Column(name = "secretRank_id")
    private String secretRank_id;//密级
    @Column(name = "sendDocRank_id")
    private String sendDocRank_id;//发文级别
    @Column(name = "sendDocState_id")
    private String sendDocState_id;//当前公文状态
    @Column(name = "sendDocType_id")
    private String sendDocType_id;//本文类型
    @Column(name = "urgentDegree_id")
    private String urgentDegree_id;//紧急程度
    @Column(name = "docRelationId")
    private String docRelationId;//文档关联id
}
