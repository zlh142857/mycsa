package com.hx.pwcontrol.apply;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 16:12
 *@功能:接入申请表
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_user_access_apply")
public class TblUserAccessApply implements Serializable{
    private static final long serialVersionUID = 3455622227706642238L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="CreateTime")
    private Date CreateTime; //创建时间
    @Column(name="applyTime")
    private String applyTime;//申请时间
    @Column(name="approveState")
    private String approveState;//审批状态
    @Column(name="createBy")
    private String createBy;//创建人
    @Column(name="updateBy")
    private String updateBy;//修改人
    @Column(name="updateTime")
    private String updateTime;//修改时间
    @Column(name="userDepartment")
    private String userDepartment;//所属部门
    @Column(name="userId")
    private String userId;//用户id
    @Column(name="userOrganization")
    private String userOrganization;//所属机构
}
