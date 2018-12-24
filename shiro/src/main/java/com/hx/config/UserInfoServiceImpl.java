package com.hx.config;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/11 17:10
 *@功能:
 */

import com.hx.shiro.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername( username );
    }
}
