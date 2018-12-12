package com.hx.service;/*
 */


import java.util.Map;

public interface UserInfoService {
    Map<String,Object> ajaxLogin(String name, String password);
    void regisetUser();
}
