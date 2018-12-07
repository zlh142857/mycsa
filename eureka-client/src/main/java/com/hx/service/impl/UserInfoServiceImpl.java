package com.hx.service.impl;/*
 *//*
 *@作者:张立恒
 *@时间:2018/9/30 11:08
 *@功能:
 */

import com.hx.UserInfo;
import com.hx.dao.UserInfoRepository;
import com.hx.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
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
