package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/10/9 10:13
 *@功能:
 */

import com.hx.service.RegisetService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/toRegiset")
public class RegisetController {
    @Autowired
    private RegisetService regisetService;
    @RequestMapping(value="/regisetUser",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod ="hiError")
    @ResponseBody
    public String regisetUser(){
        return regisetService.regisetUser();
    }
    public String hiError() {
        return "hi,sorry,error!";
    }
}
