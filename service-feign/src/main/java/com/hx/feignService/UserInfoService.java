package com.hx.feignService;/*
 */

import com.hx.model.UserInfo;

public interface UserInfoService {
    UserInfo findByUsername(String username);
    void save(UserInfo userInfo);
}
