package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 10:04
 *@功能:
 */

import com.hx.service.UseMenuService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/useMenu")
public class UseMenu {
    @Autowired
    private UseMenuService useMenuService;
    @RequestMapping(value = "/useRegisterList",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean useRegisterList(){
        return useMenuService.useRegisterList();
    }
    public String hiError() {
        return "hi,sorry,error!";
    }
}
