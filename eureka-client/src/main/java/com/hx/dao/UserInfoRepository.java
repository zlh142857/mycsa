package com.hx.dao;
/*用户信息仓库
 */

import com.hx.shiro.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {
    @Query(value="SELECT uid FROM user_info WHERE dept_code=:deptCode AND personnel_name=:deptLeader",nativeQuery = true)
    Long findUserByDeptCodeAndDeptLeader(@Param( "deptCode" ) Integer deptCode,@Param( "deptLeader" ) String deptLeader);
    @Query(value="SELECT r.role as role FROM sys_user_role as ur,sys_role as r WHERE ur.role_id=r.id and ur.uid=:uid ",nativeQuery = true)
    String findRoleByUid(@Param( "uid" ) Integer uid);
    @Query(value="SELECT ur.uid as uid FROM sys_user_role as ur,sys_role as r WHERE ur.role_id=r.id and r.role like '%机要处领导%' ",nativeQuery = true)
    Integer findUidByRoleDept();
}
