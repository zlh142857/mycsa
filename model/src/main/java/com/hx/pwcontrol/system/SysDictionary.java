package com.hx.pwcontrol.system;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 9:40
 *@功能:系统字典表
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="sys_dictionary")
public class SysDictionary implements Serializable {
    private static final long serialVersionUID = 8553107079553769262L;
    @Id
    @Column(unique=true,name = "id",length = 32)
    @GeneratedValue(generator = "jpa-uuid")
    @GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;//id;
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime; //创建时间
    @Column(name = "DictCode")
    private String DictCode; //字典表代码
    @Column(name = "DictName")
    private String DictName; //字典表名称
    @Column(name = "DictOrder")
    private Integer DictOrder; //排序
    @Column(name = "DictParent")
    private String DictParent; //字典表父代码
    @Column(name = "DictDescription")
    private String DictDescription; //描述
}
