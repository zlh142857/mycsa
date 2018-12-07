package com.hx.feignService;/*
 */

import com.hx.UserInfo;

public interface UserInfoService {
    UserInfo findByUsername(String username);
    void save(UserInfo userInfo);
}
