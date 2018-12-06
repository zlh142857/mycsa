package com.hx.model.exam;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 13:57
 *@功能:考试选择题表
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class ExamChoose implements Serializable {
    private static final long serialVersionUID = 5767980566765986428L;
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer examId;//id;
    private String examQuestion; //选择题题目
    private String answera; //a选项内容
    private String answerb;//a选项内容
    private String answerc;//a选项内容
    private Integer answer; //正确答案
    private Date createTime;
    private Date updateTime;

}
