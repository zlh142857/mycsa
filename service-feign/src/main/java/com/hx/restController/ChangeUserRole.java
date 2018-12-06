package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:59
 *@功能:
 */

import com.hx.service.ChangeUserRoleService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/changeUserRole")
public class ChangeUserRole {
    @Autowired
    private ChangeUserRoleService changeUserRoleService;
    @RequestMapping(value = "/changeRoleList/{id}",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean changeRoleList(){
        return changeUserRoleService.changeRoleList();
    }
    public String hiError() {
        return "hi,sorry,error!";
    }
}
