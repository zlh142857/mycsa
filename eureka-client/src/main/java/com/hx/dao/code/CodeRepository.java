package com.hx.dao.code;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 17:00
 *@功能:
 */

import com.hx.dict.SysDictData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CodeRepository extends JpaRepository<SysDictData, Integer> {
    @Query(value = "SELECT dict_label FROM sys_dict_data WHERE dict_id=:dictId AND dict_sort=:dictSort limit 1",nativeQuery = true)
    String findByDictIdAndDictSort(@Param( "dictId" ) Integer dictId, @Param( "dictSort" ) Integer dictSort);
    @Query(value = "SELECT * FROM sys_dict_data WHERE dict_id=:code",nativeQuery = true)
    List<SysDictData> findDictSortAndDictLabelByDictId(@Param( "code" ) Integer code);
    //测试使用,使用原生sql查询某个字段,测试成功,但是需要转换,如果查询字段太少就用这种方式,否则查询*
    @Query(value = "SELECT dict_label,dict_sort FROM sys_dict_data WHERE dict_id=:code",nativeQuery = true)
    List<Object[]> findCodeByDict(@Param( "code" ) Integer code);
}
