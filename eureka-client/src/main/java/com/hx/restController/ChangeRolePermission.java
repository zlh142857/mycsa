package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:58
 *@功能:
 */

import com.hx.service.ChangeRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/changeRolePermission")
public class ChangeRolePermission {
    @Autowired
    private ChangeRolePermissionService changeRolePermissionService;
    @RequestMapping(value = "/changePermissionList",method = RequestMethod.GET)
    public boolean changePermissionList(){
        return true;
    }
}
