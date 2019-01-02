package com.hx.personnel;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/26 9:43
 *@功能:人员履历表
 */

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class PersonnelRecord implements Serializable {
    private static final long serialVersionUID = -8162043685999122807L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer id;//id;
    private Integer perId;  //人员录入表id

    private String learnUnits;//学习或工作单位
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal( TemporalType.DATE )
    private Date learnEndTime; //起止时间  结束时间
    private String reterence; //证明人
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal( TemporalType.DATE )
    private Date learnStartTime; //起止时间  开始时间

}
