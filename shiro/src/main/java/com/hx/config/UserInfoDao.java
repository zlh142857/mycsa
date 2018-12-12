package com.hx.config;
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
public interface UserInfoDao extends CrudRepository<UserInfo, Integer> {
    UserInfo findByUsername(String username);
}
