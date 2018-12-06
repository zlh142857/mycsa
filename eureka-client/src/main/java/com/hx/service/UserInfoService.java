package com.hx.service;/*
 */

import com.hx.model.UserInfo;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    UserInfo findByUsername(String username);

    void save(UserInfo userInfo);
}
