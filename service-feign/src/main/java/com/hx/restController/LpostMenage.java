package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 9:48
 *@功能:
 */

import com.hx.service.LpostMenageService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/lpostMenage")
public class LpostMenage {
    @Autowired
    private LpostMenageService lpostMenageService;
    @RequestMapping(value = "/lpostList/{id}",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean lpostList(){
        return lpostMenageService.lpostList();
    }
    public String hiError() {
        return "hi,sorry,error!";
    }
}
