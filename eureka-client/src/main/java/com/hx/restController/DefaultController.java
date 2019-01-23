package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/10 9:26
 *@功能:默认访问页面,先查询用户是否登录,没有登录,返回false,有前端控制跳转至登录页面,如果有登陆,就跳转至首页
 */


import com.alibaba.fastjson.JSONObject;
import com.hx.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DefaultController {
    @Autowired
    private SysUserService sysUserService;
    /**
     *
     * 功能描述: 查询是否存在该用户
     *
     * 业务逻辑:
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2019/1/16 11:09
     */
    @GetMapping(value ="/default")
    @ResponseBody
    public boolean defaultMenu(@RequestParam("key")String key,@RequestParam("ip")String ip){
        return sysUserService.findByKey(key,ip);
    }
    /**
     *
     * 功能描述: 登录
     *
     * 业务逻辑:
     *
     * @param:
     * @return:
     * @auther: 张立恒
     * @date: 2019/1/16 11:40
     */
    @GetMapping(value ="/toLogin")
    @ResponseBody
    public String toLogin(@RequestParam("key")String key,@RequestParam("ip")String ip){
        Map<String,Object> msg=sysUserService.toLogin(key,ip);
        return JSONObject.toJSONString( msg );
    }

}
