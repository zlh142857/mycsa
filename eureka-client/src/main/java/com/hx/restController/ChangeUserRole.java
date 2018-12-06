package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 11:01
 *@功能:
 */

import com.hx.service.ChangeUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/changeUserRole")
public class ChangeUserRole {
    @Autowired
    private ChangeUserRoleService changeUserRoleService;
    @RequestMapping(value = "/changeRoleList",method = RequestMethod.GET)
    public boolean changeRoleList(){
        return true;
    }
}
