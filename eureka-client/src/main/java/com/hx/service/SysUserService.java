package com.hx.service;/*
 */

import com.hx.Object.MuchObj;

import java.util.Map;

public interface SysUserService {
    boolean findByKey(String key, String ip); //根据key查询用户是否存在

    Map<String,Object> toLogin(String key, String ip);//登录

    Map<String,Object> inputUser(MuchObj muchObj, String ip);//人员录入
}
