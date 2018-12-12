package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/9 10:13
 *@功能:
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.UserInfo;
import com.hx.config.md5.Md5;
import com.hx.config.md5.Salt;
import com.hx.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/toRegiset")
public class RegisetController {
    @Autowired
    private UserInfoService userInfoService;
    @GetMapping(value="/regisetUser")
    @ResponseBody
    public String regisetUser(){
        userInfoService.regisetUser();
        return JSONObject.toJSONString("注册成功");
    }
}
