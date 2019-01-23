package com.hx.config;/*
 *//*
 *@作者:张立恒
 *@时间:2018/12/11 17:09
 *@功能:
 */


import com.hx.pwcontrol.system.SysUser;

public interface UserInfoService {
    SysUser findByUserKey(String UserKey);
}
