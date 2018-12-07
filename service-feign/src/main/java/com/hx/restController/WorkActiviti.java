package com.hx.restController;/*
 *//*
 *@作者:张立恒
 *@时间:2018/11/16 9:32
 *@功能:
 */

import com.hx.service.WorkActivitiService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/workActiviti")
public class WorkActiviti {
    @Autowired
    private WorkActivitiService workActivitiService;
    @RequestMapping(value = "/workExamine",method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(fallbackMethod ="hiError")
    public boolean workExamine(){
        return workActivitiService.workExamine();
    }

    public boolean hiError() {
        return false;
    }
}
