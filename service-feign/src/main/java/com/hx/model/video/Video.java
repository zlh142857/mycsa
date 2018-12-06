package com.hx.model.video;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 14:02
 *@功能:警示教育视频信息表
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Video implements Serializable {
    private static final long serialVersionUID = 160140099540569329L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer video_id;//警示教育视频表id;
    private String video_name; //警示教育视频名称
    private Integer video_type; //视频重要程度0 一般,1重要,2很重要
    private String video_url; //视频存储地址
    private String remark; //视频描述
    private Date create_time;

}
