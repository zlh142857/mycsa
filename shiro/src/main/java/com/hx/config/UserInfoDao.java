package com.hx.config;
/*用户信息仓库
 */

import com.hx.shiro.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserInfoDao extends CrudRepository<UserInfo, Integer> {
    UserInfo findByUsername(String username);
}
