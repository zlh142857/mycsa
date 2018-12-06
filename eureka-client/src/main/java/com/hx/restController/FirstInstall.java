package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:03
 *@功能:
 */

import com.hx.service.FirstInstallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/firstInstall")
public class FirstInstall {
    @Autowired
    private FirstInstallService firstInstallService;
    @RequestMapping(value = "/installRegisterList",method = RequestMethod.GET)
    public boolean installRegisterList(){
        return true;
    }
}
