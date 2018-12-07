package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:53
 *@功能:
 */

import com.hx.service.ChangeRolePermissionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/changeRolePermission")
public class ChangeRolePermission {
    @Autowired
    private ChangeRolePermissionService changeRolePermissionService;
    @RequestMapping(value = "/changePermissionList",method = RequestMethod.GET)
    @ResponseBody
    //@RequiresPermissions("changeRolePermission:view")
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean changePermissionList(){
        return changeRolePermissionService.changePermissionList();
    }
    public String hiError() {
        return "hi,sorry,error!";
    }
}
