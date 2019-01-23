package com.hx.pwcontrol.document;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 15:10
 *@功能:收文表单表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_receive_document")
public class TblReceiveDocument implements Serializable{
    private static final long serialVersionUID = -8846333478299458797L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "fileTitle")
    private String fileTitle;//文件标题
    @Column(name = "issueDate")
    private String issueDate;//签发时间
    @Column(name = "keywords")
    private String keywords;//主题词
    @Column(name = "processInstanceId")
    private String processInstanceId;//流程实例id
    @Column(name = "reason")
    private String reason;//事由
    @Column(name = "receiveSerialNumber")
    private String receiveSerialNumber;//登记流水号
    @Column(name = "receivedDate")
    private String receivedDate;//收文日期
    @Column(name = "remark")
    private String remark;//备注
    @Column(name = "urgeDate")
    private String urgeDate;//催办期限
    @Column(name = "fileType_id")
    private String fileType_id;//文种
    @Column(name = "processOrVisual_id")
    private String processOrVisual_id;//办阅件
    @Column(name = "receiveDocState_id")
    private String receiveDocState_id;//收文登记状态
    @Column(name = "receiveMode_id")
    private String receiveMode_id;//收文方式
    @Column(name = "registerUser_id")
    private String registerUser_id;//登记人
    @Column(name = "retentPeriod_id")
    private String retentPeriod_id;//保管期限
    @Column(name = "secretRank_id")
    private String secretRank_id;//密级
    @Column(name = "systemOrganization_Dept_code")
    private String systemOrganization_Dept_code;//收文对象（部门）
    @Column(name = "systemOrganization_Unit_code")
    private String systemOrganization_Unit_code;//收文对象（机构）
    @Column(name = "urgentDegree_id")
    private String urgentDegree_id;//紧急程度
    @Column(name = "docRelationId")
    private String docRelationId;//文档关联id
}
