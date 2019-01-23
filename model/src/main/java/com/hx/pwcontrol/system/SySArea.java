package com.hx.pwcontrol.system;/*
 *//*
 *@作者:张立恒
 *@时间:2019/1/14 9:23
 *@功能:地图使用表
 */

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="sys_area")
public class SySArea implements Serializable {
    private static final long serialVersionUID = 1267261147754584078L;
    @Id
    @Column(unique=true,name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer id;//id;
    @Column(name = "areaname")
    private String areaname; //栏目名
    @Column(name = "parentid")
    private Integer parentid;//父栏目
    @Column(name = "shortname")
    private String shortname;//短名称
    @Column(name = "areacode")
    private Integer areacode;//编码
    @Column(name = "zipcode")
    private Integer zipcode;//邮政编码
    @Column(name = "pinyin")
    private String pinyin;//拼音
    @Column(name = "lng")
    private String lng;//经度
    @Column(name = "lat")
    private String lat;//纬度
    @Column(name = "level")
    private Integer level;//等级
    @Column(name = "position")
    private String position;//位置
    @Column(name = "sort")
    private Integer sort;//排序
    @Temporal( TemporalType.TIMESTAMP )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CreateTime")
    private Date CreateTime;//创建时间
}
