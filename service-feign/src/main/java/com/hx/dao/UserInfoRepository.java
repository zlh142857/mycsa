package com.hx.dao;
/*用户信息仓库
 */

import com.hx.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
    /**通过username查找用户信息;*/
    /*@Query(value="SELECT uid,name,username,password,salt,state FROM user_info WHERE username=:username",nativeQuery = true)
    UserInfo findByUsername(@Param("username") String username);*/
}
