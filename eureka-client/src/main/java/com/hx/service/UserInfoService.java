package com.hx.service;/*
 */

import com.hx.UserInfo;

public interface UserInfoService {
    UserInfo findByUsername(String username);
    void save(UserInfo userInfo);
}
