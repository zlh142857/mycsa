package com.hx.dao;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/5 17:00
 *@功能:
 */

import com.hx.SysDictData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface CodeRepository extends CrudRepository<SysDictData, Integer> {
    @Query(value = "SELECT dict_label FROM sys_dict_data WHERE dict_id=:dictId AND dict_sort=:dictSort limit 1",nativeQuery = true)
    String findByDictIdAndDictSort(@Param( "dictId" ) Integer dictId, @Param( "dictSort" ) Integer dictSort);
}
