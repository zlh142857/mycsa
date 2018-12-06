package com.hx.model.video;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 14:06
 *@功能:
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
public class VideoTime implements Serializable {
    private static final long serialVersionUID = 460984042081010355L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer video_time_id;//id;
    private Integer videoId; //警示教育视频id
    private Integer userId; //用户id
    @Temporal( TemporalType.TIMESTAMP )
    private Date create_time; //创建时间
    private Time video_time; //记录视频最后观看时间
}
