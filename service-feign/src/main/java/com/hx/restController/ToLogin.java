package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/10 9:36
 *@功能:
 */

import com.hx.feignService.ToLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    /*@RequestMapping(value = "/ajaxLogin",method = RequestMethod.POST)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="loginError")
    public String ajaxLogin(@RequestParam("name")String name, @RequestParam("password")String password,@RequestParam(value = "rememberMe",required = false) boolean rememberMe) {
        try{
            *//*String data=request.getParameter( "data" );
            System.out.println(data);*//*
            return toLoginService.ajaxLogin(name,password,rememberMe);
        }catch (Throwable throwable){
            return throwable.toString();
        }
    }
    public String loginError(@RequestParam("name")String name, @RequestParam("password")String password,@RequestParam(value = "rememberMe",required = false) boolean rememberMe) {
        return JSONObject.toJSONString( "抱歉异常问题出现" );
    }*/

}
