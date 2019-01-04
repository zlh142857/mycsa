package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/10 9:26
 *@功能:默认访问页面,先查询用户是否登录,没有登录,返回false,有前端控制跳转至登录页面,如果有登陆,就跳转至首页
 */


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    /*@RequestMapping(value="/unauth")
    @ResponseBody
    public String login(String userinfo){
        if(userinfo ==null){
            return JSONObject.toJSONString( "获取用户信息失败" );
        }else{
            JSONObject json= (JSONObject) JSONObject.toJSON(AESUtils.dcodes( userinfo ));
            UsernamePasswordToken token = new UsernamePasswordToken(
                    json.get( "username" ).toString(),
                    json.get( "password" ).toString()
            );
            SecurityUtils.getSubject().login( token );
            //根据token从redis中获取用户的所有信息,然后返回给前端,用户已登录,进入index.html
            return JSONObject.toJSONString( "已登录" );
        }
    }*/
    @GetMapping(value="/unauth")
    @ResponseBody
    public String login(){
        return "ok";
    }

}
