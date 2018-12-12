package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/10 9:36
 *@功能:
 */

import com.alibaba.fastjson.JSONObject;
import com.hx.service.ToLoginService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/toLogin")
public class ToLogin {
    @Autowired
    private ToLoginService toLoginService;
    /**
     * 登录方法
     * @param
     * @return
     * String username,String password,boolean rememberMe
     *
     */
    @RequestMapping(value = "/ajaxLogin",method = RequestMethod.POST)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="loginError")
    public String ajaxLogin(@RequestParam("name")String name, @RequestParam("password")String password) {
        return toLoginService.ajaxLogin(name,password);
    }
    public String loginError(@RequestParam("name")String name, @RequestParam("password")String password) {
        return JSONObject.toJSONString( "服务未响应" );
    }

}
