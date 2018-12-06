package com.hx.model.exam;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 13:55
 *@功能:考试成绩信息表
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class ExamInfo implements Serializable {
    private static final long serialVersionUID = 5419226920160672773L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer id;//id;
    private Integer userId; //用户id
    private Integer score;  //用户成绩成绩
    private Date createTime; //创建时间
}
