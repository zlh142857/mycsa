package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 9:37
 *@功能:
 */

import com.hx.service.LrealmMenageService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/lrealmMenage")
public class LrealmMenage {
    @Autowired
    private LrealmMenageService lrealmMenageService;
    @RequestMapping(value = "/lrealmList/{id}",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean lrealmList(){
        return lrealmMenageService.lrealmList();
    }

    public boolean hiError() {
        return false;
    }
}
