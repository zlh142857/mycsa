package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/9 10:13
 *@功能:
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/toRegiset")
public class RegisetController {
    /*@Autowired
    private UserInfoService userInfoService;
    @RequestMapping(value="/regisetUser")
    @ResponseBody
    public String regisetUser(){
        String username="囧囧";
        String password="123456";
        String salt=Salt.getSalt();
        String npassword=Md5.getPassword( username,password,salt );
        UserInfo userInfo=new UserInfo();
        userInfo.setName( "弓长张" );
        userInfo.setPassword( npassword );
        userInfo.setSalt( salt );
        userInfo.setUsername( username );
        userInfoService.save(userInfo);
        return JSONObject.toJSONString("注册成功");
    }*/
}
