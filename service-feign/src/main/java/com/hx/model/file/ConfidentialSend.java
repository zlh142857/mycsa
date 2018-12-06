package com.hx.model.file;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 13:44
 *@功能:文件发送表
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class ConfidentialSend implements Serializable {
    private static final long serialVersionUID = 2453221426775212408L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer id;//id;
    private Integer sendUserId;//发送人id;
    private String fileId; //发送文件编号
    private Integer receiverId; //接收人id
    private String corbanCopyId; //抄送人编号字符串
    private String msgTitle; //文件标题
    private String msgContent; //文件内容
    private String papersType; //公文类型
    private Integer papersLevel;  //公文等级0特急 1紧急 2普通
    private Integer deptId; //发送部门id
    private Integer papersSecretLevel; //公文密级0绝密 1机密 2秘密
    private String confidential; //定密人
    private String createUser; //发送人
    private Date createTime; //创建时间
    private Integer delFlag; //删除标识0正常  1删除

}
