package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/10 9:36
 *@功能:
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value="/toLogin")
public class ToLogin {
    @Autowired
    private UserInfoService userInfoService;
    /**
     * 登录方法
     * @param
     * @return
     * String username,String password,boolean rememberMe
     *
    /* */
    @PostMapping(value = "/ajaxLogin")
    @ResponseBody
    public String ajaxLogin(String name,String password) {
        Map<String,Object> msg=userInfoService.ajaxLogin(name,password);
        return JSONObject.toJSONString( msg );
    }
}
