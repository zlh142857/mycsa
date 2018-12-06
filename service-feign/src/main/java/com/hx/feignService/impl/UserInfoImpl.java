package com.hx.feignService.impl;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/19 15:10
 *@功能:
 */

import com.hx.dao.UserInfoRepository;
import com.hx.feignService.UserInfoService;
import com.hx.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Override
    public UserInfo findByUsername(String username) {
        try{
            return userInfoRepository.findByUsername(username);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfoRepository.save( userInfo );
    }
}
