package com.hx.service;/*
 */


import com.hx.UserInfo;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    UserInfo findByUsername(String username);

    void save(UserInfo userInfo);
}
