package com.hx.dao;
/*用户信息仓库
 */

import com.hx.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
    @Query(value="SELECT uid FROM user_info WHERE dept_code=:deptCode AND personnel_name=:deptLeader",nativeQuery = true)
    Long findUserByDeptCodeAndDeptLeader(@Param( "deptCode" ) Integer deptCode,@Param( "deptLeader" ) String deptLeader);
    /**通过username查找用户信息;*/
    /*@Query(value="SELECT uid,name,username,password,salt,state FROM user_info WHERE username=:username",nativeQuery = true)
    UserInfo findByUsername(@Param("username") String username);*/
}
