package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 9:52
 *@功能:
 */

import com.hx.service.LjobMenageService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/ljobMenage")
public class LjobMenage {
    @Autowired
    private LjobMenageService ljobMenageService;
    @RequestMapping(value = "/ljobList",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean ljobList(){
        return ljobMenageService.ljobList();
    }
    public String hiError() {
        return "hi,sorry,error!";
    }
}
