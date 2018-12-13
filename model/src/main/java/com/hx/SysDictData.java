package com.hx;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 14:21
 *@功能:数据字典子字典
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor //生成全参构造方法
@NoArgsConstructor //生成无参构造方法
@Accessors(chain = true)
public class SysDictData implements Serializable {
    private static final long serialVersionUID = -4785213674837938478L;
    @Id
    @Column(name = "dict_code",unique=true)
    @GeneratedValue(strategy=GenerationType.AUTO)//主键生成策略,默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略,MySQL 对应 auto increment
    private Integer dictCode;//字典编码;
    @Column(name="dict_sort")
    private Integer dictSort; //字典排序
    @Column(name="dict_label")
    private String dictLabel; //字典标签 男女
    @Column(name="dict_id")
    private Integer dictId; //父字典类型编码
    @Temporal( TemporalType.TIMESTAMP )
    @Column(name="create_time")
    private Date createTime;
    @Column(name="remark")
    private String remark; //备注
}
