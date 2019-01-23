package com.hx.dao;/*
 */

import com.hx.pwcontrol.system.SysUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface SysUserRepo extends CrudRepository<SysUser, String> {
    @Query(value="SELECT COUNT(id) FROM sys_user WHERE UserKey=:UserKey",nativeQuery = true)
    int findCountByUserKey(@Param( "UserKey" ) String UserKey);
}
