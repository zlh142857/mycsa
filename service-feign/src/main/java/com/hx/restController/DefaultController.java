package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/10 9:26
 *@功能:默认访问页面,先查询用户是否登录,没有登录,返回false,有前端控制跳转至登录页面,如果有登陆,就跳转至首页
 */

import com.hx.service.DefaulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    @Autowired
    private DefaulService defaulService;

    /*@RequestMapping(value="/unauth",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="error")
    public String login(String userinfo){
        return defaulService.login(userinfo);
    }
    public String error(String userinfo) {
        return JSONObject.toJSONString( "抱歉异常问题出现" );
    }
*/

}
