package com.hx.personnel;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/26 9:45
 *@功能:人员亲属表
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class ClanInfo implements Serializable {
    private static final long serialVersionUID = 7569777269562215375L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer id;//id;
    private Integer perId;  //人员录入表id

    private String familyName;//亲属名称
    private String relation; //关系
    private String numberPhone; //手机号
}
