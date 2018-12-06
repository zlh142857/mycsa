package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:01
 *@功能:
 */

import com.hx.service.FirstInstallService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/firstInstall")
public class FirstInstall {
    @Autowired
    private FirstInstallService firstInstallService;
    @RequestMapping(value = "/installRegisterList/{id}",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean installRegisterList(){
        return firstInstallService.installRegisterList();
    }
    public String hiError() {
        return "hi,sorry,error!";
    }
}
