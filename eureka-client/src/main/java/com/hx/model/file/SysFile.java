package com.hx.model.file;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 13:36
 *@功能:接收文件表
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class SysFile implements Serializable {
    private static final long serialVersionUID = -870581754728800386L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer id;//id;
    private String fileId; //文件编号
    private String fileName;  //文件名称
    private String filePath;  //文件存储路径
    private Integer isRead; //是否已读0未读  1已读
    private String sendUser; //发送人
    private Integer deptId; //发送部门id
    private Integer papersSecretLevel; //公文密级
    @Temporal( TemporalType.TIMESTAMP )
    private Date receiveTime; //接收文件时间
    @Temporal( TemporalType.TIMESTAMP )
    private Date updateTime;
    private Integer delFlag; //删除标识0正常  1删除
}
