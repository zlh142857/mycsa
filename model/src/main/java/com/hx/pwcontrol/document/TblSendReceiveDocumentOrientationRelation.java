package com.hx.pwcontrol.document;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 15:36
 *@功能:
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_send_receive_document_orientation_relation")
public class TblSendReceiveDocumentOrientationRelation implements Serializable{
    private static final long serialVersionUID = 5454858867910522535L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "creator")
    private String creator;//创建人
    @Column(name = "objectType_id")
    private String objectType_id;//当前对象类型
    @Column(name = "receiveDocument_id")
    private String receiveDocument_id;//收文表id
    @Column(name = "sendDocument_id")
    private String sendDocument_id;//发文表id
    @Column(name = "systemOrganization_code")
    private String systemOrganization_code;//机构部门对象
    @Column(name = "systemUser_id")
    private String systemUser_id;//人员对象
}
